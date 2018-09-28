<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.configuration.Configuration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletMode"%>

<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Position"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_COS"%>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>

<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page	import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>

<%@ include file="/html/init.jsp"%>
<%@ include file="/html/dataTableIncludes.jspf"%>

<portlet:actionURL name="getPosition" var="getPositionURL"></portlet:actionURL>
<portlet:actionURL name="getRequisition" var="getRequisitionURL"></portlet:actionURL>

<portlet:actionURL name="editCOSURL" var="getCOSURL"></portlet:actionURL>

<portlet:actionURL name="newPositions" var="newPositionsURL"></portlet:actionURL>
<portlet:actionURL name="newChangeOfStatus" var="newChangeOfStatusURL"></portlet:actionURL>

<% 
	String pageName="/position";
	long position_plid = 0;
	String pageCosName="/change-of-status";
	String pageReqName="/requisition";
	long cos_plid = 0;
	long req_plid = 0;
	
	try {
		cos_plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageCosName).getPlid();
		position_plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageName).getPlid();
		req_plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageReqName).getPlid();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	LiferayPortletURL editCOSURL = PortletURLFactoryUtil.create(request,		
			"ChangeOfStatus" ,cos_plid, PortletRequest.ACTION_PHASE);
			
	editCOSURL.setWindowState(LiferayWindowState.MAXIMIZED);
	editCOSURL.setPortletMode(PortletMode.VIEW);
	editCOSURL.setParameter("javax.portlet.action", "editCOS");
	editCOSURL.setParameter("cosId", "costempId");
	
	LiferayPortletURL editREQURL = PortletURLFactoryUtil.create(request,		
			"Requisition" ,req_plid, PortletRequest.ACTION_PHASE);
			
	editREQURL.setWindowState(LiferayWindowState.MAXIMIZED);
	editREQURL.setPortletMode(PortletMode.VIEW);
	editREQURL.setParameter("javax.portlet.action", "editRequisition");
	editREQURL.setParameter("positionId", "positiontempId");
	
	LiferayPortletURL editPOSURL = PortletURLFactoryUtil.create(request,		
			"Position" ,position_plid, PortletRequest.ACTION_PHASE);
			
	editPOSURL.setWindowState(LiferayWindowState.MAXIMIZED);
	editPOSURL.setPortletMode(PortletMode.VIEW);
	editPOSURL.setParameter("javax.portlet.action", "editPosition");
	editPOSURL.setParameter("positionId", "postempId");
	
	LiferayPortletURL positionCreateURL = PortletURLFactoryUtil.create(request,		
		"Position" , position_plid, PortletRequest.ACTION_PHASE);

	positionCreateURL.setWindowState(LiferayWindowState.MAXIMIZED);
	positionCreateURL.setPortletMode(PortletMode.VIEW);
	positionCreateURL.setParameter("javax.portlet.action", "newPositions");
	
	LiferayPortletURL changeofstatusCreateURL = PortletURLFactoryUtil.create(request,		
	"ChangeOfStatus" , cos_plid, PortletRequest.ACTION_PHASE);
	
	changeofstatusCreateURL.setWindowState(LiferayWindowState.MAXIMIZED);
	changeofstatusCreateURL.setPortletMode(PortletMode.VIEW);
	changeofstatusCreateURL.setParameter("javax.portlet.action", "newChangeOfStatus");
	
	
	LiferayPortletURL managePositionURL = PortletURLFactoryUtil.create(request,		
	"Position" , position_plid, PortletRequest.ACTION_PHASE);

	managePositionURL.setWindowState(LiferayWindowState.MAXIMIZED);
	managePositionURL.setPortletMode(PortletMode.VIEW);
	managePositionURL.setParameter("javax.portlet.action", "managePosition");
	
	List<WFMS_Position> posnList = (List<WFMS_Position>) request.getAttribute("wfms_PositionTasksList");
	List<WFMS_Requisition> reqList = (List<WFMS_Requisition>) request.getAttribute("wfms_RequisitionTasksList");
	List<WFMS_COS> cosList = (List<WFMS_COS>) request.getAttribute("wfms_COSTasksList");
	
	Map<String,String> deptMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
	WMSUserAccessUtil wMSUserAccessUtil= new  WMSUserAccessUtil();
%>
 
<aui:form action="<%=editPOSURL.toString() %>" method="post"
	name="viewPosition">
	<aui:input name="positionId" type="hidden" value="" id="positionId" />
</aui:form>

<aui:form action="<%=editREQURL.toString() %>" method="post"
	name="viewRequisition">
	<aui:input name="reqId" type="hidden" value="" id="positionId" />
</aui:form>

<aui:form action="<%=editCOSURL.toString()%>" method="post"
	name="viewCOS" id="viewCOS">
	<aui:input name="<portlet:namespace/>cosId" id="cosId" type="hidden"
		value="" />
</aui:form>

<!-- HR Resources > Workforce Management -->

<div class="portlet-layout row wfm-system">

	<div class="col-sm-12">
		<% if(wMSUserAccessUtil.sericeNowisactiveOrnot()){%>
				<div style="background-color: #e41313;color: white; font-size: 133%; font-weight: bold; padding: 12px">
	             	The Email Flag was in Test Mode  
	             </div>
             	<%} %>
		<div class="wms-style-1">
		 <h3>Workforce Management System</h3>
			<% if(deptMap.isEmpty()) {
				String currentURL = PortalUtil.getCurrentURL(request);
				if(currentURL.contains("?")){
					currentURL = currentURL.split("\\?")[0];
				}
				%>
			<aui:script>
				  
				/*
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
		 */
				</aui:script>
				
			<%} %>
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-4 center">
				
						<%if(WMSUserAccessUtil.checkPermission(renderRequest,PortletPropsPermission.CRT_POS_ROLES)){ %>
							<aui:form action="<%= newPositionsURL.toString()%>" method="post"
								name="newPositions">
								
								<input id="dashboard_hma" name="redirectReq" type="button"
									value="Create Position" class="btn btn-primary"
									onclick="createPositionUrl('<%=positionCreateURL.toString()%>')">
								
							</aui:form>
						<%}%>
						
						<input type="button" value="Manage Position" class="btn btn-primary"
							onclick="managePositionUrl('<%=wmsBasePath%>/position')">

				</div>
			
				<div class="col-sm-4 center">

						<%if(WMSUserAccessUtil.isUserHaveRole(renderRequest,PortletPropsPermission.COS_CRT)){ %>
							<aui:form action="<%= newChangeOfStatusURL.toString()%>"
								method="post" name="newChangeOfStatus">
								
								<input name="redirectReq" type="button"
									value="Create Change of Status" class="btn btn-primary"
									onclick="createCosnUrl('<%=changeofstatusCreateURL.toString()%>')">
									
							</aui:form>
						<%} %>
						
						<input type="button" value="Manage Change of Status"
							class="btn btn-primary"
							onclick="changeofStatsUrl('<%=wmsBasePath%>/change-of-status')">
						
				</div>
			
				<div class="col-sm-4 center">
				
						<input type="button" value="View Associate History"
							class="btn btn-primary"
							onclick="associateHistoryUrl('<%=wmsBasePath%>/associate-history')">
		
						<input type="button" value="Manage Requisition"
							class="btn btn-primary"
							onclick="manageReqUrl('<%=wmsBasePath%>/requisition')">
							
				</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="portlet-layout row wfm-system" style="margin-top: 10px">
	<div class="col-sm-8">
	
		<div class="wms-style-2">
			<h4>My Open Tasks</h4>
			<div style="padding: 5px;">
				<script>
					$(document).ready(function() {
						$('#recordList').DataTable( {
							dom: 'Bfrtip',
						 buttons: [
								 'copy', 'excel', 'csv', 'pdf', 'print'
								],
								"initComplete": function(settings, json) {
									$('#recordList tbody').on( 'click', 'tr', function () {
										//console.log("Clicked: "+primaryKeyColumn);
										//console.log("Clicked: "+$(this).find("td")[primaryKeyColumn].innerHTML);
									 var recordId = $(this).attr("data-id");
									 var recordType = $(this).attr("data-type");
										
									 if(recordType=="position")
									 {
									 	
									 	$("#<portlet:namespace />positionId").val(recordId);
									 	var currenturl = $("#<portlet:namespace />viewPosition").attr( 'action' );
											currenturl = currenturl.replace("postempId",recordId);
											$("#<portlet:namespace />viewPosition").attr( 'action',currenturl);
											$("#<portlet:namespace />viewPosition").submit();
									 }
										if(recordType=="requisition")
									 {
									 	$("#<portlet:namespace />reqId").val(recordId);
									 	var currenturl = $("#<portlet:namespace />viewRequisition").attr( 'action' );
											currenturl = currenturl.replace("positiontempId",recordId);
											$("#<portlet:namespace />viewRequisition").attr( 'action',currenturl);
											$("#<portlet:namespace />viewRequisition").submit();
									 }
									if(recordType=="cos")
									 {
											$("#<portlet:namespace />cosId").val(recordId);
									 	var currenturl = $("#<portlet:namespace />viewCOS").attr( 'action' );
											currenturl = currenturl.replace("costempId",recordId);
											$("#<portlet:namespace />viewCOS").attr( 'action',currenturl)
										 $("#<portlet:namespace />viewCOS").submit();
										 }
									 
									} );
									$(".dt-button.buttons-copy").text("Copy to Clipboard");
								},
						} );
					} );
				</script>
				<div>
					<table cellspacing="0" class="display" id="recordList" width="100%">
						<thead>
							<tr>
								<th>Created Date</th>
								<th>Type</th>
	
								<th>Number</th>
	
								<th>Associate Name</th>
	
								<th>Status</th>
	
								<th>Due</th>
							</tr>
						</thead>
						<tbody>
							<%
					
					
					for(WFMS_Position position: posnList){
						if(position.getPId().contains("-WFM")){
								System.out.println("-WFM found in POS and filtered for "+position.getPId());
								continue;
								}
						if(!position.getStatus().equals("Cancelled")) {
						
					%>
	
							<tr title="Click to view and approve the Position Record"
								data-id="<%=position.getPId()%>" data-type="position">
								<td><%= HondaLogicUtil.getDateFormat(position.getCreateDate()) %></td>
								<td><%="POS"%></td>
								<td><%=position.getPId()%></td>
								<td><%=position.getAssociateName()%></td>
								<td><%=position.getStatus()%></td>
								<td></td>
							</tr>
							<%}%>
							<%}%>
							<%for(WFMS_Requisition requisition: reqList){ 
					 if(requisition.getRwfId().contains("-WFM")){
		 					System.out.println("-WFM found in REQ and filtered for "+requisition.getRwfId());
		 					continue;
		 					}
						if(!requisition.getStatus().equals("Cancelled") && requisition.getDeleteflagStatus() != 1) {
						
						%>
							<tr title="Click to view and approve the Requisition record"
								data-id="<%=requisition.getRwfId()%>" data-type="requisition">
								<td><%= HondaLogicUtil.getDateFormat(requisition.getCreateDate()) %></td>
								<td><%="REQ"%></td>
								<td><%=requisition.getRwfId()%></td>
								<td><%=requisition.getAssociatename()%></td>
								<td><%=requisition.getStatus()%></td>
								<td></td>
							</tr>
							<%}%>
							<%}%>
	
						<%
						for(WFMS_COS cos: cosList){ 
									
							if(cos.getCosId().contains("-WFM")){
									System.out.println("-WFM found in COS and filtered for "+cos.getCosId());
									continue;
							}
							
							if(!cos.getStatus().equals("Cancelled") && cos.getDeleteflagStatus() != 1) {
							%>
								<tr title="Click to view and approve the COS record"
									data-id="<%=cos.getCosId()%>" data-type="cos">
									<td><%= HondaLogicUtil.getDateFormat(cos.getCreateDate()) %></td>
									<td><%="COS"%></td>
									<td><%=cos.getCosId()%></td>
									<td><%=cos.getAssociatename()%></td>
									<td><%=cos.getStatus()%></td>
									<td></td>
								</tr>
							<%}%>
						<%}%>
	
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-4">
		<div class="wms-style-3">
			<h4>Reports</h4>
			<div class="wfm-system center" style="padding: 0 5px;">
				<div class="center">
					<button class="btn btn-secondary orange-btn"
						onclick="getOrganizationUrl('<%=wmsBasePath%>/org-chart')">Organization
						Chart</button>
					<button class="btn btn-secondary orange-btn" onclick="#">Reconciliation
						Query</button>
				</div>
			</div>
		</div>
	</div>

</div>

<script>

	function redirectToPosition() {
		document.getElementById('<portlet:namespace />newPositions').submit();		
	}
	
	function redirectToChangeOfStatus() {
		document.getElementById('<portlet:namespace />newChangeOfStatus').submit();			
	}
	
	function updateRequest() {	
		document.getElementById('<portlet:namespace />manageNotifications').submit();
	}
	
	function createPositionUrl(url) {
		window.location.href = url;
	}
	
	function managePositionUrl(url) {
		window.location.href = url;
	}
	
	function createCosnUrl(url) {
		window.location.href = url;
	}
	
	function changeofStatsUrl(url) {
		window.location.href = url;
	}
	function associateHistoryUrl(url) {
		window.location.href = url;
	}
	function getOrganizationUrl(url) {
		window.location.href = url;
	}
	function manageReqUrl(url) {
		window.location.href = url;
	}

</script>