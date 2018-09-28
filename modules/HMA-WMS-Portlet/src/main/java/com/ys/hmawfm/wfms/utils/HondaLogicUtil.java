package com.ys.hmawfm.wfms.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;


import com.liferay.portal.kernel.json.JSONException;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_Associate_History;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_action_names;
import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;
import com.ys.hmawfm.wfms.services.rest.CostCenterService;
import com.ys.hmawfm.wfms.services.service.WFMS_Associate_HistoryLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_COS_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_Requisition_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.vo.AssociateInformation;
import com.ys.hmawfm.wfms.workflow.WorkflowConstants;


public class HondaLogicUtil {
	
	public static int getCurrentKi(){


//
		int ki = 77;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH,-3);

		return cal.get(Calendar.YEAR) - 2000 + ki;

	}
	
	

	

	/**
	 * @param wrokfowId
	 * @return
	 */
	public static String getpositoinidFromWorkFlowId(String wrokfowId)
	{
		
		String posId="";
		try {
			if (wrokfowId != null && wrokfowId.length() > 1) {
				posId = wrokfowId.substring(0, wrokfowId.length() - 4);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return posId;
	}
	


	/**
	 * By ChandraMouli S
	 * @param Pid 
	 * @param change
	 * @param action
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static void auditLogsForPosition(String Pid ,String associateId, String workflowName,String action,ActionRequest actionRequest,String comments) throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		long aid = CounterLocalServiceUtil.increment(WFMS_Position_Audit.class.getName());
		String auditId =String.valueOf(aid);
		try {
			if(Validator.isNotNull(auditId)){
				WFMS_Position_Audit wfms_pos_audit=null;
				wfms_pos_audit=WFMS_Position_AuditLocalServiceUtil.createWFMS_Position_Audit(auditId);
						   if(Validator.isNotNull(wfms_pos_audit)){
						wfms_pos_audit.setPaId(auditId);
						wfms_pos_audit.setPId(Pid);
						wfms_pos_audit.setChange(workflowName);
						wfms_pos_audit.setCreateDate(new Date());
						wfms_pos_audit.setUserId(userId);
						wfms_pos_audit.setAssociateId(associateId);
						wfms_pos_audit.setCreatedBy(user.getFullName());
						wfms_pos_audit.setComments(comments);
						WFMS_Position_AuditLocalServiceUtil.addWFMS_Position_Audit(wfms_pos_audit);
						   }
			}
			else
			{
			//	_log.info("error  in auditLogsForPosition ");
			}
		} catch (Exception e) {
			_log.error("error  in auditLogsForPosition "+e.getMessage());
			e.printStackTrace();
		}
		
			
		
		
	}
	public static void auditLogsForAssociateHistory(String associateId,String history,String positionNumber,ActionRequest actionRequest) throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		
		
	
		//  _log.info("assocHistoryId after increment 1111 >>>>"+assocHistoryId);
		try {
			DynamicQuery assocHistoryCondition =WFMS_Associate_HistoryLocalServiceUtil.dynamicQuery();
			assocHistoryCondition.addOrder(OrderFactoryUtil.desc("assocHistoryId"));
			  List <WFMS_Associate_History> WfmsAssociateHistory =  WFMS_Associate_HistoryLocalServiceUtil.dynamicQuery(assocHistoryCondition);
			  int assocHistoryId=1;
			//  _log.info("WfmsAssociateHistory.size() >>>>"+WfmsAssociateHistory.size());
			  if(WfmsAssociateHistory.size()>0){
			   assocHistoryId=WfmsAssociateHistory.get(0).getAssocHistoryId();
			//   _log.info("assocHistoryId>>>>"+assocHistoryId);
	           assocHistoryId=assocHistoryId+1;
	       //    _log.info("assocHistoryId after increment >>>>"+assocHistoryId);
			  }
			if(Validator.isNotNull(assocHistoryId)){
				Date date=new Date(); 
				history=history+ " on " +HondaLogicUtil.getDateFormat(date)+" by "+user.getFullName();
				WFMS_Associate_History wfms_associate_history=null;
				wfms_associate_history=WFMS_Associate_HistoryLocalServiceUtil.createWFMS_Associate_History(assocHistoryId);
				AssociateInformation associateInfoservice = HMAAssociateInfoService.fetchPositionOnAssociateNumber(associateId);
				
				//_log.info("assocHistoryIdValue>>>"+assocHistoryIdValue);
			//	_log.info("associateInfoservice name>>>"+associateInfoservice.getAssociateName());
				   if(Validator.isNotNull(wfms_associate_history)){
					   wfms_associate_history.setCreateDate(date);
					   wfms_associate_history.setCurrentPosition(positionNumber);
					   wfms_associate_history.setAssociateId(associateId);
					   wfms_associate_history.setCreatedBy(user.getFullName());
					   wfms_associate_history.setHistory(history);
					   wfms_associate_history.setAssociateName(associateInfoservice.getAssociateName()); 
					   WFMS_Associate_HistoryLocalServiceUtil.addWFMS_Associate_History(wfms_associate_history);
				   }
			}
			else
			{
				//_log.info("error  in auditLogsForAssociateHistory ");
			}
		} catch (Exception e) {
			_log.error("error  in auditLogsForAssociateHistory "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void auditLogsForPositionwithTwoPid(String Pid ,String associateId, String fromPId, String workflowName,String action,ActionRequest actionRequest) throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		long aid = CounterLocalServiceUtil.increment(WFMS_Position_Audit.class.getName());
		String auditId =String.valueOf(aid);
		try {
			if(Validator.isNotNull(auditId)){
				WFMS_Position_Audit wfms_pos_audit=null;
				wfms_pos_audit=WFMS_Position_AuditLocalServiceUtil.createWFMS_Position_Audit(auditId);
						   if(Validator.isNotNull(wfms_pos_audit)){
						wfms_pos_audit.setPaId(auditId);
						wfms_pos_audit.setPId(Pid);
						wfms_pos_audit.setFromPId(fromPId);
						wfms_pos_audit.setChange(workflowName);
						wfms_pos_audit.setCreateDate(new Date());
						wfms_pos_audit.setUserId(userId);
						wfms_pos_audit.setAssociateId(associateId);
						wfms_pos_audit.setCreatedBy(user.getFullName());
						WFMS_Position_AuditLocalServiceUtil.addWFMS_Position_Audit(wfms_pos_audit);
						   }
			}
			else
			{
				//_log.info("error  in auditLogsForPosition ");
			}
		} catch (Exception e) {
			_log.error("error  in auditLogsForPosition "+e.getMessage());
			e.printStackTrace();
		}	
	}
	/**
	 * By ChandraMouli S
	 * @param RCid  Means Requistion id || cos Id
	 * @param change
	 * @param action
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static void auditLogsForReqAndCOS(String RCid , String workflowName,String action,ActionRequest actionRequest , String comments) throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId); 
		long aid = CounterLocalServiceUtil.increment(WFMS_Requisition_Audit.class.getName());
		String auditId =String.valueOf(aid);
		//System.out.print("RCid:"+RCid);
				try {

					if(Validator.isNotNull(action) && action.equalsIgnoreCase(WorkflowConstants.REQUISITION_ACTION) && Validator.isNotNull(auditId)){
						
						WFMS_Requisition_Audit requisition_Audit=null;
						requisition_Audit=WFMS_Requisition_AuditLocalServiceUtil.createWFMS_Requisition_Audit(auditId);
								   if(Validator.isNotNull(requisition_Audit)){
									   requisition_Audit.setReqaId(auditId);
									   requisition_Audit.setReqId(RCid);
									   requisition_Audit.setChange(workflowName);
									   requisition_Audit.setCreateDate(new Date());
									   requisition_Audit.setUserId(userId);
									   requisition_Audit.setCreatedBy(user.getFullName());
									   requisition_Audit.setComments(comments);
									//   _log.info("<<<<<<<<<<<<<<<<<comments>>>>>>>>>>>>>>>>>>>>>>>>");
									   WFMS_Requisition_AuditLocalServiceUtil.addWFMS_Requisition_Audit(requisition_Audit);
									 //  _log.info("<<<<<<<<<<<<<<<<<logs>>>>>>>>>>>>>>>>>>>>>>>>");
								   }
					}
					
			
					else if(Validator.isNotNull(action) && action.equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_ACTION)){
					

						WFMS_COS_Audit cos_Audit=null;
						cos_Audit=WFMS_COS_AuditLocalServiceUtil.createWFMS_COS_Audit(auditId);
								   if(Validator.isNotNull(cos_Audit)){
									   cos_Audit.setCosaId(auditId);
									   cos_Audit.setCosId(RCid);
									   cos_Audit.setChange(workflowName);
									   cos_Audit.setCreateDate(new Date());
									   cos_Audit.setUserId(userId);
									   if(workflowName.equalsIgnoreCase("Auto Approved")) cos_Audit.setCreatedBy("System");
                                       else cos_Audit.setCreatedBy(user.getFullName());
									   cos_Audit.setComments(comments);
									   WFMS_COS_AuditLocalServiceUtil.addWFMS_COS_Audit(cos_Audit);
								   }
					}
					
					else
					{
					//	_log.info("error  in auditLogsForReqAndCOS ");
					}
								} catch (Exception e) {
						_log.error("error  in auditLogsForReqAndCOS "+e.getMessage());
						e.printStackTrace();
						// TODO: handle exception
					}
		
	}
	
	
	
	public static String getDateFormat(Date createdate)
	{
		
		String strDate = "";
		if(createdate!=null){
			SimpleDateFormat cstFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		  TimeZone cstTime = TimeZone.getTimeZone("CST");
		  cstFormat.setTimeZone(cstTime);
		  strDate = cstFormat.format(createdate);
		}
		return strDate;
	}
	public static String getDateFormatForAudit(Date createdate)
	{
		    String strDate="" ;
		    if(createdate!=null){
		    SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		   /* Date now = new Date();
		    strDate=  sdfDate.format(now);*/
	      	strDate=sdfDate.format(createdate);
		    }
		    
		    return strDate;   
	}

	
	
	

 /*	
	public static String getDeptAbbrevationDetails( String deptNo) throws  IOException, JSONException, com.liferay.portal.kernel.json.JSONException {
		   String deptAbbrLinkData=StringPool.BLANK;
		try{
			//String deptName= request.getParameter("roleUuid"); 
			CostCenterService costCenterService = new CostCenterService();
			JSONObject jSONObject= costCenterService.userIsSameDepartment(deptNo);
			
		   
			JSONObject jsonObjLiferayDept = JSONFactoryUtil.createJSONObject(jSONObject.toString());
		    String abbrevationStr = jsonObjLiferayDept.getString("u_department");
		    
		    JSONObject jsonObjLiferaydeptLinkAbbr = JSONFactoryUtil.createJSONObject(abbrevationStr);
		    String deptAbbrLink = jsonObjLiferaydeptLinkAbbr.getString("link");
		    
		    String deptAbbrLink1 = costCenterService.getResponseString(deptAbbrLink);
		    
		    JSONObject jsonObjLiferaydeptLinkAbbrData = JSONFactoryUtil.createJSONObject(deptAbbrLink1);
		     deptAbbrLinkData = jsonObjLiferaydeptLinkAbbrData.getString("u_abbreviation");
		    
		}catch(Exception e){
			e.printStackTrace();}
		return deptAbbrLinkData;		    
	}*/
	
	public static Map<String,String> getDeptAbbrevationDetailsforPosition() throws JSONException {
		JSONArray jsonArray  = null;
		CostCenterService serviceNowService = new CostCenterService();
		Map<String,String> departmentTreeMap= new TreeMap<String, String>();
		String mapJson = null;
		try {
		
				try {
					mapJson = serviceNowService.getAllCostCenterswithAbbrevation();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			 if(mapJson != null && mapJson.trim().length() > 1){
				 
				 if(! mapJson.startsWith("[")) {
				 int i = mapJson.indexOf('[');
				 // int j = mapJson.indexOf(']');
				 	 if(i > 0) {
				 	  mapJson = mapJson.substring(i, mapJson.length()-1);
				 	 }
				 }

				
			jsonArray = JSONFactoryUtil.createJSONArray(mapJson);
			
			
			 for(int i=0; i < jsonArray.length();i++){
				  JSONObject jsonObjLiferayLocal =jsonArray.getJSONObject(i);
				  departmentTreeMap.put(jsonObjLiferayLocal.getString("cc_code"),jsonObjLiferayLocal.getString("dpt_u_abbreviation") );	
				 // dvmgr_name
		     }
			 }
			 
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departmentTreeMap;	    
	}
	
	
	public static Map<String,String> getcccodesOnsameDeptNumber(String depNum) throws JSONException {
		JSONArray jsonArray  = null;
		CostCenterService serviceNowService = new CostCenterService();
		Map<String,String> departmentTreeMap= new TreeMap<String, String>();
		Map<String,String> deptInfoMap= new TreeMap<String, String>();

		String mapJson = null;
		try {
			deptInfoMap=	singleCallOnServieNow(depNum);
			mapJson = serviceNowService.getsameDeptNumbersOnAbbrivationCode(deptInfoMap.get("abbreviation"));
			
			
			 if(mapJson != null && mapJson.trim().length() > 1){
				 
				 if(! mapJson.startsWith("[")) {
				 int i = mapJson.indexOf('[');
				 // int j = mapJson.indexOf(']');
				 	 if(i > 0) {
				 	  mapJson = mapJson.substring(i, mapJson.length()-1);
				 	 }
				 }

				
			jsonArray = JSONFactoryUtil.createJSONArray(mapJson);
			
			
			 for(int i=0; i < jsonArray.length();i++){
				  JSONObject jsonObjLiferayLocal =jsonArray.getJSONObject(i);
				  departmentTreeMap.put(jsonObjLiferayLocal.getString("cc_code"),jsonObjLiferayLocal.getString("dpt_u_abbreviation") );	
				 // dvmgr_name
		     }
			 //System.out.print(departmentTreeMap);
			 }
			 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departmentTreeMap;	    
	}
	
	public static String getDeptEmailDetailsforCOSApproval(String deptno, String userRole) throws JSONException {
		JSONArray jsonArray  = null;
		CostCenterService serviceNowService = new CostCenterService();
		String departmentTreeMap= "";
		String mapJson = null;
		try {
			try {
				mapJson = serviceNowService.getAllDeptmanagerDetailsforCOSApproval(deptno);
			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 if(mapJson != null && mapJson.trim().length() > 1){
				 
				 if(! mapJson.startsWith("[")) {
				 int i = mapJson.indexOf('[');
				 // int j = mapJson.indexOf(']');
				 	 if(i > 0) {
				 	  mapJson = mapJson.substring(i, mapJson.length()-1);
				 	 }
				 }

				
		       	jsonArray = JSONFactoryUtil.createJSONArray(mapJson);
			
			
       		      JSONObject jsonObjLiferayLocal =jsonArray.getJSONObject(0);
				  if(userRole == HondaPermissionKeys.COS_CURRENT_DM || userRole == HondaPermissionKeys.COS_NEW_DM){
				      return jsonObjLiferayLocal.getString("mgr_email");	
				  }
				  if(userRole == HondaPermissionKeys.COS_CURRENT_DVM || userRole == HondaPermissionKeys.COS_NEW_DVM){
					  return jsonObjLiferayLocal.getString("dvmgr_email"); 
				  }
				  if(userRole == HondaPermissionKeys.ROLE_DMP){
					  return jsonObjLiferayLocal.getString("mpwrrep_email"); 
				  }
			 }
			 
		} catch (com.liferay.portal.kernel.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departmentTreeMap;	    
	}
	
	
		
	public static String getWFMPortletUrl(String portletId, ThemeDisplay themeDisplay, String positionId   )
			throws PortalException, SystemException {
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
			String URL = StringPool.BLANK;
			try {
			URL = themeDisplay.getURLHome() + LayoutLocalServiceUtil.getLayout(plid).getFriendlyURL()+"?positionId="+ positionId   ;

			} catch (NoSuchLayoutException ex) {
			URL = themeDisplay.getURLCurrent();
			}
			return URL;
			}
	
/*	public static Map<String, String> getWFMDepartmentNo() throws JSONException, com.liferay.portal.kernel.json.JSONException, IOException{
	    PortalCache portalCache=MultiVMPoolUtil.getCache(PortletPropsPermission.CACHE_KEY);
	    Object object=portalCache.get(PortletPropsPermission.CACHE_NAME);
	    if(Validator.isNull(object)){
	    	_log.info("INSIDE PORTAL CACHE");
	    	Map<String, String> deparmentNumbers=restAPICallForCostCenter();
	     	portalCache.put(PortletPropsPermission.CACHE_NAME,deparmentNumbers);
	     	for (Map.Entry<String, String> entry : deparmentNumbers.entrySet()) {
	     		portalCache.put(entry.getKey(),getDeptAbbrevationDetails(entry.getKey()));
	     	}
	    }
	    Map<String, String> map=(Map<String, String>)portalCache.get(PortletPropsPermission.CACHE_NAME);
		return map;
	}*/
	
	
	 /**
	  * By ChandraMouli S
	 * @param depNo
	 * @return
	 * @throws SystemException
	 * @throws com.liferay.portal.kernel.json.JSONException
	 * @throws IOException
	 * @throws JSONException
	 */
	 public static String geneatePositionId( String depNo) throws SystemException, com.liferay.portal.kernel.json.JSONException, IOException, JSONException{
		 String str1=StringPool.BLANK;
		 String str2=StringPool.BLANK;
		   String str3 =StringPool.BLANK;;
		 Object obj=null;
		 Long val=null;
		 Map<String, String> hondamap=HondaLogicUtil.singleCallOnServieNow(depNo);
	         	 DynamicQuery LikeOperatorQuery = WFMS_PositionLocalServiceUtil.dynamicQuery();
				 Criterion criterion3 = null;
				 
				 criterion3 = RestrictionsFactoryUtil.like("pId",new StringBuilder(hondamap.get("abbreviation")).append("%").toString());
				 criterion3=RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("dummy" ,"0"));
				 LikeOperatorQuery.add(criterion3);
				
				 List<WFMS_Position> wfms_posList=WFMS_PositionLocalServiceUtil.dynamicQuery(LikeOperatorQuery);
				  List<Long> longlist= new ArrayList<Long>();
				  if(wfms_posList.size()>0){
				 for(WFMS_Position list:wfms_posList){
					  
					  str1=list.getPId();
					  if(str1.contains("-WFM")){
						  str2= str1.replace("-WFM", "");
						  str3=str2.replace( str2.substring(0 , str2.indexOf('-'))+"-", "");
						  longlist.add(  Long.parseLong(str3));
					 } 
					 else{
						 str2=str1.replace( str1.substring(0 , str1.indexOf('-'))+"-", "");
						 longlist.add(  Long.parseLong(str2));
						 
					 }
					  
					  obj = Collections.max(longlist);
				  }
				  val= (Long.parseLong(obj.toString()))+1;
				  }
				  else{
					  val= Long.parseLong("1");
				  }
				 // //System.out.print(val);
				 return hondamap.get("abbreviation")+"-"+String.format("%03d", val);
 		 
	 }
	
	 
	 /**
	  * By ChandraMouli S
	 * @param depNo
	 * @return
	 * @throws SystemException
	 * @throws IOException
	 * @throws JSONException 
	 * @throws com.liferay.portal.kernel.json.JSONException 
	 */
	public static String geneateRequisitionId( String depNo) throws SystemException,  IOException, com.liferay.portal.kernel.json.JSONException, JSONException{
		 Map<String, String> hondamap=HondaLogicUtil.singleCallOnServieNow(depNo);
		List<String> reqlist= new ArrayList<String>();
		DynamicQuery studentQuery1 = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
				List<WFMS_Requisition> reqList=WFMS_RequisitionLocalServiceUtil.dynamicQuery(studentQuery1);
				for(WFMS_Requisition req:reqList){
					if(!req.getRwfId().contains("-WFM"))
						reqlist.add(req.getRwfId());
				}
	
			  return "REQ-"+hondamap.get("abbreviation")+"-"+String.format("%05d",  reqlist.size()+1);
	 }
	 
        


	 
/**
 * By ChandraMouli S
 * @param depNumber
 * @return
 * @throws com.liferay.portal.kernel.json.JSONException
 * @throws IOException
 * @throws JSONException
 */
public static Map<String, String> singleCallOnServieNow(String depNumber) throws com.liferay.portal.kernel.json.JSONException, IOException, JSONException{
	
		Map<String,String> deptDivInfoMap = new HashMap<String,String>();
		CostCenterService costCenterService = new CostCenterService();
		JSONObject jSONObject= costCenterService.singleCalluserIsSameDepartment(depNumber);
		if(Validator.isNotNull(jSONObject)){
		JSONObject jsonObjLiferayDept = JSONFactoryUtil.createJSONObject(jSONObject.toString());
	    String deptName = jsonObjLiferayDept.getString("dpt_name");
	    String Division = jsonObjLiferayDept.getString("dv_u_name");
	   
	    String mpwrrep_email = jsonObjLiferayDept.getString("mpwrrep_email");
	    String mgr_email = jsonObjLiferayDept.getString("mgr_email");
	    String dpt_u_abbreviation = jsonObjLiferayDept.getString("dpt_u_abbreviation");
	    String mpwrrep_name = jsonObjLiferayDept.getString("mpwrrep_name");  //DMP
	    String dvmgr_name = jsonObjLiferayDept.getString("dvmgr_name");//DVM
	    String mgr_name = jsonObjLiferayDept.getString("mgr_name");//DM
	    
	    deptDivInfoMap.put("deptName", deptName);
	    deptDivInfoMap.put("divName", Division);
	    deptDivInfoMap.put("mpwrrep_email", mpwrrep_email);
	    deptDivInfoMap.put("mgr_email", mgr_email);
	    deptDivInfoMap.put("abbreviation", dpt_u_abbreviation);
	    deptDivInfoMap.put("mpwrrep_name", mpwrrep_name); //DMP Name
	    deptDivInfoMap.put("divMgrName", dvmgr_name); //DVM Name
	    deptDivInfoMap.put("deptMgrName", mgr_name); //DM Name
	    
	    }
		return deptDivInfoMap;
	}
public static List getccCodesonRequisitonGrid(String userParamater, String screenName) throws JSONException{
	JSONArray jsonArray  = null;
	CostCenterService serviceNowService = new CostCenterService();
	Map<String,String> departmentTreeMap= new TreeMap<String, String>();
	Map<String,String> deptInfoMap= new TreeMap<String, String>();
List<String> cclist=new ArrayList<String>();
	String mapJson = null;
	try {
		//deptInfoMap=	singleCallOnServieNow(depNum);
		try {
			mapJson = serviceNowService.getccCodesonRequisitonGrid(userParamater,screenName);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 if(mapJson != null && mapJson.trim().length() > 1){
			 
			 if(! mapJson.startsWith("[")) {
			 int i = mapJson.indexOf('[');
			 // int j = mapJson.indexOf(']');
			 	 if(i > 0) {
			 	  mapJson = mapJson.substring(i, mapJson.length()-1);
			 	 }
			 }

			
		jsonArray = JSONFactoryUtil.createJSONArray(mapJson);
		
		
		 for(int i=0; i < jsonArray.length();i++){
			  JSONObject jsonObjLiferayLocal =jsonArray.getJSONObject(i);
		//	  departmentTreeMap.put(jsonObjLiferayLocal.getString("cc_code"),jsonObjLiferayLocal.getString("dpt_u_abbreviation") );	
			  cclist.add(jsonObjLiferayLocal.getString("cc_code"));
			 
			 // dvmgr_name
	     }
		 //System.out.print(departmentTreeMap);
		 }

		//_log.info(cclist);
	} catch (com.liferay.portal.kernel.json.JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cclist;
}
	public static String convertNotification(String noticationTo, String cosid){
		
		 List<String> finallist= new ArrayList<String>();
		try {
			List<String> notificationList = new ArrayList<String>(Arrays.asList(noticationTo.split(",")));
		     WFMS_COS cos= WFMS_COSLocalServiceUtil.getByCos(cosid);
		    
		     for(String val:notificationList){
		   
		     if(val.equalsIgnoreCase("Creator / Staffing")){
		    	 if(cos.getSystemGenerated()==1 || cos.getSystemGenerated()==2 ){
		    		 val=HondaPermissionKeys.ROLE_STAFFING;
		    	 }
		    	 else{
		    		 val="Creator";
		    	 }
		     }
		     finallist.add(val);
	//	     _log.info(finallist);
		     }
		} catch (Exception e) {
		}
		     return StringUtil.merge(finallist, StringPool.COMMA);
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
		if(list.size()==0){
			_log.error(roleName+" having no Next approvers in HMA-WMS portal");
		}
		  return list;
	}
	
	
	/*
	 * id means  requisition id || cos id || pos ID
	 * By chandraMOuli S
	 * 
	 */
	public static String getassoNumbersByFilterd(String associteId ,String filerAction) throws SystemException{
		
		StringBuilder sb = new StringBuilder();
		String delim = "";
		if(filerAction.equalsIgnoreCase(WorkflowConstants.POSITION_ACTOIN)){
		DynamicQuery dynamicQueryForPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
		dynamicQueryForPosition.add(PropertyFactoryUtil.forName("associateNumber").ne("None"));
		Criterion positionCondition = null;
		positionCondition = RestrictionsFactoryUtil.ne("associateNumber", "");								
		positionCondition = RestrictionsFactoryUtil.or(positionCondition, RestrictionsFactoryUtil
				.eq("status", HondaPermissionKeys.POS_FILLED));
		dynamicQueryForPosition.add(positionCondition);
		List<WFMS_Position> positionList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQueryForPosition);
	
			for (WFMS_Position i : positionList) { if(Validator.isNotNull(i.getAssociateNumber().trim())){
			
					sb.append(delim).append("'" + i.getAssociateNumber().trim() + "'");
					delim = ",";
			}	}
			 DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
			   dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("associatenumber").ne(""));
			   dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
				Criterion reqcriterionCondition = null;
				reqcriterionCondition = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_CANCELLED);
				reqcriterionCondition = RestrictionsFactoryUtil.and(reqcriterionCondition, RestrictionsFactoryUtil
						.ne("status", HondaPermissionKeys.REQ_COMPLETE));
				dynamicQueryForRequisation.add(reqcriterionCondition);
				List<WFMS_Requisition> requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryForRequisation);
						
				for (WFMS_Requisition i : requisationList) {if(Validator.isNotNull(i.getAssociatenumber().trim()) &&
						!i.getAssociatenumber().trim().equalsIgnoreCase("None")){ 
					sb.append(delim).append("'" + i.getAssociatenumber().trim() + "'");
					delim = ",";
				}}
				 DynamicQuery dynamicQueryForCos= WFMS_COSLocalServiceUtil.dynamicQuery();
					Criterion cosCondition = null;
					dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
		//			dynamicQueryForCos.add(PropertyFactoryUtil.forName("assoicateId").ne(associteId));
					cosCondition = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_CANCELLED);
					cosCondition = RestrictionsFactoryUtil.and(cosCondition, RestrictionsFactoryUtil
							.ne("status", HondaPermissionKeys.COS_APPROVED));
					cosCondition = RestrictionsFactoryUtil.and(cosCondition, RestrictionsFactoryUtil
							.ne("status", HondaPermissionKeys.COS_DISAPPROVED));
					dynamicQueryForCos.add(cosCondition);
					List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
							
					for (WFMS_COS i : cosList) { if(Validator.isNotNull(i.getAssoicateId().trim())){
						sb.append(delim).append("'" + i.getAssoicateId().trim() + "'");
						delim = ",";
					}}
		}
				if(filerAction.equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_ACTION)){
			    	 DynamicQuery dynamicQueryForCos= WFMS_COSLocalServiceUtil.dynamicQuery();
					dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
					Criterion cosCondition = null;
					cosCondition = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_CANCELLED);
					cosCondition = RestrictionsFactoryUtil.and(cosCondition, RestrictionsFactoryUtil
							.ne("status", HondaPermissionKeys.COS_APPROVED));
					cosCondition = RestrictionsFactoryUtil.and(cosCondition, RestrictionsFactoryUtil
							.ne("status", HondaPermissionKeys.COS_DISAPPROVED));
					dynamicQueryForCos.add(cosCondition);
					List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
							
					for (WFMS_COS i : cosList) {if(Validator.isNotNull(i.getAssoicateId().trim())){
						sb.append(delim).append("'" + i.getAssoicateId().trim() + "'");
						delim = ",";
					}}
				}
				if(filerAction.equalsIgnoreCase(WorkflowConstants.REQUISITION_ACTION)){
					
						 DynamicQuery dynamicQueryForRequisation =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
							dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
					 //	 dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("associatenumber").ne(""));
					/* if(filerAction.equalsIgnoreCase(WorkflowConstants.REQUISITION_ACTION) && Validator.isNotNull(associteId)){
						   dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("associatenumber").ne(associteId));
						 }*/
							Criterion reqcriterionCondition = null;
							reqcriterionCondition = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_CANCELLED);
							reqcriterionCondition = RestrictionsFactoryUtil.and(reqcriterionCondition, RestrictionsFactoryUtil
									.ne("status", HondaPermissionKeys.REQ_COMPLETE));
							dynamicQueryForRequisation.add(reqcriterionCondition);
							List<WFMS_Requisition> requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryForRequisation);
							for (WFMS_Requisition i : requisationList) {
							if(Validator.isNotNull(i.getAssociatenumber().trim()) &&  !i.getAssociatenumber().trim().equalsIgnoreCase("None")&&
									!i.getAssociatenumber().equalsIgnoreCase(associteId)
									){
								sb.append(delim).append("'" + i.getAssociatenumber().trim() + "'");
								delim = ",";
							}	}
							 DynamicQuery dynamicQueryForCos= WFMS_COSLocalServiceUtil.dynamicQuery();
								Criterion cosCondition = null;
								dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
								cosCondition = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_CANCELLED);
								cosCondition = RestrictionsFactoryUtil.and(cosCondition, RestrictionsFactoryUtil
										.ne("status", HondaPermissionKeys.COS_APPROVED));
								cosCondition = RestrictionsFactoryUtil.and(cosCondition, RestrictionsFactoryUtil
										.ne("status", HondaPermissionKeys.COS_DISAPPROVED));
								dynamicQueryForCos.add(cosCondition);
								List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
									//	_log.info(cosList);
								for (WFMS_COS i : cosList) { if(Validator.isNotNull(i.getAssoicateId().trim())){
									sb.append(delim).append("'" + i.getAssoicateId().trim() + "'");
									delim = ",";}
								}
					
				}
				
		return sb.toString();
	}
	
	public static Map<String,String> getChangeDesOnAction(WFMS_COS cos)  {
		
		   Map<String, String> actionMap= new HashMap<String, String>();
				try {
					if(Validator.isNotNull(cos)){
					 DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
					 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionName").eq(cos.getAction()));
					  List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
					  if(actionListof.size()>0){
					        DynamicQuery userQuery = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery();
							userQuery.add(RestrictionsFactoryUtil.eq("action",  actionListof.get(0).getActionId()));
							ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
							projectionList.add(PropertyFactoryUtil.forName("rapId"));
							projectionList.add(PropertyFactoryUtil.forName("changeDescription"));
							userQuery.setProjection(projectionList);
							 
				List<Object[]> userInfoList = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery(userQuery);
				for (Object[] userInfo : userInfoList) {
				actionMap.put(userInfo[0]+"", userInfo[1]+"");
				}}}
				} catch (SystemException e) {
				_log.error(e);
				}
				return actionMap;
	}
	
	
	
	/**
	 * Auto approvals logic
	 * By ChandraMouli S
	 * @param   WFMS_COS cos
	 * @return WFMS_COS object
	 */
	
	public static WFMS_COS AutoApproverList(WFMS_COS cos){
	    	List<String> uniqueIndex = new ArrayList<String>();
		    String roleArray[] = cos.getApproverList().split(",");
		    List<String> lisapprovals = Arrays.asList(roleArray);
		try { 
			 String ccName=StringPool.BLANK;
			 String LoopccName=StringPool.BLANK;
				if(lisapprovals.size()>0){  
					 for(int i=0;i<lisapprovals.size();i++){
						
						  for(int j=i+1; j<lisapprovals.size();j++){
							  
					   // 	 if(Validator.isNotNull(i+"")){
								 if((lisapprovals.get(i).equals(HondaPermissionKeys.COS_CURRENT_DM) ) ){
								  ccName=  getCCName(cos ,HondaPermissionKeys.COS_CURRENT_DM); 
							 }
							 else if(lisapprovals.get(i).equals(HondaPermissionKeys.COS_NEW_DM)){
								  ccName=  getCCName(cos ,HondaPermissionKeys.COS_NEW_DM);
							 }
							 else if(lisapprovals.get(i).equals(HondaPermissionKeys.COS_CURRENT_DVM) ){
								 ccName=  getCCName(cos ,HondaPermissionKeys.COS_CURRENT_DVM); ; 
							 }
							 else if( lisapprovals.get(i).equals(HondaPermissionKeys.COS_NEW_DVM)){
								  ccName=  getCCName(cos ,HondaPermissionKeys.COS_NEW_DVM);
							 }
							 else{
								 ccName= lisapprovals.get(i);
							 }
							// }
						//	if(Validator.isNotNull(j+"")){
							
								 if((lisapprovals.get(j).equals(HondaPermissionKeys.COS_CURRENT_DM) ) ){
									 LoopccName=  getCCName(cos ,HondaPermissionKeys.COS_CURRENT_DM); 
								 }
								 else if(lisapprovals.get(j).equals(HondaPermissionKeys.COS_NEW_DM)){
									 LoopccName=  getCCName(cos ,HondaPermissionKeys.COS_NEW_DM);
								 }
								 else if(lisapprovals.get(j).equals(HondaPermissionKeys.COS_CURRENT_DVM) ){
									 LoopccName=  getCCName(cos ,HondaPermissionKeys.COS_CURRENT_DVM);  
								 }
								 else if( lisapprovals.get(j).equals(HondaPermissionKeys.COS_NEW_DVM)){
									 LoopccName=  getCCName(cos ,HondaPermissionKeys.COS_NEW_DVM); 
								 }
								 else{
									 LoopccName= lisapprovals.get(j);
							//	 }
							}
							 if(ccName.equalsIgnoreCase(LoopccName)){
								 uniqueIndex.add(j+"");
								 }
						 }
					 }
				 }
		} catch (Exception e) {
          _log.error(e);
		}
		 Set<String> hs = new HashSet<String>();
		 hs.addAll(uniqueIndex);
		 uniqueIndex.clear();
		 uniqueIndex.addAll(hs);
		 	List<String> sortedlist = new ArrayList<String>(Arrays.asList(roleArray));
		 try {	
		   for(int i=0;i<uniqueIndex.size();i++){
		            for(int j=0;j<sortedlist.size();j++){
		                if(uniqueIndex.get(i).equals(j+"")){
		                	sortedlist.set(j, "&");
		                       break;
		                }
		            }
		        }
		   List finalList= new ArrayList();
		   for(int j=0;j<sortedlist.size();j++){
               if(!sortedlist.get(j).equals("&")) {
            	   finalList.add(sortedlist.get(j));
               }
           }
			 StringBuilder commaSepValueBuilder = new StringBuilder();
			 for ( int i = 0; i< finalList.size(); i++){
			      commaSepValueBuilder.append(finalList.get(i));
			      if ( i != finalList.size()-1){
			        commaSepValueBuilder.append(",");
			      }
			    }
		 cos.setSortApprovedList(commaSepValueBuilder.toString());
			WFMS_COSLocalServiceUtil.updateCos(cos);
		} catch (SystemException e) {
			 _log.error(e);
		}
		return cos;
	}
 

	
	/**
	 * This Function for fetching the Approver Name from ServiceNow 
	 * By ChandraMouli S
	 * @param   WFMS_COS cos , String roleName
	 * @return userName
	 */
	public static String getCCName(WFMS_COS wfms_cos,String roleName){
				 Map<String, String> costmap=null;
				 String userName=StringPool.BLANK;
				 String AsscbasedDept =StringPool.BLANK;
				 try {
					 if((roleName.equals(HondaPermissionKeys.COS_CURRENT_DM) ) ){
						 costmap = HondaLogicUtil.singleCallOnServieNow(wfms_cos.getCurrentDepartmentNumber());
						 userName =costmap.get("deptMgrName");
						 }
					
					  if(roleName.equals(HondaPermissionKeys.COS_NEW_DM)){
						  if(wfms_cos.getNewJobCode().equals("PA") || wfms_cos.getNewJobCode().equals("TC") || wfms_cos.getNewPositionNumber().equals("None")){
								 AsscbasedDept = wfms_cos.getSameDept();
							 }else{
								 AsscbasedDept = wfms_cos.getNewDepartmentNumber();
							 }
						 costmap = HondaLogicUtil.singleCallOnServieNow(AsscbasedDept);
						 userName =costmap.get("deptMgrName");
					 }
					  if(roleName.equals(HondaPermissionKeys.COS_CURRENT_DVM) ){
						   costmap = HondaLogicUtil.singleCallOnServieNow(wfms_cos.getCurrentDepartmentNumber());
						   userName =costmap.get("divMgrName");
					 }
					  if( roleName.equals(HondaPermissionKeys.COS_NEW_DVM)){
						  if(wfms_cos.getNewJobCode().equals("PA") || wfms_cos.getNewJobCode().equals("TC") || wfms_cos.getNewPositionNumber().equals("None")){
								 AsscbasedDept = wfms_cos.getSameDept();
							 }else{
								 AsscbasedDept = wfms_cos.getNewDepartmentNumber();
							 }
						 costmap = HondaLogicUtil.singleCallOnServieNow(AsscbasedDept);
						   userName =costmap.get("divMgrName");
					 }
					 
				 
				 } catch (Exception e) {
					 _log.error(e);
				}
				 return userName;
			}
	private static Log _log = LogFactoryUtil.getLog(HondaLogicUtil.class.getName());

}
