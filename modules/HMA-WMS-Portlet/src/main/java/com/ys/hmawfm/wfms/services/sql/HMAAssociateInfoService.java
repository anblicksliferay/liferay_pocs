package com.ys.hmawfm.wfms.services.sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
//import javax.swing.text.html.HTMLDocument.Iterator;




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
import com.liferay.portal.kernel.util.Validator;
import com.ys.hmawfm.wfms.services.dao.HMADB2Connection;
import com.ys.hmawfm.wfms.services.model.WFMS_Associate_History;
import com.ys.hmawfm.wfms.services.model.WFMS_Config;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode;
import com.ys.hmawfm.wfms.services.model.WFMS_action_names;
import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills;
import com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers;
import com.ys.hmawfm.wfms.services.rest.CostCenterService;
import com.ys.hmawfm.wfms.services.service.WFMS_Associate_HistoryLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_associate_skillsLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil;
import com.ys.hmawfm.wfms.utils.HondaLogicUtil;
import com.ys.hmawfm.wfms.utils.PortletPropsPermission;
import com.ys.hmawfm.wfms.utils.WMSUserAccessUtil;
import com.ys.hmawfm.wfms.vo.AssociateInformation;

public class HMAAssociateInfoService{
	
	/**
	 * 
	 * @return List<String>
	 * @throws SystemException 
	 */
	public static Map<String,String> getDistinctDeptNumbers() throws SystemException{
	       
        Map<String,String> valuesMap = new LinkedHashMap<String,String>();
        Connection conn = HMADB2Connection.getConnection();
        String assocTableName = HMADB2Connection.getAssocTableName();
       
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        try{
        	
          boolean recordNotExist=true;
            if(conn!=null){
                String sql = "SELECT DISTINCT DEPT_NUMBER,DEPT_NAME  FROM " + assocTableName + " ORDER BY DEPT_NUMBER ASC";
             //   _log.info("HMAAssociateInfoService.getDistinctDeptNumbers() sql: " + sql);
                stmt = conn.prepareStatement(sql);       
                rs = stmt.executeQuery();
            }
           
            if(null==rs) return valuesMap;
   
            while(rs.next()){ 
            	recordNotExist=false;
             
            	if(rs.getString("DEPT_NUMBER") != null){
            		valuesMap.put( rs.getString("DEPT_NUMBER").trim(), rs.getString("DEPT_NAME") );
            	}
            }
           
            conn.close();
            stmt.close();
            rs.close();
           // if(recordNotExist){
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.add(PropertyFactoryUtil.forName("DEPT_NUMBER").ne(""));
				List <WFMS_NA_Support> wfmNaSupport =  WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
				if(wfmNaSupport.size()>0){
					for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
						if(wfmNaSupportAssociate.getDEPT_NUMBER() != null){
							valuesMap.put(wfmNaSupportAssociate.getDEPT_NUMBER().trim(),wfmNaSupportAssociate.getDEPT_NAME().trim());
		            	}
					}
				}
			//}
        }
       
        catch(SQLException ex){
           
            _log.error("HMAAssociateInfoService.getDistinctDeptNumbers() SQLException",ex);
           
            if(conn !=null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    _log.error("HMAAssociateInfoService.getDistinctDeptNumbers() Error",ex);
                }
            }
           
        }
       
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
            stmt.close();
                } catch (SQLException e) {
           
                    e.printStackTrace();
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                   
                    e.printStackTrace();
                }          
            }
        }
           
        return valuesMap;
    }
	
	public static JSONArray getnasuuportConfiguration( ) throws SystemException, JSONException{
	      JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	      JSONArray jsonData = JSONFactoryUtil.createJSONArray();
	 	 
		 List<WFMS_NA_Support> listOfA=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Supports(0, WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_SupportsCount());

     for(WFMS_NA_Support val:listOfA){
  	   jsonArray = JSONFactoryUtil.createJSONArray();
  	   if(val.getDeleteflag()!=1){
  	   //jsonArray.put(val.getNasId());
  	   jsonArray.put(val.getASSOCIATE_NUMBER());
  	   //jsonArray.put(val.getASSOC_NO());
  	   jsonArray.put(val.getASSOCIATE_DATE_OF_HIRE());
  	   jsonArray.put(val.getASSOCIATE_NAME());
  	   jsonArray.put(val.getDEPT_NUMBER());
  	   jsonArray.put(val.getDEPT_NAME());
  	   //jsonArray.put(val.getDEPT_NO());
  	   jsonArray.put(val.getASSOCIATE_TITLE());
  	   jsonArray.put(val.getSHIFT_CODE());
  	   jsonArray.put(val.getTEAM_NUMBER());
  	   jsonArray.put(val.getASSGN_TYPE());
	   jsonArray.put(val.getLEADERSHIP_ASSIGNMENT());
  	   jsonArray.put(val.getEFFDT());
  	   jsonArray.put(val.getTERMINATION_DT());
  	   jsonArray.put(val.getMANAGER_ASSOCIATE_NUMBER());
  	  
  	   jsonArray.put(val.getEMAIL());
  	   jsonArray.put(val.getCreatedBy());
  	   //jsonArray.put(val.getModifiedBy());
  	   jsonArray.put(HondaLogicUtil.getDateFormat(val.getCreateDate()));
  	   //jsonArray.put(HondaLogicUtil.getDateFormat(val.getModifiedDate()));
  	   jsonData.put(jsonArray);
  	   }
     }
 return jsonData;
}
	public static JSONArray getRoutingAndApprovers( ) throws SystemException, JSONException{
	      JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	      JSONArray jsonData = JSONFactoryUtil.createJSONArray();
	 	 
		 List<WFMS_routing_and_approvers> listOfA=WFMS_routing_and_approversLocalServiceUtil.
		 getWFMS_routing_and_approverses(0, WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approversesCount());

     for(WFMS_routing_and_approvers val:listOfA){
  	   jsonArray = JSONFactoryUtil.createJSONArray();
  	 if(val.getDeleteflag()!=1){
  	   jsonArray.put(val.getRapId());
  	   
  	 WFMS_action_names wfms_action_names= WFMS_action_namesLocalServiceUtil.fetchWFMS_action_names(val.getAction());
	     if(wfms_action_names!=null){
		   jsonArray.put(wfms_action_names.getActionName()); 
		   jsonArray.put(val.getCurrentJobCodeORLeadership());
		   jsonArray.put(val.getNewJobCodeORLeadership());
		   jsonArray.put(val.getSameJobCode());
		   jsonArray.put(val.getSameLeadership());
		   jsonArray.put(val.getIsSameDept());
		   jsonArray.put(val.getIsSameMgr());
		   jsonArray.put(val.getRoutingProcess());
		   jsonArray.put(val.getChangeDescription());
		   jsonArray.put(val.getNotificationTo());
		   jsonArray.put(val.getCreatedBy());
		   jsonArray.put(val.getModifiedBy());
		   jsonArray.put(HondaLogicUtil.getDateFormat(val.getCreateDate()));
		   jsonArray.put(HondaLogicUtil.getDateFormat(val.getModifiedDate()));
		   jsonData.put(jsonArray);
		 }
  	 }
     }
 return jsonData;
}
	
	public static JSONArray getActionandReasoncode( ) throws SystemException, JSONException{
	      JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	      JSONArray jsonData = JSONFactoryUtil.createJSONArray();
	 	 
		 List<WFMS_action_and_reasoncode> listOfA=WFMS_action_and_reasoncodeLocalServiceUtil.
		 getWFMS_action_and_reasoncodes(0, WFMS_action_and_reasoncodeLocalServiceUtil.getWFMS_action_and_reasoncodesCount());
         
		 
   for(WFMS_action_and_reasoncode val:listOfA){
	   jsonArray = JSONFactoryUtil.createJSONArray();
	   if(val.getDeleteflag()!=1){
	   jsonArray.put(val.getAarId());
	   WFMS_action_names wfms_action_names= WFMS_action_namesLocalServiceUtil.fetchWFMS_action_names(val.getAction());
	   jsonArray.put(wfms_action_names.getActionName());
	   jsonArray.put(val.getReasonCode());
	   jsonArray.put(val.getDescription());
	   jsonArray.put(val.getCreatedBy());
	   jsonArray.put(val.getModifiedBy());
	   jsonArray.put(HondaLogicUtil.getDateFormat(val.getCreateDate()));
	   jsonArray.put(HondaLogicUtil.getDateFormat(val.getModifiedDate()));
	   jsonData.put(jsonArray);
	   }
   }
return jsonData;
}
	public static JSONArray getActions( ) throws SystemException, JSONException{
	      JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	      JSONArray jsonData = JSONFactoryUtil.createJSONArray();
	 	 
		 List<WFMS_action_names> listOfA=WFMS_action_namesLocalServiceUtil.getWFMS_action_nameses(0, WFMS_action_namesLocalServiceUtil.getWFMS_action_namesesCount());
       
		 
 for(WFMS_action_names val:listOfA){
	   jsonArray = JSONFactoryUtil.createJSONArray();
	   if(val.getDeleteflag()!=1){
	   jsonArray.put(val.getActionId());
	   jsonArray.put(val.getActionName());
	   jsonArray.put(val.getCreatedBy());
	   jsonArray.put(val.getModifiedBy());
	   jsonArray.put(HondaLogicUtil.getDateFormat(val.getCreateDate()));
	   jsonArray.put(HondaLogicUtil.getDateFormat(val.getModifiedDate()));
	   jsonData.put(jsonArray);
	   }
 }
return jsonData;
}
	public static JSONArray getAssociateInformation( PortletRequest renderRequest, String filterType) throws SystemException,  PortalException, IOException, com.liferay.portal.kernel.json.JSONException{
 	   
	      JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	      JSONArray jsonData = JSONFactoryUtil.createJSONArray();
	      if(WMSUserAccessUtil.isUserHaveRole(renderRequest, PortletPropsPermission.REQ_VIEW_REQ_GRID)){
  		 Criterion criterion = null;
  			HashMap<String, String> dicCodeToIndex;
              dicCodeToIndex = new HashMap<String, String>();
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey("Associate-Skills");
			JSONObject jObject= JSONFactoryUtil.createJSONObject(wfms_config.getContent());
			Iterator<String> iterator = jObject.keys();
			while(iterator.hasNext() ){
			    String value = (String)iterator.next();
			    JSONObject jObject1=JSONFactoryUtil.createJSONObject(jObject.getString(value));
			    Iterator<String> iterator1 = jObject1.keys();			
			    while( iterator1.hasNext() ){
			    	 String Key= iterator1.next();
			    	 dicCodeToIndex.put(Key, jObject1.getString(Key));
			      }  
			    }
			
			
  	if(!filterType.equalsIgnoreCase("0")){
  	      DynamicQuery WFMS_associate_skillsORCriteriaQuery = WFMS_associate_skillsLocalServiceUtil.dynamicQuery();
  		
  			 String associateSkills[] = filterType.split(",");
  			 for(String asoHistory:associateSkills){
				if(criterion==null)
  			  criterion = RestrictionsFactoryUtil.like("skills",new StringBuilder("%").append(","+asoHistory+",").append("%").toString());
				else
					criterion=RestrictionsFactoryUtil.or(criterion,
       					 RestrictionsFactoryUtil.like("skills",new StringBuilder("%").append(","+asoHistory+",").append("%").toString()));
				criterion=RestrictionsFactoryUtil.or(criterion,
  					 RestrictionsFactoryUtil.like("skills",new StringBuilder("%").append(","+asoHistory).toString()));
  			 criterion=RestrictionsFactoryUtil.or(criterion,
  					 RestrictionsFactoryUtil.like("skills",new StringBuilder(asoHistory+",").append("%").toString()));
  			 criterion=RestrictionsFactoryUtil.or(criterion,
  					 RestrictionsFactoryUtil.eq("skills",new StringBuilder(asoHistory).toString()));
  			 }
  			 WFMS_associate_skillsORCriteriaQuery.add(criterion);
  			 List<WFMS_associate_skills> associateAuditList1=WFMS_associate_skillsLocalServiceUtil.dynamicQuery(WFMS_associate_skillsORCriteriaQuery);
              for(WFMS_associate_skills obj:associateAuditList1)
				{
              	//list.add(obj.getAssociate_number());
              	
              	  String associateNumer=obj.getAssociate_number();
         		   DynamicQuery forhistory =WFMS_Associate_HistoryLocalServiceUtil.dynamicQuery();
         		   forhistory.add(PropertyFactoryUtil.forName("associateId").eq(associateNumer));
         		   forhistory.addOrder(OrderFactoryUtil.desc("assocHistoryId"));
       		       List<WFMS_Associate_History> associateAuditList= WFMS_Associate_HistoryLocalServiceUtil.dynamicQuery(forhistory,0,1);	
       			 if(associateAuditList.size()>0){
       				 if(Validator.isNotNull(associateAuditList.get(0).getAssociateId())){
            			 jsonArray = JSONFactoryUtil.createJSONArray();
 	     	        	 jsonArray.put((String) associateAuditList.get(0).getAssociateId());
 	     				 jsonArray.put((String) associateAuditList.get(0).getAssociateName());
 	     				 jsonArray.put(associateAuditList.get(0).getCurrentPosition());
 	     				 
                       WFMS_associate_skills associateskills=WFMS_associate_skillsLocalServiceUtil.fetchWFMS_associate_skills(associateAuditList.get(0).getAssociateId());
                       String skillsinfo=null;
                         if(associateskills!=null){
                           String SkillsList[] = associateskills.getSkills().split(",");
                  			 for(String skills:SkillsList){
                  				 if(skillsinfo==null)
                  					 skillsinfo=dicCodeToIndex.get(skills);
                  				 else
                  					 skillsinfo+=", "+dicCodeToIndex.get(skills);
                  			  }
                      	}
                          jsonArray.put(skillsinfo);
	                        jsonData.put(jsonArray);
       				 }	}
  	}
  	}
  	else{
       List<WFMS_Associate_History> WFMSAssociateHistory=WFMS_Associate_HistoryLocalServiceUtil.getWFMS_Associate_Histories(0, 
      		 WFMS_Associate_HistoryLocalServiceUtil.getWFMS_Associate_HistoriesCount());
       
		if(filterType.equalsIgnoreCase("0")) 
		{
		
		 HashMap<String, WFMS_Associate_History> dataList= new HashMap<String, WFMS_Associate_History>();
       for(WFMS_Associate_History obj:WFMSAssociateHistory){
       	   dataList.put( obj.getAssociateId(),obj);
		 	}
       for (Map.Entry<String, WFMS_Associate_History > entry : dataList.entrySet())
       {
    	  if(Validator.isNotNull(entry.getKey())){
        	 jsonArray = JSONFactoryUtil.createJSONArray();
           jsonArray.put((String)entry.getKey());
           jsonArray.put((String) entry.getValue().getAssociateName());
           jsonArray.put((String) entry.getValue().getCurrentPosition());
   	     WFMS_associate_skills associateskills=WFMS_associate_skillsLocalServiceUtil.fetchWFMS_associate_skills(entry.getKey());
           String skillsinfo=null;
             if(associateskills!=null){
                   String SkillsList[] = associateskills.getSkills().split(",");
      			 for(String skills:SkillsList){
      				 if(skillsinfo==null)
      					 skillsinfo=dicCodeToIndex.get(skills);
      				 else
      					 skillsinfo+=", "+dicCodeToIndex.get(skills);
      			  }
          	}
              jsonArray.put(skillsinfo);
              jsonData.put(jsonArray);
       } }
          dataList.clear();
       }
  	}
  	}
   return jsonData;

}


	public static Boolean getDepartmentNoByAssociateId(String depNumber, String screenName,String deptRoleKey) throws JSONException, IOException, com.liferay.portal.kernel.json.JSONException{
		
		//https://qsnhma.service-now.com/api/now/table/u_cost_center_department_division?sysparm_limit=1&cc_code=V5290&mpwrrep_user_name=HA26033
		  CostCenterService centerService= new CostCenterService();
	     return  centerService.userIsSameDepartmentOnServiceNow(depNumber, screenName,deptRoleKey);
    }
	
	
	public static List<String> getDepartmentUsersByDPNumber(String departmentNumber) throws SystemException{
        Connection conn = HMADB2Connection.getConnection();
        String assocTableName = HMADB2Connection.getAssocTableName();
        List<String> valuesList = new ArrayList<String>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
        	
           boolean recordNotExist=true;
            if(conn!=null){
                String sql = "SELECT ASSOC_NO FROM " + assocTableName + " where DEPT_NUMBER='"+departmentNumber+"'";
           //     _log.info("HMAAssociateInfoService.getDepartmentNoByAssociateId() sql: " + sql);
                stmt = conn.prepareStatement(sql);       
                rs = stmt.executeQuery();       
            }
            while(rs.next()){ 
            	
            	recordNotExist=false;
            	if(rs.getString("ASSOC_NO") != null){
            		valuesList.add(rs.getString("ASSOC_NO").trim());
            	}
            }
            
            if(recordNotExist){
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.add(PropertyFactoryUtil.forName("DEPT_NUMBER").eq(departmentNumber));
				List <WFMS_NA_Support> wfmNaSupport =  WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
				if(wfmNaSupport.size()>0){
					for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
						if(wfmNaSupportAssociate.getASSOC_NO() != null){
		            		valuesList.add(wfmNaSupportAssociate.getASSOC_NO().trim());
		            	}
					}
				}
			}
            Collections.sort(valuesList);
            
        }
       
        catch(SQLException ex){
           
            _log.error("HMAAssociateInfoService.getDistinctDeptNumbers() SQLException",ex);
           
            if(conn !=null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    _log.error("HMAAssociateInfoService.getDistinctDeptNumbers() Error",ex);
                }
            }
           
        }
       
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
            stmt.close();
                } catch (SQLException e) {
           
                    e.printStackTrace();
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                   
                    e.printStackTrace();
                }
                       
            }
           
        }
        return valuesList;
    }
    
	/**
	 * 
	 * @return List<Map<String,String>>
	 * @throws SystemException 
	 */
	
	public static List<String> getAssociateNumberCoss() throws SystemException{

	    List<String> valuesList = new ArrayList<String>();
	    Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try{
	        if(conn!=null){
	        	 String sql = "SELECT DISTINCT ASSOCIATE_NUMBER FROM " + assocTableName + " ORDER BY ASSOCIATE_NUMBER ASC";
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	        }
	        if(null==rs) return valuesList;

	        while(rs.next()){
	            if(rs.getString("ASSOCIATE_NUMBER") != null){
	            	valuesList.add(rs.getString("ASSOCIATE_NUMBER").trim());
	            }
	        }
	        conn.close();
			stmt.close();
			rs.close();
			
			DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
			associateInfoCount.addOrder(OrderFactoryUtil.asc("ASSOCIATE_NUMBER"));
			List <WFMS_NA_Support> wfmNaSupport = WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
			if(wfmNaSupport.size()>0){
				for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
					 if(wfmNaSupportAssociate.getASSOCIATE_NUMBER().trim() != null){
			        	   valuesList.add(wfmNaSupportAssociate.getASSOCIATE_NUMBER().trim());
			           }
				}
			}	
			
			Collections.sort(valuesList);
	    }catch(SQLException ex){
    		_log.error("HMAAssociateInfoService.getAssociateNumberCoss() Error",ex);
	    	if(conn != null){   
		    	try{
		                conn.close();
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
		    }
	    }finally{
	    	try{
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
	    			e.printStackTrace();}
	        try{
	            if(rs != null){
	               rs.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
	        try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(Exception e){e.printStackTrace();}
	            
	    }
	    return valuesList;
	}
	
	public static List<String> getTeamNumberCos() throws SystemException{

	    List<String> valuesList = new ArrayList<String>();
	    Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try{
	        if(conn!=null){
	            String sql = "SELECT DISTINCT TEAM_NUMBER FROM " + assocTableName + " ORDER BY TEAM_NUMBER ASC";
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	        }
	        if(null==rs) return valuesList;

	        while(rs.next()){
	        	if(rs.getString("TEAM_NUMBER") != null){
	        		valuesList.add(rs.getString("TEAM_NUMBER").trim());
	        	}
	        }
	        conn.close();
			stmt.close();
			rs.close();
			DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
			associateInfoCount.addOrder(OrderFactoryUtil.asc("SHIFT_CODE"));
			List <WFMS_NA_Support> wfmNaSupport = WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
			if(wfmNaSupport.size()>0){
				for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
					 if(wfmNaSupportAssociate.getTEAM_NUMBER().trim() != null){
			        	   valuesList.add(wfmNaSupportAssociate.getTEAM_NUMBER().trim());
			           }
				}
			}	
			Set<String> hs = new HashSet<String>();
			hs.addAll(valuesList);
			valuesList.clear();
			valuesList.addAll(hs);
			Collections.sort(valuesList);
	    }catch(SQLException ex){
    		_log.error("HMAAssociateInfoService.getTeamNumberCos() Error",ex);
	    	if(conn != null){   
		    	try{
		                conn.close();
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
		    }
	    }finally{
	    	try{
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
	    			e.printStackTrace();}
	        try{
	            if(rs != null){
	               rs.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
	        try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(Exception e){e.printStackTrace();}
	            
	    }
	    return valuesList;
	}
	
	public static List<String> getShiftCodeCos() throws SystemException{

	    List<String> valuesList = new ArrayList<String>();
	    Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try{
	    	
	       boolean existTherecord=true;
	        if(conn!=null){
	            String sql = "SELECT DISTINCT SHIFT_CODE FROM " + assocTableName + " ORDER BY SHIFT_CODE ASC";
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	        }

	        if(null==rs) return valuesList;

	        while(rs.next()){
	            if(rs.getString("SHIFT_CODE") != null){
	            	valuesList.add(rs.getString("SHIFT_CODE").trim());
	            }
	        }
	        conn.close();
			stmt.close();
			rs.close();
			
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.addOrder(OrderFactoryUtil.asc("SHIFT_CODE"));
				List <WFMS_NA_Support> wfmNaSupport =  WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
				if(wfmNaSupport.size()>0){
					for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
						 if(wfmNaSupportAssociate.getSHIFT_CODE().trim() != null){
				        	   valuesList.add(wfmNaSupportAssociate.getSHIFT_CODE().trim());
				           }
					}
				}		
				Set<String> hs = new HashSet<String>();
				hs.addAll(valuesList);
				valuesList.clear();
				valuesList.addAll(hs);
				Collections.sort(valuesList);
	    }catch(SQLException ex){
    		_log.error("HMAAssociateInfoService.getShiftCodeCos() Error",ex);
	        if(conn != null){   
		    	try{
		                conn.close();
		            } catch(Exception e){
		            	e.printStackTrace();
		        	}
		    	}
	        }finally{
	            try{
	                if(rs != null){
	                    rs.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	            try{
	                if(stmt != null){
	                    stmt.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	            try{
	                if(conn != null){
	                    conn.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	        }
	    return valuesList;
	}

	public static List<String> getLeaderShipCos() throws SystemException{

	    List<String> valuesList = new ArrayList<String>();
	    Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try{
	    	boolean existTherecord=true;
	        if(conn!=null){
	            String sql = "SELECT DISTINCT LEADERSHIP_ASSIGNMENT FROM " + assocTableName + " where LEADERSHIP_ASSIGNMENT != '' ORDER BY LEADERSHIP_ASSIGNMENT ASC";
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	        }

	        if(null==rs) return valuesList;

	        while(rs.next()){
	           if(rs.getString("LEADERSHIP_ASSIGNMENT") != null){
	        	   valuesList.add(rs.getString("LEADERSHIP_ASSIGNMENT").trim());
	           }
	        }
	        conn.close();
			stmt.close();
			rs.close();
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.add(PropertyFactoryUtil.forName("LEADERSHIP_ASSIGNMENT").ne(""));
				associateInfoCount.addOrder(OrderFactoryUtil.asc("LEADERSHIP_ASSIGNMENT"));
				
				
				List <WFMS_NA_Support> wfmNaSupport =  WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
				if(wfmNaSupport.size()>0){
					for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
						
						 if(wfmNaSupportAssociate.getLEADERSHIP_ASSIGNMENT().trim() != null){
				        	   valuesList.add(wfmNaSupportAssociate.getLEADERSHIP_ASSIGNMENT().trim());
				           }
					}
				}
				Set<String> hs = new HashSet<String>();
				hs.addAll(valuesList);
				valuesList.clear();
				valuesList.addAll(hs);
				Collections.sort(valuesList);
	    }catch(SQLException ex){
    		_log.error("HMAAssociateInfoService.getLeaderShipCos() Error",ex);
	    	if(conn != null){   
		    	try{
		                conn.close();
		            }catch(Exception e){
		            	e.printStackTrace();
		        	}
		    	}
	        }finally{
	            try{
	                if(rs != null){
	                    rs.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	            try{
	                if(stmt != null){
	                    stmt.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	            try{
	                if(conn != null){
	                    conn.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	        }
	    return valuesList;
	}
    
	public static Map<String,String> getAssociateNumbersWithNaTable(String filterType,String associateNumbers) throws SystemException{
	   Map<String,String> record = new LinkedHashMap<String,String>();
       Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       String sql = null;
       
       String strArray[] = associateNumbers. split(",");
       List<String> list = Arrays.asList(strArray);
       try{
           if(conn!=null){
               //String sql = "SELECT ASSOCIATE_NUMBER, ASSOCIATE_NAME FROM " + assocTableName + " ORDER BY ASSOCIATE_NUMBER ASC";
               if(Validator.isNotNull(associateNumbers)){
            	   sql = "SELECT ASSOCIATE_NUMBER , ASSOCIATE_NAME  FROM " +assocTableName+"  where  ASSOCIATE_NUMBER  NOT IN   ("	+ associateNumbers + " ) ORDER BY ASSOCIATE_NUMBER ASC ";
      		   }
               stmt = conn.prepareStatement(sql);
               rs = stmt.executeQuery();
           }
           while(rs.next()){
               record.put(rs.getString("ASSOCIATE_NUMBER").trim(),rs.getString("ASSOCIATE_NAME").trim());
           }
          List<WFMS_NA_Support> assList =WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Supports(0, WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_SupportsCount());
          if(assList.size()>0){
        	 
        	  for(WFMS_NA_Support assListData:assList){
        		if(!list.contains("'"+assListData.getASSOCIATE_NUMBER()+"'")){
        		      record.put(assListData.getASSOCIATE_NUMBER().trim(),assListData.getASSOCIATE_NAME().trim());
        		  }
        	  }
          }
           conn.close();
		   stmt.close();
		   rs.close();           
       }catch(SQLException ex){
       		if(conn != null){   
       	    	try{
       	                conn.close();
       	        } catch(Exception e){
       	        	e.printStackTrace();
       	        }
       	    }
       }finally{
	        try{
	            if(rs != null){
	                rs.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
	        try{
	            if(stmt != null){
	                stmt.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
	        try{
	            if(conn != null){
	                conn.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
       }
       return record;
   }
	/**
	 * 
	 * @param depNumber
	 * @return String
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static String  getAssNameByDeptNumner( String depNumber) throws SystemException, PortalException{

		String assname=null;
        Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List asslist= new ArrayList();
        try{
        	
        	boolean existTherecord=true;   
            if(conn!=null){
                String sql = "SELECT DISTINCT  ASSOCIATE_NAME FROM " + assocTableName + " where ASSOCIATE_NUMBER=  '" + depNumber + "'";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
            }
            if(null==rs) return assname;
            while(rs.next()){
            	existTherecord=false;   
            	if(rs.getString("ASSOCIATE_NAME") != null){
            		assname= rs.getString("ASSOCIATE_NAME").trim();
            		asslist.add(assname);
            	}
            }
            conn.close();
			stmt.close();
			rs.close();
			
			if(existTherecord){
				String associateNum=depNumber;
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.add(PropertyFactoryUtil.forName("ASSOCIATE_NUMBER").eq(associateNum));
				int wfmPositionscount = (int) WFMS_NA_SupportLocalServiceUtil.dynamicQueryCount(associateInfoCount);
				if(wfmPositionscount>0){
				WFMS_NA_Support associateInfo=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Support(associateNum);
				assname=associateInfo.getASSOCIATE_NAME().trim();
        		asslist.add(assname);
					
				}
			}
        }catch(SQLException ex){
        		_log.error("HMAAssociateInfoService.getAssNameByDeptNumner() Error",ex);
        		if(conn != null){   
        	    	try{
        	                conn.close();
        	        }catch(Exception e){
        	            	e.printStackTrace();
        	        }
        	    }
        }finally{
	        try{
	            if(rs != null){
	                rs.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
	        try{
	            if(stmt != null){
	                stmt.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
	        try{
	            if(conn != null){
	                conn.close();
	            }
	        }catch(Exception e){e.printStackTrace();}
        }
        return assname;
    }
	/**
	 * 
	 * @param associateNumber
	 * @return AssociateInformationExistorNot
	 * @throws SQLException
	 */
	public static boolean checkAssociateNumberExist(String associateNumber) throws SQLException{

		Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean recordNotExist=false; 
		try {
			
			if (conn != null) {
				String sql = "SELECT ASSOCIATE_NUMBER FROM "+assocTableName+" where ASSOCIATE_NUMBER='"+ associateNumber + "' ";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					recordNotExist=true;
				}
				rs.close();
				stmt.close();
				conn.close();
			}
			if(!recordNotExist){
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.add(PropertyFactoryUtil.forName("ASSOCIATE_NUMBER").eq(associateNumber));
				int wfmPositionscount = (int) WFMS_NA_SupportLocalServiceUtil.dynamicQueryCount(associateInfoCount);
				if(wfmPositionscount>0){
					recordNotExist=true;
				}
			}
		} catch (Exception e1) {
			_log.error("In HMAAssociateInfoService.fetchPositionOnAssociateNumber Error", e1);
			if(conn !=null){
				try {
					conn.rollback();
				} catch (SQLException e) {
					_log.error("SystemException : HMAAssociateInfoService.fetchPositionOnAssociateNumber");
				}
			}
		}finally{
			try {
				if(conn !=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null){
					stmt.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs !=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return recordNotExist;
	}
	/**
	 * 
	 * @param associateNumber
	 * @return AssociateInformation
	 * @throws SQLException
	 */
	public static AssociateInformation fetchPositionOnAssociateNumber(String associateNumber) throws SQLException{

		Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
		AssociateInformation assoInfo = new AssociateInformation();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			boolean recordNotExist=true; 
			if (conn != null) {
				String sql = "SELECT ASSOCIATE_DATE_OF_HIRE, ASSOCIATE_NAME, DEPT_NUMBER,DEPT_NAME, ASSOCIATE_TITLE,SHIFT_CODE,"+
						"TEAM_NUMBER, MANAGER_ASSOCIATE_NUMBER, LEADERSHIP_ASSIGNMENT FROM "+assocTableName+
						" where ASSOCIATE_NUMBER='"+ associateNumber + "' ";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					
					recordNotExist=false;
					assoInfo.setAssociateDateOfHire(rs.getString("ASSOCIATE_DATE_OF_HIRE"));
					assoInfo.setAssociateName(rs.getString("ASSOCIATE_NAME").trim());
					assoInfo.setDeptNumber(rs.getString("DEPT_NUMBER").trim());
					assoInfo.setDeptName(rs.getString("DEPT_NAME"));
					assoInfo.setAssociateTitle(rs.getString("ASSOCIATE_TITLE"));
					assoInfo.setShiftCode(rs.getString("SHIFT_CODE"));
					assoInfo.setTeamNumber(rs.getString("TEAM_NUMBER"));
					assoInfo.setMgrAssociateNo(rs.getString("MANAGER_ASSOCIATE_NUMBER"));
					assoInfo.setLeaderAssignment(rs.getString("LEADERSHIP_ASSIGNMENT"));
					assoInfo.setDeptManager(rs.getString("ASSOCIATE_NAME").trim());
					assoInfo.setDivManager("");
					assoInfo.setDivName("");
					assoInfo.setPid("");
				}
				rs.close();
				stmt.close();
				conn.close();
			}
			if(recordNotExist){
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.add(PropertyFactoryUtil.forName("ASSOCIATE_NUMBER").eq(associateNumber));
				int wfmPositionscount = (int) WFMS_NA_SupportLocalServiceUtil.dynamicQueryCount(associateInfoCount);
				if(wfmPositionscount>0){
				WFMS_NA_Support associateInfo=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Support(associateNumber);
					assoInfo.setAssociateDateOfHire(associateInfo.getASSOCIATE_DATE_OF_HIRE());
					assoInfo.setAssociateName(associateInfo.getASSOCIATE_NAME());
					assoInfo.setDeptNumber(associateInfo.getDEPT_NUMBER());
					assoInfo.setDeptName(associateInfo.getDEPT_NAME());
					assoInfo.setAssociateTitle(associateInfo.getASSOCIATE_TITLE());
					assoInfo.setShiftCode(associateInfo.getSHIFT_CODE());
					assoInfo.setTeamNumber(associateInfo.getTEAM_NUMBER());
					assoInfo.setMgrAssociateNo(Integer.toString(associateInfo.getMANAGER_ASSOCIATE_NUMBER()));
					assoInfo.setLeaderAssignment(associateInfo.getLEADERSHIP_ASSIGNMENT());
					assoInfo.setDeptManager(associateInfo.getASSOCIATE_NAME());
					assoInfo.setDivManager("");
					assoInfo.setDivName("");
					assoInfo.setPid("");
				}
			}
		} catch (Exception e1) {
			_log.error("In HMAAssociateInfoService.fetchPositionOnAssociateNumber Error", e1);
			if(conn !=null){
				try {
					conn.rollback();
				} catch (SQLException e) {
					_log.error("SystemException : HMAAssociateInfoService.fetchPositionOnAssociateNumber");
				}
			}
		}finally{
			try {
				if(conn !=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null){
					stmt.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs !=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return assoInfo;
	}
	
	public static AssociateInformation fetchDepManagerInfo(String associateNumber) throws SQLException{

		Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
		AssociateInformation assoInfo = new AssociateInformation();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			boolean recordNotExist=true; 
			if (conn != null) {
				String sql = "SELECT ASSOCIATE_NAME, ASSOCIATE_TITLE FROM "+assocTableName+
						" where ASSOCIATE_NUMBER='"+ associateNumber + "' ";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					recordNotExist=false;
					assoInfo.setAssociateName(rs.getString("ASSOCIATE_NAME").trim());
					assoInfo.setAssociateTitle(rs.getString("ASSOCIATE_TITLE"));
				}
				rs.close();
				stmt.close();
				conn.close();
			}
			if(recordNotExist){
				DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
				associateInfoCount.add(PropertyFactoryUtil.forName("ASSOCIATE_NUMBER").eq(associateNumber));
				int wfmPositionscount = (int) WFMS_NA_SupportLocalServiceUtil.dynamicQueryCount(associateInfoCount);
				if(wfmPositionscount>0){
				    WFMS_NA_Support associateInfo=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Support(associateNumber);
					assoInfo.setAssociateName(associateInfo.getASSOCIATE_NAME());
					assoInfo.setAssociateTitle(associateInfo.getASSOCIATE_TITLE());
				}
			}
		} catch (Exception e1) {
			_log.error("In HMAAssociateInfoService.fetchPositionOnAssociateNumber Error", e1);
			if(conn !=null){
				try {
					conn.rollback();
				} catch (SQLException e) {
					_log.error("SystemException : HMAAssociateInfoService.fetchPositionOnAssociateNumber");
				}
			}
		}finally{
			try {
				if(conn !=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null){
					stmt.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs !=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return assoInfo;
	}
	
	
	public static AssociateInformation fetchPositionOnManagerAssociateNo(String associateNumber) throws SQLException{

		Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
		AssociateInformation assoInfo = new AssociateInformation();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			boolean recordNotExist=true; 
			if (conn != null) {
				String sql = "SELECT ASSOCIATE_DATE_OF_HIRE, ASSOCIATE_NAME, DEPT_NUMBER,DEPT_NAME, ASSOCIATE_TITLE,SHIFT_CODE,"+
						"TEAM_NUMBER, MANAGER_ASSOCIATE_NUMBER, LEADERSHIP_ASSIGNMENT FROM "+assocTableName+
						" where ASSOCIATE_NUMBER='"+ associateNumber + "' ";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					
					recordNotExist=false;
					assoInfo.setAssociateDateOfHire(rs.getString("ASSOCIATE_DATE_OF_HIRE"));
					assoInfo.setAssociateName(rs.getString("ASSOCIATE_NAME").trim());
					assoInfo.setDeptNumber(rs.getString("DEPT_NUMBER").trim());
					assoInfo.setDeptName(rs.getString("DEPT_NAME"));
					assoInfo.setAssociateTitle(rs.getString("ASSOCIATE_TITLE"));
					assoInfo.setShiftCode(rs.getString("SHIFT_CODE"));
					assoInfo.setTeamNumber(rs.getString("TEAM_NUMBER"));
					assoInfo.setMgrAssociateNo(rs.getString("MANAGER_ASSOCIATE_NUMBER"));
					assoInfo.setLeaderAssignment(rs.getString("LEADERSHIP_ASSIGNMENT"));
					assoInfo.setDeptManager(rs.getString("ASSOCIATE_NAME").trim());
					assoInfo.setDivManager("");
					assoInfo.setDivName("");
					assoInfo.setPid("");
				}
				rs.close();
				stmt.close();
				conn.close();
			}
		/*	if(recordNotExist){
				DynamicQuery associateInfoCount =DynamicQueryFactoryUtil.forClass(WFMS_NA_Support.class);
				associateInfoCount.add(PropertyFactoryUtil.forName("ASSOCIATE_NUMBER").eq(associateNumber));
				int wfmPositionscount = (int) WFMS_NA_SupportLocalServiceUtil.dynamicQueryCount(associateInfoCount);
				if(wfmPositionscount>0){
				WFMS_NA_Support associateInfo=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Support(associateNumber);
					assoInfo.setAssociateDateOfHire(associateInfo.getASSOCIATE_DATE_OF_HIRE());
					assoInfo.setAssociateName(associateInfo.getASSOCIATE_NAME());
					assoInfo.setDeptNumber(associateInfo.getDEPT_NUMBER());
					assoInfo.setDeptName(associateInfo.getDEPT_NAME());
					assoInfo.setAssociateTitle(associateInfo.getASSOCIATE_TITLE());
					assoInfo.setShiftCode(associateInfo.getSHIFT_CODE());
					assoInfo.setTeamNumber(associateInfo.getTEAM_NUMBER());
					assoInfo.setMgrAssociateNo(Integer.toString(associateInfo.getMANAGER_ASSOCIATE_NUMBER()));
					assoInfo.setLeaderAssignment(associateInfo.getLEADERSHIP_ASSIGNMENT());
					assoInfo.setDeptManager(associateInfo.getASSOCIATE_NAME());
					assoInfo.setDivManager("");
					assoInfo.setDivName("");
					assoInfo.setPid("");
				}
			}*/
		} catch (Exception e1) {
			_log.error("In HMAAssociateInfoService.fetchPositionOnAssociateNumber Error", e1);
			if(conn !=null){
				try {
					conn.rollback();
				} catch (SQLException e) {
					_log.error("SystemException : HMAAssociateInfoService.fetchPositionOnAssociateNumber");
				}
			}
		}finally{
			try {
				if(conn !=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null){
					stmt.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs !=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return assoInfo;
	}
	
	
	public static Map<String,String> getMsrAssociateNoToNewCOS(){

	    Map<String,String> recordmap = new LinkedHashMap<String,String>();
	    Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try{
	        if(conn!=null){
	            String sql = "SELECT ASSOCIATE_NUMBER ,ASSOCIATE_NAME  FROM " + assocTableName + " where leadership_assignment != '' ";

	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	        }


	        while(rs.next()){
	           if(rs.getString("ASSOCIATE_NUMBER") != null){
	        	   recordmap.put(rs.getString("ASSOCIATE_NUMBER").trim(), rs.getString("ASSOCIATE_NAME").trim());
	           }
	        }
	        conn.close();
			stmt.close();
			rs.close();
		
				Set<String> hs = new HashSet<String>();
		
	    }catch(SQLException ex){
    		_log.error("HMAAssociateInfoService.getLeaderShipCos() Error",ex);
	    	if(conn != null){   
		    	try{
		                conn.close();
		            }catch(Exception e){
		            	e.printStackTrace();
		        	}
		    	}
	        }finally{
	            try{
	                if(rs != null){
	                    rs.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	            try{
	                if(stmt != null){
	                    stmt.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	            try{
	                if(conn != null){
	                    conn.close();
	                }
	            }catch(Exception e){e.printStackTrace();}
	        }
	    return recordmap;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 */
	
	public static void getMgrAssociateNo(ResourceRequest request,
			ResourceResponse response) {

		Connection connTemp = HMADB2Connection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PrintWriter out = null;
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String assocTableName = HMADB2Connection.getAssocTableName();
		try {
			String positionId = request.getParameter("mgrAssociateId");
			WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil
					.getByPositionId(positionId);
			try {
				
				boolean recordNotExist=true;
				if (wfms_Position.getDepartmentNumber() != null) {
					String sql = "SELECT ASSOCIATE_NAME,ASSOCIATE_TITLE FROM "+assocTableName+" where DEPT_NUMBER='"
							+ wfms_Position.getDepartmentNumber() + "' ";
					stmt = connTemp.prepareStatement(sql);
					rs = stmt.executeQuery();
					while (rs.next()) {
						recordNotExist=false;
						String mgrTitleincurrent = rs.getString("ASSOCIATE_TITLE");
						String mgrNameincurrent = rs.getString("ASSOCIATE_NAME");
						json.put("ASSOCIATE_TITLE", mgrTitleincurrent);
						json.put("ASSOCIATE_NAME", mgrNameincurrent);
					}
				}
				rs.close();
				stmt.close();
				connTemp.close();
				
				if(recordNotExist){
					DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
					associateInfoCount.add(PropertyFactoryUtil.forName("DEPT_NUMBER").eq(wfms_Position.getDepartmentNumber()));
					List <WFMS_NA_Support> wfmNaSupport =  WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
					if(wfmNaSupport.size()>0){
						for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
							json.put("ASSOCIATE_TITLE", wfmNaSupportAssociate.getASSOCIATE_TITLE().trim());
							json.put("ASSOCIATE_NAME", wfmNaSupportAssociate.getASSOCIATE_NAME().trim());
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(json);
		}catch (Exception e) {
			_log.error(" ChangeOfStatusPortlet.getMgrAssociateNo  Error",e);	
			if (connTemp != null) {
	            try {
	            	_log.error("Change of status is being rolled back");
	                connTemp.rollback();
	            } catch(SQLException excep) {
	                _log.error(" ChangeOfStatusPortlet.getMgrAssociateNo Error ",excep);
	            }
	        }
		}finally{
			try {
				if(connTemp !=null){
					connTemp.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null){
					stmt.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs !=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Create Requisition */
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public AssociateInformation createRequisition(String associatenumber) throws Exception {
		AssociateInformation assinfo = new AssociateInformation();
		Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
		PreparedStatement stmt = null;
		ResultSet rs = null;
        String associateName="";
        String associateTitle="";
       try{
    		boolean recordNotExist=true; 
		if (conn != null) {
			String sql = "SELECT ASSOCIATE_NAME,ASSOCIATE_TITLE FROM "+assocTableName +" WHERE ASSOCIATE_NUMBER='"+ associatenumber + "'";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				recordNotExist=false; 
				associateName=rs.getString("ASSOCIATE_NAME");
				associateTitle=rs.getString("ASSOCIATE_TITLE");
			}
		}
		if(recordNotExist){
			DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
			associateInfoCount.add(PropertyFactoryUtil.forName("ASSOCIATE_NUMBER").eq(associatenumber));
			long wfmNaSupport =  WFMS_NA_SupportLocalServiceUtil.dynamicQueryCount(associateInfoCount);
			if(wfmNaSupport>0){
				
			//_log.info("<<<<associatenumber>>>>"+associatenumber);
				WFMS_NA_Support wfmNaSupportRecord=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Support(associatenumber);
				associateName=wfmNaSupportRecord.getASSOCIATE_NAME();
				associateTitle=wfmNaSupportRecord.getASSOCIATE_TITLE();
				//_log.info("<<<<getASSOCIATE_NAME>>>>"+wfmNaSupportRecord.getASSOCIATE_NAME());
				//_log.info("<<<<getASSOCIATE_TITLE>>>>"+wfmNaSupportRecord.getASSOCIATE_TITLE());
			}
		}
		assinfo.setAssociateName(associateName);
		assinfo.setAssociateTitle(associateTitle);
		
       }
       catch(Exception e){
    	   e.printStackTrace(); 

			try {
				conn.rollback();
			} catch (SQLException ex) {
				_log.error("SystemException : while getting error change of status is being rollback",ex);
			}
		}finally{
			
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs !=null){
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
       return assinfo;
	}
	
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void fetchDeptNumberOnCos(ResourceRequest request,
			ResourceResponse response) throws IOException {
		
		Connection conn = HMADB2Connection.getConnection();
		String assocTableName = HMADB2Connection.getAssocTableName();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PrintWriter out = null;
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String deptNumber = request.getParameter("departmentNumber");
		String deptnumber = null;
		try {
			boolean recordNotExist=true; 
			if (conn != null) {
				String sql = "SELECT SHIFT_CODE,TEAM_NUMBER,LEADERSHIP_ASSIGNMENT,DEPT_NUMBER FROM "+assocTableName+" where DEPT_NUMBER='"
						+ deptNumber + "'";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					recordNotExist=false;
					deptnumber = rs.getString("DEPT_NUMBER").trim();
					json.put("DEPT_NUMBER", deptnumber);
					String leadershipassignment=rs.getString("LEADERSHIP_ASSIGNMENT");
					json.put("LEADERSHIP_ASSIGNMENT", leadershipassignment);
				}
				conn.close();
			}
			if(recordNotExist){
					DynamicQuery associateInfoCount =WFMS_NA_SupportLocalServiceUtil.dynamicQuery();
					associateInfoCount.add(PropertyFactoryUtil.forName("DEPT_NUMBER").eq(deptNumber));
					List <WFMS_NA_Support> wfmNaSupport =  WFMS_NA_SupportLocalServiceUtil.dynamicQuery(associateInfoCount);
					if(wfmNaSupport.size()>0){
						for(WFMS_NA_Support wfmNaSupportAssociate:wfmNaSupport){
							deptnumber =wfmNaSupportAssociate.getDEPT_NUMBER();
							json.put("DEPT_NUMBER", deptnumber);
							String leadershipassignment=wfmNaSupportAssociate.getLEADERSHIP_ASSIGNMENT();
							json.put("LEADERSHIP_ASSIGNMENT", leadershipassignment);
						}
					}
				}
		} catch (Exception e1) {
			_log.error(" ChangeOfStatusPortlet.fetchDeptNumberOnCos  Error",e1);
			if(conn !=null){
				try {
					conn.rollback();
				} catch (SQLException e) {
					_log.error("SystemException : while getting error change of status is being rollback");
				}
			}
		}finally{
			
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs !=null){
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out = response.getWriter();
		out.println(json);
	}
	
	private static Log _log = LogFactoryUtil.getLog(HMAAssociateInfoService.class.getName());
		
}