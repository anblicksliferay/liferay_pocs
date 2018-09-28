<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_NA_Support"%>
<%@ include file="/html/init.jsp" %>
<portlet:actionURL name="redirctcreatenaSupport" var="redirectcreateroutingURL"> </portlet:actionURL>
<portlet:actionURL name="createNASupport" var="createNASupportURL"></portlet:actionURL>

<%
String[] values = null;

List<String> associateNumbnerList =  new ArrayList<String>();
List<String> associate_title_List =  new ArrayList<String>();
List<WFMS_NA_Support> wfms_na_suuport = WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Supports(0, WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_SupportsCount());
for( WFMS_NA_Support na_support : wfms_na_suuport ){
	associateNumbnerList.add(na_support.getASSOCIATE_NUMBER());
	associate_title_List.add(na_support.getASSOCIATE_TITLE());

}

Set<String> hs = new HashSet<String>();

hs.addAll(associateNumbnerList);
associateNumbnerList.clear();
associateNumbnerList.addAll(hs);

hs.addAll(associate_title_List);
associate_title_List.clear();
associate_title_List.addAll(hs);
%>
<aui:form action="<%=createNASupportURL.toString()%>" method="post" id="createNASupport" name="createNASupport">
<aui:input name="actiontype" type="hidden"></aui:input>
	<div class="portlet-layout row">
		<div ="col-sm-12">
			<h2 class="titleArea">NA Support</h2>
		</div>
	</div>
	
  	<div class="col-sm-6">
  	</div>
		<div class="portlet-layout row">
			<div class="col-sm-12 own-wrapper">
				<div class="wfm-system">
					<div class="portlet-layout">
						<div class="portlet-column portlet-column-first">
                            <div class="small center">
                                <div class="col-sm-6"> <aui:button class="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('renderView');" value="Exit View"></aui:button>
 
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
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Number</div>

						<div id="associate_number_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						
							 <aui:input type="text" name="ASSOCIATE_NUMBER"  label="" id="associate_number"  onblur="associateNoOnBlur()" ></aui:input>  
							<div id="ass_errormessge" style="color: red;"></div>
					    </div>
						<div class="associate_number_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
									 Missing required value for the field "Associate Number"
						</div>
				</div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Date of Hire</div>

						<div id="associate_date_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<%-- <aui:input type="text" name="ASSOCIATE_DATE_OF_HIRE" label="" onkeyup="associate_date_validate();" id="associate_date"  ></aui:input> --%>
								
							<aui:input name="ASSOCIATE_DATE_OF_HIRE" label="" id="startDate"
												maxlength="70" title="Click Here" onkeyup="associate_date_validate();"
												placeholder="MM/DD/YYYY">
							</aui:input>
					    </div>
						<div class="associate_date_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Associate Date of Hire"
						</div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Name</div>

						<div id="associate_name_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:input type="text" name="ASSOCIATE_NAME"  label="" onkeyup="associate_name_validate();" id="associate_name" ></aui:input>
					    </div>
						<div class="associate_name_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Associate Name"
						</div>
				</div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Department Number</div>

						<div id="dept_number_mainDiv" class="portlet-column portlet-column-last col-sm-3">
					<aui:select name="DEPT_NUMBER" id="divdeptRest" cssClass="field-select chosen" placeholder="" label="" onChange="updateValuesForSelectedDepartment()">
						    <aui:option value=''>Select Department Number</aui:option>
						<% 
						Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
							 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){
							 if(!entry.getValue().equals("")){
							 %>
			                  <aui:option value="<%=entry.getKey() %>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
								<%}} %>
					</aui:select>
					<div class="dept_number_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;">
                                 Missing required value for the field "Department Number"
					</div>
						 
					    </div>
				</div>
				
				<div style="position: relative; top: -34px;"> <img  src="<%= request.getContextPath()%>/images/ajax-loader.jpg"  id="img" alt="Please wait a moment.."  style="display:none" /></div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Department Name</div>

						<div id="reasonchange_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						<div id="DEPT_NAME"  class="portlet-column portlet-column-last col-sm-4 sectionLabel"> 
						</div>
							<%-- <aui:input type="text" name="DEPT_NAME"  label=""  ></aui:input> --%>
					    </div>
				</div>
				
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Title</div>

						<div id="associate_title_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:input type="text" name="ASSOCIATE_TITLE"  label="" onkeyup="associate_title_validate();" id="associate_title"></aui:input>
							
					    </div>
						<div class="associate_title_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Associate Title"
						</div>
				</div>
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Shift Code</div>

						<div id="shift_code_mainDiv" class="portlet-column portlet-column-last col-sm-3">
							<%-- <aui:input type="text" name="SHIFT_CODE"  label="" onkeyup="shift_code_validate();" id="shift_code" ></aui:input> --%>
							<aui:select name="SHIFT_CODE" id="shift_code" cssClass="field-select chosen" onchange="shift_code_validate();" placeholder="" label="" >
								<aui:option value="">Select Shift Code</aui:option>
								<% 
								Map<String,String> shiftMap = new HashMap<String,String>();
		                           shiftMap=ConfigUtility.getInputValuesForMap("shift-assignment");
		                           Map<String,String> shiftMaps = new TreeMap<String,String>(shiftMap);
		                           for(Map.Entry<String, String> entry : shiftMaps.entrySet()){
		                           %>
		                           <aui:option value="<%=entry.getKey() %>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
		                              <% } %>
		                              
                            </aui:select> 
					    </div>
						<div class="shift_code_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Shift Code"
						</div>
				</div>
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Team Number</div>

						<div id="team_number_mainDiv" class="portlet-column portlet-column-last col-sm-3">
							<%-- <aui:input type="text" name="TEAM_NUMBER"  label="" onkeyup="team_number_validate();" id="team_number_na" ></aui:input> --%>
							<aui:select name="TEAM_NUMBER" id="team_number_na" cssClass="field-select chosen" onchange="team_number_validate();" placeholder="" label="" >
								<aui:option value="">Select Team Number</aui:option>
								 		<%
					                   values = ConfigUtility.getInputValuesFromConfig("Team-Number");
					                   Arrays.sort(values);
					                  for(String value:values){ 
					                  %>
					                   <aui:option value="<%=value %>"><%=value %></aui:option>
					                  <% } %>
                            </aui:select> 
					    </div>
						<div class="team_number_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Team Number"
						</div>
				</div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Effective Date</div>

						<div id="effdt_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							
							<aui:input name="EFFDT" label="" id="effdt"
								maxlength="70" title="Click Here" onkeyup="effdt_validate();" placeholder="MM/DD/YYYY">
							</aui:input> 
					    </div>
						<div class="effdt_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Effective Date"
						</div>
				</div>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Termination DT</div>

						<div id="termination_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							
							<aui:input name="TERMINATION_DT" label="" id="termination"
								maxlength="70" title="Click Here" onkeyup="termination_validate();" placeholder="MM/DD/YYYY">
							</aui:input>
					    </div>
						<div class="termination_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Termination DT"
						</div>
				</div>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Manager Associate Number</div>

						<div id="mgr_associate_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:input type="text" name="MANAGER_ASSOCIATE_NUMBER"  label="" onkeyup="mgr_associate_validate();" id="mgr_associate" onblur="ManagerassociateNoOnBlur()" ></aui:input>
					    </div>
						<div class="mgr_associate_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Manager Associate Number"
						</div>
				</div>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Assign Type</div>

						<div id="assign_type_mainDiv" class="portlet-column portlet-column-last col-sm-3">
							<%-- <aui:input type="text" name="ASSGN_TYPE"  label="" onkeyup="assign_type_assvalidate();" id="assign_type" ></aui:input> --%>
							<aui:select name="ASSGN_TYPE" id="assign_type" cssClass="field-select chosen" onchange="assign_type_assvalidate();" placeholder="" label="" >
								<aui:option value="">Select Assign Type</aui:option>
								 		<%
					                   values = ConfigUtility.getInputValuesFromConfig("assign_type_nasupport");
					                   Arrays.sort(values);
					                  for(String value:values){ 
					                  %>
					                   <aui:option value="<%=value %>"><%=value %></aui:option>
					                  <% } %>
                            </aui:select>   
					    </div>
						<div class="assign_type_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Assign Type"
						</div>
				</div>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Leadership Assignment</div>

						<div id="leader_assignment_mainDiv" class="portlet-column portlet-column-last col-sm-3">
							<%-- <aui:input type="text" name="LEADERSHIP_ASSIGNMENT"  label="" onkeyup="leader_assignment_assvalidate();" id="leader_assignment" > </aui:input> --%>
							<aui:select name="LEADERSHIP_ASSIGNMENT" id="leader_assignment" cssClass="field-select chosen" onchange="leader_assignment_assvalidate();" placeholder="" label="" >
								<aui:option value="">Select Leadership Assignment</aui:option>
								 		<%
					                   values = ConfigUtility.getInputValuesFromConfig("position-leadershipassignmenmt");
					                   Arrays.sort(values);
					                  for(String value:values){ 
					                  %>
					                   <aui:option value="<%=value %>"><%=value %></aui:option>
					                  <% } %>
                            </aui:select>   
					    </div>
						<div class="leader_assignment_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Leadership Assignment"
						</div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Email</div>

						<div id="email_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:input type="text" name="EMAIL"  label="" onkeyup="email_desvalidate();" id="email_des"></aui:input>
					    </div>
						<div class="email_no_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Email"
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

<div class="modal fade" id="showValidations" style="display:none; margin-top: -96px;" > 
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
						    <li class="associate_number_Validation_Message form-validator-stack help-inline" style="display: none;">Associate Number</li>
	                   		<li class="associate_date_ValidationMessage form-validator-stack help-inline" style="display: none;">Associate Date of Hire</li>
	                        <li class="associate_name_ValidationMessage form-validator-stack help-inline" style="display: none;">Associate Name</li>
							<li class="dept_number_ValidationMessage form-validator-stack help-inline" style="display: none;">Department Number</li>
	                   		<li class="associate_title_ValidationMessage form-validator-stack help-inline" style="display: none;">Associate Title</li>
	                        <li class="shift_code_ValidationMessage form-validator-stack help-inline" style="display: none;">Shift Code</li>
							<li class="team_number_ValidationMessage form-validator-stack help-inline" style="display: none;">Team Number</li>
							
							<li class="effdt_ValidationMessage form-validator-stack help-inline" style="display: none;">Effective Date</li>
	                   		<li class="termination_ValidationMessage form-validator-stack help-inline" style="display: none;">Termination DT</li>
	                        <li class="mgr_associate_ValidationMessage form-validator-stack help-inline" style="display: none;">Manager Associate Number</li>
							<li class="assign_type_ValidationMessage form-validator-stack help-inline" style="display: none;">Assign Type</li>
	                   		<li class="leader_assignment_ValidationMessage form-validator-stack help-inline" style="display: none;">Leadership Assignment</li>
	                        <li class="email_no_Validation_Message form-validator-stack help-inline" style="display: none;">Email</li>
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

	function associate_date_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />startDate").val();
		if(val=='' && type==1){
			$(".associate_date_ValidationMessage").show();
                $('#associate_date_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".associate_date_ValidationMessage").hide();
                $('#associate_date_mainDiv').removeClass('control-group error');
		}
	}
	
	function dept_no_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />dept_no").val();
		if(val=='' && type==1){
			$("#dept_no_ValidationMessage").show();
                $('#dept_no_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$("#dept_no_ValidationMessage").hide();
                $('#dept_no_mainDiv').removeClass('control-group error');
		}
	}
	
	function associate_title_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />associate_title").val();
		if(val=='' && type==1){
			$(".associate_title_ValidationMessage").show();
                $('#associate_title_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".associate_title_ValidationMessage").hide();
                $('#associate_title_mainDiv').removeClass('control-group error');
		}
	}		

	function shift_code_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />shift_code").val();
		if(val=='' && type==1){
			$(".shift_code_ValidationMessage").show();
                $('#shift_code_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".shift_code_ValidationMessage").hide();
                $('#shift_code_mainDiv').removeClass('control-group error');
		}
	}
	
	function team_number_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />team_number_na").val();
		if(val=='' && type==1){
			$(".team_number_ValidationMessage").show();
                $('#team_number_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".team_number_ValidationMessage").hide();
                $('#team_number_mainDiv').removeClass('control-group error');
		}
	}
	
	function associate_name_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />associate_name").val();
		if(val=='' && type==1){
			$(".associate_name_ValidationMessage").show();
                $('#associate_name_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".associate_name_ValidationMessage").hide();
                $('#associate_name_mainDiv').removeClass('control-group error');
		}
	}
	
	function effdt_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />effdt").val();
		if(val=='' && type==1){
			$(".effdt_ValidationMessage").show();
                $('#effdt_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".effdt_ValidationMessage").hide();
                $('#effdt_mainDiv').removeClass('control-group error');
		}
	}
	function termination_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />termination").val();
		if(val=='' && type==1){
			$(".termination_ValidationMessage").show();
                $('#termination_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".termination_ValidationMessage").hide();
                $('#termination_mainDiv').removeClass('control-group error');
		}
	}
	
	function mgr_associate_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />mgr_associate").val();
		if(val=='' && type==1){
			$(".mgr_associate_ValidationMessage").show();
                $('#mgr_associate_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".mgr_associate_ValidationMessage").hide();
                $('#mgr_associate_mainDiv').removeClass('control-group error');
		}
	}
	function assign_type_assvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />assign_type").val();
		if(val=='' && type==1){
			$(".assign_type_ValidationMessage").show();
                $('#assign_type_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".assign_type_ValidationMessage").hide();
                $('#assign_type_mainDiv').removeClass('control-group error');
		}
	}	

	function leader_assignment_assvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />leader_assignment").val();
		if(val=='' && type==1){
			$(".leader_assignment_ValidationMessage").show();
                $('#leader_assignment_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".leader_assignment_ValidationMessage").hide();
                $('#leader_assignment_mainDiv').removeClass('control-group error');
		}
	}
						
	function validateForm(value) {
	
	 $('#<portlet:namespace/>hidden_field').val('1');
            
              if(value == "submit"){
                 $("#<portlet:namespace/>validation_type").val(1);
              
				 //associate_no_desvalidate();
				 associate_date_validate();
				 associate_name_validate();
				 dept_no_validate();
				 associate_title_validate();
				 shift_code_validate();
				 team_number_validate();
				 effdt_validate();
				 termination_validate();
				 mgr_associate_validate();
				 assign_type_assvalidate();
				 leader_assignment_assvalidate();
				 email_desvalidate();
				 updateValuesForSelectedDepartment();
				 associateNoOnBlur();
				 
                
			var hiddenval=$('#<portlet:namespace/>hidden_field').val();
			if (hiddenval!='') {
			$('#showValidations').modal('hide');
			$("button[type=button]").attr('disabled',true); 
			$("#<portlet:namespace/>actiontype").val(value);
	        $("#<portlet:namespace/>createNASupport").submit();
			}		
		    else{
			 $('#showValidations').modal({ backdrop: 'static',
									keyboard: true, 
									show: true});
			}}
                else{
					$("#<portlet:namespace/>actiontype").val(value);
	               $("#<portlet:namespace/>createNASupport").submit();
				}
			
}

jQuery(document).ready(function(){ 
	jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
});
function email_desvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />email_des").val();
		
		if(val=='' && type==1){
			 $(".email_no_ValidationMessage").text("Missing required value for the field \"Email\"");
			$(".email_no_ValidationMessage").show();
			$(".email_no_Validation_Message").text("Email");
		    $(".email_no_Validation_Message").show();
            $('#email_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
		
                       var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                            if(!regex.test(val)){
                                $(".email_no_ValidationMessage").text("Enter valid e-mail address");
			        $(".email_no_ValidationMessage").show();
			        $(".email_no_Validation_Message").text("Enter valid e-mail address");
			        $(".email_no_Validation_Message").show();
		            $('#email_mainDiv').addClass('control-group error');
					$('#<portlet:namespace/>hidden_field').val('');
			    }else{
			        $(".email_no_ValidationMessage").hide();
			        $(".email_no_Validation_Message").hide();
                    $('#email_mainDiv').removeClass('control-group error');
			    }
		}
}
function updateValuesForSelectedDepartment(){
		var type=$("#<portlet:namespace/>validation_type").val();
		var Deptid=$("#<portlet:namespace/>divdeptRest").val();
		if(Deptid=='' && type==1){
					$(".dept_number_ValidationMessage").show();
					$('#dept_number_mainDiv').addClass('control-group error');
					$('#<portlet:namespace/>hidden_field').val('');   
			}
			else{
					$(".dept_number_ValidationMessage").hide();
					$('#dept_number_mainDiv').removeClass('control-group error');
			}
		
		$('#DEPT_NAME').html("");
		   if(Deptid!=''){
				$('#img').show();
				$.ajax({
					url : '<%=resourceURL.toString()%>',
					data : {
						<portlet:namespace />Deptid : Deptid,
						<portlet:namespace />cmd : 'LoadDivisionNames'
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
						$('#DEPT_NAME').html(data.DEPT_NAME);
						$('#img').hide();
					},
					error : function(response) {
						$('#img').hide();
					}
				});
       }
}
function ManagerassociateNoOnBlur() {
	var type=$("#<portlet:namespace/>validation_type").val();
	var MangassocateNumber=$("#<portlet:namespace/>mgr_associate").val();
	if(!MangassocateNumber==''){
	if(isNaN(MangassocateNumber)==true){
		  $(".mgr_associate_ValidationMessage").text("Enter Only Numerics");
	      $(".mgr_associate_ValidationMessage").text("Enter Only Numerics");
	      $(".mgr_associate_ValidationMessage").show();
	      $(".mgr_associate_ValidationMessage").show();
	      $('#associate_number_mainDiv').addClass('control-group error');
	      $('#<portlet:namespace/>hidden_field').val('');
	      }
	else{
		 $(".mgr_associate_ValidationMessage").hide();
	      $(".mgr_associate_ValidationMessage").hide();
	}
	}
}
function associateNoOnBlur() {
	
	var type=$("#<portlet:namespace/>validation_type").val();
	var assocateNumber=$("#<portlet:namespace/>associate_number").val();
	if(assocateNumber=='' && type==1){
              $(".associate_number_ValidationMessage").text("Missing required value for the field \"Associate Number\"");
              $(".associate_number_Validation_Message").text("Associate Number");
	      $(".associate_number_ValidationMessage").show();
              $(".associate_number_Validation_Message").show();
		$('#associate_number_mainDiv').addClass('control-group error');
	      $('#<portlet:namespace/>hidden_field').val('');   
	}
	else{
	
/* 	if(isNaN(assocateNumber)==true){
	  $(".associate_number_ValidationMessage").text("Enter Only Numerics");
      $(".associate_number_Validation_Message").text("Enter Only Numerics");
      $(".associate_number_ValidationMessage").show();
      $(".associate_number_Validation_Message").show();
      $('#associate_number_mainDiv').addClass('control-group error');
      $('#<portlet:namespace/>hidden_field').val('');}
	else if(isNaN(assocateNumber)==false){ */
                    $.ajax({
		     url : '<%=resourceURL.toString()%>',
		 data : {
			<portlet:namespace />assId : assocateNumber,
			<portlet:namespace />cmd : 'validateAssoicateNo'
		 },

		type : "POST",
		dataType : "json",
		success : function(data) {
		      if(data.success=="true"){
                             $(".associate_number_ValidationMessage").text("Associate Number already exists");
			      $(".associate_number_Validation_Message").text("Associate Number already exists");
			      $(".associate_number_ValidationMessage").show();
			      $(".associate_number_Validation_Message").show();
		          $('#associate_number_mainDiv').addClass('control-group error');
	                  $('#<portlet:namespace/>hidden_field').val('');
		     }
		     else{
                       $(".associate_number_ValidationMessage").hide();
                       $(".associate_number_Validation_Message").hide();
		       $('#associate_number_mainDiv').removeClass('control-group error');
		    	 
		     } 
		},
		error : function(response) {
	   	   console.log("Error seen for for validate Associate Number");
		}
	});

                  
	//}
	}
	
}

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
	        	     minimumDate: new Date(today.getTime() - (1000 * 60 * 60 * 24 * 365))
	        	   //minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * 24 * 60))

	        	},
	        	on: {
	                selectionChange: function(event) {
	                	$(".associate_date_ValidationMessage").hide();
						$('#associate_date_mainDiv').removeClass('control-group error');
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
	                     $(".associate_date_ValidationMessage").show();
						 $('#associate_date_mainDiv').addClass('control-group error');
	                   }
	                 }
	               },             
	             ]]
	           },
	           zIndex: 1
	         }
	       }
	     );
	   });
	   
YUI({ lang: 'en' }).use(
		   'aui-datepicker',
		   function(Y) {
			   var today=new Date();
		     var datepicker = new Y.DatePicker(
		       {
		          trigger: '#<portlet:namespace />effdt',
		         mask: '%m/%d/%Y',
		         calendar: {
		        	    minimumDate: new Date(today.getTime() - (1000 * 60 * 60 * 24 * 365))
		        	   //minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * 24 * 60))

		        	},
		        	on: {
		                selectionChange: function(event) {
		                	$(".effdt_ValidationMessage").hide();
							$('#effdt_mainDiv').removeClass('control-group error');
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
		                     $(".effdt_ValidationMessage").show();
								$('#effdt_mainDiv').addClass('control-group error');
		                   }
		                 }
		               },             
		             ]]
		           },
		           zIndex: 1
		         }
		       }
		     );
		   });
		   
YUI({ lang: 'en' }).use(
		   'aui-datepicker',
		   function(Y) {
			   var today=new Date();
		     var datepicker = new Y.DatePicker(
		       {
		          trigger: '#<portlet:namespace />termination',
		         mask: '%m/%d/%Y',
		         calendar: {
		        	    minimumDate: new Date(today.getTime() - (1000 * 60 * 60 * 24 * 365))
		        	   //minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * 24 * 60))

		        	},
		        	on: {
		                selectionChange: function(event) {
		                	$(".termination_ValidationMessage").hide();
							$('#termination_mainDiv').removeClass('control-group error');
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
		                     $(".termination_ValidationMessage").show();
								$('#termination_mainDiv').addClass('control-group error');
		                   }
		                 }
		               },             
		             ]]
		           },
		           zIndex: 1
		         }
		       }
		     );
		   });
</aui:script>