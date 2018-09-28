<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Position"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService"%>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaPermissionKeys"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_COS"%>
<%@ page trimDirectiveWhitespaces="true" %>
<div class="manageCOS">
<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />
<portlet:actionURL name="updateCommentsCOS" var="updateCommentsCOSURL"></portlet:actionURL>
<portlet:actionURL name="updateCosofPos" var="updateCosofPosURL"></portlet:actionURL>
<portlet:actionURL name="updateCosofTitle" var="updateCosofTitleURL"></portlet:actionURL>
<portlet:actionURL name="updateChangeOfStatus" var="updateChangeOfStatusURL"></portlet:actionURL>
<portlet:actionURL name="cancelCOS"	var="cancelCOSURL"></portlet:actionURL>
<portlet:actionURL name="disapproveCos" var="disapproveCosURL"></portlet:actionURL>
<%
	String posID="";
	String mgrassoID="";
	WFMS_COS wfmsCOS = (WFMS_COS) request.getAttribute("wfms_CosObj");
	String disable="0"; 
	if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_SUBMIT) || wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){
		disable="1";
	}
	
	String cosId=(String)request.getAttribute("cosId");
	//WFMS_COS wfmsCOS = WFMS_COSLocalServiceUtil.getByCOSId(cosId);
	String[] values = null;
	//List<WFMS_routing_and_approvers> wfmslist=WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approverses(-1, -1);
	String emailToName = "";
	Role role;
	String NextApprover = "";
	
%>

<portlet:resourceURL var="AssNumURL">
<portlet:param name="<%=Constants.CMD %>" value="getAssNumURL"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="newPositionURL">
<portlet:param name="<%=Constants.CMD %>" value="getnewPositionURL"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="deptNUmberURL">
<portlet:param name="<%=Constants.CMD %>" value="LoadDivisionNames"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="ManagerAssoNoURL">
<portlet:param name="<%=Constants.CMD %>" value="ManagerAssoNoURL"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="NewPositionNumURL">
<portlet:param name="<%=Constants.CMD %>" value="getNewPositionNumURL"></portlet:param>
</portlet:resourceURL>

<portlet:actionURL name="approveCOS" var="approveCOSURL">
  <portlet:param name="cosId" value="<%=wfmsCOS.getCosId() %>" />
</portlet:actionURL>


<aui:form action="<%=updateCosofPosURL.toString() %>" method="post" name="updateCosofPos"></aui:form>

<aui:form action="<%=approveCOSURL.toString() %>" method="post" name="approveCOS">
<aui:input type="hidden" name="cosId" value="<%=wfmsCOS.getCosId() %>"/>
</aui:form>

<aui:form action="<%=updateCosofTitleURL.toString() %>" method="post" name="updateCosofTitle"></aui:form>

<aui:form action="<%= updateChangeOfStatusURL.toString()%>" method="post"
	name="updateChangeOfStatus" id="updateChangeOfStatus">

<div class="portlet-layout">
		<h2 class="titleArea">Manage Change of Status
			<input class="titleArea" type="button" value="Print" id="btnPrint" onclick="printDiv('printableArea')"/>
		</h2>
</div>

<div class="portlet-layout">
	<div class="col-sm-12">
		<div class="wfm-system ">
			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-6">
					 <div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5">
							<span class="sectionLabel">Associate Number</span>
						</div>

						<div class="portlet-column portlet-column-last col-sm-7">
							<aui:select name="assoicateId" id="associaNumber" onChange="loadAssociateNo();" required="true" cssClass="field-select chosen" label="" showRequiredLabel="false" maxlength="75" disabled='<%=disable.equals("1") %>'  >
								<%-- <aui:option value="<%=wfmsCOS.getAssoicateId() %>"><%=wfmsCOS.getAssoicateId() %></aui:option> --%>
								<aui:option value="">Select Associate Number</aui:option>
 <aui:option selected="true" value="<%=wfmsCOS.getAssoicateId().trim()%>"><%=wfmsCOS.getAssoicateId().trim()+" - "+wfmsCOS.getAssociatename() %></aui:option>
									</aui:select> 
						</div>
					</div>
 
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5">
							<span class="sectionLabel">Associate Name</span>
						</div>

						<div class="portlet-column portlet-column-last col-sm-7" id="associateName">
						<div class="portlet-column portlet-column-last" id="assoName" name="assoName"><%=wfmsCOS.getAssociatename() %></div>
						</div>
					</div>
				</div>

				<div class="portlet-column portlet-column-first col-sm-6"></div>
			</div>
		</div>
	</div>
</div>

<% if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_SUBMIT)){ %>
<div class="portlet-layout">
		<div class="col-sm-12 own-wrapper">
			<div class="wfm-system">
				<div class="portlet-layout">
					<div class="portlet-column portlet-column-first">
						<div class="small center">
							<div class="col-sm-4">
							<button type="button" class="btn btn-primary" onclick="getUrl('<%=wmsBasePath%>/change-of-status')">Exit View</button>
							
								<aui:input type="hidden" name="auto-gen-req-choice"/>
							</div>
							<% //if(WMSUserAccessUtil.checkBtnVisibilityCOSApprove(cosId, renderRequest)){ %>
							<% if(WMSUserAccessUtil.checkBtnVisibilityCOSApprove(cosId, renderRequest,PortletPropsPermission.COS_APPROVAL_PROCESS)){ %>
							<div class="col-sm-4">							
							    <aui:button cssClass="btn btn-primary" type="button" onClick="approveSubmit();this.disabled=true" value="Approve"></aui:button>
							</div>
							<div class="col-sm-4">
								<aui:button type="button" cssClass="btn btn-primary" 
								id="cancel" data-toggle="modal" data-target="#disapproveCosModal" data-backdrop="static" value="Disapprove"> </aui:button>
							</div>
							
							<div class="col-sm-4">
								<aui:button type="button" cssClass="btn btn-primary" data-backdrop="static"
								id="cancel" data-toggle="modal" data-target="#myModal" value="Cancel"> </aui:button>
							</div>
							<%}	%>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
<%} %>

<% if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_CANCELLED)){ %>
<div class="portlet-layout row">
		<div class="col-sm-12 own-wrapper">
			<div class="wfm-system">
				<div class="portlet-layout">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-4">
			<button type="button" class="btn btn-primary" onclick="getUrl('<%=wmsBasePath%>/change-of-status')">Exit View</button>

								</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	

<%} %>

<% if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_DISAPPROVED)){ %>
<div class="portlet-layout row">
		<div class="col-sm-12 own-wrapper">
			<div class="wfm-system">
				<div class="portlet-layout">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-4">
							<button type="button" class="btn btn-primary" onclick="getUrl('<%=wmsBasePath%>/change-of-status')">Exit View</button>
							
								<aui:input type="hidden" name="auto-gen-req-choice"/>
							</div>
							<div class="col-sm-4">
								<aui:button cssClass="btn btn-primary" type="button" value="Modify"></aui:button>
							</div>
							<div class="col-sm-4">
								<aui:button cssClass="btn btn-primary" type="button" value="Add Data"></aui:button>
							</div>
							<div class="col-sm-4">
								<aui:button type="button" cssClass="btn btn-primary" data-backdrop="static"
								id="cancel" data-toggle="modal" data-target="#myModal" value="Cancel"> </aui:button>
							</div>
							<div class="col-sm-4">
								<aui:button cssClass="btn btn-primary" type="submit" name="updateChangeOfStatus" id="updateChangeOfStatus"  value="Submit"></aui:button>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>

<%} %>

<% if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){ %>
<div class="portlet-layout row">
		<div class="col-sm-12 own-wrapper">
			<div class="wfm-system">
				<div class="portlet-layout">
					<div class="portlet-column portlet-column-only">
						<div class="small center">
							<div class="col-sm-4">
							<button type="button" class="btn btn-primary" onclick="getUrl('<%=wmsBasePath%>/change-of-status')">Exit View</button>

							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
<%} %>

<div class="portlet-layout row">
	<div class="col-sm-12">
		<div class="wfm-system" style="margin-top:20px;">
		    <div class="portlet-layout row">

		        <div class="portlet-column col-sm-6">

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Change of Status number</div>

		                 <div class="portlet-column portlet-column-last col-sm-7"><%=wfmsCOS.getCosId() %>
		                <aui:input type="hidden" name="cos-number" id="cos-number" value="<%=wfmsCOS.getCosId()%>" /> 
		            	</div> 
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Created By</div>

		                <div class="portlet-column portlet-column-last col-sm-7" ><% if(wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2){%>System Generated<%}else{%><%=wfmsCOS.getCreatedBy() %><%} %></div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Effective Date<br>(<i>Should be Thursday of the week</i>)</div>

		                <div class="portlet-column portlet-column-last col-sm-7">
		                
			                <div id="#<portlet:namespace />startDatePicker">
									<aui:input name="effectiveDate" disabled='<%=disable.equals("1") %>' required="true" label="" id="startDate" value="<%=wfmsCOS.getEffectiveDate() %>"
											maxlength="70" title="Click Here" readOnly="true" placeholder="MM/DD/YYYY"
											style="cursor:pointer;background-color: white;width:205px;" errorMessageDivId="startDateErrorDiv"
											onFocus="clearErrorMessage('startDateErrorDiv');"
											onClick="clearErrorMessage('startDateErrorDiv');">
									</aui:input>
									<!-- Edit and Save buttons for Effective Date -->
									<% if((WMSUserAccessUtil.checkPermission(renderRequest,PortletPropsPermission.COS_EDIT_COMMENTS))){ %>
									<button id="editEffectiveDate" style="width: auto; margin-top:-10px " onclick="editComment()"><i class="icon-edit"></i>&nbsp;Edit</button>
									<button id="saveEffectiveDate" onclick="saveComments()" style="width: auto;  margin-top:-10px " disabled ><i class="icon-check"></i>&nbsp;Save</button>
									<%} %>
							</div>
		                </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Change Description</div>

		                <div class="portlet-column portlet-column-last col-sm-7" id="changeDescription">
		              
		                     <aui:select name="type" label="" showRequiredLabel="false" required="true" disabled='<%=disable.equals("1") %>'>
		                      
		                     <aui:option value="<%=wfmsCOS.getType() %>"><%=wfmsCOS.getType() %></aui:option>
		                     	<%-- <% 	
		                     	
		                     	for(WFMS_routing_and_approvers list:wfmslist){
		                     		
								%>
								  <aui:option selected="<%=wfmsCOS.getType().equals(list.getChangeDescription()) %>" value="<%= list.getChangeDescription() %>"><%= list.getChangeDescription() %></aui:option>
							<% } %> --%>
								
							</aui:select>
		                </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Requisition Number</div>

		                <div class="portlet-column portlet-column-last col-sm-7"><%if(wfmsCOS==null) {}else{if(wfmsCOS.getSystemGenerated() == 1 && Validator.isNotNull(wfmsCOS.getRequistionId())){%><%=wfmsCOS.getRequistionId()%><%}}%> </div>
		            </div>
		            
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel  ">Should this be announced</div>
						<div class="portlet-column portlet-column-last col-sm-7">				
						       <% if(wfmsCOS.getAnnounced()==1) {%> 	
						             <input type="radio" name="<portlet:namespace/>announced" value="1"   checked="checked" disabled="disabled"/>Yes 
						             <input type="radio" name="<portlet:namespace/>announced" value="0"   disabled="disabled"/>No  						      
						      <% }else {%>
						             <input type="radio" name="<portlet:namespace/>announced" value="1"   disabled="disabled"/>Yes 
						             <input type="radio" name="<portlet:namespace/>announced" value="0"  checked="checked" disabled="disabled"/>No 
						      <% } %>
						</div>
		            </div> 

		        </div>

		        <div class="portlet-column col-sm-6">

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Status</div>

		                <div class="portlet-column portlet-column-last col-sm-7">
		                <%=wfmsCOS.getStatus() %>
		                <aui:input type="hidden" name="status" class="field-select" value="<%=wfmsCOS.getStatus() %>"></aui:input>
		               
		                </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date Created</div>
		
					
	
		                <div class="portlet-column portlet-column-last col-sm-7"><%= HondaLogicUtil.getDateFormat(wfmsCOS.getCreateDate()) %></div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate Date of Hire</div>

		                <div class="portlet-column portlet-column-last col-sm-7" id="associatedateofhire">
		                <div class="portlet-column portlet-column-last" id="associatedateofhire11" name="associatedateofhire11"><%out.print(wfmsCOS.getAssociateDateOfHire()); %></div>
		                </div>
		            </div>

					<div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Action</div>

		                <div class="portlet-column portlet-column-last col-sm-7">
							<aui:select name="action" config-level="0" id="actionCodeID" onChange="loadAction();" config-key="Action" class="valueset-cosactions" label=""
							 showRequiredLabel="false" required="true" disabled='<%=disable.equals("1") %>'>
							 <%
							/*DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WFMS_action_and_reasoncode.class);
							Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("action"));
							dynamicQuery.setProjection(projection);
							dynamicQuery.addOrder(OrderFactoryUtil.asc("action"));
							java.util.List<Object> reasoncodeList = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery(dynamicQuery);
							for (int i = 0; i < reasoncodeList.size(); i++) {*/%>
								
								 <aui:option selected="selected" value="<%=wfmsCOS.getAction() %>"><%=wfmsCOS.getAction() %></aui:option>
								<% //} %>	
						</aui:select>
						</div>
		            </div>
		            
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Reason Code</div>

		                <div class="portlet-column portlet-column-last col-sm-7" id="reasonCODE">
		                  <aui:select name="reasoncode" disabled='<%=disable.equals("1") %>' required="true" id="reasoncode" class="portlet-reason" label="" onChange="onloadDescription();">
		                 <aui:option value="<%=wfmsCOS.getReasonCODE() %>">  <%= wfmsCOS.getReasonCODE()%>-<%= wfmsCOS.getDescription() %></aui:option>
		                  </aui:select>
		                </div>
		            </div>
		            
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Reason Description</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="description"> <%=wfmsCOS.getDescription() %>  </div>
		               <!--  <input type="textarea" id="description" name="changeDescription"  label="" ></input> -->
		            </div>

		        </div>  

		    </div>

		<h3 class="subsection">Current and New Position Information</h3>

		    <div class="portlet-layout row">
		        <div class="portlet-column col-sm-6">
		            <h4>Current Position</h4>

		            <div class="portlet-layout row">
		                <div class="portlet-comelumn portlet-column-first col-sm-5 sectionLabel ">Associate Title</div>
				    <div class="portlet-column portlet-column-last col-sm-7" id="associateTitle"><% if(Validator.isNotNull(wfmsCOS.getCurrentJobCode())){%><%=wfmsCOS.getCurrentJobCode()%><%} %>  </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Position Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="positionId"><% if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber())){%><%=wfmsCOS.getPositionNumber().replaceAll("-WFM","")%><%} %>  </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DIVISION" name="DIVISION"><% if(Validator.isNotNull(wfmsCOS.getCurrentDivision())){%><%=wfmsCOS.getCurrentDivision()%><%} %></div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division Manager</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="divisionmgrname"><% if(Validator.isNotNull(wfmsCOS.getCurrentDivisionManager())){%><%=wfmsCOS.getCurrentDivisionManager()%><%} %> </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Name</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="departmentname"><% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentName())){%><%=wfmsCOS.getCurrentDepartmentName()%><%} %> </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Number</div>

		                <div class="portlet-column portlet-column-last col-sm-7" id="deptnumber"><% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentNumber())){%><%=wfmsCOS.getCurrentDepartmentNumber()%><%} %>
		                <aui:input type="hidden" name="Deptid" id="Deptid" value="<%=wfmsCOS.getSameDept()%>"/>
		                </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Manager</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DEPT_MANAGER" name="DEPT_MANAGER"><% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentManager())){%><%=wfmsCOS.getCurrentDepartmentManager()%><%} %></div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Team Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="teamNumber"><% if(Validator.isNotNull(wfmsCOS.getCurrentTeamNumber())){%><%=wfmsCOS.getCurrentTeamNumber()%><%} %> </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Shift Code</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="shiftcode"><% if(Validator.isNotNull(wfmsCOS.getCurrentShiftCode())){%><%=wfmsCOS.getCurrentShiftCode()%><%} %> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Employee Category</div>
		                	<div class="portlet-column portlet-column-last col-sm-7" id="shiftcode"><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber()) && !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){ 
							WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getPositionNumber().replaceAll("-WFM",""));%>
									 <%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}%> </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Leadership Assignment</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="leader-assignment"><% if(Validator.isNotNull(wfmsCOS.getCurrentLeadershipAssignment())){%><%=wfmsCOS.getCurrentLeadershipAssignment()%><%} %> </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Associate Number</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="mgrassociateno"><% if(Validator.isNotNull(wfmsCOS.getCurrentManagerAssocNumber())){%><%=wfmsCOS.getCurrentManagerAssocNumber()%><%} %>   </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Name</div>

		                <div class="portlet-column portlet-column-last col-sm-7" id="mgrName"><% if(Validator.isNotNull(wfmsCOS.getCurrentManagerName())){%><%=wfmsCOS.getCurrentManagerName()%><%} %>   </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Title</div>

		                <div class="portlet-column portlet-column-last col-sm-7" id="mgrTitle"><% if(Validator.isNotNull(wfmsCOS.getCurrentManagerTitle())){%><%=wfmsCOS.getCurrentManagerTitle()%><%} %> </div>
<!-- 		                <div class="portlet-column portlet-column-last col-sm-7" id="managrTitle" name="managrTitle"></div> -->
		               
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Routing Path</div>

		                <div class="portlet-column portlet-column-last col-sm-7"> <%=wfmsCOS.getApproverList() %> </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Next Approver</div>

		                <div class="portlet-column portlet-column-last col-sm-7" ><%=wfmsCOS.getNextApprover().replaceAll("<br/>", ",") %>  </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Role of approver</div>

		                <div class="portlet-column portlet-column-last col-sm-7" ><%=wfmsCOS.getRoleOfApprover() %></div>
		            </div>

		        </div>

		        <div class="portlet-column col-sm-6">
		            <h4>New Position</h4>

					<div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate Title</div>

						
		                <div class="portlet-column portlet-column-last col-sm-7">
		              <aui:select name="newJobCode" id="newAssociateTitle" cssClass="field-select chosen" disabled='<%=disable.equals("1") %>' required="true" 
							label="" showRequiredLabel="false"  maxlength="75" onChange="loadAssociateTitleforNewPos();">
						 <aui:option value="">Select Associate Title</aui:option>
						<%
						String ladder=null;
						if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
							
						 if(!(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){
							WFMS_Position newPostionInfo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM",""));
							ladder=newPostionInfo.getLadder();
						}}
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
							}
						%>
							<aui:option selected="<%=wfmsCOS.getNewJobCode().equals(entry.getKey()) %>" value="<%=entry.getKey() %>"><%=entry.getKey() %></aui:option>
						<% } %>
					
					</aui:select>
		              
								 
		                </div>
		               
		            </div>
		            
		          
					 <div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5">
							<span class="sectionLabel">Position Number</span>
						</div>
						<div class="portlet-column portlet-column-last col-sm-7" >
						
						 <div id="NewPOS" name="NewPOS">
						 <% if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){%>
						 <%=wfmsCOS.getNewPositionNumber()%>
						 <%}else{ %>
						 <% if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2){
							 if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 1){
						 %>
						     <%=wfmsCOS.getNewPositionNumber()%>
						     <aui:input id="pId" type="hidden" name="positionNumber" value="<%=wfmsCOS.getNewPositionNumber()%>"></aui:input>
						     <% } else{ %>    
						     <%=wfmsCOS.getPositionNumber()%>
						     <aui:input id="pId" type="hidden" name="positionNumber" value="<%=wfmsCOS.getPositionNumber()%>"></aui:input>
						     <%}}else{%>
							 <aui:select name="positionNumber" id="pId" cssClass="position-number chosen" onChange="loadPosId();validation();" label="" disabled='<%=disable.equals("1") %>'>
							  <aui:option value="">Select Position Number</aui:option>
								<% DynamicQuery queryForPosition =WFMS_PositionLocalServiceUtil.dynamicQuery();
                                queryForPosition.add(PropertyFactoryUtil.forName("status").eq("Open"));
                                queryForPosition.addOrder(OrderFactoryUtil.asc("pId"));
                             
                                List<WFMS_Position> positionNumbers= new ArrayList<WFMS_Position>();
                                List<String> positionNoList= new ArrayList<String>();
                                positionNumbers = WFMS_PositionLocalServiceUtil.dynamicQuery(queryForPosition);
                                
                                for(WFMS_Position positionNumber: positionNumbers){
                                 List<WFMS_Requisition> reqNumbers= new ArrayList<WFMS_Requisition>();
                                DynamicQuery queryForReq =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
                                 queryForReq.add(PropertyFactoryUtil.forName("rId").eq(positionNumber.getPId()));
                                  reqNumbers = WFMS_RequisitionLocalServiceUtil.dynamicQuery(queryForReq);
                                  
                                  int sum1 = (int)WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(queryForReq);
                                  
                                  if(sum1 > 0){
                                    for(WFMS_Requisition reqNumber:reqNumbers){
                                      if(reqNumber.getStatus().equals("Complete") || reqNumber.getStatus().equals("Cancelled")){
                                      positionNoList.add(positionNumber.getPId());
                                      }else{
                                            if(positionNoList.contains(positionNumber.getPId()))
                                                positionNoList.remove(positionNumber.getPId());
                                      }
                                    }
                                  }else{
                                                positionNoList.add(positionNumber.getPId());
                                  }
                                
                                }
                                
                                List<String> positionNoList1= new ArrayList<String>();                                    
                                HashSet<String> positionNos1 = new HashSet<String>(positionNoList); %>
								<%for(String posid:positionNos1){
									posID=posid;%>
									<aui:option selected="<%=wfmsCOS.getNewPositionNumber().equals(posID) %>" value="<%=posID%>"><%=posID%></aui:option>
								<%} %>
								<aui:option selected='<%=wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") %>' value="None"><%=wfmsCOS.getNewPositionNumber()%></aui:option>
								
							</aui:select>
							<%}} %>
							<aui:input name="newPositionNumber" value='' id="newpositionId" type="hidden" /> 
							<div id="positionnumber"  class="form-required">	 </div>		
						</div> 
													
						</div>
					</div>
								<%
								 Map<String , String> hondamap= new HashMap<String,String>();
								if(Validator.isNotNull(wfmsCOS.getSameDept())){
								    hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getSameDept());
								}
								if(Validator.isNotNull(wfmsCOS.getNewDepartmentNumber())){
									hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getNewDepartmentNumber());
									}
								%>	           
					<div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division</div>
		                <div class="portlet-column portlet-column-last col-sm-7">
		                <%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last" id="Division"><%=wfmsCOS.getCurrentDivision()%></div>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						<div class="portlet-column portlet-column-last" id="Division">  <% if(hondamap.get("divName")!=null ) out.print(hondamap.get("divName"));%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last" id="Division">  <% if(hondamap.get("divName")!=null ) out.print(hondamap.get("divName"));%></div>
		                 <div class="portlet-column portlet-column-last" id="DivisionFromM"> <% if(hondamap.get("divName")!=null ) out.print(hondamap.get("divName")); %></div>
		                 <%} %>
		                 </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division Manager</div>
						<div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last" id="divMgrName"><%=wfmsCOS.getCurrentDivisionManager()%></div>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						<div class="portlet-column portlet-column-last" id="divMgrName">  <% if(hondamap.get("divMgrName")!=null ) out.print(hondamap.get("divMgrName"));%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last" id="divMgrName"><% if(hondamap.get("divMgrName")!=null ) out.print(hondamap.get("divMgrName"));%> </div>
		                 <div class="portlet-column portlet-column-last" id="divMgrNameFromM"><% if(hondamap.get("divMgrName")!=null ) out.print(hondamap.get("divMgrName")); %></div>
		                <%} %>
		               </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Name</div>
						<div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last" id="deptNAME"><%=wfmsCOS.getCurrentDepartmentName()%></div>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						<div class="portlet-column portlet-column-last" id="deptNAME">  <% if(hondamap.get("deptName")!=null ) out.print(hondamap.get("deptName"));%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last" id="deptNAME"><% if(hondamap.get("deptName")!=null ) out.print(hondamap.get("deptName"));%> </div>
		                <div class="portlet-column portlet-column-last" id="deptNameFromM"><% if(hondamap.get("deptName")!=null ) out.print(hondamap.get("deptName")); %></div>
		                <%} %>
		               </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Number</div>
		                 <%if(wfmsCOS.getSystemGenerated() == 1) {%>
		                 <div  class="portlet-column portlet-column-last col-sm-7" id="deptNumberFromPosition"><%=wfmsCOS.getNewDepartmentNumber() %></div>
		                 <%}else if(wfmsCOS.getSystemGenerated() == 2) {%>
		                 <div  class="portlet-column portlet-column-last col-sm-7" id="deptNumberFromPosition"><%=wfmsCOS.getCurrentDepartmentNumber() %></div>
		                 <%}else{ %>
		                 <div  class="portlet-column portlet-column-last col-sm-7" id="deptNumberFromPosition"><%=wfmsCOS.getNewDepartmentNumber() %></div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptNumber">
		                 
		                 <aui:select disabled='<%=disable.equals("1") %>' name="sameDept" cssClass="chosen" id="divdeptRest" label="" showRequiredLabel="false"  onChange="updateValuesForSelectedDepartment();validation();" >
                                 <aui:option value="">Select Department Number</aui:option>
                                 <% 
                             	Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
							  
							 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){
								 if(Validator.isNotNull(entry.getValue())){
							 String keyvalue = entry.getKey() +"-" +entry.getValue(); %>
				                  <aui:option selected="<%=wfmsCOS.getSameDept().equals(entry.getKey()) %>" value="<%=entry.getKey()%>"><%=keyvalue%></aui:option>
									<%}} %>		
						</aui:select>
						 <div id="departmentNumber1"  class="form-required">	 </div>  
		                </div>
		                <%} %>
		                <div style="display:none;">
							
							 <aui:input type="text" class="field error-field" id="hidden_field" name="hidden_field" required="true" disabled="${not ADD_RS_2}"></aui:input>
							</div>
			    		  
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Manager</div>
						<div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last" id="deptMgrName"><%=wfmsCOS.getCurrentDepartmentManager() %></div>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						<div class="portlet-column portlet-column-last" id="deptMgrName">  <%  if(hondamap.get("deptMgrName")!=null ) out.print(hondamap.get("deptMgrName"));%></div>
						<%}else{ %>
		                 <div class="portlet-column portlet-column-last" id="deptMgrName"><%  if(hondamap.get("deptMgrName")!=null ) out.print(hondamap.get("deptMgrName"));%></div>
		                 <div class="portlet-column portlet-column-last" id="deptManagerFromM"><%  if(hondamap.get("deptMgrName")!=null ) out.print(hondamap.get("deptMgrName")); %></div>
		                 <%} %>
		               </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Team Number</div>

		                <div class="portlet-column portlet-column-last col-sm-7" >
		                <%if(wfmsCOS.getSystemGenerated() == 2) {%>
		                <div class="portlet-column portlet-column-last col-sm-7" id="systemteamNumber"><%=wfmsCOS.getTeamNumber() %></div>
		                <aui:input name="teamNumber" id="teamNumber" type="hidden"></aui:input>
		                <%}else{ %>
			                <aui:select name="teamNumber" id="teamNumber" required="true" disabled='<%=disable.equals("1") %>'  cssClass="field-select chosen" label="" >
			                     <aui:option value="">Select Team Number</aui:option>
								<% 	List<String> reportToteamNUmber = HMAAssociateInfoService.getTeamNumberCos();
									for (String teamNumber: reportToteamNUmber) {  
								%>
								  <aui:option selected="<%=wfmsCOS.getTeamNumber().equals(teamNumber) %>" value="<%= teamNumber %>"><%= teamNumber %></aui:option>
							<% } %>
							</aui:select> 
						<%} %>	
		                </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Shift Code</div>
		                <div class="portlet-column portlet-column-last col-sm-7" >
		                <%if(wfmsCOS.getSystemGenerated() == 2) {%>
		                <div class="portlet-column portlet-column-last" id="systemshiftCode"><%=wfmsCOS.getShiftCode()%></div>
		                <aui:input name="shiftCode" id="shiftCode" type="hidden"></aui:input>
		                <%}else{ %>
			                 <aui:select name="shiftCode" id="shiftCode" required="true" disabled='<%=disable.equals("1") %>'  cssClass="field-select chosen" label="" >
			                 		<%-- <aui:option value="<%=wfmsCOS.getShiftCode() %>"><%=wfmsCOS.getShiftCode() %></aui:option> --%>
			                 		  <aui:option value="">Select Shift Code</aui:option>
									<% 	List<String> reportToshiftCodeManege = HMAAssociateInfoService.getShiftCodeCos();
									for (String shiftNumber : reportToshiftCodeManege) {  
									%>
								  <aui:option selected="<%=wfmsCOS.getShiftCode().equals(shiftNumber) %>" value="<%= shiftNumber %>"><%= shiftNumber %></aui:option>
									<% } %>
							</aui:select> 
						<%} %>	
		                </div>      
		            </div>
		            
		             <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Employee Category</div>
		                	<div class="portlet-column portlet-column-last col-sm-7" ><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getNewPositionNumber()) && !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){ 
								WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM","")); 
								if(Validator.isNotNull(wfmpo.getEmpCategory())){%>
								 <%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}}%> </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Leadership Assignment</div>
		                <div class="portlet-column portlet-column-last col-sm-7" >
		                <div class="portlet-column portlet-column-last" id="newleadershipassignment">
		                <% if((wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2) && wfmsCOS.getLeadershipAssignment()!=null) 
		                	  out.print(wfmsCOS.getLeadershipAssignment());
						  if(wfmsCOS.getSystemGenerated() == 0 && wfmsCOS.getLeadershipAssignment()!=null) 
		                	  out.print(wfmsCOS.getSameLeadership());
		                   else if(wfmsCOS.getSameLeadership()!=null)
		                	   out.print(wfmsCOS.getSameLeadership());
		                   else if(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))
		                	   out.print("None");
		                  %>
		                </div>
		                <div class="portlet-column portlet-column-last col-sm-7">
		                <div id="UpdatePO" name="UpdatePO">		              
							<div id="MgrAssNo" name="MgrAssNo" <%if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){ %>style="display: none;""<%} %>>
							<div class="leader-ship">
								<aui:select name="leadershipAssignment" disabled='<%=disable.equals("1") %>' id="LeaderShip" class="field-select"  label="" showRequiredLabel="false" maxlength="75" onChange="validation();">
									<aui:option value="">Select Leadership</aui:option> 
									<% 	List<String> reportToleaderShip = HMAAssociateInfoService.getLeaderShipCos();
									for (String leadership: reportToleaderShip) {  
									%>
								  <aui:option selected="<%=wfmsCOS.getLeadershipAssignment().equals(leadership) %>" value="<%= leadership %>"><%= leadership %></aui:option>
									<% } %>
								</aui:select>
								<div id="leadership1"  class="form-required">	 </div>
							</div>
							
							</div>
						</div>
		                </div>
		                </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Associate Number</div>
		                <%if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 2)){%>
		                <div id="managerAssociateNumber" class="col-sm-7"><%=wfmsCOS.getCurrentManagerAssocNumber()%></div>
		                <% }else{ %>
		                             <div id="managerAssociateNumber" class="col-sm-7" <% if(wfmsCOS !=null && (wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %>  style="display:none;" <% } %>><% if(wfmsCOS!=null) out.print(wfmsCOS.getMgrAssociateNumber()); %></div>
                                 <% } %>      
                                 <div class="col-sm-7">
                                            <div id="managerAssociatedropdown" <% if(wfmsCOS ==null || !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %> style="display:none;" <% } %>>  
						    <aui:select name="mgrAssociateNumber" id="mgrassociateNo" disabled="true" label="" cssClass="chosenAssociateNumber field-select" onChange="loadMgrAssoNo();" >
							<aui:option value="">Select Manager Associate Number</aui:option>
							<%  Map<String,String> MgrAssNumberMap = HMAAssociateInfoService.getMsrAssociateNoToNewCOS();
                                                                String associatemanage="";
                                                                if(wfmsCOS!=null)
                                                                   associatemanage=wfmsCOS.getMgrAssociateNumber();
							     for(Map.Entry<String, String> entry : MgrAssNumberMap.entrySet()){ %>
				                                <aui:option selected="<%=associatemanage.equals(entry.getKey()) %>" value="<%=entry.getKey() %>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
							    <% } %> 
						</aui:select>
                                                                      <div class="form-validator-stack help-inline manageAssociate_ValidationMessage" style="display:none;">
							     Missing required value for the field "Manager Associate Number"</div>          
                                                                
                                        </div>  
                                 </div>              
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Name</div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="ManagerAssociateName"><% if(wfmsCOS.getSystemGenerated() == 2){ out.print(wfmsCOS.getCurrentManagerName()); }else{ out.print(wfmsCOS.getNewManagerName()); }%></div>

		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manager Title</div>
						<div class="portlet-column portlet-column-last col-sm-7" id="ManagerAssociateTitle"><% if(wfmsCOS.getSystemGenerated() == 2){ out.print(wfmsCOS.getCurrentManagerTitle()); }else{ out.print(wfmsCOS.getNewManagerTitle()); } %> </div>
		            </div>

		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manpower Category</div>

		                <div class="portlet-column portlet-column-last col-sm-7">
							<aui:select disabled='<%=disable.equals("1") %>' name="manpowerCategiry" id="manpower-catogiry" class="field-select" label="" required="true">
							<aui:option value="">Select Manpower Category</aui:option>
								<%
									values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
									for(String value:values){	
								%>
									<aui:option selected="<%=wfmsCOS.getManpowerCategiry().equals(value) %>" value="<%=value %>"><%=value %></aui:option>
								<% } %>
								
							</aui:select>
		                </div>
		            </div>


		         <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Manpower Rep</div>
						<div class="portlet-column portlet-column-last col-sm-7">

						<div class="portlet-column portlet-column-last" id="divMgrName"> 
						<% if(wfmsCOS.getSystemGenerated() == 2)
							    out.print(wfmsCOS.getCurrentManpowerRep());
						   else if(hondamap.get("mpwrrep_name")!=null) 
							   out.print(hondamap.get("mpwrrep_name")); 
							   %> 
				       </div>
		               </div>
		            </div>
		            <div class="portlet-layout row">
		                <div class="portlet-column portlet-column-first col-sm-5 sectionLabel">Notification To</div>

						 <% String noticationTo=StringPool.BLANK;
							if(Validator.isNotNull(wfmsCOS.getNotificationTo()))  {
								noticationTo=HondaLogicUtil.convertNotification(wfmsCOS.getNotificationTo(),wfmsCOS.getCosId());
						 }%>
		                <div class="portlet-column portlet-column-last col-sm-7"> <%=noticationTo%> </div>
		            </div>
 			</div>
		            
		        </div>
		    </div>
		    <div class="portlet-layout row" style="margin-top:15px;">
                <div class="portlet-column portlet-column-first col-sm-3 sectionLabel ">Comments</div>

                <div class="portlet-column portlet-column-last col-sm-9">
                   <aui:input type="textarea" disabled='<%=disable.equals("1") %>' name="comments" class="field" cols="55" value="<%=wfmsCOS.getComments() %>"
						placeholder="comments" rows="10" label="" style="width: 93%;" maxLength="500" id="enableComments"></aui:input>
						<!-- Edit and Save Buttons for Comments -->
						<% if((WMSUserAccessUtil.checkPermission(renderRequest,PortletPropsPermission.COS_EDIT_COMMENTS))){ %>
							<button id="editCommentsButton" style="width: auto;" onclick='editComment("comments")'><i class="icon-edit"></i>&nbsp;Edit</button>
							<button id="saveCommentsButton" style="width: auto;" onclick='saveComments("comments")' disabled ><i class="icon-check"></i>&nbsp;Save</button>
						<%} %>
						
						
							<aui:input name="cmpComment" type="hidden" id="cmpComment" label=""></aui:input>
                </div>
            </div>
            <div class="portlet-layout">
                <div class="logs_main" style="font-style: oblique;word-wrap: initial;"><b>Log:</b></div>
			
                <div class="users col-sm-12">
                	<div class="logs_comments" style="line-height: 16px;">
			                <%List<WFMS_COS_Audit> wfms_auditlist=WFMS_COS_AuditLocalServiceUtil.findByCosIdForAudit(wfmsCOS.getCosId()); %>
			                <%for(WFMS_COS_Audit wfms_audit :wfms_auditlist){%>
			                	
			               <div class="logs">
				               <div class="user_comments" id="user_comments">
				               		<br>
				               		 <div id="change_comments" style="line-height: 19px;margin-top: -16px;"><%=wfms_audit.getChange() %> By : <%=wfms_audit.getCreatedBy()%> - <%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate()) %></div>
				               		 
				               			<% if(wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_DISAPPROVE)|| wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_CANCEL)){%>
											<div class="comments" id="comments">
										 	  	&nbsp;<div class="log_comments" style="line-height: 19px;margin:-9px 0px -4px 0px;text-indent: 3px;"><b class="comment_title">Comments :</b><%=wfms_audit.getComments() %></div>
										    </div>
											<%}%>
				               </div>
			               </div>
			               <%
			               }
			                %>
			        </div>
	           </div>
        	</div>
		</div>
        
		<div class="scroll_back_to_top">
		<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
		</div>


	</div>
</div>
</aui:form>


<!-- Start Workflow for Cancel Change of Status  -->

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
			placeholder="Comments" rows="3" required="true"/>
        </div>
        <div class="modal-footer">
        <div class="col-sm-6 text-right">
          <aui:button type="submit" class="btn btn-primary" value="Save" onclick="callCancelAction();"></aui:button>
        </div>
        <div class="col-sm-6 text-left">
        	<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        </div>
        </div>
      </div>
 	</aui:form>
    </div>
  </div>
  
  <div class="modal fade" id="disapproveCosModal" role="dialog" style="display:none;">
    <div class="modal-dialog">
    <aui:form method="post" action="<%=disapproveCosURL.toString() %>"
	name="disapproveCos" id="disapproveCos">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Please enter the reason for disapproval</h4>
        </div>
        <div class="modal-body">
        <aui:input type="hidden" name="cosId"  value="<%=wfmsCOS.getCosId() %>"/>
          <aui:input type="textarea" name="Comments" label=""
			value="" class="field" cols="5"
			placeholder="Comments" rows="3" required="true"/>
        </div>
        <div class="modal-footer">
        <div class="col-sm-6 text-right">
          <aui:button type="submit" class="btn btn-primary" value="Save" onclick="callDisapproveAction();"></aui:button>
        </div>
        <div class="col-sm-6 text-left">
        	<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        </div>
        </div>
      </div>
 	</aui:form>
    </div>
  </div>
<!-- End Workflow -->
<!--  Change of status Approve workflow start-->

<!--  Change of status Approve workflow end-->
<script type="text/javascript">
	function callCancelAction() {
	    var url = '<%=cancelCOSURL.toString()%>';
	    document.forms["cancelCOS"].action=url;
	    document.forms["cancelCOS"].submit();
	}
	</script>
	<script type="text/javascript">
	function callDisapproveAction() {
		 var url = '<%=disapproveCosURL.toString()%>';
		   document.forms["disapproveCos"].action=url;
		   document.forms["disapproveCos"].submit();
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
	});
	</script>
<aui:script>
$( document ).ready(function() {
    	  //var pidvalue=$("#<portlet:namespace/>pId").val();
    	  console.log('divMgr');
    	  var associateTitle=$("#<portlet:namespace/>newAssociateTitle").val();
    	  var positionId = "<%=wfmsCOS.getNewPositionNumber() %>";
    	  console.log('newAssociateTitle');
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
				
			}
			else{ 
				if(positionId == "None"){
				 document.getElementById("MgrAssNo").style.display = "block";
				 document.getElementById("NewPOS").style.display = "block";
				 document.getElementById("Division").style.display = "none";
				 document.getElementById("deptNAME").style.display = "none";
				 document.getElementById("deptMgrName").style.display = "none";
				 document.getElementById("divMgrName").style.display = "none";
				 document.getElementById("deptNumberFromPosition").style.display = "none";
				 document.getElementById("managerAssociateNumber").style.display = "none";
				 
				 document.getElementById("deptNumber").style.display = "block";
				 document.getElementById("DivisionFromM").style.display = "block";
				 document.getElementById("deptNameFromM").style.display = "block";
				 document.getElementById("deptManagerFromM").style.display = "block";
				 document.getElementById("divMgrNameFromM").style.display = "block";
				document.getElementById("UpdatePO").style.display = "none";
				}
				else if(positionId != ""){
				document.getElementById("deptNumber").style.display = "none";
				 document.getElementById("DivisionFromM").style.display = "none";
				 document.getElementById("deptNameFromM").style.display = "none";
				 document.getElementById("deptManagerFromM").style.display = "none";
				 document.getElementById("divMgrNameFromM").style.display = "none";
				document.getElementById("UpdatePO").style.display = "none";
			}else{
				document.getElementById("deptNumber").style.display = "none";
				 document.getElementById("DivisionFromM").style.display = "none";
				 document.getElementById("deptNameFromM").style.display = "none";
				 document.getElementById("deptManagerFromM").style.display = "none";
				 document.getElementById("divMgrNameFromM").style.display = "none";
				document.getElementById("UpdatePO").style.display = "none";
			}
			}
	});

function updateValuesForSelectedDepartment(){
	console.log("loadDivsionNames: called");
	var Deptid=$("#<portlet:namespace/>divdeptRest").val();
	 var pidvalue=$("#<portlet:namespace/>pId").val();
	console.log("loadDivsionNames: Deptid "+Deptid);
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
				  if(pidvalue == "None")
					  	document.getElementById("NewPOS").style.display = "block";
					  else
						document.getElementById("NewPOS").style.display = "none";
				  document.getElementById("Division").style.display = "none";
				  document.getElementById("deptNAME").style.display = "none";
				  document.getElementById("deptMgrName").style.display = "none";
				  document.getElementById("divMgrName").style.display = "none";
				  document.getElementById("deptNumberFromPosition").style.display = "none";
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

function NewDeptNumber(){  
	var roleUuid=$("#<portlet:namespace/>divdeptRest").val();
	console.log(roleUuid);
	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  

	 A.io.request('<%=resourceURL.toString()%>',{  
	 dataType: 'json', 
	 method: 'GET',   
	 data:
	 { 
		 <portlet:namespace/>roleUuid: roleUuid ,
		 <portlet:namespace/>cmd: "getNewDeptNumber" 
		 
		 },   
	 on: {    
		 
		success: function() {
			 var data=this.get('responseData');
			
			 }   
	 				}
	 			});
	 		}); 
	 } 

function loadAction(){  
	$('#<portlet:namespace/>reasoncode').empty();
	var actionId=$("#<portlet:namespace/>actionCodeID").val();

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
			 $('#ReasonCode').find('select').html("");
			 jQuery.each(data, function(i, val) {
				
			 textElement=textElement+"<option value='" + val.ReasonCode + "'>"+ val.ReasonCode + "</option>";
			});
			 $('#reasonCODE').find('select').append(textElement);
			 $('#description').html("");
		    
			 }  
	 			}
	    			});
	 	            	}); 
	 						} 

function onloadDescription(){  
	
	var reasoncode=$("#<portlet:namespace/>reasoncode").val();
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
	
	
	 $(document).ready(function(){
		
    	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
    	 A.io.request('<%=AssNumURL%>',{  
    	 dataType: 'json', 
    	 method: 'GET',   
    	 data:
    	 { 
    		 		 <portlet:namespace />associateID: '<%=wfmsCOS.getAssoicateId() %>',
    		 },   
    	 on: {    
    		 success: function() {
    			var data=this.get('responseData');
    			
           <%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
  			/* $('#Division').html(data.DIVISION);
  			$('#divMgrName').html(data.DIVISION_MANAGER);
  			$('#deptNAME').html(data.DEPT_NAME);
  			$('#deptNumberFromPosition').html(data.DEPT_NUMBER);
  			$('#deptMgrName').html(data.DEPARTMENT_MANAGER);
  			$('#managerAssociateNumber').html(data.MANAGER_ASSOCIATE_NUMBER);
  			$('#ManagerAssociateName').html(data.DEPT_MANAGER);
  			$('#ManagerAssociateTitle').html(data.DEPT_MANAGER_TITLE);
  			$('#newleadershipassignment').html("<%=wfmsCOS.getLeadershipAssignment()%>");
  			$('#systemteamNumber').html(data.TEAM_NUMBER);
  			$('#systemshiftCode').html(data.SHIFT_CODE); */
  			<%}%>
      			//$('#manpowerreq').html(data.ManpowerRep);
   				 }   
    			 } 
    		 });
    	 }); 
	 });  
		
	 function loadPosId(){  
     	 
	      var pidvalue=$("#<portlet:namespace/>pId").val();
	      $('#Division').html("");
   		  $('#deptNAME').html("");
   		  $('#deptMgrName').html("");
   		  $('#divMgrName').html("");
   		  $('#deptNumberFromPosition').html("");
   		  $('#leadershipassignment').html("");
   		  $('#managerAssociateNumber').html("");
   		  $('#ManagerAssociateName').html("");
   		  $('#ManagerAssociateTitle').html("");
	      	
	      	if(pidvalue=="")
	      		{
	      		$('#Division').html("");
	      		$('#divMgrName').html("");
	      		$('#deptMgrName').html("");
	  			//$('#divisionManager').html("");
	      		$('#deptNAME').html("");
	  			$('#deptNumberFromPosition').html("");
	  			//$('#deptNumber').html("");
	  			$('#ManagerAssociateTitle').html("");
	  			$('#ManagerAssociateName').html("");
	  			$('#leadershipassignment').html("");
	  			$('#managerAssociateNumber').html("");
				document.getElementById("deptNumber").style.display = "none";
				
	      		}
				else if(pidvalue=="None")
	      		    {
					
					 document.getElementById("deptNumber").style.display = "block";
					 var positionDisplay = document.getElementById("NewPOS");
						var departmentDisplay = document.getElementById("deptNumber");
		     		 	if(positionDisplay.style.display == "block") {
		     		 		 document.getElementById("Division").style.display = "none";
		     		 		 document.getElementById("deptNAME").style.display = "none";
		     		 		 document.getElementById("deptMgrName").style.display = "none";
		     		 		 document.getElementById("divMgrName").style.display = "none";
		     		 		 document.getElementById("deptNumberFromPosition").style.display = "none";
		     		 		 document.getElementById("leadershipassignment").style.display = "none";
		     		 		 document.getElementById("managerAssociateNumber").style.display = "none";
		     		 		// document.getElementById("ManagerAssociateName").style.display = "none";
		     		 		 //document.getElementById("ManagerAssociateTitle").style.display = "none";
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
					$('#Division').html(data.division);
					$('#divMgrName').html(data.divMgrName);
					$('#deptNAME').html(data.deptName);
					$('#deptNumberFromPosition').html(data.deptNumber);
					//$('#divMgrName').html(data.deptManager);
	      			$('#deptMgrName').html(data.deptManager);
	      			
	      			if(data.leadershipassignment == ""){
	      			$('#leadershipassignment').html("None");
	      			}
	      			else{
	      			$('#leadershipassignment').html(data.leadershipassignment);
	      			}
	      			
	      			$('#managerAssociateNumber').html(data.managerAssociateNumber);
	      			$('#ManagerAssociateName').html(data.ManagerAssociateName);
	      			$('#ManagerAssociateTitle').html(data.ManagerAssociateTitle);
	      			
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
      	 
      function loadAssociateNo(){
    	  $('#associateName').html("");
			$('#associateTitle').html("");
			<% if(!wfmsCOS.getStatus().equals(HondaPermissionKeys.COS_APPROVED)){ %>
			$('#positionId').html("");
			<% }%>
			$('#<portlet:namespace/>newpositionId').val("");
			$('#DIVISION').html("");
			$('#divisionmgrname').html("");
			$('#departmentname').html("");
			$('#deptnumber').html("");
			$('#DEPT_MANAGER').html("");
			$('#teamNumber').html("");
			$('#shiftcode').html("");
			$('#leader-assignment').html("");
			$('#mgrassociateno').html("");
			$('#mgrName').html("");
			$('#mgrTitle').html("");
			$('#associatedateofhire').html("");
			//$('#manpowerreq').html("");
    	var associateNumberCos=$("#<portlet:namespace/>associaNumber").val();
    	console.log(associateNumberCos);
    	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  

    	 A.io.request('<%=resourceURL.toString()%>',{  
    	 dataType: 'json', 
    	 method: 'GET',   
    	 data:
    	 { 
    		 <portlet:namespace/>associateNumberCos: associateNumberCos ,
    		 <portlet:namespace/>cmd: "associateNumberOnCos" 
    		 
    		 },   
    	 on: {    
    		 
    		success: function() {
    			 var data=this.get('responseData');
    			 $('#associateName').html(data.ASSOCIATE_NAME);
 				$('#associateTitle').html(data.ASSOCIATE_TITLE);
 				//$('#positionId').html(data.positionId);
 				$('#<portlet:namespace/>newpositionId').val(''+data.positionId+'');
 				$('#DIVISION').html(data.DIVISION);
 				$('#divisionmgrname').html(data.DIVISION_MANAGER);
 				$('#departmentname').html(data.DEPT_NAME);
 				$('#deptnumber').html(data.DEPT_NUMBER);
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
       			//$('#manpowerreq').html(data.ManpowerRep);
    			 }   
    	 				}
    	 			});
    	 		}); 
    	 } 
    
      function getMgrAssociateNumber(){  
      	var mgrAssociateId=$("#<portlet:namespace/>mgrassociateNo").val();
      
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
      			$('#managerName').html(data.ASSOCIATE_NAME);
    			$('#managerTitle').html(data.ASSOCIATE_TITLE);
      				 }   
      			 }
      		 });
      	 });  
       } 
      
     function loadAssociateTitleforNewPos(){  
        	var associateTitleforNewPos=$("#<portlet:namespace/>newAssociateTitle").val();
        	var deptNo=$("#<portlet:namespace/>divdeptRest").val();
        	 var pidvalue=$("#<portlet:namespace/>pId").val();
        	 if(associateTitleforNewPos == ""){
    			 document.getElementById("NewPOS").style.display = "none";
        		 document.getElementById("MgrAssNo").style.display = "block";
        		 document.getElementById("deptNumber").style.display = "block";
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
    			 
    		 }else	if(associateTitleforNewPos == 'TC' || associateTitleforNewPos == 'PA'){
    			 document.getElementById("NewPOS").style.display = "none";
        		 document.getElementById("deptNumber").style.display = "block";
        		 document.getElementById("MgrAssNo").style.display = "block";
        		 document.getElementById("UpdatePO").style.display = "block";
        		 
 				 document.getElementById("Division").style.display = "none";
 				 document.getElementById("deptNAME").style.display = "none";
 				 document.getElementById("deptMgrName").style.display = "none";
 				 document.getElementById("divMgrName").style.display = "none";
 				 document.getElementById("deptNumberFromPosition").style.display = "none";
 				 document.getElementById("leadershipassignment").style.display = "none";
 				 document.getElementById("managerAssociateNumber").style.display = "none";
 				 //document.getElementById("ManagerAssociateName").style.display = "none";
 				 //document.getElementById("ManagerAssociateTitle").style.display = "none";
      		 	
      		 		if(deptNo == ""){
      		 		 $('#DivisionFromM').html("");
      				  $('#deptNameFromM').html("");
      				  $('#deptManagerFromM').html("");
      				  $('#divMgrNameFromM').html("");
      				  $('#ManPowerRep').html("");
      		 			
      		 		}else{
      		 		document.getElementById("DivisionFromM").style.display = "block";
      		 		document.getElementById("deptNameFromM").style.display = "block";
      		 		document.getElementById("deptManagerFromM").style.display = "block";
      		 		document.getElementById("divMgrNameFromM").style.display = "block";
      		 		document.getElementById("ManPowerRep").style.display = "block";
      		 		}
        	}else {
				document.getElementById("NewPOS").style.display = "block";
        		document.getElementById("UpdatePO").style.display = "none";
        	if(associateTitleforNewPos != 'Select Associate' && pidvalue == 'none'){
				document.getElementById("Division").style.display = "none";
				document.getElementById("deptNAME").style.display = "none";
				document.getElementById("deptMgrName").style.display = "none";
				document.getElementById("divMgrName").style.display = "none";
				document.getElementById("deptNumberFromPosition").style.display = "none";
				document.getElementById("leadershipassignment").style.display = "none";
				document.getElementById("managerAssociateNumber").style.display = "none";
				//document.getElementById("ManagerAssociateName").style.display = "none";
				//document.getElementById("ManagerAssociateTitle").style.display = "none";
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
     		 	}
				}
     		 	
			}
        	}
     }
      
      function fetchDeptNumber(){  
      	var departmentNumber=$("#<portlet:namespace/>deptNumberOnCos").val();
      	      	
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
      	 console.log(data);
      	
      	if(data.LEADERSHIP_ASSIGNMENT == ""){
	  			$('#leadershipassignment').html("None");
	  			}
	  			else{
	  			$('#leadershipassignment').html(ddata.LEADERSHIP_ASSIGNMENT);
	  			}
      	 
      			//$('#leadershipassignment').html(data.LEADERSHIP_ASSIGNMENT);	
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
  
      YUI({ lang: 'en' }).use(
      'aui-datepicker',
      function(Y) {
    	  var today=new Date();
        var datepicker = new Y.DatePicker(
          {
             trigger: '#<portlet:namespace />startDate',
            mask: '%m/%d/%Y',
            calendar: {
	        	   minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * (-8760)))
	        	//maximumDate:  new Date(today.getTime() + (1000 * 60 * 60 * 120)),
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
                      }
                    }
                  },
                  {
                    icon:'icon-globe',
                    label: 'Today date',
                    on: {
                      click: function() {
                        datepicker.clearSelection();
                        datepicker.selectDates(new Date());
                      }
                    }
                  }
                ]]
              },
              zIndex: 1
            }
          }
        );
      }
    );
    </aui:script>
    <script>
    jQuery(document).ready(function(){
    jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
    });
    </script>
     <script>
    function validation(){
   	 var associateTitleforNewPos=$("#<portlet:namespace/>newAssociateTitle").val();
   	 var positionNo=$("#<portlet:namespace/>pId").val();
   	 var deptNo=$("#<portlet:namespace/>divdeptRest").val();
   	 var LeaderShip=$("#<portlet:namespace/>LeaderShip").val();
 	if(associateTitleforNewPos == ""){
  		 if (deptNo==""){ 
  		 document.getElementById('departmentNumber1').innerHTML='This field is required.';
  	 	 document.getElementById('<portlet:namespace/>hidden_field').value=''; 
  		}else{ 
  		document.getElementById('departmentNumber1').innerHTML=''; 
  		document.getElementById('<portlet:namespace/>hidden_field').value='1'; 
  		}
  	}else if(associateTitleforNewPos == 'PA' || associateTitleforNewPos == 'TC'){
		 document.getElementById('<portlet:namespace/>hidden_field').value='1'; 
		 if(deptNo == "" && LeaderShip == ""){
			 document.getElementById('departmentNumber1').innerHTML='This field is required.';
				document.getElementById('leadership1').innerHTML='This field is required.';
				document.getElementById('<portlet:namespace/>hidden_field').value=''; 
		 }else if (deptNo==""){
		  document.getElementById('departmentNumber1').innerHTML='This field is required.';
		  document.getElementById('leadership1').innerHTML=''; 
		document.getElementById('<portlet:namespace/>hidden_field').value=''; 
		
		}else if (LeaderShip==""){
			document.getElementById('leadership1').innerHTML='This field is required.';
			document.getElementById('departmentNumber1').innerHTML=''; 
			document.getElementById('<portlet:namespace/>hidden_field').value=''; 
		}
		 else{
			document.getElementById('departmentNumber1').innerHTML=''; 
			document.getElementById('leadership1').innerHTML=''; 
			document.getElementById('<portlet:namespace/>hidden_field').value='1'; 
		}
		 
		 
	 }
	 else{
		 if(associateTitleforNewPos !== 'PA' || associateTitleforNewPos !== 'TC' ){
		if(positionNo == ""){
			document.getElementById('positionnumber').innerHTML='This field is required.'; 
			document.getElementById('<portlet:namespace/>hidden_field').value=''; 
		}else if(positionNo == 'none' && deptNo == ""){
			document.getElementById('departmentNumber1').innerHTML='This field is required.';
			document.getElementById('<portlet:namespace/>hidden_field').value=''; 
			
		} else{
			document.getElementById('positionnumber').innerHTML=''; 
			document.getElementById('departmentNumber1').innerHTML=''; 
			document.getElementById('<portlet:namespace/>hidden_field').value='1'; 
			}
		}
		 
	 }
	
   }
    
    $(document).ready(function(){
    <%if(wfmsCOS !=null && (wfmsCOS.getNewJobCode().equals("PA") || wfmsCOS.getNewJobCode().equals("TC"))){ %>
	 $("#UpdatePO").hide();
	 $("#newleadershipassignment").html("None");
    <%}%>	
    });
   
	   function approveSubmit(){
	   $("#<portlet:namespace/>approveCOS").submit();	
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
		   $("#<portlet:namespace/>updateChangeOfStatus").attr('action',"<%= updateCommentsCOSURL.toString()%>");
		   $("#<portlet:namespace/>updateChangeOfStatus").submit();
	   }
    </script>
 		<script type="text/javascript">
 		function exitviewUrl(url) {
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
	</div>
<div class="print"  id="printableArea">
 <%@ include file="/html/changeOfStatus/print-form.jsp" %> 
</div>
<style type="text/css"  > 
	.print { display:none; } 
</style>
<style type="text/css" media="print">
	.manageCOS { display:block;}
	.print { display:none; }
</style>