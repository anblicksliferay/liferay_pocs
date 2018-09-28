<%@page import="java.time.LocalDateTime"%>
<%LocalDateTime today = LocalDateTime.now(); 
System.out.println("<<<<load Start Time>>>>>>"+today); %>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_Requisition_AuditLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ys.hmawfm.wfms.utils.ConfigUtility"%>
<%@page import="com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService"%>
<%@page import="com.ys.hmawfm.wfms.workflow.WorkflowConstants"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaPermissionKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Map"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Position"%>
<%@page import="java.util.List"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ include file="/html/init.jsp"%>
<%-- <liferay-ui:success key="Your request saved Sucessfully"
	message="your-saved-sucessfully" /> --%>

<portlet:actionURL name="manageRequisition" var="mangeRequisitionURL"></portlet:actionURL>
<portlet:actionURL name="approveRequisition" var="approveRequisitionURL"></portlet:actionURL>
<% 



	String[] values = null;
String positionId = (String)request.getAttribute("positionId"); 
String rwfId = (String)request.getAttribute("requisitionId"); 


PortletURL FillActionURL = renderResponse.createActionURL();
FillActionURL.setParameter("javax.portlet.action", "fillRequisition");
FillActionURL.setParameter("rwfId", rwfId);





String req_ids = "";
List<WFMS_Requisition> req_db = WFMS_RequisitionLocalServiceUtil.findByworkflowId(rwfId);
if(req_db.size()>0){
	for(WFMS_Requisition req:req_db){
		req_ids = req.getRwfId();
		System.out.println("req_ids:"+req_ids);
	}
}
else{
	req_ids = rwfId;
}
WFMS_Requisition req = WFMS_RequisitionLocalServiceUtil.fetchWFMS_Requisition(req_ids);
WFMS_Position frompos = WFMS_PositionLocalServiceUtil.getByPositionId(req.getRId());
DynamicQuery wfmreqforTemp =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
wfmreqforTemp.add(PropertyFactoryUtil.forName("rwfId").eq(rwfId+"-WFM"));
int wfmReqforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmreqforTemp);	
if(wfmReqforTempcount > 0){
WFMS_Requisition requisition=WFMS_RequisitionLocalServiceUtil.findByrequisition(rwfId+"-WFM");
req.setPostingType(requisition.getPostingType());
req.setTeamNumber(requisition.getTeamNumber());
req.setAssociatetype(requisition.getAssociatetype());
req.setShiftAssign(requisition.getShiftAssign());
req.setHowAvailable(requisition.getHowAvailable());
req.setWhoReplaced(requisition.getWhoReplaced());
req.setDateneeded(requisition.getDateneeded());
req.setContactperson(requisition.getContactperson());
req.setContactphonenumber(requisition.getContactphonenumber());
req.setTaleonumber(requisition.getTaleonumber());
req.setAssociatename(requisition.getAssociatename());
req.setAssociatenumber(requisition.getAssociatenumber());
req.setOther(requisition.getOther());


}

String reqNumber=req.getRwfId().replaceAll("-WFM", "");



PortletURL Discardstep2URL = renderResponse.createActionURL();
Discardstep2URL.setParameter("javax.portlet.action", "discardsecondRequisation");
Discardstep2URL.setParameter("reqId", reqNumber);


HondaLogicUtil logicUtil=new HondaLogicUtil();
	Map<String,String> deptMap = logicUtil.singleCallOnServieNow(frompos.getDepartmentNumber());

	String disapproveDisabled="1";//1 for enabled
String approveDisabled="1";//1 for enabled


/* if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_SUBMITTED)){
    List<Role> userRoles = (List) renderRequest.getAttribute("userroles");

User userdata = themeDisplay.getUser();
List <Role> roleIds = userdata.getRoles();
 disapproveDisabled="0";//1 for enabled
 approveDisabled="0";//1 for enabled
String fullpermitions="0";
String existDmUser="0";
for(Role rolenames:roleIds){
	if(rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM) || rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_CMP) ||
			rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_Administrator)|| rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_Owner)
			){
		fullpermitions="1";
		if(req.getWorkflowStep()!=0){
		   disapproveDisabled="1";
		   approveDisabled="1";
		}
	}
	if(rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_DM)){
		existDmUser="1";
	}
}
if(fullpermitions.equals("0") && existDmUser.equals("1")){
	  if(req.getWorkflowStep()==10){
		  approveDisabled="1";
		  disapproveDisabled="1";
	  }
	}
} */

String className=""; 
//if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_DRAFT)){
 //             className="datepicker";    
//}
%>

<div class="portlet-layout">
		<h2 class="titleArea" id="cosDivision"><% if(Validator.isNotNull(request.getAttribute("create"))){ %>Create <% } else { %>Manage <% } %> Requisition
		<% if(renderRequest.getParameter("printRequisition") == null){ %>
		 <input class="titleArea" type="button" value="Print" id="btnPrint" onclick="printDiv('printableArea')" /> <%} %>
		</h2>
<aui:form action="<%=approveRequisitionURL.toString()%>" method="post" name="approveRequisitionForm" id="approveRequisitionForm">


	<%
		//List<WFMS_Requisition_Audit> list= WFMS_Requisition_AuditLocalServiceUtil.findByReqIdForAudit(req.getRwfId()); 
			   String approvedstatus=HondaPermissionKeys.ROLE_DM;
			if(req.getRoleOfApprover().equalsIgnoreCase(HondaPermissionKeys.ROLE_CMP))
			    approvedstatus=HondaPermissionKeys.ROLE_CMP;
			else if(req.getRoleOfApprover().equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM))
			     approvedstatus=HondaPermissionKeys.ROLE_SPDM;
	%>
	<aui:input type="hidden" name="userrole" value="<%=approvedstatus%>" />
	<aui:input type="hidden" name="requisitionId" value="<%=reqNumber%>" />
</aui:form>
<aui:script>
	$(document).ready(function() {
		$("#approveRequisition").click(function() {
			$("#<portlet:namespace/>approveRequisitionForm").submit();
		});
	});
</aui:script>
<aui:form action="<%=mangeRequisitionURL.toString()%>" method="post" name="manageRequisition" id="manageRequisition">

<%
//	System.out.println(" req.getStatus() "+req.getStatus());
	if((req.getStatus()).equalsIgnoreCase(HondaPermissionKeys.REQ_SUBMITTED)){ %>

	<aui:input type="hidden" name="requisisionnumber" value="<%=reqNumber%>" />
	<aui:input type="hidden" name="Number" value="<%=frompos.getPId()%>" />
	
	<div class="portlet-layout">
		<div class="col-sm-12">
			<div class="wfm-system">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-6">
						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Requisition Number</span>
							</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=reqNumber%></div>
						</div>

						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Position Number</span>
							</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getPId()%></div>
						</div>
					</div>
		<div class="portlet-column portlet-column-first col-sm-6">
						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Filled with Associate Number</span>
							</div>
							<div class="portlet-column portlet-column-last col-sm-6">
								<div class="portlet-column portlet-column-last col-sm-12">
									<div class="portlet-column portlet-column-last col-sm-12">
										<div style="display: none;">

											<aui:input type="hidden" class="field error-field"
												id="hidden_field" name="hidden_field" required="true"></aui:input>
										</div>
										<select class=" chosenAssociate " name="<portlet:namespace/>associatenumber"
											id="associatenumber" label="" disabled
											onChange="associateNameChange();">
											<%
												if(req.getAssociatenumber().equalsIgnoreCase("None")){
											%>
											<option value="None">None</option>
											<%
												}
												else{
											%>
											<option value="">Select Filled with Associate Number</option>
											<%
												}
											boolean asscSelected = false;
											if(req.getAssociatenumber()!=StringPool.BLANK){
												asscSelected = true;
											}else{
												asscSelected = false;
											}
											
											%>
											
											<%
											
											
											String associateNumber=req.getAssociatenumber().trim();
											Map<String,String> assMap =  null;
											Map<String,String> treeMap = null;
											String sb=HondaLogicUtil.getassoNumbersByFilterd(associateNumber, WorkflowConstants.REQUISITION_ACTION);
											assMap = HMAAssociateInfoService.getAssociateNumbersWithNaTable("Requisition",sb.toString());
											
											treeMap = new TreeMap<String, String>(assMap);
											boolean associateSelected = false;
											boolean displayOption = false;
											for (String associatenumber : treeMap.keySet()) {
												String ASSOCIATE_NUMBER = associatenumber; 
												String ASSOCIATE_NAME = assMap.get(associatenumber);
												
												if(ASSOCIATE_NUMBER.equals(req.getAssociatenumber())){
													associateSelected = true;
													displayOption = true;										
													assMap.remove(ASSOCIATE_NUMBER);
													//System.out.println(displayOption);
													treeMap = assMap; 
													//System.out.println(treeMap);
												}
												else{
													associateSelected = false;
													displayOption = false;		
													treeMap = assMap;
												}
											}
												for (String associatenumber1 : treeMap.keySet()) {
													//System.out.println(associatenumber1);
													String ASSOCIATE_NUMBER1 = associatenumber1; 
													String ASSOCIATE_NAME1 = assMap.get(associatenumber1);
												
												
											%>
												
												
											<aui:option value="<%=ASSOCIATE_NUMBER1%>" selected="<%=associateSelected %>"><%=ASSOCIATE_NUMBER1%>-<%=ASSOCIATE_NAME1 %></aui:option>
										
										<%	}								
											if(req.getAssociatenumber()!=StringPool.BLANK){
												
											//System.out.println(req.getAssociatename());
											%>
											<aui:option selected="true" value="<%=req.getAssociatenumber() %>"><%=req.getAssociatenumber() %>-<%=req.getAssociatename() %></aui:option>
											<% } %>
											<aui:option
												selected='<%=req.getAssociatenumber().equalsIgnoreCase("None")%>'
												value="None">None</aui:option>
										</select> 
										<div class="associatenumber_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none; margin-top: 0px;">
                 "Missing required value for the field filled with &quot;Associate Number &quot;";
                </div>
										<div id="errormesg" class="form-required"></div>
									</div>
								</div>
							</div>
						</div>
						<%
							String associatename=""; 
						                        if(req.getAssociatenumber().equalsIgnoreCase("None")) 
						                        	associatename=req.getAssociatename();
						%>
						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Name of Person Filling if no
									ID</span>
							</div>

							<div class="portlet-column portlet-column-last col-sm-5  "
								id="assName" name="associateName" class=" personid"
								style="width: 205px; margin-left: 30px;"><%=req.getAssociatename()%></div>


							<div class="portlet-column portlet-column-last col-sm-5  "
								id="associatenameNotreqid" name="associatenameNotreqid"
								class=" personid">
								<%
									if(req.getAssociatenumber().equalsIgnoreCase("None")){
								%>
								<aui:input type="none" value="<%=associatename%>"
									onkeyup="validateEmptyField()" name="associatename"
									class=" personid" id="associateName" label="" disabled="true" />
								<%
									} else {
								%>
								<aui:input type="none" value="<%=associatename%>"
									onkeyup="validateEmptyField()" name="associatename"
									class=" personid" id="associateName" label="" />
								<%
									}
								%>
								<div>
									<span style="color: #b50303;" class="associateSpan"></span>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
			<div class="col-sm-12">
				<div class="wfm-system own-wrapper">
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-only">
							<div class="small center">
								<div class="col-sm-4">
									<button type="button" class="btn btn-primary"
										onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
										View</button>
								</div>
								<%
		                           if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_SUBMIT_EDIT_REQ,frompos.getDepartmentNumber())){

								%>
								<div class="col-sm-4">
									<aui:button cssClass="btn btn-primary" type="button"
										value="Modify Requisition" onClick="enablefield();"></aui:button>
								</div>
								<%
									}
								%>
								<%
									if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_SBMT_REQ,frompos.getDepartmentNumber())){
								%>
								<div class="col-sm-4 isModifyClicked">

									<aui:button class="btn btn-primary"
										style="background: #f1f1f1;color: #333;text-shadow: none;"
										type="submit" name="mangeRequisition" id="mangeRequisition"
										value="Submit"
										onClick="requisitionformsubmit('modifyrequisitionSubmit');"></aui:button>

								</div>
								<!-- 
								<div class="col-sm-3 isModifyClicked">
											<aui:button class="btn btn-primary" type="submit" name="saveRequisition" id="saveRequisition"
												onclick="requisitionformsubmit('modifyrequisitionSave');"
												value="Save" ></aui:button>
								</div> -->
								<%
									}
								%>

								<%
									if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_CNCL_REQ,frompos.getDepartmentNumber())){
								%>
								<div class="col-sm-4">
								<button type="submit" class="btn btn-primary"
									id="cancel" data-toggle="modal" data-backdrop="static" data-target="#myModal">Cancel
									Requisition</button>
							</div>
								<%
									}
								%>
								<%-- <div class="col-sm-3">
								<button class="btn btn-primary" type="submit"  onclick="<%=Requisition.toString() %>">Submit</button>
							</div> --%>

								<%
								 Boolean isabletoapprove=false;
								
									//if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,req.getWorkflowStep(), frompos.getDepartmentNumber(),  PortletPropsPermission.REQ_APPRV_REQ)){
										isabletoapprove=	WMSUserAccessUtil.checkButtonVisibility(renderRequest,req.getWorkflowStep(),
												frompos.getDepartmentNumber(),  PortletPropsPermission.REQ_APPRV_REQ);
									//	out.println(isabletoapprove);
								%>
								<div class="col-sm-4">
								
	<button id="approveRequisition" class="btn btn-primary"
										<%if(!isabletoapprove) { %> disabled<%} %> type="button"
										>Approve</button>
								</div>
								<%
								//} 
									Boolean isabletodisapprove=false;
								//	if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,req.getWorkflowStep(), frompos.getDepartmentNumber(), PortletPropsPermission.REQ_DIS_APPR_REQ)){
									
										isabletodisapprove=WMSUserAccessUtil.checkButtonVisibility(renderRequest,req.getWorkflowStep(), frompos.getDepartmentNumber(), PortletPropsPermission.REQ_DIS_APPR_REQ);

								%>

								<div class="col-sm-4">
									<aui:button id="disapproveRequisition"
										cssClass="btn btn-primary" type="button" data-toggle="modal" data-backdrop="static"
										data-target="#disapproveRequisitionModal"
										disabled='<%=!isabletodisapprove%>'
										value="Disapprove"></aui:button>
								</div>
								<%
									//}
								%>
								<aui:input type="hidden" name="buttonclick" id="buttonclick"
									value="" />
							</div>
						</div>
					</div>
				</div>
			</div>


		<div class="portlet-layout row">
			<div class="col-sm-12">

				<div class="wfm-system" style="margin-top: 20px;">


					<div class="portlet-layout row">
						<div class="portlet-column col-sm-6">
							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Line</div>
								<div class="portlet-column portlet-column-last">
									<%-- <%
												if((frompos.getLine()).equalsIgnoreCase("Line1")){
											%>
											<div class="portlet-column portlet-column-last col-sm-6">Line1</div>
											<%
												}
																								if((frompos.getLine()).equalsIgnoreCase("Line2")){
											%>
											<div class="portlet-column portlet-column-last col-sm-6">Line2</div>
											<%
												}
											%> --%>
									<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getLine()%></div>
								</div>

							</div>


							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Posting
									Type</div>

								<div class="portlet-column portlet-column-last col-sm-6">

									<aui:select name="postingType" id="postingType"
										class="field-select" onchange="postingTypevalidate();"
										placeholder="" label="" disabled="true">
										<aui:option value="">Select Posting Type</aui:option>
										<%
											values = ConfigUtility.getInputValuesFromConfig("requisation-type");
																	                                Arrays.sort(values);
																									for (String value : values) {
										%>
										<aui:option value="<%=value%>"
											selected="<%=req.getPostingType().equals(value)%>"><%=value%></aui:option>
										<%
											}
										%>

									</aui:select>
									<div id="postingTypeerrormesg" class="form-required"></div>
								</div>
							</div>
							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Team
									Number</div>

								<div class="portlet-column portlet-column-last col-sm-6">
									<aui:select name="teamNumber" class="field-select"
										placeholder="" label="" required="true" disabled="true" cssClass="chosenShiftassignment">
										<aui:option value="">Select Team Number</aui:option>
										<%
									
									List<String> reportToTeamNumber = HMAAssociateInfoService.getTeamNumberCos();
						              for ( String teamNumber : reportToTeamNumber) {  
						              
								if(Validator.isNotNull(teamNumber.trim())){
									%>
									<aui:option value="<%=teamNumber%>"
										selected="<%=(req.getTeamNumber().equals(teamNumber))%>"><%=teamNumber%></aui:option>
									<%
								}}
									%>
									</aui:select>
								</div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Ladder</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getLadder()%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate
									Type</div>

								<div class="portlet-column portlet-column-last col-sm-6">
									<aui:select name="associatetype" class="field-select"
										placeholder="" label="" required="true" disabled="true">
										<%
											values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
																														                   for(String value:values){
										%>
										<aui:option
											selected="<%=req.getAssociatetype().equals(value)%>"
											value="<%=value%>"><%=value%>
										</aui:option>
										<%
											}
										%>
									</aui:select>
								</div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Shift
									Assignment</div>

								<div class="portlet-column portlet-column-last col-sm-6"  id="shiftassignment_mainDiv">


									<aui:select name="shiftAssign" id="shiftassignment"
										cssClass="chosenShiftassignment"
										onchange="shiftAssignvalidate();" placeholder="" label=""
										disabled="true">
										<aui:option value="">Select Shift Assignment</aui:option>
										<%
											Map<String,String> shiftMap = new HashMap<String,String>();
																															          shiftMap=ConfigUtility.getInputValuesForMap("shift-assignment");
																															          Map<String,String> shiftMaps = new TreeMap<String,String>(shiftMap);
																															          for(Map.Entry<String, String> entry : shiftMaps.entrySet()){
																								String total = entry.getKey()+":"+entry.getValue();
										%>
										<aui:option value="<%=entry.getKey()%>"
											selected="<%=req.getShiftAssign().equals(total)%>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
										<%
											}
										%>
									</aui:select>
									<div id="shiftassignment_ValidationMessage" class="form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Shift Assignment"
                </div>
								</div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Who
									will this person report to?</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getReportsTo()%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">How
									did this person become available?</div>

								<div class="portlet-column portlet-column-last col-sm-6">

									<aui:select name="howAvailable" onChange="howAvailablevalidate();" id="howAvailable"
										class="field-select" placeholder="" label=""
										required="true" disabled="true">
										<%
											values = ConfigUtility.getInputValuesFromConfig("position-availableposition");
												              for(String value:values){
										%>
										<aui:option
											selected="<%=req.getHowAvailable().equals(value)%>"
											value="<%=value%>"><%=value%></aui:option>
										<%
											}
										%>
									</aui:select>
								</div>
							</div>
						</div>


						<div class="portlet-column col-sm-6">
							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Status</div>
								<%
									if(req.getStatus().equalsIgnoreCase("save")){
								%>
								<div class="portlet-column portlet-column-last col-sm-6">Draft</div>
								<%
									}
								                                
								                            else{
								%>
								<div class="portlet-column portlet-column-last col-sm-6"><%=req.getStatus()%></div>
								<%
									}
								%>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Creator</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=req.getCreatedBy()%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date
									Created</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=HondaLogicUtil.getDateFormat(req.getCreateDate()).trim()%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date
									Approved</div>

								<div class="portlet-column portlet-column-last col-sm-6"></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department
									Name</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getDepartmentName().trim()%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department
									Number</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getDepartmentNumber().trim()%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department
									Manager</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=deptMap.get("deptMgrName")%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getDivision()%></div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division
									Manager</div>

								<div class="portlet-column portlet-column-last col-sm-6"><%=deptMap.get("divMgrName")%></div>
							</div>
						</div>
					</div>

					<div class="portlet-layout row">
						<div class="portlet-column col-sm-12">
							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">If
									replacement, replacement of whom?</div>

								<div class="portlet-column portlet-column-last col-sm-6" id="whoReplacedRequired_mainDiv">

											<input type="textarea" onkeyup="validatewhoReplaceField()"  name="<portlet:namespace/>whoReplaced"
									label="" id="<portlet:namespace/>whoReplaced" 
									rows="1" maxlength="75" value="<%=req.getWhoReplaced()%>"
									disabled="true"> </input> 
									<div style="display:none;color: #b50303;" class="whoReplacedRequired_ValidationMessage form-validator-stack help-inline">Missing required value for the field "If replacement, replacement of whom"</div>
										</div>
							</div>

							<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date
								Manpower needed?</div>
							<script type="text/javascript">
								function datevalidation(x) {
									if (x == '') {

										//$(".date_validate").html("Missing required value for the field &quot;Date Manpower needed? &quot;.");
										$(".date_validate").show();
										 $('#date_maindiv').addClass('control-group error');
										document.getElementById('<portlet:namespace/>hidden_field').value = '';
									} else {
										//$(".date_validate").html("");
										$(".date_validate").hide();
										$('#date_maindiv').removeClass('control-group error');
									}
								
								}
							</script>
							<div class="portlet-column portlet-column-last col-sm-6" id="date_maindiv">
								<div id="#<portlet:namespace />startDatePicker">
												<aui:input name="dateneeded" label="" id="startDate"
												maxlength="70" title="Click Here" readOnly="true" 
												placeholder="MM/DD/YYYY" value="<%=req.getDateneeded()%>"
												cssClass="datepicker"
												errorMessageDivId="startDateErrorDiv"
												onFocus="clearErrorMessage('startDateErrorDiv');"
												onClick="clearErrorMessage('startDateErrorDiv');">
												</aui:input>
												
												 <!-- <div class="form-validator-stack help-inline"> -->
			 									
			 							 </div>
			 							 
			 							 <div class="date_validate form-validator-stack help-inline" style="display: none;">
                  							 Missing required value for the field "Date Manpower needed?"
              							 </div>	
									</div>	
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Contact
									Person for Interviews</div>
								<div class="portlet-column portlet-column-last col-sm-6">
									<aui:input type="textarea" name="contactperson" label=""
										required="true" value="<%=req.getContactperson()%>"
										class="field"  placeholder="contact-person" rows="1"
										disabled="true">
										<aui:validator name="maxLength">75</aui:validator>
									</aui:input>
								</div>
							</div>

							<div class="portlet-layout row">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Contact
									Phone Number</div>
								<div class="portlet-column portlet-column-last col-sm-6">
									<aui:input type="textarea" name="contactphonenumber"
										 label=""
										value="<%=req.getContactphonenumber()%>" class="field"
										 rows="1" disabled="true">
										<aui:validator name="maxLength">75</aui:validator>
									</aui:input>
								</div>
							</div>

							<div class="portlet-layout row" style="margin-top: 30px">
								<div
									class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Taleo
									Number</div>
 
								<div class="portlet-column portlet-column-last col-sm-6">
									<aui:input type="textarea" name="taleonumber" 
										class="field" value="<%=req.getTaleonumber()%>" label=""
										 rows="1" disabled="true">
										<aui:validator name="maxLength">75</aui:validator>
									</aui:input>
								</div>
							</div>
						</div>
					</div>

					<h3 class="subsection">Requisition Information</h3>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Typical
							Job Title</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="1"><%=frompos.getTypicalJobTitle()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Minimum
							Job Relevant Knowledge (Know how)</div>
					<div class="requisition_IEBrowser" > <%=frompos.getMinJobKnowHow()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getMinJobKnowHow()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Prioritized
							duties and Responsibilities</div>
					<div class="requisition_IEBrowser" > <%=frompos.getDuties()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getDuties()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Daily
							Tasks Performed</div>
					<div class="requisition_IEBrowser" > <%=frompos.getTasksPerformed()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getTasksPerformed()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Minimun
							Job Relevant Experience (length of service)</div>
					<div class="requisition_IEBrowser" > <%=frompos.getLengthOfService()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getLengthOfService()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Degree
							or certification required</div>
<div class="requisition_Browser" style="border:1px solid black;width:587px;height:67px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=frompos.getDegree()%> </div>
							<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="3"><%=frompos.getDegree()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Required
							Skills (Musts)</div>
					<div class="requisition_IEBrowser" > <%=frompos.getReqSkills()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getReqSkills()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Desired
							Skills and Abilities (Wants)</div>
						<div class="requisition_IEBrowser" > <%=frompos.getDesiredSkills()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getDesiredSkills()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Environment
							Associate will work in</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="1"><%=frompos.getEnvironment()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Estimates
							Weekly Overtime</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="1"><%=frompos.getWeeklyOvertime()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Frequency
							and Duration of Travel</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="1"><%=frompos.getFrequencyOfTravel()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Other</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<aui:input type="textarea" name="other" class="field"
								value="<%=req.getOther()%>"  placeholder="" rows="3"
								label="">
								<aui:validator name="maxLength">255</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
			</div>
		</div>

<%
	}
	else{
%>

	<aui:input type="hidden" name="requisisionnumber" value="<%=reqNumber%>" />
	<aui:input type="hidden" name="Number" value="<%=frompos.getPId()%>" />
	<aui:input type="hidden" name="createDate"
		value="<%=frompos.getCreateDate()%>" />
	<div class="portlet-layout row">
		<div class="col-sm-12">
			<div class="wfm-system">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-6">
						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Requisition Number</span>
							</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=reqNumber%></div>

						</div>

						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Position Number</span>
							</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getPId()%></div>
						</div>
					</div>

					<div class="portlet-column portlet-column-first col-sm-6">
						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Filled with Associate Number</span>
							</div>
							<div class="portlet-column portlet-column-last col-sm-6">
								<div class="portlet-column portlet-column-last col-sm-12">
									<div class="portlet-column portlet-column-last col-sm-12" id="associatenumber_mainDiv">
										<div style="display: none;">

											<aui:input type="hidden" class="field error-field"
												id="hidden_field" name="hidden_field" required="true"></aui:input>
										</div>
										
										<select class=" chosenAssociate " name="<portlet:namespace/>associatenumber"
											id="associatenumber" label="" disabled
											onChange="associateNameChange();">
											<%
												if(req.getAssociatenumber().equalsIgnoreCase("None")){
											%>
											<option value="None">None</option>
											<%
												}
												else{
											%>
											<option value="">Select Filled with Associate Number</option>
											<%
												}
											boolean asscSelected = false;
											if(req.getAssociatenumber()!=StringPool.BLANK){
												asscSelected = true;
											}else{
												asscSelected = false;
											}
											
											%>
											
											<%
											
											
											String associateNumber=req.getAssociatenumber().trim();
											Map<String,String> assMap =  null;
											Map<String,String> treeMap = null;
											String sb=HondaLogicUtil.getassoNumbersByFilterd(associateNumber, WorkflowConstants.REQUISITION_ACTION);
											assMap = HMAAssociateInfoService.getAssociateNumbersWithNaTable(WorkflowConstants.REQUISITION_ACTION,sb.toString());
											
											treeMap = new TreeMap<String, String>(assMap);
											boolean associateSelected = false;
											boolean displayOption = false;
											for (String associatenumber : treeMap.keySet()) {
												String ASSOCIATE_NUMBER = associatenumber; 
												String ASSOCIATE_NAME = assMap.get(associatenumber);
												
												if(ASSOCIATE_NUMBER.equals(req.getAssociatenumber())){
													associateSelected = true;
													displayOption = true;										
													assMap.remove(ASSOCIATE_NUMBER);
													//System.out.println(displayOption);
													treeMap = assMap; 
													//System.out.println(treeMap);
												}
												else{
													associateSelected = false;
													displayOption = false;		
													treeMap = assMap;
												}
											}
												for (String associatenumber1 : treeMap.keySet()) {
													//System.out.println(associatenumber1);
													String ASSOCIATE_NUMBER1 = associatenumber1; 
													String ASSOCIATE_NAME1 = assMap.get(associatenumber1);
												
												
											%>
												
												
											<aui:option value="<%=ASSOCIATE_NUMBER1%>" selected="<%=associateSelected %>"><%=ASSOCIATE_NUMBER1%>-<%=ASSOCIATE_NAME1 %></aui:option>
										
										<%	}								
											if(req.getAssociatenumber()!=StringPool.BLANK){
												
											//System.out.println(req.getAssociatename());
											%>
											<aui:option selected="true" value="<%=req.getAssociatenumber() %>"><%=req.getAssociatenumber() %>-<%=req.getAssociatename() %></aui:option>
											<% } %>
											<aui:option
												selected='<%=req.getAssociatenumber().equalsIgnoreCase("None")%>'
												value="None">None</aui:option>
										</select> 
										<div class="associatenumber_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none; margin-top: 0px;">
                 "Missing required value for the field filled with &quot;Associate Number &quot;";
                </div>
									</div>
								</div>
							</div>
						</div>
						<%
							String associatename=""; 
						                        if(req.getAssociatenumber().equalsIgnoreCase("None")) 
						                        	associatename=req.getAssociatename();
						%>
						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Name of Person Filling if no
									ID</span>
							</div>

							<div class="portlet-column portlet-column-last col-sm-5  "
								id="assName" name="associateName" class=" personid"
								style="width: 205px; margin-left: 30px;"><%=req.getAssociatename()%></div>


							<div class="portlet-column portlet-column-last col-sm-5  "
								id="associatenameNotreqid" name="associatenameNotreqid"
								class=" personid">
								<%
									if(req.getAssociatenumber().equalsIgnoreCase("None")){
								%>
								<aui:input type="none" value="<%=associatename%>"
									onkeyup="validateEmptyField()" name="associatename"
									class=" personid" id="associateName" label="" disabled="true" />
								<%
									} else {
								%>
								<aui:input type="none" value="<%=associatename%>"
									onkeyup="validateEmptyField()" name="associatename"
									class=" personid" id="associateName" label="" />
								<%
									}
								%>
								<div>
									<span style="color: #b50303;" class="associateSpan"></span>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<%
			if((req.getStatus()).equalsIgnoreCase(HondaPermissionKeys.REQ_DRAFT) ){
		%>
			<div class="col-sm-12">
				<div class="wfm-system own-wrapper">
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-only">
							<div class="small center">
								<div class="col-sm-4">
									<button type="button" class="btn btn-primary"
										onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
										View</button>
								</div>
								<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_EDIT_REQ,frompos.getDepartmentNumber())){ %>
								<div class="col-sm-4">
									<aui:button cssClass="btn btn-primary" type="button"
										value="Modify Requisition" onClick="addDataFunction();"
										disabled="true"></aui:button>
								</div>
								<%}%>
								<%
							
								if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_CNCL_REQ,frompos.getDepartmentNumber())){ %>
								<div class="col-sm-4">
									<aui:button cssClass="btn btn-primary" type="submit"
										value="Cancel Requisition" id="cancel" data-toggle="modal" data-backdrop="static"
										data-target="#myModal"></aui:button>
								</div>
								<%}%>
								<%-- <div class="col-sm-3">
								<button class="btn btn-primary" type="submit" onclick="<%=Requisition.toString() %>">Submit</button>
							</div> --%>
								<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_DRAFT_REQ,frompos.getDepartmentNumber())){ %>
								<div class="col-sm-4">
									<aui:button cssClass="btn btn-primary" type="button"
										name="addRequisition" id="addRequisition" value="Add Data"
										onClick="addDataFunction();"></aui:button>
								</div>
								<%}%>

                              <% if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_SBMT_REQ, frompos.getDepartmentNumber())){ %>
						<div class="col-sm-4">

									<aui:button class="btn btn-primary"
										style="background: #f1f1f1;color: #333;text-shadow: none;"
										type="submit" name="mangeRequisition" id="mangeRequisition"
										value="Submit" disabled="true"
										onClick="validateText();requisitionformsubmit('modifyrequisitionSubmit');"></aui:button>

								</div>
									<div class="col-sm-4">
										<aui:button class="btn btn-primary" name="saveRequisition"
											id="saveRequisition" type="button" disabled="true"
											onclick="requisitionformsave('modifyrequisitionSave');"
											value="Save"></aui:button>
									</div>
								
								
								<%
								

								DynamicQuery wfmRequisationforTemp =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
								wfmRequisationforTemp.add(PropertyFactoryUtil.forName("rwfId").eq(reqNumber+"-WFM"));
								int wfmRequisationforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmRequisationforTemp);	
								
								
								if(wfmRequisationforTempcount > 0){%>
								<div class="col-sm-4" id="discardId">									
									<button type="button" class="btn btn-primary"	onclick="discardUrl('<%=Discardstep2URL%>')">Discard</button>		
								</div>
								<% } %>
								
								
								<%} %>
								
								<aui:input type="hidden" name="buttonclick" id="buttonclick"
									value="" />
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
	<%
}
	%>
	<%
		if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_ONHOLD)){
	%>
		<div class="col-sm-12">
			<div class="wfm-system own-wrapper">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-12">
								<button type="button" class="btn btn-primary"
									onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
									View</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<%
		if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_CANCELLED)){
	%>
		<div class="col-sm-12">
			<div class="wfm-system own-wrapper">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-3">
								<button type="button" class="btn btn-primary"
									onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
									View</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<%
		if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_COMPLETE)){
	%>
		<div class="col-sm-12">
			<div class="wfm-system own-wrapper">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-12">
								<button type="button" class="btn btn-primary"
								onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
									View</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<%
		}
	%>
	<%
  if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_COMPLETE_PENDING_APPROVAL)){
  
	  List<WFMS_COS> cosRecordStatus= new ArrayList<WFMS_COS>();
      DynamicQuery queryForcos =WFMS_COSLocalServiceUtil.dynamicQuery();
      queryForcos.add(PropertyFactoryUtil.forName("assoicateId").eq(req.getAssociatenumber()));
      queryForcos.add(PropertyFactoryUtil.forName("systemGenerated").eq(1));

      cosRecordStatus= WFMS_COSLocalServiceUtil.dynamicQuery(queryForcos); 
      
     // int cosRecordCount = (int)WFMS_COSLocalServiceUtil.dynamicQueryCount(queryForcos);
		 
		 DynamicQuery dynamicQueryForCos =WFMS_COSLocalServiceUtil.dynamicQuery();
						dynamicQueryForCos.add(PropertyFactoryUtil.forName("assoicateId").eq(req.getAssociatenumber()));
		 	                     Criterion Coscriterion = null;
													Coscriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.COS_DRAFT);
													Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,
															RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT));
													dynamicQueryForCos.add(Coscriterion);
													List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
		 
		 int cosRecordCount = (int)cosList.size();
 %>
		<div class="col-sm-12">
			<div class="wfm-system own-wrapper">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-4">
								<button type="button" class="btn btn-primary"
									onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
									View</button>
							</div>
							
								<% if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,req.getWorkflowStep(), frompos.getDepartmentNumber(), PortletPropsPermission.REQ_DIS_APPR_REQ_COMP)){ %>
							        <%
                                     //  Boolean flag = (cosRecordCount == 0) ?true : false;
							          if(cosRecordCount == 0){
							        %>
						<div class="col-sm-4">
								<aui:button id="disapprovecomplete" cssClass="btn btn-primary"
									type="button" data-toggle="modal" data-backdrop="static"
									data-target="#disapprovecompleteModal" value="Disapprove"></aui:button>
						</div>
						<div class="col-sm-4">
							        <aui:button id="approvecomplete" cssClass="btn btn-primary"
							         type="button" data-toggle="modal" data-backdrop="static"
							         data-target="#approvecompleteModal" value="Approve"></aui:button></div>
							        <%
							         }else{
							        %>
							        <aui:script>
							        
							        function auiModal() {
			AUI().use('aui-base',
					'aui-io-plugin',
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
							width : 1010,
							height : 90,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();
					//popUpWindow.show();
					popUpWindow.titleNode.html("The current requisiton has an open COS. <br /> Approve and disapprove actions are not available at this time.");
					//popUpWindow.io.start();
	 	});
			};
</aui:script>
									<!-- <div class="col-sm-4"><aui:button cssClass="btn btn-primary" type="button" onClick="auiModal();" value="Disapprove"></aui:button></div> -->
									<div class="col-sm-4"><button type="button" class="btn btn-primary" onclick="auiModal();">Disapprove</button></div>
							        <!-- <div class="col-sm-4"><aui:button onClick="auiModal();"  cssClass="btn btn-primary"  type="button" value="Approve"></aui:button></div> -->
							        <div class="col-sm-4"><button type="button" class="btn btn-primary" onclick="auiModal();">Approve</button></div>
							        <%
							         }
						        %>
							<%}%>
						</div>
					</div>
				</div>
			</div>
		</div>
	<%
		}
	%>
	<%
		if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_WAITINGONMANPOWER)){

	%>
		<div class="col-sm-12">
			<div class="wfm-system own-wrapper">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-4">
								<button type="button" class="btn btn-primary"
									onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
									View</button>
							</div>
							
							<%
							if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest, PortletPropsPermission.REQ_DIS_APPR_REQ_CMP_SPDM_HIDE, frompos.getDepartmentNumber())){

							if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_EDIT_REQ,frompos.getDepartmentNumber() )){ %>
							<div class="col-sm-4">
								<aui:button cssClass="btn btn-primary" type="button"
									value="Modify Requisition" onClick="addDataFunction();"></aui:button>
							</div>
							<%}if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_CNCL_REQ,frompos.getDepartmentNumber() )) {%>
							<div class="col-sm-4">
								<button type="submit" class="btn btn-primary"
									id="cancel" data-toggle="modal" data-backdrop="static" data-target="#myModal">Cancel
									Requisition</button>
							</div>
							<%}%>
							<%
                            if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest, PortletPropsPermission.REQ_FILL_REQ, frompos.getDepartmentNumber())){ %>
								<div class="col-sm-4">
								<%-- 	<a><button class="btn btn-primary" onclick="getUrl('<%=FillActionURL%>')">
											Fill Requisition</button></a> --%>
								
								<button id="dashboard_hma" name="redirectReq" type="button"
							class="btn btn-primary"
							onclick="fillRequisitionUrl('<%=FillActionURL.toString()%>')">Fill Requisition</button>
								</div>
							<%}%>
							<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_SBMT_REQ,frompos.getDepartmentNumber() )) {%>
							<div class="col-sm-4">

								<aui:button class="btn btn-primary"
									style="background: #f1f1f1;color: #333;text-shadow: none;"
									type="submit" name="mangeRequisition" id="mangeRequisition"
									value="Submit" disabled="true"
									onClick="validateText();requisitionformsubmit('modifyrequisitionOnWaitingOnmanpower');"></aui:button>

							</div>
							<%} %>
							<!-- 
							<div class="col-sm-3">
											<aui:button class="btn btn-primary" type="submit" name="saveRequisition" id="saveRequisition"
												onclick="requisitionformsubmit('modifyrequisitionSave');"
												value="Save"  disabled="true"></aui:button>
							</div> -->
							<%}%>
							<%--  <div class="col-sm-3">
								<aui:button class="btn btn-primary" name="saveRequisition" id="saveRequisition" type="submit" disabled="true" hidden="hidden"
									onclick="validateText();requisitionformsubmit('modifyrequisitionSaveOnWaitingOnmanpower');"
									value="Save" ></aui:button>
							</div>  --%>

							<aui:input type="hidden" name="buttonclick" id="buttonclick"
								value="" />

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<%
		if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER)){
	%>
		<div class="col-sm-12">
			<div class="wfm-system own-wrapper">
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
						<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_CMPLT_REQ,req.getNumber() )){ 
							if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest, PortletPropsPermission.REQ_FILLED_BUT_NO_ASSOCIATENUMBER, frompos.getDepartmentNumber())){

						%>
							<div class="col-sm-6">
								<button class="btn btn-primary" id="completeRequisition"
									type="button">Complete Requisition</button>
								<button class="btn btn-primary" id="complete"
									type="button">Complete</button>
							</div>
                        <%}}%>
							<div class="col-sm-6">
								<button type="button" class="btn btn-primary"
									onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
									View</button>
							</div>
							<aui:input type="hidden" name="buttonclick" id="buttonclick"
								value="" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<%
			}
		if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_SAVE)){
		%>
			<div class="col-sm-12">
				<div class="wfm-system own-wrapper">
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-only">
							<div class="small center">
								<div class="col-sm-4">
									<button type="button" class="btn btn-primary"
										onclick="exitviewUrl('<%=wmsBasePath%>/requisition')">Exit
										View</button>
								</div>
								<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_EDIT_REQ,req.getNumber() )){ %>
								<div class="col-sm-4">
									<aui:button cssClass="btn btn-primary" type="button"
										value="Modify Requisition" onClick="addDataFunction();"></aui:button>
								</div>
								<%} %>
								<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_CNCL_REQ,req.getNumber() )){ %>
								<div class="col-sm-4">
									<aui:button class="btn btn-primary"
										id="cancel" data-toggle="modal" data-backdrop="static" value="Cancel Requisition"
										data-target="#myModal"></aui:button>
								</div>
								<%} %>
								<%-- <div class="col-sm-3">

										<aui:button class="btn btn-primary" type="button" name="addRequisition" 
										 id="addRequisition" value="Add Data" onClick="addDataFunction()"></aui:button>
									
									</div> --%>
							  <%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_SBMT_REQ,req.getNumber() )){ %>
								<div class="col-sm-4">

									<aui:button cssClass="btn btn-primary" type="button"
										name="mangeRequisition" id="mangeRequisition" value="Submit"
										onClick="validateText();addDataFunctionOne();"></aui:button>



								</div>
								
								<div class="col-sm-4">
									<aui:button class="btn btn-primary" name="saveRequisition"
										id="saveRequisition" type="button" disabled="true"
										onclick="validateText();requisitionformsubmit('modifyrequisitionSave');"
										value="Save"></aui:button>
								</div>
								<%} %>
								<aui:input type="hidden" name="buttonclick" id="buttonclick"
									value="" />
							</div>
						</div>
					</div>
				</div>
			</div>
	<%
		}
	%>


	<div class="portlet-layout row">
		<div class="col-sm-12">
			<div class="wfm-system" style="margin-top: 20px;">
				<div class="portlet-layout row">
					<div class="portlet-column col-sm-6">
						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Line</div>

							<div class="portlet-column portlet-column-last col-sm-6">

								<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getLine()%></div>


							</div>
						</div>
						

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Posting
								Type</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="postingType_mainDiv">

								<aui:select name="postingType" id="postingType"
									class="field-select" onchange="postingTypevalidate();"
									placeholder="" label="" disabled="true">
									<aui:option value="" selected="<%=req.getPostingType().equals(StringPool.BLANK)%>">Select Posting Type</aui:option>
									<%
										values = ConfigUtility.getInputValuesFromConfig("requisation-type");
																							                                Arrays.sort(values);
																															for (String value : values) {
									%>
									<aui:option value="<%=value%>"
										selected="<%=req.getPostingType().equals(value)%>"><%=value%></aui:option>
									<%
										}
									%>

								</aui:select>
								<div class="postingType_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "postingType"
                </div>
								<div id="postingTypeerrormesg" class="form-required"></div>
							</div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Team
								Number</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="teamNumber_mainDiv">

								<aui:select name="teamNumber" id="teamNumber"
									cssClass="field-select chosenTeam"
									onchange="teamNumbervalidate();" placeholder="" label=""
									disabled="true" >
									<aui:option value="">Select Team Number</aui:option>
									<%
									
									List<String> reportToTeamNumber = HMAAssociateInfoService.getTeamNumberCos();
						              for ( String teamNumber : reportToTeamNumber) {  
						            	  if(Validator.isNotNull(teamNumber.trim())){
									%>
									<aui:option value="<%=teamNumber%>"
										selected="<%=(req.getTeamNumber().equals(teamNumber))%>"><%=teamNumber%></aui:option>
									<%
						            	  }	}
									%>
								</aui:select>
								<div class="teamNumber_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Team Number"
                </div>
								<div id="teamNumbererrormesg" class="form-required"></div>
							</div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Ladder</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getLadder()%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate
								Type</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="associatetype_mainDiv">
								<aui:select name="associatetype" id="associatetype"
									class="field-select" onchange="associatetypevalidate();"
									placeholder="" label="" disabled="true">
									<aui:option value="">Select Associate Type</aui:option>
									<%
										values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
																							     Arrays.sort(values);		                   
																							for(String value:values){
									%>
									<aui:option value="<%=value%>"
										selected="<%=(req.getAssociatetype().equals(value))%>"><%=value%></aui:option>
									<%
										}
									%>
								</aui:select>
								<div class="associatetype_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Associate Type"
                </div>
								<div id="associatetypeerrormesg" class="form-required"></div>
							</div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Shift
								Assignment</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="shiftassignment_mainDiv">


								<aui:select name="shiftAssign" id="shiftassignment"
									cssClass="chosenShiftassignment"
									onchange="shiftAssignvalidate();" placeholder="" label=""
									disabled="true">
									<aui:option value="">Select Shift Assignment</aui:option>
									<%
										Map<String,String> shiftMap = new HashMap<String,String>();
																														          shiftMap=ConfigUtility.getInputValuesForMap("shift-assignment");
																														          Map<String,String> shiftMaps = new TreeMap<String,String>(shiftMap);
																														          for(Map.Entry<String, String> entry : shiftMaps.entrySet()){
																							String total = entry.getKey()+":"+entry.getValue();
									%>
									<aui:option value="<%=entry.getKey()%>"
										selected="<%=req.getShiftAssign().equals(total)%>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
									<%
										}
									%>
								</aui:select>
								<div class="shiftassignment_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Shift Assignment"
                </div>
								
							</div>
						</div>
						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Who
								will this person report to?</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getReportsTo()%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">How
								did this Position become available?</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="howAvailable_mainDiv">

								<aui:select name="howAvailable" id="howAvailable"
									class="field-select" onchange="howAvailablevalidate()"
									placeholder="" label="" disabled="true">
									<aui:option value="">Select How did this Position become available?</aui:option>
									<%
										values = ConfigUtility.getInputValuesFromConfig("position-availableposition");
																							Arrays.sort(values);					                   
																							for(String value:values){
									%>
									<aui:option value="<%=value%>"
										selected="<%=(req.getHowAvailable().equals(value))%>"><%=value%></aui:option>
									<%
										}
									%>
								</aui:select>
								<div class="howAvailable_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "How did this Position become available?"
                </div>
								<div id="howAvailableerrormesg" class="form-required"></div>
							</div>
						</div>
					</div>

					<div class="portlet-column col-sm-6">

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Status</div>
							<%
								if(req.getStatus().equalsIgnoreCase("save")){
							%>
							<div class="portlet-column portlet-column-last col-sm-6">Draft</div>
							<%
								}
							                                
							                            else{
							%>
							<div class="portlet-column portlet-column-last col-sm-6"><%=req.getStatus()%></div>
							<%
								}
							%>
						</div>


						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Creator</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=req.getCreatedBy()%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date
								Created</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=HondaLogicUtil.getDateFormat(req.getCreateDate())%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date
								Approved</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=HondaLogicUtil.getDateFormat(req.getApprovedDate()) %></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department
								Name</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getDepartmentName()%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department
								Number</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getDepartmentNumber()%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department
								Manager</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=deptMap.get("deptMgrName")%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=frompos.getDivision()%></div>
						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division
								Manager</div>

							<div class="portlet-column portlet-column-last col-sm-6"><%=deptMap.get("divMgrName")%></div>
						</div>
					</div>
				</div>

				<div class="portlet-layout row">
					<div class="portlet-column col-sm-12">
						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">If
								replacement, replacement of whom?</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="whoReplacedRequired_maindiv">
								<input onkeyup="validatewhoReplaceField()" type="textarea" name="<portlet:namespace/>whoReplaced"
									label="" id="<portlet:namespace/>whoReplaced" 
									rows="1" maxlength="75" value="<%=req.getWhoReplaced()%>"
									disabled="true"> </input> 
									<div style="display:none;color: #b50303" class="whoReplacedRequired_ValidationMessage form-validator-stack help-inline">Missing required value for the field "If replacement, replacement of whom"</div>
							</div>


						</div>

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date
								Manpower needed?</div>
							<script type="text/javascript">
								function datevalidation(x) {
									if (x == '' ) {

										//$(".date_validate").html("Missing required value for the field &quot;Date Manpower needed? &quot;.");
										$(".date_validate").show();
										 $('#date_maindiv').addClass('control-group error');
										document.getElementById('<portlet:namespace/>hidden_field').value = '';
									} else {
										//$(".date_validate").html("");
										$(".date_validate").hide();
										$('#date_maindiv').removeClass('control-group error');
										$('#date_maindiv').css("background-color: white !important;border: 1px solid #ccc !important;");
									}
								
								}
							</script>
							<div class="portlet-column portlet-column-last col-sm-3" id="date_maindiv">
								<div id="#<portlet:namespace />startDatePicker">
												<aui:input name="dateneeded" label="" id="startDate"
												maxlength="70" title="Click Here" readOnly="true"
												placeholder="MM/DD/YYYY" value="<%=req.getDateneeded()%>"
												cssClass="datepicker" 
												errorMessageDivId="startDateErrorDiv"
												onFocus="clearErrorMessage('startDateErrorDiv');"
												onClick="clearErrorMessage('startDateErrorDiv');">
												</aui:input>
												
												 <!-- <div class="form-validator-stack help-inline"> -->
			 									
			 							 </div>
			 							 
			 							 <div class="date_validate form-validator-stack help-inline" style="display: none;">
                  							 Missing required value for the field "Date Manpower needed?"
              							 </div>	
									</div>	
							</div>
						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Contact
								Person for Interviews</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="contactperson_mainDiv">
								<aui:input type="textarea" name="contactperson"
									id="contactperson" label="" onkeyup="contactpersonvalidate();"
									value="<%=(req.getContactperson())%>" class="field" 
									placeholder="" rows="1" maxlength="75" disabled="true">

								</aui:input>
								<div class="contactperson_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Contact Person for Interviews"
                </div>
							</div>
						</div>


						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Contact
								Phone Number</div>

							<div class="portlet-column portlet-column-last col-sm-6" id="contactphonenumber_mainDiv">
								<aui:input type="textarea" name="contactphonenumber"
									id="contactphonenumber" label="" onkeyup="contactphonenumbervalidate();"
									value="<%=req.getContactphonenumber()%>" class="field"
									 rows="1" maxlength="75" disabled="true" >
								</aui:input>
								<div class="contactphonenumber_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Contact Phone Number"
                </div>
							</div>
						</div>

						<div class="portlet-layout row" style="margin-top: 30px">
							<div
								class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Taleo
								Number</div>

							<div class="portlet-column portlet-column-last col-sm-6" >
								<aui:input type="textarea" name="taleonumber" id="taleonumber" onkeyup=""
									class="field" value="<%=req.getTaleonumber()%>" label=""
									 rows="1" maxlength="75" disabled="true">
									
								</aui:input>
								<!-- <div id="taleonumber_ValidationMessage" class="form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Taleo Number"
                </div> -->
							</div>
						</div>
					</div>
				</div>


				<h3 class="subsection">Requisition Information</h3>

				<div class="portlet-layout row">
					<div
						class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Typical
						Job Title</div>

					<div class="portlet-column portlet-column-last col-sm-6">
						<textarea class="field"  disabled="disabled"
							placeholder="" rows="1"><%=frompos.getTypicalJobTitle()%></textarea>
					</div>
				</div>

				<div class="portlet-layout row">
					<div
						class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Minimum
						Job Relevant Knowledge (Know how)</div>
				<div class="requisition_IEBrowser" > <%=frompos.getMinJobKnowHow()%> </div>
					<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
						<textarea class="field"  disabled="disabled"
							placeholder="" rows="10"><%=frompos.getMinJobKnowHow()%></textarea>
					</div>
				</div>

				<div class="portlet-layout row">
					<div
						class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Prioritized
						duties and Responsibilities</div>
				<div class="requisition_IEBrowser" > <%=frompos.getDuties()%> </div>
					<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
						<textarea class="field"  disabled="disabled"
							placeholder="" rows="10"><%=frompos.getDuties()%></textarea>
					</div>
				</div>

				<div class="portlet-layout row">
					<div
						class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Daily
						Tasks Performed</div>
				<div class="requisition_IEBrowser" > <%=frompos.getTasksPerformed()%> </div>
					<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
						<textarea class="field"  disabled="disabled"
							placeholder="" rows="10"><%=frompos.getTasksPerformed()%></textarea>
					</div>
				</div>
					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Minimun
							Job Relevant Experience (length of service)</div>
					<div class="requisition_IEBrowser" > <%=frompos.getLengthOfService()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getLengthOfService()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Degree
							or certification required</div>
					<div class="requisition_Browser" style="border:1px solid black;width:587px;height:67px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=frompos.getDegree()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="3"><%=frompos.getDegree()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Required
							Skills (Musts)</div>
					<div class="requisition_IEBrowser" > <%=frompos.getReqSkills()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getReqSkills()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Desired
							Skills and Abilities (Wants)</div>
					<div class="requisition_IEBrowser" > <%=frompos.getDesiredSkills()%> </div>
						<div class="portlet-column portlet-column-last col-sm-6" style="display:none">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="10"><%=frompos.getDesiredSkills()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Environment
							Associate will work in</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="1"><%=frompos.getEnvironment()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Estimates
							Weekly Overtime</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="1"><%=frompos.getWeeklyOvertime()%></textarea>
						</div>
					</div>

					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Frequency
							and Duration of Travel</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<textarea class="field"  disabled="disabled"
								placeholder="" rows="1"><%=frompos.getFrequencyOfTravel()%></textarea>
						</div>
					</div>



					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Other</div>

						<div class="portlet-column portlet-column-last col-sm-6">
							<aui:input type="textarea" name="other" class="field"
								value="<%=req.getOther()%>"  placeholder="" rows="3"
								label="" maxLength="255">

							</aui:input>
						</div>
					</div>
					
					<div style="display: none;">
			<%
			String validation_type="0";
			
			%>
				 <aui:input type="hidden" required="true" name="hidden_field" id="hidden_field" value="1" label="" maxlength="75"></aui:input>
		                 <aui:input type="textarea" name="validation_type" label="" value="<%=validation_type%>"> </aui:input>
                        </div>
					
				</div>
			</div>
		</div>
	</div>

<%
	}
%>
</aui:form>

<div class="portlet-layout">
	<div class="logs_main" style="font-style: oblique; font-size: 12px">
		<b>Log:</b>
	</div>

	<div class="users col-sm-12">
		<div class="logs_comments" style="line-height: 9px; margin-bottom: 10px;">
			<%
				List<WFMS_Requisition_Audit> requisition_Audit= WFMS_Requisition_AuditLocalServiceUtil.findByReqIdForAudit(reqNumber);
			%>
			<%
				for(WFMS_Requisition_Audit wfms_audit :requisition_Audit){
			%>

			<div class="logs">
				<div class="user_comments" id="user_comments">
					<br> 
					<%=wfms_audit.getChange()%>
					By :
					<%=wfms_audit.getCreatedBy()%>
					-
					<%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate())%>
						<% if(wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.REQUISITION_DISAPPROVAL) || wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.REQUISITION_CANCEL)){%>
						<div class="comments" id="comments">
						&nbsp;<div class="log_comments" style="line-height: 19px;margin: -10px 0px -6px 0px;text-indent: 3px;"><b class="comment_title">Comments :</b><%=wfms_audit.getComments() %></div>
						</div>
						<%}%>
					<%-- <%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate())%><br /> --%>
					
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>

<div class="scroll_back_to_top">
	<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
</div>

<% if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_WAITINGONMANPOWER) || req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_DRAFT) || req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_SUBMITTED)){
 %>

<portlet:actionURL name="cancelRequisition" var="cancelRequisitionURL">
</portlet:actionURL>
<div class="container">

	<div class="modal fade" id="myModal" role="dialog" style="display:none;">
		<div class="modal-dialog">
			<aui:form method="post"
				action="<%=cancelRequisitionURL.toString()%>"
				name="cancelRequisition" id="cancelRequisition">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal">&times;</button>
						 
						<h4 class="modal-title">Are you sure you want to cancel this requisition?</h4>
					</div>
					<div class="modal-body">
						<aui:input type="hidden" name="reqid" value="<%=reqNumber%>" />
						<aui:input type="hidden" name="CancelStatus" value="<%=req.getStatus()%>" />
						<aui:input type="textarea" name="Comments" label="" value=""
							class="field" cols="5" maxlength="3000" placeholder="Comments" rows="3"
							required="true" />
					</div>
					<div class="modal-footer">
						<div class="col-sm-6 text-right">
							<aui:button type="submit" class="btn btn-primary" value="Save"></aui:button>
						</div>
						<div class="col-sm-6 text-left">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</aui:form>
		</div>
	</div>



</div>

<% }if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_SUBMITTED)){
 %>
<portlet:actionURL name="disapproveRequisition"
	var="disapproveRequisitionURL"></portlet:actionURL>
<div class="container">
	<div class="modal fade" id="disapproveRequisitionModal" role="dialog" style="display:none;">
		<div class="modal-dialog">
			<aui:form method="post"
				action="<%=disapproveRequisitionURL.toString()%>"
				name="disapproveRequisition" id="disapproveRequisition">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Please enter the reason for disapproval</h4>
					</div>
					<div class="modal-body">
						<aui:input type="hidden" name="reqid" value="<%=reqNumber%>" />
						<aui:input type="textarea" name="Comments" label="" value=""
							class="field" cols="5" maxlength="3000" placeholder="Comments" rows="3"
							required="true" />
					</div>
					<div class="modal-footer">
						<div class="col-sm-6 text-right">
							<aui:button type="submit" class="btn btn-primary" value="Save"></aui:button>
						</div>
						<div class="col-sm-6 text-left">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</aui:form>
		</div>
	</div>

</div>

<% } %>
<%if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_COMPLETE_PENDING_APPROVAL)){
 %>
<portlet:actionURL name="disapprovecomplete" var="disapprovecompleteURL"></portlet:actionURL>
<div class="container">
	<div class="modal fade" id="disapprovecompleteModal" role="dialog" style="display:none;">
		<div class="modal-dialog" style="width: 705px;">
			<aui:form method="post"
				action="<%=disapprovecompleteURL.toString()%>"
				name="disapprovecomplete" id="disapprovecomplete">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Please enter the reason for disapproval</h4>
					</div>
					<div class="modal-body">
						<aui:input type="hidden" name="reqid" value="<%=reqNumber%>" />
						<aui:input type="textarea" name="Comments" label="" value=""
							class="field" cols="5" maxlength="3000" placeholder="Comments" rows="3"
							required="true" />
					</div>
					<div class="modal-footer">
						<div class="col-sm-6 text-right">
							<aui:button type="submit" class="btn btn-primary" value="Save"></aui:button>
						</div>
						<div class="col-sm-6 text-left">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</aui:form>
		</div>
	</div>

</div>


<portlet:actionURL name="approvecomplete" var="approvecompleteURL"></portlet:actionURL>
<div class="container">
	<div class="modal fade" id="approvecompleteModal" role="dialog" style="display:none;">
		<div class="modal-dialog" style="width: 705px;">
			<aui:form method="post" action="<%=approvecompleteURL.toString()%>"
				name="approvecomplete" id="approvecomplete">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Enter the below fields to complete the Requisition</h4>
					</div>
					<div class="modal-body">
						<aui:input type="hidden" name="reqid" value="<%=reqNumber%>" />
						<aui:input type="hidden" name="positionId"
							value="<%=positionId%>" />

						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-4 sectionLabel ">MP
								Category Filled With</div>

							<div class="portlet-column portlet-column-last col-sm-8">
								<aui:select name="mpCatFilledWith" id="mpCatFilledWith"
									class="field-select" onChange="mpCatFilledWithvalidate();"
									placeholder="mp filled" required="true" label=""
									value="<%=frompos.getMpCatFilledWith()%>">
									<aui:option value="">Select MP Category Filled With</aui:option>
									<%-- <aui:option value="<%=wfmPosition.getMpCatFilledWith()%>"><%=wfmPosition.getMpCatFilledWith()%></aui:option> --%>
									<%
										values = ConfigUtility.getInputValuesFromConfig("position-mpcategoryfilledwith");
															  Arrays.sort(values);		
															for (String value : values) {
									%>
									<aui:option
										selected="<%=(null!=frompos.getMpCatFilledWith() && frompos.getMpCatFilledWith().equals(value))%>"
										value="<%=value%>"><%=value%></aui:option>
									<%
										}
									%>

								</aui:select>
								<div id="mpCatFilledWitherrormesg" class="form-required"></div>
							</div>
						</div>
						<% 
						
						 DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
						  wfmPositionforTemp.add(PropertyFactoryUtil.forName("associateNumber").eq(req.getAssociatenumber()));
						    Criterion posStatusCondition = null;
					        posStatusCondition = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.POS_FILLED);
					        posStatusCondition = RestrictionsFactoryUtil.or(posStatusCondition,
					        RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.POS_MODFIED));
					        wfmPositionforTemp.add(posStatusCondition);
						  
					        List<WFMS_Position> position=WFMS_PositionLocalServiceUtil.dynamicQuery(wfmPositionforTemp);
						if(position.size() > 0){ %>
							<p>The Associate (<%=req.getAssociatenumber() %>-<%=req.getAssociatename() %>) who has been selected for this Position is already assigned to Position <%=position.get(0).getPId()%>. Please click on 'Save' to generate Change of Status for this Associate.</p>
							<div style="display: none">
							<aui:input checked="true" inlineLabel="right"
										name="auto-gen-cos" type="radio" value="true" label="Yes"
										 /></div>
						<% }else{%>
						
						<h4 class="modal-title">Want to generate cos?</h4>
						<div class="portlet-layout row">
							<div
								class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Auto
								Generate Cos?</div>

							<div class="portlet-column portlet-column-last col-sm-8">
								<div class="col-sm-2">
									<aui:input checked="true" inlineLabel="right"
										name="auto-gen-cos" type="radio" value="true" label="Yes"
										 />
								</div>


								<div class="col-sm-2">
									<aui:input checked="true" inlineLabel="right"
										name="auto-gen-cos" type="radio" value="false" label="No" />
								</div>
							</div>
						</div>
						
						<% } %>
						
						
						<div class="modal-footer">
							<div class="col-sm-6 text-right">
								<aui:button type="submit" class="btn btn-primary" value="Save"></aui:button>
							</div>
							<div class="col-sm-6 text-left">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
			</aui:form>
		</div>
	</div>

</div>
<% } %>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> -->
<div class="modal fade" id="requisitionformsubmit" style="top: 10%!important;display:none">
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
					  		
							<li class="postingType_ValidationMessage col-sm-12 help-inline" style="display: none;">Posting Type</li>
	                   		<li class="teamNumber_ValidationMessage col-sm-12 help-inline" style="display: none;">Team Number</li>
	                   		<li class="associatetype_ValidationMessage col-sm-12 help-inline" style="display: none;">Associate Type</li>
	                        <li class="shiftassignment_ValidationMessage col-sm-12 help-inline" style="display: none;">Shift Assignment</li>
	                        <li class="howAvailable_ValidationMessage col-sm-12 help-inline" style="display: none;">How did this Position become available?</li>
	                        <li class="whoReplacedRequired_ValidationMessage col-sm-12 help-inline" style="display: none;">If replacement, replacement of whom?</li>
	                        <li class="contactperson_ValidationMessage col-sm-12 help-inline" style="display: none;">Contact Person for Interviews</li>
	                        <li class="contactphonenumber_ValidationMessage col-sm-12 help-inline" style="display: none;">Contact Phone Number</li>
	                        <li class="contactphonenumber_ValidationMessage col-sm-12 help-inline" style="display:none;">Date Manpower needed? </li>
	                        <li class="associatenumber_ValidationMessage col-sm-12 help-inline" style="display: none;">Filled with Associate Number</li>
	                        
	                   </ul>
	                 </div>
					
				</div>
				<div class="modal-footer" style="margin-top: 30px;">
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary" data-dismiss="modal" id="move_associate_close">Close</button>
						</div>
					</div>
			</div>
	</div>
</div>


<script type="text/javascript">
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

</script>

<aui:script>
	function redirectTocreaterequisation() {
		document.getElementById('<portlet:namespace />createRequisition')
				.submit();
	}


YUI({ lang: 'en' }).use(
		   'aui-datepicker',
		   function(Y) {
			   var today=new Date();
		     var datepicker = new Y.DatePicker(
		       {
		          trigger: '#<portlet:namespace />startDate',
		         mask: '%m/%d/%Y',
		         calendar: {
		         	
		        	   minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * 24 * 60))
		        	 //maximumDate:  new Date(today.getTime() + (1000 * 60 * 60 * 120)),

		        	},
		        	on: {
		                selectionChange: function(event) {
		                	$(".date_validate").hide();
							$('#date_maindiv').removeClass('control-group error');
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
		                     $(".date_validate").show();
								$('#date_maindiv').addClass('control-group error');
		                   }
		                 }
		               },             
		             ]]
		           },
		           zIndex: 1
		         }
		       }
		     );
		   }
		 );

window.onload = function() {
		//$('#associatenameNotreqid').hide();
		// $('#associatenameNotreqid').show();
	}
	function validateEmptyField() {
		var val = document.getElementById("<portlet:namespace/>associateName").value;

		if (val == '')
			$(".associateSpan").html("Missing required value for the field &quot;Name of Person Filling if no ID &quot;");
		else
			$(".associateSpan").html("");
		return true;
	}
	
	function validateText() {

		datevalidation($("#<portlet:namespace/>startDate").val());
		
		
		<% if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER)){ %>
		var a = document.getElementById("associatenumber");
		var b = document.getElementById("<portlet:namespace/>associateName");
		//var x, text;
		document.getElementById("<portlet:namespace/>hidden_field").value = '';

	if (a.value=='' && type==1) {
			$(".associatenumber_ValidationMessage").show();
		    $('#associatenumber_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');
	}
	else{
		$(".associatenumber_ValidationMessage").hide();
		$('#associatenumber_mainDiv').removeClass('control-group error');	
	}
		
		<% } %> 
		
	}    	
	
	function validatewhoReplaceField() {
		var howAvailable = document.getElementById("<portlet:namespace/>howAvailable").value;
		var whoReplaced = document.getElementById("<portlet:namespace/>whoReplaced").value;
		var type=$("#<portlet:namespace/>validation_type").val();
	   if(howAvailable=='Replacement'){
		   if (type == 1 ){    
		   		if (whoReplaced == ''){
				 	$(".whoReplacedRequired_ValidationMessage").show();
			        $('#whoReplacedRequired_mainDiv').addClass('control-group error');
				    $('#<portlet:namespace/>hidden_field').val('');
				 
				
			    }else{
				 	$(".whoReplacedRequired_ValidationMessage").hide();
			        $('#whoReplacedRequired_mainDiv').removeClass('control-group error');
				   }
		   }
	    }
	    else{
	    $('#<portlet:namespace/>whoReplaced').removeAttr('required');
	      // var message = document.getElementById('whoReplacedRequired');
	    //    message.style.color = "#b50303";
	     //       document.getElementById("whoReplacedRequired").innerHTML = "";
	            	$(".whoReplacedRequired_ValidationMessage").hide();
			        $('#whoReplacedRequired_mainDiv').removeClass('control-group error');
	    }
	    return true;    
    }
	function associateNameChange() {
	//	alert($('#<portlet:namespace/>associatenameNotreqid').val());
		var val = $("#associatenumber").val();
		var type=$("#<portlet:namespace/>validation_type").val();
		//alert(val);
		if (val == 'None') {
			
			//alert("if");
			$('#assName').hide();
			//alert("hide");
			$('#associatenameNotreqid').show();
			
		}
		
		<% if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER)){ %>
		if (val=='' && type==1) {
			
				$(".associatenumber_ValidationMessage").show();
			    $('#associatenumber_mainDiv').addClass('control-group error');
				$('#<portlet:namespace/>hidden_field').val('');
		}
		else{
			$(".associatenumber_ValidationMessage").hide();
			$('#associatenumber_mainDiv').removeClass('control-group error');	
		}

		<% } %>
			//alert($('#_WFMPosition_WAR_HMAWorkforceManagementSystemportlet_associatenumber').val())
			if (val!= 'None'){
			$('#associatenameNotreqid').hide();
			var deptId = $("#associatenumber").val();
			$.ajax({
				url : '<%=resourceURL.toString()%>',
				data : {
					<portlet:namespace />cmd : 'getAssName',
					<portlet:namespace />cmdType : deptId

				},

				type : "POST",
				dataType : "json",
				success : function(data) {
					$('#assName').html(data.AssName);
					$('#assName').show();
					//	$('#DEPT_NAME').html(data.DEPT_NAME);
				},
				error : function(response) {
					console.log("Error seen for for loadDivisonDepName");
				}
			});
			}	
	}

	jQuery(document).ready(function() {
		jQuery(".chosen").data("placeholder", "Select Frameworks...").chosen({
			search_contains : true
		});
		<%
	if(req.getAssociatenumber().equalsIgnoreCase("None")){
	%>
		$('.assName').hide();
		<%
	}
	%>
		$("#associatenumber").change(function() {
			$('.assName').hide();
			$('#associatenameNotreqid').show();
		});

		/* if (document.getElementById('autogencos').checked) {
			<%
			List<WFMS_COS> wfsm_cos = WFMS_COSLocalServiceUtil.findBynewPositionNumber(positionId);
			if(wfsm_cos.size()>0){
			%>
			
			
			
			<%
			}
			%>
		}*/
	}

	); 

	
	
	function requisitionformsubmit(value) {
		$('#<portlet:namespace/>hidden_field').val('1'); 
        if(value == "modifyrequisitionSave"){       
                $('#<portlet:namespace/>validation_type').val(0);
        }
        else{
               $('#<portlet:namespace/>validation_type').val(1);
        }
        
         postingTypevalidate();
         teamNumbervalidate();
         associatetypevalidate();
         shiftAssignvalidate();
         howAvailablevalidate();
         contactpersonvalidate();
         contactphonenumbervalidate();
         datevalidation($("#<portlet:namespace/>startDate").val());
         
		var hiddenval=$('#<portlet:namespace/>hidden_field').val();
		
		var auiForm = Liferay.Form._INSTANCES.<portlet:namespace/>manageRequisition;
		var auiValidator = auiForm.formValidator;
		auiValidator.validate();

		if (hiddenval!='' || !auiValidator.hasErrors()) {
		 $('#requisitionformsubmit').modal('hide');
			$("button[type=button]").attr('disabled',true); 
			$("#<portlet:namespace/>manageRequisitionValue").val(value);
		
		$("#<portlet:namespace/>manageRequisition").submit();
		} else if(value == "modifyrequisitionSave"){
		
             $("#<portlet:namespace/>manageRequisition").submit();
        } else{
		$('#requisitionformsubmit').modal({ backdrop: 'static',
		               keyboard: true, 
		               show: true});
			}
		
		/*var postingType = document
				.getElementById("<portlet:namespace />postingType");
		var teamNumber = document
				.getElementById("<portlet:namespace />teamNumber");
		var associateType = document
				.getElementById("<portlet:namespace />associatetype");
		var shiftAssignment = document
				.getElementById("<portlet:namespace />shiftassignment");
		var howAvilable = document
				.getElementById("<portlet:namespace />howAvailable");
				*/
				
		

		$("#<portlet:namespace/>buttonclick").val(value);

		//console.log(auiValidator.hasErrors());
		
		<% if(req.getStatus().equalsIgnoreCase(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER)){ %>
		var associatenumber = document.getElementById("associatenumber");
		var associateName = document.getElementById("<portlet:namespace />associateName");
		
		
//alert("tets"+associatenumber+associateName);

		var associateNamevalue = true;
		if (associatenumber.value == "") {
			$('#<portlet:namespace/>hidden_field').val(''); 
		}
		if (associatenumber.value == "None") {
			if ((associateName.value).trim() == '') {
				validateText();
				
				associateNamevalue = false;
				$('#<portlet:namespace/>hidden_field').val(''); 
			}
		}
		<% } %>
		// alert("enter1");
			howAvailablevalidate();
			//alert("enter2");
			associatetypevalidate();
			//alert("enter3");
			postingTypevalidate();
			//alert("enter4");
			teamNumbervalidate();
			//alert("enter5");
			//taleonumbervalidate();
			//alert("enter6");
			contactphonenumbervalidate();
			//alert("enter7");
			contactpersonvalidate();
			//alert("enter8");
			shiftAssignvalidate();
			//alert("enter9");
			validatewhoReplaceField();
			//alert("enter10");
        //alert($('#<portlet:namespace/>hidden_field').val());
		
	}
	$(".isModifyClicked").hide();
	/*function selectbuttonclick(value) {
		//alert(value);
		console.log(value);
		$("#<portlet:namespace/>buttonclick").val(value);
		$("#<portlet:namespace/>manageRequisition").submit();
	}*/
	function enablefield() {
		//alert("submit");
		$(".isModifyEnable").hide();
		$(".isModifyClicked").show();
                $('#<portlet:namespace/>startDate').addClass('datepicker');
		$('#<portlet:namespace />postingType').removeAttr("disabled");
		$('#<portlet:namespace />teamNumber').removeAttr("disabled");
		$('#<portlet:namespace />howAvailable').removeAttr("disabled");
		$('#<portlet:namespace />associatetype').removeAttr("disabled");
		$('#<portlet:namespace />shiftassignment').removeAttr("disabled");
		$(".chosenShiftassignment").data("placeholder", "Select Frameworks...")
				.chosen({
					search_contains : true
				});
		
		$('#<portlet:namespace />contactperson').removeAttr("disabled");
		$('#<portlet:namespace />startDate').removeAttr("disabled");
		$('#<portlet:namespace/>whoReplaced').removeAttr("disabled");
		$('#<portlet:namespace />contactphonenumber').removeAttr("disabled");
		$('#<portlet:namespace />taleonumber').removeAttr("disabled");
		var associatenumber = $('#associatenumber').removeAttr("disabled");
		$('#<portlet:namespace />associateName').removeAttr("disabled");
		$(".chosenAssociate").data("placeholder", "Select Frameworks...")
				.chosen({
					search_contains : true
				});
       		/* document.getElementById("<portlet:namespace/>saveRequisition").disabled = false;
		$("#<portlet:namespace/>saveRequisition").removeClass("disabled"); */
		
		
		/* $("#<portlet:namespace />save").removeAttr("hidden");
		$("#<portlet:namespace />Submit").removeAttr("hidden");
		document.getElementById("modify").style.visibility = 'hidden';
		document.getElementById("cancel").style.visibility = 'hidden';
		document.getElementById("approve").style.visibility = 'hidden';
		document.getElementById("disapproveRequisition").style.visibility = 'hidden';
		document.getElementById("CancelRequisition").style.visibility = 'hidden'; */
	}
	function completeRequisition() {
		document.getElementById("associatenumber").disabled = false;
		//alert("enabled");
		$(".chosenAssociate").data("placeholder", "Select Frameworks...")
				.chosen({
					search_contains : true
				});
		<% if(req.getAssociatenumber().equals("None")){ %>
		$('#<portlet:namespace />associateName').removeAttr("disabled");
		<% } %>
	}

	function addDataFunction() {

		document.getElementById("associatenumber").disabled = false;

		$(".chosenAssociate").data("placeholder", "Select Frameworks...")
				.chosen({
					search_contains : true
				});
		<% if(req.getAssociatenumber().equals("None")){ %>
		$('#<portlet:namespace />associateName').removeAttr("disabled");
		<%} %>
		document.getElementById("<portlet:namespace/>postingType").disabled = false;
		document.getElementById("<portlet:namespace/>teamNumber").disabled = false;
		$(".chosenTeam").data("placeholder", "Select Frameworks...").chosen({
			search_contains : true
		});

		document.getElementById("<portlet:namespace/>associatetype").disabled = false;
		document.getElementById("<portlet:namespace/>shiftassignment").disabled = false;
		$(".chosenShiftassignment").data("placeholder", "Select Frameworks...")
				.chosen({
					search_contains : true
				});

		document.getElementById("<portlet:namespace/>howAvailable").disabled = false;
		document.getElementById("<portlet:namespace/>whoReplaced").disabled = false;
		document.getElementById("<portlet:namespace/>startDate").disabled = false;

		document.getElementById("<portlet:namespace/>contactperson").disabled = false;
		document.getElementById("<portlet:namespace/>contactphonenumber").disabled = false;
		document.getElementById("<portlet:namespace/>taleonumber").disabled = false;

		document.getElementById("<portlet:namespace/>other").disabled = false;

		document.getElementById("<portlet:namespace/>mangeRequisition").disabled = false;
		$("#<portlet:namespace/>mangeRequisition").removeClass("disabled");
		document.getElementById("<portlet:namespace/>saveRequisition").disabled = false;
		$("#<portlet:namespace/>saveRequisition").removeClass("disabled");
		//

	}
</aui:script>
	
<aui:script>
function requisitionformsave(value) {
	
	console.log(value);
	$("#<portlet:namespace/>buttonclick").val(value);
	$("#<portlet:namespace/>manageRequisition").submit();
}
</aui:script>
<aui:script>
function addDataFunctionOne() {

	$("#<portlet:namespace/>buttonclick").val("modifyrequisitionSubmit");

	document.getElementById("associatenumber").disabled = false;
	document.getElementById("<portlet:namespace/>associateName").disabled = false;
	$(".chosenAssociate").data("placeholder", "Select Frameworks...")
			.chosen({
				search_contains : true
			});

	document.getElementById("<portlet:namespace/>postingType").disabled = false;
	document.getElementById("<portlet:namespace/>teamNumber").disabled = false;
	$(".chosenTeam").data("placeholder", "Select Frameworks...").chosen({
		search_contains : true
	});

	document.getElementById("<portlet:namespace/>associatetype").disabled = false;
	document.getElementById("<portlet:namespace/>shiftassignment").disabled = false;
	$(".chosenShiftassignment").data("placeholder", "Select Frameworks...")
			.chosen({
				search_contains : true
			});

	document.getElementById("<portlet:namespace/>howAvailable").disabled = false;
	document.getElementById("<portlet:namespace/>whoReplaced").disabled = false;
	document.getElementById("<portlet:namespace/>startDate").disabled = false;

	document.getElementById("<portlet:namespace/>contactperson").disabled = false;
	document.getElementById("<portlet:namespace/>contactphonenumber").disabled = false;
	document.getElementById("<portlet:namespace/>taleonumber").disabled = false;

	document.getElementById("<portlet:namespace/>other").disabled = false;

	var postingType = document
			.getElementById("<portlet:namespace />postingType");
	var teamNumber = document
			.getElementById("<portlet:namespace />teamNumber");
	var associateType = document
			.getElementById("<portlet:namespace />associatetype");
	var shiftAssignment = document
			.getElementById("<portlet:namespace />shiftassignment");
	var howAvilable = document
			.getElementById("<portlet:namespace />howAvailable");
	var associatenumber = document.getElementById("associatenumber");
	var associateName = document
			.getElementById("<portlet:namespace />associateName");

		//console.log(auiValidator.hasErrors());

		var associateNamevalue = true;
		if (associatenumber.value == "None") {
			if ((associateName.value).trim() == '') {
				associateNamevalue = false;
			}

		}
		if ((postingType.value).trim() != '' && (teamNumber.value).trim() != ''
				&& (associateType.value).trim() != ''
				&& (shiftAssignment.value).trim() != ''
				&& (howAvilable.value).trim() != ''
				&& (associatenumber.value).trim() != '' && associateNamevalue) {

			document.getElementById('<portlet:namespace/>hidden_field').value = '1';
		} else {
			howAvailablevalidate();
			associatetypevalidate();
			postingTypevalidate();
			teamNumbervalidate();
			//taleonumbervalidate();
			contactphonenumbervalidate();
			contactpersonvalidate();
			shiftAssignvalidate();
			validatewhoReplaceField(); 
			document.getElementById('<portlet:namespace/>hidden_field').value = '';
		

		}
		var auiForm = Liferay.Form._INSTANCES.<portlet:namespace/>manageRequisition;
		var auiValidator = auiForm.formValidator;
		auiValidator.validate();

		if (!auiValidator.hasErrors()) {
			$("#<portlet:namespace/>manageRequisition").submit();
		}

	}
	$(document).ready(function() {
		$("#associatenumber").trigger('change');
		$(".date_validate").hide();
		$("#errormesg").html("");
		$("#complete").hide();
		$("#completeRequisition").click(function() {
			var asnum = $('#associatenumber').prop("disabled");
			if ($('#associatenumber').prop("disabled") == true) {
				completeRequisition();
				//alert("enter");
				$("#completeRequisition").hide();
				$("#complete").show();
			}
			//var hiddenval=$('#<portlet:namespace/>hidden_field').val();
			

		});
		$("#complete").click(function() {
			
			//$(".date_validate").hide();		
			var assnum = $('#associatenumber').val();
			//alert("assnum"+assnum);
			var associateName = $('#<portlet:namespace />associateName').val();
			//alert("associateName"+associateName);
			if(assnum==""){
				$(".associatenumber_ValidationMessage").show();
				
			    $('#associatenumber_mainDiv').addClass('control-group error'); 
			    $('#assName').hide();
			    $('#requisitionformsubmit').modal({ backdrop: 'static',
		               keyboard: true, 
		               show: true});
            }
			else if(assnum=='None' && associateName==''){
				
				$(".associatenumber_ValidationMessage").hide();
			    $('#associatenumber_mainDiv').removeClass('control-group error'); 
				validateEmptyField();
				$('#requisitionformsubmit').modal({ backdrop: 'static',
		               keyboard: true, 
		               show: true});
				//$('#associatenumber').val("");
			}
			else if ((assnum != '' && assnum != 'None') || (assnum=='None' && associateName!='')) {
				$('#requisitionformsubmit').modal('hide');
				$("#<portlet:namespace/>buttonclick").val("Complete");
				$("#<portlet:namespace/>manageRequisition").submit();
			}
			else{
				validateEmptyField();
			}
		});
	});
	function teamNumbervalidate() {
		
		var type=$("#<portlet:namespace/>validation_type").val();
		var val = document
				.getElementById("<portlet:namespace />teamNumber").value;
		if(val=='' && type==1){
		$(".teamNumber_ValidationMessage").show();
		        $('#teamNumber_mainDiv').addClass('control-group error');
		$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
		$(".teamNumber_ValidationMessage").hide();
		        $('#teamNumber_mainDiv').removeClass('control-group error');
		}
		document.getElementById(
				"<portlet:namespace />teamNumber")
				.focus();
	}
	function postingTypevalidate() {
		var type=$("#<portlet:namespace/>validation_type").val();
		var val = document
				.getElementById("<portlet:namespace />postingType").value;
		if(val=='' && type==1){
				$(".postingType_ValidationMessage").show();
				$('#postingType_mainDiv').addClass('control-group error');
				$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
		$(".postingType_ValidationMessage").hide();
		        $('#postingType_mainDiv').removeClass('control-group error');
		}
		document.getElementById(
				"<portlet:namespace />postingType")
				.focus();
	}

	function associatetypevalidate() {
		var type=$("#<portlet:namespace/>validation_type").val();
		var val = document
				.getElementById("<portlet:namespace />associatetype").value;
		if(val=='' && type==1){
		$(".associatetype_ValidationMessage").show();
		        $('#associatetype_mainDiv').addClass('control-group error');
		$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
		$(".associatetype_ValidationMessage").hide();
		        $('#associatetype_mainDiv').removeClass('control-group error');
		}
		/* 
		if (val == '') {
			text = "Missing required value for the field &quot;Associate Type &quot;";
			document
					.getElementById("associatetypeerrormesg").innerHTML = text;
		} else {
			document
					.getElementById("associatetypeerrormesg").innerHTML = '';
		}
	 */	document.getElementById(
				"<portlet:namespace />associatetype")
				.focus();
	}
	function shiftAssignvalidate() {
		var val = document.getElementById("<portlet:namespace />shiftassignment").value;
		var type=$("#<portlet:namespace/>validation_type").val();
		if(val=='' && type==1){
		$(".shiftassignment_ValidationMessage").show();
	    $('#shiftassignment_mainDiv').addClass('control-group error');
		$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
		$(".shiftassignment_ValidationMessage").hide();
		        $('#shiftassignment_mainDiv').removeClass('control-group error');
		}
	/* if (val == '') {
			text = "Missing required value for the field &quot;Shift Assignment &quot;";
			document
					.getElementById("shiftassignmenterrormesg").innerHTML = text;
		} else {
			document
					.getElementById("shiftassignmenterrormesg").innerHTML = '';
		} */
		document.getElementById(
				"<portlet:namespace />shiftassignment")
				.focus();
	}

	function howAvailablevalidate() {
		validatewhoReplaceField();
		var val = document.getElementById("<portlet:namespace />howAvailable").value;
		var type=$("#<portlet:namespace/>validation_type").val();
		if(val=='' && type==1){
		    $(".howAvailable_ValidationMessage").show();
		    $('#howAvailable_mainDiv').addClass('control-group error');
		   $('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
		        $(".howAvailable_ValidationMessage").hide();
		        $('#howAvailable_mainDiv').removeClass('control-group error');
		}
		/* if (val == '') {
			text = "Missing required value for the field &quot;How did this Position become available? &quot;";
			document.getElementById("howAvailableerrormesg").innerHTML = text;
		} else {
			document.getElementById("howAvailableerrormesg").innerHTML = '';
		} */
		document.getElementById("<portlet:namespace />howAvailable").focus();
	}
	
	 function contactpersonvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />contactperson").val());
		if(val=='' && type==1){
			$(".contactperson_ValidationMessage").show();
                        $('#contactperson_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".contactperson_ValidationMessage").hide();
                        $('#contactperson_mainDiv').removeClass('control-group error');
		}
	}
	
	 function contactphonenumbervalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />contactphonenumber").val());
		if(val=='' && type==1){	
			$(".contactphonenumber_ValidationMessage").show();
                        $('#contactphonenumber_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".contactphonenumber_ValidationMessage").hide();
                        $('#contactphonenumber_mainDiv').removeClass('control-group error');
		}
	}
	 
</aui:script>

<% if(renderRequest.getParameter("printRequisition") == null){ %>
<div class="print"  id="printableArea">
<%@ include file="/html/requisition/print-requisition.jsp" %> 
</div>
<%} %>

<script type="text/javascript">
function fillRequisitionUrl(url) {
    window.location.href = url;
}
function exitviewUrl(url) {
	window.location.href = url;
}
function discardUrl(url) {
	window.location.href = url;
}
 		function printDiv(divName) {

 	        var printContents = document.getElementById(divName).innerHTML;
 	        w = window.open();

 	        w.document.write(printContents);
 	        w.document.write('<scr' + 'ipt type="text/javascript">' + 'window.onload = function() { window.print(); window.close(); };' + '</sc' + 'ript>');

 	        w.document.close(); // necessary for IE >= 10
 	        w.focus(); // necessary for IE >= 10

 	        return true;
 	    }
    </script>
<style type="text/css"  > 
	.print { display:none; } 
</style>
<style type="text/css" media="print">
	.manageRequisition { display:block;}
	.print { display:none; }
</style>
<%LocalDateTime today1 = LocalDateTime.now(); 
System.out.println("<<<<load End Time>>>>>>"+today1); %>