<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>

<%@page import="com.liferay.portal.kernel.json.JSON"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<portlet:actionURL name="actionandreasonInformation" var="routingAndApproversURL"> </portlet:actionURL>
<portlet:actionURL name="redirctcreateaction" var="createroutingURL"> </portlet:actionURL>

<portlet:actionURL name="createNewaction" var="createactionURL"> </portlet:actionURL>
<portlet:actionURL name="getActionStatus" var="getActionStatusURL"></portlet:actionURL>
<portlet:actionURL name="actionView" var="actionViewURL"></portlet:actionURL>	

<portlet:resourceURL var="AssNumURL">
<portlet:param name="<%=Constants.CMD %>" value="getAssNumURL"></portlet:param>
</portlet:resourceURL>

<aui:form action="<%=routingAndApproversURL.toString() %>" method="post" name="actionandreasonInformation">
	<aui:input name="approverId" type="hidden"/>
</aui:form>

<aui:script>
var primaryKeyColumn = 0;
var primaryKeyColumnName = "Id";
	var exampleData = <%= HMAAssociateInfoService.getActionandReasoncode()%>;	
	
	var associates;

	$(document).ready(function() {

		function loadDataTable(tableData){
            associates = $('#recordList').DataTable({
               	dom: 'Blfrtip',
		        lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
				order: [[ 0, "desc" ]],
                data: tableData,
	            buttons: [
                          'copy', 'excel', 'pdf', 'print'
                      ],
				"initComplete": function(settings, json) {
			        $(".dt-button.buttons-copy").text("Copy to Clipboard");
				},
                /*columnDefs: [
			            {
			                title: "Skills",
			                targets:[3],
			                visible: false
			            }
		            ]*/
            	}
            );
        }
	
        loadDataTable(exampleData);

        $('#recordList tbody').on( 'click', 'tr', function () {
            $("#<portlet:namespace/>approverId").val($(this).find("td")[primaryKeyColumn].innerHTML);
            console.log($(this).find("td"));
            $("#<portlet:namespace/>actionandreasonInformation").submit();
        });
	});
	/* function actionValidate() {
		 var val=$.trim($("#<portlet:namespace />actionValue").val());
		if(val==''){
			$("#mpCatBudgetAss_ValidationMessage").show();
           $('#mpCatBudgetAss_maindiv').addClass('control-group error');
           return false;
		}
		else{
			$("#mpCatBudgetAss_ValidationMessage").hide();
           $('#mpCatBudgetAss_maindiv').removeClass('control-group error');
           return true;
		}	
    } */
	
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
						<portlet:namespace />cmd : 'ActionNames',
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
						 if($.trim(data.success)=="true")
							{
								$("#mpCatBudgetAss_ValidationMessage").show();
								$("#mpCatBudgetAss_ValidationMessage").html("This \"Action\" already exists in our database, please choose an other Action title");
					            $("#mpCatBudgetAss_maindiv").addClass('control-group error');
					            return false;
							}
							else
							{    
								 $("#mpCatBudgetAss_ValidationMessage").hide();
								 $("#mpCatBudgetAss_maindiv").removeClass('control-group error');
								 $("#<portlet:namespace />mpCatBudgetForAsscociate").submit();
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

<div class="container">
<div class="modal fade" id="addAction" role="dialog" style="display:none;">
	<div class="modal-dialog">
		<aui:form method="post" action="<%=createactionURL.toString()%>" name="mpCatBudgetForAsscociate" id="mpCatBudgetForAsscociate">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" style="margin-top:11px;">&times;</button>
                    </div>
				<div class="modal-body"	style="max-height: 250px;">
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Action </div>
						<div class="portlet-column portlet-column-last col-sm-8" id="mpCatBudgetAss_maindiv">
							<aui:input name="actionValue" type="text" value="" label=""></aui:input>
							<div id="mpCatBudgetAss_ValidationMessage" class="form-validator-stack help-inline customErroeClass" style="display: none;">
                                Missing required value for the field "Action"
                        </div>
						</div>
					</div>
				</div>
				<div class="modal-footer" style="margin-top: 30px;">
					<div class="col-sm-2">
						<aui:button type="submit" class="btn btn-default" onclick="return actionValidate();" value="Submit"
							name="mpCatBudgetForAsscociate"></aui:button>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</aui:form>
</div>
</div>
</div>

<div class="portlet-layout row">
	<div class="col-sm-8"><h4>Action and Reasoncode</h4></div>
	<div class="col-sm-12">
			<div class="col-sm-12 own-wrapper" style="margin-bottom: 5px;">
				<div class="wfm-system">
					<div class="portlet-layout">
						<div class="portlet-column portlet-column-first">
                                <div class="small center">
		<div class="col-sm-4">
			<button class="btn btn-primary" onclick="getUrl('<%=wmsBasePath%>/configuration')">Exit View</button></div>
			<div class="col-sm-4">
			<button class="btn btn-primary" onclick="getUrl('<%=actionViewURL%>')">Actions</button></div>
			<div class="col-sm-4">
			<button class="btn btn-primary" onclick="getUrl('<%=createroutingURL%>')">Create Reasoncode</button>	</div>					
		</div>
	</div>
</div>
</div>
	</div>
</div>
</div>
<table cellspacing="0" class="display" id="recordList" width="100%">
	<thead>
		<tr>
			<th >Id</th>
			<th >Action</th>
			<th>Reason Code</th>
			<th >Description</th>
			
			
		</tr>
	</thead>
</table>
<aui:script>

</aui:script>

<script>
$('.modal-backdrop').remove();$('.modal-backdrop').remove();
</script>