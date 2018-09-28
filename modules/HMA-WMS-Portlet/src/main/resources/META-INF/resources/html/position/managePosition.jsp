<%@page import="java.time.LocalDateTime"%>
<%LocalDateTime today = LocalDateTime.now(); 
System.out.println("<<<<load Start Time>>>>>>"+today); %>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>

<portlet:actionURL name="newPositions" var="newPositionsURL">
<portlet:param name="jspPage" value="/html/position/positionView.jsp" /> 
</portlet:actionURL>


<portlet:actionURL name="editPosition" var="editPositionURL"></portlet:actionURL>
<portlet:actionURL name="newURL" var="newURL"></portlet:actionURL>

<portlet:resourceURL var="listByAssociateNumberResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByAssociateNumber"/>
</portlet:resourceURL>

<portlet:resourceURL var="listPendingAndModifiedResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listPendingAndModified"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByDepartmentResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByDepartment"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByPositionNumberResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByPositionNumber"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByStatusResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByStatus"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByLastChangeDateResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByLastChangeDate"/>
</portlet:resourceURL>

<portlet:resourceURL var="listByAssociateHistoryResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listByAssociateHistory"/>
</portlet:resourceURL>

<portlet:resourceURL var="listReportViewResourceURL">
	<portlet:param name="cmd" value="positionList"/>
	<portlet:param name="cmdType" value="listReportView"/>
</portlet:resourceURL>

<aui:form action="<%=editPositionURL.toString() %>" method="post" name="viewPosition">
	<aui:input name="positionId" type="hidden"/>
</aui:form>

<script>

	var primaryKeyColumn = 0;
	var primaryKeyColumnName = "Position Number";
	
	var dataTables = {
        tables:[
            {
                select: "By Associate Number",
                dataURL:"<%=listByAssociateNumberResourceURL.toString()%>",
                columns:["Associate Number","Associate Name","Position Number","Position Reports to","Division Name","Department Name","Ladder",
                         "Level","Position Description","Leadership"],
                options:{},
                scrollX: false,
                header: true,
                footer: true
            },{
                select: "Pending and Modified",
                dataURL:"<%=listPendingAndModifiedResourceURL.toString()%>",
                columns:["Position Number","Associate Number","Associate Name","Status","Next Approver","Division Name","Department Name","Ladder ","Type"],
                options:{},
                scrollX: false
            },{
                select: "By Department",
                dataURL:"<%=listByDepartmentResourceURL.toString()%>",
                columns:["Division Name","Department Name","Status","Position Reports to","Position Number","Associate Number",
                         "Associate Name","MP Category Budgeted","MP Category Filled","Ladder","Type","Level","Category","Position Description",
                         "Year Established","Addition Reason"],
				options:{filter:"rollupFilter"},
                scrollX: true
            },{
                select: "By Position Number",
                dataURL:"<%=listByPositionNumberResourceURL.toString()%>",
                columns:["Position Number","Position Reports to","Division Name","Department Name","Status","Line","Ladder","MP Category Budgeted",
                         "MP Category Filled","Position Class","Type","Level","Leadership Assignment","Category","Subcategory","Position Description",
                         "Year Established","Addition Reason","Reevaluation Date","Associate Number","Associate Name","Critical Workforce?"],
                options:{},
                scrollX: true
            },{
                select: "By Status",
                dataURL:"<%=listByStatusResourceURL.toString()%>",
                columns:["Status","Next Approver","Position Number","Division","Department","MP Category Budgeted","Ladder","Type","Level","Category",
                         "Position Description","Year Established","Addition Reason","Associate Number","Associate Name"],
         		options:{filter:"rollupFilter"},
                scrollX: true
            },{
                select: "By Last Change Date",
                dataURL:"<%=listByLastChangeDateResourceURL.toString()%>",
                columns:["LOng TIme","Last Change Date","Position Number","Position Description","Associate Number","Associate Name",
                         "Description of the Last Change"],
                options:{},
                scrollX: false
            },{
                select: "Report View",
                dataURL:"<%=listReportViewResourceURL.toString()%>",
                columns:["Position Number","Position Reports to","Division Name","Department Name","Status","Line","Ladder","MP Category Budgeted",
                         "MP Category Filled","Position Class","Type","Level","Leadership Assignment","Category","Subcategory","Employee Category",
                         "Employee Cat Desc","Position Description","Year Established","Addition Reason","Reevaluation Date","Associate Number",
                         "Associate Name","Associate Title","Critical Workforce?","Typical Title","Minimum Knowledge","Duties","Tasks","Experience",
                         "Degree","Musts","Wants"],
                options:{},
                scrollX: true
            }
       ]
    };

	function clearAndLoadData(selectedFilter){
		var booleanflag=true;
	   if(selectedFilter==5){ 
		 booleanflag=false; 
		 }
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
			dom: 'Blfrtip',
	        lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
			order: [[ 0, "desc" ]],
			"columnDefs": [
	            {
	                "targets": [0 ],
	                "visible": booleanflag
	            
	            }],
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
		        	if(!booleanflag){primaryKeyColumn=1;}
		      //  	console.log("Clicked: "+primaryKeyColumn);
		        //	console.log("Clicked: "+$(this).find("td")[primaryKeyColumn].innerHTML);
		            var pid = $(this).find("td")[primaryKeyColumn].innerHTML;
		           
		            $("#<portlet:namespace />positionId").val(pid);
		            $("#<portlet:namespace />viewPosition").submit();
		        } );
		        $(".dt-button.buttons-copy").text("Copy to Clipboard");
			},
			fixedHeader: {
		        header:true
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
    	console.log("testa");
    	var previouslySelectedFilter = getCookie('hma-wms-position-list-filter');
    	var previouslySelectedFilterIndex = 0;
    	
    	console.log("previouslySelectedFilter:"+previouslySelectedFilter);
    	
    	for(i=0;i<dataTables.tables.length;i++){
    		if(previouslySelectedFilter==dataTables.tables[i].select){
        		$(positionFilter).append("<option selected='selected'>"+dataTables.tables[i].select+"</option>");
        		previouslySelectedFilterIndex = i;
    		}else{
        		$(positionFilter).append("<option>"+dataTables.tables[i].select+"</option>");
    		}
    	}
    	
    	$("#positionFilter").on("change",function(){
    		setCookie('hma-wms-position-list-filter',$(this).find(":selected").text(),1);
    		clearAndLoadData( $(this).find(":selected").index() );
    		$("#successmessage").hide();
    	});
    	
    	clearAndLoadData( previouslySelectedFilterIndex );
	    
	} );
    
 	function redirectRequest() {
		document.getElementById('<portlet:namespace />newPositions').submit();
	}
</script>

<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Select Position</h4>
		<select id="positionFilter"></select>
	</div>
	
	<div class="col-sm-6">
		<div class="btn-manage small">
		<%-- <%if(WMSUserAccessUtil.checkPermission(request,PortletPropsPermission.CRT_POS_ROLES)){ %> --%>
			<%-- <button class="btn btn-primary" type="submit" name="newPositions" onclick="<%=newPositionsURL%>">Create New Position</button>
			<button onClick="${newPositionsURL}" value="Create New Position" name="newPositions">Create New Position</button> --%>
	
 <%if(WMSUserAccessUtil.checkPermission(renderRequest,PortletPropsPermission.CRT_POS_ROLES)){ %> 
			<input type="button" class="btn btn-primary" value="Create New Position" onclick="callProcessAction('<%=newPositionsURL.toString()%>')">
			<%} %>
			<%-- <a href="<%=newPositionsURL%>"><button class="btn btn-primary">Create New Position</button></a> --%>
		<%-- <%}%> --%>
			<button class="btn btn-default" onclick="getUrl('<%=wmsBasePath%>/dashboard')">Home</button>
		</div>
	</div>
</div>

<div class="portlet-layout row">
	<div class="col-sm-12">
        <div id="recordList"></div>
	</div>
</div> 
<script type="text/javascript">
function callProcessAction(url) {
    window.location.href = url;
}  
$(document).ready(function() {
$('.modal-backdrop').remove();
$('.modal-backdrop').remove();

} );

</script>
<%LocalDateTime today1 = LocalDateTime.now(); 
System.out.println("<<<<load End Time>>>>>>"+today1); %>