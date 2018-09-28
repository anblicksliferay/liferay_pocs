<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>

<%@page import="com.liferay.portal.kernel.json.JSON"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>


<portlet:actionURL name="naSupportInformation" var="naSupportInformationURL"> </portlet:actionURL>
<portlet:actionURL name="nasupportImport" var="nasupportImportURL"> </portlet:actionURL>
<portlet:actionURL name="createnaSupport" var="createnaSupportURL"> </portlet:actionURL>
<aui:form action="<%=naSupportInformationURL.toString() %>" method="post" name="naSupportInformation">
	<aui:input name="approverId" type="hidden"/>
</aui:form>

<aui:script>
var primaryKeyColumn = 0;
var primaryKeyColumnName = "Id";
	var exampleData = <%= HMAAssociateInfoService.getnasuuportConfiguration()%>;	
	
	var associates;

	$(document).ready(function() {

		function loadDataTable(tableData){
            associates = $('#recordList').DataTable({
            	dom: 'Blfrtip',
		        lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
				order: [[ 0, "desc" ]],
                data: tableData,
                scrollX: true,
                //scrollY: true,
                //scrollY: '50vh',
                //scrollCollapse: true,
                buttons: [
                          'copy', 'excel', 'csv', 'pdf', 'print'
                      ],
                      //scrollX: 600,
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
            $("#<portlet:namespace/>naSupportInformation").submit();
        });
	});

</aui:script>


<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>NA Support</h4>
	</div>
	
	<div class="col-sm-6">
		<div class="btn-manage small">
		
			<button class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/configuration')">Exit View</button>
		
			<input type="button" class="btn btn-primary" value="Create NA Support" onclick="getUrl('<%=createnaSupportURL%>')">
			
			
			<%-- <button class="btn btn-primary" onclick="getUrl('<%=nasupportImportURL%>')">Import NA Support</button> --%> 
 		</div>
	</div>
</div>


<table cellspacing="0" class="display" id="recordList" >

	<thead>
		<tr>
			<!-- <th >Id</th> -->
			
			<th>Associate Number</th>
			<th>Associate Date of Hire</th>
			<th>Associate Name</th>
			<th >Department Number</th>
			<th >Department Name</th>
			<th >Associate Title</th>
			<th>Shift Code</th>
			<th>Team Number</th>
			<th >Assign Type</th>
			<th >Leadership Assignment</th>
			<th >Effective Date</th>
		     <th >Termination DT</th>
			<th>Manager Associate Number</th>
			<th>Email</th>
			
			
			
		</tr>
	</thead>
	
</table>

<aui:script>

</aui:script>

<script>
$('.modal-backdrop').remove();$('.modal-backdrop').remove();
</script>