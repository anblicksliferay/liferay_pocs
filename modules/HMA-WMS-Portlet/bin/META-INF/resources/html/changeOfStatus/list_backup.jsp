<%-- <%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_COS"%>

<portlet:actionURL name="editCOS" var="editCOSURL"></portlet:actionURL>
<portlet:actionURL name="newURL" var="newURL"></portlet:actionURL>

<portlet:resourceURL var="ByStatusURL">
	<portlet:param name="cmd" value="cosList"/>
	<portlet:param name="cmdType" value="ByStatus"/>
</portlet:resourceURL>

<portlet:resourceURL var="ByCreatorURL">
	<portlet:param name="cmd" value="cosList"/>
	<portlet:param name="cmdType" value="ByCreator"/>
</portlet:resourceURL>

<portlet:resourceURL var="OpenByStatusURL">
	<portlet:param name="cmd" value="cosList"/>
	<portlet:param name="cmdType" value="OpenByStatus"/>
</portlet:resourceURL>



<portlet:resourceURL var="ByEffectiveDateURL">
	<portlet:param name="cmd" value="cosList"/>
	<portlet:param name="cmdType" value="ByEffectiveDate"/>
</portlet:resourceURL>

<portlet:resourceURL var="ByAssociateNumberURL">
	<portlet:param name="cmd" value="cosList"/>
	<portlet:param name="cmdType" value="ByAssociateNumber"/>
</portlet:resourceURL>



<aui:form action="<%=editCOSURL.toString() %>" method="post" name="viewCOS">
	<aui:input name="cosId" type="hidden"/>
</aui:form>

<portlet:actionURL name="selectURL" var="selectURL"></portlet:actionURL>

<portlet:actionURL name="newChangeOfStatus" var="newChangeOfStatusURL"></portlet:actionURL>
<% 
String list ="";

%>

<script>
var primaryKeyColumn = 0;
	var primaryKeyColumnName = "Cos Number";
	
	var dataTables = {
        tables:[
			{
			    select: "By Status",
			    dataURL:"<%=ByStatusURL.toString()%>",
			    columns:["Record Count","Status","Effective Date","Associate Number","Associate Name","Next Approver","Created Date","Cos Number"],
			    options:{},
			    scrollX: false
			},
            {
                select: "By Creator",
                dataURL:"<%=ByCreatorURL.toString()%>",
                columns:["Creator Name","Associate Number","Cos Number","Associate Name","Status","Effective Date","Next Approver","Created Date"],
                options:{},
                scrollX: false
            },{
                select: "Open By Status",
                dataURL:"<%=OpenByStatusURL.toString()%>",
                columns:["Cos Number","Record Count","Status","Effective Date","Associate Number","Associate Name","Next Approver","Created Date"],
                options:{},
                scrollX: false
            },{
                select: "By Effective Date",
                dataURL:"<%=ByEffectiveDateURL.toString()%>",
                columns:["Effective Date","Status","Associate Number","Cos Number","Associate Name","Next Approver","Created Date"],
				options:{filter:"rollupFilter"},
                scrollX: true
            },{
                select: "By Associate Number",
                dataURL:"<%=ByAssociateNumberURL.toString()%>",
                columns:["Associate Number","Cos Number","Associate Name","Status","Effective Date","Approver","Created Date"],
         		options:{filter:"rollupFilter"},
                scrollX: true
            }
            ]
         };
	
	function clearAndLoadData(selectedFilter){
		
		$("#recordList").html("<table class='display' cellspacing='0' width='100%'><thead><tr></tr></thead></table>");
		
		var columns = dataTables.tables[selectedFilter].columns;
		var dataURL = dataTables.tables[selectedFilter].dataURL;
		var scrollXVal = dataTables.tables[selectedFilter].scrollX;
		
		for(i=0;i<columns.length;i++){
			if(primaryKeyColumnName==columns[i]) primaryKeyColumn=i;

        	//console.log("primaryKeyColumn stored as: "+primaryKeyColumn);
			$("#recordList tr").append("<th>"+columns[i]+"</th>");
		}
		
		//console.log("About to load dataURL as: " + dataURL);
		
		datatable = $('#recordList table').DataTable( {
			ajax: dataURL,
			dom: 'Bfrtip',
			order: [[ 0, "desc" ]],
            scrollX: scrollXVal,
			buttons: ['copy', 'excel', 'csv', 'pdf', 'print'],
			"initComplete": function(settings, json) {
		        $('#recordList tbody').on( 'click', 'tr', function () {
		        //	console.log("Clicked: "+primaryKeyColumn);
		        //	console.log("Clicked: "+$(this).find("td")[primaryKeyColumn].innerHTML);
		            var cosId = $(this).find("td")[primaryKeyColumn].innerHTML;
		           
		            $("#<portlet:namespace />cosId").val(cosId);
		            $("#<portlet:namespace />viewCOS").submit();
		        } );
			}
		});
	}
	
    $(document).ready(function() {
    	
    	for(i=0;i<dataTables.tables.length;i++){
    		$(positonFilter).append("<option>"+dataTables.tables[i].select+"</option>");
    	}
    	
    	$("#positonFilter").on("change",function(){
    		clearAndLoadData( $(this).find(":selected").index() );
    	});
    	
    	clearAndLoadData( 0 );
	    
	} );
    
 	function redirectRequest() {
		document.getElementById('<portlet:namespace />newChangeOfStatus').submit();
	}

</script>

<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Select Change Of Status</h4>
		<select id="positonFilter"></select>
	</div>
	
		
	<div class="col-sm-6">
		<div class="btn-manage small">
			<button class="btn btn-primary" onclick="getUrl('<%=newChangeOfStatusURL%>')">Create New Change of Status</button>
			<button class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/dashboard')">Home</button>
		</div>
	</div>
</div>


<div class="portlet-layout row">
	<div class="col-sm-12">
        <div id="recordList"></div>
	</div>
</div>

 --%>