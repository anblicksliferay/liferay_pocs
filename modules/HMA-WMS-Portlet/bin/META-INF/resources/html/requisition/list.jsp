<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>

<portlet:actionURL name="editRequisition" var="editRequisitionURL"></portlet:actionURL>
<portlet:actionURL name="newURL" var="newURL"></portlet:actionURL>

<portlet:resourceURL var="listByStatusResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByStatus"/>
</portlet:resourceURL>

<portlet:resourceURL var="listRequisitionResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByRequisition"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByDateCreatedResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByDateCreated"/>
</portlet:resourceURL>

<portlet:resourceURL var="listBySubmittedResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listBySubmitted"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByWaitingonManpowerResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByWaitingonManpower"/>
</portlet:resourceURL>


<portlet:resourceURL var="listByFilledButNoAssociateNumberResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByFilledButNoAssociateNumber"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByCompleteResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByComplete"/>
</portlet:resourceURL>

<portlet:resourceURL var="listReportViewResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listReportView"/>
</portlet:resourceURL>
<liferay-ui:success key="approvedSuccess" message="Requisition approved successfully!"/>
<liferay-ui:success key="disapprovedSuccess" message="Requisition disapproved successfully!"/>
<aui:form action="<%=editRequisitionURL.toString() %>" method="post" name="viewRequisition">
	<aui:input name="positionId"  type="hidden" value="" id="positionId"/>
</aui:form>

<script>
	var primaryKeyColumn = 0;
//	var RequisitionColumn = 0;
	var primaryKeyColumnName = "Requisition Number";
//	var RequisitionColumnName = "Requisition Number";
	
	var dataTables = {
        tables:[
            {
                select: "By Status",
                dataURL:"<%=listByStatusResourceURL.toString()%>",
                columns:["Status","Department Number","Department Name","Requisition Number","Position Number","Creator","Next Approver",
                         "Created Date"],
                options:{},
                scrollX: false
            },{
                select: "By Requisition",
                dataURL:"<%=listRequisitionResourceURL.toString()%>",
                columns:["Requisition Number","Posting Type","Position Number","Department Name","Status","Approver","Created Date"],
                options:{},
                scrollX: false
            },{
                select: "By Date Created",
                dataURL:"<%=listByDateCreatedResourceURL.toString()%>",
                columns:["Date Created", "Requisition Number","Department Name","Status","Position Number"],
				options:{filter:"rollupFilter"},
                scrollX: true
            },{
                select: "By Submitted",
                dataURL:"<%=listBySubmittedResourceURL.toString()%>",
                columns:["Status","Department Name","Next Approver","Position Number","Requisition Number","Created Date","Requesting Associate"],
                options:{},
                scrollX: true
            },{
                select: "By Waiting on Manpower",
                dataURL:"<%=listByWaitingonManpowerResourceURL.toString()%>",
                columns:["Status","Department Name","Creator","Created Date","Position Number","Requisition Number"],
         		options:{filter:"rollupFilter"},
                scrollX: true
            },{
                select: "By Filled, But No Associate Number",
                dataURL:"<%=listByFilledButNoAssociateNumberResourceURL.toString()%>",
                columns:["Status","Department Name","Department Number","Requisition Number","Position Number"],
                options:{},
                scrollX: false
            },{
                select: "By Complete",
                dataURL:"<%=listByCompleteResourceURL.toString()%>",
                columns:["Status","Department Name","Filled By Associate","Requisition Number","Position Number"],
                options:{},
                scrollX: false
            },{
                select: "By Reporting",
                dataURL:"<%=listReportViewResourceURL.toString()%>",
                columns:["Requisition Number","Status","Ladder","Creator","Created Date","Position Number","Line","Department Name",
				 "Posting Type","Date Approved","Team Number","Open Position Level(Title)","Shift Assign","Report To","Date Needed", "Contact Name",
				 "Contact Ext","How Available","Who Replaced", "Typical Job Title","Know How","Duties","Tasks","Experience","Degree" ,"Musts"
				 ,"Wants","Estimated OT","Travel","Other","Next Approver"],
                options:{},
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
			if(primaryKeyColumnName==columns[i]  ) primaryKeyColumn=i; 

        	//console.log("primaryKeyColumn stored as: "+primaryKeyColumn);
			$("#recordList tr").append("<th>"+columns[i]+"</th>");
		}
		
		//console.log("About to load dataURL as: " + dataURL);
		
		datatable = $('#recordList table').DataTable( {
			ajax: dataURL,
			dom: 'Blfrtip',
	        lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
			order: [[ 0, "desc" ]],
            scrollX: scrollXVal,
            scrollY: true,
            scrollY: '50vh',
            scrollCollapse: true,
            buttons: [ {
                extend: 'copy'
                    
            },
            {
                extend: 'excel'
            },
            {
               	extend: 'pdfHtml5',
                orientation: 'landscape',
                pageSize: 'LEGAL'
            },
            {
            	extend: 'print' 
            }],
			"initComplete": function(settings, json) {
		        $('#recordList tbody').on( 'click', 'tr', function () {
		        //	console.log("Clicked: "+primaryKeyColumn);
		        //	console.log("Clicked: "+$(this).find("td")[primaryKeyColumn].innerHTML);
		            var pid = $(this).find("td")[primaryKeyColumn].innerHTML;
		           // var rid = $(this).find("td")[RequisitionColumn].innerHTML;
		            $("#<portlet:namespace />positionId").val(pid);
		            $("#<portlet:namespace />viewRequisition").submit();
		        } );
		        $(".dt-button.buttons-copy").text("Copy to Clipboard");
			}
		});
	}
	function setCookie(cname,cvalue,exdays) {
	    var d = new Date();
	    d.setTime(d.getTime() + (exdays*24*60*60*1000));
	    var expires = "expires=" + d.toGMTString();
	    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
	}

	function getCookie(cname) {
	    var name = cname + "=";
	    var decodedCookie = decodeURIComponent(document.cookie);
	    var ca = decodedCookie.split(';');
	    for(var i = 0; i < ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0) == ' ') {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) {
	            return c.substring(name.length, c.length);
	        }
	    }
	    return "";
	}
    $(document).ready(function() {
    	var previouslySelectedFilter = getCookie('hma-wms-requisition-list-filter');
    	var previouslySelectedFilterIndex = 0;
    	
    	for(i=0;i<dataTables.tables.length;i++){
    		if(previouslySelectedFilter==dataTables.tables[i].select){
        		$(requisitionFilter).append("<option selected='selected'>"+dataTables.tables[i].select+"</option>");
        		previouslySelectedFilterIndex = i;
    		}else{
        		$(requisitionFilter).append("<option>"+dataTables.tables[i].select+"</option>");
    		}
    	}
    	
    	$("#requisitionFilter").on("change",function(){
    		setCookie('hma-wms-requisition-list-filter',$(this).find(":selected").text());
    		clearAndLoadData( $(this).find(":selected").index() );
    	});
    	
    	clearAndLoadData( previouslySelectedFilterIndex );
	    
	} );
    
 	function redirectRequest() {
		document.getElementById('<portlet:namespace />newPositions').submit();
	}
 	
</script>

<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Select Requisition</h4>
		<select id="requisitionFilter"></select>
	</div>
	
	<div class="col-sm-6">
		<div class="btn-manage small">
			
			<button class="btn btn-default" onclick="homeUrl('<%=wmsBasePath%>/dashboard')">Home</button>
		</div>
	</div>
</div>

<div class="portlet-layout row">
	<div class="col-sm-12">
        <div id="recordList"></div>
	</div>
</div>

<script>
function homeUrl(url) {
	window.location.href = url;
}

$(document).ready(function() {
	$('.modal-backdrop').remove();
	$('.modal-backdrop').remove();
	} );</script>