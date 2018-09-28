package com.ys.hmawfm.wfms.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;
import com.ys.hmawfm.wfms.workflow.WorkflowConstants;

public class DatagridDisplayManagerUtil {

private static Log _log = LogFactoryUtil.getLog(DatagridDisplayManagerUtil.class.getName());

/**
 * 
 * @param type
 * @return
 * @throws SystemException 
 * @throws JSONException 
 * @throws IOException 
 * @throws PortalException 
 * @throws JsonGenerationException 
 */
	public static JSONObject getPositionList(String type,PortletRequest renderRequest ) throws SystemException,  PortalException, IOException, JSONException{
	
	// Result Types
	//"listByAssociateNumber" 	(10 columns), 	"listPendingAndModified" 	(8  columns),
	//"listByDepartment" 	 (16 columns), 	"listByPositionNumber" 	 (22 columns),
	//"listByStatus" 	 (14 columns), 	"listByLastChangeDate" 	 (6  columns),
	//"listByAssociateHistory" 	(4  columns), 	"listReportView" 	 (33 columns)
		List<WFMS_Position> list = null;
	JSONObject json = JSONFactoryUtil.createJSONObject();
	JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	JSONArray jsonData = JSONFactoryUtil.createJSONArray();
	
	DynamicQuery dynamicQuery = WFMS_PositionLocalServiceUtil.dynamicQuery();
	Criterion criterion = null;
	
	criterion = RestrictionsFactoryUtil.eq("dummy", "0");
	if(type.equalsIgnoreCase("listPendingAndModified")){
		
		criterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.POS_PENDING);
		criterion = RestrictionsFactoryUtil.or(criterion , RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.POS_MODFIED));
		
	}
	dynamicQuery.add(criterion);
	
	try{
	    list = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQuery);
	   // list=WFMS_PositionLocalServiceUtil.findBydummy("0");
	}catch(SystemException ex){
		_log.error("WFMS_PositionLocalServiceUtil has SystemException in DatagridDisplayManagerUtil.getPositionList()", ex);
	}
	List<List<String>> dataSet = new ArrayList<List<String>>();
//	if(WMSUserAccessUtil.isUserHaveRole(renderRequest, PortletPropsPermission.REQ_VIEW_REQ_GRID)){
	if(type.equalsIgnoreCase("listByAssociateNumber")){
		for(WFMS_Position position: list){
			jsonArray = JSONFactoryUtil.createJSONArray();
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
		     String id=position.getPId();
		     if(position.getPId().contains("-WFM")){
		    	 
		    	 id=id.replace("-WFM", "");
		    	 jsonArray.put(id.trim());
		     }
		     else {
		    	 jsonArray.put(position.getPId());
		     }
		     
			jsonArray.put(position.getReportsTo());
			jsonArray.put(position.getDivision());
			jsonArray.put(position.getDepartmentName());
			jsonArray.put(position.getLadder());
			jsonArray.put(position.getLevel());
			jsonArray.put(position.getDescription());
			jsonArray.put(position.getLeadershipAssignment());
			jsonData.put(jsonArray);
		}
	} else if (type.equalsIgnoreCase("listPendingAndModified")){
		for(WFMS_Position position: list){
			jsonArray = JSONFactoryUtil.createJSONArray();
			String mainPos_id="";
			String mainPos_status="";
		     List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(position.getPId());
		     if(finalstep.size()!=0){
		      for(WFMS_Position pos:finalstep){
		     mainPos_id = pos.getPId();
		     mainPos_status=pos.getStatus();
		     mainPos_id= mainPos_id.replace("-WFM", "");
		     jsonArray.put(mainPos_id);
		      }
		     }
		     else {
		    		jsonArray.put(position.getPId());
		     }
		
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
			 if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_status=pos.getStatus();
			     jsonArray.put(mainPos_status);
			      }
			     }
			 else {jsonArray.put(position.getStatus());}
			 jsonArray.put(restrictMaxlenghtString(position.getNextApprover(),position.getStatus()));
			jsonArray.put(position.getDivision());
			jsonArray.put(position.getDepartmentName());
			jsonArray.put(position.getLadder());
			jsonArray.put(position.getType());
			jsonData.put(jsonArray);
		}
	} else if (type.equalsIgnoreCase("listByDepartment")){
		for(WFMS_Position position: list){
			String mainPos_id="";
			String mainPos_status="";
		     List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(position.getPId());
			jsonArray = JSONFactoryUtil.createJSONArray();
			jsonArray.put(position.getDivision());
			jsonArray.put(position.getDepartmentName());
			 if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_status=pos.getStatus();
			     jsonArray.put(mainPos_status);
			      }
			     }
			 else {jsonArray.put(position.getStatus());}
			jsonArray.put(position.getReportsTo());
		
		     if(finalstep.size()!=0){
		      for(WFMS_Position pos:finalstep){
		     mainPos_id = pos.getPId();
		     mainPos_status=pos.getStatus();
		     mainPos_id= mainPos_id.replace("-WFM", "");
		     jsonArray.put(mainPos_id);
		      }
		     }
		     else {
		    		jsonArray.put(position.getPId());
		     }
		
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
			jsonArray.put(position.getMpCatBugdet());
			jsonArray.put(position.getMpCatFilledWith());
			jsonArray.put(position.getLadder());
			jsonArray.put(position.getType());
			jsonArray.put(position.getLevel());
			jsonArray.put(position.getCategory());
			jsonArray.put(position.getDescription());
			jsonArray.put(position.getYearEst());
			String ReasonsFor="";
			if(position.getReasonsFor().length()>26){
				ReasonsFor = position.getReasonsFor().substring(0, 25) + "...";
			}
			else
			{
				ReasonsFor=position.getReasonsFor();
			}
			jsonArray.put(ReasonsFor);
			jsonData.put(jsonArray);
		}
	} else if (type.equalsIgnoreCase("listByPositionNumber")){
		for(WFMS_Position position: list){
			String mainPos_id="";
			String mainPos_status="";
		     List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(position.getPId());
			jsonArray = JSONFactoryUtil.createJSONArray();
			 if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_id = pos.getPId();
			     mainPos_status=pos.getStatus();
			     mainPos_id= mainPos_id.replace("-WFM", "");
			     jsonArray.put(mainPos_id);
			      }
			     }
			     else {
			    		jsonArray.put(position.getPId());
			     }
			jsonArray.put(position.getReportsTo());
			jsonArray.put(position.getDivision());
			jsonArray.put(position.getDepartmentName());
			 if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_status=pos.getStatus();
			     jsonArray.put(mainPos_status);
			      }
			     }
			 else {jsonArray.put(position.getStatus());}
			jsonArray.put(position.getLine());
			jsonArray.put(position.getLadder());
			jsonArray.put(position.getMpCatBugdet());
			jsonArray.put(position.getMpCatFilledWith());
			jsonArray.put(position.getPositionClass());
			jsonArray.put(position.getType());
			jsonArray.put(position.getLevel());
			jsonArray.put(position.getLeadershipAssignment());
			jsonArray.put(position.getCategory());
			jsonArray.put(position.getSubCategory());
			jsonArray.put(position.getDescription());
			jsonArray.put(position.getYearEst());
			String ReasonsFor="";
			if(position.getReasonsFor().length()>26){
				ReasonsFor = position.getReasonsFor().substring(0, 25) + "...";
			}
			else
			{
				ReasonsFor=position.getReasonsFor();
			}
			jsonArray.put(ReasonsFor);
			jsonArray.put(position.getReavailuationDate());
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
			boolean critical=position.getCritical();
			String workforce=null;
			if(critical==true)
			{
			workforce="Yes";
			}
			else
			{
		    workforce="No";
			}
			jsonArray.put(workforce);
			jsonData.put(jsonArray);
		}
	} else if (type.equalsIgnoreCase("listByStatus")){
		for(WFMS_Position position: list){
			String mainPos_id="";
			String mainPos_status="";
			
		     List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(position.getPId());
			jsonArray = JSONFactoryUtil.createJSONArray();
			
			 if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_status=pos.getStatus();
			     jsonArray.put(mainPos_status);
			      }
			     }
			 else {jsonArray.put(position.getStatus());}
			 jsonArray.put(restrictMaxlenghtString(position.getNextApprover(),position.getStatus()));
			 
			 if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_id = pos.getPId();
			     mainPos_id= mainPos_id.replace("-WFM", "");
			     mainPos_status=pos.getStatus();
			     jsonArray.put(mainPos_id);
			      }
			     }
			     else {
			    	    mainPos_id= position.getPId().replace("-WFM", "");
			    		jsonArray.put(mainPos_id);
			     }
			
			jsonArray.put(position.getDivision());
			jsonArray.put(position.getDepartmentName());
			jsonArray.put(position.getMpCatBugdet());
			jsonArray.put(position.getLadder());
			jsonArray.put(position.getType());
			jsonArray.put(position.getLevel());
			jsonArray.put(position.getCategory());
			jsonArray.put(position.getDescription());
			jsonArray.put(position.getYearEst());
			String ReasonsFor="";
			if(position.getReasonsFor().length()>26){
				ReasonsFor = position.getReasonsFor().substring(0, 25) + "...";
			}
			else
			{
				ReasonsFor=position.getReasonsFor();
			}
			jsonArray.put(ReasonsFor);
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
			
			jsonData.put(jsonArray);
		}
	} else if (type.equalsIgnoreCase("listByLastChangeDate")){
		for(WFMS_Position position: list){
			  String lastDiscription="";
			     Date lastChangeDate= null;
			    
			 if(position.getPId() != null){
			   
		    	 //wfms_auditlist = WFMS_Position_AuditLocalServiceUtil.findByPosIdForAudit(position.getPId());
		    	 DynamicQuery posAuditInfo =WFMS_Position_AuditLocalServiceUtil.dynamicQuery();
		    		 posAuditInfo.add(PropertyFactoryUtil.forName("pId").eq(position.getPId()));
		    		 posAuditInfo.addOrder(OrderFactoryUtil.desc("paId"));
				List<WFMS_Position_Audit> wfmPositionAudits = WFMS_PositionLocalServiceUtil.dynamicQuery(posAuditInfo);
				if(wfmPositionAudits.size()>0){
					lastDiscription=wfmPositionAudits.get(0).getChange();
					lastChangeDate = wfmPositionAudits.get(0).getCreateDate();
				}
		     }
			
		   //  List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(position.getPId());
		     List<WFMS_Position_Audit> wfms_auditlist = null;
		
			jsonArray = JSONFactoryUtil.createJSONArray();
			
			/* if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			    	 Date	date=null;
					if(null!=position.getModifiedDate()){
					date= position.getModifiedDate();
					}else if(null!=position.getCreateDate()){
					date = position.getCreateDate();
					}
					jsonArray.put(HondaLogicUtil.getDateFormat(date));
			      }
			     }*/
			// Date	date=null;
		if(null != position.getModifiedDate()){
				jsonArray.put(convertintoLong(position.getModifiedDate()));
				jsonArray.put(HondaLogicUtil.getDateFormat(position.getModifiedDate()));
			} else {
				jsonArray.put(convertintoLong(lastChangeDate));
				jsonArray.put(HondaLogicUtil.getDateFormat(lastChangeDate));
			}

			 
			String mainPos_id= position.getPId().replace("-WFM", "");
			jsonArray.put(mainPos_id);
			jsonArray.put(position.getDescription());
			//jsonArray.put(position.getDivision());
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
			if(lastDiscription != null)jsonArray.put(lastDiscription); else jsonArray.put("");
			jsonData.put(jsonArray);
		}
	} else if (type.equalsIgnoreCase("listByAssociateHistory")){
		for(WFMS_Position position: list){
			String mainPos_id="";
			String mainPos_status="";
		     List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(position.getPId());
			jsonArray = JSONFactoryUtil.createJSONArray();
			
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
			if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_id = pos.getPId();
			     mainPos_status=pos.getStatus();
			     mainPos_id= mainPos_id.replace("-WFM", "");
			     jsonArray.put(mainPos_id);
			      }
			     }
			     else {
			    		jsonArray.put(position.getPId());
			     }
			jsonArray.put(position.getHistory());
			
			jsonData.put(jsonArray);
		}
	} else if(type.equalsIgnoreCase("listReportView")) {
	
		for(WFMS_Position position: list){
			String mainPos_id="";
			String mainPos_status="";
		     List<WFMS_Position> finalstep = WFMS_PositionLocalServiceUtil.findByworkflowId(position.getPId());
			jsonArray = JSONFactoryUtil.createJSONArray();
			
			if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_id = pos.getPId();
			     
			     mainPos_id= mainPos_id.replace("-WFM", "");
					
					
			     mainPos_status=pos.getStatus();
			     jsonArray.put(mainPos_id);
			      }
			     }
			     else {
			    		jsonArray.put(position.getPId());
			     }
			jsonArray.put(position.getReportsTo());
			jsonArray.put(position.getDivision());
			jsonArray.put(position.getDepartmentName());
			if(finalstep.size()!=0){
			      for(WFMS_Position pos:finalstep){
			     mainPos_status=pos.getStatus();
			     jsonArray.put(mainPos_status);
			      }
			     }
			 else {
				 	jsonArray.put(position.getStatus());}
			jsonArray.put(position.getLine());
			jsonArray.put(position.getLadder());
			jsonArray.put(position.getMpCatBugdet());
			jsonArray.put(position.getMpCatFilledWith());
			jsonArray.put(position.getPositionClass());
			jsonArray.put(position.getType());
			jsonArray.put(position.getLevel());
			jsonArray.put(position.getLeadershipAssignment());
			jsonArray.put(position.getCategory());
			jsonArray.put(position.getSubCategory());
			jsonArray.put(position.getEmpCategory());
			jsonArray.put(position.getEmpCategoryDesc());
			jsonArray.put(position.getDescription());
				
			jsonArray.put(position.getYearEst());
			//jsonArray.put(position.getReasonsFor());
			
				String ReasonsFor="";
				if(position.getReasonsFor().length()>26){
					ReasonsFor = position.getReasonsFor().substring(0, 25) + "...";
				}
				else
				{
					ReasonsFor=position.getReasonsFor();
				}
				jsonArray.put(ReasonsFor);
				
			jsonArray.put(position.getReavailuationDate());
			jsonArray.put(position.getAssociateNumber());
			jsonArray.put(position.getAssociateName());
			jsonArray.put(position.getAssociateTitle());
			boolean critical=position.getCritical();
			String workforce=null;
			if(critical==true)
			{
			workforce="Yes";
			}
			else
			{
		    workforce="No";
			}
			jsonArray.put(workforce);
			//jsonArray.put(position.getTypicalJobTitle());
			
			String TypicalJobTitle="";
			if(position.getTypicalJobTitle().length()>26){
				TypicalJobTitle = position.getTypicalJobTitle().substring(0, 25) + "...";
			}
			
			else
			{
				TypicalJobTitle=position.getTypicalJobTitle();
			}
			jsonArray.put(TypicalJobTitle.trim())
			;
			
					String MinJobKnowHow="";
						if(position.getMinJobKnowHow().length()>26){
							MinJobKnowHow = position.getMinJobKnowHow().substring(0, 25) + "...";
						}
						
						else
						{
							MinJobKnowHow=position.getMinJobKnowHow();
						}
						jsonArray.put(MinJobKnowHow)
						;
			//jsonArray.put(position.getDuties());

			String Duties="";
				if(position.getDuties().length()>26){
					Duties = position.getDuties().substring(0, 25) + "...";
				}
				
				else
				{
					Duties=position.getDuties();
				}
				jsonArray.put(Duties)
				;
				
			//jsonArray.put(position.getTasksPerformed());
				String TasksPerformed="";
				if(position.getTasksPerformed().length()>26){
					TasksPerformed = position.getTasksPerformed().substring(0, 25) + "...";
				}
				
				else
				{
					TasksPerformed=position.getTasksPerformed();
				}
				jsonArray.put(TasksPerformed)
				;
			//jsonArray.put(position.getLengthOfService());
				String LengthOfService="";
				if(position.getLengthOfService().length()>26){
					LengthOfService = position.getLengthOfService().substring(0, 25) + "...";
				}
				
				else
				{
					LengthOfService=position.getLengthOfService();
				}
				jsonArray.put(LengthOfService)
				;
				
			//jsonArray.put(position.getDegree());
				

				String Degree="";
				if(position.getDegree().length()>26){
					Degree = position.getDegree().substring(0, 25) + "...";
				}
				
				else
				{
					Degree=position.getDegree();
				}
				jsonArray.put(Degree)
				;
			
			//jsonArray.put(position.getReqSkills());
			
			String ReqSkills="";
			if(position.getReqSkills().length()>26){
				ReqSkills = position.getReqSkills().substring(0, 25) + "...";
			}
			
			else
			{
				ReqSkills=position.getReqSkills();
			}
			jsonArray.put(ReqSkills)
			;
			
			//jsonArray.put(position.getDesiredSkills());
			String DesiredSkills="";
			if(position.getDesiredSkills().length()>26){
				DesiredSkills = position.getDesiredSkills().substring(0, 25) + "...";
			}
			
			else
			{
				DesiredSkills=position.getDesiredSkills();
			}
			jsonArray.put(DesiredSkills)
			;
			
			
			
			jsonData.put(jsonArray);
		}
//	}
	}	return json.put("data", jsonData );
  }

/**
 * 
 * @param type
 * @return
 * @throws IOException 
 * @throws SystemException 
 * @throws PortalException 
 * @throws JsonGenerationException 
 * @throws JSONException 
 */
	public static JSONObject getCOSList(String type,PortletRequest renderRequest) throws  PortalException, SystemException, IOException, JSONException{
		 
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONArray jsonData = JSONFactoryUtil.createJSONArray();
		
		DynamicQuery dynamicQuery = WFMS_COSLocalServiceUtil.dynamicQuery();
		List<WFMS_COS> list = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
	    Criterion criterion = null;
		
	    if(type.equalsIgnoreCase("ByCreator") || type.equalsIgnoreCase("OpenByStatus") || type.equalsIgnoreCase("ByEffectiveDate")||
	    		type.equalsIgnoreCase("ByAnnounced")){
		criterion = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_CANCELLED);
		
		
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_APPROVED));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_DISAPPROVED));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("announced", 1));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("deleteflagStatus", 0));
		//criterion = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.POS_APPROVED);
		dynamicQuery.add(criterion);
	    }
		
		
		try{
			criterion = 
					RestrictionsFactoryUtil.eq("deleteflagStatus", 0);
			dynamicQuery.add(criterion);
			list = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQuery);
		}catch(SystemException ex){
		_log.error("WFMS_COSLocalServiceUtil has SystemException in DatagridDisplayManagerUtil.getCOSList()" +ex);
		}
		List<String> ccCodeslist=null;
		
		List<List<String>> dataSet = new ArrayList<List<String>>();
		if(WMSUserAccessUtil.isUserHaveRole(renderRequest, PortletPropsPermission.REQ_VIEW_REQ_GRID)){
		ccCodeslist=	WMSUserAccessUtil.getccCodelistOnRequistionGrid(renderRequest,PortletPropsPermission.REQ_VIEW_REQ_GRID);
//		_log.info(ccCodeslist);
		 if (type.equalsIgnoreCase("ByStatus")){
			for(WFMS_COS changeofstatus: list){
				//if(WMSUserAccessUtil.checkPermissionForCOS(renderRequest,PortletPropsPermission.COS_VIEW,changeofstatus.getNewDepartmentName())){
				String AsscbasedDept=StringPool.BLANK;
				 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
					 AsscbasedDept = changeofstatus.getSameDept();
				 }else{
					 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
				 }
						if(ccCodeslist.size()>0 && (!compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber()) &&  !compareDepartmentList(ccCodeslist,AsscbasedDept))){
							  continue;
							}
			//	}

				/*if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_CURRENT_DVM)){
						if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber())){
							  continue;
							}
				}
				 if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DM)){
					String AsscbasedDept=StringPool.BLANK;
					 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
						 AsscbasedDept = changeofstatus.getSameDept();
					 }else{
						 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
					 }
					if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,AsscbasedDept)){
						  continue;
						}
				}

					if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DVM)){
					String AsscbasedDept=StringPool.BLANK;
					 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
						 AsscbasedDept = changeofstatus.getSameDept();
					 }else{
						 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
					 }
					if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,AsscbasedDept)){
						  continue;
						}*/
			//	}
				jsonArray = JSONFactoryUtil.createJSONArray();
				
				//jsonArray.put("");
				jsonArray.put(changeofstatus.getStatus());
				jsonArray.put(changeofstatus.getEffectiveDate());
				jsonArray.put(changeofstatus.getAssoicateId());
				jsonArray.put(changeofstatus.getAssociatename());
				if(changeofstatus.getApproverStep() != -1) jsonArray.put(restrictMaxlenghtString(changeofstatus.getNextApprover(),changeofstatus.getStatus()));else jsonArray.put("");
				jsonArray.put(changeofstatus.getCosId());
				jsonArray.put(HondaLogicUtil.getDateFormat(changeofstatus.getCreateDate()));
				
				jsonData.put(jsonArray);
				//}
			}
		} 
		 else if (type.equalsIgnoreCase("ByAnnounced")){
				for(WFMS_COS changeofstatus: list){
					//if(WMSUserAccessUtil.checkPermissionForCOS(renderRequest,PortletPropsPermission.COS_VIEW,changeofstatus.getNewDepartmentName())){
					String AsscbasedDept=StringPool.BLANK;
					 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
						 AsscbasedDept = changeofstatus.getSameDept();
					 }else{
						 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
					 }
							if(ccCodeslist.size()>0 && (!compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber()) &&  !compareDepartmentList(ccCodeslist,AsscbasedDept))){
								  continue;
								}
				//	}

					/*if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_CURRENT_DVM)){
							if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber())){
								  continue;
								}
					}
					 if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DM)){
						String AsscbasedDept=StringPool.BLANK;
						 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
							 AsscbasedDept = changeofstatus.getSameDept();
						 }else{
							 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
						 }
						if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,AsscbasedDept)){
							  continue;
							}
					}

						if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DVM)){
						String AsscbasedDept=StringPool.BLANK;
						 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
							 AsscbasedDept = changeofstatus.getSameDept();
						 }else{
							 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
						 }
						if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,AsscbasedDept)){
							  continue;
							}*/
				//	}
					jsonArray = JSONFactoryUtil.createJSONArray();
					
					//jsonArray.put("");
					String annouced=StringPool.BLANK;
					if(changeofstatus.getAnnounced()==1){annouced="YES" ;}else annouced="NO";
					jsonArray.put(annouced);
					//jsonArray.put(changeofstatus.getStatus());
					jsonArray.put(changeofstatus.getEffectiveDate());
					jsonArray.put(changeofstatus.getAssoicateId());
					jsonArray.put(changeofstatus.getAssociatename());
					if(changeofstatus.getApproverStep() != -1) jsonArray.put(restrictMaxlenghtString(changeofstatus.getNextApprover(),changeofstatus.getStatus()));else jsonArray.put("");
					jsonArray.put(changeofstatus.getCosId());
					jsonArray.put(HondaLogicUtil.getDateFormat(changeofstatus.getCreateDate()));
					
					jsonData.put(jsonArray);
					//}
				}
			}
		 else if(type.equalsIgnoreCase("ByCreator")){
			for(WFMS_COS changeofstatus: list){
				//if(WMSUserAccessUtil.checkPermissionForCOS(renderRequest,PortletPropsPermission.COS_VIEW,changeofstatus.getNewDepartmentName())){
				String AsscbasedDept=StringPool.BLANK;
				 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
					 AsscbasedDept = changeofstatus.getSameDept();
				 }else{
					 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
				 }
					if(ccCodeslist.size()>0  && (!compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber()) &&  !compareDepartmentList(ccCodeslist,AsscbasedDept))){
							  continue;
							}
				jsonArray = JSONFactoryUtil.createJSONArray();
				
				if(changeofstatus !=null && (changeofstatus.getSystemGenerated() == 1 || changeofstatus.getSystemGenerated() == 2)){
					jsonArray.put(HondaPermissionKeys.COS_SYSTEM_GENERATE);
				}
				else{
					jsonArray.put(changeofstatus.getCreatedBy());
				}
				
				//jsonArray.put(changeofstatus.getCreatedBy());
				
				jsonArray.put(changeofstatus.getAssoicateId());
				jsonArray.put(changeofstatus.getCosId());
				jsonArray.put(changeofstatus.getAssociatename());
				jsonArray.put(changeofstatus.getStatus());
				jsonArray.put(changeofstatus.getEffectiveDate());
				if(changeofstatus.getApproverStep() != -1) jsonArray.put(restrictMaxlenghtString(changeofstatus.getNextApprover(),changeofstatus.getStatus()));else jsonArray.put("");
				jsonArray.put(HondaLogicUtil.getDateFormat(changeofstatus.getCreateDate()));
			    jsonData.put(jsonArray);
			  //  }
			}
		} else if (type.equalsIgnoreCase("OpenByStatus")){
			for(WFMS_COS changeofstatus: list){
				//if(WMSUserAccessUtil.checkPermissionForCOS(renderRequest,PortletPropsPermission.COS_VIEW,changeofstatus.getNewDepartmentName())){
				String AsscbasedDept=StringPool.BLANK;
				 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
					 AsscbasedDept = changeofstatus.getSameDept();
				 }else{
					 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
				 }
					if(ccCodeslist.size()>0  && (!compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber()) &&  !compareDepartmentList(ccCodeslist,AsscbasedDept))){
							  continue;
							}
				jsonArray = JSONFactoryUtil.createJSONArray();
				
				jsonArray.put(changeofstatus.getCosId());
				//jsonArray.put("");
				jsonArray.put(changeofstatus.getStatus());
				jsonArray.put(changeofstatus.getEffectiveDate());
				
				jsonArray.put(changeofstatus.getAssoicateId());
				jsonArray.put(changeofstatus.getAssociatename());
				if(changeofstatus.getApproverStep() != -1) jsonArray.put(restrictMaxlenghtString(changeofstatus.getNextApprover(),changeofstatus.getStatus()));else jsonArray.put("");
				jsonArray.put(HondaLogicUtil.getDateFormat(changeofstatus.getCreateDate()));
				if(changeofstatus.getPositionNumber().equalsIgnoreCase("undefined")) {jsonArray.put("");}
				else{
					jsonArray.put(changeofstatus.getPositionNumber());
				}
				if(changeofstatus.getNewPositionNumber().equalsIgnoreCase("undefined")) {
					jsonArray.put("");
				}
				else{
					jsonArray.put(changeofstatus.getNewPositionNumber());
				}
				jsonData.put(jsonArray);
			  //}
			}
		}else if (type.equalsIgnoreCase("ByEffectiveDate")){
			for(WFMS_COS changeofstatus: list){
				//if(WMSUserAccessUtil.checkPermissionForCOS(renderRequest,PortletPropsPermission.COS_VIEW,changeofstatus.getNewDepartmentName())){
				String AsscbasedDept=StringPool.BLANK;
				 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
					 AsscbasedDept = changeofstatus.getSameDept();
				 }else{
					 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
				 }
					if(ccCodeslist.size()>0 && (!compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber()) && !compareDepartmentList(ccCodeslist,AsscbasedDept))){
							  continue;
							}
				jsonArray = JSONFactoryUtil.createJSONArray();
				jsonArray.put(changeofstatus.getEffectiveDate());
				jsonArray.put(changeofstatus.getStatus());
				jsonArray.put(changeofstatus.getAssoicateId());
				jsonArray.put(changeofstatus.getCosId());
				jsonArray.put(changeofstatus.getAssociatename());
				if(changeofstatus.getApproverStep() != -1) jsonArray.put(restrictMaxlenghtString(changeofstatus.getNextApprover(),changeofstatus.getStatus()));else jsonArray.put("");
				jsonArray.put(HondaLogicUtil.getDateFormat(changeofstatus.getCreateDate()));
				jsonData.put(jsonArray);
			 // }
			}
			
		}else if (type.equalsIgnoreCase("ByAssociateNumber")){
			for(WFMS_COS changeofstatus: list){
				//if(WMSUserAccessUtil.checkPermissionForCOS(renderRequest,PortletPropsPermission.COS_VIEW,changeofstatus.getNewDepartmentName())){
				String AsscbasedDept=StringPool.BLANK;
				 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
					 AsscbasedDept = changeofstatus.getSameDept();
				 }else{
					 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
				 }
					if(ccCodeslist.size()>0 && (!compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber()) &&  !compareDepartmentList(ccCodeslist,AsscbasedDept))){
							  continue;
							}
			/*	if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_CURRENT_DM)){
					ccCodeslist=HondaLogicUtil.getccCodesonRequisitonGrid(HondaPermissionKeys.DM_KEY,screenName);
					if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber())){
						  continue;
						}
				}
				else	if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_CURRENT_DVM)){
					ccCodeslist=HondaLogicUtil.getccCodesonRequisitonGrid(HondaPermissionKeys.DVM_KEY,screenName);
					if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,changeofstatus.getCurrentDepartmentNumber())){
						  continue;
						}			
							}
				else if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DM)){
					ccCodeslist=HondaLogicUtil.getccCodesonRequisitonGrid(HondaPermissionKeys.DM_KEY,screenName);
					String AsscbasedDept=StringPool.BLANK;
					 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
						 AsscbasedDept = changeofstatus.getSameDept();
					 }else{
						 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
					 }
					if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,AsscbasedDept)){
						  continue;
						}
				}

				else	if(changeofstatus.getNextApprover().equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DVM)){
					ccCodeslist=HondaLogicUtil.getccCodesonRequisitonGrid(HondaPermissionKeys.DVM_KEY,screenName);
					String AsscbasedDept=StringPool.BLANK;
					 if(changeofstatus.getNewJobCode().equals("PA") || changeofstatus.getNewJobCode().equals("TC") || changeofstatus.getNewPositionNumber().equals("None")){
						 AsscbasedDept = changeofstatus.getSameDept();
					 }else{
						 AsscbasedDept = changeofstatus.getNewDepartmentNumber();
					 }
					if(ccCodeslist.size()>0 && !compareDepartmentList(ccCodeslist,AsscbasedDept)){
						  continue;
						}
				}*/
				jsonArray = JSONFactoryUtil.createJSONArray();
				
				jsonArray.put(changeofstatus.getAssoicateId());
				jsonArray.put(changeofstatus.getCosId());
				jsonArray.put(changeofstatus.getAssociatename());
				jsonArray.put(changeofstatus.getStatus());
				jsonArray.put(changeofstatus.getEffectiveDate());
				if(changeofstatus.getApproverStep() != -1) jsonArray.put(restrictMaxlenghtString(changeofstatus.getNextApprover(),changeofstatus.getStatus()));else jsonArray.put("");
				jsonArray.put(HondaLogicUtil.getDateFormat(changeofstatus.getCreateDate()));
				if(changeofstatus.getPositionNumber().equalsIgnoreCase("undefined")) {jsonArray.put("");}
				else{
					jsonArray.put(changeofstatus.getPositionNumber().replaceAll("-WFM",""));
				}
				//jsonArray.put(changeofstatus.getPositionNumber().replaceAll("-WFM",""));
				
				if(changeofstatus.getNewPositionNumber().equalsIgnoreCase("undefined")) {
					jsonArray.put("");
				}
				else{
					jsonArray.put(changeofstatus.getNewPositionNumber().replaceAll("-WFM",""));
				}
				//jsonArray.put(changeofstatus.getNewPositionNumber().replaceAll("-WFM",""));
				
				jsonData.put(jsonArray);
			   // }
			}
		}  
		}return json.put("data", jsonData );
	 }

		/**
		 * 
		 * @param type
		 * @return
		 * @throws SystemException
		 * @throws PortalException 
		 * @throws NumberFormatException 
		 * @throws IOException 
		 * @throws JsonGenerationException 
		 * @throws JSONException 
		 */
		public static JSONObject getRequisitionList(String type,PortletRequest aPortletRequest) throws SystemException,  PortalException, IOException, JSONException {
			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			JSONArray jsonData = JSONFactoryUtil.createJSONArray();
			
			DynamicQuery dynamicQueryReq = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
			dynamicQueryReq.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
			dynamicQueryReq.add(PropertyFactoryUtil.forName("dummy").eq("0"));
			DynamicQuery dynamicQuerypos = WFMS_PositionLocalServiceUtil.dynamicQuery();
			List<WFMS_Requisition> requisitionlist = null;
			List<WFMS_Requisition> requisitionlistWating = null;
			List<WFMS_Requisition> requisitionlistFilled = null;
			List<WFMS_Requisition> requisitionlistComplete = null;
			
			Criterion criterion = null;
			 List<String> cclist=null;
			try{

			cclist=	WMSUserAccessUtil.getccCodelistOnRequistionGrid(aPortletRequest,PortletPropsPermission.REQ_VIEW_REQ_GRID);
				requisitionlist = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryReq);
				requisitionlist = WFMS_RequisitionLocalServiceUtil.findBydummy("0");

				DynamicQuery queryForpos =WFMS_PositionLocalServiceUtil.dynamicQuery();
				queryForpos.setProjection(PropertyFactoryUtil.forName("pId"));

				DynamicQuery queryForRequisition =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
				queryForRequisition.add(PropertyFactoryUtil.forName("rId").in(queryForpos)).add(RestrictionsFactoryUtil.ne("dummy","1"));
				criterion = RestrictionsFactoryUtil.eq("deleteflagStatus", 0);

				queryForRequisition.add(criterion);
				requisitionlist = WFMS_RequisitionLocalServiceUtil.dynamicQuery(queryForRequisition);


			}catch(SystemException ex){
				_log.error("WFMS_RequisitionLocalServiceUtil has SystemException in DatagridDisplayManagerUtil.getRequisitionList()" +ex);
			}
			//if(WMSUserAccessUtil.isUserHaveRole(aPortletRequest, PortletPropsPermission.REQ_VIEW_REQ_GRID)){
				if(type.equalsIgnoreCase("listByStatus")) {

					for(WFMS_Requisition requisition: requisitionlist){
							WFMS_Position listpos=WFMS_PositionLocalServiceUtil.findByposition(requisition.getRId());				
				//	if(WMSUserAccessUtil.checkPermissionForRequisition(aPortletRequest,PortletPropsPermission.REQ_VIEW_REQ,listpos.getDepartmentNumber())){
							//compareDepartmentList(list,listpos.getDepartmentNumber());
							if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
								  continue;
								}
						jsonArray = JSONFactoryUtil.createJSONArray();
						String mainreq_id = "";
						List<WFMS_Requisition> finalstep = WFMS_RequisitionLocalServiceUtil.findByworkflowId(requisition.getRwfId());
						
							if(requisition.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
						        	jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
						        }
							 else{
						        	jsonArray.put(requisition.getStatus());
						        }
						criterion = RestrictionsFactoryUtil.eq("pId", requisition.getRId());
						dynamicQuerypos.add(criterion);
						jsonArray.put(listpos.getDepartmentNumber());
					 	jsonArray.put(listpos.getDepartmentName());
					 	if(finalstep.size()!=0){
					 		for(WFMS_Requisition req:finalstep){
								mainreq_id = req.getRwfId().replaceAll("-WFM", "");
								jsonArray.put(mainreq_id);
							}
					 	}
					 	else{
					 		jsonArray.put(requisition.getRwfId().replaceAll("-WFM", ""));
					 	}
						//jsonArray.put(requisition.getRId());
                       /*String id=requisition.getRwfId();
						
					    id=id.replace("-WFM", "");
						jsonArray.put(id);*/
					 	
					 	/*if(requisition.getRwfId().contains("-WFM"))
					 	{
					 		jsonArray.put(requisition.getRwfId().replace("-WFM", ""));
					 	}
					 	else{
					 		jsonArray.put(requisition.getRwfId());
					 	}*/
					 	jsonArray.put(requisition.getRId());
						jsonArray.put(requisition.getCreatedBy());
						jsonArray.put(restrictMaxlenghtString(requisition.getNextapprove(),requisition.getStatus()));
						Date date=null;
						String dateFormat=null;
							if(null!=requisition.getCreateDate()){
							date=requisition.getCreateDate();
							dateFormat=HondaLogicUtil.getDateFormat(date);
							}
						jsonArray.put(dateFormat);
						jsonData.put(jsonArray); 
					}
			   // }
			}else if(type.equalsIgnoreCase("listByRequisition")) {
			
				for(WFMS_Requisition requisition: requisitionlist){
					WFMS_Position listpos=WFMS_PositionLocalServiceUtil.findByposition(requisition.getRId());
					//if(WMSUserAccessUtil.checkPermissionForRequisition(aPortletRequest,PortletPropsPermission.REQ_VIEW_REQ,listpos.getDepartmentNumber())){
					if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
						  continue;
						}
					jsonArray = JSONFactoryUtil.createJSONArray();
					String mainreq_id = "";
					String status = "";
					List<WFMS_Requisition> finalstep = WFMS_RequisitionLocalServiceUtil.findByworkflowId(requisition.getRwfId());
					
						for(WFMS_Requisition req:finalstep){
							mainreq_id = req.getRwfId();
							status = req.getStatus();
						}
						if(finalstep.size()!=0){
							jsonArray.put(mainreq_id.replaceAll("-WFM", ""));
						}
						else{
							jsonArray.put(requisition.getRwfId().replaceAll("-WFM", ""));
						}
					jsonArray.put(requisition.getPostingType());
					jsonArray.put(requisition.getRId());
					
						jsonArray.put(listpos.getDepartmentName());
						if(requisition.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
							jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
						}
						else{
							jsonArray.put(requisition.getStatus());
						}
						jsonArray.put(restrictMaxlenghtString(requisition.getNextapprove(),requisition.getStatus()));
						jsonArray.put(HondaLogicUtil.getDateFormat(requisition.getCreateDate()));
						jsonData.put(jsonArray);
				}
				//}
			}
			else if(type.equalsIgnoreCase("listByDateCreated")) {
			
				for(WFMS_Requisition requisition: requisitionlist){
					WFMS_Position listpos=WFMS_PositionLocalServiceUtil.findByposition(requisition.getRId());
				//	if(WMSUserAccessUtil.checkPermissionForRequisition(aPortletRequest,PortletPropsPermission.REQ_VIEW_REQ,listpos.getDepartmentNumber())){
					if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
						  continue;
						}
						jsonArray = JSONFactoryUtil.createJSONArray();
						jsonArray.put(HondaLogicUtil.getDateFormat(requisition.getCreateDate()));
						String id=requisition.getRwfId();
						
					    id=id.replace("-WFM", "");
						jsonArray.put(id);
						
						jsonArray.put(listpos.getDepartmentName());
						if(requisition.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
							jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
						}
						else{
							jsonArray.put(requisition.getStatus());
						}
						jsonArray.put(requisition.getRId());
						jsonData.put(jsonArray);
					
				//}
				}
			}else if(type.equalsIgnoreCase("listBySubmitted")) {
			
				DynamicQuery dynamicQuery=WFMS_RequisitionLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(HondaPermissionKeys.REQ_SUBMITTED));
				dynamicQuery.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
				dynamicQuery.add(PropertyFactoryUtil.forName("dummy").eq("0"));
				List<WFMS_Requisition> numberList=WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQuery);
										
				for(WFMS_Requisition wfms_Requisitionsubmitted:numberList){
					jsonArray = JSONFactoryUtil.createJSONArray();
					if(wfms_Requisitionsubmitted.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
						jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
					}
					else{
						jsonArray.put(wfms_Requisitionsubmitted.getStatus());
					}
					
                    DynamicQuery dynamicQueryforCount = WFMS_PositionLocalServiceUtil.dynamicQuery();
					Criterion criterionforCount = null;
					criterionforCount = RestrictionsFactoryUtil.eq("pId", wfms_Requisitionsubmitted.getRId());
					dynamicQueryforCount.add(criterionforCount);
					long positionsCount=WFMS_PositionLocalServiceUtil.dynamicQueryCount(dynamicQueryforCount);				
					if(positionsCount>0){
					 WFMS_Position listpos=WFMS_PositionLocalServiceUtil.findByposition(wfms_Requisitionsubmitted.getRId());
					// if(WMSUserAccessUtil.checkPermissionForRequisition(aPortletRequest,PortletPropsPermission.REQ_VIEW_REQ,listpos.getDepartmentNumber())){
					 if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
						  continue;
						}
						 jsonArray.put(listpos.getDepartmentName());
					}	
					else{
						 continue;
					}
						 
						 
						 
						 jsonArray.put(wfms_Requisitionsubmitted.getNextapprove());
						 
							jsonArray.put(wfms_Requisitionsubmitted.getRId());
							String id=wfms_Requisitionsubmitted.getRwfId();
							id=id.replace("-WFM", "");
							jsonArray.put(id);
							
							jsonArray.put(HondaLogicUtil.getDateFormat(wfms_Requisitionsubmitted.getCreateDate()));
							jsonArray.put(wfms_Requisitionsubmitted.getAssociatename());
							jsonData.put(jsonArray);
				
				//}
				}
			}else if(type.equalsIgnoreCase("listByWaitingonManpower")) {
			
				criterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_WAITINGONMANPOWER);
				dynamicQueryReq.add(criterion);
				
				try{
					requisitionlistWating= WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryReq);
				}catch(SystemException ex){
					_log.error("WFMS_PositionLocalServiceUtil has SystemException in DatagridDisplayManagerUtil.getPositionList()");
				}
				for(WFMS_Requisition wfms_Requisitionwaiting:requisitionlistWating){
					jsonArray = JSONFactoryUtil.createJSONArray();
					WFMS_Position listpos=null;
					try {
						 listpos=WFMS_PositionLocalServiceUtil.findByposition(wfms_Requisitionwaiting.getRId());
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(listpos!=null){
				//	if(WMSUserAccessUtil.checkPermissionForRequisition(aPortletRequest,PortletPropsPermission.REQ_VIEW_REQ,listpos.getDepartmentNumber())){
					if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
						  continue;
						}
						 if(wfms_Requisitionwaiting.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
								jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
							}
							else{
								jsonArray.put(wfms_Requisitionwaiting.getStatus());
							}
					
						jsonArray.put(listpos.getDepartmentName());
						
						jsonArray.put(wfms_Requisitionwaiting.getCreatedBy());
						
						jsonArray.put(HondaLogicUtil.getDateFormat(wfms_Requisitionwaiting.getCreateDate()));
						//jsonArray.put(wfms_Requisitionwaiting.getAssociatename());
						jsonArray.put(wfms_Requisitionwaiting.getRId());
						jsonArray.put(wfms_Requisitionwaiting.getRwfId());
						jsonData.put(jsonArray);
					
				}
				}
			}else if(type.equalsIgnoreCase("listByFilledButNoAssociateNumber")) {
                
                criterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER);
                dynamicQueryReq.add(criterion);
                
                try{
                    requisitionlistFilled= WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryReq);
                }catch(SystemException ex){
                    _log.error("WFMS_PositionLocalServiceUtil has SystemException in DatagridDisplayManagerUtil.getPositionList()");
                }
                for(WFMS_Requisition wfms_Requisitionfilled:requisitionlistFilled){
                    
                    WFMS_Position listpos=WFMS_PositionLocalServiceUtil.findByposition(wfms_Requisitionfilled.getRId());
                    
                  //   if(WMSUserAccessUtil.checkPermissionForRequisition(aPortletRequest,PortletPropsPermission.REQ_VIEW_REQ,listpos.getDepartmentNumber())){
                    if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
						  continue;
						}
                        jsonArray = JSONFactoryUtil.createJSONArray();
                        if(wfms_Requisitionfilled.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
							jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
						}
						else{
							jsonArray.put(wfms_Requisitionfilled.getStatus());
						}
                       
                        jsonArray.put(listpos.getDepartmentName());
                        jsonArray.put(listpos.getDepartmentNumber());
                        jsonArray.put(wfms_Requisitionfilled.getRwfId());
                        
                        
                        jsonArray.put(wfms_Requisitionfilled. getRId());
                        jsonData.put(jsonArray);
                  }
            //    }
            }else if(type.equalsIgnoreCase("listByComplete")) {
			
				criterion = RestrictionsFactoryUtil.eq("status", "Complete");
				
				//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("dummy", '0'));
				dynamicQueryReq.add(criterion);
				
				try{
					requisitionlistComplete= WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryReq);
				}catch(SystemException ex){
					_log.error("WFMS_PositionLocalServiceUtil has SystemException in DatagridDisplayManagerUtil.getPositionList()", ex);
				}
				for(WFMS_Requisition wfms_Requisitioncomplete:requisitionlistComplete){
					WFMS_Position listpos=null;
					try {
						 listpos=WFMS_PositionLocalServiceUtil.findByposition(wfms_Requisitioncomplete.getRId());

					} catch (Exception e) {
						// TODO: handle exception
					}
					if(listpos!=null){
					if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
						  continue;
						}
					jsonArray = JSONFactoryUtil.createJSONArray();
					 if(wfms_Requisitioncomplete.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
							jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
						}
						else{
							jsonArray.put(wfms_Requisitioncomplete.getStatus());
						}
				
						//WFMS_Position listpos=WFMS_PositionLocalServiceUtil.findByposition(wfms_Requisitioncomplete.getRId());
						jsonArray.put(listpos.getDepartmentName());
					
						jsonArray.put(wfms_Requisitioncomplete.getAssociatenumber());
						jsonArray.put(wfms_Requisitioncomplete.getRwfId());
						jsonArray.put(wfms_Requisitioncomplete.getRId());
						jsonData.put(jsonArray);
					
				
				}
			}
			}
			else if(type.equalsIgnoreCase("listReportView")) {


				//System.out.println("listReportViewlistReportViewlistReportViewlistReportViewlistReportViewlistReportView");
				List<WFMS_Requisition> req = WFMS_RequisitionLocalServiceUtil.findBydummy("0");
				
				for(WFMS_Requisition requisition: req){
					if(requisition.getDeleteflagStatus()==1 || requisition.getDummy().equalsIgnoreCase("1"))
						continue;
					WFMS_Position listpos=null;
				try {
					 listpos=WFMS_PositionLocalServiceUtil.findByposition(requisition.getRId());

				} catch (Exception e) {
					// TODO: handle exception
				}	
				 if(listpos!=null){
					if(cclist.size()>0 && !compareDepartmentList(cclist,listpos.getDepartmentNumber())){
						  continue;
						}
					String main_id = ""; String status = "";
					
					
					try {
						jsonArray = JSONFactoryUtil.createJSONArray();
                       String id=requisition.getRwfId();
                       
					    id=id.replace("-WFM", "");
						jsonArray.put(id);
						 if(requisition.getStatus().equalsIgnoreCase(WorkflowConstants.REQUISITION_SAVE)){
								jsonArray.put(HondaPermissionKeys.REQ_DRAFT);
							}
							else{
								jsonArray.put(requisition.getStatus());
							}
						jsonArray.put(listpos.getLadder()); 
						jsonArray.put(requisition.getCreatedBy());
						jsonArray.put(HondaLogicUtil.getDateFormat(requisition.getCreateDate()));
						jsonArray.put(requisition.getRId());
						jsonArray.put(listpos.getLine());
						jsonArray.put(listpos.getDepartmentName());
						jsonArray.put(requisition.getPostingType());//posting TYPE
					//	if(requisition.getStatus().equals(HondaPermissionKeys.REQ_WAITINGONMANPOWER)){
							//jsonArray.put(String.valueOf(requisition.getApprovedDate()));
							jsonArray.put(HondaLogicUtil.getDateFormat(requisition.getApprovedDate()));
					//	}
					//	else{
					//		jsonArray.put(String.valueOf(""));
					//	}
						jsonArray.put(requisition.getTeamNumber()); //Team Number 
						jsonArray.put(listpos.getLevel());
						String shiftdescription ="";
						Map<String,String> shiftMap = new HashMap<String,String>();
						try {
						shiftMap=ConfigUtility.getInputValuesForMap("shift-assignment");
						shiftdescription  = shiftMap.get(requisition.getShiftAssign());
						} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
						jsonArray.put(requisition.getShiftAssign());
						jsonArray.put(listpos.getReportsTo());
						jsonArray.put(requisition.getDateneeded());
						jsonArray.put(requisition.getContactperson()); //contact Ext
						jsonArray.put(requisition.getContactphonenumber()); //contact Ext
						jsonArray.put(requisition.getHowAvailable());
						jsonArray.put(requisition.getWhoReplaced());
						//jsonArray.put(listpos.getTypicalJobTitle());
							String TypicalJobTitle="";
							if(listpos.getTypicalJobTitle().length()>26){
								TypicalJobTitle = listpos.getTypicalJobTitle().substring(0, 25) + "...";
							}
							
							else
							{
								TypicalJobTitle=listpos.getTypicalJobTitle();
							}
							jsonArray.put(TypicalJobTitle)
							;
						//jsonArray.put(listpos.getMinJobKnowHow());
						
						String MinJobKnowHow="";
						if(listpos.getMinJobKnowHow().length()>26){
							MinJobKnowHow = listpos.getMinJobKnowHow().substring(0, 25) + "...";
						}
						
						else
						{
							MinJobKnowHow=listpos.getMinJobKnowHow();
						}
						jsonArray.put(MinJobKnowHow)
						;
						//jsonArray.put(listpos.getDuties());
							String Duties="";
							if(listpos.getDuties().length()>26){
								Duties = listpos.getDuties().substring(0, 25) + "...";
								
								
							}
							
							else
							{
								Duties=listpos.getDuties();
							}
							jsonArray.put(Duties)
							;
						//jsonArray.put(listpos.getTasksPerformed());
							String TasksPerformed="";
							if(listpos.getTasksPerformed().length()>26){
								TasksPerformed = listpos.getTasksPerformed().substring(0, 25) + "...";
							}
							
							else
							{
								TasksPerformed=listpos.getTasksPerformed();
							}
							jsonArray.put(TasksPerformed)
							;
							
						//jsonArray.put(listpos.getLengthOfService());
							String LengthOfService="";
							if(listpos.getLengthOfService().length()>26){
								LengthOfService = listpos.getLengthOfService().substring(0, 25) + "...";
							}
							
							else
							{
								LengthOfService=listpos.getLengthOfService();
							}
							jsonArray.put(LengthOfService)
							;
						//jsonArray.put(listpos.getDegree());
							String Degree="";
							if(listpos.getDegree().length()>26){
								Degree = listpos.getDegree().substring(0, 25) + "...";
							}
							
							else
							{
								Degree=listpos.getDegree();
							}
							jsonArray.put(Degree)
							;
						//jsonArray.put(listpos.getReqSkills());
							String ReqSkills="";
							if(listpos.getReqSkills().length()>26){
								ReqSkills = listpos.getReqSkills().substring(0, 25) + "...";
							}
							
							else
							{
								ReqSkills=listpos.getReqSkills();
							}
							jsonArray.put(ReqSkills)
							;
						//jsonArray.put(listpos.getDesiredSkills());
							String DesiredSkills="";
							if(listpos.getDesiredSkills().length()>26){
								DesiredSkills = listpos.getDesiredSkills().substring(0, 25) + "...";
							}
							
							else
							{
								DesiredSkills=listpos.getDesiredSkills();
							}
							jsonArray.put(DesiredSkills);
						jsonArray.put(listpos.getWeeklyOvertime());
						jsonArray.put(listpos.getFrequencyOfTravel());
						jsonArray.put(requisition.getOther());
						jsonArray.put(restrictMaxlenghtString(requisition.getNextapprove(),requisition.getStatus()));
						//jsonArray.put("");
						jsonData.put(jsonArray);
					
					/* jsonArray.put(requisition.getRwfId());
					jsonArray.put(requisition.getRId());
					jsonArray.put(requisition.getAssociatenumber());
					jsonArray.put(requisition.getNextapprove());
					jsonArray.put(requisition.getCreateDate()+"");
					jsonData.put(jsonArray);*/
					} 
					catch (SystemException e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
				}
			
			}
			//}
		return json.put("data", jsonData);
	}
		public static boolean compareDepartmentList(List<String>cclist, String deptNum){
			if(Validator.isNotNull(deptNum)){
			for(String str: cclist) {
			    if(str.trim().contains(deptNum))
			       return true;
			}
			}
			return false;
		}
		public static String restrictMaxlenghtString(String orginalString ,String status){
			    String replaceString = orginalString.replaceAll("<br/>",",");
		    	String substring=StringPool.BLANK;
		    	if(Validator.isNull(replaceString) || status.equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_DISAPPROVE)) return "";
		    	else{
		    	if(replaceString.length()>26) substring =replaceString.substring(0, 25) + "...";
				else substring=replaceString;
			    return substring;}
		    	
		}
		
		public static Long convertintoLong(Date date){
			if(Validator.isNotNull(date)){
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			Long longtime = gc.getTimeInMillis();
			return longtime;}
			else return 0000L;
		}
		HondaLogicUtil hondaLogicUtil= new HondaLogicUtil();
}
