<%@ include file="/html/init.jsp" %>

<portlet:resourceURL var="findGUHURL"></portlet:resourceURL>


<form name="findGUHForm" id="findGUHForm" action="findGUH" method="post" name="findGUH">

<div class="header">
<H2>View Unit History</H2>
</div>
<aui:form>
    <aui:fieldset>
<div class="row">
Enter/Scan Unit Barcode<br/>
<div class="barCode">
<aui:input type="textarea" inlineField="true" name="<portlet:namespace/>unitBarCode" id="<portlet:namespace/>unitBarCode" >
</aui:input>
</div>
</div>
<div class="row">
Show Issue ID's
<aui:input type="checkbox" name="<portlet:namespace/>showIssueId" id="<portlet:namespace/>showIssueId" label="Show Issue ID's" >
</aui:input>
</div>
<div class="row">
Include SMT Data
<aui:input type="checkbox" name="<portlet:namespace/>IncludeSMTData" id="<portlet:namespace/>IncludeSMTData" label="Include SMT Data">
</aui:input>
</div>
</aui:fieldset>
</aui:form>
	<div id="moveRows" class="">
		<div class="">
			<div class="">
				<i class="fa fa-arrow-down" aria-hidden="true"></i>
				<input class="btn btn-primary" type="button" id="search" value="Search Unit History" onclick="searchGUH()"/>
			</div>
		</div>
	</div>


<div class="row">
   
	<table id="viewGUHTable" class="table table-striped table-bordered table-hover dataTable dtr-inline" cellspacing="0" width="100%">
	    
	</table>

</div>

</form>
    
<script>
	var subscriptions =  "";
	
	var debug = true;
	
	function initGUH(){
		
		console.log('the subscription above will be replaced by GUH history');
		
		$('#viewGUHTable').DataTable( {
	        data: [],
	        columns: [
	                  { title: "Alert Id" },
	                  { title: "Alert Desc" },
	                  { title: "Alert Info" },
	                  { title: "Alert Warn" },
	                  { title: "Alert Crit" },
	                  { title: "Alert Name" },
	                  { title: "Alert Type" },
	                  
	                  { "className":      'editControl',
	                      "orderable":      false,
	                      "data":           null,
	                      "defaultContent": '<i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i>'},
	                  { "className":      'deleteControl',
	                       "orderable":      false,
	                       "data":           null,
	                       "defaultContent": '<i class="fa fa-trash-o fa-lg" aria-hidden="true"></i>'},
	                  {
	                        "className":      'onOffNotification',
	                  	    "visible": true,
	                  		"orderable":      false,
	                     	"data":           null,
	                     	"defaultContent":""
	                }
	                 
	              ],
	              "columnDefs": [
	                   {
	                       "targets": [ 0,1,2,3,4],
	                       "visible": true
	                   },
	                   {                	
	           			"targets": 9,
	           			"visible": true,
	           			"createdCell": function (td, cellData, rowData, row, col) {           				
	           								  var input = $('<input  type="checkbox" class="js-switch js-check-change onOffNotification"/>');	
	           								  if(cellData[7] == "true"){
	           									input.prop( "checked", true );
	           								  }else{
	           									input.prop( "checked", false );
	           								  }
	           									input.appendTo(td);
	           									return '';
	           					}
	           			}
	          ]
	    } );
	
	 	var table = $('#viewGUHTable').DataTable();
     
	    var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));

	    elems.forEach(function(html) {
	      var switchery = new Switchery(html,{ color: '#1AB394',size: 'small' });
	    });
	};
	
	function searchGUH(){
	   
		var url = '<%=findGUHURL.toString()%>';
		var unitBarCode = $("#unitBarCode").val();
		var showIssueId = $("#showIssueId").val();
		var IncludeSMTData = $("#IncludeSMTData").val();
		console.log('in the searchGUH function, with URL '+url);         
		console.log('in the searchGUH function, with unitBarCode '+unitBarCode);         
		console.log('in the searchGUH function, with showIssueId '+showIssueId);         
		console.log('in the searchGUH function, with IncludeSMTData '+IncludeSMTData);         
        $.ajax({  
                url : '<%=findGUHURL.toString()%>',
                data : {
                    <portlet:namespace />unitBarCode: unitBarCode,
                    <portlet:namespace />showIssueId: showIssueId,
                    <portlet:namespace />IncludeSMTData: IncludeSMTData
                },
    
                type : "POST",
                dataType : "json",                
                success : function(data) {
                    if(debug) console.log(data);                    
                },
                error : function(response) {
                    console.log("Error seen for update");                   
                }
        });
    }

	initGUH();
	initGUHLogic();
</script>
