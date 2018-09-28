<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Arrays"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.ys.hmawfm.wfms.workflow.WorkflowConstants"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_COS_AuditLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Position"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.ys.hmawfm.wfms.utils.ConfigUtility"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers"%>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaPermissionKeys"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ys.hmawfm.wfms.services.rest.CostCenterService"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_COS"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page trimDirectiveWhitespaces="true" %>
<div class="manageCOS">
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_names"%>
<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />
<portlet:actionURL name="disapproveCommentsCOS" var="disApproveCommentsCOSURL"></portlet:actionURL>
<portlet:actionURL name="updateCosofPos" var="updateCosofPosURL"></portlet:actionURL>
<portlet:actionURL name="updateCosofTitle" var="updateCosofTitleURL"></portlet:actionURL>
<portlet:actionURL name="addWFMSCOS" var="addWFMSCOSURL"></portlet:actionURL>
<portlet:actionURL name="associateIdForCOS" var="associateIdForCOSURL"></portlet:actionURL>
<portlet:actionURL name="cancelCOS"	var="cancelCOSURL"></portlet:actionURL>
<portlet:resourceURL var="AssNumURL">
<portlet:param name="<%=Constants.CMD %>" value="getAssNumURL"></portlet:param>
</portlet:resourceURL>
<portlet:renderURL var="generateCosPopupURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
<portlet:param name="jspPage" value="/html/changeOfStatus/generateCosPopup.jsp" />
</portlet:renderURL>
<%String posID="";
String[] values = null;
String annouced = null;
annouced=(String)request.getAttribute("annouced");
WFMS_COS wfmsCOS = (WFMS_COS) request.getAttribute("wfms_CosObj");
String AssociateNumber=(String)request.getAttribute("AssociateNumber");
String associateID=(String)request.getAttribute("associateID");
String modifyButtonEnable=(String)request.getAttribute("modifyButtonEnable");
String associateIdForExistingRecord=(String)request.getAttribute("associateIdForExistingRecord");
String deptNumber=Validator.isNotNull(wfmsCOS)?wfmsCOS.getNewDepartmentNumber():null;
if(wfmsCOS!=null)
associateID=wfmsCOS.getAssoicateId();
 CostCenterService centerManagerService = new CostCenterService();
 long userId = themeDisplay.getUserId();
 long companyId = user.getCompanyId();
 String screenName=StringPool.BLANK;
 if(wfmsCOS!=null)  screenName = wfmsCOS.getCreatedBy();
 boolean userIsDepartmentManager = false; //REST Service Lookup needs to be developed
 boolean userIsDepartmentManpower = false; //REST Service Lookup needs to be developed
 boolean permission_add1stSet = WMSUserAccessUtil.doesUserHaveAccess(user, companyId, "position",
  "add2ndSet", false, userIsDepartmentManager, userIsDepartmentManpower);
Map<String,String> deptMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
List<String> cosAsscnumbers1= new ArrayList<String>();
DynamicQuery queryForcosAssoc =WFMS_COSLocalServiceUtil.dynamicQuery();
Criterion reqcriterion_cosAssoc = null;
                    reqcriterion_cosAssoc = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DRAFT);
                    reqcriterion_cosAssoc = RestrictionsFactoryUtil.or(reqcriterion_cosAssoc,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT));
					queryForcosAssoc.add(reqcriterion_cosAssoc);
					if(wfmsCOS != null){
						queryForcosAssoc.add(PropertyFactoryUtil.forName("cosId").ne(wfmsCOS.getCosId()));
					}
    queryForcosAssoc.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
  List<WFMS_COS> cosAsscnumbers= WFMS_COSLocalServiceUtil.dynamicQuery(queryForcosAssoc);
  int sumcosAsscnumbers = (int)WFMS_COSLocalServiceUtil.dynamicQueryCount(queryForcosAssoc);
  if(sumcosAsscnumbers > 0){
      for(WFMS_COS sumcosAsscnumber1:cosAsscnumbers){
    	 cosAsscnumbers1.add(sumcosAsscnumber1.getAssoicateId());        
      } }
  cosAsscnumbers1.remove(associateID);
%>
<aui:form action="<%=updateCosofPosURL.toString() %>" method="post" name="updateCosofPos"></aui:form>
<aui:form action="<%=updateCosofTitleURL.toString() %>" method="post" name="updateCosofTitle"></aui:form>
<aui:form action="<%= addWFMSCOSURL.toString()%>" method="post"
	name="addWFMSCOS" id="addWFMSCOS">
<div style="display:none">
<aui:input type="hidden" name="hidden_field" required="true" ></aui:input>
<aui:input type="hidden" name="validation_type" label="" value="0"> </aui:input>
<aui:input type="hidden"  name="currentpositionText" label=""></aui:input>
</div>
<div class="portlet-layout">
		<h2 class="titleArea">Create Change of Status
			<input class="titleArea" type="button" value="Print" id="btnPrint" onclick="printDiv('printableArea')"/>
		</h2>
</div>
<div class="portlet-layout">
	<div class="col-sm-12">
		<div class="wfm-system">
		     <div  id="errorMsgForAssociateNumber" style="color:#b50303; font-weight:bold;font-size:14px;"></div>
			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-6">
					 <div class="portlet-layout row">
					<% if(wfmsCOS == null){ %>
					 <div class="col-sm-5">&nbsp;</div>
					 <div class="col-sm-6">
					 	<div class="guide_alert" id="msgForAssociateNumber" style="display:none;margin-left:6px;height:25px;width:215px;">Please fill Associate Number</div>
					 </div>
					 <div class="col-sm-6" id="msgForAssociateNumberBlank">&nbsp;</div>
					 <% } %>
						<div class="portlet-column portlet-column-first col-sm-5">
							<span class="sectionLabel">Associate Number</span>
						</div>
						<div class="portlet-column portlet-column-last col-sm-7" id="associaNumber_mainDiv">
                        <% if(wfmsCOS == null){ %>
							<aui:select name="assoicateId" id="associaNumber" onChange="loadAssociateNo();" cssClass="field-select chosen" label="" showRequiredLabel="false" maxlength="75">
								<aui:option value="" selected="selected">Select Associate Number</aui:option>
								<%	
								String sb=HondaLogicUtil.getassoNumbersByFilterd("", WorkflowConstants.CHANGE_OF_STATUS_ACTION);
									Map<String,String> assMap = HMAAssociateInfoService.getAssociateNumbersWithNaTable("Cos",sb.toString());
									boolean asscSelected = false;
									Map<String,String> treeMap = new TreeMap<String, String>(assMap);
									for (String associatenumber : treeMap.keySet()) {
										String ASSOCIATE_NUMBER = associatenumber;
										String ASSOCIATE_NAME = assMap.get(associatenumber);
										if(!cosAsscnumbers1.contains(ASSOCIATE_NUMBER)){
									%>
								 <aui:option value="<%= ASSOCIATE_NUMBER %>"><%= ASSOCIATE_NUMBER+" - "+ASSOCIATE_NAME %></aui:option>
							<% } } %>
							</aui:select> 
							<div class="form-validator-stack help-inline customErroeClass associaNumber_ValidationMessage" style="display:none;">
							     Missing required value for the field "Associate Number"</div>
						<% }else {  %>
							  <aui:select name="assoicateId" id="associaNumber" disabled="true" cssClass="field-select chosen" label="" showRequiredLabel="false" maxlength="75">
								<aui:option value="">Select Associate Number</aui:option>
								<aui:option selected="true" value="<%=wfmsCOS.getAssoicateId().trim() %>"><%=wfmsCOS.getAssoicateId().trim()+" - "+wfmsCOS.getAssociatename() %></aui:option>
							</aui:select> 
							<aui:input type="hidden"  name="hiddenAssociateId" value="<%=wfmsCOS.getAssoicateId() %>"></aui:input><%  } %>
						</div>
					</div>
                    <% if(wfmsCOS == null){%>
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5">
							<span class="sectionLabel">Associate Name</span>
						</div>
						<div class="portlet-column portlet-column-last col-sm-7" id="associateName"> </div>
					</div>
					<%} else {	%>
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5">
							<span class="sectionLabel">Associate Name</span>
						</div>
						<div class="portlet-column portlet-column-last col-sm-7" id="associateName">
						<div class="portlet-column portlet-column-last col-sm-7" id="assoName" name="assoName"><%=wfmsCOS.getAssociatename() %></div>
						</div>
					</div>
					<%}%>
				</div>
				<div class="portlet-column portlet-column-first col-sm-6"></div>
			</div>
		</div>
	</div>
</div>
<%
if(wfmsCOS==null){ %>
<div class="portlet-layout">
		<div class="col-sm-12 own-wrapper" id="buttonDivision">
			<div class="wfm-system">
				<div class="portlet-layout">
					<div class="portlet-column portlet-column-first">
						<div class="small center">
							<div class="col-sm-4">
							<button type="button" class="btn btn-primary" onclick="exitviewUrl('<%=wmsBasePath%>/change-of-status')">Exit View</button>
								<aui:input type="hidden" name="auto-gen-req-choice"/>
							</div>
							 <%if(WMSUserAccessUtil.checkPermissionForCOS(renderRequest,PortletPropsPermission.COS_DIS_APRV,deptNumber)){ %> 
							<div class="col-sm-4">
								<aui:button type="button" cssClass="btn btn-primary" value="Cancel"></aui:button>
							</div>
						 	 <%} %>  
							<div class="col-sm-4">
								<aui:button cssClass="btn btn-primary" type="button" name="saveButton" id="saveButton" onclick="formValidationForSave();"  value="Save"></aui:button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%}else { %>
	<div class="portlet-layout">
		<div class="col-sm-12 own-wrapper">
			<div class="wfm-system">
				<div class="portlet-layout">
					<div class="portlet-column portlet-column-first">
						<div class="small center">
							<div class="col-sm-3">
							<button type="button" class="btn btn-primary" onclick="exitviewUrl('<%=wmsBasePath%>/change-of-status')">Exit View</button>
								<aui:input type="hidden" name="auto-gen-req-choice"/>
							</div>
							<div class="col-sm-3">
								<aui:button type="button" cssClass="btn btn-primary" data-backdrop="static"
								id="cancel" data-toggle="modal" data-target="#myModal" value="Cancel"> </aui:button>
							</div>
						 <aui:input type="hidden" name="submitonworkflow" />
							<div class="col-sm-3">
								<aui:button cssClass="btn btn-primary" type="button" name="submitButton" id="submitButton" disabled="true" onclick="formvalidation('submit')"  value="Submit"></aui:button>
							</div>
							<% if(!wfmsCOS.getStatus().equals(HondaPermissionKeys.COS_DISAPPROVED)){ %>  
							<div class="col-sm-3">
								<aui:button cssClass="btn btn-primary" type="button" name="saveButton" id="saveButton" disabled="true" onclick="formvalidation('save');"  value="Save"></aui:button>
							</div>
							<%} %>
<% if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_DISAPPROVED)){ 
	if(WMSUserAccessUtil.permissionOnCOSModifyButton(renderRequest,PortletPropsPermission.COS_MODIFY_BUTTON)){ %>
<div class="col-sm-3">
<aui:button cssClass="btn btn-primary" type="button" id="modify_button" value="Modify" onClick="modifyFunction()"></aui:button>
							</div>
<%}}else{ %>
	<div class="col-sm-3">
		<aui:button cssClass="btn btn-primary" type="button" value="Modify" onClick="modifyFunction()"></aui:button>
	</div> <%} %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%} %>
 <aui:input type="hidden" name="saveForm" />
<div class="portlet-layout row">
	<div class="col-sm-12">
		<div class="wfm-system" style="margin-top:20px;">
		    <div class="portlet-layout row">
		        <div class="portlet-column col-sm-6">
                    <% if(wfmsCOS == null){  %>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Change of Status number</div>
		                <div class="portlet-column portlet-column-last col-sm-7"> </div>
		            </div>						
                      <%} else {%>
                    	<div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Change of Status number</div>
		                 <div class="portlet-column portlet-column-last col-sm-7"><%-- <%=cosId %> --%>
		                 <%=wfmsCOS.getCosId()%>
		                <aui:input type="hidden" name="cos-number" id="cos-number" value="<%=wfmsCOS.getCosId()%>" /> 
		            	</div> 
		            </div>
                    <%} %>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Created By</div>
		                <div class="portlet-column portlet-column-last col-sm-7" > <% if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){%>System Generated<%}else{%><%=screenName%><%} %></div>
		            </div>
		         	<div class="portlet-layout row">
		         		<div class="col-sm-5"></div>
		         		<div class="col-sm-7">
							<div class="guide_alert" id="msgForEffectiveDate" style="margin-left:5px;display:none;">Please fill Effective Date</div>
						</div>
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Effective Date<br>(<i>Should be Thursday of the week</i>)</div>
						<div class="portlet-column portlet-column-last col-sm-7">
							<div id="startDate_maindiv">
							<%if(wfmsCOS==null) {%>										
										<aui:input name="effectiveDate" label="" id="startDate"
										maxlength="70" title="Click Here" readOnly="true" disabled="true"
										placeholder="MM/DD/YYYY" 
										style="cursor:pointer;background-color: white;width:205px;"
										errorMessageDivId="startDateErrorDiv">
										</aui:input>
								<% } else { %>										
										<aui:input name="effectiveDate" label="" id="startDate"
										maxlength="70" title="Click Here" readOnly="true" disabled="true"
										placeholder="MM/DD/YYYY" value="<%=wfmsCOS.getEffectiveDate() %>"
										style="cursor:pointer;background-color: white;width:205px;"
										errorMessageDivId="startDateErrorDiv">
										</aui:input>
										<!-- Edit and Save buttons for Effective Date -->
										<% if((WMSUserAccessUtil.checkPermission(renderRequest,PortletPropsPermission.COS_EDIT_COMMENTS))){ %>
										<button id="editEffectiveDate" style="width: auto; margin-top:-10px " onclick="editComment()"><i class="icon-edit"></i>&nbsp;Edit</button>
										<button id="saveEffectiveDate" onclick="saveComments()" style="width: auto;  margin-top:-10px " disabled ><i class="icon-check"></i>&nbsp;Save</button>
										<%} %>
							<% } %>
								 <div class="form-validator-stack help-inline startDate_ValidationMessage" style="display:none">
	 									Missing required value for the field "Effective Date"</div>
							</div> </div>
						</div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Change Description</div>
                        <%if(wfmsCOS==null) {%>
		                <div class="portlet-column portlet-column-last col-sm-7" id="changeDescription" style="display:none;"><div id="msgForchgDesc" class="guide_alert" margin-left:5px;"></div>
		                     <aui:select  name="type" label=""  onChange="scrolldownToNextSection();" id="chgDesc" showRequiredLabel="false" disabled="true" >
							</aui:select>
		                <%} else { %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="changeDescription" <%if(Validator.isNull(wfmsCOS.getReasonCODE())){ %>style="display:none;"<%} %>><div id="msgForchgDesc" class="guide_alert" style="display:none;margin-left:5px;">Please fill Change Description</div>
		                     <aui:select name="type" label="" id="chgDesc" showRequiredLabel="false" disabled="true" onChange="scrolldownToNextSection();" >
		                      <option value="">Select Change Description</option>
		                     <%
							     DynamicQuery dynamicreasonCode = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery();
           	                     DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
		        			 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionName").eq(wfmsCOS.getAction()));
		        			 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
		        			 if(actionListof.size()>0){
		                       dynamicreasonCode.add(PropertyFactoryUtil.forName("action").eq(actionListof.get(0).getActionId()));
		                       dynamicreasonCode.addOrder(OrderFactoryUtil.asc("changeDescription"));
		                       List<WFMS_routing_and_approvers> changeDesc=WFMS_routing_and_approversLocalServiceUtil.dynamicQuery(dynamicreasonCode);
							for(WFMS_routing_and_approvers changeDeslist : changeDesc){	%>								
								<aui:option selected="<%=wfmsCOS.getType().equals(changeDeslist.getChangeDescription()) %>" value="<%= changeDeslist.getChangeDescription() %>"><%= changeDeslist.getChangeDescription() %></aui:option>
							<% }  } %>
							</aui:select>
		                <%} %>
		                <div class="form-validator-stack help-inline chgDesc_ValidationMessage" id="chgdesc_message" style="display:none;">
							     Missing required value for the field "Change Description"</div>
		                </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Requisition Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7"> <%if(wfmsCOS==null) {
		                }else{
		                	if(wfmsCOS.getSystemGenerated() == 1 && Validator.isNotNull(wfmsCOS.getRequistionId())){%>
		                	<%=wfmsCOS.getRequistionId()%><%}}%></div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Should this be announced</div>
						<div class="portlet-column portlet-column-last col-sm-7">
						  <%if(wfmsCOS==null){%>
						        <input type="radio" name="<portlet:namespace/>announced"  value="1" id="announced1" />Yes
						        <input type="radio" name="<portlet:namespace/>announced"  value="0" id="announced2"  />No 
						  <%} else { %>
						      <% if(wfmsCOS.getAnnounced()==1) {%>
						             <input type="radio" name="<portlet:namespace/>announced" value="1" id="announced1"   checked="checked" />Yes 
						             <input type="radio" name="<portlet:namespace/>announced" value="0" id="announced2"  />No  
						      <%}else {%>
						        <input type="radio" name="<portlet:namespace/>announced" value="1" id="announced1"   />Yes 
						        <input type="radio" name="<portlet:namespace/>announced" value="0" id="announced2" checked="checked" />No 
						      <% }} %> 
						</div>
		            </div> 
		        </div>
		        <div class="portlet-column col-sm-6">
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Status</div>
                        <%if(wfmsCOS==null) {%>
		                <div class="portlet-column portlet-column-last col-sm-7">
		                </div>
		                <%} else { %>
		                 <div class="portlet-column portlet-column-last col-sm-7">
		                <%=wfmsCOS.getStatus() %>
		                </div>
		                <%} %>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date Created</div>
                        <%if(wfmsCOS==null) {%>
		                <div class="portlet-column portlet-column-last col-sm-7"> </div>
		                <%} else { %>
		                <div class="portlet-column portlet-column-last col-sm-7"><%= HondaLogicUtil.getDateFormat(wfmsCOS.getCreateDate()) %></div>
		                <%} %>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate Date of Hire</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="associatedateofhire">
			                <% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getAssociateDateOfHire())){%>
			                <%out.print(wfmsCOS.getAssociateDateOfHire()); %> <%}%>
							 </div>
							<%if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 2 ||  wfmsCOS.getSystemGenerated() == 1)){%>
						<aui:input name="associateDateOfHire" label="" id="associateDateOfHire" type="hidden" value=""></aui:input>	                 	
					<%}else{%>
					<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 0){%>
					<aui:input name="associateDateOfHire" label="" id="associateDateOfHire" type="hidden" value="<%=wfmsCOS.getAssociateDateOfHire() %>"></aui:input>
					<%}else{%>
					<aui:input name="associateDateOfHire" label="" id="associateDateOfHire" type="hidden" value=""></aui:input>
					<%}}%>		
				<aui:input name="associateDateOfHire" id="asDateOfHire" type="hidden" ></aui:input>
		            </div>
					<div class="portlet-layout row">
						<div class="col-sm-5"></div>
						<div class="col-sm-7">
							<div class="guide_alert" id="msgForActionCode" style="margin-left:5px;display:none;">Please fill Action</div>
						</div>
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel">Action</div>
						<div class="portlet-column portlet-column-last col-sm-7" id="action_maindiv">
						<%
						DynamicQuery dynamicQuery = WFMS_action_namesLocalServiceUtil.dynamicQuery();
						dynamicQuery.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
						dynamicQuery.addOrder(OrderFactoryUtil.asc("actionName"));
						List<WFMS_action_names> actionList=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQuery);
						if(wfmsCOS==null) {%>
							<aui:select name="action" config-level="0" id="actionCodeID" disabled="true" onChange="loadAction();"  config-key="Action" class="valueset-cosactions" label=""
							 showRequiredLabel="false">
							 <aui:option value="">Select Action</aui:option>
							 <% for(WFMS_action_names val:actionList){  %>
								 <aui:option  value="<%=val.getActionId() %>"><%=val.getActionName() %></aui:option>
								<%} %>
						</aui:select>
						<%} else { %>
							<aui:select name="action" config-level="0" id="actionCodeID" onChange="loadAction();" disabled="true" config-key="Action" class="valueset-cosactions" label=""
							 showRequiredLabel="false"  >
							 <aui:option value="">Select Action</aui:option>
							 <% 
							 List<String> actioncodeList= new ArrayList<String>();
							 for(WFMS_action_names val:actionList){ %>		
							   <aui:option selected="<%=wfmsCOS.getAction().equals(val.getActionName()) %>" value="<%=val.getActionId() %>"><%=val.getActionName() %></aui:option>
								<%} %>
						</aui:select>
						 <aui:input type="hidden"  name="hiddenAction" value="hiddenAction"></aui:input>
						<% } %>
						<div class="form-validator-stack help-inline action_ValidationMessage" id="action_message" style="display:none;">
							     Missing required value for the field "Action"
							</div>
						</div>
					</div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Reason Code</div>
                        <%if(wfmsCOS==null) { %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="reasonCODE" style="display:none;" ><div id="msgForreasonCODE" class="guide_alert" margin-left:5px;"></div>
		                  <aui:select name="reasoncode" id="reasoncode" class="portlet-reason" label="" disabled="true" onChange="onloadDescription();"> </aui:select>
		                <%}else{ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="reasonCODE" <%if(Validator.isNull(wfmsCOS.getAction())){ %>style="display:none;"<%} %> ><div id="msgForreasonCODE" class="guide_alert" style="margin-left:5px;display:none">Please fill Reason Code</div>
		                  <aui:select name="reasoncode"   id="reasoncode" class="portlet-reason" label=""  disabled="true" onChange="onloadDescription();">
		                 <%DynamicQuery dynamicreasonCode = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery();
		             	DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
						 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionName").eq(wfmsCOS.getAction()));
						 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
						 if(actionListof.size()>0)
	                     dynamicreasonCode.add(PropertyFactoryUtil.forName("action").eq(actionListof.get(0).getActionId()));
							List<WFMS_action_and_reasoncode> reasonCodelist = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery(dynamicreasonCode);
							for(WFMS_action_and_reasoncode reasonCODE : reasonCodelist){ %>
					        	<aui:option selected="<%=wfmsCOS.getReasonCODE().equals(reasonCODE.getReasonCode()) %>" value="<%= reasonCODE.getReasonCode() %>">
					        	   <%= reasonCODE.getReasonCode()%>-<%= reasonCODE.getDescription() %>
					        	   </aui:option>
							<% } %>                
		                  </aui:select>
		                <% } %>
		                 <div class="form-validator-stack help-inline reasoncode_ValidationMessage" id="reasoncode_message" style="display:none;">
							Missing required value for the field "Reason Code"</div>
		                </div>
		            </div>
		            <div class="portlet-layout row" style="height: 55px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Reason Description</div>
                        <%if(wfmsCOS==null){ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="description">
		               <!--  <input type="textarea" id="description" name="description"  label="" ></input> -->
		                </div>
		                <%} else { %>
		                 <div class="portlet-column portlet-column-last col-sm-7" id="description"> <%=wfmsCOS.getDescription() %>  </div>
		                <%} %>
		            </div>
		        </div>  
		    </div>
		<h3 class="subsection" id="current_position">Current and New Position Information</h3>
		    <div class="portlet-layout row" >
		        <div class="portlet-column col-sm-6">
		            <h4>Current Position</h4>
		            <div class="portlet-layout row" style="height: 40px;" >
		                <div class="portlet-comelumn portlet-column-first col-sm-5 sectionLabel "> Associate Title</div>
				    <div class="portlet-column portlet-column-last col-sm-7" id="associateTitle"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentJobCode())){%><%=wfmsCOS.getCurrentJobCode()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row" style="height: 40px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Position Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="positionId"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getPositionNumber())){%><%=wfmsCOS.getPositionNumber().replaceAll("-WFM","")%><%} %></div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DIVISION" ><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentDivision())){%><%=wfmsCOS.getCurrentDivision()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division Manager</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DIVISION_MANAGER"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentDivisionManager())){%><%=wfmsCOS.getCurrentDivisionManager()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Name</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DEPT_NAME"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentDepartmentName())){%><%=wfmsCOS.getCurrentDepartmentName()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Number</div>

		                <div class="portlet-column portlet-column-last col-sm-7" id="DEPT_NUMBER"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentDepartmentNumber())){%><%=wfmsCOS.getCurrentDepartmentNumber()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Manager</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DEPT_MANAGER"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentDepartmentManager())){%><%=wfmsCOS.getCurrentDepartmentManager()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row" style="height: 40px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Team Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="teamNumber"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentTeamNumber())){%><%=wfmsCOS.getCurrentTeamNumber()%><%} %></div>
		            </div>
		            <div class="portlet-layout row" style="height: 40px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Shift Code</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="shiftcode"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentShiftCode())){%><%=wfmsCOS.getCurrentShiftCode()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row" style="height: 40px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Employee Category</div>
		                	<div class="portlet-column portlet-column-last col-sm-7" id="employeecategory"><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber()) && !(wfmsCOS.getPositionNumber().equalsIgnoreCase("None"))){ 
							WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getPositionNumber().replaceAll("-WFM",""));%>
							 <%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}%> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Leadership Assignment</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="leader-assignment"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentLeadershipAssignment())){%><%=wfmsCOS.getCurrentLeadershipAssignment()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Associate Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="mgrassociateno"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentManagerAssocNumber())){%><%=wfmsCOS.getCurrentManagerAssocNumber()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row" style="margin-top:15px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Name</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="mgrName"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentManagerName())){%><%=wfmsCOS.getCurrentManagerName()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Title</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="mgrTitle"><% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentManagerTitle())){%><%=wfmsCOS.getCurrentManagerTitle()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row" style="margin-top:15px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Routing Path</div>
		                <div class="portlet-column portlet-column-last col-sm-7"> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Next Approver</div>
		                <div class="portlet-column portlet-column-last col-sm-7"> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Role of approver</div>
		                <div class="portlet-column portlet-column-last col-sm-7"> </div>
		            </div>
		        </div>
		        <div class="portlet-column col-sm-6">
		            <h4>New Position</h4>
		            <div class="portlet-layout row">
		            <div class="portlet-column portlet-column-first  col-sm-5 sectionLabel">Associate Title</div><div class="col-sm-7"><div class="guide_alert" id="msgForTitle" style="display:none;margin-left:5px;">Please Fill Associate Title</div></div>
		            <div class="col-sm-5  "></div>
                     <div class="portlet-column portlet-column-last col-sm-7" id="newAssociateTitle_mainDiv" >
                    <%if(wfmsCOS==null) { %>
		              
                                   <aui:select  name="newJobCode" id="newAssociateTitle"
										label="" showRequiredLabel="false" cssClass="chosenAssociateTitle" disabled="true" onChange="loadAssociateTitleforNewPos();">
									<aui:option value="">Select Associate Title</aui:option>									
									<% Map<String, String> shiftMap = new HashMap<String, String>();
										shiftMap = ConfigUtility.getInputValuesForMap("associate-titles-and-ladder");
										Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
										for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {	%>
										<option value="<%=entry.getKey()%>"><%=entry.getKey() %></option>
									<% } %>
								</aui:select>	 
		            <% } else { %>
		           <aui:select name="newJobCode" id="newAssociateTitle" cssClass="chosenAssociateTitle"  disabled="true"
							label="" showRequiredLabel="false"  maxlength="75"  onChange="loadAssociateTitleforNewPosUpdate();">
						 <aui:option value="">Select Associate Title</aui:option>
						<%	    String ladder=null;
						        if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
						        	if(wfmsCOS.getNewPositionNumber()!=null && !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){
							        	WFMS_Position newPostionInfo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM",""));
										ladder=newPostionInfo.getLadder();
						        	}
						        }
								Map<String, String> shiftMap = new HashMap<String, String>();
								shiftMap = ConfigUtility.getInputValuesForMap("associate-titles-and-ladder");
								Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
								for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {
									if(ladder!=null){
										 if(ladder.equalsIgnoreCase("Either") || ladder.equalsIgnoreCase("Technical") || ladder.equalsIgnoreCase("Business")){
											 if(ladder.equalsIgnoreCase("Technical") || ladder.equalsIgnoreCase("Business")){
												 if(!(entry.getValue().equalsIgnoreCase(ladder) || entry.getValue().equalsIgnoreCase("Either")))
													 continue;
											 }
											 else if(ladder.equalsIgnoreCase("Either")){
												 if(!(entry.getValue().equalsIgnoreCase("Business") || entry.getValue().equalsIgnoreCase("Technical") || entry.getValue().equalsIgnoreCase("Either")))
												      continue;
											 }
										 }
										 else if(!entry.getValue().equalsIgnoreCase(ladder))
											 continue;
									} %>
						<aui:option selected="<%=wfmsCOS.getNewJobCode().equals(entry.getKey()) %>" value="<%=entry.getKey() %>"><%=entry.getKey() %></aui:option>
						<% } %>
					</aui:select>
		              <aui:input type="hidden"  name="hiddenAssociateTitle" value="<%=wfmsCOS.getNewJobCode() %>"></aui:input>
		            <% } %>
		            <div class="form-validator-stack help-inline newAssociateTitle_ValidationMessage" id="newJobCode_message" style="display:none;">
							     Missing required value for the field "Associate Title"</div>
			           	</div>
		              </div>
					 <div class="portlet-layout row">
					 <div class="  portlet-column portlet-column-first col-sm-5 sectionLabel">Position Number </div>
					 <div class="col-sm-7"><div id="NewPOS" name="NewPOS">
						     <% if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
						    	 if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 1){
						     %>
						     <%=wfmsCOS.getNewPositionNumber()%>
						     <aui:input id="pId" type="hidden" name="positionNumber" value="<%=wfmsCOS.getNewPositionNumber()%>"></aui:input>
						     <%}else{ %>    
						     <%=wfmsCOS.getPositionNumber()%>
						     <aui:input id="pId" type="hidden" name="positionNumber" value="<%=wfmsCOS.getPositionNumber()%>"></aui:input>
						     <%}}else{%>
	                         <%if(wfmsCOS==null) { %> 
							 <aui:select name="positionNumber" cssClass="chosen removeNone" id="pId"   onChange="loadPosId();showPopup();" label="" >
                  			<aui:option value="">Select Position Number</aui:option>
                            <aui:option value="None">None</aui:option>								
							</aui:select>
							<% } else {
								String ladderType = "";
								Map<String, String> shiftMap = new HashMap<String, String>();
								shiftMap = ConfigUtility.getInputValuesForMap("associate-titles-and-ladder");
								Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
								for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {	
									if(wfmsCOS.getNewJobCode().equalsIgnoreCase(entry.getKey())){
									  ladderType = entry.getValue();
										break;
									}
								}
							%>
							<aui:select name="positionNumber" id="pId" disabled="true" cssClass="chosenPId removeNone" onChange="loadPosIdForUpdate();" label="">
							  <aui:option value="">Select Position Number</aui:option>
								<% 	DynamicQuery queryForPosition =WFMS_PositionLocalServiceUtil.dynamicQuery();
                                //queryForPosition.add(PropertyFactoryUtil.forName("ladder").eq(ladderType));
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
                             
                                List<WFMS_Position> positionNumbers= new ArrayList<WFMS_Position>();
                                List<String> positionNoList= new ArrayList<String>();
                                positionNumbers = WFMS_PositionLocalServiceUtil.dynamicQuery(queryForPosition);
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
                           				
                           				if (cosTotalList == cosList || positionNumber.getPId().equalsIgnoreCase(wfmsCOS.getNewPositionNumber())) {
                           					positionNoList.add(positionNumber.getPId());
                           				}
                           			}
                                }
                                Set<String> hs = new HashSet<String>();
								hs.addAll(positionNoList);
								positionNoList.clear();
								positionNoList.addAll(hs); %>
							<% out.print(positionNoList); for(String posid:positionNoList){
								if(!posid.contains("-WFM")){
								posID=posid;%>
								<aui:option selected="<%=wfmsCOS.getNewPositionNumber().equalsIgnoreCase(posID) %>" value="<%=posID%>"><%=posID%></aui:option>
							<% } } if(wfmsCOS.getCurrentJobCode().equalsIgnoreCase("PA") ||  wfmsCOS.getCurrentJobCode().equalsIgnoreCase("TC")){ %>
							<aui:option selected='<%=wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") %>' value="None">None</aui:option><% } %>
							 <%if(wfmsCOS.getCurrentPositionText() == 1){%> <aui:option selected="true" value="<%=wfmsCOS.getNewPositionNumber()%>">Current Position - <%=wfmsCOS.getNewPositionNumber()%> </aui:option><%}%>
						</aui:select>
					<% } }  %>
										<script>
										if(document.getElementById("associateTitle").innerHTML.trim()!="PA" || document.getElementById("associateTitle").innerHTML.trim()!="TC"){
											$(".removeNone option[value='None']").each(function() {
	                                                 $(this).remove();
	                                               });
											
									} else{  $('#<portlet:namespace/>pId')
								         .append($("<option></option>")
								    	         .attr("value","None")
								    	         .text("None"));
												 }
										$( document ).ready(function() {
										
										if(document.getElementById("associateTitle").innerHTML.trim()=="PA" || document.getElementById("associateTitle").innerHTML.trim()=="TC"){
							                $('#<portlet:namespace/>pId')
							   	         .append($("<option selected="true"></option>")
							   	         .attr("value","None")
							   	         .text("None"));
							   	     }});

							        </script>
							<aui:input name="newPositionNumber" value='' id="newpositionId" type="hidden" /> 						
							<div class="form-validator-stack help-inline positionnumber_ValidationMessage" id="positionnumber" style="display:none;">
							     Missing required value for the field "Position Number"</div>
						</div> <div class="guide_alert" id="msgForPosition" style="display:none;margin-left:5px;width:210px;">Please Fill Position Number</div></div>
						<div class="">
							<span class="sectionLabel"></span>
						</div>
						<div class="portlet-column portlet-column-last col-sm-7" >
						<style>
						.chosen-container{
						width: 230px !important;
						}
						</style>
						</div>
								</div>       
					<% Map<String , String> hondamap= new HashMap<String,String>(); %>
		          <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division</div>
						<div class="portlet-column portlet-column-last col-sm-7">
		                <%if(wfmsCOS==null || (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2))) {%>
		                <%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last" id="Division"><%=wfmsCOS.getCurrentDivision()%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last" id="Division"> </div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DivisionFromM"> </div>
		                <%}} else {
								if(Validator.isNotNull(wfmsCOS.getSameDept())){
								hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getSameDept());
								}
								if(Validator.isNotNull(wfmsCOS.getNewDepartmentNumber())){
									hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getNewDepartmentNumber());
									}
		                	%>
		                <div class="portlet-column portlet-column-last" id="Division">  <% if(hondamap.get("divName")!=null) out.print(hondamap.get("divName"));%></div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DivisionFromM">  <%if(hondamap.get("divName")!=null) out.print(hondamap.get("divName")); %></div>
		                <%} %>		                 
		                </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division Manager</div>
						<div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS==null || (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2))) {%>
						<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last" id="divMgrName"><%=wfmsCOS.getCurrentDivisionManager()%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last" id="divMgrName">  </div>
		                 <div class="portlet-column portlet-column-last col-sm-7" id="divMgrNameFromM"></div>
		                 <%}} else { %>
		                <div class="portlet-column portlet-column-last" id="divMgrName">  <% if(hondamap.get("divMgrName")!=null) out.print(hondamap.get("divMgrName")); %></div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="divMgrNameFromM">  <% if(hondamap.get("divMgrName")!=null) out.print(hondamap.get("divMgrName")); %></div>
		                <%} %>
		               </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Name</div>
						<div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS==null || (wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2)) {%>
						<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last" id="deptNAME"><%=wfmsCOS.getCurrentDepartmentName()%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last" id="deptNAME">  </div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptNameFromM"></div>
		                <%}} else { %>
		                <div class="portlet-column portlet-column-last" id="deptNAME"><% if(hondamap.get("deptName")!=null) out.print(hondamap.get("deptName"));%> </div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptNameFromM"><% if(hondamap.get("deptName")!=null) out.print(hondamap.get("deptName"));%> </div>
		                <%} %>
		               </div>
		            </div>
<div style="position: relative; top: -34px;"> <img  src="<%= request.getContextPath()%>/images/ajax-loader.jpg"  id="img" alt="Please Wait A Moment"  style="display:none"/ ></div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Number</div>
		                 <div class="col-sm-7">
                            <%if(wfmsCOS==null) { %>
                              <div class="portlet-column portlet-column-last" id="newDeptNUmber1" name="newDeptNUmber1">
		     					    </div>
			                <div class="portlet-column portlet-column-last" id="deptNumber">
		     					<div class="portlet-layout row newDeptNUmber_mindiv">
										<aui:select name="sameDept" id="divdeptRest" label="" cssClass="chosenDivdeptRest" showRequiredLabel="false" disabled="true"   onChange="showPopup();updateValuesForSelectedDepartment();">
										<aui:option value="">Select Department Number</aui:option>
					<% Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
							 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){  
								 if(Validator.isNotNull(entry.getValue())){ %>
				                  <aui:option value="<%=entry.getKey() %>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
									<%}} %>
										</aui:select>
							<div class="form-validator-stack help-inline newDeptNUmber_ValidationMessage" style="display:none;">
							     Missing required value for the field "Department Number"</div>										 
								</div>
			    		    </div>
			    		     <% } else {  %> 
		                        <div  class="portlet-column portlet-column-last" id="deptNumberFromPosition">
		                        <%if(wfmsCOS.getSystemGenerated() == 2) {%>
		                            <%=wfmsCOS.getCurrentDepartmentNumber()%>
		                        <% }else{ %>
		                         <%=wfmsCOS.getNewDepartmentNumber() %>
		                        <% } %>
		                        </div>
				                <div class="portlet-column portlet-column-last newDeptNUmber_mindiv" id="deptNumber">
				                 <aui:select name="sameDept" cssClass="chosenDivdeptRest" id="divdeptRest" label="" showRequiredLabel="false" disabled="true"  onChange="updateValuesForSelectedDepartmentManage();" >
		                                 <aui:option value="">Select Department Number</aui:option>
		                                 <% Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
									 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){
										 if(Validator.isNotNull(entry.getValue())){	 
									// String keyvalue = entry.getKey() +"-" +entry.getValue(); %>
						                  <aui:option selected="<%=wfmsCOS.getSameDept().equals(entry.getKey()) %>" value="<%=entry.getKey()%>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
											<%}} %>		
								</aui:select>
								 	<div class="form-validator-stack help-inline newDeptNUmber_ValidationMessage" style="display:none;">
									     Missing required value for the field "Department Number"</div>	
				                </div>
			    		    <% } %>
			    		     </div>
		            <div id="msgForsameDept" style="display:none;">
                                <div class="col-sm-5">&nbsp;</div>
					 <div class="guide_alert col-sm-7" style=";margin-left:3px;width:230px;">Please Fill Department Number</div>
					 </div>
		          	    <div style="display:none;">
							 <aui:input type="text" class="field error-field" id="hidden_field" name="hidden_field" required="true" disabled="${not ADD_RS_2}"></aui:input> 
							</div> 
		               </div>
					 <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Manager</div>
						<div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS==null || (wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2)) {%>
						<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2){ %>
						<div class="portlet-column portlet-column-last col-sm-7" id="deptManager"> <%=wfmsCOS.getCurrentDepartmentManager() %> </div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptManager">  </div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptManagerFromM"></div>
		                <%}}else {%>
		                <div class="portlet-column portlet-column-last" id="deptMgrName"><% if(hondamap.get("deptMgrName")!=null) out.print(hondamap.get("deptMgrName")); %></div>
		                 <div class="portlet-column portlet-column-last col-sm-7" id="deptManagerFromM"><% if(hondamap.get("deptMgrName")!=null) out.print(hondamap.get("deptMgrName"));  %></div>
		                <%} %>
		               </div>
		            </div>
       <div class="portlet-layout row">
                <div class="col-sm-5"></div>
                <div class="col-sm-7">
                	<div class="guide_alert" id="msgForTeamNumber" style="display:none;margin-left:5px;">Please fill Team Number</div>
                </div>
                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Team Number</div>
                <div class="portlet-column portlet-column-last col-sm-7" id="teamNumber_maindiv">
                <%if(wfmsCOS==null || (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2))) {%>
                <aui:select name="teamNumber" id="teamNumber" onChange="teamNumberValidation();" cssClass="chosenTitle" label=""  disabled="true">
                <aui:option value="" selected="selected">Select Team Number</aui:option>
              <% 	List<String> reportToTeamNumber = HMAAssociateInfoService.getTeamNumberCos();
              for ( String teamNumber : reportToTeamNumber) {  
            	  if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
            		  if(Validator.isNotNull(wfmsCOS.getTeamNumber())){	  
              %>
             <aui:option selected="<%=wfmsCOS.getTeamNumber().equals(teamNumber) %>" value="<%= teamNumber %>"><%= teamNumber %></aui:option>
             <% }else{%>
            <aui:option  value="<%= teamNumber %>"><%= teamNumber %></aui:option>	 
             <%}}else{%>
            <aui:option  value="<%= teamNumber %>"><%= teamNumber %></aui:option>	 
             <%}} %>
             </aui:select> 
				<% } else { %>
			                <aui:select name="teamNumber" id="teamNumber" cssClass="chosenTitle" label="" onChange="teamNumberValidation();" disabled="true" >
			                     <aui:option value="">Select Team Number</aui:option>
								<% 	List<String> reportToteamNUmber = HMAAssociateInfoService.getTeamNumberCos();
								    reportToteamNUmber.removeAll(Arrays.asList(null,""));
									for (String teamNumber: reportToteamNUmber) {
								%>
								  <aui:option selected="<%=wfmsCOS.getTeamNumber().equals(teamNumber) %>" value="<%= teamNumber %>"><%= teamNumber %></aui:option>
							<% } %>
							</aui:select> 
				<%} %>
                       <div class="form-validator-stack help-inline teamNumber_ValidationMessage" id="teamNumber_message" style="display:none;">
							     Missing required value for the field "Team Number"</div>
                </div>
            </div>
            <div class="portlet-layout row">
             <div class="col-sm-5"></div>
             <div class="col-sm-7">
                <div class="guide_alert" id="msgForShiftCode" style="display:none;margin-left:5px;">Please fill Shift Code</div>
            </div>
             <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Shift Code</div>
                  <div class="portlet-column portlet-column-last col-sm-7" id="shiftCode_maindiv">
                <%if(wfmsCOS==null || (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2))) {%>
                <%//if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
                <%//}else{ %>
                 <aui:select name="shiftCode" id="shiftCode" onChange="shiftCodeValidation();" cssClass="chosenShiftcode" label=""  disabled="true">
                  <aui:option value="" selected="selected ">Select Shift Code</aui:option>
                  <% 	List<String> reportToShiftCOde = HMAAssociateInfoService.getShiftCodeCos();
                  for (String shiftNumber: reportToShiftCOde) {  
                	  if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
                		  if(Validator.isNotNull(wfmsCOS.getShiftCode())){
                  %>
                 <aui:option selected="<%=wfmsCOS.getShiftCode().equals(shiftNumber) %>" value="<%= shiftNumber %>"><%= shiftNumber %></aui:option>
                     <% }else{%>
                  <aui:option value="<%= shiftNumber %>"><%= shiftNumber %></aui:option>   
                     <%}}else{%>
                  <aui:option value="<%= shiftNumber %>"><%= shiftNumber %></aui:option>   
                     <%}} %>
                 </aui:select>
                <% } else { %>
			                 <aui:select name="shiftCode" id="shiftCode" cssClass="chosenShiftcode" label="" onChange="shiftCodeValidation();" disabled="true">
			                 		<%-- <aui:option value="<%=wfmsCOS.getShiftCode() %>"><%=wfmsCOS.getShiftCode() %></aui:option> --%>
			                 		  <aui:option value="">Select Shift Code</aui:option>
									<% 	List<String> reportToshiftCodeManege = HMAAssociateInfoService.getShiftCodeCos();
									for (String shiftNumber : reportToshiftCodeManege) {  
									%>
								  <aui:option selected="<%=wfmsCOS.getShiftCode().equals(shiftNumber) %>" value="<%= shiftNumber %>"><%= shiftNumber %></aui:option>
									<% } %>
							</aui:select> 
		                <%} %>   
                <div class="form-validator-stack help-inline shiftCode_ValidationMessage" id="shiftCode_message" style="display:none;">
							     Missing required value for the field "Shift Code"</div>
                </div> 
            </div>
           			<div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Employee Category</div>
		                	<div class="portlet-column portlet-column-last col-sm-7""  id="employeecategoryNew"><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getNewPositionNumber()) &&  !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){ 
								WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM","")); 
								if(Validator.isNotNull(wfmpo.getEmpCategory())){	%>
		 						<%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}}%> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Leadership Assignment</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="leadershipassignment">
                          <% if(wfmsCOS==null || (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2))){
	                              if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2)
	                                  if(wfmsCOS.getLeadershipAssignment()!=null) out.print(wfmsCOS.getLeadershipAssignment());
                              }
                              else if(wfmsCOS.getLeadershipAssignment()!=null) 
                            	  out.println(wfmsCOS.getSameLeadership());
                              else if(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None")) 
                            	  out.println("None");
                              else    out.println("None");
		                  %>
		                 </div>
		                <div class="portlet-column portlet-column-last col-sm-7">
		                <% if(wfmsCOS==null) {%>
		                <div id="UpdatePO" name="UpdatePO">
							<div id="MgrAssNo" name="MgrAssNo">
							<div class="portlet-column portlet-column-last col-sm-7">
							  <div id="msgForAssociateNumber" class="guide_alert" style=" margin-left:17px; width: 205px;"></div>
								<aui:select name="leadershipAssignment" id="LeaderShip" class="field-select"  label="" disabled="true" showRequiredLabel="false" maxlength="75" onChange="showPopup();validation();">
									<aui:option value="" selected="selected">Select Leadership</aui:option>
									<% 	List<String> reportToLeaderShip = HMAAssociateInfoService.getLeaderShipCos();
									for (String leadership: reportToLeaderShip) { %>
								  <aui:option value="<%= leadership %>"><%= leadership %></aui:option>
									<% 	 }%>
								</aui:select>
								<div class="form-validator-stack help-inline" id="leadership1" style="color: #b50303; display:none;">
							      <div role="alert" class="required" >Missing required value for the field "Manager Associate Number"</div>
								</div>
							</div>
							</div>
						</div>
		                <%}else{ %>
		                <div id="UpdatePO" name="UpdatePO">
		   				
							<div id="MgrAssNo" name="MgrAssNo" <%if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){ %>style="display: none;""<%} %>>
							<div class="portlet-column portlet-column-last col-sm-7">
                                                            <div id="msgForAssociateNumber" class="guide_alert" style="display:none;margin-left:-12px; width:205px; margin-bottom:7px;">Please fill Manage Associate Number</div>
								<aui:select name="leadershipAssignment" id="LeaderShip" class="field-select"  label="" showRequiredLabel="false" disabed="true" maxlength="75" onChange="leaderShipValidation();">
									<aui:option value="">Select Leadership</aui:option> 
									<% 	List<String> reportToleaderShip = HMAAssociateInfoService.getLeaderShipCos();
									for (String leadership: reportToleaderShip) {  %>
								  <aui:option selected="<%=wfmsCOS.getLeadershipAssignment().equals(leadership) %>" value="<%= leadership %>"><%= leadership %></aui:option>
									<% } %>
								</aui:select>
								<div class="form-validator-stack help-inline" id="leadership1" style="color: #b50303; width: 250px; display:none;">
							     <div role="alert" class="required" >Missing required value for the field &quot;Manager Associate Number &quot;</div>
								</div>
							</div>
							</div>
						</div>
		                <% } %>
		                <div id="leadershipassignmentnone"></div>
		                </div>		                
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Associate Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7">
		                <div id="msgFormanagerAssociateNumber" style="display:none;">
							 <div class="guide_alert col-sm-6" style=";margin-left:3px;width:275px;">Please Select Manager Associate Number</div>
				        </div>
                         <% if(wfmsCOS!=null && wfmsCOS.getSystemGenerated() == 2){ %>           
		                 <div id="managerAssociateNumber">
		                       <%=wfmsCOS.getCurrentManagerAssocNumber() %>
		                 </div>
		                 <% }else{ %>
		                  <div id="managerAssociateNumber" <% if(wfmsCOS !=null && (wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %>  style="display:none;" <% } %>>
		                       <% if(wfmsCOS!=null) out.print(wfmsCOS.getMgrAssociateNumber()); %>
		                 </div>
		                 <% } %>
                         <div id="managerAssociatedropdown" <% if(wfmsCOS ==null || !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %> style="display:none;" <% } %>>
						    <aui:select name="mgrAssociateNumber" id="mgrassociateNo" disabled="true" label="" cssClass="chosenAssociateNumber field-select" onChange="loadMgrAssoNo();" >
							<aui:option value="">Select Manager Associate Number</aui:option>
							<%  Map<String,String> MgrAssNumberMap = HMAAssociateInfoService.getMsrAssociateNoToNewCOS();
                                                                String associatemanage="";
                                                                if(wfmsCOS!=null)
                                                                   associatemanage=wfmsCOS.getMgrAssociateNumber();
							     for(Map.Entry<String, String> entry : MgrAssNumberMap.entrySet()){ %>
				                                <aui:option selected="<%=associatemanage.equals(entry.getKey()) %>" value="<%=entry.getKey() %>"><%=entry.getKey()%>--<%=entry.getValue()%></aui:option>
							    <% } %>
						</aui:select> 
                                      <div class="form-validator-stack help-inline manageAssociate_ValidationMessage" style="display:none;">
							     Missing required value for the field "Manager Associate Number"</div>          
                         </div>
		                </div>
		            </div>
		            <div class="portlet-layout row" style="margin-top:15px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Name</div>
		                    <div class="portlet-column portlet-column-last col-sm-7" id="ManagerAssociateName"><% if(wfmsCOS!=null){ if(wfmsCOS.getSystemGenerated() == 2) out.print(wfmsCOS.getCurrentManagerName()); else out.print(wfmsCOS.getNewManagerName()); } %></div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Title</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="ManagerAssociateTitle"> <% if(wfmsCOS!=null){ if(wfmsCOS.getSystemGenerated() == 2)  out.print(wfmsCOS.getCurrentManagerTitle()); else out.print(wfmsCOS.getNewManagerTitle()); } %></div>
		            </div>
		            <div class="portlet-layout row" style="margin-top:15px;">
		         		<div class="col-sm-5"></div>
		         		<div class="col-sm-7">
			            	<div class="guide_alert" id="msgForManpower" style="display:none;margin-left:5px;height:25px;width:215px;">Please fill Manpower Category</div>
			            </div>
		            	<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manpower Category</div>
			            <div class="portlet-column portlet-column-last col-sm-7" id="manpowerCategiry_maindiv">
			                <%if(wfmsCOS==null){ %>
								<aui:select name="manpowerCategiry"  id="manpower-catogiry" disabled="true" class="field-select" label="">
									<aui:option value="">Select Manpower Category</aui:option>
									<% values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
										for(String value:values){	%>
										<aui:option value="<%=value %>"><%=value %></aui:option>
									<% } %>
								</aui:select>
								<%}else{ %>
			                <aui:select name="manpowerCategiry" id="manpower-catogiry" onChange="manpowerValidation();" class="field-select" label="" disabled="true" >
								<aui:option value="">Select Manpower Category</aui:option>
									<%
										values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
										for(String value:values){	
									%>
										<aui:option selected="<%=wfmsCOS.getManpowerCategiry().equals(value) %>" value="<%=value %>"><%=value %></aui:option>
									<% } %>
								</aui:select>
			                <%} %>
								<div class="form-validator-stack help-inline manpowerCategiry_ValidationMessage" id="manpowerCategiry_message" style="display:none;">
								     Missing required value for the field "Manpower Category"</div>
			             </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manpower Rep</div>
		                
		                                <%if(wfmsCOS !=null && hondamap.get("mpwrrep_name")!=null ){ %>
		                                    <div class="portlet-column portlet-column-last col-sm-7" id="ManPowerRep" > <% if(hondamap.get("mpwrrep_name")!=null) out.print(hondamap.get("mpwrrep_name")); %></div>
		                               <%}else if(wfmsCOS !=null ){ %>
		                                     <div class="portlet-column portlet-column-last col-sm-7" id="ManPowerRep"> <% if(wfmsCOS.getCurrentManpowerRep()!=null) out.print(wfmsCOS.getCurrentManpowerRep()); %></div>
		                                     <% }else{ %>
		                                     <div class="portlet-column portlet-column-last col-sm-7" id="ManPowerRep"></div>
		                                     <% } %>
		            </div>
		            <div class="portlet-layout row" style="margin-top:15px;">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Notification To</div>
		                <div class="portlet-column portlet-column-last col-sm-7"></div>
		            </div>
		        </div>
		    </div>
		    <div class="portlet-layout row" style="margin-top:15px;">
                <div class="portlet-column portlet-column-first col-sm-3 sectionLabel ">Comments</div>
                <div class="portlet-column portlet-column-last col-sm-9">
                <%if(wfmsCOS==null) {%>
                   <aui:input type="textarea" name="comments" class="field" cols="55"
						placeholder="comments" rows="10" label="" style="width: 93%;" maxLength="500"></aui:input>
				<%}else{ %>
				<aui:input type="textarea" name="comments" class="field" cols="55" value="<%=wfmsCOS.getComments() %>"
						placeholder="comments" rows="10" label="" style="width: 93%;" maxLength="500" id="enableComments"></aui:input>
				<!-- Edit and Save Buttons for Comments -->
						<% if((WMSUserAccessUtil.checkPermission(renderRequest,PortletPropsPermission.COS_EDIT_COMMENTS))){ %>
							<button id="editCommentsButton" style="width: auto;" onclick='editComment("comments")'><i class="icon-edit"></i>&nbsp;Edit</button>
							<button id="saveCommentsButton" style="width: auto;" onclick='saveComments("comments")' disabled ><i class="icon-check"></i>&nbsp;Save</button>
						<%} %>
						<aui:input name="cmpComment" type="hidden" id="cmpComment" label=""></aui:input>
				<%} %>
                </div>
            </div>
		</div>
			<div class="portlet-layout">
                <div class="logs_main" style="font-style: oblique; font-size:12px"><b>Log:</b></div>
				<%if(wfmsCOS!=null) {%>	
                <div class="users col-sm-12">
                	<div class="logs_comments" style="line-height: 16px;">
			                <%List<WFMS_COS_Audit> wfms_auditlist=WFMS_COS_AuditLocalServiceUtil.findByCosIdForAudit(wfmsCOS.getCosId()); %>
			                <%for(WFMS_COS_Audit wfms_audit :wfms_auditlist){%>
			               <div class="logs">
				               <div class="user_comments" id="user_comments" style="line-height: 19px;margin-top: -16px;">
				               		<br> <%=wfms_audit.getChange() %> By : <%=wfms_audit.getCreatedBy()%> - <%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate()) %>
				               			<% if(wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_DISAPPROVE) || wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_CANCEL)){%>
											<div class="comments" id="comments">
											 	&nbsp;<div class="log_comments" style="line-height: 19px;margin:-9px 0px -4px 0px;text-indent: 3px;"><b class="comment_title">Comments :</b><%=wfms_audit.getComments() %></div>
											</div>
										<%}%>
				               </div>
			               </div>
			               <%  }  %>
			        </div>
	           </div>
	           <%} %>
        	</div>
        <div class="scroll_back_to_top">
			<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
		</div>
    <aui:input name="IsSameJobCode" id="IsSameJobCode" type="hidden"></aui:input>
    <aui:input name="IsSameLeadership" id="IsSameLeadership" type="hidden"></aui:input>
    <aui:input name="IsSameDept" id="IsSameDept" type="hidden"></aui:input>
    <aui:input name="IsSameMgr" id="IsSameMgr" type="hidden"></aui:input>
<aui:input name="currentPositionNumber" id="currentPositionNumber" type="hidden"></aui:input>
<aui:input name="currentJobCode" id="currentJobCode" type="hidden"></aui:input>
<aui:input name="currentDivision" id="currentDivision" type="hidden"></aui:input>
<aui:input name="currentDivisionManager" id="currentDivisionManager" type="hidden"></aui:input>
<aui:input name="currentDepartmentName" id="currentDepartmentName" type="hidden"></aui:input>
<aui:input name="currentDepartmentNumber" id="currentDepartmentNumber" type="hidden"></aui:input>
<aui:input name="currentManagerName" id="currentManagerName" type="hidden"></aui:input>
<aui:input name="currentDepartmentManager" id="currentDepartmentManager" type="hidden"></aui:input>
<aui:input name="currentManagerTitle" id="currentManagerTitle" type="hidden"></aui:input>
<aui:input name="currentTeamNumber" id="currentTeamNumber" type="hidden"></aui:input>
<aui:input name="currentShiftCode" id="currentShiftCode" type="hidden"></aui:input>
<aui:input name="currentLeadershipAssignment" id="currentLeadershipAssignment" type="hidden"></aui:input>
<aui:input name="currentManpowerRep" id="currentManpowerRep" type="hidden"></aui:input>
<aui:input name="currentManagerAssocNumber" id="currentManagerAssocNumber" type="hidden"></aui:input>
<% if(wfmsCOS!=null) {
	String NewpositionLeadership = "";
	String NewpositionDepartmentname = "";
	String NewpositiondeptManager = "";
	if(Validator.isNotNull(wfmsCOS.getSameLeadership())){
		NewpositionLeadership = wfmsCOS.getSameLeadership();
    }
	if(Validator.isNotNull(wfmsCOS.getNewDepartmentNumber())){
		NewpositionDepartmentname = wfmsCOS.getNewDepartmentNumber();
    }
	if(Validator.isNotNull(wfmsCOS.getNewDepartmentManager())){
		NewpositiondeptManager = wfmsCOS.getNewDepartmentManager();
    }
%>
<aui:input name="NewpositionLeadership" id="NewpositionLeadership" type="hidden" value="<%=NewpositionLeadership %>"></aui:input>
<aui:input name="NewpositionDepartmentname" id="NewpositionDepartmentname" type="hidden" value="<%=NewpositionDepartmentname %>"></aui:input>
<aui:input name="NewpositiondeptManager" id="NewpositiondeptManager" type="hidden" value="<%=NewpositiondeptManager%>"></aui:input>
<%} %>
	</div>
</div>
</aui:form>
<!-- Start Workflow for Cancel Change of Status  -->
<% if(wfmsCOS!=null) {%>
    <!-- <div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false" style="display:none;"> -->
     <div class="modal fade" id="myModal" role="dialog" style="display:none;">
    <div class="modal-dialog">
    <aui:form method="post" action="<%=cancelCOSURL.toString() %>"
	name="cancelCOS" id="cancelCOS">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Are you sure you want to cancel this Change of Status?</h4>
        </div>
        <div class="modal-body">
        <aui:input type="hidden" name="cosid"  value="<%=wfmsCOS.getCosId() %>"/>
          <aui:input type="textarea" name="comments" label=""
			value="" class="field" cols="5"
			placeholder="Comments" rows="3" required="true" style="width: 500px; height: 83px;"/>
        </div>
        <div class="modal-footer">
        <div class="col-sm-2">
          <aui:button type="submit" class="btn btn-default" value="Save" onclick="callCancelAction();"></aui:button>
        </div>
        <div class="col-sm-2">
        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </div>
      </div>
 	</aui:form>
    </div>
  </div>
<%}%>
<!-- End Workflow -->
<% if(deptMap.isEmpty()) {
		String currentURL = PortalUtil.getCurrentURL(request);
		if(currentURL.contains("?")){
			currentURL = currentURL.split("\\?")[0];
		} %>
		<br>
	<aui:script>
  	$( document ).ready(function() {
		AUI().use('aui-base',
				'aui-io-plugin-deprecated',
				'liferay-util-window',
			function(A) {
				var popUpWindow = Liferay.Util.Window.getWindow({
					dialog : {
						centered : true,
						constrain2view : true,
						align : {
							node : null,
							points : [ 'tc', 'tc' ]
						},
						modal : true,
						cache : false,
						width : 550,
						height : 150,
						destroyOnClose : true,
					}
				}).plug(A.Plugin.IO, {
					autoLoad : false
				}).render();

				popUpWindow.show();
				popUpWindow.titleNode.html("");
				popUpWindow.io.set('uri',"<%=generateInternetConnection%>");
				popUpWindow.io.start();
 	});});
	</aui:script>
	<br>
	<%} %>
<script type="text/javascript">
function callCancelAction() {
    var url = '<%=cancelCOSURL.toString()%>';
    document.forms["cancelCOS"].action=url;
    document.forms["cancelCOS"].submit();
}
if ($('#back-to-top').length) {
    var scrollTrigger = 100, // px
        backToTop = function () {
            var scrollTop = $(window).scrollTop();
            if (scrollTop > scrollTrigger) {
                $('#back-to-top').addClass('show');
            } else {
                $('#back-to-top').removeClass('show');
            }
        };
    backToTop();
    $(window).on('scroll', function () {
        backToTop();
    });
    $('#back-to-top').on('click', function (e) {
        e.preventDefault();
        $('html,body').animate({
            scrollTop: 0
        }, 700);
    });
}
function editComment(type){
	if(type == "comments"){
		$("#<portlet:namespace/>enableComments").removeAttr("disabled");
		$("#saveCommentsButton").removeAttr("disabled");
		$("#editCommentsButton").attr('disabled','disabled');
	}else{
		$("#<portlet:namespace/>startDate").removeAttr("disabled");
		$("#saveEffectiveDate").removeAttr("disabled");
		$("#editEffectiveDate").attr('disabled','disabled');
	}
}
function saveComments(type){
   $("#<portlet:namespace/>cmpComment").val(type);
   $("#<portlet:namespace/>addWFMSCOS").attr('action',"<%= disApproveCommentsCOSURL.toString()%>");
   $("#<portlet:namespace/>addWFMSCOS").submit();
}
</script>
<aui:script>
YUI({ lang: 'en' }).use(
		   'aui-datepicker',
		   function(Y) {
			   var today=new Date();
		     var datepicker = new Y.DatePicker(
		       { trigger: '#<portlet:namespace />startDate',
		         mask: '%m/%d/%Y',
		         calendar: {
		        	   minimumDate: new Date(today.getTime() - (1000 * 60 * 60 * 24 * 365))
		        	  // maximumDate:  new Date(today.getTime() - (1000 * 60 * 60 * 1)),
		        	},
		        	on: {
		                selectionChange: function(event) {
		                	           $(".startDate_ValidationMessage").hide();
										$("#msgForEffectiveDate").hide();
							            $('#startDate_maindiv').removeClass('control-group error');
		              }
		            },
		         popover: {
		           toolbars: {
		             header: [[
		               {
		                 icon:'icon-trash',
		                 label: 'Clear',
		                 on: {
		                   click: function() {
		                     datepicker.clearSelection();
		                     
		                     var A=new AUI();
								var checkBoxValue= A.one("input[name=<portlet:namespace/>positionClass]:checked").get("value"); 
								if(checkBoxValue=="Temporary"){
		                            $(".startDate_ValidationMessage").show();
									$("#msgForEffectiveDate").show();
						            $('#startDate_maindiv').addClass('control-group error');
									$('#<portlet:namespace/>hidden_field').val('');
								}
								else{
				                        $(".startDate_ValidationMessage").hide();
										$("#msgForEffectiveDate").hide();
							            $('#startDate_maindiv').removeClass('control-group error');
								}
		                   } }},  ]]},
		           zIndex: 1
		         }}); });
$(document).ready(function(){
         $( "#<portlet:namespace/>newAssociateTitle" ).change(function() {
	    var AssociateTitleID=$("#<portlet:namespace/>newAssociateTitle").val();
	     $('#img2').show();
	      $.ajax({  
	       url : '<%=resourceURL.toString()%>',
	    data : {
	     <portlet:namespace />cmdType : AssociateTitleID,
	     <portlet:namespace />cmd : 'AssociateTitlePositionData',
	     <% if(wfmsCOS!=null){ %>
	      <portlet:namespace />newpositionId : '<%=wfmsCOS.getNewPositionNumber() %>',
	      <% } %>
	    },
	    type : "POST",
	    dataType : "json",
	    success : function(data) {
             $('#<portlet:namespace/>pId').empty(); //remove all child nodes
             $('#<portlet:namespace/>pId')
	         .append($("<option></option>")
	         .attr("value","")
	         .text("Select Position Number"));
	     $.each(data, function(idx, obj) {
	    	 $('#<portlet:namespace/>pId')
	         .append($("<option></option>")
	         .attr("value",obj)
	         .text(obj));
	     });
	     if(document.getElementById("associateTitle").innerHTML.trim()=="PA" || document.getElementById("associateTitle").innerHTML.trim()=="TC"){
                $('#<portlet:namespace/>pId')
   	         .append($("<option></option>")
   	         .attr("value","None")
   	         .text("None"));
   	     }var currentPosNo=document.getElementById("positionId").innerHTML;
	     if(currentPosNo !=null && currentPosNo != "" && currentPosTextVal == true){
			  $('#<portlet:namespace/>pId')
	        .append($("<option></option>")
			.attr("value",currentPosNo)
	        .text("Current Position"+" - "+currentPosNo )); }
             $('#<portlet:namespace/>pId').trigger("chosen:updated");
	     $('#img2').hide();
	    },
	    error : function(response) {
	           console.log("Error seen for for loadDivisonDepName");
	           $('#img2').hide();
	    }   });});
	<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 1){%>	
	         loadPosIdForUpdate();
	<%}%>
	<% if(wfmsCOS == null || wfmsCOS.getAction().equals("")){ %>
	<% } %>	
});
$(document).ready(function(){
    $(".accociate-title").change(function(){
        $(this).find("option:selected").each(function(){
            if($(this).attr("value")=="PATCOL"){
                $(".box").not(".PATCOL").hide();
                $(".PATCOL").show();
            }
            else{
                $(".box").hide();
            }
        });
    }).change();     
    $("#<portlet:namespace/>pId").change(function(){
    	if($(this).val() == "None"){
        	 $("#leadershipassignment").html("None");
        	}
    }); 
    $("#<portlet:namespace/>chgDesc").change(function(){
    	var actionId=$("#<portlet:namespace/>actionCodeID").val();
    	 var reasoncode=$("#<portlet:namespace/>reasoncode").val();
         var chgDesc=$("#<portlet:namespace/>chgDesc").val();
         chgDescValidation();
         AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
        	 A.io.request('<%=resourceURL.toString()%>',{  
        	 dataType: 'json', 
        	 method: 'GET',   
        	 data:
        	 { 
        		 <portlet:namespace/>actionId: actionId ,
        		 <portlet:namespace/>reasoncode: reasoncode ,
        		 <portlet:namespace/>chgDesc: chgDesc ,
        		 <portlet:namespace/>cmd: "getchgDesConditions"         		 
        		 },   
        	 on: {           		  
        		 success: function() {
        			 var data=this.get('responseData');        			 
        			 $('#<portlet:namespace/>IsSameJobCode').val(data.SameJobCode);
        			 $('#<portlet:namespace/>IsSameLeadership').val(data.SameLeadership);
        			 $('#<portlet:namespace/>IsSameDept').val(data.isSameDept);
        			 $('#<portlet:namespace/>IsSameMgr').val(data.isSameMgr);
        			 }  
        	 			}
        	    			});
        	 	            	}); 
    });    
});
function formvalidation(actionVal){
	checkServiceNowIsDownPoPup();
	var currentPosName=$("#<portlet:namespace/>pId option:selected").text().indexOf('Current Position');
	if( currentPosName == "-1"){$("#<portlet:namespace/>currentpositionText").val("nonecurrent");
	}else{	$("#<portlet:namespace/>currentpositionText").val("currentpositionText");} 
	$("#<portlet:namespace/>hidden_field").val('1');
       if(actionVal == 'submit'){
          $("#<portlet:namespace/>submitonworkflow").val('submit');
          $("#<portlet:namespace/>validation_type").val("1");
           $("#<portlet:namespace/>saveForm").val('');
       }
       if(actionVal == 'save'){
         $("#<portlet:namespace/>submitonworkflow").val('');
         $("#<portlet:namespace/>saveForm").val('save');
       }
       var associateNumberCos=$("#<portlet:namespace/>associaNumber").val();
       var associateDateOfHire=$("#<portlet:namespace/>associateDateOfHire").val();
       var actionId=$("#<portlet:namespace/>actionCodeID").val();
   	   var actionName=$.trim($("#<portlet:namespace />actionCodeID :selected").text());
       var reasoncode=$("#<portlet:namespace/>reasoncode").val();
       var chgDesc=$("#<portlet:namespace/>chgDesc").val();
       var associateTitleforNewPos=$("#<portlet:namespace/>newAssociateTitle").val();
       var pidvalue=$("#<portlet:namespace/>pId").val();	
       var shiftCode=$("#<portlet:namespace/>shiftCode").val();
       var LeaderShip=$("#<portlet:namespace/>LeaderShip").val();
       var Deptid=$("#<portlet:namespace/>divdeptRest").val();
       var type=$("#<portlet:namespace/>type").val();
       var manpowercatogiry=$("#<portlet:namespace/>manpower-catogiry").val();
       var teamNumber=$("#<portlet:namespace/>teamNumber").val();	
       var SameJobCode = "";
       var SameLeadership = "";
       var isSameDept = "";
       var isSameMgr = "";
           datevalidation();
           teamNumberValidation();
           manpowerValidation();
           chgDescValidation();
           associatNumbervalidate();
            actionValidation();
            reasoncodeValidation();
           newAssociateTitlevalidate();
           shiftCodeValidation();
              manageAssociateValidation();
	       var auiForm = Liferay.Form._INSTANCES.<portlet:namespace/>addWFMSCOS;
			var auiValidator = auiForm.formValidator;
			auiValidator.validate();
			if(actionVal == 'submit'){
			AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
		       	 A.io.request('<%=resourceURL.toString()%>',{  
		       	 dataType: 'json', 
		       	 method: 'GET',   
		       	 data:
		       	 {
		       		 <portlet:namespace/>actionId: actionId ,
		       		 <portlet:namespace/>reasoncode: reasoncode ,
		       		 <portlet:namespace/>chgDesc: chgDesc ,
		       		 <portlet:namespace/>cmd: "getchgDesConditions" 		       		 
		       		 },   
		       	 on: {		       		  
		       		 success: function() {
		       			if (!auiValidator.hasErrors()) {
		       			 var data=this.get('responseData');        			 
		       			SameJobCode        = data.SameJobCode;
		       			SameLeadership     = data.SameLeadership;
		       			SameDept           = data.isSameDept;
		       			SameMgr            = data.isSameMgr;
		       			CurrentJLeadership = data.CurrentJobCodeORLeadership;
		       			NewJLeadership     = data.NewJobCodeORLeadership;
						<%if(wfmsCOS !=null){%>    
		       	        <%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
			       	        var currentJobcode = $("#<portlet:namespace/>currentJobCode").val().trim();
			       	        var currentleadership = $("#<portlet:namespace/>currentLeadershipAssignment").val().trim();
			       	        var currentdepartment = $("#<portlet:namespace/>currentDepartmentNumber").val().trim();
			       	        var currentdeptmanager = $("#<portlet:namespace/>currentDepartmentManager").val().trim();
		       	        <% }else{%>
		       	        var currentJobcode = "<%=wfmsCOS.getCurrentJobCode()%>";
		       	        var currentleadership = "<%=wfmsCOS.getCurrentLeadershipAssignment()%>";
		       	       
		       	        var currentdepartment = "<%=wfmsCOS.getCurrentDepartmentNumber()%>";
		       	        var currentdeptmanager = "<%=wfmsCOS.getCurrentDepartmentManager()%>";
		       	        <%}%>		       	    
		       	        var CurrentJLeadershipArray = CurrentJLeadership.split(',');
		       	        var NewJLeadershipArray     = NewJLeadership.split(','); 
		       	        var CurrentJLeadershipText  = CurrentJLeadership.replace(/,/g," or ");
		       	        var NewJLeadershipText      = NewJLeadership.replace(/,/g," or ");
		       	        if($("#<portlet:namespace/>newAssociateTitle").val() == "PA" || $("#<portlet:namespace/>newAssociateTitle").val() == "TC"){
		       	        var PositionLeaderShipcode = $("#<portlet:namespace/>LeaderShip").val();	
		       	        var PositionDepartmentNumber = $("#<portlet:namespace/>divdeptRest").val().split('-');
		       	            PositionDepartmentNumber = PositionDepartmentNumber[0];		       	        		       	        
		       	        }else{
		       	        var PositionLeaderShipcode   = $("#<portlet:namespace/>NewpositionLeadership").val();	
		       	        var PositionDepartmentNumber = $("#<portlet:namespace/>NewpositionDepartmentname").val();
		       	        }
		       	        if(PositionLeaderShipcode == ""){
		       	        <% if(wfmsCOS.getLeadershipAssignment() != ""){%>
		       	            PositionLeaderShipcode = "<%=wfmsCOS.getLeadershipAssignment()%>";
		       	        <%}%>
		       	        }
		       	     if(currentleadership=="")
		       	        	currentleadership="None";
		       	        if(PositionLeaderShipcode == ""){		       	        
		       	        	PositionLeaderShipcode = "None";
		       	        }
		       	        if(pidvalue == 'None'){
		       	        	PositionLeaderShipcode = "None";
		       	        	var PositionDepartmentNumber = $("#<portlet:namespace/>divdeptRest").val().split('-');
		       	            PositionDepartmentNumber = PositionDepartmentNumber[0];
		       	        }
		       	        if(PositionLeaderShipcode == "PM"){
		       	        	PositionLeaderShipcode = "Plant Manager";
		       	        }
		       	     if(PositionLeaderShipcode == "DVM"){
		       	        	PositionLeaderShipcode = "Division Manager";
		       	     }
		       	     if(PositionLeaderShipcode == "DM"){
	       	        	PositionLeaderShipcode = "Department Manager";
	       	         }
		       	     if(PositionLeaderShipcode == "LTM"){
	       	        	PositionLeaderShipcode = "Lead Team Manager";
	       	         }
		       	     if(PositionLeaderShipcode == "TM"){
	       	        	PositionLeaderShipcode = "Team Manager";
	       	         }
		       	     if(CurrentJLeadership != "" || NewJLeadership!=""){
		       	        if(actionName != "Leadership Assignment" && ( (CurrentJLeadership!="" && $.inArray( currentJobcode, CurrentJLeadershipArray ) == -1) || (NewJLeadership!="" && $.inArray( $("#<portlet:namespace/>newAssociateTitle").val(), NewJLeadershipArray ) == -1))){
		       	        	getGenerateCosPopupforConditions("For this action the title must change.");
		       	        	return false;	
		       	        }		       	       
		       	        if(actionName == "Leadership Assignment" && ( (CurrentJLeadership!="" && $.inArray( currentleadership, CurrentJLeadershipArray ) == -1) || (NewJLeadership!="" && $.inArray( PositionLeaderShipcode, NewJLeadershipArray ) == -1))){
		       	        	getGenerateCosPopupforConditions("For this action the Leadership must change.");
		       	        	return false;	
		       	        }
		       	     }
		       	        if(currentJobcode == $("#<portlet:namespace/>newAssociateTitle").val() && SameJobCode.toLowerCase() == "must change"){
		       	        	getGenerateCosPopupforConditions("For this action the title must change.");
		       	        	return false;
		       	          }
		       	          if(currentleadership == PositionLeaderShipcode && SameLeadership.toLowerCase() == "must change"){
		       	    	    getGenerateCosPopupforConditions("For this action the Leadership must change.");
		       	    	    return false;
		    	          }
		       	          if(currentdepartment == PositionDepartmentNumber && SameDept.toLowerCase() == "must change"){
		       	    	    getGenerateCosPopupforConditions("For this action the Department name must change.");
		       	    	    return false;
		 	              }
		       	          if(currentdeptmanager == $("#<portlet:namespace/>NewpositiondeptManager").val() && SameMgr.toLowerCase() == "must change"){
		       	    	   getGenerateCosPopupforConditions("For this action the Department manager must change.");
		       	    	   return false;
			              }
		       	          if(currentJobcode != $("#<portlet:namespace/>newAssociateTitle").val() && SameJobCode.toLowerCase() == "must match"){
		      	        	getGenerateCosPopupforConditions("For this action the title must match.");
		      	        	return false;
		      	          }
		      	          if(currentleadership != PositionLeaderShipcode && SameLeadership.toLowerCase() == "must match"){
		      	    	    getGenerateCosPopupforConditions("For this action the Leadership must match.");
		      	    	    return false;
		      	          }
		      	          if(currentdepartment != PositionDepartmentNumber && SameDept.toLowerCase() == "must match"){
		      	    	    getGenerateCosPopupforConditions("For this action the Department name must match.");
		      	    	    return false;
			              }
		      	          if(currentdeptmanager != $("#<portlet:namespace/>NewpositiondeptManager").val() && SameMgr.toLowerCase() == "must match"){
		      	    	   getGenerateCosPopupforConditions("For this action the Department manager must match.");
		      	    	   return false;
			              }
		       	        <%}%>		       	        
		       	        $('#showValidations').modal('hide');
		                 $("button[type=button]").attr('disabled',true); 	
						 $("#<portlet:namespace/>addWFMSCOS").submit();					
					 }
					 else{
					   $('#showValidations').modal({ backdrop: 'static',
                        keyboard: true, 
                        show: true});
					 } }  	}
		       	    			});
		       });
			}else{
		                 $("button[type=button]").attr('disabled',true); 	
						 $("#<portlet:namespace/>addWFMSCOS").submit();					
			}
}
function checkServiceNowIsDown(){
 	AUI().use('aui-base',
	'aui-io-plugin-deprecated',
	'liferay-util-window',
function(A) {
	var popUpWindow = Liferay.Util.Window.getWindow({
		dialog : {
			centered : true,
			constrain2view : true,
			align : {
				node : null,
				points : [ 'tc', 'tc' ]
			},
			modal : true,
			cache : false,
			width : 550,
			height : 150,
			destroyOnClose : true,
		}
	}).plug(A.Plugin.IO, {
		autoLoad : false
	}).render();
	popUpWindow.show();
	popUpWindow.titleNode.html("");
	popUpWindow.io.set('uri',"<%=generateInternetConnection%>");
	popUpWindow.io.start();
});
}
function checkServiceNowIsDownPoPup(){
$.ajax({
	url : '<%=resourceURL.toString()%>',
	data : {
		<portlet:namespace />cmd : 'checkServiceNowIsDown'
	},
	type : "POST",
	dataType : "json",
	success : function(data) {
		if(data.sucess)checkServiceNowIsDown();
	},
	error : function(response) {
    	console.log("Error seen for for checkServiceNowIsDownPoPup");
	}
});
}
  jQuery(document).ready(function(){
           associatNumbervalidate();
    });
function formValidationForSave(){
	var currentPosName=$("#<portlet:namespace/>pId option:selected").text().indexOf('Current Position');
	if( currentPosName == "-1"){$("#<portlet:namespace/>currentpositionText").val("nonecurrent");		
	}else{	$("#<portlet:namespace/>currentpositionText").val("currentpositionText");} 
	$("#<portlet:namespace/>hidden_field").val('1');
       $("#<portlet:namespace/>validation_type").val("1");
        $("#<portlet:namespace/>saveForm").val('save');
          associatNumbervalidate();
           <% //if(associateID!=null && associateIdForExistingRecord==""){ %>
                newAssociateTitlevalidate();
          <% //} %>
          hiddev_val= $("#<portlet:namespace/>hidden_field").val();
			if(hiddev_val!='')
				{
				 $('#showValidations').modal('hide');
				 $("button[type=button]").attr('disabled',true); 
				 $("#<portlet:namespace/>addWFMSCOS").submit();			
				}	
				else{
				 $('#showValidations').modal({ backdrop: 'static',
                        keyboard: true, 
                        show: true});
				}		
 }
 function loadAssociateTitleforNewPos(){  
		 var associateTitleforNewPos=$("#<portlet:namespace/>newAssociateTitle").val();	
		 newAssociateTitlevalidate();
		 if(associateTitleforNewPos == ""){
    		  $('#Division').html("");
    		  $('#deptNAME').html("");
    		  $('#deptManager').html("");
    		  $('#divMgrName').html("");
    		  $('#newDeptNUmber1').html("");
    		  $('#leadershipassignment').html("");
    		  $('#managerAssociateNumber').html("");
    		  $('#ManagerAssociateName').html("");
    		  $('#ManagerAssociateTitle').html("");
    		  $('#DivisionFromM').html("");
    		  $('#deptNameFromM').html("");
    		  $('#deptManagerFromM').html("");
    		  $('#divMgrNameFromM').html("");
    		  $('#ManPowerRep').html("");
		 }
		 else if(associateTitleforNewPos == 'TC' || associateTitleforNewPos == 'PA'){   
	        <% if(wfmsCOS !=null){ %>
		      $("#managerAssociatedropdown").show();
		    if($("#<portlet:namespace/>mgrassociateNo").val()==''){
		      $("#msgFormanagerAssociateNumber").show();
                       $("#ManagerAssociateName").html("");
                       $("#ManagerAssociateTitle").html("");
		    }else{
		       $("#msgFormanagerAssociateNumber").hide();
                       $("#ManagerAssociateName").show();
                       $("#ManagerAssociateTitle").show();
              }
		    <% } %>
				var positionDisplay = document.getElementById("NewPOS");
				var departmentDisplay = document.getElementById("deptNumber");
     		 	if(positionDisplay.style.display == "none") {
					 document.getElementById("Division").style.display = "none";
					 document.getElementById("deptNAME").style.display = "none";
					 document.getElementById("deptManager").style.display = "none";
					 document.getElementById("divMgrName").style.display = "none";
					 document.getElementById("newDeptNUmber1").style.display = "none";
					 document.getElementById("leadershipassignment").style.display = "none";
					 document.getElementById("managerAssociateNumber").style.display = "none";
					 document.getElementById("ManagerAssociateName").style.display = "none";
					 document.getElementById("ManagerAssociateTitle").style.display = "none";
     		 	}
     		 	if(departmentDisplay.style.display == "block"){
     		 		document.getElementById("DivisionFromM").style.display = "block";
     		 		document.getElementById("deptNameFromM").style.display = "block";
     		 		document.getElementById("deptManagerFromM").style.display = "block";
     		 		document.getElementById("divMgrNameFromM").style.display = "block";
     		 		document.getElementById("ManPowerRep").style.display = "block";
     		 	}
        	}
        	else{
        	       $("#managerAssociatedropdown").hide();
                   $("#<portlet:namespace/>mgrassociateNo").val('');                
                   $("#ManagerAssociateName").html("");
                   $("#ManagerAssociateTitle").html("");
                   $("#managerAssociateNumber").html("");                 
        	       $("#msgFormanagerAssociateNumber").hide();
        		   document.getElementById("UpdatePO").style.display = "none";
        		   var pidvalue=$("#<portlet:namespace/>pId").val();
        	if(associateTitleforNewPos != 'Select Associate' && pidvalue == 'None'){
				document.getElementById("Division").style.display = "none";
				document.getElementById("deptNAME").style.display = "none";
				document.getElementById("deptManager").style.display = "none";
				document.getElementById("divMgrName").style.display = "none";
				document.getElementById("newDeptNUmber1").style.display = "none";
				document.getElementById("leadershipassignment").style.display = "none";
				document.getElementById("managerAssociateNumber").style.display = "none";
				document.getElementById("ManagerAssociateName").style.display = "none";
				document.getElementById("ManagerAssociateTitle").style.display = "none";
			} else {
				document.getElementById("MgrAssNo").style.display = "none";
				var positionDisplay = document.getElementById("NewPOS");
				var departmentDisplay = document.getElementById("deptNumber");
     		 	if(positionDisplay.style.display == "block") {
				 document.getElementById("Division").style.display = "block";
				 document.getElementById("deptNAME").style.display = "block";
				 document.getElementById("deptManager").style.display = "block";
				 document.getElementById("divMgrName").style.display = "block";
				 document.getElementById("newDeptNUmber1").style.display = "block";
				 document.getElementById("leadershipassignment").style.display = "block";
				 document.getElementById("managerAssociateNumber").style.display = "block";
				 document.getElementById("ManagerAssociateName").style.display = "block";
				 document.getElementById("ManagerAssociateTitle").style.display = "block";
     		 	}if(departmentDisplay.style.display == "none"){
     		 		document.getElementById("DivisionFromM").style.display = "none";
     		 		document.getElementById("deptNameFromM").style.display = "none";
     		 		document.getElementById("deptManagerFromM").style.display = "none";
     		 		document.getElementById("divMgrNameFromM").style.display = "none";
     		 		document.getElementById("ManPowerRep").style.display = "none";
     		 	}
			}
		}var currentpositionnumber= document.getElementById("positionId").innerHTML; 
		 if(associateTitleforNewPos != "PA" && associateTitleforNewPos != "TC" && currentpositionnumber != "" && associateTitleforNewPos.trim()!=""){
				$.ajax({
			    		url : '<%=resourceURL.toString()%>',
						data : {
							<portlet:namespace />assotiletitle : associateTitleforNewPos,
							<portlet:namespace />currentpositionnumber : currentpositionnumber ,
							<portlet:namespace />cmd : 'assiateTitleshowalert'
						},
						type : "POST",
						dataType : "json",
						success : function(data) {
							console.log("me "+data.flagshow);
							currentPosTextVal=data.flagshow;
							if(!data.flagshow) {
								getAuiAsTitlePopup();
							$("#msgForPosition").show();
							}	
						},
						error : function(response) {
				        	console.log("Error seen for show pop on assotiletitle validating");
						}
				 }); }  }
function datevalidation(){
	var startDate=$("#<portlet:namespace/>startDate").val();
	var validation_type=$("#<portlet:namespace/>validation_type").val();
            if(startDate==''){
	            if(validation_type==1){
				   $(".startDate_ValidationMessage").show();
				   $('#startDate_maindiv').addClass('control-group error');
				   $('#<portlet:namespace/>hidden_field').val('');
				}
				$("#msgForEffectiveDate").show();
			}
			else {
				   $(".startDate_ValidationMessage").hide();
				   $("#msgForEffectiveDate").hide();
		           $('#startDate_maindiv').removeClass('control-group error');
			}
}
 function newAssociateTitlevalidate(){
         var validation_type=$("#<portlet:namespace/>validation_type").val();
         var newAssociateTitle=$("#<portlet:namespace/>newAssociateTitle").val();
        if(newAssociateTitle==''){
        	$("#msgForTitle").show();
           if(validation_type==1){
				$(".newAssociateTitle_ValidationMessage").show();
	            $('#newAssociateTitle_mainDiv').addClass('control-group error');
			    $('#<portlet:namespace/>hidden_field').val('');
			}
		}
		else{
			$(".newAssociateTitle_ValidationMessage").hide();
			$("#msgForTitle").hide();
            $('#newAssociateTitle_mainDiv').removeClass('control-group error');
		}
		  <% if(!(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 	|| wfmsCOS.getSystemGenerated() == 2))){ %>
          positionnumberrvalidate();
          validateDeptNumber();
          <% } %>
	}
	function associatNumbervalidate(){
         var associateNumberCos=$("#<portlet:namespace/>associaNumber").val();
         	var validation_type=$("#<portlet:namespace/>validation_type").val();
         	$("#msgForAssociateNumber").show();
         	$("#msgForAssociateNumberBlank").hide();
		if(associateNumberCos==''){
		    if(validation_type==1){
				$(".associaNumber_ValidationMessage").show();
	            $('#associaNumber_mainDiv').addClass('control-group error');
				$('#<portlet:namespace/>hidden_field').val('');
			}
		}
		else{
		    $("#msgForAssociateNumber").hide();
		    $("#msgForAssociateNumberBlank").show();
			$(".associaNumber_ValidationMessage").hide();
            $('#associaNumber_mainDiv').removeClass('control-group error');
		}
	}
	function positionnumberrvalidate(){
      var newAssociateTitle=document.getElementById("<portlet:namespace/>newAssociateTitle").value;
      var validation_type=$("#<portlet:namespace/>validation_type").val();
		  if(newAssociateTitle!="PA" && newAssociateTitle!="TC" && newAssociateTitle!=""){
		            $('#NewPOS').show();
		            document.getElementById("<portlet:namespace/>pId").disabled = false;
			        var pId=$("#<portlet:namespace/>pId").val();
					if(pId==''){
					    $("#msgForPosition").show();
					    if(validation_type==1){
							$(".positionnumber_ValidationMessage").show();
				            $('#NewPOS').addClass('control-group error');
							$('#<portlet:namespace/>hidden_field').val('');   
						}
					}
					else{
						$(".positionnumber_ValidationMessage").hide();
						$("#msgForPosition").hide();
			            $('#NewPOS').removeClass('control-group error');
					}
		}
		else{
		 $('#NewPOS').hide();
		 $("#<portlet:namespace/>pId").val('');
		 $(".positionnumber_ValidationMessage").hide();
		 $("#msgForPosition").hide();
	     $('#NewPOS').removeClass('control-group error');
		}
	}
	function validateDeptNumber()
    {
      var validation_type=$("#<portlet:namespace/>validation_type").val();
	  var newAssociateTitle=document.getElementById("<portlet:namespace/>newAssociateTitle").value;
	  var position=document.getElementById("<portlet:namespace/>pId").value;
	  if((newAssociateTitle=="PA" || newAssociateTitle=="TC" || newAssociateTitle=="") || (newAssociateTitle!="" && position=="None")){
		    $("#deptNumber").show();
		    document.getElementById("<portlet:namespace/>divdeptRest").disabled = false;
		    $(".chosenDivdeptRest").data("placeholder","Select Frameworks...").chosen({search_contains:true});
		    document.getElementById("<portlet:namespace/>LeaderShip").disabled = false;
		    var divdeptRest=$("#<portlet:namespace/>divdeptRest").val();
		    if(divdeptRest==""){
		    	 $("#msgForsameDept").show();
		    	 if(validation_type==1){
			    	 $(".newDeptNUmber_ValidationMessage").show();
	                 $('.newDeptNUmber_mindiv').addClass('control-group error');
				     $('#<portlet:namespace/>hidden_field').val(''); 
			     }  
		    }
		    else{
		    	 $("#msgForsameDept").hide();
		    	 $(".newDeptNUmber_ValidationMessage").hide();
                 $('.newDeptNUmber_mindiv').removeClass('control-group error');
		    }
        }
	    else{
		   $("#deptNumber").hide();
		   $("#msgForsameDept").hide();
		   $(".newDeptNUmber_ValidationMessage").hide();
           $('.newDeptNUmber_mindiv').removeClass('control-group error');
		}
	  }
	  function teamNumberValidation(){
           var teamNumber=$("#<portlet:namespace/>teamNumber").val();	
           var validation_type=$("#<portlet:namespace/>validation_type").val();
         if(teamNumber==''){
           $("#msgForTeamNumber").show();
	           if(validation_type==1){
		            $(".teamNumber_ValidationMessage").show();
		            $('#teamNumber_maindiv').addClass('control-group error');
					$('#<portlet:namespace/>hidden_field').val('');
	           }  
         }
         else{
           $("#msgForTeamNumber").hide();
           $(".teamNumber_ValidationMessage").hide();
           $('#teamNumber_maindiv').removeClass('control-group error');
         }
}
function shiftCodeValidation(){
        var shiftCode=$("#<portlet:namespace/>shiftCode").val();
        var validation_type=$("#<portlet:namespace/>validation_type").val();	
         if(shiftCode==''){
         $("#msgForShiftCode").show();
          if(validation_type){
	           $('#shiftCode_maindiv').addClass('control-group error');
	           $(".shiftCode_ValidationMessage").show();
	           $("#<portlet:namespace/>hidden_field").val('');
           }
         }
         else{
            $(".shiftCode_ValidationMessage").hide();
            $('#shiftCode_maindiv').removeClass('control-group error');
            $("#msgForShiftCode").hide();
         }
}
function manageAssociateValidation(){
        var mgrassociateNo=$("#<portlet:namespace/>mgrassociateNo").val();
        var validation_type=$("#<portlet:namespace/>validation_type").val();
        var position=document.getElementById("<portlet:namespace/>pId").value;
        <% if(wfmsCOS !=null){ %>
          var newAssociateTitle=document.getElementById("<portlet:namespace/>newAssociateTitle").value;
	  var position=document.getElementById("<portlet:namespace/>pId").value;
	  if((newAssociateTitle=="PA" || newAssociateTitle=="TC") || (newAssociateTitle!="" && position=="None")){

        if(mgrassociateNo==''){
           $('#ManagerAssociateName').html("");
    	   $('#ManagerAssociateTitle').html("");
          $("#msgFormanagerAssociateNumber").show();
          if(validation_type==1){
	           $('#managerAssociatedropdown').addClass('control-group error');
	           $(".manageAssociate_ValidationMessage").show();
	           $("#<portlet:namespace/>hidden_field").val('');
           }
         }
         else{
            $(".manageAssociate_ValidationMessage").hide();
            $('#managerAssociatedropdown').removeClass('control-group error');
            $("#msgFormanagerAssociateNumber").hide();
         }
         }
         else{
            $(".manageAssociate_ValidationMessage").hide();
            $('#managerAssociatedropdown').removeClass('control-group error');
            $("#msgFormanagerAssociateNumber").hide();
         }
         <% } %>
}
function manpowerValidation(){
         var manpowercatogiry=$("#<portlet:namespace/>manpower-catogiry").val();
          var validation_type=$("#<portlet:namespace/>validation_type").val();	
         if(manpowercatogiry==''){
         $("#msgForManpower").show();
         if(validation_type==1){
	           $(".manpowerCategiry_ValidationMessage").show();
	           $('#manpowerCategiry_maindiv').addClass('control-group error');
	           $("#<portlet:namespace/>hidden_field").val('');
           }
         }
         else{
           $(".manpowerCategiry_ValidationMessage").hide();
           $('#manpowerCategiry_maindiv').removeClass('control-group error');
           $("#msgForManpower").hide();
         }
}
function actionValidation(){
         var actionCodeID=$("#<portlet:namespace/>actionCodeID").val();	
         var validation_type=$("#<portlet:namespace/>validation_type").val();
         if(actionCodeID==''){
           $("#msgForActionCode").show();
           if(validation_type==1){
	           $(".action_ValidationMessage").show();
	           $('#action_maindiv').addClass('control-group error');
	           $("#<portlet:namespace/>hidden_field").val('');
           }
         }
         else{
           $(".action_ValidationMessage").hide();
            $('#action_maindiv').removeClass('control-group error');
            $("#msgForActionCode").hide();
         }	
}
function reasoncodeValidation(){
	var reasoncode=$("#<portlet:namespace/>reasoncode").val();
	var validation_type=$("#<portlet:namespace/>validation_type").val();
	    if(reasoncode==''){
	    $("#msgForreasonCODE").show();
	       if(validation_type==1){
	         	$(".reasoncode_ValidationMessage").show();
	            $('#reasonCODE').addClass('control-group error');
				$('#<portlet:namespace/>hidden_field').val('');
	         	$("#<portlet:namespace/>reasoncode").focus();
         	}
         }
         else{
			$("#msgForreasonCODE").hide();
			$(".reasoncode_ValidationMessage").hide();
            $('#reasonCODE').removeClass('control-group error');
         }
 }
 function chgDescValidation(){
	var chgDesc=$("#<portlet:namespace/>chgDesc").val();
	var validation_type=$("#<portlet:namespace/>validation_type").val();	
	if(chgDesc==''){
				$("#msgForchgDesc").show();
	     if(validation_type==1){
         	$(".chgDesc_ValidationMessage").show();
            $('#changeDescription').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');
         	$("#<portlet:namespace/>chgDesc").focus();
         	}
         }
         else{
			$("#msgForchgDesc").hide();
			$(".chgDesc_ValidationMessage").hide();
            $('#changeDescription').removeClass('control-group error');
         }
 }
function loadAction(){
	$('#<portlet:namespace/>reasoncode').empty();
	var actionId=$("#<portlet:namespace/>actionCodeID").val();
	  actionValidation();
	  $("#changeDescription").hide();
	if(actionId!=""){
	     $("#reasonCODE").show();
	     $("#msgForreasonCODE").show();
	}
	else{
        $("#reasonCODE").hide();	
        $("#changeDescription").hide();	
	 }
	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){
	 A.io.request('<%=resourceURL.toString()%>',{  
	 dataType: 'json', 
	 method: 'GET',   
	 data:
	 {
		 <portlet:namespace/>actionId: actionId ,
		 <portlet:namespace/>cmd: "getActionURL" 
		 
		 },   
	 on: {    
		  
		 success: function() {
			 var data=this.get('responseData');
			 console.log(JSON.stringify(data))
			 var textElement;
			 textElement= textElement+"<option value=''>Select Reason Code</option>";
			 $('#description').html("");
			 $('#ReasonCode').find('select').html("");
			 jQuery.each(data, function(i, val) {
				
			 textElement=textElement+"<option value='" + val.ReasonCode + "'>"+ val.ReasonCode + "-"+ val.change_Des + "</option>";
			});
			 $('#reasonCODE').find('select').append(textElement);
			 }  
	 			}
	    			});
	 	            	}); 

   } 
function onloadDescription(){  
	var reasoncode=$("#<portlet:namespace/>reasoncode").val();
	      if(reasoncode == ""){
        	   $("#changeDescription").hide();	
        	}else{
        	    $("#changeDescription").show();
        	    $("#msgForchgDesc").show();
        	}
	reasoncodeValidation();
	var action=$("#<portlet:namespace/>actionCodeID").val();
	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
	 A.io.request('<%=resourceURL.toString()%>',{  
	 dataType: 'json', 
	 method: 'GET',   
	 data:
	 { 
		 <portlet:namespace/>reasoncode: reasoncode ,
		 <portlet:namespace/>action: action ,
		 <portlet:namespace/>cmd: "getDescriptionURL" 
		 
		 },   
	 on: {    
		 success: function() {
			 var data=this.get('responseData');
			 console.log(JSON.stringify(data))
			 var textElement;
			 textElement= textElement+"<option value=''>Select Change Description</option>";
			 $('#changeDescription').find('select').html("");
			 jQuery.each(data, function(i, val) {
				 if(val.Description !== undefined)
					 $('#description').html(val.Description);
				if(val.changeDescription !== undefined)
			 		textElement=textElement+"<option value='" + val.changeDescription + "'>"+ val.changeDescription + "</option>";
			});
			 $('#changeDescription').find('select').append(textElement);
			 }
	 }
	 });
	 }); 
	 } 
	function getserviceDetails(){  
	var roleUuid=$("#<portlet:namespace/>divdeptRest").val();
	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
	 A.io.request('<%=resourceURL.toString()%>',{  
	 dataType: 'json',
	 method: 'GET',   
	 data:
	 { 
		 <portlet:namespace/>roleUuid: roleUuid ,
		 <portlet:namespace/>cmd: "getServiceDetail" 
		 },   
	 on: {    
		 
		success: function() {
			 var data=this.get('responseData');
			 }   
	 				}
	 			});
	 		}); 
	 } 
      function dataempty(){
					$('#associateName').html("");
					$('#associateTitle').html("");
					$('#positionId').html("");
					$('#<portlet:namespace/>newpositionId').val("");
					$('#DIVISION').html("");
					$('#DIVISION_MANAGER').html("");
					$('#DEPT_NAME').html("");
					$('#DEPT_NUMBER').html("");
					$('#DEPT_MANAGER').html("");
					$('#teamNumber').html("");
					$('#shiftcode').html("");
					$('#employeecategory').html("");
		    		$('#leader-assignment').html("");
					$('#mgrassociateno').html("");
		  			$('#mgrName').html("");
		  			$('#mgrTitle').html("");
		  			$('#associatedateofhire').html("");		  			
		  			$('#<portlet:namespace/>currentJobCode').val("");
	 			    $('#<portlet:namespace/>currentPositionNumber').val("");
		 			$('#<portlet:namespace/>currentDivision').val("");
		 			$('#<portlet:namespace/>currentDivisionManager').val("");
		 			$('#<portlet:namespace/>currentDepartmentName').val("");
		 			$('#<portlet:namespace/>currentDepartmentNumber').val("");	
		 			$('#<portlet:namespace/>currentManagerName').val("");
		 			$('#<portlet:namespace/>currentTeamNumber').val("");
		 			$('#<portlet:namespace/>currentShiftCode').val("");
	 			    $('#<portlet:namespace/>currentLeadershipAssignment').val("");	
		 			$('#<portlet:namespace/>currentManagerAssocNumber').val("");
		 			$('#<portlet:namespace/>currentDepartmentManager').val("");
		 			$('#<portlet:namespace/>currentManagerTitle').val("");
		 			$('#<portlet:namespace/>currentManpowerRep').val("");
      }
      function loadAssociateNo(){
      	var associaNumber=$("#<portlet:namespace/>associaNumber").val();
      	associatNumbervalidate();
      	if(associaNumber==""){
      	    $('#msgForTitle').hide();
      	    dataempty();
      	}
      	else{
      	    $('#msgForTitle').show();
			 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
			 A.io.request('<%=AssNumURL%>',{  
			 dataType: 'json', 
			 method: 'GET',   
			 data:
			 { 
				 		 <portlet:namespace />associateID: associaNumber,
				 },   
			 on: {    
				 success: function() {
					var data=this.get('responseData');
					$('#associateName').html(data.ASSOCIATE_NAME);
					$('#associateTitle').html(data.ASSOCIATE_TITLE);
					
					//alert(data.positionId);
					if(!(data.positionId === undefined || data.positionId.length <= 0)){
						$('#positionId').html(data.positionId);
					    $('#<portlet:namespace/>newpositionId').val(''+data.positionId+'');
					}
					else{
						$('#positionId').html("");
					    $('#<portlet:namespace/>newpositionId').val('');
						$('#positionId').html(""); 
				 }
					$('#DIVISION').html(data.DIVISION);
					$('#DIVISION_MANAGER').html(data.DIVISION_MANAGER);
					$('#DEPT_NAME').html(data.DEPT_NAME);
					$('#DEPT_NUMBER').html(data.DEPT_NUMBER);
					$('#DEPT_MANAGER').html(data.DEPARTMENT_MANAGER);
					$('#teamNumber').html(data.TEAM_NUMBER);
					$('#shiftcode').html(data.SHIFT_CODE);
					$('#employeecategory').html(data.EMPLOYEE_CATEGORY);
					if(data.LEADERSHIP_ASSIGNMENT == ""){
		    			$('#leader-assignment').html("None");	
		    		}else{
		    			$('#leader-assignment').html(data.LEADERSHIP_ASSIGNMENT);
		    		}
					$('#mgrassociateno').html(data.MANAGER_ASSOCIATE_NUMBER);
		  			$('#mgrName').html(data.DEPT_MANAGER);
		  			$('#mgrTitle').html(data.DEPT_MANAGER_TITLE);
					
		  			$('#associatedateofhire').html(data.ASSOCIATE_DATE_OF_HIRE);
		  			$('#<portlet:namespace/>associateDateOfHire').val(data.ASSOCIATE_DATE_OF_HIRE);
		  			$('#<portlet:namespace/>currentJobCode').val(data.ASSOCIATE_TITLE);
		  			if(!(data.positionId === undefined || data.positionId.length <= 0)){
		 			    $('#<portlet:namespace/>currentPositionNumber').val(''+data.positionId+'');
		  			}
		 			$('#<portlet:namespace/>currentDivision').val(data.DIVISION);
		 			$('#<portlet:namespace/>currentDivisionManager').val(data.DIVISION_MANAGER);
		 			$('#<portlet:namespace/>currentDepartmentName').val(data.DEPT_NAME);
		 			$('#<portlet:namespace/>currentDepartmentNumber').val(data.DEPT_NUMBER);	
		 			$('#<portlet:namespace/>currentManagerName').val(data.DEPT_MANAGER);
		 			$('#<portlet:namespace/>currentTeamNumber').val(data.TEAM_NUMBER);
		 			$('#<portlet:namespace/>currentShiftCode').val(data.SHIFT_CODE);
		 			if(data.LEADERSHIP_ASSIGNMENT == ""){
		 			    $('#<portlet:namespace/>currentLeadershipAssignment').val("None");	
		 			}else{
		 			    $('#<portlet:namespace/>currentLeadershipAssignment').val(data.LEADERSHIP_ASSIGNMENT);
		 			}
		 			$('#<portlet:namespace/>currentManagerAssocNumber').val(data.MANAGER_ASSOCIATE_NUMBER);
		 			$('#<portlet:namespace/>currentDepartmentManager').val(data.DEPARTMENT_MANAGER);
		 			$('#<portlet:namespace/>currentManagerTitle').val(data.DEPT_MANAGER_TITLE);
		 			
		 			$('#<portlet:namespace/>currentManpowerRep').val(data.MANPOWER_REP);
						 }   
					 } 
				 });
			 }); 
			 document.getElementById("<portlet:namespace/>newAssociateTitle").disabled = false; 
			   $(".chosenAssociateTitle").data("placeholder","Select Frameworks...").chosen({search_contains:true});
        }
   } 
      function modaForNoDataInServiceNow() {
      	AUI().use('aui-base',
      				'aui-io-plugin-deprecated',
      				'liferay-util-window',
      			function(A) {
      				var popUpWindow = Liferay.Util.Window.getWindow({
      					dialog : {
      						centered : true,
      						constrain2view : true,
      						align : {
      							node : null,
      							points : [ 'tc', 'tc' ]
      						},
      						modal : true,
      						cache : false,
      						width : 600,
      						height : 100,
      						destroyOnClose : true,
      					}
      				}).plug(A.Plugin.IO, {
      					autoLoad : false
      				}).render();
		popUpWindow.titleNode.html("This Associate do not have the department details in ServiceNow - Please contact Adminstrator");
       	});
      }
      function loadMgrAssoNo(){
      	var mgrAssociateId=$("#<portlet:namespace/>mgrassociateNo").val();
        manageAssociateValidation();
        if(mgrAssociateId!=""){
        $("#msgFormanagerAssociateNumber").hide();
      	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
      	 A.io.request('<%=resourceURL.toString()%>',{  
      	 dataType: 'json', 
      	 method: 'GET',   
      	 data:
      	 {
      		  <portlet:namespace/>mgrAssociateId: mgrAssociateId,
      		  <portlet:namespace/>cmd: "ManagerAssoNoURL"
      		 },   
      	 on: {    
      		 success: function() {
                    var data=this.get('responseData');
      		   console.log(data);
      		$('#ManagerAssociateName').html(data.ASSOCIATE_NAME);
    		$('#ManagerAssociateTitle').html(data.ASSOCIATE_TITLE);
                $('#ManagerAssociateName').show();
                $('#ManagerAssociateTitle').show();
      				 }   
      			 }
      		 });
      	 }); 
         }
         else{
            $("#msgFormanagerAssociateNumber").show();
         }
       } 
       function updateValuesForSelectedDepartment(){
	validateDeptNumber();
	var Deptid=$("#<portlet:namespace/>divdeptRest").val();
	 var pidvalue=$("#<portlet:namespace/>pId").val();
	 $('#DivisionFromM').html("");
	  $('#deptNameFromM').html("");
	  $('#deptManagerFromM').html("");
	  $('#divMgrNameFromM').html("");
	  $('#ManPowerRep').html("");
	if(Deptid == ""){
		  $('#DivisionFromM').html("");
		  $('#deptNameFromM').html("");
		  $('#deptManagerFromM').html("");
		  $('#divMgrNameFromM').html("");
		  $('#ManPowerRep').html("");
 	}else{
		var Deptid = Deptid.split("-");
		for (var i=0;i< Deptid.length;i++)
		 {
		     var Deptid = Deptid[i].split(" ");
		 }
		 var Deptid = Deptid[0];
    $.ajax({  
    		url : '<%=resourceURL.toString()%>',
			data : {
				<portlet:namespace />Deptid : Deptid,
				<portlet:namespace />cmd : 'LoadDivisionNames'
			},
			type : "POST",
			dataType : "json",
			success : function(data) {
				console.log(data);
				 $('#DivisionFromM').html(data.Division);
					$('#deptNameFromM').html(data.deptNAME);
					//$('#deptMgrName').html(data.deptMgrName);
					$('#deptManagerFromM').html(data.deptMgrName);
					$('#divMgrNameFromM').html(data.divMgrName);
					 $('#ManPowerRep').html(data.MANPOWER_REP);
					 document.getElementById("deptNumber").style.display = "block";
					 document.getElementById("DivisionFromM").style.display = "block";
					 document.getElementById("deptNameFromM").style.display = "block";
					 document.getElementById("deptManagerFromM").style.display = "block";
					 document.getElementById("divMgrNameFromM").style.display = "block";
					  document.getElementById("ManPowerRep").style.display = "block";
					  if(pidvalue == "None")
					  	document.getElementById("NewPOS").style.display = "block";
					  else
						document.getElementById("NewPOS").style.display = "none";
					  document.getElementById("Division").style.display = "none";
					  document.getElementById("deptNAME").style.display = "none";
					  document.getElementById("deptManager").style.display = "none";
					  document.getElementById("divMgrName").style.display = "none";
					   document.getElementById("newDeptNUmber1").style.display = "none";
					  document.getElementById("leadershipassignment").style.display = "none";
					  document.getElementById("managerAssociateNumber").style.display = "none";
					  document.getElementById("ManagerAssociateName").style.display = "none";
					  document.getElementById("ManagerAssociateTitle").style.display = "none";
					 
			},
			error : function(response) {
	        	console.log("Error seen for for loadDivisonDepName");
			}
		});
 	}
	}
      function loadPosId(){
	       var pidvalue=$("#<portlet:namespace/>pId").val();
	      positionnumberrvalidate();
               validateDeptNumber();
	      $('#Division').html("");
		  $('#deptNAME').html("");
		  $('#deptManager').html("");
		  $('#divMgrName').html("");
		  $('#newDeptNUmber1').html("");
		  $('#leadershipassignment').html("");
		  $('#managerAssociateNumber').html("");
		  $('#ManagerAssociateName').html("");
		  $('#ManagerAssociateTitle').html("");
		  $('#employeecategoryNew').html("");
      	if(pidvalue=="")
      		{
			  $('#Division').html("");
			  $('#deptNAME').html("");
			  $('#deptManager').html("");
			  $('#divMgrName').html("");
			  $('#newDeptNUmber1').html("");
			  $('#leadershipassignment').html("");
			  $('#managerAssociateNumber').html("");
			  $('#ManagerAssociateName').html("");
			  $('#ManagerAssociateTitle').html("");
			  $('#employeecategoryNew').html("");
      		}
		    else if(pidvalue=="None")
      		    {  //loadAssociateTitleforNewPos
                                    <% if(wfmsCOS !=null){ %>
				                         $("#managerAssociatedropdown").show();
                                         if($("#<portlet:namespace/>mgrassociateNo").val()==''){
                                            $("#msgFormanagerAssociateNumber").show();
                                             $("#ManagerAssociateName").html("");
                                             $("#ManagerAssociateTitle").html("");
                                          }else{
                                             $("#msgFormanagerAssociateNumber").hide();
                                             $("#ManagerAssociateName").show();
                                             $("#ManagerAssociateTitle").show();
                                           }
                                    <% } %>                                                
					    document.getElementById("deptNumber").style.display = "block";
					    var positionDisplay = document.getElementById("NewPOS");
						var departmentDisplay = document.getElementById("deptNumber");
		     		 	if(positionDisplay.style.display == "block") {
		     		 		document.getElementById("Division").style.display = "none";
		    				document.getElementById("deptNAME").style.display = "none";
		    				document.getElementById("deptManager").style.display = "none";
		    				document.getElementById("divMgrName").style.display = "none";
		    				document.getElementById("newDeptNUmber1").style.display = "none";
		    				document.getElementById("leadershipassignment").style.display = "none";
		    				document.getElementById("managerAssociateNumber").style.display = "none";
		    				document.getElementById("ManagerAssociateName").style.display = "none";
		    				document.getElementById("ManagerAssociateTitle").style.display = "none";
		     		 	}
		     		 	if(departmentDisplay.style.display == "block"){
		     		 		document.getElementById("DivisionFromM").style.display = "block";
		     		 		document.getElementById("deptNameFromM").style.display = "block";
		     		 		document.getElementById("deptManagerFromM").style.display = "block";
		     		 		document.getElementById("divMgrNameFromM").style.display = "block";
		     		 		document.getElementById("ManPowerRep").style.display = "block";
		     		 	}
				}
      	else {
      	 $("#managerAssociatedropdown").hide();
         $("#<portlet:namespace/>mgrassociateNo").val('');
		     		 document.getElementById("deptNumber").style.display = "none";
		     		 document.getElementById("DivisionFromM").style.display = "none";
		     		 document.getElementById("deptNameFromM").style.display = "none";
		     		 document.getElementById("deptManagerFromM").style.display = "none";
		     		 document.getElementById("divMgrNameFromM").style.display = "none";
		     		 document.getElementById("ManPowerRep").style.display = "none";     		
      	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
      	 A.io.request('<%=resourceURL.toString()%>',{  
      	 dataType: 'json', 
      	 method: 'GET',   
      	 data:
      	 { 
      		 <portlet:namespace/>pidvalue: pidvalue,
      		 <portlet:namespace/>cmd: "getPositionDetailsURL"
      		 
      		 },   
      	 on: {    
      		 	success: function() { 
      			var data=this.get('responseData');
				console.log(data);
      			$('#deptNAME').html(data.deptName);
      			$('#newDeptNUmber1').html(data.deptNumber);
      			$('#Division').html(data.division);
      			$('#ManagerAssociateTitle').html(data.ManagerAssociateTitle);
      			$('#ManagerAssociateName').html(data.ManagerAssociateName);
      			$('#leadershipassignment').html(data.leadershipassignment);
      			$('#managerAssociateNumber').html(data.managerAssociateNumber);
      			$('#deptManager').html(data.deptManager);
      			$('#divMgrName').html(data.divMgrName);
      			$('#employeecategoryNew').html(data.employeecategory);
				document.getElementById("NewPOS").style.display = "block";
				document.getElementById("Division").style.display = "block";
				document.getElementById("deptNAME").style.display = "block";
				document.getElementById("deptManager").style.display = "block";
				document.getElementById("divMgrName").style.display = "block";
				document.getElementById("newDeptNUmber1").style.display = "block";
				document.getElementById("leadershipassignment").style.display = "block";
				document.getElementById("managerAssociateNumber").style.display = "block";
				document.getElementById("ManagerAssociateName").style.display = "block";
				document.getElementById("ManagerAssociateTitle").style.display = "block";
				}   
      			 }
      		 });
      	 });
      	}
       } 
      function fetchPositionOnAssTitle11(){  
      	var departmentNumber=$("#<portlet:namespace/>assiateTitle").val();
      	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
      	 A.io.request('<%=resourceURL.toString()%>',{  
      	 dataType: 'json', 
      	 method: 'GET',   
      	 data:
      	 { 
      		 <portlet:namespace/>departmentNumber: departmentNumber ,
      		 <portlet:namespace/>cmd: "cmdassocitaetitle" 
      		 
      		 },   
      	 on: {    
      		success: function() {
      	 var data=this.get('responseData');
      	 		$('#leadershipassignment').html(data.LEADERSHIP_ASSIGNMENT);	
      			$('#shiftcode11').html(data.SHIFT_CODE);
      			$('#teamnumber11').html(data.TEAM_NUMBER);
      			
      			$('#division').html(data.Division);
      			$('#deptmanagerforDeptName').html(data.Manager);
      			$('#divisionmgrnameforDeptName').html(data.Name);
      			$('#deptName').html(data.Department);
      	 }   
      	 }
      	 });
      	 }); 
      	 } 
    jQuery(document).ready(function(){
    jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
    });
    function leaderShipValidation(){
    	 var associateTitleforNewPos=$("#<portlet:namespace/>newAssociateTitle").val();
      	 var positionNo=$("#<portlet:namespace/>pId").val();
      	 var deptNo=$("#<portlet:namespace/>divdeptRest").val();
      	 var LeaderShip=$("#<portlet:namespace/>LeaderShip").val();
      	if(associateTitleforNewPos == ""){
      	}
      	else if(associateTitleforNewPos == 'PA' || associateTitleforNewPos == 'TC'){
   		 if(deptNo == "" && LeaderShip == ""){
   			$("#msgForAssociateNumber").show();
   			document.getElementById('<portlet:namespace/>hidden_field').value=''; 
   		 }else if (deptNo==""){
   		}
   		 else{
   		}
   	 }
    }
  
    </aui:script>
    <% if(wfmsCOS==null){ %>
    <aui:script>
	$( document ).ready(function() {
    	document.getElementById("UpdatePO").style.display = "none";
    	 console.log('Manager');
    	document.getElementById("NewPOS").style.display = "none";
    	 document.getElementById("Division").style.display = "none";
    	 document.getElementById("deptNAME").style.display = "none";
    	 document.getElementById("deptManager").style.display = "none";
    	 document.getElementById("divMgrName").style.display = "none";
    	  document.getElementById("newDeptNUmber1").style.display = "none";
    	  console.log('divMgr');
    	 document.getElementById("leadershipassignment").style.display = "none";
    	 document.getElementById("managerAssociateNumber").style.display = "none";
    	 document.getElementById("ManagerAssociateName").style.display = "none";
    	 console.log('Manager');
    	 document.getElementById("ManagerAssociateTitle").style.display = "none";
    	});
    </aui:script>
    <% } else { %>
    <aui:script>
    $( document ).ready(function() {
  	  //var pidvalue=$("#<portlet:namespace/>pId").val();
  	  var associateTitle=$("#<portlet:namespace/>newAssociateTitle").val();
  	  var positionId = "<%=wfmsCOS.getPositionNumber() %>";
  	  
  	  if(positionId != ""){
  		$('#<portlet:namespace/>newpositionId').val('<%=wfmsCOS.getPositionNumber() %>');  		
  	  }
     
			if(associateTitle == 'PA' || associateTitle == 'TC'){
			 document.getElementById("MgrAssNo").style.display = "block";
			 document.getElementById("NewPOS").style.display = "none";
			 document.getElementById("Division").style.display = "none";
			 document.getElementById("deptNAME").style.display = "none";
			 document.getElementById("deptMgrName").style.display = "none";
			 document.getElementById("divMgrName").style.display = "none";
			 document.getElementById("deptNumberFromPosition").style.display = "none";
			 document.getElementById("leadershipassignment").style.display = "none";
			 document.getElementById("managerAssociateNumber").style.display = "none";
			// document.getElementById("ManagerAssociateName").style.display = "none";
			// document.getElementById("ManagerAssociateTitle").style.display = "none";
			
			}
			else{ 
				if(positionId == "None"){
				 document.getElementById("MgrAssNo").style.display = "none";
				 document.getElementById("NewPOS").style.display = "block";
				 document.getElementById("Division").style.display = "none";
				 document.getElementById("deptNAME").style.display = "none";
				 document.getElementById("deptMgrName").style.display = "none";
				 document.getElementById("divMgrName").style.display = "none";
				 document.getElementById("deptNumberFromPosition").style.display = "none";
				// document.getElementById("leadershipassignment").style.display = "none";
				 document.getElementById("managerAssociateNumber").style.display = "none";
			////	 document.getElementById("ManagerAssociateName").style.display = "none";
			//	 document.getElementById("ManagerAssociateTitle").style.display = "none";
				 document.getElementById("UpdatePO").style.display = "none";
				 document.getElementById("deptNumber").style.display = "block";
				 document.getElementById("DivisionFromM").style.display = "block";
				 document.getElementById("deptNameFromM").style.display = "block";
				 document.getElementById("deptManagerFromM").style.display = "block";
				 document.getElementById("divMgrNameFromM").style.display = "block";
				document.getElementById("UpdatePO").style.display = "none";
				}else if(positionId != ""){
				if($("#<portlet:namespace/>pId").val() == "None"){
				document.getElementById("deptNumber").style.display = "block";	
				document.getElementById("deptNumberFromPosition").style.display = "none";
				}else{	
				document.getElementById("deptNumber").style.display = "none";
				document.getElementById("deptNumberFromPosition").style.display = "block";
				}
				 document.getElementById("DivisionFromM").style.display = "none";
				 document.getElementById("deptNameFromM").style.display = "none";
				 document.getElementById("deptManagerFromM").style.display = "none";
				 document.getElementById("divMgrNameFromM").style.display = "none";
				document.getElementById("UpdatePO").style.display = "none";
					
			}else{
				if($("#<portlet:namespace/>pId").val() == "None"){
					document.getElementById("deptNumberFromPosition").style.display = "none";	
					document.getElementById("deptNumber").style.display = "block";	
				}else{	
				document.getElementById("deptNumber").style.display = "none";
				document.getElementById("deptNumberFromPosition").style.display = "block";
				}
				 document.getElementById("DivisionFromM").style.display = "none";
				 document.getElementById("deptNameFromM").style.display = "none";
				 document.getElementById("deptManagerFromM").style.display = "none";
				 document.getElementById("divMgrNameFromM").style.display = "none";
				document.getElementById("UpdatePO").style.display = "none";
			}
			}
	});
    </aui:script>
    <% } %>
<script>
    <%if(wfmsCOS!=null){ %>

    $(document).ready(function(){
    	var associaNumber=$("#<portlet:namespace/>associaNumber").val();
	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
	 A.io.request('<%=AssNumURL%>',{  
	 dataType: 'json', 
	 method: 'GET',   
	 data:
	 { 
		 		 <portlet:namespace />associateID: associaNumber,
		 },   
	 on: {    
		 success: function() {
			var data=this.get('responseData');
		$('#<portlet:namespace/>associateDateOfHire').val(data.ASSOCIATE_DATE_OF_HIRE);
			<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2 && wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_DRAFT)) { %>

             $('#associateName').html(data.ASSOCIATE_NAME);
			<% if(Validator.isNotNull(wfmsCOS.getCurrentJobCode())){%>
			     $('#associateTitle').html("<%=wfmsCOS.getCurrentJobCode()%>");
			<%}else{ %>
			    $('#associateTitle').html(data.ASSOCIATE_TITLE);
			<% } %>
			if(!(data.positionId === undefined || data.positionId.length <= 0)){
				
			$('#positionId').html(data.positionId);
			$('#<portlet:namespace/>newpositionId').val(''+data.positionId+'');
			}
			$('#DIVISION').html(data.DIVISION);
			$('#DIVISION_MANAGER').html(data.DIVISION_MANAGER);
			$('#DEPT_NAME').html(data.DEPT_NAME);
			$('#DEPT_NUMBER').html(data.DEPT_NUMBER);
			$('#DEPT_MANAGER').html(data.DEPARTMENT_MANAGER);
				
			<%  if(Validator.isNotNull(wfmsCOS.getCurrentTeamNumber())){ %>
			     $('#teamNumber').html("<%=wfmsCOS.getCurrentTeamNumber()%>");
			    <%}else{ %>
			       $('#teamNumber').html(data.TEAM_NUMBER);
			    <% } %>
			    
			    <% if(Validator.isNotNull(wfmsCOS.getTeamNumber())){ %>
			    $('#<portlet:namespace/>teamNumber').val("<%=wfmsCOS.getTeamNumber()%>");
			    <%}else if(Validator.isNotNull(wfmsCOS.getCurrentTeamNumber())){ %>
			    $('#<portlet:namespace/>teamNumber').val("<%=wfmsCOS.getCurrentTeamNumber()%>");
			    <%}else{ %>
			       $('#<portlet:namespace/>teamNumber').val(data.TEAM_NUMBER);
			    <% } %>
			    <% if(Validator.isNotNull(wfmsCOS.getCurrentShiftCode())){ %>
				      $('#shiftcode').html("<%=wfmsCOS.getCurrentShiftCode()%>");
			    <%}else{ %> 
				       $('#shiftcode').html(data.SHIFT_CODE);
			    <% } %>
		
			    <% if(Validator.isNotNull(wfmsCOS.getShiftCode())){ %>
			      $('#<portlet:namespace/>shiftCode').val("<%=wfmsCOS.getShiftCode()%>");
		    <%}else if(Validator.isNotNull(wfmsCOS.getCurrentShiftCode())){ %>
		        $('#<portlet:namespace/>shiftCode').val("<%=wfmsCOS.getCurrentShiftCode()%>");
		    <%}else{ %>
			       $('#<portlet:namespace/>shiftCode').val(data.SHIFT_CODE);
		    <% } %>
          
			$('#mgrassociateno').html(data.MANAGER_ASSOCIATE_NUMBER);
  			$('#mgrName').html(data.DEPT_MANAGER);
  			$('#mgrTitle').html(data.DEPT_MANAGER_TITLE);
  			$('#associatedateofhire').html(data.ASSOCIATE_DATE_OF_HIRE);
			
			$('#<portlet:namespace/>associateDateOfHire').val(data.ASSOCIATE_DATE_OF_HIRE);
  			$('#Division').html(data.DIVISION);
  			$('#divMgrName').html(data.DIVISION_MANAGER);
  			$('#deptNAME').html(data.DEPT_NAME);
  			$('#deptNumberFromPosition').html(data.DEPT_NUMBER);
  			$('#deptManager').html(data.DEPARTMENT_MANAGER);
  			$('#managerAssociateNumber').html(data.MANAGER_ASSOCIATE_NUMBER);
  			$('#ManagerAssociateName').html(data.DEPT_MANAGER);
  			$('#ManagerAssociateTitle').html(data.DEPT_MANAGER_TITLE);
  			$('#newleadershipassignment').html("<%=wfmsCOS.getLeadershipAssignment()%>");
  		   $('#<portlet:namespace/>currentJobCode').val(data.ASSOCIATE_TITLE);
  			if(!(data.positionId === undefined || data.positionId.length <= 0)){
 			$('#<portlet:namespace/>currentPositionNumber').val(''+data.positionId+'');
  			}
 			$('#<portlet:namespace/>currentDivision').val(data.DIVISION);
 			$('#<portlet:namespace/>currentDivisionManager').val(data.DIVISION_MANAGER);
 			$('#<portlet:namespace/>currentDepartmentName').val(data.DEPT_NAME);
 			$('#<portlet:namespace/>currentDepartmentNumber').val(data.DEPT_NUMBER);	
 			$('#<portlet:namespace/>currentManagerName').val(data.DEPT_MANAGER);
 			$('#<portlet:namespace/>currentTeamNumber').val(data.TEAM_NUMBER);
 			$('#<portlet:namespace/>currentShiftCode').val(data.SHIFT_CODE);
 			$('#<portlet:namespace/>currentManagerAssocNumber').val(data.MANAGER_ASSOCIATE_NUMBER);
 			$('#<portlet:namespace/>currentDepartmentManager').val(data.DEPARTMENT_MANAGER);
 			$('#<portlet:namespace/>currentManagerTitle').val(data.DEPT_MANAGER_TITLE);
 			$('#<portlet:namespace/>currentManpowerRep').val(data.MANPOWER_REP);
			
  			$('#<portlet:namespace/>associateDateOfHire').val(data.ASSOCIATE_DATE_OF_HIRE);
  			$('#associatedateofhire').html(data.ASSOCIATE_DATE_OF_HIRE);
  			$('#manpowerreq').html(data.ManpowerRep);
  			
  			<%}%>  			
				 }   
			 } 
		 });
	 }); 
   } );
    <% } else if(associateID!=null && associateIdForExistingRecord==""){ %>

    $('#msgForTitle').show();
    $(document).ready(function(){
	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
	 A.io.request('<%=AssNumURL%>',{  
	 dataType: 'json', 
	 method: 'GET',   
	 data:
	 { 
		 		 <portlet:namespace />associateID: '<%=associateID %>',
		 },   
	 on: {    
		 success: function() {
			var data=this.get('responseData');
			$('#associateName').html(data.ASSOCIATE_NAME);
			$('#associateTitle').html(data.ASSOCIATE_TITLE);
			if(!(data.positionId === undefined || data.positionId.length <= 0)){
			   $('#positionId').html(data.positionId);
			   $('#<portlet:namespace/>newpositionId').val(''+data.positionId+'');
			}
			$('#DIVISION').html(data.DIVISION);
			$('#DIVISION_MANAGER').html(data.DIVISION_MANAGER);
			$('#DEPT_NAME').html(data.DEPT_NAME);
			$('#DEPT_NUMBER').html(data.DEPT_NUMBER);
			$('#DEPT_MANAGER').html(data.DEPARTMENT_MANAGER);
			$('#teamNumber').html(data.TEAM_NUMBER);
			$('#shiftcode').html(data.SHIFT_CODE);
			$('#mgrassociateno').html(data.MANAGER_ASSOCIATE_NUMBER);
  			$('#mgrName').html(data.DEPT_MANAGER);
  			$('#mgrTitle').html(data.DEPT_MANAGER_TITLE);
  			$('#associatedateofhire').html(data.ASSOCIATE_DATE_OF_HIRE);
  			$('#manpowerreq').html(data.ManpowerRep);
  			$('#<portlet:namespace/>associateDateOfHire').val(data.ASSOCIATE_DATE_OF_HIRE);
  			$('#<portlet:namespace/>currentJobCode').val(data.ASSOCIATE_TITLE);
  			if(!(data.positionId === undefined || data.positionId.length <= 0)){
 			$('#<portlet:namespace/>currentPositionNumber').val(''+data.positionId+'');
  			}
 			$('#<portlet:namespace/>currentDivision').val(data.DIVISION);
 			$('#<portlet:namespace/>currentDivisionManager').val(data.DIVISION_MANAGER);
 			$('#<portlet:namespace/>currentDepartmentName').val(data.DEPT_NAME);
 			$('#<portlet:namespace/>currentDepartmentNumber').val(data.DEPT_NUMBER);	
 			$('#<portlet:namespace/>currentManagerName').val(data.DEPT_MANAGER);
 			$('#<portlet:namespace/>currentTeamNumber').val(data.TEAM_NUMBER);
 			$('#<portlet:namespace/>currentShiftCode').val(data.SHIFT_CODE);
 			
 			if(wfmsCOS.getSystemGenerated() != 2){
 				
 				if(data.LEADERSHIP_ASSIGNMENT == ""){
 	    			$('#leader-assignment').html("None");	
 	    		}else{
 	    			$('#leader-assignment').html(data.LEADERSHIP_ASSIGNMENT);
 	    		}
	 			if(data.LEADERSHIP_ASSIGNMENT == ""){
	 			$('#<portlet:namespace/>currentLeadershipAssignment').val("None");	
	 			}else{
	 			$('#<portlet:namespace/>currentLeadershipAssignment').val(data.LEADERSHIP_ASSIGNMENT);
	 			}
 			}
 			$('#<portlet:namespace/>currentManagerAssocNumber').val(data.MANAGER_ASSOCIATE_NUMBER);
 			$('#<portlet:namespace/>currentDepartmentManager').val(data.DEPARTMENT_MANAGER);
 			$('#<portlet:namespace/>currentManagerTitle').val(data.DEPT_MANAGER_TITLE);
 			$('#<portlet:namespace/>currentManpowerRep').val(data.MANPOWER_REP);
				 }   
			 } 
		 });
	 }); 
//	 $('html, body').animate({scrollTop: $("#current_position").offset().top}, 100);
	 document.getElementById("<portlet:namespace/>newAssociateTitle").disabled = false; 
	   $(".chosenAssociateTitle").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	    
    } );
    <% } else if(associateID!=null && associateIdForExistingRecord!="") { %>

	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
	 A.io.request('<%=AssNumURL%>',{  
	 dataType: 'json', 
	 method: 'GET',   
	 data:
	 { 
		 		 <portlet:namespace />associateID: '<%=associateID %>',
		 },   
	 on: {    
		 success: function() {
			var data=this.get('responseData');
			$('#associateName').html(data.ASSOCIATE_NAME);
			$('#associateTitle').html(data.ASSOCIATE_TITLE);
			if(!(data.positionId === undefined || data.positionId.length <= 0)){
				$('#positionId').html(data.positionId);
				//alert(data.positionId);
				$('#<portlet:namespace/>newpositionId').val(''+data.positionId+'');
			}
			$('#DIVISION').html(data.DIVISION);
			$('#DIVISION_MANAGER').html(data.DIVISION_MANAGER);
			$('#DEPT_NAME').html(data.DEPT_NAME);
			$('#DEPT_NUMBER').html(data.DEPT_NUMBER);
			$('#DEPT_MANAGER').html(data.DEPARTMENT_MANAGER);
			$('#teamNumber').html(data.TEAM_NUMBER);
			$('#shiftcode').html(data.SHIFT_CODE);
			if(data.LEADERSHIP_ASSIGNMENT == ""){
     			$('#leader-assignment').html("None");	
     		}else{
     			$('#leader-assignment').html(data.LEADERSHIP_ASSIGNMENT);
     		}
			$('#mgrassociateno').html(data.MANAGER_ASSOCIATE_NUMBER);
  			$('#mgrName').html(data.DEPT_MANAGER);
  			$('#mgrTitle').html(data.DEPT_MANAGER_TITLE);
  			$('#associatedateofhire').html(data.ASSOCIATE_DATE_OF_HIRE);
			
  			$('#<portlet:namespace/>associateDateOfHire').val(data.ASSOCIATE_DATE_OF_HIRE);
  				 }   
			 } 
		 });
    } );
    
    <%} %>
   function saveonworkflow(value){
      // console.log(value);
     $("#<portlet:namespace/>saveonworkflow").val(value);
    } 
   function modifyFunction()
   {
	    document.getElementById("<portlet:namespace/>newAssociateTitle").disabled = false; 
	    var newAssociateTitle=$("#<portlet:namespace/>newAssociateTitle").val();
	    $(".chosenAssociateTitle").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	       document.getElementById("<portlet:namespace/>LeaderShip").disabled = false;
		   document.getElementById("<portlet:namespace/>shiftCode").disabled = false;
		   $(".chosenShiftcode").data("placeholder","Select Frameworks...").chosen({search_contains:true});
		   document.getElementById("<portlet:namespace/>teamNumber").disabled = false;
		   $(".chosenTitle").data("placeholder","Select Frameworks...").chosen({search_contains:true});
		   document.getElementById("<portlet:namespace/>actionCodeID").disabled = false;
		   document.getElementById("<portlet:namespace/>chgDesc").disabled = false;
		   document.getElementById("<portlet:namespace/>manpower-catogiry").disabled = false;
		   document.getElementById("<portlet:namespace/>startDate").disabled = false;
		   document.getElementById("<portlet:namespace/>reasoncode").disabled = false;	 
		var shiftCode=$("#<portlet:namespace/>shiftCode").val();
		var teamNumber=$("#<portlet:namespace/>teamNumber").val();
		var actionCodeID=$("#<portlet:namespace/>actionCodeID").val();
		var startDate=$("#<portlet:namespace/>startDate").val();
		var manpowerCategory=$("#<portlet:namespace/>manpower-catogiry").val();
		var chgDesc=$("#<portlet:namespace/>chgDesc").val();
		var LeaderShip=$("#<portlet:namespace/>LeaderShip").val();
		var reasoncode=$("#<portlet:namespace/>reasoncode").val();
		var deptNo=$("#<portlet:namespace/>divdeptRest").val();
			<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) { %>
				      $("#msgForShiftCode").hide();
			              $("#msgForTeamNumber").hide();
                        <% }else{ %>
			            if(shiftCode=="")    
                           $("#msgForShiftCode").show();
			            if(teamNumber=="")    
	                        $("#msgForTeamNumber").show();
                        <% } %>
                        
                        if(newAssociateTitle==""){
                        	$("#msgForTitle").show();
                        }
                        var pId =$("#<portlet:namespace/>pId").val();
                        if(newAssociateTitle!="PA" && newAssociateTitle!="TC" && newAssociateTitle!=""){
                        	document.getElementById("<portlet:namespace/>pId").disabled = false;
                		    $(".chosenPId").data("placeholder","Select Frameworks...").chosen({search_contains:true}); 
                           var pId =$("#<portlet:namespace/>pId").val();
                           if(pId==""){
                        	   $("#msgForPosition").show(); 
                           }
                            if(pId == 'None'){
                                    $("#managerAssociatedropdown").show();
                                    $("#managerAssociateNumber").hide();
                                    document.getElementById("<portlet:namespace/>mgrassociateNo").disabled = false;
                                     $(".chosenAssociateNumber").data("placeholder","Select Frameworks...").chosen({search_contains:true});
                                        if($("#<portlet:namespace/>mgrassociateNo").val()==''){
                                             $("#msgFormanagerAssociateNumber").show();
                                              $("#ManagerAssociateName").html("");
                                              $("#ManagerAssociateTitle").html("");
                                         }else{
                                             $("#msgFormanagerAssociateNumber").hide();
                                             $("#ManagerAssociateName").show();
                                             $("#ManagerAssociateTitle").show();
                                          }
                                    }
                        }
                        if(newAssociateTitle=="PA" || newAssociateTitle=="TC" || newAssociateTitle=="" || (pId=="None" &&  newAssociateTitle!="")){
                        	document.getElementById("<portlet:namespace/>divdeptRest").disabled = false; 
                		    $(".chosenDivdeptRest").data("placeholder","Select Frameworks...").chosen({search_contains:true}); 
                        	var deptNumber=$("#<portlet:namespace/>divdeptRest").val();
                        	<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() != 2 && wfmsCOS.getSystemGenerated() != 1) { %>
                        	     $("#managerAssociatedropdown").show();
                                 $("#managerAssociateNumber").hide();
                                 document.getElementById("<portlet:namespace/>mgrassociateNo").disabled = false;
                                 
                                  $(".chosenAssociateNumber").data("placeholder","Select Frameworks...").chosen({search_contains:true});
                                if($("#<portlet:namespace/>mgrassociateNo").val()==''){
                                     $("#msgFormanagerAssociateNumber").show();
                                      $("#ManagerAssociateName").html("");
                                      $("#ManagerAssociateTitle").html("");
                                 }else{
                                     $("#msgFormanagerAssociateNumber").hide();
                                     $("#ManagerAssociateName").show();
                                     $("#ManagerAssociateTitle").show();
                                  }
<%}%>
            				var departmentDisplay = document.getElementById("deptNumber");
	              		 	if(departmentDisplay.style.display == "block") {
	                        	if(deptNumber==""){
			                        $("#msgForsameDept").show();
	                            }
	                        }
                        }
                        if(startDate=="")
                        	$("#msgForEffectiveDate").show();
                        if(actionCodeID=="")    
                        	$("#msgForActionCode").show();
                        if(manpowerCategory=="")    
                        	$("#msgForManpower").show();
                        if(chgDesc=="")    
                        	$("#msgForchgDesc").show();
                        if(reasoncode=="")    
                        	$("#msgForreasonCODE").show();
		 
                        document.getElementById("announced1").disabled = false;
              		   document.getElementById("announced2").disabled = false;
	   $("#<portlet:namespace/>submitButton").removeAttr( "disabled", "disabled");
	   $("#<portlet:namespace/>submitButton").removeClass( "btn disabled" ).addClass( "btn" );
	   $("#<portlet:namespace/>saveButton").removeAttr( "disabled", "disabled");
	   $("#<portlet:namespace/>saveButton").removeClass( "btn disabled" ).addClass( "btn" );
   }
   function validateAssociateNumber(){
	   associatNumbervalidate();
	   var associateNumber=$("#<portlet:namespace/>associaNumber").val();
	   var msgForTitle= document.getElementById("msgForTitle");
	   msgForTitle.innerHTML ='';
	    $.ajax({
	    		url : '<%=resourceURL.toString()%>',
				data : {
					<portlet:namespace />associateNumber : associateNumber,
					<portlet:namespace />cmd : 'getAssociateNum'
				},

				type : "POST",
				dataType : "json",
				success : function(data) {
					$('#associateNumber').html(data.error);	
					if(data.error==true)
						{
						  document.getElementById('<portlet:namespace />addWFMSCOS').submit();
						}
					else
					{
						  document.getElementById("<portlet:namespace/>newAssociateTitle").disabled = false;
					      $(".chosenAssociateTitle").data("placeholder","Select Frameworks...").chosen({search_contains:true});
						  document.getElementById('<portlet:namespace />addWFMSCOS').submit();
					}
				},
				error : function(response) {
		        	console.log("Error seen for for loadDivisonDepName");
				}
			});
	    }
   </script>    
  <aui:script>
  function loadAssociateTitleforNewPosUpdate(){
    <% if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){ %>
	 newAssociateTitlevalidate();
	<% }else{ %>
     	var associateTitleforNewPos=$("#<portlet:namespace/>newAssociateTitle").val();
     	newAssociateTitlevalidate();
     	var deptNo=$("#<portlet:namespace/>divdeptRest").val();
     	 var pidvalue=$("#<portlet:namespace/>pId").val();
     	 if(associateTitleforNewPos == ""){
     		  $('#Division').html("");
     		  $('#deptNAME').html("");
     		  $('#deptMgrName').html("");
     		  $('#divMgrName').html("");
     		  $('#deptNumberFromPosition').html("");
     		  $('#leadershipassignment').html("");
     		  $('#managerAssociateNumber').html("");
     		  $('#ManagerAssociateName').html("");
     		  $('#ManagerAssociateTitle').html("");
     		  $('#DivisionFromM').html("");
     		  $('#deptNameFromM').html("");
     		  $('#deptManagerFromM').html("");
     		  $('#divMgrNameFromM').html("");
     		  $('#ManPowerRep').html(""); 
     		  $('#employeecategoryNew').html(""); 
 		 }
         else if(associateTitleforNewPos == 'TC' || associateTitleforNewPos == 'PA'){
                            $("#managerAssociatedropdown").show();
                            $("#<portlet:namespace/>mgrassociateNo_chosen").show();
                            if($("#<portlet:namespace/>mgrassociateNo").val()=="")
                               $("#msgFormanagerAssociateNumber").show();
                               
                               $("#managerAssociateNumber").hide();
                              document.getElementById("<portlet:namespace/>mgrassociateNo").disabled = false;
                              $(".chosenAssociateNumber").data("placeholder","Select Frameworks...").chosen({search_contains:true});
                            $("#<portlet:namespace/>mgrassociateNo option:selected").removeAttr("selected"); 
                            $('.chosenAssociateNumber').trigger('chosen:updated');
                             $("#Division").hide();
                             $("#deptNAME").hide();
                             $("#deptMgrName").hide();
                             $("#divMgrName").hide();
                             $("#deptNumberFromPosition").hide();
                             $("#leadershipassignment").hide();
                             $("#managerAssociateNumber").hide();
                              $("#ManagerAssociateName").html("");
                             $("#ManagerAssociateTitle").html("");
                             $('#employeecategoryNew').html(""); 
                             if(deptNo == ""){
                               $('#DivisionFromM').html("");
                               $('#deptNameFromM').html("");
                               $('#deptManagerFromM').html("");
                               $('#divMgrNameFromM').html("");
                               $('#ManPowerRep').html("");
                               $('#employeecategoryNew').html("");
                             }else{
                                $("#DivisionFromM").show();
                                $("#deptNameFromM").show();
                                $("#deptManagerFromM").show();
                                $("#divMgrNameFromM").show();
                                $("#ManPowerRep").show();
                                $('#employeecategoryNew').html(""); 
                             }
   		 	$(".chosenDivdeptRest").data("placeholder","Select Frameworks...").chosen({search_contains:true});			
     	}else {
               $("#<portlet:namespace/>divdeptRest option:selected").removeAttr("selected"); 
               $("#DivisionFromM").html("");
               $("#divMgrNameFromM").html("");
               $("#deptNameFromM").html("");
               $("#deptManagerFromM").html("");
               $('.chosenDivdeptRest').trigger('chosen:updated');
                 $("#deptNumber").hide();
                 $("#msgForsameDept").hide();
                 $("#<portlet:namespace/>mgrassociateNo option:selected").removeAttr("selected"); 
                $("#ManagerAssociateName").html("");
                $("#ManagerAssociateTitle").html("");
                 $('#managerAssociateNumber').html("");
                $('.chosenAssociateNumber').trigger('chosen:updated');
     	       $("#managerAssociatedropdown").hide();
                $("#<portlet:namespace/>mgrassociateNo_chosen").hide();
                $("#msgFormanagerAssociateNumber").hide();
                document.getElementById("<portlet:namespace/>mgrassociateNo").disabled = true;
                 document.getElementById("NewPOS").style.display = "block";
     		document.getElementById("UpdatePO").style.display = "none";
     	        if(associateTitleforNewPos != 'Select Associate' && pidvalue == 'None'){
				document.getElementById("Division").style.display = "none";
				document.getElementById("deptNAME").style.display = "none";
				document.getElementById("deptMgrName").style.display = "none";
				document.getElementById("divMgrName").style.display = "none";
				document.getElementById("deptNumberFromPosition").style.display = "none";
				document.getElementById("leadershipassignment").style.display = "none";
				document.getElementById("managerAssociateNumber").style.display = "none";
				document.getElementById("ManagerAssociateName").style.display = "none";
				document.getElementById("ManagerAssociateTitle").style.display = "none";
			} else {
				if(pidvalue == ""){
					 $('#Division').html("");
	        		  $('#deptNAME').html("");
	        		  $('#deptMgrName').html("");
	        		  $('#divMgrName').html("");
	        		  $('#deptNumberFromPosition').html("");
	        		  $('#leadershipassignment').html("");
	        		  $('#managerAssociateNumber').html("");
	        		  $('#ManagerAssociateName').html("");
	        		  $('#ManagerAssociateTitle').html("");
	        		  $('#employeecategoryNew').html("");
				}else{
				document.getElementById("MgrAssNo").style.display = "none";
				document.getElementById("deptNumber").style.display = "none";
				var positionDisplay = document.getElementById("NewPOS");
				var departmentDisplay = document.getElementById("deptNumber");
  		 	if(positionDisplay.style.display == "block") {
				 document.getElementById("Division").style.display = "block";
				 document.getElementById("deptNAME").style.display = "block";
				 document.getElementById("deptMgrName").style.display = "block";
				 document.getElementById("divMgrName").style.display = "block";
				 document.getElementById("deptNumberFromPosition").style.display = "block";
				 document.getElementById("leadershipassignment").style.display = "block";
				 document.getElementById("managerAssociateNumber").style.display = "block";
				 document.getElementById("ManagerAssociateName").style.display = "block";
				 document.getElementById("ManagerAssociateTitle").style.display = "block";
  		 	}if(departmentDisplay.style.display == "none"){
  		 		document.getElementById("DivisionFromM").style.display = "none";
  		 		document.getElementById("deptNameFromM").style.display = "none";
  		 		document.getElementById("deptManagerFromM").style.display = "none";
  		 		document.getElementById("divMgrNameFromM").style.display = "none";
  		 		document.getElementById("ManPowerRep").style.display = "none";
  		 	}}}
		 	 $(".chosenPId").data("placeholder","Select Frameworks...").chosen({search_contains:true}); 
     	}var currentpositionnumber= document.getElementById("positionId").innerHTML;
		 if(associateTitleforNewPos != "PA" && associateTitleforNewPos != "TC" && currentpositionnumber != "" && associateTitleforNewPos.trim()!=""){
				$.ajax({
			    		url : '<%=resourceURL.toString()%>',
						data : {
							<portlet:namespace />assotiletitle : associateTitleforNewPos,
							<portlet:namespace />currentpositionnumber : currentpositionnumber ,
							<portlet:namespace />cmd : 'assiateTitleshowalert'
						},
						type : "POST",
						dataType : "json",
						success : function(data) {
							currentPosTextVal=data.flagshow;
							console.log(data.flagshow+"test");
							if(!data.flagshow) {
								getAuiAsTitlePopup();
							}	
						},
						error : function(response) {
				        	console.log("Error seen for show pop on assotiletitle validating");
						}
				 });
		 }  
     	<% } %>
  }
  function updateValuesForSelectedDepartmentManage(){
		 validateDeptNumber();
		var Deptid=$("#<portlet:namespace/>divdeptRest").val();
		 var pidvalue=$("#<portlet:namespace/>pId").val();
		 var associateTitleforNewPos=$("#<portlet:namespace/>newAssociateTitle").val();
		 $('#DivisionFromM').html("");
		  $('#deptNameFromM').html("");
		  $('#deptManagerFromM').html("");
		  $('#divMgrNameFromM').html("");
		  $('#ManPowerRep').html("");
		if(Deptid == ""){
			 $('#DivisionFromM').html("");
			  $('#deptNameFromM').html("");
			  $('#deptManagerFromM').html("");
			  $('#divMgrNameFromM').html("");
			  $('#ManPowerRep').html("");
			
		}else{
			var Deptid = Deptid.split("-");
			for (var i=0;i< Deptid.length;i++)
			 {
			     var Deptid = Deptid[i].split(" ");
			 }
			 var Deptid = Deptid[0];
	    $.ajax({  
	    		url : '<%=resourceURL.toString()%>',
				data : {
					<portlet:namespace />Deptid : Deptid,
					<portlet:namespace />cmd : 'LoadDivisionNames'
				},
				type : "POST",
				dataType : "json",
				success : function(data) {
					console.log(data);
					$('#DivisionFromM').html(data.Division);
					$('#deptNameFromM').html(data.deptNAME);
					$('#deptManagerFromM').html(data.deptMgrName);
					$('#divMgrNameFromM').html(data.divMgrName);
					$('#ManPowerRep').html(data.MANPOWER_REP);
					  document.getElementById("deptNumber").style.display = "block";
					  document.getElementById("DivisionFromM").style.display = "block";
					  document.getElementById("deptNameFromM").style.display = "block";
					  document.getElementById("deptManagerFromM").style.display = "block";
					  document.getElementById("divMgrNameFromM").style.display = "block";
					  document.getElementById("ManPowerRep").style.display = "block";
					  document.getElementById("Division").style.display = "none";
					  document.getElementById("deptNAME").style.display = "none";
					  document.getElementById("deptMgrName").style.display = "none";
					  document.getElementById("divMgrName").style.display = "none";
					  document.getElementById("deptNumberFromPosition").style.display = "none";
					  document.getElementById("leadershipassignment").style.display = "none";
					  document.getElementById("managerAssociateNumber").style.display = "none";
					  document.getElementById("ManagerAssociateName").style.display = "block";
					  document.getElementById("ManagerAssociateTitle").style.display = "block";
				},
				error : function(response) {
		        	console.log("Error seen for for loadDivisonDepName");
				}
			});
		}
		}
  function loadPosIdForUpdate(){
      var pidvalue=$("#<portlet:namespace/>pId").val();
      <% if(!(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 1)){ %>
      positionnumberrvalidate();
      validateDeptNumber();
      <% } %>
      <%if(Validator.isNotNull(wfmsCOS) && !wfmsCOS.getPositionNumber().equalsIgnoreCase("")){%>
		$('#<portlet:namespace/>newpositionId').val('<%=wfmsCOS.getPositionNumber()%>');
		<%}else if(Validator.isNotNull(wfmsCOS) && wfmsCOS.getSystemGenerated() == 1){%>
		$('#<portlet:namespace/>newpositionId').val('');
		<%}else{%>
		$('#<portlet:namespace/>newpositionId').val(''+pidvalue+'');
		<%}%>
                  $('#Division').html("");
		  $('#deptNAME').html("");
		  $('#deptMgrName').html("");
		  $('#divMgrName').html("");
		  $('#deptNumberFromPosition').html("");
		  $('#leadershipassignment').html("");
		  $('#managerAssociateNumber').html("");
		  $('#ManagerAssociateName').html("");
		  $('#ManagerAssociateTitle').html("");
		  $('#employeecategoryNew').html("");
      	        if(pidvalue=="None"){
                    $("#managerAssociatedropdown").show();
                    $("#<portlet:namespace/>mgrassociateNo_chosen").show();
                    $("#managerAssociateNumber").hide();
                    document.getElementById("<portlet:namespace/>mgrassociateNo").disabled = false;
                    manageAssociateValidation();
                    $(".chosenAssociateNumber").data("placeholder","Select Frameworks...").chosen({search_contains:true});
                     $('.chosenAssociateNumber').trigger('chosen:updated');
			var positionDisplay = document.getElementById("NewPOS");
			var departmentDisplay = document.getElementById("deptNumber");
                        if(positionDisplay.style.display == "block") {
                                 $("#Division").hide();
                                 $("#deptNAME").hide();
                                 $("#deptMgrName").hide();
                                 $("#divMgrName").hide();
                                 $("#deptNumberFromPosition").hide();
                                 $("#leadershipassignment").hide();
                                 $("#managerAssociateNumber").hide();
                        }
                        if(departmentDisplay.style.display == "block"){
                                $("#DivisionFromM").show();
                                $("#deptNameFromM").show();
                                $("#deptManagerFromM").show();
                                $("#divMgrNameFromM").show();
                                $("#ManPowerRep").show();
                        }
                        $(".chosenDivdeptRest").data("placeholder","Select Frameworks...").chosen({search_contains:true});	
                        }
      	        else {   
                        $("#<portlet:namespace/>divdeptRest option:selected").removeAttr("selected"); 
                        $("#DivisionFromM").html("");
                        $("#divMgrNameFromM").html("");
                        $("#deptNameFromM").html("");
                        $("#deptManagerFromM").html("");
                        $('.chosenDivdeptRest').trigger('chosen:updated');
                        $("#<portlet:namespace/>mgrassociateNo option:selected").removeAttr("selected"); 
                        $("#ManagerAssociateName").html("");
                        $("#ManagerAssociateTitle").html("");
                        $('.chosenAssociateNumber').trigger('chosen:updated');
                    $("#msgFormanagerAssociateNumber").hide();
                    $(".manageAssociate_ValidationMessage").hide();
                    $("#<portlet:namespace/>mgrassociateNo_chosen").hide();
                    $("#ManagerAssociateName").show();
                    $("#ManagerAssociateTitle").show();
     		 document.getElementById("deptNumber").style.display = "none";
     		 document.getElementById("DivisionFromM").style.display = "none";
     		 document.getElementById("deptNameFromM").style.display = "none";
     		 document.getElementById("deptManagerFromM").style.display = "none";
     		 document.getElementById("divMgrNameFromM").style.display = "none";
      	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
      	 A.io.request('<%=resourceURL.toString()%>',{  
      	 dataType: 'json', 
      	 method: 'GET',   
      	 data:
      	 { 
      		 <portlet:namespace/>pidvalue: pidvalue,
      		 <portlet:namespace/>cmd: "getPositionDetailsURL"
      		 },   
      	 on: {    
      		 	success: function() { 
      			var data=this.get('responseData');
				$('#Division').html(data.division);
				$('#divMgrName').html(data.divMgrName);
				$('#deptNAME').html(data.deptName);
				$('#deptNumberFromPosition').html(data.deptNumber);
				//$('#divMgrName').html(data.deptManager);
      			$('#deptMgrName').html(data.deptManager);
      			$('#leadershipassignment').html(data.leadershipassignment);
      			$('#managerAssociateNumber').html(data.managerAssociateNumber);
      			$('#ManagerAssociateName').html(data.ManagerAssociateName);
      			$('#ManagerAssociateTitle').html(data.ManagerAssociateTitle);
      			$('#ManPowerRep').html(data.MANPOWER_REP);
      			$('#employeecategoryNew').html(data.employeecategory);
      			$('#<portlet:namespace/>NewpositionLeadership').val(data.leadershipassignment);
      			$('#<portlet:namespace/>NewpositionDepartmentname').val(data.deptName);
      			$('#<portlet:namespace/>NewpositiondeptManager').val(data.deptManager);
      			document.getElementById("NewPOS").style.display = "block";
				document.getElementById("Division").style.display = "block";
				document.getElementById("deptNAME").style.display = "block";
				document.getElementById("deptMgrName").style.display = "block";
				document.getElementById("divMgrName").style.display = "block";
				 document.getElementById("deptNumberFromPosition").style.display = "block";
				document.getElementById("leadershipassignment").style.display = "block";
				document.getElementById("managerAssociateNumber").style.display = "block";
				document.getElementById("ManagerAssociateName").style.display = "block";
				document.getElementById("ManagerAssociateTitle").style.display = "block";
				}   
      			 }
      		 });
      	 });
      	}
       } 
  </aui:script>
  <script>
  function scrolldown(){
	  var associate_no = document.getElementById("<portlet:namespace/>associaNumber").value;
	  if(associate_no != ''){
	
	  }
  }
  function addDataFunction() {
      document.getElementById("<portlet:namespace/>newAssociateTitle").disabled = false;
      $(".chosenAssociateTitle").data("placeholder","Select Frameworks...").chosen({search_contains:true});
      document.getElementById("<portlet:namespace/>pId").disabled = false;
    $(".chosenPId").data("placeholder","Select Frameworks...").chosen({search_contains:true});     
  }
	function validateLeadership(){
		 document.getElementById("<portlet:namespace/>LeaderShip").disabled = false; 
	}
  function validateDeptNumberForPosition() {
	  var position=document.getElementById("<portlet:namespace/>pId").value;
	  if(position=="None")
	  {
	  document.getElementById("<portlet:namespace/>divdeptRest").disabled = false;
	    $(".chosenDivdeptRest").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	  }
  } 
  function showPopup (){
	  var position=document.getElementById("<portlet:namespace/>pId").value;
	  var deptNumber=document.getElementById("<portlet:namespace/>divdeptRest").value;
	  var LeaderShip=document.getElementById("<portlet:namespace/>LeaderShip").value;
	  var newAssociateTitle=document.getElementById("<portlet:namespace/>newAssociateTitle").value;
	  var save=document.getElementById("<portlet:namespace/>saveButton");
	 if(newAssociateTitle=="PA" || newAssociateTitle=="TC" ) {
	  	if(deptNumber!=""){
	    	getAuiGenerateCosPopup();
	     	save.focus();
	  	}}
	 else if(newAssociateTitle!="" && position=="None" && deptNumber!="") {
	    getAuiGenerateCosPopup();
	    save.focus();
	  }
	 else if(position!="")
		  {
	         if(newAssociateTitle!="" && position!="None" && LeaderShip=="") {
	  	    getAuiGenerateCosPopup();
	  	    save.focus();
	         }} }
	function autoSaveCosPopupComplete() {
        var msgForPosition= document.getElementById("msgForPosition");
        msgForPosition.innerHTML='';
        document.getElementById('<portlet:namespace />addWFMSCOS').submit();
         }
  function getAuiGenerateCosPopup() {
		AUI().use('aui-base',
					'aui-io-plugin-deprecated',
					'liferay-util-window',
				function(A) {
					var popUpWindow = Liferay.Util.Window.getWindow({
						dialog : {
							centered : true,
							constrain2view : true,
							align : {
								node : null,
								points : [ 'tc', 'tc' ]
							},
							modal : true,
							cache : false,
							width : 650,
							height : 200,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();
					popUpWindow.show();
					popUpWindow.titleNode.html('Thank you for entering Associate New Position data <br /> Now please click "Save and Modify" button to proceed');
					popUpWindow.io.set('uri',"<%=generateCosPopupURL%>");
					popUpWindow.io.start();
	 	});
		$("#msgForPosition").hide();
	}
  function  getAuiAsTitlePopup(){
	  AUI().use('aui-base',
					'aui-io-plugin-deprecated',
					'liferay-util-window',
				function(A) {
					var popUpWindow = Liferay.Util.Window.getWindow({
						dialog : {
							centered : true,
							constrain2view : true,
							align : {
								node : null,
								points : [ 'tc', 'tc' ]
							},
							modal : true,
							cache : false,
							width : 550,
							height : 100,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();
					popUpWindow.show();
					popUpWindow.titleNode.html('Please choose a title in the correct ladder for this position.');
					//popUpWindow.io.set('uri',"<%=generateCosPopupURL%>");
					//popUpWindow.io.start();
	 	});
		$("#msgForPosition").hide();
  }
	function generateCosPopupComplete() {
		checkServiceNowIsDownPoPup();
		var currentPosName=$("#<portlet:namespace/>pId option:selected").text().indexOf('Current Position');
		if( currentPosName == "-1"){$("#<portlet:namespace/>currentpositionText").val("nonecurrent");
					}else{	$("#<portlet:namespace/>currentpositionText").val("currentpositionText");} 
		document.getElementById('<portlet:namespace />addWFMSCOS').submit();
		$("#announced1").attr('disabled', false);
		 $("#announced2").attr('disabled', false);
		 }
	function checkServiceNowIsDown(){
	 	AUI().use('aui-base',
		'aui-io-plugin-deprecated',
		'liferay-util-window',
	function(A) {
		var popUpWindow = Liferay.Util.Window.getWindow({
			dialog : {
				centered : true,
				constrain2view : true,
				align : {
					node : null,
					points : [ 'tc', 'tc' ]
				},
				modal : true,
				cache : false,
				width : 550,
				height : 150,
				destroyOnClose : true,
			}
		}).plug(A.Plugin.IO, {
			autoLoad : false
		}).render();
		popUpWindow.show();
		popUpWindow.titleNode.html("");
		popUpWindow.io.set('uri',"<%=generateInternetConnection%>");
		popUpWindow.io.start();
});
 }
	 function checkServiceNowIsDownPoPup(){
		    $.ajax({
		    		url : '<%=resourceURL.toString()%>',
					data : {
						<portlet:namespace />cmd : 'checkServiceNowIsDown'
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
						if(data.sucess)checkServiceNowIsDown();
					},
					error : function(response) {
			        	console.log("Error seen for for Internet Connection Down");
					}
			});
			 }
	function getGenerateCosPopupforConditions(msg) {
		AUI().use('aui-base',
					'aui-io-plugin-deprecated',
					'liferay-util-window',
				function(A) {
					var popUpWindow = Liferay.Util.Window.getWindow({
						dialog : {
							centered : true,
							constrain2view : true,
							align : {
								node : null,
								points : [ 'tc', 'tc' ]
							},
							modal : true,
							cache : false,
							width : 550,
							height : 100,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();
					popUpWindow.show();
					popUpWindow.titleNode.html(msg);
	 	});
		$("#msgForPosition").hide();
		return false;
	}
	$(document).ready(function(){
		$("#<portlet:namespace/>pId").change(function(){
		if($(this).val() == "None"){
			$("#leadershipassignmentnone").show();
	    	 $("#leadershipassignmentnone").html("None");
	    	}else{
	    	 $("#leadershipassignmentnone").html("");	
	    	 $("#leadershipassignmentnone").hide();
	    	 $("#UpdatePO").hide();
	    	}
	   }); 
		$("#<portlet:namespace/>newAssociateTitle").change(function(){
			if($(this).val() == "PA" || $(this).val() == "TC"){
				  $("#leadershipassignmentnone").show();
				  $("#UpdatePO").hide();
		    	  $("#leadershipassignmentnone").html("None");
		    	}else{
		    	 $("#leadershipassignmentnone").html("");
		    	 $("#leadershipassignmentnone").hide();
		    	 $("#UpdatePO").hide();
		    	}
		   });
		<%if(wfmsCOS !=null && (wfmsCOS.getNewJobCode().equals("PA") || wfmsCOS.getNewJobCode().equals("TC"))){ %>
			 document.getElementById("leadershipassignmentnone").style.display = "block";
			 $("#UpdatePO").hide();
	    	 $("#leadershipassignmentnone").html("None");
		<%}%>	
	}); 
	function scrolldownToNextSection(){
	      var change_desc = document.getElementById("<portlet:namespace/>chgDesc").value;
	      var effective_date = document.getElementById("<portlet:namespace/>startDate").value;
	      if(change_desc != '' && effective_date != ''){
	        //  $('html, body').animate({scrollTop: $("#current_position").offset().top}, 100);
	      }
	  }
  </script>  
  <aui:form action="<%= associateIdForCOSURL.toString()%>" method="post" name="associateIdForCOS" id="associateIdForCOS">
  </aui:form>    
  <div class="modal fade" id="showValidations" style="display:none">
	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id="moveAssociateFormclose" class="close"
						data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="control-group error">
					   <h4 class="modal-title help-inline">Please fill the following required fields</h4>
						<ul class="popup-validation-messages">
                                                    <li class="associaNumber_ValidationMessage col-sm-12 help-inline" style="display: none;">Associate Number</li>
                                                    <li class="startDate_ValidationMessage col-sm-12 help-inline" style="display: none;">Effective Date</li>
                                                    <li class="action_ValidationMessage col-sm-12 help-inline" style="display: none;">Action</li>
                                                    <li class="reasoncode_ValidationMessage col-sm-12 help-inline" style="display: none;">Reason Code</li>
                                                    <li class="chgDesc_ValidationMessage col-sm-12 help-inline" style="display: none;">Change Description</li>
                                                    <li class="newAssociateTitle_ValidationMessage col-sm-12 help-inline" style="display: none;">Associate Title</li>
                                                    <li class="positionnumber_ValidationMessage col-sm-12 help-inline" style="display:none;">Position Number</li>
                                                    <li class="newDeptNUmber_ValidationMessage col-sm-12 help-inline" style="display: none;">Department Number</li>
                                                    <li class="teamNumber_ValidationMessage col-sm-12 help-inline" style="display:none;">Team Number</li>
                                                    <li class="shiftCode_ValidationMessage col-sm-12 help-inline" style="display:none;">Shift Code</li>
                                                    <li class="manageAssociate_ValidationMessage col-sm-12 help-inline" style="display:none;">Manager Associate Number</li>
                                                    <li class="manpowerCategiry_ValidationMessage col-sm-12 help-inline" style="display:none;">Manpower Category</li>
	                       </ul>
					</div>
				</div>
				<div class="modal-footer" style="margin-top: 30px;">
						<div class="col-sm-2">
							<button type="button" class="btn btn-default" data-dismiss="modal" id="move_associate_close">Close</button>
						</div>
					</div>
			</div>
	</div>
</div>
<script>

  <%  if(ParamUtil.getString(request, "modifyButtonEnable").equals("modifyButtonEnable")){ %>
   modifyFunction(); 
    <% } %>  
 
</script>
	<script type="text/javascript">	
	var currentPosTextVal = new Boolean(false);
	function exitviewUrl(url) {
		window.location.href = url;
	}
	$(document).ready(function(){
    	$("#announced1").attr('disabled', true);
		$("#announced2").attr('disabled', true);
	}); 
 		function printDiv(divName) {
 	        var printContents = document.getElementById(divName).innerHTML;
 	        w = window.open();
 	        w.document.write(printContents);
 	        w.document.write('<scr' + 'ipt type="text/javascript">' + 'window.onload = function() { window.print(); window.close(); };' + '</sc' + 'ript>');
 	        w.document.close(); // necessary for IE >= 10
 	        w.focus(); // necessary for IE >= 10
 	        return true;
 	    }
 		<%if(Validator.isNotNull(annouced)){%>		
 		$(document).ready(function(){
 		 $("#announced1").attr('disabled', false);
		 $("#announced2").attr('disabled', false);
		 });
 		<%}%>
    </script>
	</div>
	<% if(renderRequest.getParameter("newChangeOfStatus") == null){ %>
<div class="print"  id="printableArea">
<%@ include file="/html/changeOfStatus/draft-Print.jsp" %> 
</div>
<%} %>
<style type="text/css"  > 
	.print { display:none; } 
</style>
<style type="text/css" media="print">
	.manageCOS { display:block;}
	.print { display:none; }
</style>