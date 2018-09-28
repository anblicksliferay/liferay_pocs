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
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.portlets.constants.WorkflowConfigurationPortletKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_Config;
import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills;
import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsImpl;
import com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skills_auditImpl;
import com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_associate_skillsLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_associate_skills_auditLocalServiceUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=HMA-WMS",
        "com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.view-template=/html/associateHistory/list.jsp",
		"javax.portlet.name=" + WorkflowConfigurationPortletKeys.AssociateHistory,
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.display-name=WMS-AssociateHistory"
    },
    service = Portlet.class
)
public class AssociateHistoryPortlet extends MVCPortlet {

	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {

		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/html/associateHistory/list.jsp");
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		boolean loggedIn = themeDisplay.isSignedIn();
		if (!loggedIn) {
			prd = getPortletContext().getRequestDispatcher("/html/signin.jsp");
		}

		prd.include(request, response);
	
	}
	public void associateList(ActionRequest actionRequest, ActionResponse actionResponse) throws SQLException{
	//	System.out.print("filterType"+actionRequest.getParameter("filterType"));
		if(actionRequest.getParameter("filterType")!=null)
	     	actionRequest.setAttribute("filterType", actionRequest.getParameter("filterType"));
		actionResponse.setRenderParameter("jspPage","/html/associateHistory/list.jsp");
	}
	public void associateInformation(ActionRequest actionRequest, ActionResponse actionResponse) throws SQLException{
		try{
			String associateId=actionRequest.getParameter("associateId");
			actionRequest.setAttribute("associateNumber", associateId);
		}
		catch (Exception e){
		}
		actionResponse.setRenderParameter("jspPage",	"/html/associateHistory/manageAssociateHistory.jsp");
	}
	
	public void updateAssociateSkills(ActionRequest actionRequest, ActionResponse actionResponse) throws SQLException{

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		
		Date createdDate = new Date();
		
		try{
			User user = UserLocalServiceUtil.getUserById(userId);
			String associateId=actionRequest.getParameter("associateId");
			actionRequest.setAttribute("associateNumber", associateId);
		
			//	System.out.println("buttonvalue:"+actionRequest.getParameter("buttonvalue"));
			
			if(actionRequest.getParameter("buttonvalue").equalsIgnoreCase("save")){
					
				PortletSession session = actionRequest.getPortletSession();
				if(session.getAttribute("ass"+associateId)==null){
				//	System.out.println("enter if");
						session.setAttribute("ass"+associateId,associateId);
						 DynamicQuery wfms_associate_skillsquery =WFMS_associate_skillsLocalServiceUtil.dynamicQuery();
						 wfms_associate_skillsquery.add(PropertyFactoryUtil.forName("associate_number").eq(associateId));
						 WFMS_associate_skills wfms_associate_skills = new WFMS_associate_skillsImpl();
						 if(WFMS_associate_skillsLocalServiceUtil.dynamicQueryCount(wfms_associate_skillsquery)>0){
							 wfms_associate_skills = WFMS_associate_skillsLocalServiceUtil.fetchWFMS_associate_skills(associateId);
						 }
						 wfms_associate_skills.setAssociate_number(associateId);
						 
						 
						 
						 WFMS_associate_skills_audit wfms_associate_skills_audit = new WFMS_associate_skills_auditImpl();
						 wfms_associate_skills_audit.setAssociate_log_id(CounterLocalServiceUtil.increment(WFMS_associate_skills_audit.class.getName()));
						 wfms_associate_skills_audit.setAssociate_number(associateId);
						 wfms_associate_skills_audit.setUserId(userId);
						 wfms_associate_skills_audit.setCreateDate(createdDate);
						 wfms_associate_skills_audit.setCreatedBy(user.getFullName());
						 
				 
							WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey("Associate-Skills");
							com.liferay.portal.kernel.json.JSONObject jObject= JSONFactoryUtil.createJSONObject(wfms_config.getContent());
							Iterator<String> iterator = jObject.keys();
							String associateSkillsList=actionRequest.getParameter("skillsList");
							String associateSkills1[] = associateSkillsList.split(",");
							String data="null";
							while( iterator.hasNext() ){
						    String key = (String)iterator.next();
						    com.liferay.portal.kernel.json.JSONObject jObject1=JSONFactoryUtil.createJSONObject(jObject.getString(key));
						    Iterator<String> iterator1 = jObject1.keys();
						  
						    while( iterator1.hasNext() ){
						    	 String key1= (String)iterator1.next();
						    	 if(Arrays.asList(associateSkills1).contains(key1)){ 
						    		 if(data.equals("null")) 
						    			 data=jObject1.getString(key1); 
						    		 else 
						    			 data+=", "+jObject1.getString(key1); 
						    		 
						    	 } 
						       }  
						    }
						wfms_associate_skills_audit.setChange(data);
						 if(WFMS_associate_skillsLocalServiceUtil.dynamicQueryCount(wfms_associate_skillsquery)>0){
							 if(!actionRequest.getParameter("skillsList").equalsIgnoreCase(wfms_associate_skills.getSkills())){
								   wfms_associate_skills.setSkills(actionRequest.getParameter("skillsList"));
								   WFMS_associate_skillsLocalServiceUtil.updateWFMS_associate_skills(wfms_associate_skills);
								   WFMS_associate_skills_auditLocalServiceUtil.updateWFMS_associate_skills_audit(wfms_associate_skills_audit);
							 }
						 }
						 else{
							 wfms_associate_skills.setSkills(actionRequest.getParameter("skillsList"));
							 WFMS_associate_skillsLocalServiceUtil.updateWFMS_associate_skills(wfms_associate_skills);
							 WFMS_associate_skills_auditLocalServiceUtil.updateWFMS_associate_skills_audit(wfms_associate_skills_audit);
						 }
						
						
						
						
				}
				else{
				//	System.out.println("enter else");
					session.removeAttribute("ass"+associateId);
				}
		   }
		}
		catch (Exception e){
			
		}
		//SessionMessages.add(actionRequest, "success");
		//actionResponse.setRenderParameter("jspPage",	"/html/associateHistory/list.jsp");
	}
	public void myProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
	}
}