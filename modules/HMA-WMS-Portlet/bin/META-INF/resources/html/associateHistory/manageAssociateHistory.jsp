<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Position"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Config"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_Associate_HistoryLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Associate_History"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_associate_skills_auditLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_associate_skillsLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_associate_skills"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Session"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.vo.AssociateInformation"%>
<%@ include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.util.Iterator"%>
<%
String associateNumber = (String)request.getAttribute("associateNumber");
//AssociateInformation associateInfoservice = HMAAssociateInfoService.fetchPositionOnAssociateNumber(associateNumber);

WFMS_associate_skills wfms_associate_skills = WFMS_associate_skillsLocalServiceUtil.fetchWFMS_associate_skills(associateNumber);
String associate_skillsList="";
if(wfms_associate_skills!=null){
	associate_skillsList=wfms_associate_skills.getSkills();
}
String associateSkills[] = associate_skillsList.split(",");

String pId="";
String depNumner=StringPool.BLANK;
DynamicQuery dynamicQuery = WFMS_PositionLocalServiceUtil.dynamicQuery();
dynamicQuery.add(PropertyFactoryUtil.forName("associateNumber").eq(associateNumber));
List<WFMS_Position> list=WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQuery);
	if(list.size()>0){
		pId=list.get(0).getPId();
	     depNumner=list.get(0).getDepartmentNumber();	
	}
	
	
%>
<aui:script>
$(document).ready(function() {


$('.field-radio').on('change', function() {
var checkboxValues = [];
  $('.field-radio:checkbox:checked').each(function () {
     checkboxValues.push($(this).val());
   });
  $("#<portlet:namespace/>skillsList").val(checkboxValues);
});

 $("#savebutton").on('click',function () {
           $("#<portlet:namespace/>buttonvalue").val("save");
            $("#<portlet:namespace/>associateInformation").submit();
        });
 });
        </aui:script>
        <% 
		boolean flag=WMSUserAccessUtil.checkPermissionForRequisition(renderRequest, PortletPropsPermission.ASSOCIATE_SAVE,depNumner);
        
   	 DynamicQuery queryForhistory =WFMS_Associate_HistoryLocalServiceUtil.dynamicQuery();
	 queryForhistory.add(PropertyFactoryUtil.forName("associateId").eq(associateNumber));
	 queryForhistory.addOrder(OrderFactoryUtil.desc("assocHistoryId"));
	 List<WFMS_Associate_History> associateAuditList= WFMS_Associate_HistoryLocalServiceUtil.dynamicQuery(queryForhistory);	
	 String currentPosition="";
	 String associateName="";
	 if(associateAuditList.size()>0){
		 associateName=associateAuditList.get(0).getAssociateName();
		 currentPosition=associateAuditList.get(0).getCurrentPosition();
	 }
		%>
<portlet:actionURL name="updateAssociateSkills" var="updateAssociateSkillsURL"> </portlet:actionURL>

<aui:form action="<%=updateAssociateSkillsURL.toString() %>" method="post" name="associateInformation">
	<aui:input name="associateId" type="hidden" value="<%=associateNumber%>"/>
	<aui:input name="skillsList" type="hidden" value="<%=associate_skillsList%>"/>
	<aui:input name="buttonvalue" type="hidden" value=""/>
<div class="wfm-system" style="margin-top: 20px;">
	<div class="portlet-layout row">
		<div class="portlet-column portlet-column-first col-sm-6">
			<h4>Associate History</h4>
		</div>

		<div class="portlet-column portlet-column-first col-sm-6">
			<div class="small right-align">
				<div>
					<button class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/associate-history')">Exit View</button>
					<%if(flag){%>
					<button id="savebutton" class="btn btn-primary">Save</button>
					<% }%>
					<!-- <button class="btn btn-primary" onclick="getUrl('#')">Disapprove</button>  -->
				</div>
			</div>

			<div>
				<p>&nbsp;</p>
			</div>
		</div>
	</div>

	<div class="portlet-layout row">
		<div class="portlet-column col-sm-6">
			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate
					Number</div>

				<div class="portlet-column portlet-column-last col-sm-7"><%=associateNumber %></div>
			</div>

			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate
					Name</div>

				<div class="portlet-column portlet-column-last col-sm-7"><%=associateName%></div>
			</div>
		</div>

		<div class="portlet-column col-sm-6">
			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Current Position</div>
				<div class="portlet-column portlet-column-last col-sm-7"><%=currentPosition%></div>
			</div>
		</div>
	</div>

	<h3 class="subsection">Associate Position History</h3>
	<textarea class="field" cols="55" disabled="disabled" placeholder=""
		rows="10" style="width: 98%">
		<% 
		try{
		
			 if(associateAuditList.size()>0){
					//ArrayList<String> arrlist = new ArrayList<String>();
					for(WFMS_Associate_History asoHistory:associateAuditList){
						out.println();
						//if(asoHistory.getCreatedBy().equalsIgnoreCase("existingData")){
							out.println(asoHistory.getHistory());
						//}
						//else{
						//  out.println(asoHistory.getHistory()+ " on " +HondaLogicUtil.getDateFormat(asoHistory.getCreateDate())+" by "+asoHistory.getCreatedBy());
						//}
					}
		
           }
           else{
		%>No Records Found
		<% } 
			 }catch	(Exception e){
				 
		}
		
		
		%>
		</textarea>

	<h3 class="subsection">Associate Skills</h3>
<%  // Map<String, String[]> map = new HashMap<String, String[]>();
    // map= ConfigUtility.getOptionGroupValuesFromConfig("Associate-Skills");
    //
 %>
	<div class="portlet-layout">
	
	
			<% 
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey("Associate-Skills");
			JSONObject jObject= JSONFactoryUtil.createJSONObject(wfms_config.getContent());
			Iterator<String> iterator = jObject.keys();
			while( iterator.hasNext() ){
			    String key = (String)iterator.next();
			    JSONObject jObject1=JSONFactoryUtil.createJSONObject(jObject.getString(key));
			    Iterator<String> iterator1 = jObject1.keys();
			    %>
			    <h5><%=key%></h5>
			<%
			    while( iterator1.hasNext() ){
			    	 String key1= (String)iterator1.next();
			    	%>
		        <input <% if(!flag){ %> disabled="disabled" <% } if(Arrays.asList(associateSkills).contains(key1)){ %> checked="checked" <% } %> class="field-radio" name="skills" type="checkbox" value="<%=key1 %>" /><label class="skills"><%=jObject1.getString(key1) %></label> 
			  <%  }  } %>	
	
	</div>
</div>
  </aui:form>
  <div class="portlet-layout">
	<div class="logs_main"
		style="font-style: oblique; font-size: 12px">
		<b>Log:</b>
	</div>
	
	
	<div class="users col-sm-12">
		<div class="logs_comments">
			<%
			dynamicQuery = WFMS_associate_skills_auditLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("associate_number").eq(associateNumber));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("associate_log_id"));
			//dynamicQuery.addOrder(arg0)(associateNumber);
				List<WFMS_associate_skills_audit> wfms_auditlist = WFMS_associate_skills_auditLocalServiceUtil.dynamicQuery(dynamicQuery);
			%>
			<%
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey("Associate-Skills");
			JSONObject jObject= JSONFactoryUtil.createJSONObject(wfms_config.getContent());
			Iterator<String> iterator = jObject.keys();
			if(!wfms_auditlist.isEmpty()){
				for (WFMS_associate_skills_audit wfms_audit : wfms_auditlist) {
	                                      %>
	        <div class="logs">
				<div class="user_comments" id="user_comments">
					<br> 
					<%=wfms_audit.getCreatedBy()%>
					Set skills to 
					<b><%=wfms_audit.getChange()%></b>
					On :
					<%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate())%>
				</div>
			</div>
			<% } }else{ %>
			 <div class="logs">No Records Found</div>
			<% } %>
			</div>
		</div>
	</div>
