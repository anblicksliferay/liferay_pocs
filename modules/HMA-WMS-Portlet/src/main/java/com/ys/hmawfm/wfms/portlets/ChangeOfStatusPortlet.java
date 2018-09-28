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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.ys.hmawfm.wfms.portlets.constants.WorkflowConfigurationPortletKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode;
import com.ys.hmawfm.wfms.services.model.WFMS_action_names;
import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_COSImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_COS_AuditImpl;
import com.ys.hmawfm.wfms.services.rest.CostCenterService;
import com.ys.hmawfm.wfms.services.rest.DivisionService;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.utils.ConfigUtility;
import com.ys.hmawfm.wfms.utils.DatagridDisplayManagerUtil;
import com.ys.hmawfm.wfms.utils.EmailUtility;
import com.ys.hmawfm.wfms.utils.GenerateFrindlyURL;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.utils.HondaPermissionKeys;
import com.ys.hmawfm.wfms.vo.AssociateInformation;
import com.ys.hmawfm.wfms.workflow.ModifyPositionWFHelper;
import com.ys.hmawfm.wfms.workflow.Workflow;
import com.ys.hmawfm.wfms.workflow.WorkflowConstants;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_COSException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_RequisitionException;
import com.ys.hmawfm.wfms.services.exception.NoSuchWFMS_PositionException;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=HMA-WMS",
        "com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.view-template=/html/changeOfStatus/list.jsp",
		"javax.portlet.name=" + WorkflowConfigurationPortletKeys.ChangeOfStatus,
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.display-name=WMS-ChangeOfStatus"
    },
    service = Portlet.class
)
public class ChangeOfStatusPortlet extends MVCPortlet {

	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PortletRequestDispatcher prd = getPortletContext()
					.getRequestDispatcher("/html/changeOfStatus/list.jsp");
			boolean loggedIn = themeDisplay.isSignedIn();
			if (!loggedIn){
				prd = getPortletContext().getRequestDispatcher("/html/signin.jsp");
			}
			prd.include(request, response);
		} catch (PortletException e) {
			_log.error("In ChangeOfStatusPortlet.doView Error", e);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	
	public void manageCos(ActionRequest request, ActionResponse response) throws Exception {
		try {
			List<WFMS_COS> wfms_CosList = WFMS_COSLocalServiceUtil.getAll();
			if (wfms_CosList != null)
				request.setAttribute("wfms_CosList", wfms_CosList);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/position/managePosition.jsp");
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editCOS(ActionRequest request, ActionResponse response)
			throws Exception {
		    String cosId = ParamUtil.getString(request, "cosId");
		    WFMS_COS wfms_cos=null;
		try {
			   wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosId);
			if (wfms_cos != null) {
				request.setAttribute("cosId", cosId);
				request.setAttribute("wfms_CosObj", wfms_cos);
				request.setAttribute("AssociateNumber", wfms_cos.getAssoicateId());
			}
		} catch (Exception e) {
			_log.error("In ChangeOfStatusPortlet.editCOS Error ", e);
		}
		if(wfms_cos.getStatus().equals(HondaPermissionKeys.COS_DRAFT) || wfms_cos.getStatus().equals(HondaPermissionKeys.COS_DISAPPROVED))
		response.setRenderParameter("jspPage",	"/html/changeOfStatus/manage.jsp");
		else
		response.setRenderParameter("jspPage",	"/html/changeOfStatus/manageCOS.jsp");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void newChangeOfStatus(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = UserLocalServiceUtil.getUserById(themeDisplay.getUserId());
		request.getPortletSession().setAttribute("ScreenName", user.getScreenName());
		/*Below line used for print option*/
		response.setRenderParameter("newChangeOfStatus","newChangeOfStatus");
		response.setRenderParameter("jspPage",	"/html/changeOfStatus/manage.jsp");
	}
		
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 */
	public void updateCOS(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {

		JSONObject jsonUser = JSONFactoryUtil.createJSONObject();
		try {
			String positionId = request.getParameter("positionId");
			WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
					.getByPositionId(positionId);
			if (wfms_Position != null) {
				wfms_Position = WFMS_PositionLocalServiceUtil
						.updateWFMS_Position(wfms_Position);
				request.setAttribute("positionId", positionId);
				request.setAttribute("wfms_PositionObj", wfms_Position);
				jsonUser.put("success", "true");

			} else {
				jsonUser.put("success", "false");
			}
		} catch (Exception e) {
			jsonUser.put("success", "false");
			_log.error("In ChangeOfStatusPortlet.updateCOS Error", e);
		}
		response.setRenderParameter("jspPage",
				"/html/changeOfStatus/manage.jsp");
	}

	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 */
	public void serveResource(ResourceRequest request, ResourceResponse response)
			   throws IOException, PortletException {
			  
			  String cmd = ParamUtil.getString(request, "cmd");
			 
			  String cmdType = ParamUtil.getString(request, "cmdType");
				if (cmd.equals("cosList")) {
					try {
						try {
							getCOSList(cmdType,request, response);
						} catch (JSONException e) {
							e.printStackTrace();
						}
					} catch (NoSuchWFMS_PositionException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}else if (cmd.equals("getPositionDetailsURL")) {
						fetchPositionDetails(request, response);
				}else if (cmd.equalsIgnoreCase("restForCostCenter")) {
					
				}else if(cmd.equalsIgnoreCase("getServiceDetail")){
				   try {
					   getServiceDetails(request, response);
				   } catch (com.liferay.portal.kernel.json.JSONException e) {
				   }
				} else if (cmd.equals("getActionURL")) {
					   getAction(request, response);
			    }else if (cmd.equals("getchgDesConditions")) {
					   getchgDesConditions(request, response);
			    }else if (cmd.equals("getDescriptionURL")) {
			    		getDescriptionData(request, response);
			    }else if (cmd.equals("getDeptNumberURL")) {
				   try {
					   getDeptNumber(request, response);
				   } catch (JSONException e) {
					   e.printStackTrace();
				   }
			  }else if (cmd.equals("associateNumberOnCos")) {
				   try {
					   fetchPositionOnAssociateNumber(request, response);
				   } catch (NoSuchWFMS_PositionException e) {
					e.printStackTrace();
				}
			  }else if (cmd.equals("cmdassocitaetitle")) {
				  	fetchDeptNumberOnCos(request, response);
			  }else if (cmd.equals("ManagerAssoNoURL")) {
				  	getMgrAssociateNo(request, response);
			  }else if (cmd.equals("LoadDivisionNames")) {
					getDivisionNameDeptName(request, response);
			  }else if(cmd.equalsIgnoreCase("getAssNumURL")){
				  try {
				     fetchPositionOnAssociateNumber(request, response);
				  } catch (NoSuchWFMS_PositionException e) {
						e.printStackTrace();
					}
			  }else if(cmd.equalsIgnoreCase("getnewPositionURL")){
			      	getNewPositionNumber(request, response);
			  }else if(cmd.equalsIgnoreCase("getPositionNumURL")){
				  	getPositionDetailsforUpdate(request, response);
			  }else if (cmd.equals("reopenEvent")) {
				//	checkReopenStatus(request, response);
				} else if (cmd.equals("LoadDivisionNames")) {
					getDivisionNameDeptName(request, response);
				} else if (cmd.equals("positionList")) {
					try {
						try {
							PositionPortlet.getPositionList(cmdType, request, response);
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SystemException e) {
						
						e.printStackTrace();
					}
				} else if (cmd.equals("closePositionEvent")) {
					try {
						PositionPortlet.closePositionAction(request ,response);
					} catch (NoSuchWFMS_RequisitionException e) {
						
						e.printStackTrace();
					} catch (SystemException e) {
						
						e.printStackTrace();
					}
				} else if (cmd.equalsIgnoreCase("restForCostCenter")) {
					
				} else if (cmd.equalsIgnoreCase("Employecategory")) {
					try {
						PositionPortlet.empDescriptionOnchange(cmdType,request, response);
					} catch (SystemException e) {
						e.printStackTrace();
					} catch (JSONException e) {
						e.printStackTrace();
					} catch (PortalException e) {
						
						e.printStackTrace();
					}
				} else if (cmd.equalsIgnoreCase("getAssName")) {
					try {
						PositionPortlet.getAssociateNameBydepId(cmdType ,request, response);
					} catch (Exception e) {
					e.printStackTrace();}
					}
				else if (cmd.equalsIgnoreCase("getAssNameForAddAssociate")) {
					try {
						PositionPortlet.getAssNameForAddAssociate(cmdType ,request, response);
					} catch (Exception e) {
					e.printStackTrace();}
					}
				else if (cmd.equalsIgnoreCase("checkServiceNowIsDown")) {
					try {
					//	getAssNameForAddAssociate(cmdType ,resourceRequest, resourceResponse);
						checkServiceNowIsDown(request, response);
					} catch (Exception e) {
					e.printStackTrace();}
					}
				else if (cmd.equalsIgnoreCase("AssociateTitlePositionData")) {
					try {
						 String newpositionId= ParamUtil.getString(request, "newpositionId");
						 getAssocbasedPositionData(cmdType,request, response,newpositionId);
					} catch (Exception e) {
					e.printStackTrace();}
					}
	
                if(cmd.equalsIgnoreCase("getAssociateNum")){
                	try {
						fetchAssociateId(request, response);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
              }else if(cmd.equalsIgnoreCase("assiateTitleshowalert")){
              	try {
            		assiateTitleshowalert(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
          }
			  else{
			  }
		}

	// popUp for Internet connection down 
	public static void checkServiceNowIsDown( ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, SQLException  {
		   JSONObject json = JSONFactoryUtil.createJSONObject();
		    
		    try {
		    	   Map<String,String> deptMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
				   if(deptMap.isEmpty())json.put("sucess", true);
				   else json.put("error", false);
				  
			} catch (Exception e) {
				_log.error(e);
			}
		    PrintWriter writer = resourceResponse.getWriter();
		    writer.print( json );
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	
	
	public static void getAssocbasedPositionData(String type, ResourceRequest resourceRequest, ResourceResponse resourceResponse,String newpositionId) 
			throws IOException, SystemException, JSONException, PortalException, WindowStateException, PortletModeException {

		String ladderType = "";
		Map<String, String> shiftMap1 = new HashMap<String, String>();
		try {
			shiftMap1 = ConfigUtility.getInputValuesForMap("associate-titles-and-ladder");
			Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap1);
			for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {
				if(type.equalsIgnoreCase(entry.getKey())){
					ladderType = entry.getValue();
					break;
				}
			}
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DynamicQuery queryForPosition =WFMS_PositionLocalServiceUtil.dynamicQuery();
  
		if(ladderType.equalsIgnoreCase("Either") || ladderType.equalsIgnoreCase("Technical") || ladderType.equalsIgnoreCase("Business")){
  			 Criterion reqladder = null;
  			 reqladder = RestrictionsFactoryUtil.eq("ladder", "Either");
  			 if(ladderType.equalsIgnoreCase("Technical")){
      			 reqladder = RestrictionsFactoryUtil.or(reqladder,RestrictionsFactoryUtil.eq("ladder", "Technical"));
  			 }
  			 if(ladderType.equalsIgnoreCase("Business")){
      			 reqladder = RestrictionsFactoryUtil.or(reqladder,RestrictionsFactoryUtil.eq("ladder", "Business"));
  			 }
  			 
  			if(ladderType.equalsIgnoreCase("Either")){
  			 reqladder = RestrictionsFactoryUtil.or(reqladder,
						RestrictionsFactoryUtil.eq("ladder", "Technical"));
  			 reqladder = RestrictionsFactoryUtil.or(reqladder,
						RestrictionsFactoryUtil.eq("ladder", "Business"));
  				
  			}
  			 queryForPosition.add(reqladder);
      		}
      		else{
      			queryForPosition.add(PropertyFactoryUtil.forName("ladder").eq(ladderType));
      		}
		
		
        queryForPosition.add(PropertyFactoryUtil.forName("status").eq("Open"));
        queryForPosition.add(PropertyFactoryUtil.forName("dummy").eq("0"));
        queryForPosition.addOrder(OrderFactoryUtil.asc("pId"));
     
        List<String> positionNoList= new ArrayList<String>();
        List<WFMS_Position> positionNumbers = WFMS_PositionLocalServiceUtil.dynamicQuery(queryForPosition);
    	if (positionNumbers.size() > 0) {
        for(WFMS_Position positionNumber: positionNumbers){
        	
        DynamicQuery queryForReq =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
         queryForReq.add(PropertyFactoryUtil.forName("rId").eq(positionNumber.getPId()));

         Long TotalRequisations = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(queryForReq);
			Criterion reqcriterion = null;
			reqcriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_CANCELLED);
			reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,
					RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_COMPLETE));
			queryForReq.add(reqcriterion);
			Long requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(queryForReq);
			if (TotalRequisations == requisationList) {
				
				
				DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
				dynamicQueryForCos.add(PropertyFactoryUtil.forName("newPositionNumber").eq(positionNumber.getPId()));
				Long cosTotalList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos);
				Criterion Coscriterion = null;
				Coscriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_APPROVED);
				Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,
						RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_CANCELLED));
				Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,
						RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DISAPPROVED));
				dynamicQueryForCos.add(Coscriterion);
				Long cosList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos);
				
				if (cosTotalList == cosList || positionNumber.getPId().equalsIgnoreCase(newpositionId)) {
					positionNoList.add(positionNumber.getPId());
				} 
			}
        
        }
	}
      
        TreeSet<String> positionNos = new TreeSet<String>(positionNoList);
        JSONObject json = JSONFactoryUtil.createJSONObject();
        JSONArray jsonData = JSONFactoryUtil.createJSONArray();
    	JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
        for(String posid:positionNos){
        if(!posid.contains("-WFM")){
        	jsonArray = JSONFactoryUtil.createJSONArray();
			jsonArray.put(posid);
            
              jsonData.put(jsonArray);
        }
        }
        PrintWriter writer = resourceResponse.getWriter();
		writer.print( jsonData );
	}
	
	public void addWFMSCOS(ActionRequest request, ActionResponse response)
			throws Exception {
		PortletSession session=request.getPortletSession();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String newPositionNumber = "";
		String positionNumber = "";
		
		if(!ParamUtil.getString(request, "newPositionNumber").equals("undefined")){
			newPositionNumber = ParamUtil.getString(request, "newPositionNumber");
		}
		
		if(!ParamUtil.getString(request, "positionNumber").equals("undefined")){
		    positionNumber = ParamUtil.getString(request, "positionNumber");
		}	
		String associateDateOfHire = ParamUtil.getString(request, "associateDateOfHire");
		String comments = request.getParameter("comments");
        String sameDept = ParamUtil.getString(request, "sameDept");
		String submitonworkflow=ParamUtil.getString(request, "submitonworkflow");
		String hiddenAction=ParamUtil.getString(request, "hiddenAction");
		String hiddenAssociateId=ParamUtil.getString(request, "hiddenAssociateId");
		String newJobCode=ParamUtil.getString(request, "newJobCode");
		String mgrassociateNo=ParamUtil.getString(request, "mgrAssociateNumber");
		String announced=ParamUtil.getString(request,"announced");
		String currentpositionText=ParamUtil.getString(request, "currentpositionText");
		String associateID=ParamUtil.getString(request, "assoicateId");
		ChangeOfStatusPortlet changeOfStatusPortlet=new ChangeOfStatusPortlet();
		
		String associateIdForExistingRecord=changeOfStatusPortlet.fetchAssociateNumber(associateID);
		
		if(associateID!=""  && associateIdForExistingRecord!="")
		{
			request.setAttribute("associateIdForExistingRecord", associateIdForExistingRecord);
			request.setAttribute("associateID", associateID);
			
			response.setRenderParameter("jspPage", "/html/changeOfStatus/manage.jsp");
		}
		else if(associateID!=""  && associateIdForExistingRecord=="" && newJobCode=="")
		{
			request.setAttribute("associateIdForExistingRecord", associateIdForExistingRecord);
			request.setAttribute("associateID", associateID);
			
			response.setRenderParameter("jspPage", "/html/changeOfStatus/manage.jsp");
		}
		else if(associateIdForExistingRecord=="" && newJobCode!="")
		{
			request.setAttribute("modifyButtonEnable", "modifyButtonEnable");
		
		try {
			
			String status = null;
			String change = null;
			String id=null;
			String cosID = ParamUtil.getString(request, "cos-number");
			WFMS_COS wfms_COSList = null;
			wfms_COSList = new WFMS_COSImpl();
			
			
			if(cosID == "")
			{
			
			long cosId = CounterLocalServiceUtil.increment(WFMS_COS.class.getName());
			int genId = HondaLogicUtil.getCurrentKi();
			Integer intObj = new Integer(genId);
			id = intObj + "-" + String.format("%04d", cosId);

			wfms_COSList = WFMS_COSLocalServiceUtil.createWFMS_COS(id);
			wfms_COSList.setCompanyId(user.getUserId());
			wfms_COSList.setNextApprover(user.getFullName());
		
	//		 WFMS_COSLocalServiceUtil.updateCos(wfms_COSList);
			if(announced.equals("1")){	
				wfms_COSList.setAnnounced(1);
			}
			else {
				wfms_COSList.setAnnounced(0);
			}
			}
			else
			{
				id = ParamUtil.getString(request, "cos-number");
				wfms_COSList = WFMS_COSLocalServiceUtil.getWFMS_COS(id);
			    long cosaId = CounterLocalServiceUtil.increment(WFMS_COS_Audit.class.getName());
				if(Validator.isNotNull(mgrassociateNo)){
		            AssociateInformation associateInformation= new AssociateInformation();
		            associateInformation=HMAAssociateInfoService.fetchPositionOnManagerAssociateNo(mgrassociateNo);
		            wfms_COSList.setMgrAssociateNumber(mgrassociateNo);
		            wfms_COSList.setNewManagerName(associateInformation.getAssociateName());
		            wfms_COSList.setNewManagerTitle(associateInformation.getAssociateTitle());
					}
			
				String audId =String.valueOf(cosaId);
				WFMS_COS_Audit wfms_audit = null;
				wfms_audit = new WFMS_COS_AuditImpl();			
				wfms_audit.setCosaId(audId);
				wfms_audit.setUserId(userId);
				wfms_audit.setCreatedBy(user.getFullName());
				if(submitonworkflow=="")
				change = HondaPermissionKeys.COS_MODIFIED;
				else
				change = HondaPermissionKeys.COS_SUBMIT;	
				wfms_audit.setChange(change);
				wfms_audit.setCosId(id);
				wfms_audit.setCreateDate(new Date());
				if(!currentpositionText.equals("")){
					if(currentpositionText.equalsIgnoreCase("currentpositionText")){
						wfms_COSList.setCurrentPositionText(1);
					}else{
						wfms_COSList.setCurrentPositionText(0);
					}}
				if(announced.equals("1")){
					wfms_COSList.setAnnounced(1);
				}
				else{
					 wfms_COSList.setAnnounced(0);
				}
			
				WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_COSList);
				HondaLogicUtil.auditLogsForReqAndCOS(wfms_audit.getCosaId(), WorkflowConstants.CHANGE_OF_STATUS_SAVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request,comments );
 
			}  	if(!currentpositionText.equals("")){
				if(currentpositionText.equalsIgnoreCase("currentpositionText")){
					wfms_COSList.setCurrentPositionText(1);
				}else{
					wfms_COSList.setCurrentPositionText(0);
				}}
			if(Validator.isNotNull(mgrassociateNo)){
	            AssociateInformation associateInformation= new AssociateInformation();
	            associateInformation=HMAAssociateInfoService.fetchPositionOnManagerAssociateNo(mgrassociateNo);
	            wfms_COSList.setMgrAssociateNumber(mgrassociateNo);
	            wfms_COSList.setNewManagerName(associateInformation.getAssociateName());
	            wfms_COSList.setNewManagerTitle(associateInformation.getAssociateTitle());
			    }
			newJobCode=ParamUtil.getString(request, "newJobCode");
			if(newJobCode!="")
			{
				newJobCode=ParamUtil.getString(request, "newJobCode");
			}
			else
			{
				newJobCode=ParamUtil.getString(request, "hiddenAssociateTitle");
			}
			wfms_COSList.setNewJobCode(newJobCode);
			if(positionNumber.equals("None")){
			    wfms_COSList.setNewPositionNumber(positionNumber);
			}
			
			wfms_COSList.setCosId(id);
			if(hiddenAssociateId=="")
			{
				wfms_COSList.setAssoicateId(ParamUtil.getString(request, "assoicateId"));
			}
			else
			{
		     wfms_COSList.setAssoicateId(ParamUtil.getString(request, "hiddenAssociateId"));
			}
			if(session.getAttribute("associateName") != null)
				wfms_COSList.setAssociatename((String)session.getAttribute("associateName"));
			session.removeAttribute("associateName");
			if(session.getAttribute("Description") != null)
				wfms_COSList.setDescription((String)session.getAttribute("Description"));
			session.removeAttribute("Description");
		
			
			 DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
			 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionId").eq(ParamUtil.getString(request, "action")));
		     List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
			 if(actionListof.size()>0)
			    wfms_COSList.setAction(actionListof.get(0).getActionName());
			
			wfms_COSList.setAssociateDateOfHire(ParamUtil.getString(request, "associateDateOfHire"));
			wfms_COSList.setType(ParamUtil.getString(request, "type"));
			wfms_COSList.setReasonCODE(ParamUtil.getString(request, "reasoncode"));
			wfms_COSList.setEffectiveDate(ParamUtil.getString(request, "effectiveDate"));
			wfms_COSList.setNewJobCode(newJobCode);
			wfms_COSList.setRoutingProcess(ParamUtil.getString(request, "routingProcess"));
			wfms_COSList.setNotificationTo(ParamUtil.getString(request, "notificationTo"));
			if(session.getAttribute("ScreenName") != null)
				wfms_COSList.setCreatedBy(user.getFullName());
			wfms_COSList.setSameJobCode(ParamUtil.getString(request, "sameJobCode"));
			wfms_COSList.setSameMgr(ParamUtil.getString(request, "sameMgr"));
			wfms_COSList.setTeamNumber(ParamUtil.getString(request, "teamNumber"));
			wfms_COSList.setShiftCode(ParamUtil.getString(request, "shiftCode"));
			wfms_COSList.setManpowerCategiry(ParamUtil.getString(request, "manpowerCategiry"));
			wfms_COSList.setComments(ParamUtil.getString(request, "comments"));
			
			if(!ParamUtil.getString(request, "currentJobCode").equalsIgnoreCase("")){
			wfms_COSList.setCurrentJobCode(ParamUtil.getString(request, "currentJobCode"));
			wfms_COSList.setCurrentDepartmentManager(ParamUtil.getString(request, "currentDepartmentManager"));
			wfms_COSList.setCurrentDivisionManager(ParamUtil.getString(request, "currentDivisionManager"));
			wfms_COSList.setCurrentDepartmentNumber(ParamUtil.getString(request, "currentDepartmentNumber"));
			wfms_COSList.setCurrentDepartmentName(ParamUtil.getString(request, "currentDepartmentName"));
			wfms_COSList.setCurrentDivision(ParamUtil.getString(request, "currentDivision"));
			wfms_COSList.setCurrentTeamNumber(ParamUtil.getString(request, "currentTeamNumber"));			
			wfms_COSList.setCurrentShiftCode(ParamUtil.getString(request, "currentShiftCode"));
			wfms_COSList.setCurrentManagerAssocNumber(ParamUtil.getString(request, "currentManagerAssocNumber"));
			
			if(wfms_COSList.getSystemGenerated()!=2){
				wfms_COSList.setCurrentLeadershipAssignment(ParamUtil.getString(request, "currentLeadershipAssignment"));
			    wfms_COSList.setCurrentManpowerRep(ParamUtil.getString(request, "currentManpowerRep"));
			}
			wfms_COSList.setCurrentManagerName(ParamUtil.getString(request, "currentManagerName"));
			wfms_COSList.setCurrentManagerTitle(ParamUtil.getString(request, "currentManagerTitle"));
			wfms_COSList.setCurrentDepartmentManager(ParamUtil.getString(request, "currentDepartmentManager"));
			wfms_COSList.setPositionNumber(ParamUtil.getString(request, "currentPositionNumber"));
			
			
			}
			
			if(newJobCode.equals("PA") || newJobCode.equals("TC"))
				wfms_COSList.setLeadershipAssignment(ParamUtil.getString(request, "leadershipAssignment"));

			if(session.getAttribute("position") != null){
				 if(positionNumber.equalsIgnoreCase("None")){					
				    wfms_COSList.setNewPositionNumber("None");
				    wfms_COSList.setPositionNumber("None");
				}else {
					wfms_COSList.setPositionNumber(newPositionNumber);
				    wfms_COSList.setNewPositionNumber(positionNumber);
				}
				WFMS_Position wfmsposition = (WFMS_Position)session.getAttribute("position");
				WFMS_Position wfmspositionBasedOnReportto = (WFMS_Position)session.getAttribute("positionBasedOnReport");
				wfms_COSList.setNewDivision(wfmsposition.getDivision());
				wfms_COSList.setNewDivisionManager(wfmsposition.getDivisionManager());
				wfms_COSList.setNewDepartmentName(wfmsposition.getDepartmentName());
				wfms_COSList.setNewDepartmentManager(wfmsposition.getDepartmentManager());
				wfms_COSList.setNewDepartmentNumber(wfmsposition.getDepartmentNumber());
				if(!newJobCode.equals("PA") || !newJobCode.equals("TC")){
					wfms_COSList.setSameDept("");
					wfms_COSList.setLeadershipAssignment("");
			    }
				if(wfmsposition.getLeadershipAssignment() != null)
					wfms_COSList.setSameLeadership(wfmsposition.getLeadershipAssignment());
				if(wfmspositionBasedOnReportto.getAssociateNumber() != null)
					if(positionNumber != null && !positionNumber.equals("None") && !positionNumber.equals(""))
					   wfms_COSList.setMgrAssociateNumber(wfmspositionBasedOnReportto.getAssociateNumber());
				
				if(wfmspositionBasedOnReportto.getAssociateName() != null)
					wfms_COSList.setNewManagerName(wfmspositionBasedOnReportto.getAssociateName());
				else
					wfms_COSList.setNewManagerName("Not Found");
				
				if(wfmspositionBasedOnReportto.getAssociateTitle() != null)
					wfms_COSList.setNewManagerTitle(wfmspositionBasedOnReportto.getAssociateTitle());
				else
					wfms_COSList.setNewManagerTitle("Not Found");
				
				session.removeAttribute("position");
				session.removeAttribute("positionBasedOnReport");
			}else if(session.getAttribute("DivInfoFromMaster") != null){
				 Map<String,String> DivInfoFromMaster = (Map<String, String>)session.getAttribute("DivInfoFromMaster");
				wfms_COSList.setNewDivision(DivInfoFromMaster.get("divName"));
				wfms_COSList.setNewDivisionManager(DivInfoFromMaster.get("divMgrName"));
				wfms_COSList.setNewDepartmentName(DivInfoFromMaster.get("deptName"));
				wfms_COSList.setNewDepartmentManager(DivInfoFromMaster.get("deptMgrName"));
			//	wfms_COSList.setMgrAssociateNumber("");
			//	wfms_COSList.setNewManagerName("");
			//	wfms_COSList.setNewManagerTitle("");
				wfms_COSList.setNewDepartmentNumber("");
				if(sameDept.equals(""))
					wfms_COSList.setSameDept("");
				else
					wfms_COSList.setSameDept(sameDept);
				if(newJobCode.equals("PA") || newJobCode.equals("TC")){
					wfms_COSList.setSameLeadership("");
					wfms_COSList.setLeadershipAssignment(ParamUtil.getString(request, "leadershipAssignment"));
				}
				else{
					wfms_COSList.setNewPositionNumber("None");
					wfms_COSList.setSameLeadership("None");
					wfms_COSList.setLeadershipAssignment("");
				}
				session.removeAttribute("DivInfoFromMaster");
			}
			if(wfms_COSList.getSystemGenerated()==2){
				   wfms_COSList.setCurrentManagerTitle(ParamUtil.getString(request, "currentManagerTitle"));
				   wfms_COSList.setNewManagerTitle(ParamUtil.getString(request, "currentManagerTitle"));
				   wfms_COSList.setNewManagerName(ParamUtil.getString(request, "currentManagerName"));

				}
			if(wfms_COSList.getSystemGenerated()==1){
				if(wfms_COSList.getNewManagerName().equals(""))
					wfms_COSList.setNewManagerName("Not Found");
				
				if(wfms_COSList.getNewManagerTitle().equals(""))
					wfms_COSList.setNewManagerTitle("Not Found");
			}
			
		     if(submitonworkflow=="" &&  wfms_COSList.getStatus().equals(HondaPermissionKeys.COS_DRAFT))			{
		    	 Date createDate=wfms_COSList.getCreateDate();
		    	wfms_COSList.setCreateDate(createDate);	
				status=HondaPermissionKeys.COS_DRAFT;	
				wfms_COSList.setStatus(status);	
				if(newJobCode.equals("PA") || newJobCode.equals("TC")){
					wfms_COSList.setNewPositionNumber("");
				}
				wfms_COSList = WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_COSList);
				
			}
		     else if(submitonworkflow=="" && status==null)
			{
		    wfms_COSList.setCreateDate(new Date());		
			status = HondaPermissionKeys.COS_DRAFT;	
			wfms_COSList.setStatus(status);
			wfms_COSList.setNextApprover( user.getFullName());
			wfms_COSList = WFMS_COSLocalServiceUtil.addWFMS_COS(wfms_COSList);
			HondaLogicUtil.auditLogsForReqAndCOS(wfms_COSList.getCosId(), WorkflowConstants.CHANGE_OF_STATUS_SAVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, comments);
			 
			}
			else
			{if(!currentpositionText.equals("")){
				if(currentpositionText.equalsIgnoreCase("currentpositionText")){
					wfms_COSList.setCurrentPositionText(1);
				}else{
					wfms_COSList.setCurrentPositionText(0);
				}}
				Date createDate=wfms_COSList.getCreateDate();
		    wfms_COSList.setCreateDate(createDate);	
			status=HondaPermissionKeys.COS_SUBMIT;	
			DynamicQuery queryForRoutingandApprovers =WFMS_routing_and_approversLocalServiceUtil.dynamicQuery();
        	queryForRoutingandApprovers.add(PropertyFactoryUtil.forName("action").eq(ParamUtil.getString(request, "action")));
        	Criterion coscriterionCondition = null;
        	coscriterionCondition = RestrictionsFactoryUtil.eq("changeDescription", ParamUtil.getString(request, "type"));
        	queryForRoutingandApprovers.add(coscriterionCondition);
        	//queryForRoutingandApprovers.add(PropertyFactoryUtil.forName("changeDescription").eq(ParamUtil.getString(request, "type")));
        	 List<WFMS_routing_and_approvers> roleDesc= new ArrayList<WFMS_routing_and_approvers>();
        	 
             roleDesc = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery(queryForRoutingandApprovers);
        	 
             String routingList = "";
        	 String notificationToList=StringPool.BLANK; 
        	 for(WFMS_routing_and_approvers roleDes: roleDesc){	
        		 routingList = roleDes.getRoutingProcess();
        		 notificationToList=roleDes.getNotificationTo();
        	 }
        	 
        	 for(WFMS_routing_and_approvers roleDes: roleDesc){
        		 routingList = roleDes.getRoutingProcess();
        	 }
        	 
             String roleArray[] = routingList.split(",");        	 
        	 String[] roleList = new String[50];
        	 
        	 for(int i=0; i < roleArray.length; i++){
                 if(!roleArray[i].trim().equals("")){	 
              	 roleList[i] = roleArray[i].trim();
             }
             }
        	
        	 String roleListvalue = "";
        	 if(roleList.length>0)
        	    roleListvalue = roleList[0];
        	 
        	 int approverStep = 0;
        	
        	if(roleListvalue.equals(HondaPermissionKeys.COS_CMP)){
        		roleListvalue = HondaPermissionKeys.ROLE_CMP;
        	}
        	String	managerEmail=null;
        	Map<String, String> costmap=null;
        	  String emailMessage="";
              String emailSubject = "";
              String Manager_email = "";
              List<String> nextapproverlist=null;
	        		 String AsscbasedDept = "";
	        		 String url     =GenerateFrindlyURL.getCOSfrindlyURL(request,cosID);
	        	//	 WFMS_COS	wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosID);
	           if(roleListvalue.equals(HondaPermissionKeys.COS_CURRENT_DM)){
	                     costmap = HondaLogicUtil.singleCallOnServieNow(wfms_COSList.getCurrentDepartmentNumber());
				          wfms_COSList.setNextApprover(costmap.get("deptMgrName"));
				
					 emailMessage="This Change of status has been submitted and needs your approval.<br/> Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a> ";
					 emailSubject = " Department Manager: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"]  "+wfms_COSList.getAssociatename()+" has been submitted for your approval.";
					 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, wfms_COSList.getCurrentDepartmentNumber(), request, emailSubject, emailMessage);

			    }if(roleListvalue.equals(HondaPermissionKeys.COS_CURRENT_DVM)){
			    	 costmap = HondaLogicUtil.singleCallOnServieNow(wfms_COSList.getCurrentDepartmentNumber());
			    	 wfms_COSList.setNextApprover(costmap.get("divMgrName"));
   				
				 emailMessage="This Change of status has been submitted and needs your approval.<br/> Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a> ";
				 emailSubject = " Division Manager: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+"  has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, wfms_COSList.getCurrentDepartmentNumber(), request, emailSubject, emailMessage);

			 }if(roleListvalue.equals(HondaPermissionKeys.COS_NEW_DM)){
				 if(wfms_COSList.getNewJobCode().equals("PA") || wfms_COSList.getNewJobCode().equals("TC") || wfms_COSList.getNewPositionNumber().equals("None")){
					 AsscbasedDept = wfms_COSList.getSameDept();
				 }else{
					 AsscbasedDept = wfms_COSList.getNewDepartmentNumber();
				 }
				 costmap = HondaLogicUtil.singleCallOnServieNow(AsscbasedDept);
		    	 wfms_COSList.setNextApprover(costmap.get("deptMgrName"));
				

				 emailMessage="This Change of status has been submitted and needs your approval. <br/>Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a>  ";
				 emailSubject = " Department Manager: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+"  has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, AsscbasedDept, request, emailSubject, emailMessage);

			 }if(roleListvalue.equals(HondaPermissionKeys.COS_NEW_DVM)){
				 if(wfms_COSList.getNewJobCode().equals("PA") || wfms_COSList.getNewJobCode().equals("TC") || wfms_COSList.getNewPositionNumber().equals("None")){
					 AsscbasedDept = wfms_COSList.getSameDept();
				 }else{
					 AsscbasedDept = wfms_COSList.getNewDepartmentNumber();
				 }
				 costmap = HondaLogicUtil.singleCallOnServieNow(AsscbasedDept);
		    	 wfms_COSList.setNextApprover(costmap.get("divMgrName"));
				
				 emailMessage="This Change of status has been submitted and needs your approval.<br/> Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a>  ";
				 emailSubject = " Division Manager: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+"  has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, AsscbasedDept, request, emailSubject, emailMessage);
			
       	}
			 if(roleListvalue.equals(HondaPermissionKeys.COS_HR_DM)){
				 nextapproverlist=listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_HRDM);
				wfms_COSList.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
       		     emailMessage="This Change of status has been submitted and needs your approval.<br/> Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a>";
				 emailSubject = "HR Department Manager: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_HRDM,"", request, emailSubject, emailMessage);

				}	
			if(roleListvalue.equals(HondaPermissionKeys.COS_OPS_LEADER)){
				 nextapproverlist= listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_OPS_LEADER);
				wfms_COSList.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
				 emailMessage="This Change of status has been submitted and needs your approval.<br/> Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a>";
				 emailSubject = "Ops Leader: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_OPS_LEADER,"", request, emailSubject, emailMessage);
			}	
			if(roleListvalue.equals(HondaPermissionKeys.COS_CMP)){
				 nextapproverlist= listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_CMP);
			 wfms_COSList.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
			    emailMessage="This Change of status has been submitted and needs your approval.<br/> Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a>";
				 emailSubject = "Company Manpower Controller: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP,"", request, emailSubject, emailMessage);

			}
			if(roleListvalue.equals(HondaPermissionKeys.COS_SP_DM)){
				 nextapproverlist=  listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_SPDM);
			 wfms_COSList.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
				 emailMessage="This Change of status has been submitted and needs your approval. <br/>Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a>";
				 emailSubject = "SP Department Manager: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM,"", request, emailSubject, emailMessage);

			}				        				
   		if(roleListvalue.equals(HondaPermissionKeys.COS_ARL_OA)){
   		 nextapproverlist=  listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_ARL_OA);
   		wfms_COSList.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
   			 emailMessage="This Change of status has been submitted and needs your approval.<br/> Click the below link to access the Change of status. <br/> <a href=" + url + "> Click here to review the record </a>";
				 emailSubject = "ARL OA: Change of status "+cosID+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been submitted for your approval.";
				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_ARL_OA,"", request, emailSubject, emailMessage);		  

   		}
   		
       	wfms_COSList.setRoleOfApprover(roleListvalue);
       	wfms_COSList.setApproverStep(approverStep);
       	wfms_COSList.setApproverList(routingList);
       	wfms_COSList.setNotificationTo(notificationToList);
       	wfms_COSList.setWorkflowId("Approve Change of Status");
    	if(newJobCode.equals("PA") || newJobCode.equals("TC")){
    		wfms_COSList.setNewPositionNumber("");
    	}
       	wfms_COSList.setWorkflowStep(0);
       	
			wfms_COSList.setStatus(status);	
			wfms_COSList = WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_COSList);
			HondaLogicUtil.auditLogsForReqAndCOS(wfms_COSList.getCosId(), WorkflowConstants.CHANGE_OF_STATUS_MODIFY, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, comments);
			
			}
		     if (wfms_COSList != null) 
					SessionMessages.add(request, "request_processed","Your request completed successfully");
				else 
					SessionErrors.add(request, "request_processed",	"Your request failed to complete");
			WFMS_COS wfms_cos = WFMS_COSLocalServiceUtil.getByCOSId(id);
			if (wfms_cos != null) {
				request.setAttribute("cosId", id);
				request.setAttribute("wfms_CosObj", wfms_cos);
				request.setAttribute("AssociateNumber", wfms_cos.getAssoicateId());
			}
			String saveForm=ParamUtil.getString(request, "saveForm");
			
			if(saveForm!="" && hiddenAction!="")
			{
			//	response.setRenderParameter("jspPage", "/html/changeOfStatus/list.jsp");	
				response.sendRedirect(GenerateFrindlyURL.renderManageCOS(request));

			}
			else if(submitonworkflow!="")
			{
				//response.setRenderParameter("jspPage", "/html/changeOfStatus/list.jsp");	
				response.sendRedirect(GenerateFrindlyURL.renderManageCOS(request));
			}
			else
			{
				if (wfms_cos != null) {
					request.setAttribute("cosId", id);
					request.setAttribute("wfms_CosObj", wfms_cos);
					request.setAttribute("AssociateNumber", wfms_cos.getAssoicateId());
				}

				//response.setRenderParameter("jspPage", "/html/changeOfStatus/manage.jsp");
				response.sendRedirect(GenerateFrindlyURL.getCOSfrindlyURL(request, id));
				
			}
			
		} catch (SystemException e) {
			_log.error("In ChangeOfStatusPortlet.addWFMSCOS Error", e);
		}
	}
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateChangeOfStatus(ActionRequest request, ActionResponse response)
			throws Exception {
		Date createDate = new Date();
		String status = ParamUtil.getString(request, "status");
		String associateDateOfHire =ParamUtil.getString(request, "associateDateOfHire");
		String newPositionNumber = ParamUtil.getString(request, "newPositionNumber");
		String positionNumber = ParamUtil.getString(request, "positionNumber");
		String newJobCode = ParamUtil.getString(request, "newJobCode");
		String sameDept = ParamUtil.getString(request, "sameDept");
		String cosId = ParamUtil.getString(request, "cos-number");
		String announced = ParamUtil.getString(request, "announced");
		WFMS_COS wfms_COSList = WFMS_COSLocalServiceUtil.getWFMS_COS(cosId);
		PortletSession session=request.getPortletSession();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();

		User user = UserLocalServiceUtil.getUserById(userId);
		
		try {
			
			status=HondaPermissionKeys.COS_SUBMIT;
			wfms_COSList.setAssoicateId(ParamUtil.getString(request, "assoicateId"));
			wfms_COSList.setModifiedDate(createDate);
			wfms_COSList.setStatus(status);
			if(session.getAttribute("ScreenName") != null)
				wfms_COSList.setCreatedBy(user.getFullName());
			
			 DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
			 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionId").eq(ParamUtil.getString(request, "action")));
		     List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
			 if(actionListof.size()>0)
			    wfms_COSList.setAction(actionListof.get(0).getActionName());
			 else
				 wfms_COSList.setAction( ParamUtil.getString(request, "action"));
			
			wfms_COSList.setReasonCODE(ParamUtil.getString(request, "reasoncode"));
			wfms_COSList.setAssociateDateOfHire(ParamUtil.getString(request, "associateDateOfHire"));
			wfms_COSList.setRoutingProcess(ParamUtil.getString(request, "routingProcess"));
			wfms_COSList.setNotificationTo(ParamUtil.getString(request, "notificationTo"));
			wfms_COSList.setType(ParamUtil.getString(request, "type"));
			wfms_COSList.setEffectiveDate(ParamUtil.getString(request, "effectiveDate"));
			wfms_COSList.setSameJobCode(ParamUtil.getString(request, "sameJobCode"));
			wfms_COSList.setNewJobCode(newJobCode);
			wfms_COSList.setSameMgr(ParamUtil.getString(request, "sameMgr"));
			wfms_COSList.setTeamNumber(ParamUtil.getString(request, "teamNumber"));
			wfms_COSList.setShiftCode(ParamUtil.getString(request, "shiftCode"));
			wfms_COSList.setManpowerCategiry(ParamUtil.getString(request, "manpowerCategiry"));
			wfms_COSList.setComments(ParamUtil.getString(request, "comments"));
			
			if(announced.equals("1") ){
				wfms_COSList.setAnnounced(1);
				}
			 else{
			    wfms_COSList.setAnnounced(0);
			    }
			if(session.getAttribute("associateName") != null)
				wfms_COSList.setAssociatename((String)session.getAttribute("associateName"));
			session.removeAttribute("associateName");
			if(session.getAttribute("Description") != null)
				wfms_COSList.setDescription((String)session.getAttribute("Description"));
			session.removeAttribute("Description");
			
			if(session.getAttribute("position") != null){
				if(positionNumber.equals("selected")){
					wfms_COSList.setPositionNumber("");
					wfms_COSList.setNewPositionNumber("");
				}else{
					wfms_COSList.setPositionNumber(newPositionNumber);
				    wfms_COSList.setNewPositionNumber(positionNumber);
				}
				WFMS_Position wfmsposition = (WFMS_Position)session.getAttribute("position");
				WFMS_Position wfmspositionBasedOnReportto = (WFMS_Position)session.getAttribute("positionBasedOnReport");
				wfms_COSList.setNewDivision(wfmsposition.getDivision());
				wfms_COSList.setNewDivisionManager(wfmsposition.getDivisionManager());
				wfms_COSList.setNewDepartmentName(wfmsposition.getDepartmentName());
				wfms_COSList.setNewDepartmentManager(wfmsposition.getDepartmentManager());
				wfms_COSList.setNewDepartmentNumber(wfmsposition.getDepartmentNumber());
				if(!newJobCode.equals("PA") || !newJobCode.equals("TC")){
						wfms_COSList.setSameDept("");
						wfms_COSList.setLeadershipAssignment("");
				}
						
				if(wfmsposition.getLeadershipAssignment() != null)
					wfms_COSList.setSameLeadership(wfmsposition.getLeadershipAssignment());
				if(wfmspositionBasedOnReportto.getAssociateNumber() != null)
					if(positionNumber != null && !positionNumber.equals("None") && !positionNumber.equals(""))
					   wfms_COSList.setMgrAssociateNumber(wfmspositionBasedOnReportto.getAssociateNumber());
				
				
				if(wfmspositionBasedOnReportto.getAssociateName() != null)
					wfms_COSList.setNewManagerName(wfmspositionBasedOnReportto.getAssociateName());
				else
					wfms_COSList.setNewManagerName("Not Found");
				
				if(wfmspositionBasedOnReportto.getAssociateTitle() != null)
					wfms_COSList.setNewManagerTitle(wfmspositionBasedOnReportto.getAssociateTitle());
				else
					wfms_COSList.setNewManagerTitle("Not Found");
				
			}else if(session.getAttribute("DivInfoFromMaster") != null){
				 Map<String,String> DivInfoFromMaster = (Map<String, String>)session.getAttribute("DivInfoFromMaster");
				wfms_COSList.setNewDivision(DivInfoFromMaster.get("divName"));
				wfms_COSList.setNewDivisionManager(DivInfoFromMaster.get("divMgrName"));
				wfms_COSList.setNewDepartmentName(DivInfoFromMaster.get("deptName"));
				wfms_COSList.setNewDepartmentManager(DivInfoFromMaster.get("deptMgrName"));
				wfms_COSList.setMgrAssociateNumber("");
				
				
				
				
				wfms_COSList.setNewDepartmentNumber("");
				if(sameDept.equals("Select Department"))
					wfms_COSList.setSameDept("");
				else
					wfms_COSList.setSameDept(sameDept);
				if(newJobCode.equals("PA") || newJobCode.equals("TC")){
					wfms_COSList.setPositionNumber("");
					wfms_COSList.setSameLeadership("");
					wfms_COSList.setLeadershipAssignment(ParamUtil.getString(request, "leadershipAssignment"));
				}
				else{
					wfms_COSList.setPositionNumber("None");
					wfms_COSList.setSameLeadership("None");
					wfms_COSList.setLeadershipAssignment("");
				}
			}
			session.removeAttribute("position");
			session.removeAttribute("positionBasedOnReport");
			session.removeAttribute("DivInfoFromMaster");
			
			wfms_COSList = WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_COSList);
			if (wfms_COSList != null) 
				SessionMessages.add(request, "request_processed","Your request completed successfully");
			else 
				SessionErrors.add(request, "request_processed",	"Your request failed to complete");
			List<WFMS_COS> wfms_COSList1 = WFMS_COSLocalServiceUtil.getWFMS_COSs(-1, -1);
			if (wfms_COSList1 != null) 
				session.setAttribute("wfms_COSList", wfms_COSList1);
			response.setRenderParameter("jspPage","/html/changeOfStatus/list.jsp");
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	private void getDivisionNameDeptName(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			   throws IOException {
		  String deptNo = resourceRequest.getParameter("Deptid");
		  JSONObject json = JSONFactoryUtil.createJSONObject();
		  HondaLogicUtil HondaLogicUtil = new HondaLogicUtil();
		  Map<String,String> deptDivInfoMap = new HashMap<String,String>();
		  PortletSession session = resourceRequest.getPortletSession();
		  try{ 
			  if(!deptNo.equals(""))
				deptDivInfoMap = HondaLogicUtil.singleCallOnServieNow(deptNo);
			    json.put("deptNAME", deptDivInfoMap.get("deptName") );
			    json.put("Division", deptDivInfoMap.get("divName") );
			    json.put("deptMgrName", deptDivInfoMap.get("deptMgrName") );
			    json.put("divMgrName", deptDivInfoMap.get("divMgrName") );
			    if(deptDivInfoMap != null && !deptNo.equals(""))
			    	session.setAttribute("DivInfoFromMaster", deptDivInfoMap);
			    session.removeAttribute("position");
				session.removeAttribute("positionBasedOnReport");
			    PrintWriter writer = resourceResponse.getWriter();
			    writer.print(json);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }finally{
		   
		  }
	}

	public void getNewPositionNumber(ResourceRequest request,
			ResourceResponse response) {

		PrintWriter out = null;
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			String positionId = request.getParameter("posID");
			WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
					.getByPositionId(positionId);

			json.put("POSITION_NUMBER", wfms_Position.getPId());
			json.put("DEPT_NUMBER", wfms_Position.getDepartmentNumber());
			json.put("DEPT_NAME", wfms_Position.getDepartmentName());
			json.put("DEPT_MANAGER", wfms_Position.getDepartmentManager());
			json.put("LeaderShip_Assignment", wfms_Position.getLeadershipAssignment());
			json.put("DIVISION", wfms_Position.getDivision());
			json.put("DIVISION_MANAGER", wfms_Position.getDivisionManager());
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(json);
		}catch (Exception e) {
			_log.error("ChangeOfStatusPortlet.getNewPositionNumber():",e);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws JSONException 
	 */
	public void getPositionDetailsforUpdate(ResourceRequest request,
			ResourceResponse response) {

		PrintWriter out = null;
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			String positionId = request.getParameter("positionID");
			WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
					.getByPositionId(positionId);
			json.put("division", wfms_Position.getDivision());
			json.put("deptName", wfms_Position.getDepartmentName());
			json.put("deptNumber", wfms_Position.getDepartmentNumber());
			json.put("leadershipassignment", wfms_Position.getLeadershipAssignment());
			json.put("associatenumber", wfms_Position.getAssociateNumber());
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(json);
		}catch (Exception e) {
			_log.error(" ChangeOfStatusPortlet.getPositionDetailsforUpdate  Error",e);
		}finally{
		}
	}
	
	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	private void getAction(ResourceRequest resourceRequest ,ResourceResponse resourceResponse) throws IOException
	{
		PrintWriter out = null;
		String hmaactionId=ParamUtil.getString(resourceRequest, "actionId");
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			if (hmaactionId != null) {
				DynamicQuery dynamicQuery = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery();
				Junction junction = RestrictionsFactoryUtil.conjunction();
				junction.add(PropertyFactoryUtil.forName("action").eq(hmaactionId));
				junction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
				dynamicQuery.add(junction);
				List<WFMS_action_and_reasoncode> list = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery(dynamicQuery);
				for(WFMS_action_and_reasoncode actionlist:list){
					JSONObject jsondata=JSONFactoryUtil.createJSONObject();
					    jsondata.put("ReasonCode", actionlist.getReasonCode());
					    jsondata.put("change_Des", actionlist.getDescription());
					    jsonarray.put(jsondata);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}out = resourceResponse.getWriter();
		  out.println(jsonarray.toString());
	}

	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	private void getDescriptionData(ResourceRequest resourceRequest ,ResourceResponse resourceResponse) throws IOException
	{
		String reasoncode=ParamUtil.getString(resourceRequest, "reasoncode");
		String action=ParamUtil.getString(resourceRequest, "action");
		_log.info(reasoncode);
		_log.info(action);
		PrintWriter out = null;
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		JSONObject jsondata=JSONFactoryUtil.createJSONObject();
		try {
			if (reasoncode != null) {
				DynamicQuery dynamicQuery = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery();
				Junction junction = RestrictionsFactoryUtil.conjunction();
				junction.add(PropertyFactoryUtil.forName("action").eq(action));
				junction.add(PropertyFactoryUtil.forName("reasonCode").eq(reasoncode));
				junction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
				dynamicQuery.add(junction);
				List<WFMS_action_and_reasoncode> list = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size() >0){
					WFMS_action_and_reasoncode wFMS_action_and_reasoncode = list.get(0);
				    jsondata.put("Description", wFMS_action_and_reasoncode.getDescription());
 					PortletSession session = resourceRequest.getPortletSession(); 
				    session.setAttribute("Description", wFMS_action_and_reasoncode.getDescription());
				}
				DynamicQuery dynamicQuerys = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery();
				Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("changeDescription"));
				Projection projection1 = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("rapId"));
				
				dynamicQuerys.setProjection(projection);
				Junction junctions = RestrictionsFactoryUtil.conjunction();
				junctions.add(PropertyFactoryUtil.forName("action").eq(action));
				junctions.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
				dynamicQuerys.add(junctions);
				dynamicQuerys.addOrder(OrderFactoryUtil.asc("changeDescription"));
				List<String> ChangeDescriptionlist = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery(dynamicQuerys);
				for(String value:ChangeDescriptionlist){
					JSONObject jsondataForDes=JSONFactoryUtil.createJSONObject();
					jsondataForDes.put("changeDescription", value);
				    jsonarray.put(jsondataForDes);
				}
				jsonarray.put(jsondata);
				_log.info(jsonarray);
				out = resourceResponse.getWriter();
				out.println(jsonarray.toString());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	        
	}
	
	
	private void getchgDesConditions(ResourceRequest resourceRequest ,ResourceResponse resourceResponse) throws IOException
	{
		String chgDesc=ParamUtil.getString(resourceRequest, "chgDesc");
		String action=ParamUtil.getString(resourceRequest, "actionId");
		PrintWriter out = null;
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		JSONObject jsondata=JSONFactoryUtil.createJSONObject();
		try {
			if (action != null && chgDesc != null) {	
				List<WFMS_routing_and_approvers> ChangeDescriptionlist= new ArrayList<WFMS_routing_and_approvers>();
				
				DynamicQuery dynamicQuerys = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery();
				Junction junctions = RestrictionsFactoryUtil.conjunction();
				if(action != null)
				junctions.add(PropertyFactoryUtil.forName("action").eq(action));
				junctions.add(PropertyFactoryUtil.forName("changeDescription").eq(chgDesc));
				dynamicQuerys.add(junctions);
				ChangeDescriptionlist = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery(dynamicQuerys);
				JSONObject jsondataForDes=JSONFactoryUtil.createJSONObject();
				
				if(ChangeDescriptionlist.size()>0){
						jsondataForDes.put("CurrentJobCodeORLeadership", ChangeDescriptionlist.get(0).getCurrentJobCodeORLeadership());
						jsondataForDes.put("NewJobCodeORLeadership", ChangeDescriptionlist.get(0).getNewJobCodeORLeadership());
						jsondataForDes.put("SameJobCode", ChangeDescriptionlist.get(0).getSameJobCode());		
						jsondataForDes.put("SameLeadership", ChangeDescriptionlist.get(0).getSameLeadership());	
						jsondataForDes.put("isSameDept", ChangeDescriptionlist.get(0).getIsSameDept());	
						jsondataForDes.put("isSameMgr", ChangeDescriptionlist.get(0).getIsSameMgr());	
				}
				out = resourceResponse.getWriter();
				out.println(jsondataForDes.toString());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws JSONException
	 */
	private void getDeptNumber(ResourceRequest resourceRequest ,ResourceResponse resourceResponse) throws IOException, JSONException
	{
		PrintWriter out = null;
		String hmadeptNumberId=ParamUtil.getString(resourceRequest, "hmaDeptId");
		try{
			DivisionService serviceNowDivision = new DivisionService();
			//hmadeptNumberId=serviceNowDivision.getAllDivisions(hmadeptNumberId);
			out = resourceResponse.getWriter();
			out.println(hmadeptNumberId);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws JSONException
	 */
	private void restAPICallForCostCenter(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws JSONException {
		
		PrintWriter out = null;
		CostCenterService serviceNowService = new CostCenterService();
		String mapJson = null;
		try {
			mapJson = serviceNowService.getAllCostCenters();
			out = resourceResponse.getWriter();
			out.println(mapJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	public void fetchPositionDetails(ResourceRequest request,
			ResourceResponse response) {
		
		PrintWriter out = null;
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			String positionId = request.getParameter("pidvalue");
			WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
			
			WFMS_Position wfmsPosition = WFMS_PositionLocalServiceUtil.getByPositionId(wfms_Position.getReportsTo());
			 HondaLogicUtil logicUtil=new HondaLogicUtil();
			 Map<String,String> deptMap = logicUtil.singleCallOnServieNow(wfms_Position.getDepartmentNumber());
			json.put("division", deptMap.get("divName"));
			json.put("deptName", deptMap.get("deptName"));
			json.put("deptNumber", wfms_Position.getDepartmentNumber());
			json.put("leadershipassignment", wfms_Position.getLeadershipAssignment());
			if(wfmsPosition.getAssociateNumber() != null)
				json.put("managerAssociateNumber", wfmsPosition.getAssociateNumber());
			json.put("divMgrName",deptMap.get("divMgrName"));
			json.put("deptManager",deptMap.get("deptMgrName"));
		
			if(wfmsPosition.getAssociateTitle()!="")
			    json.put("ManagerAssociateTitle", wfmsPosition.getAssociateTitle());
			else
				json.put("ManagerAssociateTitle", "Not Found");
			
			if(wfmsPosition.getAssociateName()!="")
			    json.put("ManagerAssociateName", wfmsPosition.getAssociateName());
			else
				json.put("ManagerAssociateName", "Not Found");
			if(Validator.isNotNull(wfms_Position.getEmpCategory())) json.put("employeecategory", wfms_Position.getEmpCategory()+"-"+wfms_Position.getEmpCategoryDesc());
			else json.put("employeecategory", "");
			PortletSession session = request.getPortletSession(); 
			session.setAttribute("position", wfms_Position);
			session.setAttribute("positionBasedOnReport",wfmsPosition);
			session.removeAttribute("DivInfoFromMaster");
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(json);
		}catch (Exception e) {
			_log.error("SystemException : ChangeOfStatusPortlet.fetchPositionDetails ", e);
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws NoSuchWFMS_PositionException
	 */
	public void fetchPositionOnAssociateNumber(ResourceRequest request,
			      ResourceResponse response) throws IOException, NoSuchWFMS_PositionException {
		String associateNumber = null;
		 associateNumber = request.getParameter("associateNumberCos");
		 if(associateNumber == null)
			 associateNumber= ParamUtil.getString(request,"associateID");
		AssociateInformation assoInfo = new AssociateInformation();
		AssociateInformation assoInfoForManager = new AssociateInformation();
		assoInfo=null;
		PrintWriter out = null;
		String deptNum = "";
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			if(HMAAssociateInfoService.checkAssociateNumberExist(associateNumber)){
			    assoInfo = HMAAssociateInfoService.fetchPositionOnAssociateNumber(associateNumber);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(assoInfo != null){
			deptNum = assoInfo.getDeptNumber().trim();
			json.put("ASSOCIATE_NAME", assoInfo.getAssociateName());
			json.put("ASSOCIATE_TITLE", assoInfo.getAssociateTitle());
			json.put("DEPT_NUMBER", deptNum);
			json.put("MANAGER_ASSOCIATE_NUMBER", assoInfo.getMgrAssociateNo());
			json.put("TEAM_NUMBER", assoInfo.getTeamNumber());
			json.put("SHIFT_CODE", assoInfo.getShiftCode());
			json.put("LEADERSHIP_ASSIGNMENT", assoInfo.getLeaderAssignment());
			json.put("ASSOCIATE_DATE_OF_HIRE", assoInfo.getAssociateDateOfHire());
		    if(assoInfo.getAssociateName() != null)
			  request.getPortletSession().setAttribute("associateName", assoInfo.getAssociateName());
			try {
				if(assoInfo.getMgrAssociateNo() != null){
					if(HMAAssociateInfoService.checkAssociateNumberExist(assoInfo.getMgrAssociateNo())){
				        assoInfoForManager = HMAAssociateInfoService.fetchPositionOnAssociateNumber(assoInfo.getMgrAssociateNo());
					    json.put("DEPT_MANAGER", assoInfoForManager.getAssociateName());
						json.put("DEPT_MANAGER_TITLE", assoInfoForManager.getAssociateTitle());
				  }
					else{
						
						    json.put("DEPT_MANAGER", "Not Found");
							json.put("DEPT_MANAGER_TITLE", "Not Found");
					}
				}
				} catch (SQLException e) {
				e.printStackTrace();
			}
				/*json.put("DEPT_MANAGER", assoInfo.getAssociateName());
				_log.info(assoInfo.getAssociateName()+"assoInfo.getAssociateName()=");
				json.put("DEPT_MANAGER_TITLE", assoInfo.getAssociateTitle());*/
		}
			DynamicQuery dynamicQuery = WFMS_PositionLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("associateNumber").eq(associateNumber));

			@SuppressWarnings("unchecked")
			List<WFMS_Position> numberList;
			try {
				numberList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQuery);
				if (numberList.size() > 0) {
					WFMS_Position positionObj = numberList.get(0);
					json.put("EMPLOYEE_CATEGORY", positionObj.getEmpCategory()+"-"+positionObj.getEmpCategoryDesc());
					json.put("positionId", positionObj.getPId());
					json.put("EMPLOYEE_CATEGORY", positionObj.getEmpCategory()+"-"+positionObj.getEmpCategoryDesc());
				}
				else{	json.put("EMPLOYEE_CATEGORY", "");}
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			HondaLogicUtil logicUtil = new HondaLogicUtil();
			try {
				Map<String,String> deptMap = logicUtil.singleCallOnServieNow(deptNum);
				if(Validator.isNotNull(deptMap)){
				json.put("DIVISION", deptMap.get("divName"));
				json.put("DIVISION_MANAGER", deptMap.get("divMgrName"));
				json.put("DEPT_NAME", deptMap.get("deptName"));
				json.put("DEPARTMENT_MANAGER", deptMap.get("deptMgrName"));
		//	System.out.println("DIVISION"+deptMap.get("divName")+"DIVISION_MANAGER"+deptMap.get("divMgrName")+"DEPT_NAME"+deptMap.get("deptName")+"DEPARTMENT_MANAGER"+deptMap.get("deptMgrName"));
				}
			} catch (com.liferay.portal.kernel.json.JSONException e) {
				e.printStackTrace();
			}
			
			out = response.getWriter();
			out.println(json);
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void getMgrAssociateNo(ResourceRequest request,
			ResourceResponse response) throws IOException {
		PrintWriter out = null;
		JSONObject json = JSONFactoryUtil.createJSONObject();
		AssociateInformation assoInfo = new AssociateInformation();
		try{
			assoInfo=HMAAssociateInfoService.fetchPositionOnManagerAssociateNo(request.getParameter("mgrAssociateId"));
			json.put("ASSOCIATE_NAME", assoInfo.getAssociateName());
			json.put("ASSOCIATE_TITLE", assoInfo.getAssociateTitle());
		}catch (Exception e) {
			_log.error(" ChangeOfStatusPortlet.getMgrAssociateNo  Error",e);	
			
		}finally{
			
		}
		out = response.getWriter();
		out.println(json);
	
	}

	/**
	 * 
	 * @param response
	 * @throws IOException
	 */
	public void fetchDeptNumberOnCos(ResourceRequest request,
			ResourceResponse response) throws IOException {
		try {
			
			HMAAssociateInfoService.fetchDeptNumberOnCos( request,response);
		} catch (Exception e1) {
			_log.error(" ChangeOfStatusPortlet.fetchDeptNumberOnCos  Error",e1);
		}finally{
		}
	}

	// Position ID for New POS
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void manageCosofPos(ActionRequest request, ActionResponse response)
			throws Exception {

		try {
			String positionId = request.getParameter("positionId");
			WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
					.getByPositionId(positionId);
			if (wfms_Position != null) {
				request.setAttribute("positionId", positionId);
				request.setAttribute("wfms_PositionObj", wfms_Position);
			}
		} catch (SystemException e) {
			_log.error(" ChangeOfStatusPortlet.manageCosofPos  Error",e);
		}
		response.setRenderParameter("jspPage",
				"/html/requisition/manageRequisition.jsp");
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws com.liferay.portal.kernel.json.JSONException
	 * @throws com.liferay.portal.kernel.json.JSONException 
	 */
	private void getServiceDetails(ResourceRequest request,ResourceResponse response) throws  IOException, JSONException,      
			com.liferay.portal.kernel.json.JSONException {
		  String deptName= request.getParameter("roleUuid"); 
		  CostCenterService costCenterService = new CostCenterService();
		  JSONObject jSONObject= costCenterService.userIsSameDepartment(deptName);
		  JSONObject jsonObjLiferayDept = JSONFactoryUtil.createJSONObject(jSONObject.toString());
		  String deptNameStr = jsonObjLiferayDept.getString("name");
		  JSONObject jsonObjLiferayManager = JSONFactoryUtil.createJSONObject(jSONObject.toString());
		  String manager = jsonObjLiferayDept.getString("manager");
		  JSONObject jsonObjLiferayNew = JSONFactoryUtil.createJSONObject(jSONObject.toString());
		  String deptLink = jsonObjLiferayNew.getString("u_department");
		  JSONObject jsonObjLiferayLink = JSONFactoryUtil.createJSONObject(deptLink.toString());
		  String urlLink = jsonObjLiferayLink.getString("link");
		  JSONObject deptObject = costCenterService.getResponseObject(urlLink, deptName,"u_division");
		   }
	/**
	 * 
	 * @param type
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws SystemException
	 * @throws PortalException 
	 * @throws JSONException 
	 */
	private static void getCOSList(String type, ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
												throws SystemException, PortalException {
		try{
	
			JSONObject json = DatagridDisplayManagerUtil.getCOSList(type,resourceRequest);
			PrintWriter writer = resourceResponse.getWriter();
			writer.print( json );
		}catch(IOException | com.liferay.portal.kernel.json.JSONException ioex){
			ioex.printStackTrace();
		}
	}

	
	public void cancelCOS(ActionRequest actionRequest,ActionResponse actionResponse) throws PortletException, IOException, SystemException{
		
		String cosid = actionRequest.getParameter("cosid");
		String comments = actionRequest.getParameter("comments");
		WFMS_COS wfms_COSList = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosid);
		
		 String url     =GenerateFrindlyURL.getCOSfrindlyURL(actionRequest,cosid);
		String emailSubject = "Change of Status "+cosid+" for "+wfms_COSList.getAssoicateId()+","+wfms_COSList.getAssociatename()+" that you previously approved as been cancelled.";
		String emailToName = "";
		String emailMessage = "This change of status has been cancelled.<br/> Cancellation comments: "+comments+" <br/> Click the below link to access the change of status.<br/><a href=" + url + "> Click here to review the record</a>";
		
		 String emailFromName = "Workforce_Management@hma.honda.com";
			String emailFromAddress = "Workforce_Management@hma.honda.com";
		try{
			if(wfms_COSList!=null){
				User  user=null;
				try {
					user = UserLocalServiceUtil.getUserById(wfms_COSList.getCompanyId());
				} catch (Exception e) {
					
				}
				String roleArray[] = wfms_COSList.getApproverList().split(",");
	        	 
	        	 String[] roleList = new String[roleArray.length];

	             for(int i=0; i < roleArray.length; i++){
	               if(!roleArray[i].trim().equals("")){	 
	            	 roleList[i] = roleArray[i].trim();
	               }
	             }
	        	 int approveStepID = wfms_COSList.getApproverStep();
	        	  String[] mailApproveusers = new String[approveStepID];
			        	  if(approveStepID >0){
			        	  for(int j=0; j < approveStepID; j++){
			        		  mailApproveusers[j] = roleArray[j].trim();
			        	  }}
	        	  if(mailApproveusers.length > 0 ){
	        		 String roleType = ""; 
	        		 String AsscbasedDept="";
	        		   for(String mailuser:mailApproveusers){
	        			 roleType = mailuser;
	        			 
	        			 if(roleType.equals(HondaPermissionKeys.COS_CURRENT_DM)){
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, wfms_COSList.getCurrentDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							 
						 }if(roleType.equals(HondaPermissionKeys.COS_CURRENT_DVM)){
	        				 
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, wfms_COSList.getCurrentDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							
	        			 }if(roleType.equals(HondaPermissionKeys.COS_NEW_DM)){
							 
							 if(wfms_COSList.getNewJobCode().equals("PA") || wfms_COSList.getNewJobCode().equals("TC") || wfms_COSList.getNewPositionNumber().equals("None")){
								 AsscbasedDept = wfms_COSList.getSameDept();
							 }else{
								 AsscbasedDept = wfms_COSList.getNewDepartmentNumber();
							 }
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, AsscbasedDept, actionRequest, emailSubject, emailMessage);
	        			 }if(roleType.equals(HondaPermissionKeys.COS_NEW_DVM)){
							 
							 if(wfms_COSList.getNewJobCode().equals("PA") || wfms_COSList.getNewJobCode().equals("TC") || wfms_COSList.getNewPositionNumber().equals("None")){
								 AsscbasedDept = wfms_COSList.getSameDept();
							 }else{
								 AsscbasedDept = wfms_COSList.getNewDepartmentNumber();
							 }
							 
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, AsscbasedDept, actionRequest, emailSubject, emailMessage);

			        	}if(roleType.equals(HondaPermissionKeys.COS_HR_DM)){
			        			 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_HRDM,"", actionRequest, emailSubject, emailMessage);

       					}	
        				if(roleType.equals(HondaPermissionKeys.COS_OPS_LEADER)){
        					 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_OPS_LEADER,"", actionRequest, emailSubject, emailMessage);
        				}	
	        			if(roleType.equals(HondaPermissionKeys.COS_CMP)){
	        				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP,"", actionRequest, emailSubject, emailMessage);

	        			}
	        			if(roleType.equals(HondaPermissionKeys.COS_SP_DM)){
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM,"", actionRequest, emailSubject, emailMessage);

	        			}				        				
		        		if(roleType.equals(HondaPermissionKeys.COS_ARL_OA)){
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_ARL_OA,"", actionRequest, emailSubject, emailMessage);		  
		        		}  
		         		
	        	  }
	        	  }
	        	  else if(HondaPermissionKeys.COS_DRAFT.equalsIgnoreCase(wfms_COSList.getStatus())){
				     if(wfms_COSList.getSystemGenerated()==1  ){
						 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,"", actionRequest, emailSubject, emailMessage);

				     }
				     else if( wfms_COSList.getSystemGenerated()==2){
				    	 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,wfms_COSList.getCurrentDepartmentNumber(), actionRequest, emailSubject, emailMessage);

				     }
				else{
							 if("true".equalsIgnoreCase(configuration.get("mail.config.verify"))){
								 
								 emailSubject = user.getFullName()+": Change of Status "+cosid+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" that you previously approved as been cancelled.";
								 emailMessage = "This change of status has been cancelled.<br/> Cancellation comments: "+comments+" <br/> Click the below link to access the change of status.<br/><a href=" + url + "> Click here to review the record</a>";

						        EmailUtility.sendEmail(emailFromName, emailToName, emailFromAddress,  user.getEmailAddress(), emailSubject, emailMessage);
						 }
						 else{
							 emailSubject = user.getFullName()+": Change of Status "+cosid+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" that you previously approved as been cancelled.";
							 emailMessage = "This change of status has been cancelled.<br/> Cancellation comments: "+comments+" <br/> Click the below link to access the change of status.<br/><a href=" + url + "> Click here to review the record</a>";

								 EmailUtility.sendEmail(emailFromName, emailToName, emailFromAddress, user.getEmailAddress(), emailSubject, emailMessage);	
						 }	 
				
				}
	        	  }
	         	  else if(HondaPermissionKeys.COS_SUBMIT.equalsIgnoreCase(
	         			  wfms_COSList.getStatus())){
					     if(wfms_COSList.getSystemGenerated()==1 ||  wfms_COSList.getSystemGenerated()==2 ){
							 if("true".equalsIgnoreCase(configuration.get("mail.config.verify"))){
									 emailSubject = user.getFullName()+": Change of Status "+cosid+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" that you previously approved as been cancelled.";
										 emailMessage = "This change of status has been cancelled.<br/> Cancellation comments: "+comments+" <br/> Click the below link to access the change of status.<br/><a href=" + url + "> Click here to review the record</a>";

							 EmailUtility.sendEmail(emailFromName, emailToName, emailFromAddress, user.getEmailAddress(), emailSubject , emailMessage);
							 }
							 else{
								 if( user != null && Validator.isNotNull(user.getEmailAddress()))
									 emailSubject = user.getFullName()+": Change of Status "+cosid+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" that you previously approved as been cancelled.";
							    	 emailMessage = "This change of status has been cancelled.<br/> Cancellation comments: "+comments+" <br/> Click the below link to access the change of status.<br/><a href=" + url + "> Click here to review the record</a>";

									 EmailUtility.sendEmail(emailFromName, emailToName, emailFromAddress, user.getEmailAddress(), emailSubject, emailMessage);	
							 }	 
					}
					else{
						 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,"", actionRequest, emailSubject, emailMessage);
					}
		        	  }
				wfms_COSList.setStatus(HondaPermissionKeys.COS_CANCELLED);
				wfms_COSList.setNextApprover("");
				WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_COSList);
				HondaLogicUtil.auditLogsForReqAndCOS(cosid, WorkflowConstants.CHANGE_OF_STATUS_CANCEL, WorkflowConstants.CHANGE_OF_STATUS_ACTION, actionRequest, comments);
				 WFMS_Requisition req_update=null;
						try {
			     req_update = WFMS_RequisitionLocalServiceUtil.findBypositionassociate(wfms_COSList.getNewPositionNumber(), wfms_COSList.getAssoicateId());
		
		} catch (Exception e) {
			
		}
		if(req_update!=null){
				 req_update.setStatus(HondaPermissionKeys.REQ_WAITINGONMANPOWER);
				 req_update.setWorkflowStep(40);
				 req_update.setNextapprove(StringUtil.merge(HondaLogicUtil.listOfrolseusers("",actionRequest,HondaPermissionKeys.ROLE_STAFFING), "<br/>"));
				 req_update.setAssociatename(StringPool.BLANK);
				 req_update.setAssociatenumber(StringPool.BLANK);
				 WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(req_update);
				String rid=req_update.getRwfId();
				emailSubject ="Staffing: Manpower Requisition "+rid+"  is now waiting on manpower.";				
				emailMessage = "This requisition "+rid+"  has been submitted and needs to be filled. Click the below link to access the requisition.";
				 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, rid);
				emailMessage = emailMessage +". <br/><p><a href='"+url+"'>Click here to review the record</a></p>";
				EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,null, actionRequest, emailSubject, emailMessage);
			}}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
        	if(wfms_COSList.getSystemGenerated() == 2){
        	    ModifyPositionWFHelper.revertPosOnDisapproveCos(wfms_COSList.getPositionNumber()); 
        	}
        }
	
	}
	
	public void fetchAssociateId(ResourceRequest request, ResourceResponse response)
			throws Exception {
		PrintWriter out = null;
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			String associateNumber = request.getParameter("associateNumber");
						WFMS_COS wfms_cos=WFMS_COSLocalServiceUtil.findByassociateId(associateNumber);
			if (wfms_cos != null) {
			
				json.put("error", true);
			
				out= response.getWriter();
				out.println(json);
			}
		} catch (Exception e) {
			
			json.put("error", false);
			out= response.getWriter();
			out.println(json);
			
		}
	}
	
	public String fetchAssociateNumber(String associateID)
			throws Exception {

		    DynamicQuery dynamicQueryForcos =WFMS_COSLocalServiceUtil.dynamicQuery();
			dynamicQueryForcos.add(PropertyFactoryUtil.forName("assoicateId").eq(associateID));
			dynamicQueryForcos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
			Criterion reqcriterion = null;
			reqcriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT);
			reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,
					RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DRAFT));			
			dynamicQueryForcos.add(reqcriterion);
			Long coslistsize = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForcos);
			if (coslistsize == 0 ) {
                return "";
			}
			
			return associateID	;			
		
		
		
	}

	public void approveCOS(ActionRequest request,ActionResponse response){
		String cosID = request.getParameter("cosId");
		String comments = request.getParameter("comments");
		WFMS_COS wfms_cos = null;
		Date createdate = new Date();
	
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
       String emailMessage="";
        String emailSubject = "";
		String userFullName ="";
		 String url="";
			if(cosID!=null){
				
				 
				wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosID);
				String[] roleArray = null;
				
				List<String> adminList= new ArrayList<String>();
				List<Role> listofRoles= RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
				for(Role val:listofRoles){
					if(val.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_Administrator)||
							val.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM) ||val.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_CMP) ||
							val.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_HRDM) ){
						adminList.add(val.getName());
					}
				}
				
			
				 wfms_cos=checklist(wfms_cos);
				 wfms_cos=findDuplicateUser(wfms_cos, adminList);
					
			 	if( wfms_cos.getSortApprovedList().equalsIgnoreCase(wfms_cos.getApproverList())) roleArray= wfms_cos.getApproverList().split(",");
					else roleArray = wfms_cos.getSortApprovedList().split(",");
				//roleArray= wfms_cos.getApproverList().split(",");			
				  List<String> listofArray1 = Arrays.asList(roleArray);
             
	        	 String[] roleList = new String[roleArray.length];
	            
	             for(int i=0; i < roleArray.length; i++){
	               if(!roleArray[i].trim().equals("")){	 
	            	 roleList[i] = roleArray[i].trim();
	             }
	             }
	        	 int approveStepID = wfms_cos.getApproverStep();
	        	 String listvalue=StringPool.BLANK;

	        	List<String>  nextapproverlist=null;
	        	 String roleListvalue = "";
	        	 int workflowIncrement = approveStepID+1;
	        	 try {
               	  listvalue=listofArray1.get(workflowIncrement);
             	} 
				catch (Exception e) {
				}
	        	  String[] mailApproveusers = new String[approveStepID];
			        	  if(approveStepID >0){
				        	  for(int j=0; j < approveStepID; j++){
				        		  mailApproveusers[j] = roleArray[j].trim();
				        	  }
			        	  }
			        	  String emailFromName = "Workforce_Management@hma.honda.com";
			      		  String emailFromAddress = "Workforce_Management@hma.honda.com";
			      		  
			      		  
			      		
	        	  if(Validator.isNotNull(listvalue)){
		        		 String roleType = ""; 
		        		 String AsscbasedDept = "";
		        		 url     =GenerateFrindlyURL.getCOSfrindlyURL(request,cosID);
		        			 roleType = roleList[workflowIncrement];
		        			 wfms_cos = WFMS_COSLocalServiceUtil.getByCOSId(cosID);
		        			 Map<String, String> costmap=null;
		        			 if(roleType.equals(HondaPermissionKeys.COS_CURRENT_DM)){
		        				 costmap = HondaLogicUtil.singleCallOnServieNow(wfms_cos.getCurrentDepartmentNumber());
		        				 wfms_cos.setNextApprover(costmap.get("deptMgrName"));
							     emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
								 emailSubject = "Department Manager: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
									EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, wfms_cos.getCurrentDepartmentNumber(), request, emailSubject, emailMessage);
		        			 }
		        			 if(roleType.equals(HondaPermissionKeys.COS_CURRENT_DVM)){
		        				 costmap = HondaLogicUtil.singleCallOnServieNow(wfms_cos.getCurrentDepartmentNumber());
		        				 wfms_cos.setNextApprover(costmap.get("divMgrName"));
							  	 emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
								 emailSubject = "Division Manager: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
									EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, wfms_cos.getCurrentDepartmentNumber(), request, emailSubject, emailMessage);
								
		        			 }
		        			 if(roleType.equals(HondaPermissionKeys.COS_NEW_DM)){

		        				  if(wfms_cos.getNewJobCode().equals("PA") || wfms_cos.getNewJobCode().equals("TC") || wfms_cos.getNewPositionNumber().equals("None")){
									 AsscbasedDept = wfms_cos.getSameDept();
								 }else{
									 AsscbasedDept = wfms_cos.getNewDepartmentNumber();
								 }
		        				     costmap = HondaLogicUtil.singleCallOnServieNow(AsscbasedDept);
			        				 wfms_cos.setNextApprover(costmap.get("deptMgrName"));
								    emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Click here to review the record </a>";
									 emailSubject = "Department Manager: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
									
									EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, AsscbasedDept, request, emailSubject, emailMessage);

								 }
		        			 if(roleType.equals(HondaPermissionKeys.COS_NEW_DVM)){
									
								 if(wfms_cos.getNewJobCode().equals("PA") || wfms_cos.getNewJobCode().equals("TC") || wfms_cos.getNewPositionNumber().equals("None")){
									 AsscbasedDept = wfms_cos.getSameDept();
								 }else{
									 AsscbasedDept = wfms_cos.getNewDepartmentNumber();
								 }
								 costmap = HondaLogicUtil.singleCallOnServieNow(AsscbasedDept);
		        				 wfms_cos.setNextApprover(costmap.get("divMgrName"));
								
	        				 emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Click here to review the record </a>  ";
							 emailSubject = "Division Manager: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
							
	        				 
								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, AsscbasedDept, request, emailSubject, emailMessage);
							
				        	}
									if(roleType.equals(HondaPermissionKeys.COS_OPS_LEADER)){
										
										 nextapproverlist=	 listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_OPS_LEADER);
								if(nextapproverlist!=null)		  wfms_cos.setNextApprover(StringUtil.merge(nextapproverlist, StringPool.COMMA));
			        					 emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Click here to review the record</a>";
										 emailSubject = "Ops Leader: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
										 
										 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_OPS_LEADER,"", request, emailSubject, emailMessage);
			        				}	
		        			 if(roleType.equals(HondaPermissionKeys.COS_HR_DM)){
		        			  	 nextapproverlist= listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_HRDM);
		        			  	if(nextapproverlist!=null)		  wfms_cos.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
				        		 emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Click here to review the record </a>  ";
								 emailSubject = "HR Department Manager: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
								 
								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_HRDM,"", request, emailSubject, emailMessage);

	       					}	
	        			
		        			if(roleType.equals(HondaPermissionKeys.COS_CMP)){
		        				 nextapproverlist=	 listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_CMP);
		        				 if(nextapproverlist!=null)		  wfms_cos.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
		        				 emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Click here to review the record </a>";
								 emailSubject = "Company Manpower Controller: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
								
								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP,"", request, emailSubject, emailMessage);

		        			}
		        			if(roleType.equals(HondaPermissionKeys.COS_SP_DM)){
		        				 nextapproverlist=	 listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_SPDM);
		        				 if(nextapproverlist!=null)		  wfms_cos.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
		        				 emailMessage="This change of status has been submitted and needs your approval.<br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Click here to review the record </a>";
								 emailSubject = " SP Department Manager: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
								
								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM,"", request, emailSubject, emailMessage);

		        			}				        				
			        		if(roleType.equals(HondaPermissionKeys.COS_ARL_OA)){
			        			 nextapproverlist= listOfrolseusers(cosID, request, HondaPermissionKeys.ROLE_ARL_OA);
			        			 if(nextapproverlist!=null)		  
			        				 wfms_cos.setNextApprover(StringUtil.merge(nextapproverlist,StringPool.COMMA));
			        			 
			        			 emailMessage="This change of status has been submitted and needs your approval. <br/> Click the below link to access the change of status.<br/> <a href=" + url + ">Click here to review the record</a>";
								 emailSubject = " ARL OA: Change of Status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been submitted for your approval.";
								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_ARL_OA,"", request, emailSubject, emailMessage);		  

			        		} 
		        	  }
	        	//  }
	        	  
    	  if(roleList.length == workflowIncrement || Validator.isNull(listvalue)){
  		    wfms_cos.setApproverStep(-1);
  		    wfms_cos.setWorkflowStep(-1);
  		    wfms_cos.setStatus(HondaPermissionKeys.COS_APPROVED);
  		    wfms_cos.setNextApprover("");
  		    wfms_cos.setRoleOfApprover("");
  		  String nofiticationArray[] =wfms_cos.getNotificationTo().split(",");
  	   	   List<String> listofArrayOfNotication = Arrays.asList(nofiticationArray);
  	   	String   urlApproved     =GenerateFrindlyURL.getCOSfrindlyURL(request,cosID);
  	 
  	   	   for(String value:listofArrayOfNotication){
  	   		   _log.info("Notification Roll Name:"+value);
  	   		   emailMessage="This Change of status has been Approved.<br/> Click the below link to access the Change of status. <br/> <a href=" + urlApproved + ">Click here to review the record </a>";	 
  	   		   if(value.equalsIgnoreCase(HondaPermissionKeys.ROLE_CAC)){
  	   			  emailSubject = "CAC: Change of status. "+cosID+" for ["+ wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+"  has been Approved .";
  				  EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CAC,"", request, emailSubject, emailMessage);
  				
  	   		   }
  	   		   else if(value.equalsIgnoreCase(HondaPermissionKeys.ROLE_PAYROLL) || value.equalsIgnoreCase(HondaPermissionKeys.ROLE_PR)){
  	   			// emailMessage="This Change of status has been Approved.<br/> Click the below link to access the Change of status. <br/> <a href=" + urlApproved + ">Click here to review the record </a>";
  				 emailSubject = "Payroll: Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
  				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_PAYROLL,"", request, emailSubject, emailMessage);
  				 
  	   		   }
  	   		   else if(value.contains(HondaPermissionKeys.ROLE_DMP)){
  	   			 String newdeptid=StringPool.BLANK;
	  	   			 if(wfms_cos.getNewJobCode().equals("PA") || wfms_cos.getNewJobCode().equals("TC") || wfms_cos.getNewPositionNumber().equals("None")){
	  	   				newdeptid = wfms_cos.getSameDept();
	  	   				
	  				 }else{
	  					 newdeptid = wfms_cos.getNewDepartmentNumber();
	  				 }
  	   			 if(value.length()>4){
  	    			 
  	  	   			 emailSubject = "Department Manpower Controller: Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
  	  				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,wfms_cos.getCurrentDepartmentNumber(), request, emailSubject, emailMessage);
  	  				 
  	  				// emailSubject = "Department Manpower Controller: Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
  	  				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,newdeptid, request, emailSubject, emailMessage);
  	  				 
  	   				 
  	   			 } else{
  	   			     emailSubject = "Department Manpower Controller: Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
	  				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,newdeptid, request, emailSubject, emailMessage);
	  		
  	   			 }
  	 
  	 		   }
  	   		   else if(value.equalsIgnoreCase(HondaPermissionKeys.ROLE_CMP)){
  	   			 emailSubject =  "Company Manpower Controller:Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
  				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP,"", request, emailSubject, emailMessage);
  				  
  	 		   }
  	   		   else if(value.equalsIgnoreCase(HondaPermissionKeys.ROLE_STAFFING)){
 	   			 emailSubject =  "Staffing : Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
 				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,"", request, emailSubject, emailMessage);			  
 	 		   }else if(value.equalsIgnoreCase(HondaPermissionKeys.ROLE_PR_Notify)){
 	 			 emailSubject =  "PR Notify : Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
 	 			EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_PR_Notify,"", request, emailSubject, emailMessage);
 	 		   }
  	   	   }

  	  		    if(wfms_cos.getSystemGenerated() == 2 || wfms_cos.getSystemGenerated() == 1){
  	  		    	
  	  		         emailMessage="This Change of status has been Approved.<br/> Click the below link to access the Change of status. <br/> <a href=" + urlApproved + ">Click here to review the record </a>";
	  				 emailSubject = "Staffing : Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
	  				 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,"", request, emailSubject, emailMessage);	  	  			
	  			
  	  		    }
  	  		  
  	  		    else{	
  	  		    	
  	  		    	User user=null;
		  	  		    try {
		  	  			 user = UserLocalServiceUtil.getUserById(wfms_cos.getCompanyId());
		
					} catch (Exception e) {
						
					}
				
	  		    		 emailMessage="This Change of status has been Approved.<br/> Click the below link to access the Change of status. <br/> <a href=" + urlApproved + ">Click here to review the record </a>";
	  					 emailSubject = user.getFullName()+ ": Change of status "+cosID+" for ["+wfms_cos.getAssoicateId()+"] "+wfms_cos.getAssociatename()+" has been Approved.";
	  				 if("true".equalsIgnoreCase(configuration.get("mail.config.verify"))){
					     EmailUtility.sendEmail(emailFromName, "", emailFromAddress, user.getEmailAddress(), emailSubject, emailMessage);
					 }
					 else{
						 if( user != null && Validator.isNotNull(user.getEmailAddress()))
							 EmailUtility.sendEmail(emailFromName, "", emailFromAddress, user.getEmailAddress(), emailSubject, emailMessage);	
					 }	
	  		//    ModifyPositionWFHelper.callModifyPositionOnCos(26, wfms_cos.getPositionNumber()); 
	  		    }
  	  		    HondaLogicUtil.auditLogsForReqAndCOS(cosID, WorkflowConstants.CHANGE_OF_STATUS_APPROVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request,comments);
  	  		    TimeUnit.SECONDS.sleep(1);
		        checklog(wfms_cos,request);
  		    
  		    WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_cos);	

				
    	  }else {
    		  
				roleListvalue = roleList[workflowIncrement];  
				if(roleListvalue.equals(HondaPermissionKeys.COS_CMP)){
	        		roleListvalue = HondaPermissionKeys.ROLE_CMP;
	        	}
				
	      		  wfms_cos.setRoleOfApprover(roleListvalue);
		        	  wfms_cos.setApproverStep(workflowIncrement);
		        	  wfms_cos.setWorkflowStep(10);
		        	  WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_cos);
		        	  HondaLogicUtil.auditLogsForReqAndCOS(cosID, WorkflowConstants.CHANGE_OF_STATUS_APPROVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request,comments);
		        	  TimeUnit.SECONDS.sleep(1);
					  checklog(wfms_cos,request);
		  }
    	  
    	  		wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosID);
			 	if(wfms_cos.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){
			 		
			 		String associateTitle=wfms_cos.getNewJobCode();
			 		String assocNumber = wfms_cos.getAssoicateId();
			 		DynamicQuery dynamicQueryForExistPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
			 			dynamicQueryForExistPosition.add(PropertyFactoryUtil.forName("associateNumber").eq(assocNumber));
			 			List<WFMS_Position> existPositionsList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQueryForExistPosition);
		if(!wfms_cos.getNewJobCode().equals("PA") && !wfms_cos.getNewJobCode().equals("TC")){
		String wfms_pid=wfms_cos.getNewPositionNumber();

			DynamicQuery dynamicQueryForPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
			dynamicQueryForPosition.add(PropertyFactoryUtil.forName("pId").eq(wfms_pid));
			Long positionsList = WFMS_PositionLocalServiceUtil.dynamicQueryCount(dynamicQueryForPosition);
	if(existPositionsList.size()>0 || positionsList>0){
		
		String existposid="";
		String newposid="";
		String newreqid="";
		DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
		dynamicQueryForCos.add(PropertyFactoryUtil.forName("assoicateId").eq(assocNumber));
		List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
		String cosId="";
		 if(cosList.size()>0){
			 cosId=cosList.get(0).getCosId();
	     }
		AssociateInformation assObj=HMAAssociateInfoService.fetchPositionOnAssociateNumber(assocNumber);
		String associateName =assObj.getAssociateName();
		String filledPosForCOS = StringPool.BLANK;
		
		String mpCatFilledWith="";
		if(existPositionsList.size()>0){
			
			
				String existPositionId=existPositionsList.get(0).getPId();
				existposid=existPositionId;
				WFMS_Position exist_wfms_postion = null;
			    exist_wfms_postion = WFMS_PositionLocalServiceUtil.fetchWFMS_Position(existPositionId);
				associateName =exist_wfms_postion.getAssociateName();
				mpCatFilledWith =exist_wfms_postion.getMpCatFilledWith();
				if(exist_wfms_postion.getAutoGenerateReq().equalsIgnoreCase("true"))
					request.setAttribute("redirectTo", "requisition");
				else
					request.setAttribute("redirectTo", "Position");
				exist_wfms_postion.setAssociateName("");
				exist_wfms_postion.setAssociateTitle("");
				exist_wfms_postion.setMpCatFilledWith("");
				exist_wfms_postion.setAssociateNumber("");
				exist_wfms_postion.setStatus(HondaPermissionKeys.POS_OPEN);
				exist_wfms_postion.setModifiedDate(createdate);
				exist_wfms_postion.setModifiedBy(userFullName);
				exist_wfms_postion.setWorkflowStep(-1);
				WFMS_PositionLocalServiceUtil.updateWFMS_Position(exist_wfms_postion);
				//Audit log insert
				
				HondaLogicUtil.auditLogsForPosition(existPositionId, assocNumber, WorkflowConstants.POSITION_MOVE_ASSOCIATE, WorkflowConstants.POSITION_ACTOIN, request,"");
				HondaLogicUtil.auditLogsForPosition(existPositionId, "", HondaPermissionKeys.POS_OPEN, WorkflowConstants.POSITION_ACTOIN, request,"");
				
				if(!cosId.equals("")){
				 HondaLogicUtil.auditLogsForReqAndCOS(cosId, WorkflowConstants.POSITION_MOVE_ASSOCIATE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, "Position "+existPositionId+" move to "+HondaPermissionKeys.POS_OPEN);
				}
				if(exist_wfms_postion.getAutoGenerateReq().equalsIgnoreCase("true")){
				WFMS_Requisition entry = null;
				long posid = (CounterLocalServiceUtil.increment(WFMS_Position.class.getName()));
				String id = "";
				if(Validator.isNotNull(exist_wfms_postion.getDepartmentNumber())){
				 id=HondaLogicUtil.geneateRequisitionId(exist_wfms_postion.getDepartmentNumber());
				} 
				newreqid=id;
				entry.setRwfId(id);
				entry.setStatus(HondaPermissionKeys.POS_DRAFT);
				entry.setRId(exist_wfms_postion.getPId());
			//	wfms_cos.getPositionNumber()
			
				entry.setCreateDate(createdate);
				entry.setDummy("0");
				Map<String, String>	hondamap=null;
				if(Validator.isNotNull(exist_wfms_postion.getDepartmentNumber())){
					hondamap=HondaLogicUtil.singleCallOnServieNow(exist_wfms_postion.getDepartmentNumber());
					}
					entry.setNextapprove(hondamap.get("mpwrrep_name"));
				if(!wfms_cos.getPositionNumber().equalsIgnoreCase(wfms_cos.getNewPositionNumber())){
				WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(entry);
				HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, request, exist_wfms_postion.getComments());
				}			
				 emailMessage="This Requisition is Created, please click below link to proceed further";
				 emailSubject = "Notification: Hello "+HondaPermissionKeys.ROLE_DMP+" this Requisition "+id+" is Created";
				 url=GenerateFrindlyURL.getURLForRequisition( request, id);
				emailMessage = emailMessage +"<br/><a href='"+url+"'>Click here to review the record</a>";
				EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP, wfms_cos.getNewDepartmentNumber(), request, emailSubject, emailMessage);
				//HondaLogicUtil.auditLogsForReqAndCOS(id, WorkflowConstants.REQUISITION_CREATE, WorkflowConstants.REQUISITION_ACTION, request , "");
				
				WFMS_RequisitionLocalServiceUtil.clearCache();
				PortletSession session = request.getPortletSession();
				request.setAttribute("reqcid", id);
				session.setAttribute("posid", posid,PortletSession.APPLICATION_SCOPE);
		      }
				if(positionsList==0){
				 HondaLogicUtil.auditLogsForAssociateHistory(assocNumber,"Moved from position "+exist_wfms_postion.getPId()+" to position none","", request);
				}
				    
		}
		if(positionsList>0){
			
			newposid=wfms_pid;
			
				WFMS_Position wfms_postion = null;
				
				
				filledPosForCOS=associateName+StringPool.SPACE+StringPool.OPEN_BRACKET+assocNumber+StringPool.CLOSE_BRACKET+StringPool.SPACE+" has Filled for this position "+StringPool.SPACE;
				        wfms_postion =WFMS_PositionLocalServiceUtil.findByposition(wfms_pid);
						wfms_postion.setAssociateTitle(associateTitle);
						wfms_postion.setAssociateName(associateName);
						if(Validator.isNotNull(mpCatFilledWith)){
							wfms_postion.setMpCatFilledWith(mpCatFilledWith);
						}
					
						
						wfms_postion.setAssociateNumber(assocNumber);
						wfms_postion.setModifiedDate(createdate);
						wfms_postion.setModifiedBy(userFullName);
						wfms_postion.setNextApprover("");
						
						wfms_postion.setStatus(HondaPermissionKeys.POS_FILLED);
						WFMS_PositionLocalServiceUtil.updateWFMS_Position(wfms_postion);
						
						   DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
							wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(wfms_pid+"-WFM"));
							Long wfmPositionforTempcount = WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);	
							if(wfmPositionforTempcount > 0){
							    WFMS_PositionLocalServiceUtil.deleteWFMS_Position(wfms_pid+"-WFM");
							}
						DynamicQuery dynamicQueryForReq = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
						dynamicQueryForReq.add(PropertyFactoryUtil.forName("rId").eq(wfms_pid));
						dynamicQueryForReq.add(PropertyFactoryUtil.forName("associatenumber").eq(assocNumber));
						Long reqsList = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForReq);
						if(reqsList!=0){
							String req_id = null;
						WFMS_Requisition req_update = WFMS_RequisitionLocalServiceUtil.findBypositionassociate(wfms_pid, assocNumber);
						req_id = req_update.getRwfId();
						req_update.setStatus(HondaPermissionKeys.REQ_COMPLETE);
						req_update.setNextapprove("");
						WFMS_RequisitionLocalServiceUtil.updateWFMS_Requisition(req_update);
						HondaLogicUtil.auditLogsForReqAndCOS(wfms_cos.getNewPositionNumber(),
								WorkflowConstants.REQUISITION_COMPLETE,
								WorkflowConstants.REQUISITION_ACTION, request, "");
						}
						if(!existposid.equals("")){
							HondaLogicUtil.auditLogsForAssociateHistory(assocNumber,"Moved from position "+existposid+" to position "+wfms_pid,wfms_pid, request);
							HondaLogicUtil.auditLogsForPositionwithTwoPid(wfms_pid, assocNumber, existposid, WorkflowConstants.POSITION_MOVE_ASSOCIATE, WorkflowConstants.POSITION_ACTOIN, request);
						}else{
						   HondaLogicUtil.auditLogsForPosition(wfms_pid, assocNumber, WorkflowConstants.POSITION_MOVE_ASSOCIATE, WorkflowConstants.POSITION_ACTOIN, request,"");
						   HondaLogicUtil.auditLogsForAssociateHistory(assocNumber,"Moved to direct position "+wfms_pid, "",request);
						}
						HondaLogicUtil.auditLogsForPosition(wfms_pid,  assocNumber,filledPosForCOS, WorkflowConstants.POSITION_ACTOIN, request,"");
						
						
		if(!cosId.equals("")){
			// HondaLogicUtil.auditLogsForReqAndCOS(cosId, WorkflowConstants.POSITION_MOVE_ASSOCIATE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, "Position "+wfms_pid+" move to "+HondaPermissionKeys.POS_FILLED);
		}
		
		}
	   
		PositionPortlet portlet = new PositionPortlet();
		request.setAttribute("associateId", wfms_cos.getAssoicateId());
		request.setAttribute("existposid", existposid);
		request.setAttribute("newposid", newposid);
		request.getPortletSession().setAttribute("fromCosPortlet", "fromCosPortlet");
		/*if(!existposid.equalsIgnoreCase("")){
			if(!newreqid.equals("")){
			    
			if(!wfms_cos.getPositionNumber().equalsIgnoreCase(wfms_cos.getNewPositionNumber())){
				Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/requisition");
				PortletURL portletURL = PortletURLFactoryUtil.create(request,"WMSRequisition_WAR_HMAWorkforceManagementSystemportlet",layout.getPlid(), RenderRequest.RENDER_PHASE);        
			    response.sendRedirect(portletURL.toString());
			}
			else{
				response.sendRedirect(GenerateFrindlyURL.renderManagePosition(request));
			}
			}
			
			else{
				
			//	_log.info(existposid);
			Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
			PortletURL portletURL = PortletURLFactoryUtil.create(request,"WFMPosition_WAR_HMAWorkforceManagementSystemportlet",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
			portletURL.setWindowState(WindowState.NORMAL);
			//portletURL.setParameter("autoReqAfterTerminate", "autoreqModal");
			portletURL.setParameter(ActionRequest.ACTION_NAME,"editPosition");
			portletURL.setParameter("positionId",existposid);
			response.sendRedirect(portletURL.toString());
			}
		}
		else{
				if(!newposid.equalsIgnoreCase("")){
					
					Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
					PortletURL portletURL = PortletURLFactoryUtil.create(request,"WFMPosition_WAR_HMAWorkforceManagementSystemportlet",layout.getPlid(), ActionRequest.ACTION_PHASE);
					portletURL.setWindowState(WindowState.NORMAL);
					portletURL.setParameter(ActionRequest.ACTION_NAME,"editPosition");
					portletURL.setParameter("positionId",newposid);
					response.sendRedirect(portletURL.toString());
				}
				else{
					wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosID);
					if(wfms_cos !=null){
							request.setAttribute("cosId", cosID);
							request.setAttribute("wfms_CosObj", wfms_cos);
							request.setAttribute("AssociateNumber", wfms_cos.getAssoicateId());
							response.setRenderParameter("jspPage",	"/html/changeOfStatus/manageCOS.jsp");
					}
				}
		}*/
	 }
	}
	else if(wfms_cos.getNewJobCode().equals("PA") || wfms_cos.getNewJobCode().equals("TC")){
				
			request.setAttribute("associateId", wfms_cos.getAssoicateId());
			PositionPortlet portlet = new PositionPortlet();
			request.getPortletSession().setAttribute("fromCosPortlet", "fromCosPortlet");
			if(existPositionsList.size()>0){
					String existPositionId=existPositionsList.get(0).getPId();
			        HondaLogicUtil.auditLogsForAssociateHistory(assocNumber,"Moved to direct from position "+existPositionId,"", request);
			}
			else{
				HondaLogicUtil.auditLogsForAssociateHistory(assocNumber,"Moved to direct","", request);
			}

			portlet.terminateAssociate(request, response);
			}
			else{
					/*wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosID);
					if(wfms_cos !=null){
							request.setAttribute("cosId", cosID);
							request.setAttribute("wfms_CosObj", wfms_cos);
							request.setAttribute("AssociateNumber", wfms_cos.getAssoicateId());
							response.setRenderParameter("jspPage",	"/html/changeOfStatus/manageCOS.jsp");
					}*/
			}
			 }
			 	
			 	else {
			     response.sendRedirect(GenerateFrindlyURL.renderManageCOS(request));
		}	 	
			}
		}catch(Exception e){
			//_log.error("[approveCOS]" +e);
		}
	}
	
	public void disapproveCos(ActionRequest actionRequest,ActionResponse actionResponse) throws PortletException, IOException, SystemException, PortalException{

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
		String emailSubject = "";
		String emailMessage = "";

        String comments = actionRequest.getParameter("Comments");
        String changeofstatusId = actionRequest.getParameter("cosId");
        WFMS_COS wfms_COSList = WFMS_COSLocalServiceUtil.fetchWFMS_COS(changeofstatusId);
        
        String emailFromName = "Workforce_Management@hma.honda.com";
		String emailFromAddress = "Workforce_Management@hma.honda.com";
        actionRequest.setAttribute("positionId", changeofstatusId);
        User user =null;
        try{
            if(changeofstatusId!=null){
             if(Validator.isNotNull(wfms_COSList.getCompanyId()))  
            	 try {
                	 user = UserLocalServiceUtil.getUserById(wfms_COSList.getCompanyId());

				} catch (Exception e) {
					// TODO: handle exception
				}
                //long companyId = user.getCompanyId();                
                
                String roleArray[] = wfms_COSList.getApproverList().split(",");
	        	 
	        	 String[] roleList = new String[roleArray.length];
	            
	             for(int i=0; i < roleArray.length; i++){
	               if(!roleArray[i].trim().equals("")){	 
	            	 roleList[i] = roleArray[i].trim();
	             }
	             }
	        	 int approveStepID = wfms_COSList.getApproverStep();
	        	 
        	 
	        	 String roleListvalue = "";
	        	 int workflowIncrement = approveStepID+1;
	        	  
	        	  String[] mailApproveusers = new String[approveStepID];
	        	  
			        	  if(approveStepID >0){
			        	  for(int j=0; j < approveStepID; j++){
			        		  if(!(mailApproveusers[j]==Integer.toString(approveStepID))){
			        		  mailApproveusers[j] = roleArray[j].trim();}
			        	  }}
	        	  
	        	  if(mailApproveusers.length > 0 ){
	        		 String roleType = ""; 
	        		 String Manager_email= "";
	        		 String AsscbasedDept= "";
	        		 String url     =GenerateFrindlyURL.getCOSfrindlyURL(actionRequest,changeofstatusId);
	        		   for(String mailuser:mailApproveusers){
	        			 roleType = mailuser;
	        			 
	        			 if(roleType.equals(HondaPermissionKeys.COS_CURRENT_DM)){
	        				 
							 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/>  Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a> ";
							 emailSubject = "Department Manager Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
							 	 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, wfms_COSList.getCurrentDepartmentNumber(), actionRequest, emailSubject, emailMessage);
	        					 }if(roleType.equals(HondaPermissionKeys.COS_CURRENT_DVM)){

	 						 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a> ";
							 emailSubject = "Division Manager Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";

								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, wfms_COSList.getCurrentDepartmentNumber(), actionRequest, emailSubject, emailMessage);

							
	        			 }if(roleType.equals(HondaPermissionKeys.COS_NEW_DM)){
	        					
							 if(wfms_COSList.getNewJobCode().equals("PA") || wfms_COSList.getNewJobCode().equals("TC") || wfms_COSList.getNewPositionNumber().equals("None")){
								 AsscbasedDept = wfms_COSList.getSameDept();
							 }else{
								 AsscbasedDept = wfms_COSList.getNewDepartmentNumber();
							 }
							 
		        				 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record</a> ";
								 emailSubject = "New Department Manager Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
								 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DM, AsscbasedDept, actionRequest, emailSubject, emailMessage);
	        			
	        			 }if(roleType.equals(HondaPermissionKeys.COS_NEW_DVM)){
	        				  
	        				 if(wfms_COSList.getNewJobCode().equals("PA") || wfms_COSList.getNewJobCode().equals("TC") || wfms_COSList.getNewPositionNumber().equals("None")){
								 AsscbasedDept = wfms_COSList.getSameDept();
							 }else{
								 AsscbasedDept = wfms_COSList.getNewDepartmentNumber();
							 }

			 				 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record</a> ";
							 emailSubject = "New Division Manager Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DVM, AsscbasedDept, actionRequest, emailSubject, emailMessage);

		        			
			        	}if(roleType.equals(HondaPermissionKeys.COS_HR_DM)){
			        		 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/>  Click the below link to access the change of status.  Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
							 emailSubject = "HR Department Manager Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_HRDM,"", actionRequest, emailSubject, emailMessage);
						
       					}	
        				if(roleType.equals(HondaPermissionKeys.COS_OPS_LEADER)){
        					 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/>  Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
							 emailSubject = "Ops Leader Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_OPS_LEADER,"", actionRequest, emailSubject, emailMessage);
        				}	
	        			if(roleType.equals(HondaPermissionKeys.COS_CMP)){
	        				 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
							 emailSubject = "Company Manpower Controller Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_CMP,"", actionRequest, emailSubject, emailMessage);
						
	        			}
	        			if(roleType.equals(HondaPermissionKeys.COS_SP_DM)){
	        				 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
							 emailSubject = "SP Department Manager Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_SPDM,"", actionRequest, emailSubject, emailMessage);
							
	        			}				        				
		        		if(roleType.equals(HondaPermissionKeys.COS_ARL_OA)){
		        			 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/>  Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
							 emailSubject = "ARL OA Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+" has been disapproved.";
							 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_ARL_OA,"", actionRequest, emailSubject, emailMessage);		  
							
		        		}                             
	        	  }
	        		   

		        	  
	        	  }
	        	  
					     if( wfms_COSList.getSystemGenerated()==1 ){ 
					    	 String url     =GenerateFrindlyURL.getCOSfrindlyURL(actionRequest,changeofstatusId);
								 emailSubject = "Notification: Hello Staffing this COS "+wfms_COSList.getCosId()+" is Cancelled";
									    emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
										 emailSubject = "Staffing Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+"  that you previously approved as been disapproved.";
									
					    	 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,"", actionRequest, emailSubject, emailMessage);
					    	 }
				
					     else  if(wfms_COSList.getSystemGenerated()==2){
					    	 String url     =GenerateFrindlyURL.getCOSfrindlyURL(actionRequest,changeofstatusId);
											    emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/> Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
												 emailSubject = "Department Manpower Controller: Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+"  that you previously approved as been disapproved.";
											
							    	 EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_DMP,wfms_COSList.getCurrentDepartmentNumber(), actionRequest, emailSubject, emailMessage);
							 
					     }
					     else{
							
						String url     =GenerateFrindlyURL.getCOSfrindlyURL(actionRequest,changeofstatusId);
						if("true".equalsIgnoreCase(configuration.get("mail.config.verify"))){
							
								 
								 emailMessage="This change of status has been disapproved by another approver. <br/> Disapproval Comments: "+ comments  +" <br/>  Click the below link to access the change of status. <br/> <a href=" + url + ">Click here to review the record </a>";
						    	 emailSubject = user.getFullName()+ ": Change of Status "+changeofstatusId+" for ["+wfms_COSList.getAssoicateId()+"] "+wfms_COSList.getAssociatename()+"  that you previously approved as been disapproved.";
							
								 EmailUtility.sendEmail(emailFromName, user.getFullName(), emailFromAddress, user.getEmailAddress(), emailSubject  , emailMessage);
							 }
							 else{
								 
								 
								 if( user != null && Validator.isNotNull(user.getEmailAddress()))
									 	 EmailUtility.sendEmail(emailFromName, user.getFullName(), emailFromAddress, user.getEmailAddress(), emailSubject, emailMessage);	
							 }	 
					
					
					}
	        	  
	            wfms_COSList.setStatus(HondaPermissionKeys.COS_DISAPPROVED);
	       /*     if(wfms_COSList.getSystemGenerated() == 2){
	            	
	            	Map<String, String> map=HondaLogicUtil.singleCallOnServieNow(wfms_COSList.getCurrentDepartmentNumber());
	            	wfms_COSList.setNextApprover(map.get("mpwrrep_name"));
	            }
	            else if(wfms_COSList.getSystemGenerated() == 1){
				   wfms_COSList.setNextApprover(StringUtil.merge(HondaLogicUtil.listOfrolseusers("", actionRequest, HondaPermissionKeys.ROLE_STAFFING), "<br/>"));
	            } else{       
                wfms_COSList.setNextApprover(user.getFullName());
	            }*/
	            wfms_COSList.setNextApprover("");
                wfms_COSList.setRoleOfApprover("");
                wfms_COSList.setApproverStep(0);
                wfms_COSList.setWorkflowStep(0);
                wfms_COSList.setSortApprovedList("");
                wfms_COSList.setRoutingProcess("");
                WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_COSList);
                HondaLogicUtil.auditLogsForReqAndCOS(changeofstatusId, WorkflowConstants.CHANGE_OF_STATUS_DISAPPROVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, actionRequest,comments);
                WFMS_Requisition req_update=null;  
                try {
                	req_update = WFMS_RequisitionLocalServiceUtil.findBypositionassociate(wfms_COSList.getNewPositionNumber(), wfms_COSList.getAssoicateId());

           } catch (Exception e) {
           	
           }               			
				if(req_update!=null)
				{
			 req_update.setAssociatename(StringPool.BLANK);
			 req_update.setAssociatenumber(StringPool.BLANK);
				req_update.setStatus(HondaPermissionKeys.REQ_WAITINGONMANPOWER);
				req_update.setWorkflowStep(40);
				req_update.setNextapprove(StringUtil.merge(HondaLogicUtil.listOfrolseusers("",actionRequest,HondaPermissionKeys.ROLE_STAFFING), "<br/>"));
				req_update.setAssociatename(StringPool.BLANK);
				 req_update.setAssociatenumber(StringPool.BLANK);
				WFMS_RequisitionLocalServiceUtil
						.updateWFMS_Requisition(req_update);
				
				String rid=req_update.getRwfId();
							
				emailSubject = "Staffing: Manpower Requisition "+rid+" is now waiting on manpower.";
				emailMessage = "This requisition "+rid+"  has been submitted and needs to be filled. Click the below link to access the requisition.";
			String	 url=	GenerateFrindlyURL.getURLForRequisition( actionRequest, rid);
				emailMessage = emailMessage +". <br/><a href='"+url+"'>Click here to review the record</a>";
				EmailUtility.sendMailsNotify(HondaPermissionKeys.ROLE_STAFFING,null, actionRequest, emailSubject, emailMessage);
				}
    }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
            	if(wfms_COSList.getSystemGenerated() == 2){
            	    ModifyPositionWFHelper.revertPosOnDisapproveCos(wfms_COSList.getPositionNumber()); 
            	}
            }
        
	}
	
	public static List<String> listOfrolseusers(String  cosid, PortletRequest portletRequest,String roleName){
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		  List<String> list=new ArrayList<String>();
		try {
			Role role=null;
			  role=RoleLocalServiceUtil.getRole(companyId, roleName);
			  long roleId=role.getRoleId();
			
			  List<User> roleUsers = UserLocalServiceUtil.getRoleUsers(roleId);
			  for (User user : roleUsers) {
				  list.add(user.getFullName());
			}
		} catch (Exception e) {
			
		}
		  return list;
	}
	
	public void updateCommentsCOS(ActionRequest request, ActionResponse response)
			throws Exception {
		String cosId = ParamUtil.getString(request, "cos-number");
		String comments = ParamUtil.getString(request, "comments");
		String effectiveDate = ParamUtil.getString(request, "effectiveDate");
		 WFMS_COS wfms_cos=null;
		 String audit_message="";
		   wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosId);
		try {
			if(ParamUtil.getString(request, "cmpComment").equals("comments")){
				if(!wfms_cos.getComments().equalsIgnoreCase(comments))
		        	audit_message+="&quot;Comments changed From&quot;"  + " "+ wfms_cos.getComments() + " " + "&quot;To&quot;"  +" "+ comments+ " ";
				
				wfms_cos.setComments(ParamUtil.getString(request, "comments"));
			}else{
				if(!wfms_cos.getEffectiveDate().equalsIgnoreCase(effectiveDate))
		        	audit_message+="&quot;Effective Date changed From&quot;"  + " "+  wfms_cos.getEffectiveDate() + " "+ "&quot;To&quot;"  +" "+ effectiveDate;
				wfms_cos.setEffectiveDate(ParamUtil.getString(request, "effectiveDate"));
			}
			wfms_cos = WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_cos);
			 //PortletURL portletURLmanageCOS = GenerateFrindlyURL.renderingPage(request, response, "/html/changeOfStatus/manageCOS.jsp");
			request.setAttribute("cosId", cosId);
			 //portletURLmanageCOS.setParameter("wfms_CosObj", wfms_cos);
			 request.setAttribute("wfms_CosObj", wfms_cos);
			 request.setAttribute("AssociateNumber", wfms_cos.getAssoicateId());
			 if(!audit_message.equals(""))
			 //HondaLogicUtil.auditLogsForReqAndCOS(cosId, WorkflowConstants.CHANGE_OF_STATUS_SAVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, "");
				 HondaLogicUtil.auditLogsForReqAndCOS(cosId, audit_message, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, "");
		    // response.sendRedirect(portletURLmanageCOS.toString());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/changeOfStatus/manageCOS.jsp");
	}
	
	public void disapproveCommentsCOS(ActionRequest request, ActionResponse response)
			throws Exception {
		String cosId = ParamUtil.getString(request, "cos-number");
		String comments = ParamUtil.getString(request, "comments");
		String effectiveDate = ParamUtil.getString(request, "effectiveDate");
		 WFMS_COS wfms_cos=null;
		 String audit_message="";
		   wfms_cos = WFMS_COSLocalServiceUtil.fetchWFMS_COS(cosId);
		try {
			if(ParamUtil.getString(request, "cmpComment").equals("comments")){
				if(!wfms_cos.getComments().equalsIgnoreCase(comments))
		        	audit_message+="&quot;Comments changed From&quot;"  + " "+ wfms_cos.getComments() +" "+  "&quot;To&quot;"  +" "+ comments+ " ";
				
				wfms_cos.setComments(ParamUtil.getString(request, "comments"));
			}else{
				if(!wfms_cos.getEffectiveDate().equalsIgnoreCase(effectiveDate))
		        	audit_message+="&quot;Effective Date changed From&quot;"  +" " + wfms_cos.getEffectiveDate() +" "+  "&quot;To&quot;"  +" "+ effectiveDate;
				wfms_cos.setEffectiveDate(ParamUtil.getString(request, "effectiveDate"));
			}
			wfms_cos = WFMS_COSLocalServiceUtil.updateWFMS_COS(wfms_cos);
			 //PortletURL portletURLmanageCOS = GenerateFrindlyURL.renderingPage(request, response, "/html/changeOfStatus/manageCOS.jsp");
			request.setAttribute("cosId", cosId);
			 //portletURLmanageCOS.setParameter("wfms_CosObj", wfms_cos);
			 request.setAttribute("wfms_CosObj", wfms_cos);
			 request.setAttribute("AssociateNumber", wfms_cos.getAssoicateId());
			 if(!audit_message.equals(""))
			 //HondaLogicUtil.auditLogsForReqAndCOS(cosId, WorkflowConstants.CHANGE_OF_STATUS_SAVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, "");
				 HondaLogicUtil.auditLogsForReqAndCOS(cosId, audit_message, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request, "");
		    // response.sendRedirect(portletURLmanageCOS.toString());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/changeOfStatus/manage.jsp");
	}
	
	
	
	/**
	 * Auto approvals logic
	 * By ChandraMouli S
	 * @param   WFMS_COS cos
	 * @return List adminList
	 */
public static WFMS_COS  findDuplicateUser(WFMS_COS cos, List<String> adminList){

	if(cos.getApproverStep()==0){
	List<String> lisapprovals1 =null;
	String roleArray1[] = cos.getApproverList().split(",");
	lisapprovals1= Arrays.asList(roleArray1);
	 StringBuilder commaSepValueBuilderduplicateList = new StringBuilder();
	 for ( int i = 0; i< lisapprovals1.size(); i++){
		 commaSepValueBuilderduplicateList.append(lisapprovals1.get(i));
	      if ( i != lisapprovals1.size()-1){
	    	  commaSepValueBuilderduplicateList.append(",");
	      }
	 }
	 cos.setDuplicateApprovedList(commaSepValueBuilderduplicateList.toString());
	 cos.setDuplicateApprovedListStartIndex(0);
	 cos.setDuplicateApprovedListEndIndex(lisapprovals1.size());
}	
	
String roleArray[] = cos.getApproverList().split(",");
List<String> lisapprovals =null;
//List GobaluniqueIndex=new ArrayList();
String appendRole= StringPool.BLANK;
if((adminList.contains(HondaPermissionKeys.ROLE_Administrator))){
	appendRole=HondaPermissionKeys.ROLE_SPDM;
}
if(adminList.contains(HondaPermissionKeys.ROLE_SPDM)){
	appendRole=HondaPermissionKeys.ROLE_SPDM;
}
List<String> sortedList= new ArrayList<String>();

try { 
	if(Validator.isNull(cos.getRoutingProcess()) && cos.getApproverStep()==0){
		lisapprovals= Arrays.asList(roleArray);
		sortedList=	sorteNamedList(lisapprovals, cos);
		if(appendRole.equalsIgnoreCase(HondaPermissionKeys.ROLE_Administrator) || appendRole.equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM))
		{
			if(HondaPermissionKeys.COS_SP_DM.equalsIgnoreCase(lisapprovals.get(cos.getApproverStep())) ){
				sortedList.set(cos.getApproverStep(), sortedList.get(cos.getApproverStep()));
			}
			else{
				sortedList.set(cos.getApproverStep(), appendRole+sortedList.get(cos.getApproverStep())+cos.getApproverStep());
			}
		}
		else{
			 sortedList.set(cos.getApproverStep(), sortedList.get(cos.getApproverStep()));
		}
		
}
else{ 
		sortedList=	sorteNamedList( Arrays.asList( cos.getSortApprovedList().split(",")), cos);
		
		lisapprovals= Arrays.asList( cos.getSortApprovedList().split(","));
		if(appendRole.equalsIgnoreCase(HondaPermissionKeys.ROLE_Administrator) || appendRole.equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM))
		{
			if(HondaPermissionKeys.COS_SP_DM.equalsIgnoreCase(lisapprovals.get(cos.getApproverStep()))  ){
				sortedList.set(cos.getApproverStep(), sortedList.get(cos.getApproverStep()));
			}
			else{
				sortedList.set(cos.getApproverStep(), appendRole+sortedList.get(cos.getApproverStep())+cos.getApproverStep());
			}
		}
		else{
			 sortedList.set(cos.getApproverStep(), sortedList.get(cos.getApproverStep()));
		}
		
} 
   
	
	
	//-----------------------Traversing the array based on Location on every Iteration-----------------
	    String[] sortedArr = new String[sortedList.size()];
	    sortedArr = sortedList.toArray(sortedArr);
	    List uniqueIndex=new ArrayList();
	    for(int i=cos.getApproverStep()+1;i<sortedArr.length;i++){
	    	if(sortedArr[cos.getApproverStep()].equalsIgnoreCase(sortedArr[i])){
	    	//	GobaluniqueIndex.add(i);
	    		 uniqueIndex.add(i);
	    	}	    	
	    }
	    
	    
	    
	    
	    //---------------------------------------------LOG----------------------------------------------
	    List<String> DuplicatesortedList =null;
	    List<String> DuplicatedsortedList =null;
	    DuplicatesortedList=Arrays.asList(cos.getDuplicateApprovedList().split(","));
	    DuplicatedsortedList=sorteNamedList(Arrays.asList(cos.getDuplicateApprovedList().split(",")), cos);
	    String[] DuplicatesortedArr = new String[DuplicatedsortedList.size()];
	    DuplicatesortedArr = DuplicatedsortedList.toArray(DuplicatesortedArr);
	    if(!(uniqueIndex.isEmpty())){
	    	 for(int i=cos.getDuplicateApprovedListStartIndex()+1;i<cos.getDuplicateApprovedListEndIndex();i++){
	 	    	if(DuplicatesortedArr[cos.getDuplicateApprovedListStartIndex()].equalsIgnoreCase(DuplicatesortedArr[i])){
	 	    		DuplicatesortedList.set(i, "&");
	 	    	}	
	    	
	              }
	    }	    
	    //----------------------------------------------LOG----------------------------------------------
	    
      
	       for(int i=0;i<uniqueIndex.size();i++){
	           for(int j=0;j<lisapprovals.size();j++){
	               if(uniqueIndex.get(i).equals(j)){
	            	   lisapprovals.set(j, "&");
	               }
	           }
	       }
	       List<String> finalList= new ArrayList<String>();
		   for(int j=0;j<lisapprovals.size();j++){
	           if(!lisapprovals.get(j).equals("&")) {
	        	   finalList.add(lisapprovals.get(j));
	        	 //  DupsortedArr[j]=lisapprovals.get(j);
	           }
	       }
		   List<String> DfinalList= new ArrayList<String>(finalList);
		   DfinalList.add("null");
		   String[] DupsortedArr = finalList.toArray(new String[lisapprovals.size()+2]);
		   //-------------------------------------LOG-----------------------------------
		  int step=cos.getApproverStep();
		  int counter=0;
		  int duplicatecounter=0;
		  cos.setDuplicateCounter(duplicatecounter);
		  step=step+1;
		  String str= DfinalList.get(step);
		   for(int i=cos.getDuplicateApprovedListStartIndex()+1;i<cos.getDuplicateApprovedListEndIndex();i++){
			   for(int k=0;k<DfinalList.size();k++){
			   }
			   if((DuplicatesortedList.get(i)).equalsIgnoreCase(str)){
				   counter++;
				   break;				   
			   }
			   else{
				   counter++;
				   duplicatecounter++;
			   }		   
             }
		   cos.setDuplicateCounter(duplicatecounter);
		   cos.setDuplicateApprovedListStartIndex(cos.getDuplicateApprovedListStartIndex()+counter);
		   
		   List DuplicatefinalList= new ArrayList();
		   for(int j=0;j<DuplicatesortedList.size();j++){
	        	   DuplicatefinalList.add(DuplicatesortedList.get(j));
	       }				   
		   //-------------------------------------LOG------------------------------------
		   
	
	    StringBuilder commaSepValueBuilder = new StringBuilder();
		 for ( int i = 0; i< sortedList.size(); i++){
		      commaSepValueBuilder.append(sortedList.get(i));
		      if ( i != sortedList.size()-1){
		        commaSepValueBuilder.append(",");
		      }
		    }
		 
		  StringBuilder commaSepValueBuilderfinalList = new StringBuilder();
			 for ( int i = 0; i< finalList.size(); i++){
				 commaSepValueBuilderfinalList.append(finalList.get(i));
			      if ( i != finalList.size()-1){
			    	  commaSepValueBuilderfinalList.append(",");
			      }
			    }
			 
		//---------------------------------------LOG-------------------------------------------------			 
			 StringBuilder commaSepValueBuilderDuplicatefinalList = new StringBuilder();
			 for ( int i = 0; i< DuplicatefinalList.size(); i++){
				 commaSepValueBuilderDuplicatefinalList.append(DuplicatefinalList.get(i));
			      if ( i != DuplicatefinalList.size()-1){
			    	  commaSepValueBuilderDuplicatefinalList.append(",");
			      }
			    }		 
			 cos.setDuplicateApprovedList(commaSepValueBuilderDuplicatefinalList.toString());		 
		//----------------------------------------LOG-------------------------------------------------	 
	 cos.setRoutingProcess(commaSepValueBuilder.toString());
	 cos.setSortApprovedList(commaSepValueBuilderfinalList.toString());
	   WFMS_COSLocalServiceUtil.updateCos(cos);
   
} catch (Exception e) { 
e.printStackTrace();
}
return cos;  }



public static List<String> sorteNamedList(List<String> sortedlist, WFMS_COS cos){
	List<String> sortedNameslist=new ArrayList<String>();
	try {
		for(int i=0;i<sortedlist.size();i++){
			 if((sortedlist.get(i).equals(HondaPermissionKeys.COS_CURRENT_DM) ) ){
				 sortedNameslist.add(HondaLogicUtil.getCCName(cos ,HondaPermissionKeys.COS_CURRENT_DM));
			 }
			 else if(sortedlist.get(i).equals(HondaPermissionKeys.COS_NEW_DM)){
				 sortedNameslist.add(HondaLogicUtil.getCCName(cos ,HondaPermissionKeys.COS_NEW_DM));
			 }
			 else if(sortedlist.get(i).equals(HondaPermissionKeys.COS_CURRENT_DVM) ){
				 sortedNameslist.add(HondaLogicUtil.getCCName(cos ,HondaPermissionKeys.COS_CURRENT_DVM));
			 }
			 else if( sortedlist.get(i).equals(HondaPermissionKeys.COS_NEW_DVM)){
				 sortedNameslist.add(HondaLogicUtil.getCCName(cos ,HondaPermissionKeys.COS_NEW_DVM));
			 }
			 else{
				 sortedNameslist.add(sortedlist.get(i));
	    }
	}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return sortedNameslist;
}

//--------------------------------------------------LogFunction--------------------------------------------

public static WFMS_COS checklog(WFMS_COS cos,ActionRequest request){
	try {
		if(cos.getDuplicateCounter()>0){
			int counter=cos.getDuplicateCounter();
			while(counter>0){
				
				
  	  		    HondaLogicUtil.auditLogsForReqAndCOS(cos.getCosId(), "Auto " +WorkflowConstants.CHANGE_OF_STATUS_APPROVE, WorkflowConstants.CHANGE_OF_STATUS_ACTION, request,"");
				counter--;
			}
			cos.setDuplicateCounter(0);				
		}
		else{
			return cos;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cos;
}

public static  WFMS_COS checklist(WFMS_COS cos){
	try {
		if(cos.getApproverStep()>=1 && cos.getDuplicateApprovedListStartIndex()==0 && cos.getDuplicateApprovedListEndIndex()==0 ){
			List<String> listofApprove = new ArrayList<String>(Arrays.asList(cos.getApproverList().split(",")));
			cos.setSortApprovedList(cos.getApproverList());
			cos.setDuplicateApprovedList(cos.getApproverList());
			cos.setDuplicateApprovedListStartIndex(cos.getApproverStep());
			cos.setDuplicateApprovedListEndIndex(listofApprove.size());
			WFMS_COSLocalServiceUtil.updateCos(cos);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cos;
}

public void assiateTitleshowalert(ResourceRequest request,
		ResourceResponse response) {
	PrintWriter out = null;
	String congLadder=StringPool.BLANK;
	JSONObject json = JSONFactoryUtil.createJSONObject();
	try {
		String assotiletitle = request.getParameter("assotiletitle");
		String currentpositionnumber = request.getParameter("currentpositionnumber");
		WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
				.getByPositionId(currentpositionnumber);
		Map<String, String> shiftMap = new HashMap<String, String>();
		shiftMap = ConfigUtility.getInputValuesForMap("associate-titles-and-ladder");
		Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
		for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {
			if(entry.getKey().trim().equals(assotiletitle)){
				congLadder=entry.getValue().trim();
			}
		}
		Boolean flagshow = false;
		// Boolean flagshow= 	wfms_Position.getLadder().equals(congLadder) ? true:false;
		//wfms_Position.getLadder()
		if(wfms_Position.getLadder().trim().equals(congLadder)){
			flagshow=true;
		}
		else if(wfms_Position.getLadder().trim().equals("Either") && ( congLadder.equals("Technical") || congLadder.equals("Business"))){
			flagshow=true;
		}
		else {
			flagshow = false;
		}
		json.put("flagshow", flagshow);
				response.setCharacterEncoding("UTF-8");
		out = response.getWriter();
		out.println(json);
	}catch (Exception e) {
		_log.error("ChangeOfStatusPortlet.getNewPositionNumber():",e);
	}
}
private static	Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");


	private static Log _log = LogFactoryUtil.getLog(ChangeOfStatusPortlet.class.getName());
}