<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@ include file="/html/init.jsp" %>
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

<portlet:resourceURL var="ByAnnouncedURL">
	<portlet:param name="cmd" value="cosList"/>
	<portlet:param name="cmdType" value="ByAnnounced"/>
	</portlet:resourceURL>

<aui:form action="<%=editCOSURL.toString() %>" method="post" name="viewCOS">
	<aui:input name="cosId" type="hidden"/>
</aui:form>

<portlet:actionURL name="selectURL" var="selectURL"></portlet:actionURL>
<portlet:actionURL name="newChangeOfStatus" var="newChangeOfStatusURL"></portlet:actionURL>

<% 
	String list = "";
%>

<script>
var primaryKeyColumn = 0;
	var primaryKeyColumnName = "Cos Number";
	
	var dataTables = {
        tables:[
    			{
    			    select: "By Status",
    			    dataURL:"<%=ByStatusURL.toString()%>",
    			    columns:["Status","Effective Date","Associate Number","Associate Name","Next Approver","Cos Number","Created Date"],
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
                    columns:["Cos Number","Status","Effective Date","Associate Number","Associate Name","Next Approver","Created Date" ,"Current Position Number","New Position Number"],
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
                    columns:["Associate Number","Cos Number","Associate Name","Status","Effective Date","Next Approver","Created Date" ,"Current Position Number","New Position Number"],
             		options:{filter:"rollupFilter"},
                    scrollX: true
                },{
                	select :"By Announced",
                	dataURL : "<%=ByAnnouncedURL.toString()%>",
                	columns:["Announced","Effective Date","Associate Number","Associate Name","Next Approver","Cos Number","Created Date"],
                	options : {},
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
		            var cosId = $(this).find("td")[primaryKeyColumn].innerHTML;
		           
		            $("#<portlet:namespace />cosId").val(cosId);
		            $("#<portlet:namespace />viewCOS").submit();
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
    	var previouslySelectedFilter = getCookie('hma-wms-cos-list-filter');
    	var previouslySelectedFilterIndex = 0;
    	
    	for(i=0;i<dataTables.tables.length;i++){
    		if(previouslySelectedFilter==dataTables.tables[i].select){
        		$(cosFilter).append("<option selected='selected'>"+dataTables.tables[i].select+"</option>");
        		previouslySelectedFilterIndex = i;
    		}else{
        		$(cosFilter).append("<option>"+dataTables.tables[i].select+"</option>");
    		}
    	}
    	
    	$("#cosFilter").on("change",function(){
    		setCookie('hma-wms-cos-list-filter',$(this).find(":selected").text(),1);
    		clearAndLoadData( $(this).find(":selected").index() );
    	});
    	
    	clearAndLoadData( previouslySelectedFilterIndex );
	    
	} ); 
    
 	function redirectRequest() {
		document.getElementById('<portlet:namespace />newChangeOfStatus').submit();
	}
 	$(document).ready(function() {
 		$('.modal-backdrop').remove();
 		$('.modal-backdrop').remove(); 
 	} );
</script>
<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Select Change Of Status</h4>
		<select id="cosFilter"></select>
	</div>
	
		
	<div class="col-sm-6">
		<div class="btn-manage small">
		<%-- <%if(WMSUserAccessUtil.isUserHaveRole(request,PortletPropsPermission.COS_CRT)){ %> --%>
				<%-- <button class="btn btn-primary" onclick="getUrl('<%=newChangeOfStatusURL%>')">Create New Change of Status</button> --%>
		
			<input type="button" value="Create New Change of Status" class="btn btn-primary" onclick="newchangeofStatus('<%=newChangeOfStatusURL.toString()%>')">
			<%-- <%} %> --%>
			<button class="btn btn-default" onclick="homeUrl('<%=wmsBasePath%>/dashboard')">Home</button>
		</div>
	</div>
</div>


<div class="portlet-layout row">
	<div class="col-sm-12">
        <div id="recordList"></div>
	</div>
</div>

<script type="text/javascript">
function newchangeofStatus(url) {
    window.location.href = url;
}
function homeUrl(url) {
    window.location.href = url;
}
</script>
