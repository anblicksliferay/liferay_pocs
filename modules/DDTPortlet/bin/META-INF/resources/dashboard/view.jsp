<%@ include file="/init.jsp" %>
<portlet:actionURL var="deleteProfile" name="deleteProfile"/>
<portlet:actionURL var="editProfile" name="editProfile"/>
<%
String JsonLocationdata= (String) request.getAttribute("loca_course");
%>
<portlet:resourceURL var="niceImageUrl">
<portlet:param name="cmd" value="cmd"/>
<portlet:param name="locationid" value="324234"/>
</portlet:resourceURL>


<style>
select.chosen-select-region {
		
		}
.slidecontainer {
    width: 100%;
}
.alert-lvl-all
{
color: white;
}
.alert-lvl-AP{
    background-color: rgba(88, 171, 94, 0.84);
}
.alert-lvl-TS{
background:#ff4a4a;
}
.slider {
    -webkit-appearance: none;
    width: 100%;
    height: 15px;
    border-radius: 5px;
    background: #d3d3d3;
    outline: none;
    opacity: 0.7;
    -webkit-transition: .2s;
    transition: opacity .2s;
	width:200px;
}

.slider:hover {
    opacity: 1;
}

.slider::-webkit-slider-thumb {
    -webkit-appearance: none;
    appearance: none;
    width: 25px;
    height: 25px;
    border-radius: 50%;
    background: #4CAF50;
    cursor: pointer;
}

.slider::-moz-range-thumb {
    width: 25px;
    height: 25px;
    border-radius: 50%;
    background: #4CAF50;
    cursor: pointer;
}
		.button {
    background-color: #383142;
    border: none;
    color: white;
    padding: 7px 34px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.new-search-area {
    width: 100%;
    clear: both;
    padding-top: 20px;
    padding-bottom: 20px;
}
.new-search-area input {
    width: 600px;
    font-size: 20px;
    padding: 5px;
}
</style>
<div id='spinner' class="portlet-spinner" style="display: none;">
<!-- 	<div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
 -->
  <div>  <img src="<%=request.getContextPath()%>/images/ajax-loader.gif"
                    id="img_copy" alt="Please wait a moment.." />
    </div>
 </div>

<div id="<portlet:namespace />warning" style="display:none">
	<span class="badge badge-danger">There was error while retrieving data. Please contact Administrator.</span>
</div>


<portlet:resourceURL var="listURL"/>
<form name="deleteForm" id="deleteForm" action="<%=deleteProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>userid" name="<portlet:namespace/>userid"/>
</form> 

<form name="editForm" id="editForm" action="<%=editProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>editid" name="<portlet:namespace/>editid"/>
</form>

	<div id="confirmDelete_Admin" style="background-color:#ffffff;  height: 15px; display: none;">
				<p style="margin: -9px 0 10px;" >Confirm Delete</p>
			</div>
			



<div class="col-sm-12">
			<div class="col-sm-2">		
					<select   name="location"  id="locationId"    class="chosen target"  >
					  <option value="ALL" >ALL</option>
					<%  List<String> Locationlist= new ArrayList<String>(); 
					List<Loc_Course_Info> list_locations=Loc_Course_InfoLocalServiceUtil.getLoc_Course_Infos(0, 
							Loc_Course_InfoLocalServiceUtil.getLoc_Course_InfosCount());
					for(Loc_Course_Info listModel:list_locations){ Locationlist.add(listModel.getLocationName()); %>
					<%	}    Set<String> set = new HashSet<String>(Locationlist);%>
				<% 	for(String  temp:set){%>    <option value="<%=temp %>"><%=temp %></option><%} %>
			    </select>
	  	 </div>
    	 <div class="col-sm-4">		
			  <input type="range" min="300" max="5000" value="50" class="slider target" id="feesRange">
			  <p>Fee Range: <span id="pickfees"></span></p>
        </div>
		 <div  class="col-sm-3" >
		  <input id="DashBoardFromDate" type="text"  class="target"/>
		 </div>
		  <div  class="col-sm-3" >
		  <input id="DashBoardToDate" type="text"  class="target" />
		 </div>
</div>
<!-- <div class="new-search-area"></div>
 --><table class="userlistGrid" class="table-responsive  table-bordered table-hover" cellspacing="0" width="100%">
			  <thead>
		        <tr>
		            <th>Location</th>
		            <th>Location Id</th>
		            <th>Course Name</th>
		            <th>Course Id</th>
		            <th>Start date</th>
		            <th>Fees</th>
		            <th>Status</th>
		                 <th>locationIdList</th>
		             <th></th>
		        </tr>
		         <tr>
		            <th>Location</th>
		            <th>Location Id</th>
		            <th>Course Name</th>
		            <th>Course Id</th>
		            <th>Start date</th>
		            <th>Fees</th>
		            <th>Status</th>
		                <th></th>
		             <th></th>
		        </tr>
             </thead>
	          <!--  <tfoot>
	               <tr>
	               <th>Location</th>
	               <th>Location Id</th>
	               <th>Course Name</th>
	               <th>Course Id</th>
	               <th>Start date</th>
	               <th>Fees</th>
	               <th>Status</th>
	               <th></th>
	               </tr>
	           </tfoot> -->
			</table>
			
<script>
/* $( "li" ).each(function( index ) {
	  console.log( index + ": " + $( this ).text() ); if(index==1) {   $(this).hide();   }
	}); */
var downloadURL='<%=niceImageUrl.toString()%>';
$('#DashBoardFromDate').datepicker({
    dateFormat: 'dd-mm-yy',
    altField: '#thealtdate',
    altFormat: 'yy-mm-dd'
});
$('#DashBoardToDate').datepicker({
    dateFormat: 'dd-mm-yy',
    altField: '#thealtdate',
    altFormat: 'yy-mm-dd'
});

var slider = document.getElementById("feesRange");
var output = document.getElementById("pickfees");
output.innerHTML = slider.value;

slider.oninput = function() {
  output.innerHTML = this.value;
}
var locationJson=<%=JsonLocationdata%>;
var userlistTable=null;

	  userlistTable = $('.userlistGrid').DataTable( {
		 /*  initComplete : function() {
		        $("#DataTables_Table_0_filter").detach().appendTo('.new-search-area');
		    }, */
		    dom: 'lBfrtip',
		  order: [[4, 'desc'] ],
		  "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50,100, "All"]],  
        orderCellsTop: true,
        buttons: [
        	  { className:'button',
                  extend: 'print',
                  exportOptions: {
                	  columns: [0, 1, 2, 3, 4,5,6 ]
                  }
              },
            { className:'button',
                extend: 'copyHtml5',
                exportOptions: {
                    columns: [0, 1, 2, 3, 4,5,6 ]
                }
            },
            { className:'button',
                extend: 'excelHtml5'


            },
            {   className:'button',
                extend: 'pdfHtml5',
                exportOptions: {
                    columns: [ 0, 1, 2, 3, 4,5,6 ]
                }
            }
          
        ],
        data:locationJson.Loc_CourseData, 
	    columns: [
		{ data: "CousrseName" },
		{ data: "CourseId" },
		{ data: "LocationName"},
		{ data: "LocationId" },
		{ data: "CreatDate" },
		{ data: "Fees" },
		{ data: "Status" },
		{ data: "locationIdList" ,
			    render: function (data, type, row) { 
			    //	var dataObj = jQuery.parseJSON(data);
                   console.log(row.CourseId);
			      var ddl = "<select size='1' id='division"+row.CourseId+"' name='row-1-division'>";
		              ddl = ddl + "<option value=''>select Id </option>";

			    	var myObjects = jQuery.parseJSON(row.DropdwonData);
			        $.each(myObjects, function () {
			         ddl = ddl + "<option value="+this.key+">"+this.value+"</option>";
                      });
			        ddl += "</select>";
			    
			    	
                 return ddl;
            },
		},
		{	
			title:			'',
			className:		'editControl',
			orderable:		true,
			data:			null,
		defaultContent: '<button  type="button" class="btn btn-default btn-sm" > Register </button>'
	<%-- 	//  defaultContent: '<a onclick="addParamToAcnhor(<%=niceImageUrl.toString()%>);" >Download PDF</a>'  --%>
		}
		],
		
		columnDefs: [{
			targets: 0,
			type: "Location"},
		
			{targets: 1,
				type: "LocationId"},
				
				{   targets: 2,
					type: "CourseName"
				},
					{
						targets: 3,
						type: "CourseId"
						},
						{   targets: 4,
							type: "Start date"
							},
							
							{   targets: 5,
								type: "Fees" 
								},
								{   targets: 6,
									type: "Status" ,
									createdCell: function (td, cellData, data, row, col) {
									  if(data.LocationName =="AP" ){
											$(td).addClass('alert-lvl-all alert-lvl-AP');
											//	$(td).addClass('alert-lvl-AP');
										}
									  else  if(data.LocationName =="TS" ){	$(td).addClass('alert-lvl-all alert-lvl-TS');
											//$(td).addClass('alert-lvl-TS'); 
									}
									}},
									{   targets: 7,
										type: "locationIdList" 
										},
								{   targets: 8,
									type: "" ,
									 "searchable": false,
									 'sortable': false,
									 "orderable": false
									}
		]
    
	});	
	
	$('.userlistGrid').addClass("table-bordered");
	$('.userlistGrid').on('click','.editControl', function(){
   var data = userlistTable.row( this).data();
	console.log("CourseId :    " +data.CourseId +"   CousrseName   :   "+ data.CousrseName+"   LocationName  :  "+data.LocationName+"  LocationId:    "+data.LocationId ); 
	console.log(downloadURL);
	//   var myresouce =Liferay.PortletURL.createURL(); 
	  // console.log(myresouce); 
	  console.log(downloadURL); 
	 //  downloadURL.setResourceId("locationid" ,09800);
	//window.open(downloadURL, '_blank');
	//$('#editForm').submit();
} ); 
$('.userlistGrid tbody').on( 'click', 'button', function () {
 	var data = userlistTable.row( this ).data();
	 
});

function localSpinner(selector, method){ 
	if("open"==method){ 
		 $(selector).show()
	} else {
		 $(selector).hide();
	}s
}

/* 
$('#locationId').on('change', function () {
	if($("#locationId").val()=="ALL"){
	userlistTable.columns(2).search('').draw();
	}else
	{userlistTable.columns(2).search( this.value ).draw();}
} ); */
/* function addParamToAcnhor(currentAncorObject){
	var newURL=currentAncorObject;
	window.open(newURL, '_blank');
	} */
$('.target').on('change', function () {
	var cmd = 'list';
	var cmdType= 'nothing';
	var context= {'location':$("#locationId").val(), 'FeesRange': $("#feesRange").val(),'fromDate':$("#DashBoardFromDate").val(), 'ToDate':$("#DashBoardToDate").val() };
	console.log(context);
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: cmd,
				<portlet:namespace />cmdType: cmdType,
				<portlet:namespace />location: $("#locationId").val(),
				<portlet:namespace />context: context
			},
		type : "POST",
		dataType : "json",
		beforeSend:function(){ 
			localSpinner("#spinner", 'open');
		},
		complete:function(){
		
			localSpinner("#spinner", 'close');
		},
		success : function(data) { 
			 var data = data.Loc_CourseData;
		       userlistTable.clear();	
		       userlistTable.rows.add(data).draw();
		       userlistTable.draw();
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
} );

function DrawNewTable(){
	$('#viewSubscriptionsTableWrap').html('<table class="userlistGrid" class="table-responsive table-striped table-bordered table-hover" cellspacing="0" width="100%"> <thead> <tr> <th>Location</th> <th>LocationId</th><th>CourseName</th><th>CourseId</th><th>Start date</th><th>Fees</th><th></th></tr>  </thead> </table>'); //build table
	
	var  userlistTableNew = $('.userlistGrid').DataTable( {
			order: [[0, 'asc'] ],
	        dom: 'frtip',
	        data:locationJson.Loc_CourseData,
		   columns: [
			{ data: "CousrseName" },
			{ data: "CourseId" },
			{ data: "LocationName"},
			{ data: "LocationId" },
			{ data: "CreatDate" },
			{ data: "Fees" },  {	
				title:			'',
				className:		'editControl',
				orderable:		true,
				data:			null,
				defaultContent: '<button  type="button" class="btn btn-default btn-sm" > Register </button>'
			}
			],
			
			columnDefs: [{
				targets: 0,
				type: "Location"},
			
				{targets: 1,
					type: "LocationId"},
					
					{   targets: 2,
						type: "CourseName"
					},
						{
							targets: 3,
							type: "CourseId"
							},
							{   targets: 4,
								type: "Start date"
								},
								
								{   targets: 5,
									type: "Fees" 
									},
									{   targets: 6,
										type: "" ,
										 
										}
			]
	    
		});	
}

/* 
$(document).ready(function() {
	$('.userlistGrid tfoot th').each( function (index) {
		console.log(index);
	   // var title = $('.userlistGrid thead th').eq( $(this).index() ).text();
	    $(this).html( '<input type="text" placeholder="Search  data-index="'+index+'" />' );
	} );
	} );
$('.userlistGrid').DataTable().columns().every( function (index) {
		var that = this;	
		$( 'input', this.footer() ).on( 'keyup change', function () {
			if ( that.search() !== this.value ) {
				that.search( this.value )
					.draw();
			} 
		} );
	 });
 */
 
 $(document).ready(function() {
	  
	    $('.userlistGrid thead tr:eq(1) th').each( function () {
	        var title = $('.userlistGrid thead tr:eq(0) th').eq( $(this).index()).text();
	        if(title.trim()=="Location"){
	        $(this).html( '<input type="text" placeholder="Search '+title+' "  style="width:103px;"  />' );
	        }
	        if(title.trim()=="Location Id"){
		        $(this).html( '<input type="text" placeholder="Search '+title+'"  style="width:103px;"  />' );
		        }
	        if(title.trim()=="Start date"){
		        $(this).html( '<input type="text" placeholder="Search '+title+' " id=datatableDashBoardToDate style="width:103px;"  />' );
		        $('#datatableDashBoardToDate').datepicker({
		            dateFormat: 'dd-mm-yy',
		            altField: '#thealtdate',
		            altFormat: 'yy-mm-dd'
		        });
		        }
	        if(title.trim()=="Course Id"){
		        $(this).html( '<input type="text" placeholder="Search '+title+'"  style="width:103px;"  />' );
		        }
	        if(title.trim()=="Fees"){
		        $(this).html( '<input type="text" placeholder="Search '+title+'"  style="width:103px;"  />' );
		        }
	        if(title.trim()=="Status"){
		        $(this).html( '<input type="text" placeholder="Search '+title+'"  style="width:103px;"  />' );
		        }
	         if(title.trim()=="Course Name"){ 
	        	  var table = $('.userlistGrid').DataTable();
   			   var   select = $('<select  name="tablelocation" id="tablelocation" class="chosen"  style="width:103px;"  ><option value="All">ALL</option></select>')

	       	  table.columns(2).every(function (index) {
	        		   var column = this;
	        		   column.data().unique().sort().each( function ( d, j ) {
	        			        select.append($( '<option value="'+d+'">'+d+'</option>') )
	                   } );
	        	   } );
	 	/* 	var   select = $('<select  name="tablelocation" id="tablelocation" class="chosen"  style="width:103px;"  ><option value="All">ALL</option></select>')
	        	select.append( $('<option value="TS">TS</option>') );
				select.append( $('<option value="AP">AP</option>') );
				select.append( $('<option value="MP">MP</option>') );
				select.append( $('<option value="Delhi">Delhi</option>') ); */
				$(this).html(select);
				$("#tablelocation").chosen();
	        }
	    } ); 
	  var table = $('.userlistGrid').DataTable();
	  table.columns().every(function (index) {
	      var that = this;
		  if(index==0){
	        $('.userlistGrid thead tr:eq(1) th:eq(' + index + ') input').on('keyup change', function () {
	        	table.column($(this).parent().index() + ':visible')
	                .search(this.value).draw();
	        });}
		  if(index==1){
		        $('.userlistGrid thead tr:eq(1) th:eq(' + index + ') input').on('keyup change', function () {
		        	table.column($(this).parent().index() + ':visible')
		                .search(this.value).draw();
		        });}

		  if(index==2){ 
		        $('.userlistGrid thead tr:eq(1) th:eq(' + index + ') select').on('keyup change', function () {
		        	var seachWord = this.value ;
					if(seachWord =='All'){
						seachWord='';
						that.search(seachWord).draw();
					} else {
						that.search(seachWord).draw();
					}	
		        });}
		  if(index==3){
		        $('.userlistGrid thead tr:eq(1) th:eq(' + index + ') input').on('keyup change', function () {
		        	table.column($(this).parent().index() + ':visible')
		                .search(this.value).draw();
		        });}
		  if(index==4){
		        $('.userlistGrid thead tr:eq(1) th:eq(' + index + ') input').on('keyup change', function () {
		        	table.column($(this).parent().index() + ':visible')
		                .search(this.value).draw();
		        });}
		  if(index==5){
		        $('.userlistGrid thead tr:eq(1) th:eq(' + index + ') input').on('keyup change', function () {
		        	table.column($(this).parent().index() + ':visible')
		                .search(this.value).draw();
		        });}
		  if(index==6){
		        $('.userlistGrid thead tr:eq(1) th:eq(' + index + ') input').on('keyup change', function () {
		        	table.column($(this).parent().index() + ':visible')
		                .search(this.value).draw();
		        });}
	    });
	} );
 $('.chosen').chosen();
</script>