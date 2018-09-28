<%@ include file="/html/mynotification/init.jsp" %>

<portlet:resourceURL var="listURL"/>

<% 
	String partNumber = PortalUtil.getOriginalServletRequest(request).getParameter("partNumber");
	String process = PortalUtil.getOriginalServletRequest(request).getParameter("process");
	String station = PortalUtil.getOriginalServletRequest(request).getParameter("station"); 
	String numOfDays =PortalUtil.getOriginalServletRequest(request).getParameter("numOfDays"); 
	if( partNumber == null ) partNumber = "";
	if( process == null ) process = "";
	if( station == null ) station = "";
	if( numOfDays == null ) numOfDays = "1";
 %>

<div id='<portlet:namespace />spinner' class="portlet-spinner">
	<div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
</div>

<div id="<portlet:namespace />warning" style="display:none">
	<span class="badge badge-danger">There was error while retrieving data. Please contact Administrator.</span>
</div>

<div class="row">
	<div class="col-sm-4">
		<h2 class="mfg-portlet-title">Alerts</h2>
	</div>
	<div class="col-sm-8">
		<div class="row">			
			<div id="dateButtons" class="col-sm-12">
				<span>Date Range:</span>
				<input type="button" value="1D" id="1d" class="btn-white"/>
				<input type="button" value="2D" id="2d" class="btn-white"/>
				<input type="button" value="3D" id="3d" class="btn-white"/>
				<input type="button" value="7D" id="7d" class="btn-white"/>
				<input type="button" value="30D" id="30d" class="btn-white"/>
			</div>
		</div> 
	</div>
</div>	
<%
	Map<String, String> defaultModel = null ; 
	if(renderRequest.getAttribute("userDefaultModel")!=null){
		defaultModel = (Map<String, String>)renderRequest.getAttribute("userDefaultModel");%>
		<script>
			defRegion = "<%=(defaultModel.get("region")==null) ? "All": defaultModel.get("region") %>";
			defSite = "<%=(defaultModel.get("site")==null) ? "All": defaultModel.get("site") %>";
			defServer = "<%=(defaultModel.get("server")==null) ? "All": defaultModel.get("server") %>";
			defAlertType = "<%=(defaultModel.get("alertType")==null) ? "All": defaultModel.get("alertType")%>";
			defProcess = "<%=(defaultModel.get("process") == null) ? "" : defaultModel.get("process") %>";
			defPartNo = "<%=(defaultModel.get("partNo") == null) ? "" : defaultModel.get("partNo") %>";
			defStation = "<%=(defaultModel.get("station") == null) ? "" : defaultModel.get("station") %>";
		</script>
		<%
	}
%>
<div class="row wrapper">
	<div id="tableheader" class="main notifications-controls-container">
					
		<div class="col-sm-4">
			<label>Region</label>
			<select name="region"  class="chosen-select-region"></select>						
		</div>
 
		<div class="col-sm-4">
			<label>Site</label>
			<select name="site" class="chosen-select-site"></select>
		</div>

		<div class="col-sm-4">
			<label>Server</label>										
			<select name="server" data-placeholder="All" class="chosen-select-server" >
				<c:forEach var="server" items="${servers}">
					<option value=${server}>${server}</option>
				</c:forEach>
			</select>																	
		</div>
		
	</div>

	<div style="padding-top: 50px;">
		<table id="myNotificationTable" class="table-responsive table-striped table-bordered table-hover dtr-inline" cellspacing="0" width="100%">
			<thead>
				<tr>			
					<th width="20%">Level & Duration</th> 
					<th width="7%">Deviation</th>
					<th width="13%">Alert Type</th>
					<th width="15%">Station</th>
					<th width="10%">Part No</th>
					<th width="12%">Process</th> 
					<th width="10%">Status</th>
					<th width="13%">Start Date<br/>(Station Local)</th>
					<th width="0%"></th>
					<th width="0%"></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Level & Duration</th>  
					<th>Deviation</th>
					<th>Alert Type</th>
					<th>Station</th>
					<th>Part No</th>
					<th>Process</th> 
					<th>Status</th>
					<th>Start Date<br/>(Station Local)</th>
					<th></th>
					<th></th>
				</tr>
			</tfoot>
		</table>
		<div class="toggleAll floatRight">
			<a class="collapseAll">Collapse All</a>
		</div>
	</div>
</div>
	
<script>
	var debug = false;	
	var partNumber= "<%=partNumber.trim()%>"; 
	var process= "<%=process.trim()%>"; 
	var station= "<%=station.trim()%>"; 
	var numOfDays = "<%=numOfDays.trim()%>";
	var notificationTable = {};
	var currentNotificationsList = [];
	var regionSiteServerList = JSON.parse('<c:out value="${regionSiteServerList}" escapeXml="false" />');
	var regionSitesServers = regionSiteServerList.regionSitesServers;
	var notificationsTable = null;
	//var numOfDays = 1;
	$( document ).ready(function() {
    $("#"+numOfDays+"d").removeClass( "btn-white" ).addClass( "btn" );
	});
	function localSpinner(selector, method){
		if("open"==method){
			$(selector).fadeIn(200);
		} else {
			$(selector).fadeOut(200);
		}
	}
	
	function setSubscriptionCounts(){
		
		var countJSON = "{}";
		
		try{
			if($("#notifications-context .alert-count").length==1){
				countJSON = $("#notifications-context .alert-count").text( );
			}else{
				var configObj = $("#notifications-context .alert-count")[0];
				countJSON = $(configObj).text( );
			}
		}catch(error){
			console.log("Unable to parse count")
		}
		
		var countData = JSON.parse(countJSON);
		
		$(".active-alerts").text(0);
		
		for (var k in countData){
			if (typeof countData[k] !== 'function') {
				
				  if(debug) console.log("key is " + k + ", value is" + countData[k]);
				  $(".active-alerts").each(function(){
					if($(this).attr("sub-id")==k)
						$(this).text( countData[k] );
				  });
			}
		}
	}
	
	function setAlertsCounts(data){
		var alertCounts = {};
		if(debug) console.log("data.length:"+data.length);
		for(i=0;i<data.length;i++){
			if(debug) console.log("data[i].subId +1 :"+data[i].subId);
			if(data[i].status=="Active"){
				if(undefined==alertCounts[data[i].subId]){
					alertCounts[data[i].subId]=1;
				}else{
					alertCounts[data[i].subId]+=1;
				}
			}
		}

		$("#notifications-context .alert-count").text( JSON.stringify(alertCounts) );
		setSubscriptionCounts();
	}
	
	function initializeNotificationsTable(tabledata){
		
		customSorting();
		setAlertsCounts(tabledata);
		
		notificationsTable = $('#myNotificationTable').DataTable( {
			lengthChange: false,
			pagingType: "full_numbers",
			data: tabledata,
			order: [[8, 'asc'],[9, 'desc']],
			columns: [
				{ 
					data: "level", 
					render : function(data, type, full, meta){
						
						if(undefined!=data){
							data = data.charAt(0).toUpperCase() + data.slice(1);
							data = data.replace("Critical","").replace("Info","").replace("Warn","");
						}
						
						if (full.alertType == 'CHANGEOVER ALERT'){
							icon = "<i class='fa fa-cogs'></i> "+data;
						}else if(full.alertType == "DOWNTIME ALERT"){
							icon = "<i class='fa fa-arrow-circle-down'></i> "+data;
						} else if(full.alertType == "YIELD ALERT"){
							icon = "<i class='fa fa-percent'></i> "+data;
						}
						else {
							icon = "<i class='fa fa-clock-o'></i> "+data;
						}

						var fmt='';
						
						if(full.duration){
							var duration = JSON.parse(full.duration);
							if(duration.days >0){
								var days = parseInt(duration.days);
								if(parseInt(duration.hours)>12) days++;
								fmt+= days + "D ";
							}else if(duration.hours >0){
								var hours = parseInt(duration.hours);
								if(parseInt(duration.minutes)>30) hours++;
								fmt+= hours + "h ";
							}else if(duration.minutes >0){
								var minutes = parseInt(duration.minutes);
								if(parseInt(duration.seconds)>30) minutes++;
								fmt+= minutes + "m ";
							}else{
								var seconds = parseInt(duration.seconds);
								fmt+= seconds + "s ";
							}
						}
						var onTxt ='';
						if(full.alertType == "YIELD ALERT"){
							onTxt = full.name ;
						}
						else {
							onTxt = full.station+" for "+full.partNumber ; 
						}
						return  icon +  fmt + " on "+ onTxt;
					}
				},
				{ data: "deviation" },
				{ 
					data: "alertType", 
					render : function(data, type, full, meta){
						if(undefined!=data)	return data.split(" ")[0];
					}
				},
				{ data: "station" },
				{ data: "partNumber" },
				{ data: "process" },
				{ data: "status"},
				{ 
					data: "date", 
					render : function(data){ 
						if(undefined!=data) return data.split(" ")[0];
					}
				},
				{ 
					data: "level", 
					render : function(data, type, full, meta){
						if(full.status=="Active"){
								if(data=="Critical" ) return 1;
								else if(data=="Warn") return 2;
								else  return 3;
						}
						else{return 4;}
					
					}
				},
				{ 
					data: "date", 
					render : function(data){ 
						if(undefined!=data) return data;
					}
				}
				
			],
			columnDefs: [{
				targets: 0,
				type: "level-duration",
				createdCell: function (td, cellData, rowData, row, col) {
					if(debug) console.log("rowData.status:"+rowData.status);
						if(rowData.status !="Active" ){
							$(td).addClass('alert-lvl-disabled');
							//return;
						}
						if ( cellData == 'Critical' ) {
							$(td).addClass('alert-lvl-crit');
						} else if ( cellData == 'Warn' ) {
							$(td).addClass('alert-lvl-warn');
						} else if ( cellData == 'Info' )  {
							$(td).addClass('alert-lvl-info');
						} else {
							$(td).addClass('alert-lvl-disabled');
						}
					}
				},
				{
					"targets": [ 8,9 ],
					"visible": false
				}
			]
		} );
		$("#myNotificationTable_filter").hide();
		$(".sorting_disabled").hide();
	}
	
	function storeDefaultValues(id, value){
		
		var cmd = "storeDefault";
		var cmdType= "storeDefault";
		var context = {fieldid:id, fieldvalue:value};	
		context = JSON.stringify(context);
		console.log('context - '+ context);
		var data  = {};
		data['<portlet:namespace />cmd'] = cmd;
		data['<portlet:namespace />cmdType'] = cmdType;
		data['<portlet:namespace />context'] = context;
		
		$.ajax({  
				url : '<%=listURL.toString()%>',
				data : data,

				type : "POST",
				dataType : "json",
				success : function(data) {
					console.log("Sucessfully storeDefaultValues Response");
				},
				error : function(response) {
					console.log("Error seen for storeDefaultValues Response");
				}
		});
	}
	
	function updateNotificationsGridValues(){

		var context = {regionName: $(".notifications-controls-container select[name='region'] option:selected ").text(),siteName : $(".notifications-controls-container select[name='site'] option:selected ").text(), serverName: $(".notifications-controls-container select[name='server'] option:selected ").val()}
		context['numOfDays']=numOfDays;

		var cmd = 'list';
		var cmdType= 'nothing';
		if(debug) console.log("[Notifications view] updateValues: called with cmd : "+cmd +"cmdType : "+cmdType+" context:"+JSON.stringify(context));
		$("#<portlet:namespace />warning").hide();
		
		$.ajax({  
			url : '<%=listURL.toString()%>',
			data : {
 				<portlet:namespace />cmd: cmd,
 				<portlet:namespace />cmdType: cmdType,
 				<portlet:namespace />context: JSON.stringify(context)
 			},
			type : "POST",
			dataType : "json",
			beforeSend:function(){
				localSpinner("#<portlet:namespace />spinner", 'open');
			},
			complete:function(){
				localSpinner("#<portlet:namespace />spinner", 'close');
				addChosenSelectInSearch();
			},
			success : function(data) {
 				if(debug) console.log(data);
 				if(data.error){
					$("#<portlet:namespace />warning").show();
					console.log(data.error);
				} else {
					
					if(debug) console.log(data.notifications)
					
					setAlertsCounts(data.notifications);
					
					currentNotificationsList = data.notifications;
					
					updateNotificationsTableView();
				}
			},
			error : function(response) {
				console.log("Error seen for updateValues");
				$("#<portlet:namespace />warning").show();
			}
		});
	}

	function updateNotificationsTableView(){
		filteredData = filterAlertsBySubscriptions(currentNotificationsList);
	
		notificationTable.clear();
		notificationTable.rows.add(filteredData).draw();
		addNotificationColumnSearch(notificationsTable);
		
		var partNumber= "<%=partNumber.trim()%>"; 
		var process= "<%=process.trim()%>"; 
		var station= "<%=station.trim()%>"; 
		if(partNumber!="" && process!=""	&& station!=""	){
	
			$('#myNotificationTable tfoot th:nth-child(4) input').val(station).trigger('change');
			$('#myNotificationTable tfoot th:nth-child(5) input').val(partNumber).trigger('change');
			$('#myNotificationTable tfoot th:nth-child(6) input').val(process).trigger('change');
			$('#myNotificationTable tbody tr:nth-child(1)').trigger( "click" );
		}
	}

	function filterAlertsBySubscriptions(data){
		
		var filteredData= [];

		try{
			if(activeSubscriptionFilters && Object.keys(activeSubscriptionFilters).length>0){
				for(activeSubscription in activeSubscriptionFilters){
					for(i=0;i<data.length;i++){
						if(data[i].subId==activeSubscription)
						filteredData.push(data[i]);
					}
				}
			}else{
				filteredData = data;
			}
		}catch(error){
			console.log("Unable to parse filterAlertsBySubscriptions");
			filteredData = data;
		}
		
		return filteredData;
	}
	
	function customSorting(){
 		
		 jQuery.fn.dataTableExt.oSort['string-case-asc']  = function(x,y) {
		    return ((x < y) ? -1 : ((x > y) ?  1 : 0));
		};
		 
		jQuery.fn.dataTableExt.oSort['string-case-desc'] = function(x,y) {
		    return ((x < y) ?  1 : ((x > y) ? -1 : 0));
		}; 
	
	}

	function getSortedValue(d){
		var sortValue = 0;
		if(!d) return sortValue;
		
		var levels = d.split(' ');
	
		if(levels[0]=='Critical'){
			sortValue = 130000000;
			
		} else if(levels[0]=='Warn'){
			sortValue = 12000000;
		}else if(levels[0]=='Info') {
			sortValue = 1100000;
		}
		if(levels.length == 1){
			return  sortValue/2;
		}
		for(var i = 1; i<levels.length; i++){
			if(levels[i]=='seconds'){
				sortValue -=parseInt(levels[i-1]);
			}else if(levels[i]=='minutes'){
				sortValue -=parseInt(levels[i-1]) * 60;
			}else if(levels[i]=='hours'){
				sortValue -=parseInt(levels[i-1]) * 60 * 60;
			}else if(levels[i]=='days'){
				sortValue -=parseInt(levels[i-1]) * 60 * 60 * 24;
			}
		}
	
		return sortValue;
	}
	
	function retrieveDetail(row, tr, chartType){
		var rowData = row.data();
		
		if(chartType=="threshold"){
			row.indexId = row.index();
			row.index = function(){
				var thisRowIndex=row.indexId+'';
				var res = thisRowIndex.split("-");
				    var length=res.length-1;
				    return "threshold-"+res[length];
				};
			row.dataStore = row.data();
			var thd = new Date();
			if(row.dataStore){
				row.dataStore["startTimeUTC"] = (thd.getFullYear() +"-"+ (thd.getMonth()+1)  +"-"+ thd.getDate()  +" "+
												thd.getHours() +":"+ thd.getMinutes() +":"+ thd.getSeconds() +".0") ;
				row.dataStore["alertType"] = "CYCLETIME ALERT";
			}
			row.data = function(){return this.dataStore};
		}
		
		var duration = $(".cycletime-duration-"+ row.index() +" button.btn").val();

		if(debug) console.log("duration:"+duration);
		if(debug) console.log("row.index():"+row.index());
		if(debug) console.log("rowData.startTimeUTC:"+rowData.startTimeUTC);
		if(debug) console.log("rowData.alertType:"+rowData.alertType);
		
		if(undefined==duration) duration = 1;
		
		var context = {	serverName: rowData.server,
						station: rowData.station,
						process: rowData.process ,
						partNumber: rowData.partNumber,
						alertType:rowData.alertType,
						startTimeUTC:rowData.startTimeUTC,
						alarmId:rowData.alarmId,
						duration: duration ,
						deviation: rowData.deviation}

		var cmd = 'history';
		var cmdType= 'nothing';
		
		if(debug) console.log("retrieveDetail: called with cmd : "+cmd +"cmdType : "+cmdType+" context:"+JSON.stringify(context));
		$("#<portlet:namespace />warning").hide();
		
		$.ajax({  
				url : '<%=listURL.toString()%>',
				data : {
					<portlet:namespace />cmd: cmd,
					<portlet:namespace />cmdType: cmdType,
					<portlet:namespace />context: JSON.stringify(context)
				},
	
				type : "POST",
				dataType : "json",
				beforeSend:function(){
					if(chartType=="threshold")
						localspinner_cycleTime("#spinner_cycleTime", 'open');
					else
						localSpinner("#<portlet:namespace />spinner", 'open');
					
				},
				complete:function(){
					if(chartType=="threshold")
						localspinner_cycleTime("#spinner_cycleTime", 'close');
					else
					  localSpinner("#<portlet:namespace />spinner", 'close');
				},
				success : function(data) {
					console.log("retrieveDetail Returned data");
					console.log(data);
					rowData.hours=data.hours;
					rowData.detail=data.detail;
					rowData.productType=data.productType;
					rowData.productFamily=data.productFamily;

					showDetails(row,tr);
				},
				error : function(response) {
					console.log("Error seen for retrieveDetail");
					$("#<portlet:namespace />warning").show();
				}
		});
		
	}
	
	initializeMyNotifications(regionSitesServers); // in main.js
	
	/* $( document ).ready(function() {
		$(".notifications-controls-container select[name='region']").val('Americas');
		alert($(".notifications-controls-container select[name='region']  option:selected").val());
		$(".notifications-controls-container select[name='region']").trigger("change");
	}); */
	
	
</script>
<style>
#myNotificationTable tr th:nth-child(9), #myNotificationTable tr td:nth-child(9) {    display: none; }
</style>