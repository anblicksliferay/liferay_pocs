<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_NA_Support"%>

<%@ include file="/html/init.jsp" %>
<%

String[] values = null;
WFMS_NA_Support wfms_NA_Support=null;
if(Validator.isNotNull((String)request.getAttribute("Approverid"))){
String  approverId = (String)request.getAttribute("Approverid");
wfms_NA_Support=WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Support(approverId);
}

List<String> associateNumList = new ArrayList<String>();
List<String> associate_title = new ArrayList<String>();
List<WFMS_NA_Support> wfms_na_support = WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_Supports(0, WFMS_NA_SupportLocalServiceUtil.getWFMS_NA_SupportsCount());
for(WFMS_NA_Support na_support : wfms_na_support){
	
	associateNumList.add(na_support.getASSOCIATE_NUMBER());
	associate_title.add(na_support.getASSOCIATE_TITLE());
	
}
Set<String> hs = new HashSet<String>();

hs.addAll(associateNumList);
associateNumList.clear();
associateNumList.addAll(hs);

hs.addAll(associate_title);
associate_title.clear();
associate_title.addAll(hs);
%>

<portlet:actionURL name="deleteNASupport" var="deleteNASupportURL">
		<portlet:param name="ASSOCIATE_NUMBER" value="<%=wfms_NA_Support.getASSOCIATE_NUMBER() %>" />
</portlet:actionURL>

<aui:form method="post" action="<%=deleteNASupportURL.toString()%>" name="deleteNASupport" id="deleteNASupport">
	
	<aui:input id="ASSOCIATE_NUMBER" type="hidden" name="ASSOCIATE_NUMBER" value="<%=wfms_NA_Support.getASSOCIATE_NUMBER() %>" />
</aui:form>

<%-- <portlet:actionURL name="deleteNASupport" var="deleteNASupportURL"></portlet:actionURL> --%>
<portlet:actionURL name="updatenaSupport" var="updatenaSupportURL"></portlet:actionURL>

<aui:form action="<%=updatenaSupportURL.toString()%>" method="post" id="updatenaSupport" name="updatenaSupport">
<aui:input name="actiontype" type="hidden"></aui:input>
	
	<div id="addConfigurationForm">
	
	<div class="portlet-layout row">
		<div class="col-sm-12">
			<h2 class="titleArea">NA Support</h2>
		</div>
		
	</div>
	
	<div class="portlet-layout row">
			<div class="col-sm-12 own-wrapper">
				<div class="wfm-system">
					<div class="portlet-layout">
						<div class="portlet-column portlet-column-first">
                            <div class="small center">
                                  <div class="col-sm-4">
                                        <%-- <button type="button" class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/configure')">Exit View</button> --%>
                                        <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('renderView');" value="Exit View"></aui:button> 
                                  </div>
                                  <div class="col-sm-4">
                                        <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('submit');" value="Submit"></aui:button>
                                  </div>
                                  <div class="col-sm-4">
										<button type="button" class="btn btn-primary" type="button" 
										id="cancel" data-toggle="modal" data-backdrop="static" data-backdrop="static" data-target="#na_support_delete">Delete </button>
								  </div>
                                 
                   		  		<%--   <div class="col-sm-3">
                  						<aui:button class="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('create');" value="Create NA Support"></aui:button>
                   		  		  </div> --%>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	<div class="portlet-layout row">
			<div class="portlet-column portlet-column-first col-sm-8 box-content">
			
				<div class="col-sm-12">
			<div class="wfm-system" style="margin-top: 20px;">
			
				<aui:input name="ASSOCIATE_NUMBER" type="hidden" value="<%=wfms_NA_Support.getASSOCIATE_NUMBER() %>"></aui:input>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Number</div>

						<div id="associate_number_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							 <aui:input type="text" disabled="true" name="ASSOCIATE_NUMBER"  label="" id="associate_number"  onblur="associateNoOnBlur()" value="<%=wfms_NA_Support.getASSOCIATE_NUMBER() %>"></aui:input>   
							<div id="ass_errormessge" style="color: red;"></div>
					    </div>
						<div class="associate_number_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
							 Missing required value for the field "Associate Number"
						</div>
				</div>
			
			<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Date of Hire</div>

						<div id="associate_date_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							
							<aui:input name="ASSOCIATE_DATE_OF_HIRE" label="" id="associate_date" value="<%=wfms_NA_Support.getASSOCIATE_DATE_OF_HIRE() %>"
												maxlength="70" title="Click Here" onkeyup="associate_date_validate();"
												placeholder="MM/DD/YYYY">
							</aui:input>
					    </div>
						<div class="associate_date_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Associate Date of Hire"
						</div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Name</div>

						<div id="associate_name_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<aui:input type="text" name="ASSOCIATE_NAME"  label="" onkeyup="associate_name_validate();" value="<%=wfms_NA_Support.getASSOCIATE_NAME()%>"  id="associate_name" ></aui:input>
					    </div>
						<div class="associate_name_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Associate Name"
						</div>
				</div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Department Number</div>

						<div id="dept_number_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<%-- <aui:input type="text" name="DEPT_NUMBER"  label="" value="<%=wfms_NA_Support.getDEPT_NUMBER() %>" ></aui:input>  --%> 
							<aui:select  name="DEPT_NUMBER" id="divdeptRest" cssClass="field-select chosen" placeholder="" label=""
                                        onchange="updateValuesForSelectedDepartmentManage();" >
                                <aui:option value="">Select Department Number</aui:option>
                        		 <% 
                        		 Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
									 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){
										 if(Validator.isNotNull(entry.getValue())){	 
									// String keyvalue = entry.getKey() +"-" +entry.getValue(); %>
						              <aui:option selected="<%=wfms_NA_Support.getDEPT_NUMBER().equals(entry.getKey()) %>" value="<%=entry.getKey()%>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
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

						<div id="reasonchange_mainDiv" class="portlet-column portlet-column-last col-sm-8">
						<div id="DEPT_NAME"><%=wfms_NA_Support.getDEPT_NAME()%></div>
                                
						<aui:input type="hidden" name="DEPT_NAME"  label="" value="<%=wfms_NA_Support.getDEPT_NAME() %>" ></aui:input>
					    </div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Title</div>

						<div id="associate_title_mainDiv" class="portlet-column portlet-column-last col-sm-8">
						
							<aui:input type="text" name="ASSOCIATE_TITLE"  label="" onkeyup="associate_title_validate();" id="associate_title" value="<%=wfms_NA_Support.getASSOCIATE_TITLE() %>"></aui:input>   
					    </div>
						<div class="associate_title_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Associate Title"
						</div>
				</div>
	
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Shift Code</div>

						<div id="shift_code_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<%-- <aui:input type="text" name="SHIFT_CODE"  label="" onkeyup="shift_code_validate();" id="shift_code" value="<%=wfms_NA_Support.getSHIFT_CODE() %>" ></aui:input> --%>
							<aui:select name="SHIFT_CODE" id="shift_code" cssClass="field-select chosen" onchange="shift_code_validate();" placeholder="" label="">
								<aui:option value="">Select Shift Code</aui:option>
								
		                           <% 
								Map<String,String> shiftMap = new HashMap<String,String>();
		                           shiftMap=ConfigUtility.getInputValuesForMap("shift-assignment");
		                           Map<String,String> shiftMaps = new TreeMap<String,String>(shiftMap);
		                           for(Map.Entry<String, String> entry : shiftMaps.entrySet()){
		                           %>
		                           <aui:option selected="<%=wfms_NA_Support.getSHIFT_CODE().equals(entry.getKey()) %>" value="<%=entry.getKey() %>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
		                              <% } %>
		                              
                            </aui:select> 
					    </div>
						<div class="shift_code_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Shift Code"
						</div>
				</div>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Team Number</div>

						<div id="team_number_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<%-- <aui:input type="text" name="TEAM_NUMBER"  label="" onkeyup="team_number_validate();" id="team_number_na" value="<%=wfms_NA_Support.getTEAM_NUMBER() %>"></aui:input> --%>
							<aui:select name="TEAM_NUMBER" id="team_number_na" cssClass="field-select chosen" onchange="team_number_validate();" placeholder="" label="" >
								<aui:option value="">Select Team Number</aui:option>
					            <%
									values = ConfigUtility.getInputValuesFromConfig("Team-Number");
									for(String value:values){	
								%>
									<aui:option selected="<%=wfms_NA_Support.getTEAM_NUMBER().equals(value) %>" value="<%=value %>"><%=value %></aui:option>
								<% } %>
		                          
                            </aui:select> 
					    </div>
						<div class="team_number_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Team Number"
						</div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Effective Date</div>

						<div id="effdt_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							
							<aui:input name="EFFDT" label="" id="effdt" value="<%=wfms_NA_Support.getEFFDT() %>"
												maxlength="70" title="Click Here" onkeyup="effdt_validate();"
												placeholder="MM/DD/YYYY">
							</aui:input>   
					    </div>
						<div class="effdt_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Effective Date"
						</div>
				</div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Termination DT</div>

						<div id="termination_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							
							<aui:input name="TERMINATION_DT" label="" id="termination" value="<%=wfms_NA_Support.getTERMINATION_DT() %>"
												maxlength="70" title="Click Here" onkeyup="termination_validate();"
												placeholder="MM/DD/YYYY">
							</aui:input>  
					    </div>
						<div class="termination_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Termination DT"
						</div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Manager Associate Number</div>

						<div id="mgr_associate_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<aui:input type="text" name="MANAGER_ASSOCIATE_NUMBER"  label="" onkeyup="mgr_associate_validate();" id="mgr_associate" value="<%=wfms_NA_Support.getMANAGER_ASSOCIATE_NUMBER() %>"></aui:input>
					    </div>
						<div class="mgr_associate_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Manager Associate Number"
						</div>
				</div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Assign Type</div>

						<div id="assign_type_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<%-- <aui:input type="text" name="ASSGN_TYPE"  label="" onkeyup="assign_type_assvalidate();" id="assign_type" value="<%=wfms_NA_Support.getASSGN_TYPE() %>"></aui:input> --%>
							<aui:select name="ASSGN_TYPE" id="assign_type" cssClass="field-select chosen" onchange="assign_type_assvalidate();" placeholder="" label=""  >
							<aui:option value="">Select Assign Type</aui:option>
								 		
					             <%
									values = ConfigUtility.getInputValuesFromConfig("assign_type_nasupport");
									for(String value:values){	
								%>
									<aui:option selected="<%=wfms_NA_Support.getASSGN_TYPE().equals(value) %>" value="<%=value %>"><%=value %></aui:option>
								<% } %>
                            </aui:select>     
					    </div>
						<div class="assign_type_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Assign Type"
						</div>
				</div>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Leadership Assignment</div>

						<div id="leader_assignment_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<%-- <aui:input type="text" name="LEADERSHIP_ASSIGNMENT"  label="" onkeyup="leader_assignment_assvalidate();" id="leader_assignment" value="<%=wfms_NA_Support.getLEADERSHIP_ASSIGNMENT() %>"> </aui:input> --%>
							<aui:select name="LEADERSHIP_ASSIGNMENT" id="leader_assignment" cssClass="field-select chosen" onchange="leader_assignment_assvalidate();" placeholder="" label="" >
							<aui:option value="">Select Assign Type</aui:option>
					                  
					              <%
									values = ConfigUtility.getInputValuesFromConfig("position-leadershipassignmenmt");
									for(String value:values){	
								%>
									<aui:option selected="<%=wfms_NA_Support.getLEADERSHIP_ASSIGNMENT().equals(value) %>" value="<%=value %>"><%=value %></aui:option>
								<% } %>
                            </aui:select>    
					    </div>
						<div class="leader_assignment_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Leadership Assignment"
						</div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Email</div>

						<div id="email_mainDiv" class="portlet-column portlet-column-last col-sm-8">
							<aui:input type="text" name="EMAIL"  label="" onkeyup="email_desvalidate();" id="email_des" value="<%=wfms_NA_Support.getEMAIL() %>"></aui:input>
					    </div>
						<div class="email_no_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 197px;padding-bottom: 7px;">
                                 Missing required value for the field "Email"
						</div>
				</div>
				
				<aui:input name="actiontype" type="hidden"></aui:input> 
				<div style="display: none;">
					  <aui:input type="textarea" name="hidden_field" label="" required="true" > </aui:input>
                      <aui:input type="textarea" name="validation_type" label="" value="0" > </aui:input>

				</div>
				
				</div>
					
				<div class="scroll_back_to_top">
				<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
				
				</div>
				</div>
			</div>
			<div class="portlet-column portlet-column-first col-sm-4">
				<div class="box-details">
				
					<h3>Na Support ID : <%=wfms_NA_Support.getASSOCIATE_NUMBER() %></h3>
					<div>
				
					</div>
					<ul class="box-detail-list">
						<li>Created By:</li>
						<li><%=wfms_NA_Support.getCreatedBy() %></li>
						<li>Date Created:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_NA_Support.getCreateDate())%></li>
					    <li>Modified By:</li>
						<li><%=wfms_NA_Support.getModifiedBy()%></li>
						<li>Modified Date:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_NA_Support.getModifiedDate())%></li>
					</ul>
					
				</div>
			</div>
	</div>
</div>
		
</aui:form>

<div class="modal fade" id="na_support_popup" style="display:none; margin-top:-96px;display:none;">
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
						    <li class="associate_number_ValidationMessage form-validator-stack help-inline" style="display: none;">Associate Number</li>
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

<!-- Start PopUp for NA Support -->
  
  <div class="modal fade" id="na_support_delete" style="display:none;">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="yui3-widget-hd modal-header">
			      <div class="toolbar-content yui3-widget component toolbar">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<h3>Do you want to Delete the NA Support Associate No?</h3>
				</div>
				<div class="yui3-widget-bd modal-body" style="max-height: 150px; height: 60px;">
				<div class="portlet-layout row">
				    <aui:button cssClass="btn btn-primary col-sm-5" name="deleteNASupport"  type="button"
							onClick='<%=deleteNASupportURL.toString()%>' value="Yes"></aui:button>

						<div class="col-sm-2"></div>
						     <button class="btn btn-primary col-sm-5" type="button" data-dismiss="modal">No</button>
				 </div>
				 </div>
			</div>
		</div>
	</div>
  
<!-- End  -->

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

    function associate_no_desvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />associate_no").val();
		if(val=='' && type==1){
			$("#associate_no_ValidationMessage").show();
                $('#associate_no_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$("#associate_no_ValidationMessage").hide();
                $('#associate_no_mainDiv').removeClass('control-group error');
		}
	}

	function associate_date_validate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />associate_date").val();
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
                                $(".email_no_ValidationMessage").text("Not a valid e-mail address");
			        $(".email_no_ValidationMessage").show();
			        $(".email_no_Validation_Message").text("Not a valid e-mail address");
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

	function validateForm(value) {
		 $('#<portlet:namespace/>hidden_field').val('1');
		           
				 if(value == "submit"){
					$("#<portlet:namespace/>validation_type").val(1);
				 
				 associate_no_desvalidate();
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
				 updateValuesForSelectedDepartmentManage();
				 associateNoOnBlur();
				   
				var auiForm = Liferay.Form._INSTANCES.<portlet:namespace/>updatenaSupport;
				 var auiValidator = auiForm.formValidator;
				 auiValidator.validate();
				  if (!auiValidator.hasErrors()) {
				$('#na_support_popup').modal('hide');
				$("button[type=button]").attr('disabled',true); 
				  $("#<portlet:namespace/>actiontype").val(value);
				  $("#<portlet:namespace/>updatenaSupport").submit();
			  }		
			  else{
			     $('#na_support_popup').modal({ backdrop: 'static',
									keyboard: true, 
									show: true});
			  	}}
				 else  if(value == "create"){
						$("#<portlet:namespace/>actiontype").val(value);
		               $("#<portlet:namespace/>updatenaSupport").submit();
					}
				 else{
						$("#<portlet:namespace/>actiontype").val(value);
			               $("#<portlet:namespace/>updatenaSupport").submit(); 
				 }
		}

function loadDivisonDepName(Deptid){
    Deptidvalidate();
//var Deptid=$("#<portlet:namespace/>Deptid").val();
$('#Division').html("");
$('#DEPT_NAME').html("");
    if(Deptid!=''){
$('#img').show();
$.ajax({
url : '<%=resourceURL.toString()%>',    
data: {
	<portlet:namespace />Deptid: Deptid,
		<portlet:namespace />cmd: 'LoadDivisionNames' 
	},
type: "POST",
dataType: "json",
success: function(data) {
	$('#Division').html(data.Division);
	$('#DEPT_NAME').html(data.DEPT_NAME);
	$('#img').hide();
	if(data.DEPT_NAME=="" || data.DEPT_NAME.length <3){
		 document.getElementById('departmentname').innerHTML='Department Name less than three characters is invalid - Please contact System Admin';
		 $('#<portlet:namespace/>hidden_field').val('');
		 
	}
	else{
		document.getElementById('departmentname').innerHTML='';
		$('#img').hide();
	}
	
},
error: function (response) {
		console.log("Error seen for loadDivisonDepName ajax result");
}
});
}
}

jQuery(document).ready(function(){ 
	jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
});

function updateValuesForSelectedDepartmentManage(){
	
	var type=$("#<portlet:namespace/>validation_type").val();
	var Deptid=$("#<portlet:namespace/>divdeptRest").val();
	var pidvalue=$("#<portlet:namespace/>pId").val();
	
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
	
	if(Deptid == ""){
		
		  $('#deptNameFromM').html("");
		 
		
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
				
				$('#DEPT_NAME').html(data.DEPT_NAME);
				
			},
			error : function(response) {
	        	console.log("Error seen for for loadDivisonDepName");
			}
		});
	}
	}
	
	function associateNoOnBlur() {
	
	var type=$("#<portlet:namespace/>validation_type").val();
	var assocateNumber=$("#<portlet:namespace/>associate_number").val();
	if(assocateNumber=='' && type==1){
	$(".associate_number_ValidationMessage").show();
		$('#associate_number_mainDiv').addClass('control-group error');
	$('#<portlet:namespace/>hidden_field').val('');   
	}
	else{
	$(".associate_number_ValidationMessage").hide();
		$('#associate_number_mainDiv').removeClass('control-group error');
	}
	$.ajax({
		url : '<%=resourceURL.toString()%>',
		data : {
			<portlet:namespace />assId : assocateNumber,
			<portlet:namespace />cmd : 'validateAssoicateNo'
		},

		type : "POST",
		dataType : "json",
		success : function(data) {
			
		     console.log(data);
		     console.log(data.success);
		     
		      if(data.success=="true"){
		    	 //$('#ass_errormessge').html("Exist in Associate info OR NA support Info");
		     }
		     else{
		    	 //$('#ass_errormessge').html("Not Exist");
		     } 
		},
		error : function(response) {
	   	console.log("Error seen for for validate Associate Number");
		}
	});
}
	
	YUI({ lang: 'en' }).use(
			   'aui-datepicker',
			   function(Y) {
				   var today=new Date();
			     var datepicker = new Y.DatePicker(
			       {
			          trigger: '#<portlet:namespace />associate_date',
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
				        	  // minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * 24 * 60))

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