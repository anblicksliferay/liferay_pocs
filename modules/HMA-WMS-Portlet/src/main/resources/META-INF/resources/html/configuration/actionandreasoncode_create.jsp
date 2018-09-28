<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_names"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="createActionandreason" var="createActionandreasonURL"></portlet:actionURL>
<aui:form action="<%=createActionandreasonURL.toString()%>" method="post" id="createActionandreason" name="createActionandreason">
<aui:input name="actiontype" type="hidden"></aui:input>
	<div class="portlet-layout">
		<h2 class="titleArea">Action and Reasoncode</h2>
	</div>
		<div class="portlet-layout">
			<div class="col-sm-12 own-wrapper">
				<div class="wfm-system">
					<div class="portlet-layout">
						<div class="portlet-column portlet-column-first">
                                <div class="small center">
                                        <div class="col-sm-6">
                                              <%-- <button type="button" class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/configuration')">Exit
                                                        View</button>  --%>
                                                      <%--   <button class="btn btn-primary" onclick="getUrl('<%=routingapproversURL%>')">Exit View</button> --%>
                                               <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('renderView');" value="Exit View"></aui:button>
                                             
                                        </div>
                                        <div class="col-sm-6">
								 <aui:input name="actiontype" type="hidden"></aui:input>
                                           <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('submit');" value="Submit"></aui:button>
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
					
						<div id="action_mainDiv" class="portlet-column portlet-column-last col-sm-3">
							
							
							<aui:select name="action" id="action" cssClass="field-select chosen" onchange="actionvalidate();" placeholder="" label="" >
							<aui:option value="">Select Action</aui:option>
							<%  
							DynamicQuery dynamicQueryForAction = WFMS_action_namesLocalServiceUtil.dynamicQuery();
							 dynamicQueryForAction.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
							 dynamicQueryForAction.addOrder(OrderFactoryUtil.asc("actionName"));
							 List<WFMS_action_names> actionListof=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction);
							 for(WFMS_action_names val:actionListof){

								 %>		
								   <aui:option  value="<%=val.getActionId() %>"><%=val.getActionName() %></aui:option>
									<%} %>
						</aui:select>
						</div>
						 <div class="action_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Action"
						</div>
				</div>
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Reason Code</div>

						<div id="reason_code_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:input type="text" name="reasonCode" onkeyup="reason_codevalidate();" id="reason_code" label=" " ></aui:input>
					    </div>
						
						<div class="reason_code_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Reason Code"
						</div>
				</div>

				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Description</div>

						<div id="description_code_mainDiv" class="portlet-column portlet-column-last col-sm-4">
							<aui:input type="text" name="description" onkeyup="description_codevalidate();" id="description_code" label="" ></aui:input>
					    </div>
						<div class="description_code_ValidationMessage form-validator-stack help-inline" style="display: none;color:#b50303;padding-left: 303px;padding-bottom: 9px;">
                                 Missing required value for the field "Description"
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
					<portlet:namespace />actionAndReasonCodeId : "",
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
						    ('#showValidations').modal({ backdrop: 'static',
								keyboard: true, 
								show: true});
						}
						else
						{    
							$(".reason_code_ValidationMessage").hide();
							$(".reason_code_ValidationMessage_pop").hide();
			                $('#reason_code_mainDiv').removeClass('control-group error'); 
			                $('#showValidations').modal('hide');
							$("button[type=button]").attr('disabled',true); 
			                $("#<portlet:namespace/>createActionandreason").submit();
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
		else{
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
                
			   var hiddenval=$('#<portlet:namespace/>hidden_field').val();
			  if (hiddenval!='') {
					$("#<portlet:namespace/>actiontype").val(value);
					reasonCodeCheckDuplicate();
			  }		
			  else{
				$('#showValidations').modal({ backdrop: 'static',
								keyboard: true, 
								show: true});
				}
			  }
			else{
				$("#<portlet:namespace/>actiontype").val(value);
			    $("#<portlet:namespace/>createActionandreason").submit();
			}
}

$(".chosen-select").chosen({});

jQuery(document).ready(function(){ 
jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
});
</aui:script>


