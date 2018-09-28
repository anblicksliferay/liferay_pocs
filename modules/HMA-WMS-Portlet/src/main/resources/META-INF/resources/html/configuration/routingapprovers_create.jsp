<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_names"%>
<%@ include file="/html/init.jsp" %>
<portlet:actionURL name="createRoutingAndApprover" var="updateroutingURL"></portlet:actionURL>
<%
List<String> actionList = new ArrayList<String>();
List<String> sameJobCode = new ArrayList<String>();
List<String> sameLeaderShip = new ArrayList<String>();
List<String> issameDept = new ArrayList<String>();
List<String> isSameLeader = new ArrayList<String>();
List<WFMS_routing_and_approvers> routing_and_approvers = WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approverses
(0, WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approversesCount());

for(WFMS_routing_and_approvers routing_approversList :routing_and_approvers ){
	actionList.add(routing_approversList.getAction());
	sameJobCode.add(routing_approversList.getSameJobCode());
	sameLeaderShip.add(routing_approversList.getSameLeadership());
	issameDept.add(routing_approversList.getIsSameDept());
	isSameLeader.add(routing_approversList.getIsSameMgr());
}

Set<String> hs = new HashSet<String>();

hs.addAll(actionList);
actionList.clear();
actionList.addAll(hs);

hs.addAll(sameJobCode);
sameJobCode.clear();
sameJobCode.addAll(hs);

hs.addAll(sameLeaderShip);
sameLeaderShip.clear();
sameLeaderShip.addAll(hs);

hs.addAll(issameDept);
issameDept.clear();
issameDept.addAll(hs);

hs.addAll(isSameLeader);
isSameLeader.clear();
isSameLeader.addAll(hs);

%>
<aui:form action="<%=updateroutingURL.toString()%>" method="post" id="createRoutingAndApprover" name="createRoutingAndApprover">
<aui:input name="actiontype" type="hidden"></aui:input>
	<div class="portlet-layout">
		<h2 class="titleArea">Routing and Approvers</h2>
	</div>
		<div class="portlet-layout">
			<div class="col-sm-12 own-wrapper">
				<div class="wfm-system">
					<div class="portlet-layout">
						<div class="portlet-column portlet-column-first">
                               <div class="small center">
                                       <div class="col-sm-6">
                                        <button class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/configuration')">Exit View</button>
                                        </div>
                                       <div class="col-sm-6">
                                          <aui:button class="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('submit');" value="Submit"></aui:button>
                                </div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="wfm-system" style="margin-top: 20px;">
			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Action</div>
				<div id="mpCatBudget_mainDiv" class="portlet-column portlet-column-last col-sm-3">
						<aui:select name="action" id="mpCatBudget" cssClass="field-select chosen" onchange="actionBudgetvalidate();"
									placeholder="" label="" >
							<aui:option value="">Select Action</aui:option>
							<%  
							DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
							 dynamicQueryForAction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
							 dynamicQueryForAction.addOrder(OrderFactoryUtil.asc("actionName"));
							 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
							 for(WFMS_action_names val:actionListof){  %>		
								   <aui:option value="<%=val.getActionId() %>"><%=val.getActionName() %></aui:option>
							 <%} %>
						</aui:select>
						<div class="mpCatBudget_ValidationMessage form-validator-stack help-inline " style="display: none;">
							Missing required value for the field "Action"
						</div>
				</div>
			</div>
			
			<div class="portlet-layout row">
					<div
						class="portlet-column portlet-column-first col-sm-4 sectionLabel">Change Description</div>
					<div id="change_des_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						 <aui:input type="text" name="changeDescription"  label="" onkeyup="change_desvalidate();" id="change_des" ></aui:input> 
						<div class="change_des_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-bottom: 9px;">
	                                 Missing required value for the field "Change Description"
						</div>
					</div>
			</div>
	
			<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel" id="Current_Job_Code">CurrentJobCode OR Leadership</div>
					<div id="current_jobcode_mainDiv" class="portlet-column portlet-column-last col-sm-4">
					
					<div class="routingProcess_leadership">
					<div class="portlet-layout row note">
							Please enter full title for Leadership. Such as <strong>"Team Manager,Lead Team Manager,Department Manager,Division Manager,Plant Manager".</strong>Do not use the Abbreviates for these. 
					</div>
					</div>
					
						 <aui:input type="text" name="currentJobCodeORLeadership"  label="" id="current_jobcode" ></aui:input>
						 <div class="routingProcess_currentjob">
						 <p>(Enter Current JobCode(s) in Abbreviative formats {Ex: SE,BA})</p> 
						 </div>
						 <div class="routingProcess_job">
						 <p>(Enter Comma separated CurrentJobCode OR Leadership { ex: BA,SE or Team Manager,Lead Team Manager etc})</p>
						 </div >
						 <div class="routingProcess_New_Leadership">
						 <p>(Enter Current Leadership(s) in following format {Ex: Team Manager,Lead Team Manager etc})</p> 
						 </div>
					</div>
					<div class="current_jobcode_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "CurrentJobCode OR Leadership"
					</div>
			</div>	
			<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel " id="New_Job_Code">NewJobCode OR Leadership</div>

					 <div id="newjob_mainDiv" class="portlet-column portlet-column-last col-sm-4">
					 
					 <div class="routingProcess_leadership">
					<div class="portlet-layout row note">
							Please enter full title for Leadership. Such as <strong>"Team Manager,Lead Team Manager,Department Manager,Division Manager,Plant Manager".</strong>Do not use the Abbreviates for these. 
					</div>
					</div>
						 <aui:input type="text" name="newJobCodeORLeadership"  label=""  id="newJobcode" ></aui:input>
						<div class="routingProcess_job">						 
						 <p>(Enter Comma separated NewJobCode OR Leadership { ex: BA,SE or Team Manager,Lead Team Manager etc})</p>
						 </div>
						 <div class="routingProcess_currentjob">
						 <p>(Enter New JobCode(s) in Abbreviative formats {Ex: SE,BA})</p> 
						 </div>
						 
						 <div class="routingProcess_New_Leadership">
						 <p>(Enter New Leadership(s) in following format { ex: Team Manager,Lead Team Manager etc})</p> 
						 </div>
					</div>
					<div class="newJobcode_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "NewJobCode OR Leadership"
					</div>
			</div>
                            
			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Same JobCode</div>

				<div id="samejobcode_mainDiv" class="portlet-column portlet-column-last col-sm-3">
						<aui:select name="SameJobCode" id="samejobcode" cssClass="field-select chosen" onchange="samejobcodevalidate();"
									placeholder="" label="" >
							<aui:option value="">Select Same JobCode</aui:option>
							 <%
                                 List<String> jobCodeOptions = new ArrayList<String>();
									 jobCodeOptions.add("Can Match");
									 jobCodeOptions.add("Must Change");
									 jobCodeOptions.add("Must Match");
								  for(int i=0;i<jobCodeOptions.size();i++){  %>
								 <aui:option value="<%=jobCodeOptions.get(i) %>"><%=jobCodeOptions.get(i) %></aui:option>
								<% } %>
						</aui:select>
						<div class="samejobcode_ValidationMessage form-validator-stack help-inline " style="display: none;">
							Missing required value for the field "Same JobCode"
						</div>
				</div>
			</div>
			<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Same Leadership</div>

					<div id="sameleadership_mainDiv" class="portlet-column portlet-column-last col-sm-3">
						 <aui:select name="SameLeadership"  label="" id="sameleadership"  cssClass="field-select chosen" onchange="sameleadershipvalidate();"
									placeholder="" >
							  <aui:option value="">Select Same Leadership</aui:option>
								   <%
								   List<String> leadershipOptions = new ArrayList<String>();
								   leadershipOptions.add("Can Match");
								   leadershipOptions.add("Must Change");
								   leadershipOptions.add("Must Match");
								   for(int i=0;i<leadershipOptions.size();i++){  %>
								 <aui:option value="<%=leadershipOptions.get(i) %>"><%=leadershipOptions.get(i) %></aui:option>
								<% } %>
						</aui:select>
						<div class="sameleadership_ValidationMessage form-validator-stack help-inline " style="display: none;">
							Missing required value for the field "Same Leadership"
						</div>

					</div>
			</div>
			<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Is SameDept</div>

				<div id="issamedept_mainDiv" class="portlet-column portlet-column-last col-sm-3">
					<%-- 	<aui:input type="text" name="isSameDept"  label=""  ></aui:input> --%>
             			<aui:select name="isSameDept"  label="" id="issamedept"  cssClass="field-select chosen" onchange="issamedeptvalidate();"
									placeholder="" >
									 <aui:option value="">Select Same Department</aui:option>
							 <% 
							 List<String> departmentOptions = new ArrayList<String>();
							 departmentOptions.add("Can Match");
							 departmentOptions.add("Must Change");
							 departmentOptions.add("Must Match");
							 for(int i=0;i<departmentOptions.size();i++){  %>
								 <aui:option value="<%=departmentOptions.get(i) %>"><%=departmentOptions.get(i) %></aui:option>
								<% } %>
					 			
						</aui:select>
						<div class="issamedept_ValidationMessage form-validator-stack help-inline " style="display: none;">
							Missing required value for the field "Is SameDept"
						</div>
					</div>
        	</div>
        
           <div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Is SameMgr</div>

					<div id="issamemngr_mainDiv" class="portlet-column portlet-column-last col-sm-3">
						<%-- <aui:input type="text" name="isSameMgr"  label="" ></aui:input> --%>
 						<aui:select name="isSameMgr"  label="" id="issamemngr" cssClass="field-select chosen" onchange="issamemngrvalidate();"
									placeholder="" >
							  <aui:option value="">Select Is SameMgr</aui:option>
								 <%
								 List<String> sameMgrOptions = new ArrayList<String>();
								 sameMgrOptions.add("Can Match");
								 sameMgrOptions.add("Must Change");
								 sameMgrOptions.add("Must Match");
								 for(int i=0;i<sameMgrOptions.size();i++){  %>
								 <aui:option value="<%=sameMgrOptions.get(i) %>"><%=sameMgrOptions.get(i) %></aui:option>
								<% } %>
						</aui:select>
						<div class="issamemngr_ValidationMessage form-validator-stack help-inline " style="display: none;">
							Missing required value for the field "Is SameMgr"
						</div>
					</div>
            </div>
            <div class="portlet-layout row">
				<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Notification To</div>
				<div id="notificationTo_mainDiv" class="portlet-column portlet-column-last note-child col-sm-4">
							<aui:input type="text" name="notificationTo"  label="" onkeyup="notificationtorouting();" id="notification" ></aui:input> 
							<p>(Enter Comma separated Role values { ex: current DVM,new DVM etc})</p>
							<div class="notificationTo_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-bottom: 9px;">
			                    Missing required value for the field "Notification To"
							</div>
				</div>
				<div class="portlet-layout row note">
					The current Role titles available in the system are: <strong>Staffing, DMP, CMP, Payroll, CAC, PR Notify</strong> 
		        </div>
        	</div>
        
         	<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Routing Process</div>
					<div id="routingProcess_mainDiv" class="portlet-column portlet-column-last col-sm-4 note-child">
					
						<aui:input type="textarea" name="routingProcess" label="" onkeyup="routingprocess_main();" id="routingprocess_create"></aui:input>	
        				<p style="float: left; margin-top: 15px;">(Enter Comma separated Role values { ex: current DVM,new DVM etc})</p>
					</div>
					<div class="portlet-layout row note">
							The current Role titles available in the system are: <strong>AR LOA,SP DM,CMP,HR DM,Ops Leader,new DVM,current DVM,new DM,current DM</strong> 
			        </div>
					<div class="routingProcess_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-bottom: 9px;">
                                 Missing required value for the field "Routing Process"
					</div>
        	</div>
			
			
			<div style="display: none;">
					  <aui:input type="textarea" name="hidden_field" label="" required="true" > </aui:input>
                      <aui:input type="textarea" name="validation_type" label="" value="0" > </aui:input>
			</div>
		</div>
		<div class="scroll_back_to_top">
		<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
		</div>
		</div>
		
</aui:form>

<div class="modal fade" id="showValidations" style="display: none;">
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
						    <li class="mpCatBudget_ValidationMessage form-validator-stack help-inline" style="display: none;">Action</li>
	                   		<li class="change_des_ValidationMessage form-validator-stack help-inline" style="display: none;">Change Description</li>
	                        <li class="current_jobcode_ValidationMessage form-validator-stack help-inline" style="display: none;">CurrentJobCode OR Leadership</li>
							<li class="newJobcode_ValidationMessage form-validator-stack help-inline" style="display: none;">NewJobCode OR Leadership</li>
	                   		<li class="samejobcode_ValidationMessage form-validator-stack help-inline" style="display: none;">Same JobCode</li>
	                        <li class="sameleadership_ValidationMessage form-validator-stack help-inline " style="display: none;">Same Leadership</li>
							<li class="issamedept_ValidationMessage form-validator-stack help-inline " style="display: none;">Is SameDept</li>
							<li class="issamemngr_ValidationMessage form-validator-stack help-inline " style="display: none;">Is SameMgr</li>
	                   		<li class="notificationTo_ValidationMessage_popup form-validator-stack help-inline" style="display: none;">Notification To</li>
	                        <li class="routingProcess_ValidationMessage_popup form-validator-stack help-inline" style="display: none;">Routing Process</li>
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

<aui:script>
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

	function actionBudgetvalidate(){
		
         var actionVal=$.trim($("#<portlet:namespace />mpCatBudget").val());
		 if(actionVal==''){
			 $(".routingProcess_leadership").hide();
			$(".mpCatBudget_ValidationMessage").show();
			$(".routingProcess_New_Leadership").hide();
			$(".routingProcess_job").show();
			$("#Current_Job_Code").html("CurrentJobCode OR Leadership");
			$("#New_Job_Code").html("NewJobCode OR Leadership");
			$('#mpCatBudget_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
			
		}
		else{
			var text=$.trim($("#<portlet:namespace />mpCatBudget :selected").text());
			if(text=="Leadership Assignment"){
				$("#Current_Job_Code").html("Current Leadership");
				$(".routingProcess_leadership").show();
				$(".routingProcess_New_Leadership").show();
				$(".routingProcess_job").hide();
				$(".routingProcess_newjob").hide();
				$(".routingProcess_currentjob").hide();
				$("#New_Job_Code").html("New Leadership");
				
				
			}
			else{
				$("#Current_Job_Code").html("Current JobCode");
				$("#New_Job_Code").html("New JobCode");
				$(".routingProcess_New_Leadership").hide();
				$(".routingProcess_currentjob").show();
				$(".routingProcess_newjob").show();
				$(".routingProcess_job").hide();
				$(".routingProcess_leadership").hide();
			}
			
         $('#mpCatBudget_mainDiv').removeClass('control-group error');
         $(".mpCatBudget_ValidationMessage").hide();
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
	
	function change_desvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />change_des").val();
		if(val=='' && type==1){
			$(".change_des_ValidationMessage").show();
                $('#change_des_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".change_des_ValidationMessage").hide();
                $('#change_des_mainDiv').removeClass('control-group error');
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
		var val=$("#<portlet:namespace />current_jobcode").val();
		if(val=='' && type==1){
			$(".current_jobcode_ValidationMessage").show();
                $('#current_jobcode_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".current_jobcode_ValidationMessage").hide();
                $('#current_jobcode_mainDiv').removeClass('control-group error');
		}
	}
	
	function notificationtorouting(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />notification").val();
		if(val=='' && type==1){
			
			$(".notificationTo_ValidationMessage").html("Missing required value for the field \"Notification To\"");
			$(".notificationTo_ValidationMessage_popup").html("Notification To");
			$(".notificationTo_ValidationMessage").show();
			$(".notificationTo_ValidationMessage_popup").show();
			
                $('#notificationTo_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".notificationTo_ValidationMessage").hide();
			$(".notificationTo_ValidationMessage_popup").hide();
                $('#notificationTo_mainDiv').removeClass('control-group error');
		}
	}
	function notificationRolesValid(){
	                    var val=$("#<portlet:namespace />notification").val();
						if(val!=''){
							var rolesArray = ['Staffing','DMP','CMP','Payroll','CAC','PR Notify'];
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
								    $(".notificationTo_ValidationMessage").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
									 $(".notificationTo_ValidationMessage_popup").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
								$(".notificationTo_ValidationMessage").show();
								$(".notificationTo_ValidationMessage_popup").show();
					            $('#notificationTo_mainDiv').addClass('control-group error');
								$('#<portlet:namespace/>hidden_field').val('');  
							}
							else{
								$(".notificationTo_ValidationMessage").hide();
								$(".notificationTo_ValidationMessage_popup").hide();
								$('#notificationTo_mainDiv').removeClass('control-group error');
							}
						}
	}
	function routingprocess_main(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />routingprocess_create").val();
		if(val=='' && type==1){
			$(".routingProcess_ValidationMessage").html("Missing required value for the field \"Routing Process\"");
			$(".routingProcess_ValidationMessage_popup").html("Routing Process");
			$(".routingProcess_ValidationMessage").show();
			$(".routingProcess_ValidationMessage_popup").show();
                $('#routingProcess_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".routingProcess_ValidationMessage").hide();
			$(".routingProcess_ValidationMessage_popup").hide();
			
                $('#routingProcess_mainDiv').removeClass('control-group error');
		}
	}
	function routingprocessRolesValid(){
	                    var val=$("#<portlet:namespace />routingprocess_create").val();
						if(val!=''){
							var rolesArray = ['AR LOA','SP DM','CMP','HR DM','Ops Leader','new DVM','current DVM','new DM','current DM'];
						//	var noApprovalRoles =[''];//'staffing','current dmp','new dmp','cac'
							var rolesArrayLowerCase = [];
							var invalidApprovalRoles="";
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
								/*  else{
									if($.inArray( value.toLowerCase(), noApprovalRoles)!=-1){
										if(invalidApprovalRoles=="")
											invalidApprovalRoles=value;
										else
											invalidApprovalRoles=invalidApprovalRoles+", "+value;
									} 
								 } */
								 
								});
							 if(invalidRoles!=""){
								// if(invalidRoles!=""){
								    $(".routingProcess_ValidationMessage").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
									 $(".routingProcess_ValidationMessage_popup").html("Please check the role entered for" +"\""+invalidRoles+"\" "+"It seems like it doesn't exist in our list");
									
								// }
								/* else{
								    $(".routingProcess_ValidationMessage").html("please check once below roles has no Approvel process<br>\""+invalidApprovalRoles+"\"");
									$(".routingProcess_ValidationMessage_popup").html("please check once below roles has no Approvel process<br>\""+invalidApprovalRoles+"\"");
								 }*/
								$(".routingProcess_ValidationMessage").show();
								$(".routingProcess_ValidationMessage_popup").show();
					            $('#routingProcess_mainDiv').addClass('control-group error');
								$('#<portlet:namespace/>hidden_field').val('');  
							}
							else{
								$(".routingProcess_ValidationMessage").hide();
								$(".routingProcess_ValidationMessage_popup").hide();
								$('#routingProcess_mainDiv').removeClass('control-group error');
							}
						}
	}
	jQuery(document).ready(function(){ 
		jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
		 $(".routingProcess_leadership").hide();
		 $(".routingProcess_currentjob").hide();
		 $(".routingProcess_newjob").hide();
		  $(".routingProcess_New_Leadership").hide();
		 
		 
	});
	
function validateForm(value) {
	
	 $('#<portlet:namespace/>hidden_field').val('1');
            
              if(value == "submit"){
                 $("#<portlet:namespace/>validation_type").val(1);
             
				 change_desvalidate();
				 notificationtorouting();
				 notificationRolesValid();
				 routingprocess_main();
				 routingprocessRolesValid();
				 //current_jobcodevalidate();
				  //newjob_desvalidate();
				  actionBudgetvalidate();
				  samejobcodevalidate();
				  sameleadershipvalidate();
				  issamedeptvalidate();
				  issamemngrvalidate();
                
				  //currentAndLeadershipValidation();
				  
				  
				  
			var hiddenval=$('#<portlet:namespace/>hidden_field').val();
			if (hiddenval!='') {
			$('#showValidations').modal('hide');
			$("button[type=button]").attr('disabled',true); 
			$("#<portlet:namespace/>actiontype").val(value);
			$("#<portlet:namespace/>createRoutingAndApprover").submit();
	       }		
	  else{
	    $('#showValidations').modal({ backdrop: 'static',
								keyboard: true, 
								show: true});
	  	}}
              
              else{
				  $("#<portlet:namespace/>actiontype").val(value);
			        $("#<portlet:namespace/>createRoutingAndApprover").submit();
			  	}
}
	/*function currentAndLeadershipValidation(){
		
            //['None','Team Manager','Lead Team Manager','Department Manager','Division Manager','Pla Department Manager','Division Manager','Plant Manager']
			var current_jobcode=$.trim($("#<portlet:namespace />current_jobcode").val());
			var newJobcode=$.trim($("#<portlet:namespace />newJobcode").val());
			var samejobcode=$("#<portlet:namespace />samejobcode");
			var sameleadership=$("#<portlet:namespace />sameleadership");
			if(current_jobcode!="" && newJobcode!=""){
				if(current_jobcode==newJobcode){
					if(samejobcode=="Must Change"){
						$(".samejobcode_ValidationMessage").show();
			            $('#samejobcode_mainDiv').addClass('control-group error');
						$('#<portlet:namespace/>hidden_field').val(''); 
					}
                    if(sameleadership=="Must Change"){
						
					}
				}
				else if(current_jobcode!=newJobcode){
                    if(samejobcode=="Must Match"){
						
					}
                    if(sameleadership=="Must Match"){
						
					}
				}
			}
	}*/
</aui:script>

