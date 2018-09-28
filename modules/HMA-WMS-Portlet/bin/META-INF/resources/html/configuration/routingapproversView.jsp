<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>

<%@page import="com.liferay.portal.kernel.json.JSON"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<portlet:actionURL name="routingAndApproversInformation" var="routingAndApproversURL"> </portlet:actionURL>
<portlet:actionURL name="createrouting" var="createroutingURL"> </portlet:actionURL>
<aui:form action="<%=routingAndApproversURL.toString() %>" method="post" name="routingAndApproversInformation">
	<aui:input name="approverId" type="hidden"/>
</aui:form>

<aui:script>
var primaryKeyColumn = 0;
var primaryKeyColumnName = "Id";
	var exampleData = <%= HMAAssociateInfoService.getRoutingAndApprovers()%>;	
	
	var associates;

	$(document).ready(function() {

		function loadDataTable(tableData){
            associates = $('#recordList').DataTable({
            	dom: 'Blfrtip',
		        lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
				order: [[ 0, "desc" ]],
                data: tableData,
                scrollX: true,
                buttons: [
                          'copy', 'excel', 'csv', 'pdf', 'print'
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
            $("#<portlet:namespace/>routingAndApproversInformation").submit();
        });
	});

</aui:script>


<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Routing And Approvers</h4>
	</div>
	
	<div class="col-sm-6">
		<div class="btn-manage small">
		
			<button class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/configuration')">Exit View</button>
		
			<input type="button" class="btn btn-primary" value="Create Routing And Approver" onclick="getUrl('<%=createroutingURL%>')">
		</div>
	</div>
</div>


<table cellspacing="0" class="display" id="recordList" width="100%">
	<thead>
		<tr>
			<th >Id</th>
			<th >Action</th>
			<th >currentJobCode ORLeadership</th>
			<th >newJobCode ORLeadership</th>
			<th >Same JobCode</th>
			<th >Same Leadership</th>
			<th >is SameDept</th>
			<th >is SameMgr</th>
			 <th >routing Process</th>
			<th>change Description</th>
			<th >notification To</th> 
			
		</tr>
	</thead>
</table>
<aui:script>

</aui:script>

<script>
$('.modal-backdrop').remove();$('.modal-backdrop').remove();
</script>