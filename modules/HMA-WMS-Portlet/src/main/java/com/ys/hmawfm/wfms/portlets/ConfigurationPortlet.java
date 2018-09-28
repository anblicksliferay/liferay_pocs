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

import javax.portlet.Portlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.portlets.constants.WorkflowConfigurationPortletKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Config;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;
import com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode;
import com.ys.hmawfm.wfms.services.model.WFMS_action_names;
import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_NA_SupportImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_action_namesImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_routing_and_approversImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_WorkflowConfigLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.utils.GenerateFrindlyURL;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.utils.HondaPermissionKeys;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=HMA-WMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/configuration/list.jsp",
		"javax.portlet.name=" + WorkflowConfigurationPortletKeys.Configuration,
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.display-name=WMS-Configuration"
    },
    service = Portlet.class
)
public class ConfigurationPortlet extends MVCPortlet {

	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {

		try {
			List<WFMS_Config> wfms_ConfigList = WFMS_ConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_ConfigList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/html/configuration/list.jsp");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		boolean loggedIn = themeDisplay.isSignedIn();
		if (!loggedIn){
			prd = getPortletContext().getRequestDispatcher("/html/signin.jsp");
		}
		
		prd.include(request, response);
	}
	
	public void gridworkflowConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		//long configId = Long.parseLong(request.getParameter("configId"));
		//_log.info("In manage config portlet---- manageConfiguration for " + configId);
		try {
		List<WFMS_WorkflowConfig> wfms_ConfigList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
		if(wfms_ConfigList != null){
		request.setAttribute("wfms_workflow_list", wfms_ConfigList);
		}
		}
		catch(SystemException e){
			
		}
		response.setRenderParameter("jspPage", "/html/configuration/workflow_list.jsp");
	}
	
	public void newworkflowConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/workflow_manage.jsp");
	}
	public void manageworkflowConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		long configId = Long.parseLong(request.getParameter("configId"));
		//_log.info("In manage config portlet---- manageConfiguration for " + configId);
		WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.getByConfigId(configId);
		if (wfms_config != null) {
			request.setAttribute("wfms_workflow_config", wfms_config);
		}
		response.setRenderParameter("jspPage", "/html/configuration/workflow_manage.jsp");
	}
	public void deleteworkflowConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		long configId = Long.parseLong(request.getParameter("configId"));
		
		WFMS_WorkflowConfigLocalServiceUtil.deleteConfig(configId);
		
		try {
			List<WFMS_WorkflowConfig> wfms_ConfigList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
			request.setAttribute("wfms_workflow_list", wfms_ConfigList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/configuration/workflow_list.jsp");
	}
	public void createworkflowConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		//_log.info("In config portlet----createNotification");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUserById(userId);
			String screenName = user.getScreenName();
			String configKey = request.getParameter("configKey");
			String configLabel = request.getParameter("configLabel");
			String contentType = request.getParameter("contentType");
			String content = request.getParameter("content");
			WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.addNewConfig(screenName, configKey, configLabel,
					contentType, content);
			List<WFMS_WorkflowConfig> wfms_configList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
			request.setAttribute("wfms_workflow_list", wfms_configList);
			response.setRenderParameter("jspPage", "/html/configuration/workflow_list.jsp");
		} catch (Exception ex) {
			_log.error("WorkflowConfigurationPortlet.createConfiguration(): "+ex);
		}
	}
	public void saveworkflowConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		//_log.info("In config portlet----saveNotification");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUserById(userId);
			String screenName = user.getScreenName();
			long configId = Long.parseLong(request.getParameter("configId"));
			String configKey = request.getParameter("configKey");
			String configLabel = request.getParameter("configLabel");
			String contentType = request.getParameter("contentType");
			String content = request.getParameter("content");
			WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.updateConfig(configId, screenName, configKey, configLabel,
					contentType, content);
			List<WFMS_WorkflowConfig> wfms_configList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
			request.setAttribute("wfms_workflow_list", wfms_configList);
			response.setRenderParameter("jspPage", "/html/configuration/workflow_list.jsp");
		} catch (Exception ex) {
			_log.error("WorkflowConfigurationPortlet.saveConfiguration(): "+ex);
		}
	}
public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException,PortletException{
		
		String cmd = ParamUtil.getString(request, "cmd");
		String cmdType = ParamUtil.getString(request, "cmdType");
		String action = ParamUtil.getString(request, "action");
		 PrintWriter writer = response.getWriter();
		 JSONObject json = JSONFactoryUtil.createJSONObject();
		if(cmd.equalsIgnoreCase("ActionNames")){
			try{
				//_log.info("ActionNames>>>>"+cmd.equalsIgnoreCase("ActionNames"));
				String actionId = ParamUtil.getString(request, "actionId");
				//_log.info("actionId>>>>"+actionId);
				 DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
				 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionName").eq(action));
				 dynamicQueryForAction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
				 if(actionId!="")
					 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionId").ne(actionId));
				 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
			 	 String val="";
	               if(actionListof.size()>0) 
	            	   json.put("success", "true"); 
                   else 
                	   json.put("success","false");
			        writer.println( json.toString() );
			}
			catch(Exception e){
				_log.error("createActionandreason"+e);
			}
		}
		else if(cmd.equalsIgnoreCase("ActionAndReasonCode")){
				try{
					
					String actionId = ParamUtil.getString(request, "actionId");
					String reason_code = ParamUtil.getString(request, "reason_code").trim();
					String actionAndReasonCodeId= ParamUtil.getString(request, "actionAndReasonCodeId");
					_log.info("actionId>>>>"+actionId);
					_log.info("reason_code>>>>"+reason_code);
					_log.info("actionAndReasonCodeId>>>>"+actionAndReasonCodeId);
					 DynamicQuery dynamicQueryForAction = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery();
					 dynamicQueryForAction.add(PropertyFactoryUtil.forName("action").eq(actionId));
					 dynamicQueryForAction.add(PropertyFactoryUtil.forName("reasonCode").eq(reason_code));
					 dynamicQueryForAction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
					 if(actionAndReasonCodeId!="")
						 dynamicQueryForAction.add(PropertyFactoryUtil.forName("aarId").ne(actionAndReasonCodeId));
					 List<WFMS_action_and_reasoncode> actionListof=WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
				 	 String val="";
		               if(actionListof.size()>0) 
		            	   json.put("success", "true"); 
	                   else 
	                	   json.put("success","false");
				        writer.println( json.toString());
				}
				catch(Exception e){
					_log.error("createActionandreason"+e);
				}
		}
		else if(cmd.equalsIgnoreCase("LoadDivisionNames")){
			getDivisionNameDeptName(request, response);
			
		}
		else if(cmd.equalsIgnoreCase("validateAssoicateNo")){
			try {
				validateAssoicateNo(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void validateAssoicateNo(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			   throws IOException, WindowStateException, PortletModeException, SQLException {
			  String assId = resourceRequest.getParameter("assId");
			  PrintWriter writer = resourceResponse.getWriter();
			  boolean isExist=false;
			  JSONObject json = JSONFactoryUtil.createJSONObject();
			  isExist=HMAAssociateInfoService.checkAssociateNumberExist(assId);
			  if(isExist) 
			  json.put("success", "true"); 
			  else 
			  json.put("success","false");
			  writer.print(json);
			  
	}
	
	private static void getDivisionNameDeptName(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			   throws IOException, WindowStateException, PortletModeException {
			  String DeptNo = resourceRequest.getParameter("Deptid");
			 
			  JSONObject json = JSONFactoryUtil.createJSONObject();
			  HondaLogicUtil hondaLogicUtil = new HondaLogicUtil();
			  Map<String,String> deptDivInfoMap = new HashMap<String,String>();
			  
			  try{ deptDivInfoMap=hondaLogicUtil.singleCallOnServieNow(DeptNo);		
				    json.put("DEPT_NAME", deptDivInfoMap.get("deptName") );
				    PrintWriter writer = resourceResponse.getWriter();
				    writer.print(json);
			  } catch (Exception e) {
			   e.printStackTrace();
			  }finally{
			   
			  }
			 }
	
	public void newConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/manage.jsp");
	}

	public void manageConfiguration(ActionRequest request, ActionResponse response) throws Exception {

		long configId = Long.parseLong(request.getParameter("configId"));
		System.out.println("In manage config portlet---- manageConfiguration for " + configId);

		WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigId(configId);

		if (wfms_config != null) {
			request.setAttribute("wfms_config", wfms_config);
		}

		response.setRenderParameter("jspPage", "/html/configuration/manage.jsp");
	}

	public void deleteConfiguration(ActionRequest request, ActionResponse response) throws Exception {

		long configId = Long.parseLong(request.getParameter("configId"));
		
		WFMS_ConfigLocalServiceUtil.deleteConfig(configId);
		
		try {
			List<WFMS_Config> wfms_ConfigList = WFMS_ConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_ConfigList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setRenderParameter("jspPage", "/html/configuration/list.jsp");

	}

	
	public void createConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		//System.out.println("In config portlet----createNotification");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUserById(userId);
			String screenName = user.getScreenName();

			String configKey = request.getParameter("configKey");
			String configLabel = request.getParameter("configLabel");
			String contentType = request.getParameter("contentType");
			String content = request.getParameter("content");

			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.addNewConfig(screenName, configKey, configLabel,
					contentType, content);

			List<WFMS_Config> wfms_configList = WFMS_ConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_configList);
			response.setRenderParameter("jspPage", "/html/configuration/list.jsp");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void saveConfiguration(ActionRequest request, ActionResponse response) throws Exception {
	///	System.out.println("In config portlet----saveNotification");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUserById(userId);
			String screenName = user.getScreenName();

			long configId = Long.parseLong(request.getParameter("configId"));
			String configKey = request.getParameter("configKey");
			String configLabel = request.getParameter("configLabel");
			String contentType = request.getParameter("contentType");
			String content = request.getParameter("content");

			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.updateConfig(configId, screenName, configKey, configLabel,
					contentType, content);

			List<WFMS_Config> wfms_configList = WFMS_ConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_configList);
			response.setRenderParameter("jspPage", "/html/configuration/list.jsp");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void importView(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/import.jsp");
	}
	public void routingapproversView(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/routingapproversView.jsp");
	}
	
	public void naSupportView(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
	}
	
	public void nasupportImport(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/nasupportImport.jsp");
	}
	
	public void actionandreasoncodeView(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncodeView.jsp");
	}
	
public void createNewaction(ActionRequest request, ActionResponse response) throws Exception {
		
		//_log.info("actionValue--->"+request.getParameter("actionValue"));	
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		int flag = 0;
		User user = UserLocalServiceUtil.getUserById(userId);
		WFMS_action_names wfms_action_names = null;
		try{
			if(request.getParameter("actionId").equals("")){
				
			    wfms_action_names = new WFMS_action_namesImpl();
			    long and_approvers = CounterLocalServiceUtil.increment(WFMS_action_names.class.getName()); 
			    wfms_action_names.setActionId(Long.toString(and_approvers));
				wfms_action_names.setCreateDate(new Date());
				wfms_action_names.setCreatedBy(user.getFullName());
				wfms_action_names.setDeleteflag(flag);
				wfms_action_names.setActionName(request.getParameter("actionValue").trim());
				WFMS_action_namesLocalServiceUtil.addWFMS_action_names(wfms_action_names);
			}
			else{
				wfms_action_names=WFMS_action_namesLocalServiceUtil.getWFMS_action_names(request.getParameter("actionId"));
				String existingAction=wfms_action_names.getActionName();
				wfms_action_names.setModifiedDate(new Date());
				String newActionName=request.getParameter("actionValue").trim();
				wfms_action_names.setModifiedBy(user.getFullName());
			    wfms_action_names.setActionName(newActionName);
			    WFMS_action_namesLocalServiceUtil.updateWFMS_action_names(wfms_action_names);
			    if(!newActionName.equalsIgnoreCase(existingAction)){
					DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
					dynamicQueryForCos.add(PropertyFactoryUtil.forName("action").eq(existingAction));
					//dynamicQueryForCos.add(PropertyFactoryUtil.forName("status").eq(HondaPermissionKeys.COS_DRAFT));
					
					Criterion reqcriterion = null;
					reqcriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DRAFT);
					reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,
							RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DISAPPROVED));
					dynamicQueryForCos.add(reqcriterion);
					
					
					List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
					if(cosList.size()>0){
						for(WFMS_COS cosdata:cosList){
						/*	_log.info("cos status and ids are:>>>"+cosdata.getStatus()+"  >>> "+cosdata.getCosId());
							_log.info("exist action name is:>>>"+existingAction);
							_log.info("new action name is:>>>"+newActionName);*/
							cosdata.setAction(newActionName);
							WFMS_COSLocalServiceUtil.updateWFMS_COS(cosdata);
							
						}
					}
				} 
			}
		}
		catch(Exception e){
			_log.error("createActionandreason"+e);
		}
		//_log.info("enter to createNewaction");
		response.setRenderParameter("jspPage", "/html/configuration/actionView.jsp");
	}

	public void actionView(ActionRequest request, ActionResponse response) throws Exception {
		//_log.info("enter to actionView");
		response.setRenderParameter("jspPage", "/html/configuration/actionView.jsp");
	}
	
	public void actionCreate(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/configuration/action_create.jsp");
	}
	
	public void actionEdit(ActionRequest request, ActionResponse response) throws Exception {		
		request.setAttribute("actionId", request.getParameter("actionId"));
		response.setRenderParameter("jspPage", "/html/configuration/action_create.jsp");
	}
	
    public void deleteAction(ActionRequest request, ActionResponse response) throws Exception {
		
		int flag= 1;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		WFMS_action_names wfms_action_names=null;
		String actionId = ParamUtil.getString(request, "actionId");
		try{
			if(Validator.isNotNull(actionId)){
				wfms_action_names=WFMS_action_namesLocalServiceUtil.fetchWFMS_action_names(actionId);
				wfms_action_names.setDeleteflag(flag);
				WFMS_action_namesLocalServiceUtil.updateWFMS_action_names(wfms_action_names);
				
		    	 DynamicQuery dynamicQueryForAction = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery();
				 dynamicQueryForAction.add(PropertyFactoryUtil.forName("action").eq(actionId));
				 List<WFMS_action_and_reasoncode> wfms_action_and_reasoncodes=WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery(dynamicQueryForAction); 
				for(WFMS_action_and_reasoncode resoncodeList:wfms_action_and_reasoncodes){
					
					    WFMS_action_and_reasoncode wfms_action_and_reasoncode=WFMS_action_and_reasoncodeLocalServiceUtil.findByreasoncode(resoncodeList.getAarId());
					    wfms_action_names.setModifiedDate(new Date());
						wfms_action_names.setModifiedBy(user.getFullName());
					    wfms_action_and_reasoncode.setDeleteflag(flag);
						WFMS_action_and_reasoncodeLocalServiceUtil.updateWFMS_action_and_reasoncode(wfms_action_and_reasoncode);
				}
				 DynamicQuery dynamicQueryForAction1 = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery();
				 dynamicQueryForAction1.add(PropertyFactoryUtil.forName("action").eq(actionId));
				 List<WFMS_routing_and_approvers> wfms_routing_and_approvers=WFMS_routing_and_approversLocalServiceUtil.dynamicQuery(dynamicQueryForAction1); 
                 for(WFMS_routing_and_approvers resoncodeList:wfms_routing_and_approvers){
					WFMS_routing_and_approvers wfms_routing_and_approvers1=WFMS_routing_and_approversLocalServiceUtil.findByrouting(resoncodeList.getRapId());
					wfms_routing_and_approvers1.setDeleteflag(flag);
					WFMS_routing_and_approversLocalServiceUtil.updateWFMS_routing_and_approvers(wfms_routing_and_approvers1);
				}
				
				
			}
		}
		catch(SystemException e){
			_log.info("deleteActionandReasoncode"+e);
		}
		response.setRenderParameter("jspPage", "/html/configuration/actionView.jsp");
	}
    
	public void routingAndApproversInformation(ActionRequest request, ActionResponse response) throws Exception {
		
	//	System.out.println(request.getParameter("approverId"));
		request.setAttribute("Approverid", request.getParameter("approverId"));
		response.setRenderParameter("jspPage", "/html/configuration/routingapprovers_Edit.jsp");
	}
	
	
	public void naSupportInformation(ActionRequest request, ActionResponse response) throws Exception {
		
			request.setAttribute("Approverid", request.getParameter("approverId"));
			response.setRenderParameter("jspPage", "/html/configuration/nasupport_Edit.jsp");
		}
	
	
	public void actionandreasonInformation(ActionRequest request, ActionResponse response) throws Exception {
		
		//	System.out.println(request.getParameter("approverId"));
			request.setAttribute("Approverid", request.getParameter("approverId"));
			response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncode_Edit.jsp");
		}
public void createrouting(ActionRequest request, ActionResponse response) throws Exception {
		
		response.setRenderParameter("jspPage", "/html/configuration/routingapprovers_create.jsp");
	}
public void redirctcreaterouting(ActionRequest request, ActionResponse response) throws Exception {	
	response.setRenderParameter("jspPage", "/html/configuration/routingapprovers_create.jsp");
}

public void createnaSupport(ActionRequest request, ActionResponse response) throws Exception {
	
	response.setRenderParameter("jspPage", "/html/configuration/naSupport_create.jsp");
}
public void redirctcreatenaSupport(ActionRequest request, ActionResponse response) throws Exception {	
response.setRenderParameter("jspPage", "/html/configuration/naSupport_create.jsp");

}


/*public void createaction(ActionRequest request, ActionResponse response) throws Exception {
	response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncode_create.jsp");
}*/
public void redirctcreateaction(ActionRequest request, ActionResponse response) throws Exception {	
response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncode_create.jsp");

}
	
public void deleteRoutingAndApprover(ActionRequest request, ActionResponse response) throws Exception {
	
	int flag= 1;
	WFMS_routing_and_approvers wfms_routing_and_approvers=null;
	String rapId = ParamUtil.getString(request, "rapId");
	try{
		if(Validator.isNotNull(rapId)){
			wfms_routing_and_approvers=WFMS_routing_and_approversLocalServiceUtil.findByrouting(rapId);
			wfms_routing_and_approvers.setDeleteflag(flag);
			WFMS_routing_and_approversLocalServiceUtil.updateWFMS_routing_and_approvers(wfms_routing_and_approvers);
		}
	}
	catch(SystemException e){
		_log.info("deleteRoutingAndApprover"+e);
	}
	response.setRenderParameter("jspPage", "/html/configuration/routingapproversView.jsp");
	}
	
	public void deleteActionandReasoncode(ActionRequest request, ActionResponse response) throws Exception {
		
		int flag= 1;
		WFMS_action_and_reasoncode wfms_action_and_reasoncode=null;
		String aarId = ParamUtil.getString(request, "aarId");
		try{
			if(Validator.isNotNull(aarId)){
				wfms_action_and_reasoncode=WFMS_action_and_reasoncodeLocalServiceUtil.findByreasoncode(aarId);
				wfms_action_and_reasoncode.setDeleteflag(flag);
				WFMS_action_and_reasoncodeLocalServiceUtil.updateWFMS_action_and_reasoncode(wfms_action_and_reasoncode);
			}
		}
		catch(SystemException e){
			_log.info("deleteActionandReasoncode"+e);
		}
		response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncodeView.jsp");
	}	
	public void deleteNASupport(ActionRequest request, ActionResponse response) throws Exception {
		
		int flag= 1;
		WFMS_NA_Support wfms_na_support=null;
		String associateNumber = ParamUtil.getString(request, "ASSOCIATE_NUMBER");
		try{
			if(Validator.isNotNull(associateNumber)){
				wfms_na_support=WFMS_NA_SupportLocalServiceUtil.findBynaSupport(associateNumber);
				wfms_na_support.setDeleteflag(flag);
				WFMS_NA_SupportLocalServiceUtil.updateWFMS_NA_Support(wfms_na_support);
			}
		}
		catch(SystemException e){
			_log.info("deleteNASupport"+e);
		}
		response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
	}

	public void updaterouting(ActionRequest request, ActionResponse response) throws Exception {
		if(request.getParameter("actiontype").equalsIgnoreCase("renderView")){
			 response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
		}
		else if(request.getParameter("actiontype").equalsIgnoreCase("submit")){	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = themeDisplay.getUserId();
	int flag=0;
	User user = UserLocalServiceUtil.getUserById(userId);
	String rapId = ParamUtil.getString(request, "rapId");
	
		WFMS_routing_and_approvers wfms_routing_and_approvers=null;
		
		try{
		wfms_routing_and_approvers = WFMS_routing_and_approversLocalServiceUtil.findByrouting(rapId);
		String existingDescription=wfms_routing_and_approvers.getChangeDescription();
		wfms_routing_and_approvers.setModifiedDate(new Date());
		wfms_routing_and_approvers.setModifiedBy(user.getFullName());
		wfms_routing_and_approvers.setAction(request.getParameter("action"));	
		String action=request.getParameter("action");
		String newDdescription=request.getParameter("changeDescription").trim();
		wfms_routing_and_approvers.setChangeDescription(newDdescription);
		wfms_routing_and_approvers.setCurrentJobCodeORLeadership(request.getParameter("currentJobCodeORLeadership"));
		wfms_routing_and_approvers.setNewJobCodeORLeadership(request.getParameter("newJobCodeORLeadership"));
		wfms_routing_and_approvers.setSameJobCode(request.getParameter("SameJobCode"));
		wfms_routing_and_approvers.setDeleteflag(flag);
		wfms_routing_and_approvers.setSameLeadership(request.getParameter("SameLeadership"));
		wfms_routing_and_approvers.setIsSameDept(request.getParameter("isSameDept"));
		wfms_routing_and_approvers.setIsSameMgr(request.getParameter("isSameMgr"));
		wfms_routing_and_approvers.setRoutingProcess(request.getParameter("routingProcess"));
		wfms_routing_and_approvers.setNotificationTo(request.getParameter("notificationTo"));
		WFMS_routing_and_approversLocalServiceUtil.updateWFMS_routing_and_approvers(wfms_routing_and_approvers);
		if(!existingDescription.equalsIgnoreCase(newDdescription)){
			WFMS_action_names wfms_action_names= WFMS_action_namesLocalServiceUtil.getWFMS_action_names(action);
			if(wfms_action_names!=null){
				DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
				dynamicQueryForCos.add(PropertyFactoryUtil.forName("action").eq(wfms_action_names.getActionName()));
				dynamicQueryForCos.add(PropertyFactoryUtil.forName("type").eq(existingDescription));
				Criterion reqcriterion = null;
				reqcriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DRAFT);
				reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,
						RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DISAPPROVED));
				dynamicQueryForCos.add(reqcriterion);
				
				List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
				if(cosList.size()>0){
					for(WFMS_COS cosdata:cosList){
						/*_log.info("action:>>>"+wfms_action_names.getActionName());
						_log.info("cos status and ids are:>>>"+cosdata.getStatus()+"  >>> "+cosdata.getCosId());
						_log.info("exist description is:>>>"+cosdata.getDescription());
						_log.info("new description is:>>>"+newDdescription);*/
		           		cosdata.setType(newDdescription);
						WFMS_COSLocalServiceUtil.updateWFMS_COS(cosdata);
					}
				}
			}
		  }
		}
		catch(SystemException e){
			System.out.println("updaterouting"+e);
		}response.setRenderParameter("jspPage", "/html/configuration/routingapproversView.jsp");
		}
		else{
			response.setRenderParameter("jspPage", "/html/configuration/routingapprovers_create.jsp");
		}
	}

	public void updatenaSupport(ActionRequest request, ActionResponse response) throws Exception {
		if(request.getParameter("actiontype").equalsIgnoreCase("renderView")){
			 response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
		}
		else if(request.getParameter("actiontype").equalsIgnoreCase("submit")){
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = themeDisplay.getUserId();
	int flag = 0;
	User user = UserLocalServiceUtil.getUserById(userId);
	String ASSOCIATE_NUMBER= ParamUtil.getString(request, "ASSOCIATE_NUMBER");
	String deptNumber = request.getParameter("DEPT_NUMBER");
	Map<String, String> deptDivInfoMap=new HashMap<String, String>();
	HondaLogicUtil hondaLogicUtil= new HondaLogicUtil();
	deptDivInfoMap=hondaLogicUtil.singleCallOnServieNow(deptNumber);
	String depname= deptDivInfoMap.get("deptName") ;
		     WFMS_NA_Support wfms_na_support=null;
		     try{
		     wfms_na_support = WFMS_NA_SupportLocalServiceUtil.findBynaSupport(ASSOCIATE_NUMBER);
			 wfms_na_support.setModifiedDate(new Date());
	         wfms_na_support.setModifiedBy(user.getFullName());
	         wfms_na_support.setASSOC_NO(request.getParameter("ASSOC_NO"));
	         wfms_na_support.setASSOCIATE_DATE_OF_HIRE(request.getParameter("ASSOCIATE_DATE_OF_HIRE"));
	         wfms_na_support.setASSOCIATE_NAME(request.getParameter("ASSOCIATE_NAME"));
	         wfms_na_support.setDEPT_NUMBER(deptNumber);
	         wfms_na_support.setDEPT_NO(ParamUtil.getInteger(request, "DEPT_NO"));
	         wfms_na_support.setDEPT_NAME(depname);
	         wfms_na_support.setDeleteflag(flag);
	         wfms_na_support.setASSOCIATE_TITLE(request.getParameter("ASSOCIATE_TITLE"));
	         wfms_na_support.setSHIFT_CODE(request.getParameter("SHIFT_CODE"));
	         wfms_na_support.setTEAM_NUMBER(request.getParameter("TEAM_NUMBER"));
	         wfms_na_support.setEFFDT(request.getParameter("EFFDT"));
	         wfms_na_support.setTERMINATION_DT(request.getParameter("TERMINATION_DT"));
	         wfms_na_support.setMANAGER_ASSOCIATE_NUMBER(ParamUtil.getInteger(request, "MANAGER_ASSOCIATE_NUMBER"));
	         wfms_na_support.setASSGN_TYPE(request.getParameter("ASSGN_TYPE"));
	         wfms_na_support.setLEADERSHIP_ASSIGNMENT(request.getParameter("LEADERSHIP_ASSIGNMENT"));
	         wfms_na_support.setEMAIL(request.getParameter("EMAIL"));
	         WFMS_NA_SupportLocalServiceUtil.updateWFMS_NA_Support(wfms_na_support);
		     }
		     catch(SystemException e){
		    	 System.out.println("updatenaSupport"+e);
		     }
		 	response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
		} 
	
		else{
			response.setRenderParameter("jspPage", "/html/configuration/naSupport_create.jsp");
		}
	}
	
	public void createRoutingAndApprover(ActionRequest request, ActionResponse response) throws Exception {
		if(request.getParameter("actiontype").equalsIgnoreCase("renderView")){
			 response.setRenderParameter("jspPage", "/html/configuration/routingapproversView.jsp");
		}
		else{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		int flag=0;
		User user = UserLocalServiceUtil.getUserById(userId);
		try{
			WFMS_routing_and_approvers wfms_routing_and_approvers=null;
			int and_approvers=WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approversesCount();
	        wfms_routing_and_approvers= new WFMS_routing_and_approversImpl();
	        wfms_routing_and_approvers.setRapId(Integer.toString(and_approvers+1));
	        wfms_routing_and_approvers.setCreateDate(new Date());
	        wfms_routing_and_approvers.setCreatedBy(user.getFullName());
			//wfms_routing_and_approvers.setModifiedDate(new Date());
			//wfms_routing_and_approvers.setModifiedBy(user.getFullName());
			wfms_routing_and_approvers.setAction(request.getParameter("action"));
			wfms_routing_and_approvers.setChangeDescription(request.getParameter("changeDescription").trim());
			wfms_routing_and_approvers.setCurrentJobCodeORLeadership(request.getParameter("currentJobCodeORLeadership"));
			wfms_routing_and_approvers.setNewJobCodeORLeadership(request.getParameter("newJobCodeORLeadership"));
			wfms_routing_and_approvers.setSameJobCode(request.getParameter("SameJobCode"));
			wfms_routing_and_approvers.setDeleteflag(flag);
			wfms_routing_and_approvers.setSameLeadership(request.getParameter("SameLeadership"));
			wfms_routing_and_approvers.setIsSameDept(request.getParameter("isSameDept"));
			wfms_routing_and_approvers.setIsSameMgr(request.getParameter("isSameMgr"));
			wfms_routing_and_approvers.setRoutingProcess(request.getParameter("routingProcess"));
			wfms_routing_and_approvers.setNotificationTo(request.getParameter("notificationTo"));
			WFMS_routing_and_approversLocalServiceUtil.addWFMS_routing_and_approvers(wfms_routing_and_approvers);
			//response.setRenderParameter("jspPage", "/html/configuration/routingapproversView.jsp");
		}
		catch(SystemException e){
			_log.info("createRoutingAndApprover"+e);
			
		}
		response.setRenderParameter("jspPage", "/html/configuration/routingapproversView.jsp");
		}
		
		}
	
	public void createNASupport(ActionRequest request, ActionResponse response) throws Exception {
		if(request.getParameter("actiontype").equalsIgnoreCase("renderView")){
			 response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
		}
		else{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		WFMS_NA_Support wfms_na_support=null;
		User user = UserLocalServiceUtil.getUserById(userId);
		int flag=0;
		String deptNumber = request.getParameter("DEPT_NUMBER");
		Map<String, String> deptDivInfoMap=new HashMap<String, String>();
		HondaLogicUtil hondaLogicUtil= new HondaLogicUtil();
		deptDivInfoMap=hondaLogicUtil.singleCallOnServieNow(deptNumber);
		String depname= deptDivInfoMap.get("deptName") ;
		int and_approvers=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_SupportsCount();
		 wfms_na_support= new WFMS_NA_SupportImpl();
		/* wfms_na_support.setNasId(Integer.toString(and_approvers+1));
		*/
		 try{
	     	 wfms_na_support.setASSOCIATE_NUMBER(request.getParameter("ASSOCIATE_NUMBER"));
	         wfms_na_support.setASSOC_NO(request.getParameter("ASSOCIATE_NUMBER"));
	         wfms_na_support.setASSOCIATE_DATE_OF_HIRE(request.getParameter("ASSOCIATE_DATE_OF_HIRE"));
	         wfms_na_support.setASSOCIATE_NAME(request.getParameter("ASSOCIATE_NAME"));
	         wfms_na_support.setDEPT_NUMBER(deptNumber);
	         wfms_na_support.setDEPT_NAME(depname);
	         String  deptNumbers = deptNumber.replaceAll("[^\\d.]", "");
	         wfms_na_support.setDEPT_NO(Integer.parseInt(deptNumbers));
	         wfms_na_support.setDeleteflag(flag);
	         wfms_na_support.setASSOCIATE_TITLE(request.getParameter("ASSOCIATE_TITLE"));
	         wfms_na_support.setSHIFT_CODE(request.getParameter("SHIFT_CODE"));
	         wfms_na_support.setTEAM_NUMBER(request.getParameter("TEAM_NUMBER"));
	         wfms_na_support.setEFFDT(request.getParameter("EFFDT"));
	         wfms_na_support.setTERMINATION_DT(request.getParameter("TERMINATION_DT"));
	         wfms_na_support.setMANAGER_ASSOCIATE_NUMBER(ParamUtil.getInteger(request, "MANAGER_ASSOCIATE_NUMBER"));
	         wfms_na_support.setASSGN_TYPE(request.getParameter("ASSGN_TYPE"));
	         wfms_na_support.setLEADERSHIP_ASSIGNMENT(request.getParameter("LEADERSHIP_ASSIGNMENT"));
	         wfms_na_support.setEMAIL(request.getParameter("EMAIL"));
	         wfms_na_support.setCreateDate(new Date());
	 		 wfms_na_support.setCreatedBy(user.getFullName());
  			 //wfms_na_support.setModifiedDate(new Date());
	 	     //wfms_na_support.setModifiedBy(user.getFullName());
	 	     WFMS_NA_SupportLocalServiceUtil.addWFMS_NA_Support(wfms_na_support);
	         //WFMS_NA_SupportLocalServiceUtil.updateWFMS_NA_Support(wfms_na_support);
		 }
		 catch(Exception e){
			 _log.error("createNASupport"+e); 
		 }
	         response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
		}
		}
	
	public void updateActionandreason(ActionRequest request, ActionResponse response) throws Exception {
		if(request.getParameter("actiontype").equalsIgnoreCase("renderView")){
			 response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
		}
		else{
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = themeDisplay.getUserId();
	int flag = 0;
	User user = UserLocalServiceUtil.getUserById(userId);
	String aarId = ParamUtil.getString(request, "aarId");
		WFMS_action_and_reasoncode wfms_action_and_reason=null;
		try{
		
		wfms_action_and_reason = WFMS_action_and_reasoncodeLocalServiceUtil.findByreasoncode(aarId);
		String existingReasonCode=wfms_action_and_reason.getReasonCode();
		String action=request.getParameter("action");
		wfms_action_and_reason.setAction(action);
		wfms_action_and_reason.setModifiedDate(new Date());
		wfms_action_and_reason.setModifiedBy(user.getFullName());
		wfms_action_and_reason.setDeleteflag(flag);
		String newReasonCode=request.getParameter("reasonCode").trim();
		wfms_action_and_reason.setReasonCode(newReasonCode);
		String description=request.getParameter("description");
		wfms_action_and_reason.setDescription(description);
		WFMS_action_and_reasoncodeLocalServiceUtil.updateWFMS_action_and_reasoncode(wfms_action_and_reason);
		if(!existingReasonCode.equalsIgnoreCase(newReasonCode)){
			WFMS_action_names wfms_action_names= WFMS_action_namesLocalServiceUtil.getWFMS_action_names(action);
			if(wfms_action_names!=null){
				DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
				dynamicQueryForCos.add(PropertyFactoryUtil.forName("action").eq(wfms_action_names.getActionName()));
				//dynamicQueryForCos.add(PropertyFactoryUtil.forName("status").eq(HondaPermissionKeys.COS_DRAFT));
				dynamicQueryForCos.add(PropertyFactoryUtil.forName("reasonCODE").eq(existingReasonCode));
				
				Criterion reqcriterion = null;
				reqcriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DRAFT);
				reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,
						RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DISAPPROVED));
				dynamicQueryForCos.add(reqcriterion);
				
				List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
				if(cosList.size()>0){
					for(WFMS_COS cosdata:cosList){
					/*	_log.info("action:>>>"+wfms_action_names.getActionName());
						_log.info("cos status and ids are:>>>"+cosdata.getStatus()+"  >>> "+cosdata.getCosId());
						_log.info("exist reasonCode is:>>>"+cosdata.getReasonCODE());
						_log.info("new reasonCode is:>>>"+newReasonCode);*/
		           		cosdata.setReasonCODE(newReasonCode);
		           		if(!cosdata.getDescription().equalsIgnoreCase(description))
		           			cosdata.setDescription(description);
						WFMS_COSLocalServiceUtil.updateWFMS_COS(cosdata);
					}
				}
			  }
		}
		}
		catch(SystemException e){
			System.out.println("updateActionandreason"+e);
		}
		}
		response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncodeView.jsp");
	
	}

	public void createActionandreason(ActionRequest request, ActionResponse response) throws Exception {
		if(request.getParameter("actiontype").equalsIgnoreCase("renderView")){
			 response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncodeView.jsp");
		}
		else if(request.getParameter("actiontype").equalsIgnoreCase("submit")){
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = themeDisplay.getUserId();
	int flag = 0;
		User user = UserLocalServiceUtil.getUserById(userId);
		WFMS_action_and_reasoncode	wfms_action_and_reason = new WFMS_action_and_reasoncodeImpl();
		try{
		wfms_action_and_reason.setAarId(Integer.toString((int)  CounterLocalServiceUtil.increment("id", 50)+1));
		wfms_action_and_reason.setCreateDate(new Date());
		wfms_action_and_reason.setCreatedBy(user.getFullName());
		wfms_action_and_reason.setAction(request.getParameter("action"));
		//wfms_action_and_reason.setModifiedDate(new Date());
		//wfms_action_and_reason.setModifiedBy(user.getFullName());
		wfms_action_and_reason.setDeleteflag(flag);
		wfms_action_and_reason.setReasonCode(request.getParameter("reasonCode").trim());
		wfms_action_and_reason.setDescription(request.getParameter("description"));
		WFMS_action_and_reasoncodeLocalServiceUtil.addWFMS_action_and_reasoncode(wfms_action_and_reason);
		}
		catch(Exception e){
			_log.error("createActionandreason"+e);
		}
		}
		response.setRenderParameter("jspPage", "/html/configuration/actionandreasoncodeView.jsp");
	}
	
	public void importPositionData(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, PortletException, IOException {
		
		System.out.println("Calling Upload Position Data");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
		long companyId = user.getCompanyId();
		Group group = user.getGroup();

		long scopeGroupId = group.getGroupId();
		Calendar cal = Calendar.getInstance();
		Date createDt = cal.getTime();
		
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);
		
		String vendorName = null; 
		
		//File file = uploadRequest.getFile("positionReport");
		
		List<WFMS_Position> importedPositions = null;
		
		/*try {
			ExcelFileUtil fUtil = new ExcelFileUtil();
			importedPositions = fUtil.parsePositionFile(file);
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    }*/
		
		try {
			List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();

			if (wfms_PositionList != null)
				request.setAttribute("wfms_PositionList", wfms_PositionList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
	}

	public void importNASupportData(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, PortletException, IOException {
		
		System.out.println("Calling Upload Position Data");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		//String screenName = user.getScreenName();
		//long companyId = user.getCompanyId();
		Group group = user.getGroup();

		long scopeGroupId = group.getGroupId();
		Calendar cal = Calendar.getInstance();
		Date createDt = cal.getTime();
		
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);
		
		String vendorName = null; 
		
		//File file = uploadRequest.getFile("importNASupportData");
		
		List<WFMS_NA_Support> importedPositions = null;
		
		/*try {
			ExcelFileUtil fUtil = new ExcelFileUtil();
			importedPositions = fUtil.parseNaSupportfile(file);
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    }
	*/

		response.setRenderParameter("jspPage", "/html/configuration/nasupportView.jsp");
	}
	private static Log _log= LogFactoryUtil.getLog(ConfigurationPortlet.class.getName());
	private WFMS_action_and_reasoncode wfms_action_and_reason;
}