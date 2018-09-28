<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_names"%>
<%@ include file="/html/init.jsp" %>
<portlet:actionURL name="redirctcreateaction" var="redirectcreateroutingURL"> </portlet:actionURL>
<%
WFMS_action_and_reasoncode wfms_action_and_reasoncode=null;
String  approverId="";
if(Validator.isNotNull((String)request.getAttribute("Approverid"))){
   approverId = (String)request.getAttribute("Approverid");
wfms_action_and_reasoncode=WFMS_action_and_reasoncodeLocalServiceUtil.getWFMS_action_and_reasoncode(approverId);
}
%>

<portlet:actionURL name="deleteActionandReasoncode" var="deleteActionandReasoncodeURL">
		<portlet:param name="aarId" value="<%=wfms_action_and_reasoncode.getAarId()%>" />
</portlet:actionURL>

<aui:form method="post" action="<%=deleteActionandReasoncodeURL.toString()%>" name="deleteActionandReasoncode" id="deleteActionandReasoncode">
	
	<aui:input id="aarId" type="hidden" name="aarId" value="<%=wfms_action_and_reasoncode.getAarId()%>" />
</aui:form>

<portlet:actionURL name="updateActionandreason" var="updateactionURL"></portlet:actionURL>
<aui:form action="<%=updateactionURL.toString()%>" method="post" id="updateActionandreason" name="updateActionandreason">
<aui:input name="actiontype" type="hidden"></aui:input>
<div id="addConfigurationForm">
	
	<div class="portlet-layout row">
		<div class="col-sm-12">
			<h2 class="titleArea">Action and Reasoncode</h2>
		</div>
	</div>
	<div class="portlet-layout row">
			<div class="col-sm-12 own-wrapper">
				<div class="wfm-system">
					<div class="portlet-layout">
						<div class="portlet-column portlet-column-first">
                            <div class="small center">
                                  <div class="col-sm-4">
                                        <%-- <button type="button" class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/configure')">Exit View</button>  --%>
                                        <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('renderView');" value="Exit View"></aui:button>
                                  </div>
                                  <div class="col-sm-4">
                                        <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('submit');" value="Submit"></aui:button>
                                  </div>
                                  <div class="col-sm-4">
										<button type="button" class="btn btn-primary" type="button"
										id="cancel" data-toggle="modal" data-backdrop="static" data-backdrop="static" data-target="#action_support_delete">Delete </button>
								  </div>
                                  <%-- <div class="col-sm-3">
                   					<aui:button class="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('create');" value="Create Action and resaoncode"></aui:button>
                   	
                   				</div> --%>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	<div class="portlet-layout row">
			<div class="portlet-column portlet-column-first col-sm-8 box-content">
			 
				<div>
				<aui:input name="aarId" type="hidden" value="<%=wfms_action_and_reasoncode.getAarId() %>"></aui:input>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Action</div>

						<div id="action_mainDiv" class="portlet-column portlet-column-last col-sm-4">
						
						<aui:select name="action" id="action" cssClass="field-select chosen" onchange="actionvalidate();" placeholder="" label="" >
							<aui:option value="">Select Action</aui:option>
							<%  
							DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
							 dynamicQueryForAction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
							 dynamicQueryForAction.addOrder(OrderFactoryUtil.asc("actionName"));
							 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
							 for(WFMS_action_names val:actionListof){
								 %>		
								   <aui:option selected="<%=wfms_action_and_reasoncode.getAction().equals(val.getActionId()) %>"  value="<%=val.getActionId() %>"><%=val.getActionName() %></aui:option>
									<%} %>
						</aui:select>
						 </div>
					    <div class="action_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
                                 Missing required value for the field "Action"
						</div>
				</div>
				
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Reason Code</div>

						<div id="reason_code_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:input type="text" name="reasonCode" onkeyup="reason_codevalidate();" id="reason_code" label="" value="<%=wfms_action_and_reasoncode.getReasonCode() %>" ></aui:input>
					    </div>
					    <div class="reason_code_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
                                 Missing required value for the field "Reason Code"
						</div>
				</div>


				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Description</div>

						<div id="description_code_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							 <aui:input type="text" name="description" onkeyup="description_codevalidate();" id="description_code" label="" value="<%=wfms_action_and_reasoncode.getDescription()%>" ></aui:input>
					    </div>
					    <div class="description_code_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 196px;padding-bottom: 9px;">
                                 Missing required value for the field "Description"
						</div>
				</div>
				
				<div style="display: none;">
					  <aui:input type="textarea" name="hidden_field" label="" required="true" > </aui:input>
                      <aui:input type="textarea" name="validation_type" label="" value="0" > </aui:input>

				</div>
				
					<%--  <aui:input type="text" name="action"  label="Action" value="<%=wfms_action_and_reasoncode.getAction() %>" ></aui:input>
					 <aui:input type="text" name="reasonCode"  label="Reason Code" value="<%=wfms_action_and_reasoncode.getReasonCode() %>" ></aui:input>
					 <aui:input type="text" name="description"  label="Description" value="<%=wfms_action_and_reasoncode.getDescription()%>" ></aui:input> --%>
					 <aui:input name="actiontype" type="hidden"></aui:input>
							
				</div>
				
			</div>
			<div class="portlet-column portlet-column-first col-sm-4">
				<div class="box-details">
				
					<h3>Action and Reasoncode ID : <%=wfms_action_and_reasoncode.getAarId() %></h3>
					<div>
				<%-- 	Configuration Type:  	<%= contentType %> --%>
					</div>
					<ul class="box-detail-list">
						<li>Created By:</li>
						<li><%=wfms_action_and_reasoncode.getCreatedBy() %></li>
						<li>Date Created:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_action_and_reasoncode.getCreateDate())%></li>
						<li>Modified By:</li>
						<li><%=wfms_action_and_reasoncode.getModifiedBy()%></li>
						<li>Modified Date:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_action_and_reasoncode.getModifiedDate())%></li>
					</ul>
					
				</div>
			</div>
		</div>
</div>
</aui:form>

<div class="modal fade" id="action_and_reason_popup" style="display: none;">
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
						    <li class="action_ValidationMessage form-validator-stack help-inline" style="display: none;">Action</li>
	                   		<li class="reason_code_ValidationMessage_pop form-validator-stack help-inline" style="display: none;">Reason Code</li>
	                        <li class="description_code_ValidationMessage form-validator-stack help-inline" style="display: none;">Description</li>
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

<!-- Start PopUp for Action and reasoncode -->
   
   <div class="modal fade" id="action_support_delete" style="display:none;">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="yui3-widget-hd modal-header">
			      <div class="toolbar-content yui3-widget component toolbar">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<h3>Do you want to Delete the Action and Reasoncode Associate?</h3>
				</div>
				<div class="yui3-widget-bd modal-body" style="max-height: 150px; height: 60px;">
				<div class="portlet-layout row">
				    <aui:button cssClass="btn btn-primary col-sm-5" name="deleteActionandReasoncode"  type="button"
							onClick='<%=deleteActionandReasoncodeURL.toString()%>' value="Yes"></aui:button>

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

function actionvalidate(){
    var type=$("#<portlet:namespace/>validation_type").val();
	var val=$("#<portlet:namespace />action").val();
	if(val=='' && type==1){
		$(".action_ValidationMessage").show();
           $('#action_mainDiv').addClass('control-group error');
		$('#<portlet:namespace/>hidden_field').val('');   
	}
	else{
		$(".action_ValidationMessage").hide();
           $('#action_mainDiv').removeClass('control-group error');
	}
}

function reasonCodeCheckDuplicate(){
	var actionId=$("#<portlet:namespace />action").val();
	var val=$.trim($("#<portlet:namespace />reason_code").val());
	if(val!=""){
	$.ajax({
		 url : '<%=resourceURL.toString()%>',
			data : {
				<portlet:namespace />actionId : actionId,
				<portlet:namespace />reason_code : val,
				<portlet:namespace />actionAndReasonCodeId : "<%=approverId%>",
				<portlet:namespace />cmd : 'ActionAndReasonCode',
			},
			type : "POST",
			dataType : "json",
			success : function(data) {
				 if($.trim(data.success)=="true")
					{
					    $(".reason_code_ValidationMessage").show();
					    $(".reason_code_ValidationMessage").html("\"Reason Code\" already exists in our database under selected \"Action\", please choose an other Reason Code");
					    $(".reason_code_ValidationMessage_pop").show();
					    $(".reason_code_ValidationMessage_pop").html("\"Reason Code\" already exists in our database under selected \"Action\", please choose an other Reason Code");
					    $('#reason_code_mainDiv').addClass('control-group error');
					    $('#<portlet:namespace/>hidden_field').val(''); 
					}
					else
					{    
						$(".reason_code_ValidationMessage").hide();
						$(".reason_code_ValidationMessage_pop").hide();
		                $('#reason_code_mainDiv').removeClass('control-group error'); 
						$('#action_and_reason_popup').modal('hide');
			     		$("button[type=button]").attr('disabled',true); 
		                $("#<portlet:namespace/>updateActionandreason").submit();
					}
			},
			error : function(response) {
	        	console.log("Error seen for for loadDivisonDepName");
			}
		});
	}
}

function reason_codevalidate(){
	var val=$.trim($("#<portlet:namespace />reason_code").val());
	if(val==''){
		    $(".reason_code_ValidationMessage").show();
		    $(".reason_code_ValidationMessage_pop").show();
		    $(".reason_code_ValidationMessage").html(" Missing required value for the field \"Reason Code\"");
		    $(".reason_code_ValidationMessage_pop").html("Reason Code");
            $('#reason_code_mainDiv').addClass('control-group error');
		    $('#<portlet:namespace/>hidden_field').val('');     
	}
	else
	{
		$(".reason_code_ValidationMessage").hide();
		$(".reason_code_ValidationMessage_pop").hide();
        $('#reason_code_mainDiv').removeClass('control-group error'); 
	}
	
}

function description_codevalidate(){
    var type=$("#<portlet:namespace/>validation_type").val();
	var val=$("#<portlet:namespace />description_code").val();
	if(val=='' && type==1){
		$(".description_code_ValidationMessage").show();
           $('#description_code_mainDiv').addClass('control-group error');
		$('#<portlet:namespace/>hidden_field').val('');   
	}
	else{
		$(".description_code_ValidationMessage").hide();
           $('#description_code_mainDiv').removeClass('control-group error');
	}
}

function validateForm(value) {
	
	 $('#<portlet:namespace/>hidden_field').val('1');
           
             if(value == "submit"){
                $("#<portlet:namespace/>validation_type").val(1);
           
                actionvalidate();
				 reason_codevalidate();
			
				 description_codevalidate();
               
			var auiForm = Liferay.Form._INSTANCES.<portlet:namespace/>updateActionandreason;
				 var auiValidator = auiForm.formValidator;
				 auiValidator.validate();
				 if (!auiValidator.hasErrors()) {
			    $("#<portlet:namespace/>actiontype").val(value);
				 reasonCodeCheckDuplicate();
			  }		
			  else{
			    $('#action_and_reason_popup').modal({ backdrop: 'static',
											keyboard: true, 
											show: true});
			  	}}
             else{
					$("#<portlet:namespace/>actiontype").val(value);
	               $("#<portlet:namespace/>updateActionandreason").submit();
				}
}
</aui:script>
