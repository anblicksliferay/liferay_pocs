<%@ include file="/html/init.jsp"%>
<%@ include file="/html/dataTableIncludes.jspf"%>

<%@page import="com.liferay.portal.kernel.json.JSON"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<portlet:actionURL name="actionEdit" var="actionUpdateURL">
</portlet:actionURL>
<portlet:actionURL name="actionandreasoncodeView"
	var="actionandreasoncodeGridURL"></portlet:actionURL>
<portlet:actionURL name="actionCreate" var="actionCreateFormURL"></portlet:actionURL>

<aui:form action="<%=actionUpdateURL.toString() %>" method="post"
	name="actionEdit">
	<aui:input name="actionId" type="hidden" />
</aui:form>

<aui:script>
var primaryKeyColumn = 0;
var primaryKeyColumnName = "Id";
	var exampleData = <%= HMAAssociateInfoService.getActions()%>;	
	
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
            	}
            );
        }
        loadDataTable(exampleData);
        $('#recordList tbody').on( 'click', 'tr', function () {
            $("#<portlet:namespace/>actionId").val($(this).find("td")[primaryKeyColumn].innerHTML);
            console.log($(this).find("td"));
            $("#<portlet:namespace/>actionEdit").submit();
        });
	});
	
</aui:script>

<div class="portlet-layout row">
	<div class="col-sm-12 own-wrapper">
		<div class="wfm-system">
			<div class="portlet-layout">
				<div class="portlet-column portlet-column-first">
					<div class="small center">
						<div class="col-sm-3">
							<button class="btn btn-secondary"
								onclick="getUrl('<%=actionandreasoncodeGridURL%>')">Exit
								View</button>
						</div>
						<div class="col-sm-3">

							<button class="btn btn-primary"
								onclick="getUrl('<%=actionCreateFormURL%>')">Create
								Action</button>
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
			<th>Id</th>
			<th>Action</th>
		</tr>
	</thead>
</table>
<script>
$('.modal-backdrop').remove();$('.modal-backdrop').remove();
</script>