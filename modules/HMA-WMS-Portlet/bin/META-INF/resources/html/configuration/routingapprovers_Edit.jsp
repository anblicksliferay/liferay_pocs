<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_names"%>
<%@ include file="/html/init.jsp" %>
<portlet:actionURL name="redirctcreaterouting" var="redirectcreateroutingURL"> </portlet:actionURL>
<%
WFMS_routing_and_approvers wfms_routing_and_approvers=null;
String actionName="";
if(Validator.isNotNull((String)request.getAttribute("Approverid"))){
String  approverId = (String)request.getAttribute("Approverid");
 wfms_routing_and_approvers=WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approvers(approverId);
 DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
 dynamicQueryForAction.add(PropertyFactoryUtil.forName("actionId").eq(wfms_routing_and_approvers.getAction()));
 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
 if(actionListof.size()>0)
   actionName=actionListof.get(0).getActionName().trim();
}
List<String> actionList=new ArrayList<String>();
List<String> sameLeadership = new ArrayList<String>();
List<String> actionSameJobcodeList=new ArrayList<String>();
List<String> isSameDept = new ArrayList<String>();
List<String> isSameMgr =  new ArrayList<String>();
 List<WFMS_routing_and_approvers> routing_and_approvers_list=WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approverses
(0,WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approversesCount());
for(WFMS_routing_and_approvers wfms_routng:routing_and_approvers_list){
	actionList.add(wfms_routng.getAction());
	actionSameJobcodeList.add(wfms_routng.getSameJobCode());
	sameLeadership.add(wfms_routng.getSameLeadership());
	isSameDept.add(wfms_routng.getIsSameDept());
	isSameMgr.add(wfms_routng.getIsSameMgr());
}

Set<String> hashSet = new HashSet<String>();

hashSet.addAll(actionList);
actionList.clear();
actionList.addAll(hashSet);

hashSet.addAll(actionSameJobcodeList);
actionSameJobcodeList.clear();
actionSameJobcodeList.addAll(hashSet);

hashSet.addAll(sameLeadership);
sameLeadership.clear();
sameLeadership.addAll(hashSet);

hashSet.addAll(isSameDept);
isSameDept.clear();
isSameDept.addAll(hashSet);

hashSet.addAll(isSameMgr);
isSameMgr.clear();
isSameMgr.addAll(hashSet);
%>

<portlet:actionURL name="deleteRoutingAndApprover" var="deleteRoutingAndApproverURL">
		<portlet:param name="rapId" value="<%=wfms_routing_and_approvers.getRapId()%>" />
</portlet:actionURL>

<aui:form method="post" action="<%=deleteRoutingAndApproverURL.toString()%>" name="deleteRoutingAndApprover" id="deleteRoutingAndApprover">
	
	<aui:input id="rapId" type="hidden" name="rapId" value="<%=wfms_routing_and_approvers.getRapId()%>" />
</aui:form>

<portlet:actionURL name="updaterouting" var="updateroutingURL"></portlet:actionURL>

<aui:form action="<%=updateroutingURL.toString()%>" method="post" id="updaterouting" name="updaterouting">
<aui:input name="actiontype" type="hidden"></aui:input>
	
	<div id="addConfigurationForm">
	<div class="portlet-layout">
		<h2 class="titleArea">Routing and Approvers</h2>
	</div>
	
	<div class="portlet-layout own-wrapper">
			<div class="wfm-system">
				<div class="portlet-layout row">
                           <div class="small center">
                                <div class="col-sm-4">
                                    <button class="btn btn-primary" onclick="getUrl('<%=wmsBasePath%>/configuration')">Exit View</button>
                                </div>
                                <div class="col-sm-4">
                                      <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('submit');" value="Submit"></aui:button>
                                </div>
                                <div class="col-sm-4">
								<button type="button" class="btn btn-primary" type="button"
								id="cancel" data-toggle="modal" data-backdrop="static" data-backdrop="static" data-target="#routing_approve_delete">Delete </button>
						  </div>
					</div>
				</div>
			</div>
		</div>
	<div class="portlet-layout">
			<div class="portlet-column portlet-column-first col-sm-8 box-content">
				<div>
					<aui:input name="rapId" type="hidden" value="<%=wfms_routing_and_approvers.getRapId() %>"></aui:input>
				<%-- 	<aui:input type="text" name="action"  label="Action" value="<%=wfms_routing_and_approvers.getAction() %>" ></aui:input>  --%>
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Action</div>
						<div id="action_routing_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						<aui:select name="action"  label="" id="action_routing" cssClass="field-select chosen" onchange="action_routingvalidate();"
									placeholder="">
							  <aui:option value="">Select Action</aui:option>
							<%  
							DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
							 dynamicQueryForAction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
							 dynamicQueryForAction.addOrder(OrderFactoryUtil.asc("actionName"));
							 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
							 for(WFMS_action_names val:actionListof){  %>		
								   <aui:option selected="<%=wfms_routing_and_approvers.getAction().equals(val.getActionId()) %>" value="<%=val.getActionId() %>"><%=val.getActionName() %></aui:option>
							 <%} %>	
							
						</aui:select>
						<div class="action_routing_ValidationMessage form-validator-stack help-inline" style="display: none;">
							Missing required value for the field "Action"
						</div>
						</div>
				</div>
				<div class="portlet-layout row">		
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Change Description</div>
						<div id="changedescription_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						<aui:input type="text" name="changeDescription" onChange="changedescriptionvalidate();" id="changedescription"  label="" value="<%=wfms_routing_and_approvers.getChangeDescription() %>"></aui:input> 
							
						</div>
						 <div class="changedescription_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
                                 Missing required value for the field "Change Description"
						</div>
				</div>
				<div class="portlet-layout row">		
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel " id="Current_Job_Code">
						<% if(actionName.equalsIgnoreCase("Leadership Assignment")){ %>
						        Current Leadership
						<% }else{ %>
						        Current JobCode
						<% } %>
</div>
						<div id="currentJobCode_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						
						<aui:input type="text" name="currentJobCodeORLeadership" id="currentJobCode" label="" value="<%=wfms_routing_and_approvers.getCurrentJobCodeORLeadership() %>"></aui:input>
						<div class="routingProcess_currentjob">
						 <p>(Enter CurrentJobCode(s) in Abbreviative formats {Ex: SE,BA})</p> 
						 </div>
						 <div class="routingProcess_job">
						 <p>(Enter Comma separated CurrentJobCode OR Leadership { ex: BA,SE or Team Manager,Lead Team Manager etc})</p>
						 </div >
						
						<div class="routingProcess_New_Leadership">
						 <p>(Enter Current Leadership(s) in following format {Ex: Team Manager,Lead Team Manager etc})</p> 
						 </div>
						<div class="routingProcess_leadership">
							<div class="portlet-layout row note" style="width: auto !important;">
									Please enter full title for JobCode. Such as <strong>"Team Manager,Lead Team Manager,Department Manager,Division Manager,Plant Manager".</strong>Do not use the Abbreviates for these. 
							</div>
						</div>
							
						</div>
						<div class="currentJobCode_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
                                 Missing required value for the field "CurrentJobCode OR Leadership"
						</div>
				</div>
				<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel " id="New_Job_Code">
						
						<% if(actionName.equalsIgnoreCase("Leadership Assignment")){ %>
						        New Leadership
						<% }else{ %>
						        New JobCode
						<% } %>
						
						</div>
						<div id="newjob_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						
						 <aui:input type="text" name="newJobCodeORLeadership" id="newJobcode"  label="" value="<%=wfms_routing_and_approvers.getNewJobCodeORLeadership() %>" ></aui:input> 
						<div class="routingProcess_job">						 
						 <p>(Enter Comma separated NewJobCode OR Leadership { ex: BA,SE or Team Manager,Lead Team Manager etc})</p>
						 </div>
						 <div class="routingProcess_currentjob">
						 <p>(Enter New JobCode(s) in Abbreviative formats {Ex: SE,BA})</p> 
						 </div>
						 
						 <div class="routingProcess_New_Leadership">
						 <p>(Enter New Leadership(s) in following format {Ex: Team Manager,Lead Team Manager etc})</p> 
						 </div>	
						
						<div class="routingProcess_leadership">
							<div class="portlet-layout row note" style="width: auto !important;">
									Please enter full title for Leadership. Such as <strong>"Team Manager,Lead Team Manager,Department Manager,Division Manager,Plant Manager".</strong>Do not use the Abbreviates for these. 
							</div>
						</div>
							
						</div>
						<div class="newJobcode_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
                                 Missing required value for the field "NewJobCode OR Leadership"
						</div>
				</div>
				<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Same JobCode</div>
						<div id="samejobcode_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:select name="SameJobCode"  label="" id="samejobcode" cssClass="field-select chosen" onchange="samejobcodevalidate();" >
								  <aui:option value="">Select Same JobCode</aui:option>
							
								 <%
								   List<String> jobCodeOptions = new ArrayList<String>();
								 jobCodeOptions.add("Can Match");
								 jobCodeOptions.add("Must Change");
								   jobCodeOptions.add("Must Match");
								   for(int i=0;i<jobCodeOptions.size();i++){  %>
								 <aui:option selected="<%=wfms_routing_and_approvers.getSameJobCode().equals(jobCodeOptions.get(i)) %>" value="<%=jobCodeOptions.get(i) %>"><%=jobCodeOptions.get(i) %></aui:option>
								<% } %>
							</aui:select>
						<div class="samejobcode_ValidationMessage form-validator-stack help-inline" style="display: none;">
							Missing required value for the field "Same JobCode"
						</div>
						</div>
				</div>
				<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Same Leadership</div>
						<div id="sameleadership_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:select name="SameLeadership"  label="" id="sameleadership"  cssClass="field-select chosen" onchange="sameleadershipvalidate();" >
								  <aui:option value="">Select Same Leadership</aui:option>
								 <%
							 List<String> leadershipOptions = new ArrayList<String>();
								 leadershipOptions.add("Can Match");
								 leadershipOptions.add("Must Change");
								 leadershipOptions.add("Must Match");
							 for(int i=0;i<leadershipOptions.size();i++){  %>
								 <aui:option selected="<%=wfms_routing_and_approvers.getSameLeadership().equals(leadershipOptions.get(i)) %>" value="<%=leadershipOptions.get(i) %>"><%=leadershipOptions.get(i) %></aui:option>
								<% } %>
							</aui:select>
						<div class="sameleadership_ValidationMessage form-validator-stack help-inline" style="display: none;">
							Missing required value for the field "Same Leadership"
						</div>
						</div>
				</div>
				<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Is SameDept</div>
						<div id="issamedept_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:select name="isSameDept"  label="" id="issamedept"  cssClass="field-select chosen" onchange="issamedeptvalidate();" >
								  <aui:option value="">Select Is SameDept</aui:option>
						<%
								 List<String> departmentOptions = new ArrayList<String>();
								 departmentOptions.add("Can Match");
								 departmentOptions.add("Must Change");
								 departmentOptions.add("Must Match");
								 for(int i=0;i<departmentOptions.size();i++){  %>
								 <aui:option selected="<%=wfms_routing_and_approvers.getIsSameDept().equals(departmentOptions.get(i)) %>" value="<%=departmentOptions.get(i) %>"><%=departmentOptions.get(i) %></aui:option>
								<% } %>

							</aui:select>
						<div class="issamedept_ValidationMessage form-validator-stack help-inline" style="display: none;">
							Missing required value for the field "Is SameDept"
						</div>
						</div>
				</div>
				<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Is SameMgr</div>
						<div id="issamemngr_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:select name="isSameMgr"  label="" id="issamemngr"  cssClass="field-select chosen" onchange="issamemngrvalidate();" >
								  <aui:option value="">Select Is SameMgr</aui:option>
								 <%
								 List<String> sameMgrOptions = new ArrayList<String>();
								 sameMgrOptions.add("Can Match");
								 sameMgrOptions.add("Must Change");
								 sameMgrOptions.add("Must Match");
								 for(int i=0;i<sameMgrOptions.size();i++){  %>
								 <aui:option selected="<%=wfms_routing_and_approvers.getIsSameMgr().equals(sameMgrOptions.get(i)) %>"  value="<%=sameMgrOptions.get(i) %>"><%=sameMgrOptions.get(i) %></aui:option>
								<% } %>
							</aui:select>
						<div class="issamemngr_ValidationMessage form-validator-stack help-inline" style="display: none;">
							Missing required value for the field "Is SameMgr"
						</div>
						</div>
				</div>	
 						
						<div class="portlet-layout row">		
							<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Notification To</div>
							<div id="currentnotification_mainDiv" class="portlet-column portlet-column-last col-sm-8 note-child">
							
							<aui:input type="text" name="notificationTo" onChange="current_notificationvalidate();" id="current_Notification" label="" value="<%=wfms_routing_and_approvers.getNotificationTo() %>"></aui:input>
								<p class="roles-note">(Enter Comma separated Role values { ex: current DVM,new DVM etc})</p>
			<div class="portlet-layout row note">
				<ul>
				<li class="routing_current_config">The current Role titles available in the system are: <strong>Staffing,CMP,DMP,Payroll,CAC,PR Notify</strong> </li>
				<li class="routing_current_config">Based on the COS creation, system will send notification to Creator / Staffing after approval flow. Please do not enter "Creator / Staffing" value in the input box.</li>
				<li class="routing_current_config">Do not enter "Payroll" in abbreviated format i.e PR in input box </li>
				</ul>
        	</div>
						</div>
							<div class="current_Notification_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
									 Missing required value for the field "Notification To"
							</div>
						</div>
						
						<div class="portlet-layout row">		
							<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Routing Process</div>
							<div id="currentrouting_mainDiv" class="portlet-column portlet-column-last col-sm-8 note-child">
							
							<aui:input type="text" name="routingProcess" onChange="current_routingnvalidate();" id="current_routing" label="" value="<%=wfms_routing_and_approvers.getRoutingProcess() %>"></aui:input>
								<p class="roles-note">(Enter Comma separated Role values { ex: current DVM,new DVM etc})</p>
							<div class="portlet-layout row note">
			The current Role titles available in the system are: <strong>AR LOA,SP DM,CMP,HR DM,Ops Leader,new DVM,current DVM,new DM,current DM</strong> 
        	</div>
							</div>
							<div class="current_routing_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
									 Missing required value for the field "Routing Process"
							</div>
						</div>
					
        				<aui:input name="actiontype" type="hidden"></aui:input>
        				
        				<div style="display: none;">
							  <aui:input type="textarea" name="hidden_field" label="" required="true" > </aui:input>
		                      <aui:input type="textarea" name="validation_type" label="" value="0" > </aui:input>
						</div>
						
					
				</div>
				
			</div>
			<div class="portlet-column portlet-column-first col-sm-4">
				<div class="box-details">
				
					<h3>Routing and approvers ID : <%=wfms_routing_and_approvers.getRapId() %></h3>
					<div>
				
					</div>
					<ul class="box-detail-list">
						<li>Created By:</li>
						<li><%=wfms_routing_and_approvers.getCreatedBy() %></li>
						<li>Date Created:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_routing_and_approvers.getCreateDate())%></li>
						<li>Modified By:</li>
						<li><%=wfms_routing_and_approvers.getModifiedBy()%></li>
						<li>Modified Date:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_routing_and_approvers.getModifiedDate())%></li>
					</ul>
					
				</div>
			</div>
	</div>
</div>
	
</aui:form>

<div class="modal fade" id="routing_approves_popUp" style="display: none;">
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
						    <li class="action_routing_ValidationMessage form-validator-stack help-inline" style="display: none;">Action</li>
	                   		<li class="changedescription_ValidationMessage form-validator-stack help-inline" style="display: none;">Change Description</li>
	                        <li class="currentJobCode_ValidationMessage form-validator-stack help-inline" style="display: none;">CurrentJobCode OR Leadership</li>
							<li class="newJobcode_ValidationMessage form-validator-stack help-inline" style="display: none;">NewJobCode OR Leadership</li>
	                   		<li class="samejobcode_ValidationMessage form-validator-stack help-inline" style="display: none;">Same JobCode</li>
	                        <li class="sameleadership_ValidationMessage form-validator-stack help-inline " style="display: none;">Same Leadership</li>
							<li class="issamedept_ValidationMessage form-validator-stack help-inline " style="display: none;">Is SameDept</li>
							<li class="issamemngr_ValidationMessage form-validator-stack help-inline " style="display: none;">Is SameMgr</li>
	                   		<li class="current_Notification_ValidationMessage_popup form-validator-stack help-inline" style="display: none;">Notification To</li>
	                        <li class="current_routing_ValidationMessage_popup form-validator-stack help-inline" style="display: none;">Routing Process</li>
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

<!-- Start PopUp for Routing and Approvers  -->

  <div class="modal fade" id="routing_approve_delete" style="display:none;">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="yui3-widget-hd modal-header">
			      <div class="toolbar-content yui3-widget component toolbar">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<h3>Do you want to Delete the Routing and Approvers?</h3>
				</div>
				<div class="yui3-widget-bd modal-body" style="max-height: 150px; height: 60px;">
				<div class="portlet-layout row">
				    <aui:button cssClass="btn btn-primary col-sm-5" name="deleteRoutingAndApprover"  type="button"
							onClick='<%=deleteRoutingAndApproverURL.toString()%>' value="Yes"></aui:button>

						<div class="col-sm-2"></div>
						     <button class="btn btn-primary col-sm-5" type="button" data-dismiss="modal">No</button>
				 </div>
				 </div>
			</div>
		</div>
	</div>
  
<!-- End Workflow -->

<script>
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
function action_routingvalidate(){
         var val=$("#<portlet:namespace />action_routing");
		 if($.trim(val.val())==''){
			$(".action_routing_ValidationMessage").show();
			$(".routingProcess_leadership").hide();
			$(".routingProcess_job").show();
			$(".routingProcess_currentjob").hide();
			$(".routingProcess_New_Leadership").hide();
            $('#action_routing_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
			$("#Current_Job_Code").html("CurrentJobCode OR Leadership");
			$("#New_Job_Code").html("NewJobCode OR Leadership");
			//val.focus();
		}
		else{

			var text=$.trim($("#<portlet:namespace />action_routing :selected").text());
			if(text=="Leadership Assignment"){
				$("#Current_Job_Code").html("Current Leadership");
				$("#New_Job_Code").html("New Leadership");
				$(".routingProcess_job").hide();
				$(".routingProcess_currentjob").hide();
				$(".routingProcess_leadership").show();
				$(".routingProcess_New_Leadership").show();
			}
			else{
				$("#Current_Job_Code").html("Current JobCode");
				$("#New_Job_Code").html("New JobCode");
				$(".routingProcess_leadership").hide();
				$(".routingProcess_job").hide();
				$(".routingProcess_currentjob").show();
				
				$(".routingProcess_New_Leadership").hide();
			}
			
			
		 $('#action_routing_mainDiv').removeClass('control-group error');
		 $(".action_routing_ValidationMessage").hide();
		}
	}

function sameleadershipvalidate(){
        var type=$("#<portlet:namespace/>validation_type").val();
		 var val=$("#<portlet:namespace />sameleadership");
		 if(val.val()=='' && type==1){
			$(".sameleadership_ValidationMessage").show();
            $('#sameleadership_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
			//val.focus();
		}
		else{
		 $('#sameleadership_mainDiv').removeClass('control-group error');
		 $(".sameleadership_ValidationMessage").hide();
		}
	}

	
	function issamedeptvalidate(){
        var type=$("#<portlet:namespace/>validation_type").val();
		 var val=$("#<portlet:namespace />issamedept");
		 if(val.val()=='' && type==1){
			$(".issamedept_ValidationMessage").show();
            $('#issamedept_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
			//val.focus();
		}
		else{
		 $('#issamedept_mainDiv').removeClass('control-group error');
		 $(".issamedept_ValidationMessage").hide();
		}
	}
	
	function issamemngrvalidate(){
        var type=$("#<portlet:namespace/>validation_type").val();
		 var val=$("#<portlet:namespace />issamemngr");
		 if(val.val()=='' && type==1){
			$(".issamemngr_ValidationMessage").show();
            $('#issamemngr_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
			//val.focus();
		}
		else{
		 $('#issamemngr_mainDiv').removeClass('control-group error');
		 $(".issamemngr_ValidationMessage").hide();
		}
	}
	
	
	function samejobcodevalidate(){
        var type=$("#<portlet:namespace/>validation_type").val();
		 var val=$("#<portlet:namespace />samejobcode");
		 if(val.val()=='' && type==1){
			$(".samejobcode_ValidationMessage").show();
            $('#samejobcode_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
			//val.focus();
		}
		else{
		 $('#samejobcode_mainDiv').removeClass('control-group error');
		 $(".samejobcode_ValidationMessage").hide();
		}
	}
	
	function changedescriptionvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />changedescription").val();
		if(val=='' && type==1){
			$(".changedescription_ValidationMessage").show();
            $('#changedescription_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".changedescription_ValidationMessage").hide();
            $('#changedescription_mainDiv').removeClass('control-group error');
		}
	}
	
	function newjob_desvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />newJobcode").val();
		if(val=='' && type==1){
			$(".newJobcode_ValidationMessage").show();
            $('#newjob_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".newJobcode_ValidationMessage").hide();
            $('#newjob_mainDiv').removeClass('control-group error');
		}
	}
	
	                    
	function current_jobcodevalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />currentJobCode").val();
		if(val=='' && type==1){
			$(".currentJobCode_ValidationMessage").show();
            $('#currentJobCode_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".currentJobCode_ValidationMessage").hide();
            $('#currentJobCode_mainDiv').removeClass('control-group error');
		}
	}
	
	
	function current_notificationvalidate(){
       
		var val=$("#<portlet:namespace />current_Notification").val();
		if(val==''){
			$(".current_Notification_ValidationMessage").html("Missing required value for the field \"Notification To\"");
			$(".current_Notification_ValidationMessage_popup").html("Notification To");
			$(".current_Notification_ValidationMessage").show();
            $('#currentnotification_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".current_Notification_ValidationMessage").hide();
            $('#currentnotification_mainDiv').removeClass('control-group error');
		}
	}
	function notificationRolesValid(){
        var val=$("#<portlet:namespace />current_Notification").val();
		if(val!=''){
			var rolesArray = ['Staffing','CMP','DMP','Payroll','CAC','PR Notify'];
			var rolesArrayLowerCase = [];
			for (var i = 0; i < rolesArray.length; i++) {
				rolesArrayLowerCase.push(rolesArray[i].toLowerCase());
			}
			rolesArrayLowerCase.sort();
			var invalidRoles="";
			var valArray = val.split(',');
			   $.each(valArray, function(index, value) {
                 var number =$.inArray( $.trim(value.toLowerCase()), rolesArrayLowerCase);
                 if(number==-1){
					if(invalidRoles=="")
                       invalidRoles=value;		
				     else
					   invalidRoles=invalidRoles+", "+value;		
				 }
				});
			 if(invalidRoles!=""){
				    $(".current_Notification_ValidationMessage").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
					 $(".current_Notification_ValidationMessage_popup").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
				$(".current_Notification_ValidationMessage").show();
				$(".current_Notification_ValidationMessage_popup").show();
	            $('#currentnotification_mainDiv').addClass('control-group error');
				$('#<portlet:namespace/>hidden_field').val('');  
			}
			else{
				$(".current_Notification_ValidationMessage").hide();
				$(".current_Notification_ValidationMessage_popup").hide();
				$('#currentnotification_mainDiv').removeClass('control-group error');
			}
		}
}
function current_routingnvalidate(){
		var val=$("#<portlet:namespace />current_routing").val();
		if(val==''){
			$(".current_routing_ValidationMessage").html("Missing required value for the field \"Routing Process\"");
			$(".current_routing_ValidationMessage_popup").html("Routing Process");
			$(".current_routing_ValidationMessage").show();
            $('#currentrouting_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".current_routing_ValidationMessage").hide();
            $('#currentrouting_mainDiv').removeClass('control-group error');
		}
	}
function routingprocessRolesValid(){
    var val=$("#<portlet:namespace />current_routing").val();
	if(val!=''){
		var rolesArray = ['AR LOA','SP DM','CMP','HR DM','Ops Leader','new DVM','current DVM','new DM','current DM'];
		var noApprovalRoles =[''];//'staffing','current dmp','new dmp','cac'
		var rolesArrayLowerCase = [];
		//var invalidApprovalRoles="";
		for (var i = 0; i < rolesArray.length; i++) {
			rolesArrayLowerCase.push(rolesArray[i].toLowerCase());
		}
		rolesArrayLowerCase.sort();
		var invalidRoles="";
		var valArray = val.split(',');
		   $.each(valArray, function(index, value) {
             var number =$.inArray( $.trim(value.toLowerCase()), rolesArrayLowerCase);
             if(number==-1){
				if(invalidRoles=="")
                   invalidRoles=value;
			     else
				   invalidRoles=invalidRoles+", "+value;		
			 }
			 /* else{
				if($.inArray( value.toLowerCase(), noApprovalRoles)!=-1){
					if(invalidApprovalRoles=="")
						invalidApprovalRoles=value;
					else
						invalidApprovalRoles=invalidApprovalRoles+", "+value;
				} 
			 }*/
			 
			});
		 if(invalidRoles!=""){
			 //if(invalidRoles!=""){
			    $(".current_routing_ValidationMessage").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
				 $(".current_routing_ValidationMessage_popup").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
				
			// }
			 /* else{
			    $(".current_routing_ValidationMessage").html("please check once below roles has no Approvel process<br>\""+invalidApprovalRoles+"\"");
				$(".current_routing_ValidationMessage_popup").html("please check once below roles has no Approvel process<br>\""+invalidApprovalRoles+"\"");
			 } */
			$(".current_routing_ValidationMessage").show();
			$(".current_routing_ValidationMessage_popup").show();
            $('#currentrouting_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');  
		}
		else{
			$(".current_routing_ValidationMessage").hide();
			$(".current_routing_ValidationMessage_popup").hide();
			$('#currentrouting_mainDiv').removeClass('control-group error');
		}
	}
}

jQuery(document).ready(function(){
	jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	// $(".routingProcess_leadership").show();
	
	 $(".routingProcess_job").hide();
	 // 
	  
	  var val=$("#<portlet:namespace />action_routing");
		 if($.trim(val.val())==''){
			$(".routingProcess_leadership").hide();
			 $(".routingProcess_New_Leadership").hide();
			 $(".routingProcess_currentjob").hide();
		}
		else{
			var text=$.trim($("#<portlet:namespace />action_routing :selected").text());
			if(text=="Leadership Assignment"){
				$(".routingProcess_leadership").show();
				 $(".routingProcess_New_Leadership").show();
				 $(".routingProcess_currentjob").hide();
			}
			else{
				$(".routingProcess_currentjob").show();
				$(".routingProcess_leadership").hide();
				 $(".routingProcess_New_Leadership").hide();
			}
	
		 $('#action_routing_mainDiv').removeClass('control-group error');
		 $(".action_routing_ValidationMessage").hide();
		}
	 
	 
});

function validateForm(value) {
 $('#<portlet:namespace/>hidden_field').val('1');
           
		 if(value == "submit"){
			$("#<portlet:namespace/>validation_type").val(1);
				changedescriptionvalidate();
				 current_routingnvalidate();
				 routingprocessRolesValid();
                 action_routingvalidate();
				 notificationRolesValid();
				// current_jobcodevalidate();
				// newjob_desvalidate();
				 current_notificationvalidate();
				  samejobcodevalidate();
				  sameleadershipvalidate();
				  issamedeptvalidate();
				  issamemngrvalidate();

				var auiForm = Liferay.Form._INSTANCES.<portlet:namespace/>updaterouting;
				 var auiValidator = auiForm.formValidator;
				 auiValidator.validate();
				 if (!auiValidator.hasErrors()) {
					  $('#routing_approves_popUp').modal('hide');
		 			  $("button[type=button]").attr('disabled',true); 
					  $("#<portlet:namespace/>actiontype").val(value);
					  $("#<portlet:namespace/>updaterouting").submit();
				  }		
				  else{
					 $('#routing_approves_popUp').modal({ backdrop: 'static',
									keyboard: true, 
									show: true});
					}
				 }
				else if (value == "renderView"){
					$("#<portlet:namespace/>actiontype").val(value);
				   $("#<portlet:namespace/>updaterouting").submit();
				}
				else{
					$("#<portlet:namespace/>actiontype").val(value);
					   $("#<portlet:namespace/>updaterouting").submit();
				}
}
</script>

