<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_names"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<%@ include file="/html/init.jsp" %>
<%
WFMS_action_names wfms_action_names=null;
String actionValue="";
String actionId="";
if(Validator.isNotNull((String)request.getAttribute("actionId"))){
actionId = (String)request.getAttribute("actionId");
wfms_action_names=WFMS_action_namesLocalServiceUtil.getWFMS_action_names(actionId);
actionValue=wfms_action_names.getActionName();
}
%>
<portlet:actionURL name="actionView" var="actionViewURL"></portlet:actionURL>
<portlet:actionURL name="createNewaction" var="createActionURL"> </portlet:actionURL>
<portlet:actionURL name="createActionandreason" var="createActionandreasonURL"></portlet:actionURL>


<portlet:actionURL name="deleteAction" var="deleteActionURL">
		<portlet:param name="actionId" value="<%=actionId%>" />
</portlet:actionURL>

<!-- Start PopUp for Action and reasoncode -->
   
   <div class="modal fade" id="action_delete" style="display:none;">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="yui3-widget-hd modal-header">
			      <div class="toolbar-content yui3-widget component toolbar">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<h3>Do you want to Delete the Action?</h3>
				</div>
				<div class="yui3-widget-bd modal-body" style="max-height: 150px; height: 60px;">
				<div class="portlet-layout row">
				    <aui:button cssClass="btn btn-primary col-sm-5" name="deleteActiocode"  type="button"
							onClick='<%=deleteActionURL.toString()%>' value="Yes"></aui:button>

						<div class="col-sm-2"></div>
						     <button class="btn btn-primary col-sm-5" type="button" data-dismiss="modal">No</button>
				 </div>
				 </div>
			</div>
		</div>
	</div>
  
<!-- End  -->

<aui:form action="<%=createActionURL.toString()%>" method="post" id="createActionForm" name="createActionForm">
	<div class="portlet-layout row">
		<div ="col-sm-12">
			<h2 class="titleArea">Actions</h2>
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
                                        <div class="col-sm-4">
                                          <button class="btn btn-primary" type="button" onclick="getUrl('<%=actionViewURL%>')">Exit View</button>
                                        </div>
                                        <div class="col-sm-4">
                                           <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onclick="return actionValidate();" value="Submit"></aui:button>
                                </div>
                                <% if(actionId!=""){ %>
                                  <div class="col-sm-4">
										<button type="button" class="btn btn-primary" type="button"
										id="cancel" data-toggle="modal" data-backdrop="static" data-backdrop="static" data-target="#action_delete">Delete </button>
								  </div>
				                         <% } %>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-12">
		<% if(actionId!=""){ %>
		<div class="portlet-column portlet-column-first col-sm-8 box-content">
			<% } %>
			<div class="wfm-system" style="margin-top: 20px;">
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Action</div>
					
						<div class="portlet-column portlet-column-last col-sm-8" id="mpCatBudgetAss_maindiv">
							<aui:input name="actionValue" type="text" value="<%=actionValue %>" label=""></aui:input>
							<div id="mpCatBudgetAss_ValidationMessage" class="form-validator-stack help-inline customErroeClass" style="display: none;">
                                Missing required value for the field "Action"
                        </div>
						</div>
							<aui:input name="actionId" type="hidden" value="<%=actionId %>" label=""></aui:input>
						
				</div></div>
			
			 <% if(actionId!=""){ %></div>
					<div class="portlet-column portlet-column-first col-sm-4">
				<div class="box-details">
				
					<h3>Action and Reasoncode ID : <%=wfms_action_names.getActionId() %></h3>
					<div>
				<%-- 	Configuration Type:  	<%= contentType %> --%>
					</div>
					<ul class="box-detail-list">
						<li>Created By:</li>
						<li><%=wfms_action_names.getCreatedBy() %></li>
						<li>Date Created:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_action_names.getCreateDate())%></li>
						<li>Modified By:</li>
						<li><%=wfms_action_names.getModifiedBy()%></li>
						<li>Modified Date:</li>
						<li><%= HondaLogicUtil.getDateFormat(wfms_action_names.getModifiedDate())%></li>
					</ul>
					
				</div>
			</div>
			<% } %>
		
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

function actionValidate(){
	var val=$.trim($("#<portlet:namespace />actionValue").val());
	if(val==''){
		$("#mpCatBudgetAss_ValidationMessage").show();
		$("#mpCatBudgetAss_ValidationMessage").html("Missing required value for the field \"Action\"");
		 $("#mpCatBudgetAss_maindiv").addClass('control-group error');
       return false;  
	}
	else{
		 $.ajax({
			 url : '<%=resourceURL.toString()%>',
				data : {
					<portlet:namespace />action : val,
					<portlet:namespace />actionId : "<%=actionId %>",
					<portlet:namespace />cmd : 'ActionNames',
				},
				type : "POST",
				dataType : "json",
				success : function(data) {
					 if($.trim(data.success)=="true")
						{
							$("#mpCatBudgetAss_ValidationMessage").show();
							$("#mpCatBudgetAss_ValidationMessage").html("This \"Action\" already exists in our database, please choose an other Action");
				            $("#mpCatBudgetAss_maindiv").addClass('control-group error');
				            return false;
						}
						else
						{    
							 $("#mpCatBudgetAss_ValidationMessage").hide();
							 $("#mpCatBudgetAss_maindiv").removeClass('control-group error');
							 $("#<portlet:namespace />createActionForm").submit();
				             return true;  
						}
				},
				error : function(response) {
		        	console.log("Error seen for for loadDivisonDepName");
				}
			});
		return false;
	}
}

</aui:script>


