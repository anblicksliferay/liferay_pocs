function initializeMyNotifications(regionSitesServers){

	var debug = false;
	
	if(debug) console.log("initializeMyNotifications called");
	
	initializeNotificationsTable([]);
	
	var notificationForm = ".notifications-controls-container ";
	$(notificationForm + " .chosen-select-server").chosen({width: "100%"});
	
	var regions = getRegions(regionSitesServers);
	var selectRegion= $(notificationForm + " select[name='region']");
	selectRegion.append($("<option></option>").attr("value", 'All').text('All'));
	
	for (var i = 0; i < regions.length; i++) {
		if($.trim(regions[i])!=""){
		     selectRegion.append($("<option></option>").attr("value", regions[i]).text(regions[i]));
		}
	}
	
	$(notificationForm + " .chosen-select-region").chosen({width: "100%"});
	
	//alert($(".notifications-controls-container select[name='region']  option:selected").val());
	$(".notifications-controls-container select[name='region']").val(defRegion);
	//$(".notifications-controls-container select[name='region'] option[value='Americas']").prop('selected', true);
	$(".notifications-controls-container select[name='region']").trigger("chosen:updated");
	
	populateSites(defRegion);
	
	$(notificationForm + " .chosen-select-site").chosen({width: "100%"});	
	
	function populateSites(regionName){
		$(".notifications-controls-container select[name='site'] option" ).remove();
		var selectSite= $(".notifications-controls-container select[name='site']");
		var sites = getSite(regionName);
		
		for (var i = 0; i < sites.length; i++) {
			if($.trim(sites[i])!=""){
			    selectSite.append($("<option></option>").attr("value", sites[i]).text(sites[i]));
			}
		}
		$(".notifications-controls-container select[name='site']").val(defSite);
		$(".notifications-controls-container .chosen-select-site").trigger("chosen:updated");	
//		populateNotificationsServer(regionName,sites[0]);
		populateNotificationsServer(regionName,defSite);
	}
	function populateRegions(siteName){
		var regionName="All";
		for(var r in regionSitesServers){
			if(	regionSitesServers[r].siteName == siteName && 
				undefined != regionSitesServers[r].regionName){
			 
				regionName = regionSitesServers[r].regionName;
				if(debug) console.log(regionName)
				break;
			}		
		}
		var selectRegion = $(".notifications-controls-container select[name='region']");
		selectRegion.val(regionName).find("option[value=" + regionName +"]").attr('selected', true); 
		selectRegion.trigger("chosen:updated");
		populateNotificationsServer(regionName,siteName);
	}
	function populateNotificationsServer(regionName,siteName){
		$(".notifications-controls-container select[name='server'] option" ).remove();
		var server= $(".notifications-controls-container select[name='server']");
		var servers = getSever(regionName,siteName);
	
		server.append($("<option></option>").attr("value", 'All').text('All'));
		for (var i = 0; i < servers.length; i++) {
			if($.trim(servers[i].split(".")[0])!=""){
			server.append($("<option></option>").attr("value", servers[i]).text(servers[i].split(".")[0]));
			}
		}
		$(".notifications-controls-container select[name='server']").val(defServer);
		$(".notifications-controls-container .chosen-select-server").trigger("chosen:updated"); 
		updateNotificationsGridValues('list');  
	}
	
	$(".notifications-controls-container select[name='region']").on("change",function(){		
		var regionId = $(".notifications-controls-container select[name='region'] option:selected ").val();
		populateSites(regionId);
		storeDefaultValues("region",regionId);
	});

	$(".notifications-controls-container select[name='site']").on("change",function(){			
		var onchangesite = $(".notifications-controls-container select[name='site'] option:selected" ).val();
		populateRegions(onchangesite);
	});

	$(".notifications-controls-container select[name='server']").on("change",function(){			
		updateNotificationsGridValues('list');
		var onchangeserver = $(".notifications-controls-container select[name='server'] option:selected" ).val();
		storeDefaultValues("server",onchangeserver);
	});
	
	$('#myNotificationTable tfoot th').each( function (index) {
		var title = $(this).text();
		switch(index){
			case 0: $(this).html( '<input type="text" placeholder="Search '+title+'" />' );break;
			case 1: $(this).html( '<input type="text" placeholder="Search '+title+'" />' );break;
			case 2: $(this).html( '<select/>' );break;
			case 3: $(this).html( '<input type="text" id="mySearchStation" placeholder="Search '+title+'" />' );break;
			case 4: $(this).html( '<input type="text" id="myPartNo" placeholder="Search '+title+'" />' );break;
			case 5: $(this).html( '<input type="text" id="myProcess" placeholder="Search '+title+'" />' );break;
			case 6: $(this).html( '<select/>' );break;
	
			default: $(this).html( '' );break;
		}
	
	} );
	
	addNotificationColumnSearch(notificationTable);
	
	$('#myNotificationTable tbody').on('click', 'tr', function () {
		var tr = $(this).closest('tr');
		var row = notificationTable.row( tr );
	
		if ( row.child.isShown() ) {
			row.child.hide();
			tr.removeClass('shown');
		} else {
			if(row.data()){
				if(row.data().detail){
					showDetails(row,tr);				
				}else{				
					retrieveDetail(row,tr, "notification");	
				}
			}
		}
		
	} );
	
	// Expand/Collapse All Rows
	notificationTable = $('#myNotificationTable').DataTable();
 
	notificationTable.rows().every( function () {
		this.child( 'Row details for row: '+this.index() );
	});
	
	$('.toggleAll .expandAll').on( 'click', function () {
		var child = notificationTable.row().child;
		child.show();
	});
	$('.toggleAll .collapseAll').on( 'click', function () {
		$('.notificationDetail').each(function(){
			$(this).parent().parent().remove();
		});
	});
	
	function getRegions(regionSitesServers){
		var regions =[];
		for(var r in regionSitesServers){
			regions.push(regionSitesServers[r].regionName);
		}
		return uniq(regions);
	}
	
	function getSite(regionName){
		var sites = ['All'];
		for(var r in regionSitesServers){
			if(regionName=='All'){
				sites.push(regionSitesServers[r].siteName);
			}else if(regionSitesServers[r].regionName == regionName){
				sites.push(regionSitesServers[r].siteName);
			}			
		}
		return uniq(sites);
	}
	
	$('#1d, #2d, #3d, #7d, #30d').click(function(){
		$('#dateButtons input').each(function(){$(this).addClass('btn-white');$(this).removeClass('btn');});
		$(this).addClass('btn');
		startDate = new Date();
		switch($(this).val()){
			case '1D':numOfDays = 1; break;
			case '2D':numOfDays = 2; break;
			case '3D':numOfDays = 3; break;
			case '7D':numOfDays = 7; break;
			case '30D':numOfDays = 30; break;
			default: numOfDays = -1; break;
		}
		
		updateNotificationsGridValues();
	});

	getNotificationColumnSearchDefaults();
}

function getNotificationColumnSearchDefaults(){
	console.log("inner getNotificationColumnSearchDefaults");
	$(".chosen-select-6").val("Active").trigger("chosen:updated").trigger("change");
	$(".chosen-select-2").val(defAlertType).trigger("chosen:updated").trigger("change");
	$("#mySearchStation").val(defStation).trigger("change");
	$("#myPartNo").val(defPartNo).trigger("change");
	$("#myProcess").val(defProcess).trigger("change");
}

function addNotificationColumnSearch(thisNotificationTable){
	if(!thisNotificationTable.columns)return;
	
	thisNotificationTable.columns().every( function (index) {
		
		if(debug) console.log("Setting up thisNotificationTable column "+index);
		
		var that = this;	
		$( 'input', this.footer() ).on( 'keyup change', function () {
			if ( that.search() !== this.value ) {
				that.search( this.value )
					.draw();
			}
			
			if (index == 3){
				storeDefaultValues("station", this.value);
				//alert("Station" + this.value);
			}
			
			if (index == 4){
				storeDefaultValues("partNo", this.value);
				//alert("Part No" + this.value);
			}
			
			if (index == 5){
				storeDefaultValues("process", this.value);
				//alert("Process" + this.value);
			}
			
		} );
	
		var select = $( 'select', this.footer() );
		$( 'select', this.footer() ).on( 'keyup change', function () {
			var seachWord = this.value ;
			if(seachWord =='All'){
				seachWord='';
				that.search(seachWord).draw();
			} else if (index == 6 || index == 7) {
				regExSearch = '^' + seachWord;
				that.search(regExSearch, true, false).draw();
			} else {
				that.search(seachWord).draw();
			}						
				
			if (index == 2){
				storeDefaultValues("alertType", this.value);
				//alert("Alert Type" + this.value);
			}
		} );

		//if(index>3){
		
		select.addClass('chosen-select-'+index);
		$("select.chosen-select-"+index+" option" ).remove();
		select.append( $('<option value="All">All</option>') );
		if(index == 2 ){
			select.append( $('<option value="cycleTime">CYCLETIME</option>') );
			select.append( $('<option value="changeOver">CHANGEOVER</option>') );
			select.append( $('<option value="downTime">DOWNTIME</option>') );
			select.append( $('<option value="yield">YIELD</option>') );
		} else if(index == 6 ){
			select.append( $('<option selected="selected" value="Active">Active</option>') );
			select.append( $('<option value="Inactive">Inactive</option>') );
		} else {
			this
			.cache( 'search' )
			.sort()
			.unique()
			.each( function ( d ) {
				select.append( $('<option value="'+d+'">'+d+'</option>') );
			});
		}
		
		//}
	});
	
	getNotificationColumnSearchDefaults();
}

function dateFromString(str) {
	var a = $.map(str.split(/[^0-9]/), function(s) { return parseInt(s, 10) });
	return new Date(a[0], a[1]-1 || 0, a[2] || 1, a[3] || 0, a[4] || 0, a[5] || 0, a[6] || 0);
}

function getEndDateForDownTime(startDate,duration){
	
	if(!startDate){
		return null;
	}
	
	var endDate = dateFromString(startDate);
	endDate.setDate(endDate.getDate()+parseInt(duration.days));
	endDate.setHours(endDate.getHours()+parseInt(duration.hours));
	endDate.setMinutes(endDate.getMinutes()+parseInt(duration.minutes));
	endDate.setSeconds(endDate.getSeconds()+parseInt(duration.seconds));
	
	return endDate;
}

function downTimeHistory(d){
	if(d==undefined) return "";

	var threshold = 'Info: 30, Warn: 60, Critical: 120 (minutes)';
	
		var notificationTemplate='<div class="notificationDetail">';
	
		var duration = null;
		if(d.status !="Active"){
			duration = JSON.parse(d.detail);
		}else{
			duration = JSON.parse(d.duration);
		}
		
		var endDate = getEndDateForDownTime(d.date,duration);
	
		var detailTempalate = '<div class="row wrapper">'+
								'<div class="col-sm-12">'+
								'<div id="tableheader2" class="main detailDescription">'+
									'<table>'+
									'<thead>'+
										'<th>Down Time Alert</th>'+
										'<th></th>'+
										'<th></th>'+
										'<th></th>'+
									'</thead>'+
									'<tbody>';
				
					detailTempalate+='<tr>';	
					detailTempalate+='<td><b> Station failed to send any messages for <br>longer than alert level (minutes)....<br>'+threshold +' <b> </td>';		
					detailTempalate+='<td></td>';
					detailTempalate+='<td> <b>Time<br/>(hh:mm:ss) </b> </td>';
					detailTempalate+='<td><b> Date </b> </td>';
					detailTempalate+='</tr>';
		
					detailTempalate+='<tr>';		
					detailTempalate+='<td><b> Last message before gap sent at: </b></td>';		
					detailTempalate+='<td></td>';
					if(d.date){
							detailTempalate+='<td> <b>'+d.date.split(" ")[1]+' <b></td>';
							detailTempalate+='<td><b>'+d.date.split(" ")[0]+'<b></td>';
					}else{
							detailTempalate+='<td>-</td>';
								detailTempalate+='<td>-</td>';
					}
					detailTempalate+='</tr>';
					
					detailTempalate+='<tr>';		
					detailTempalate+='<td><b> Down time ended (next message) at: </b></td>';		
					detailTempalate+='<td></td>';
					if(endDate && d.status !="Active"){
							detailTempalate+='<td> <b>'+(endDate.getHours() < 9 ? '0'+endDate.getHours():endDate.getHours())+':'+(endDate.getMinutes() < 9 ? '0'+endDate.getMinutes():endDate.getMinutes())+':'+(endDate.getSeconds() < 9 ? '0'+endDate.getSeconds():endDate.getSeconds())+'<b></td>';
						detailTempalate+='<td><b>'+endDate.getFullYear()+'-'+(endDate.getMonth() <9 ? '0'+(endDate.getMonth()+1):(endDate.getMonth()+1))+'-'+(endDate.getDate() <9 ? '0'+(endDate.getDate()):(endDate.getDate()))+'<b></td>';
		
					}else{
							detailTempalate+='<td>-</td>';
							detailTempalate+='<td>-</td>';
					}
					detailTempalate+='</tr>';
				
					
					detailTempalate+='<tr>';		
					detailTempalate+='<td><b> Elapsed down time :<b></td>';		
					detailTempalate+='<td></td>';
					detailTempalate+='<td><b>'+duration.hours+':'+duration.minutes+':'+duration.seconds+'<b></td>';
					detailTempalate+='<td><b>'+duration.days+' days <b></td>';
					detailTempalate+='</tr>';
					
									
					detailTempalate+= '</tbody>'+
				'</table>'+
			'</div>'+
			'</div>'+
		'</div>';

	notificationTemplate+=getInfoDescriptionTemplate(d);
	notificationTemplate+=detailTempalate;
	notificationTemplate+='</div>'

	// `d` is the original data object for the row
	return notificationTemplate;
	
}	
function yieldHistory(rowIndex,d){
	if(d==undefined) return "";

	console.log("yieldHistory data");
	console.log(d);

	var notificationTemplate='<div class="notificationDetail">';
	var triggeringYieldClass='';
	var currentYieldClass='';
	
	//parseFloat(warn) < parseFloat(yield)
	var nInfoValue = parseFloat(d.detail.yieldInfoValue);
	var nWarnValue = parseFloat(d.detail.yieldWarnValue);
	var nCritValue = parseFloat(d.detail.yieldCritValue);
	var nTriggeringYield = parseFloat(d.detail.triggeringYield);
	var nCurrentYield = parseFloat(d.detail.currentYield);

	if(nTriggeringYield < nCritValue) {
		triggeringYieldClass = "alert-lvl-crit-yield";
	} else if (nTriggeringYield < nWarnValue) {
		triggeringYieldClass = "alert-lvl-warn-yield";
	} else if (nTriggeringYield < nInfoValue) {
		triggeringYieldClass = "alert-lvl-info-yield";
	}

	if(nCurrentYield < nCritValue) {
		currentYieldClass = "alert-lvl-crit-yield";
	} else if (nCurrentYield < nWarnValue) {
		currentYieldClass = "alert-lvl-warn-yield";
	} else if (nCurrentYield < nInfoValue) {
		currentYieldClass = "alert-lvl-info-yield";
	}

	var detailTempalate = '<div class="row wrapper">'+
							'<div class="col-sm-8">'+
							'<div id="tableheader2" class="main detailDescription">'+
								'<table cellspacing="0" class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline" id="moveRows2" role="grid" style="width: 100%;" width="100%">'+
								'<tbody>'+
									'<tr role="row">'+
										'<th colspan="5" rowspan="1" style="text-align: center; color: #fff; background-color: #2f4050;">Subscription Yield Values - Recalculated Once Each Day Over Last 30 Days of Data</th>'+
									'</tr>'+
									'<tr>'+
										'<td style="text-align: center; background-color: #a7a7a7; color: #2f4050; padding: 0; border: none;">'+
										'<table class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline" id="yield-alert">'+
											'<tbody>'+
												'<tr>'+
													'<th class="yield-alert-title">Mean Yield</th>'+
													'<th class="yield-alert-title">Standard Deviation</th>'+
													'<th class="yield-alert-title">Triggering Yield</th>'+
													'<th class="calc-now-wrapper">'+
														'<button data-id="'+rowIndex+'" class="calc-now-button calc-now-button-'+rowIndex+'">Current Yield</button>'+
													'</th>'+
												'</tr>'+
												'<tr>'+
													'<td>'+d.detail.meanYield+'%</td>'+
													'<td>'+d.detail.standardDeviation+'%</td>'+
													'<td class="'+triggeringYieldClass+'">'+d.detail.triggeringYield+'%</td>'+
													'<td class="'+currentYieldClass+'">'+d.detail.currentYield+'%</td>'+
												'</tr>'+
											'</tbody>'+
										'</table>'+
										'</td>'+
									'</tr>'+
									'<tr>'+
										'<th style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Alert Levels calculated relative to Mean Yield using Standard Deviation (SD)</th>'+
									'</tr>'+
									'<tr>'+
										'<td><span class="info"></span><span id="subTypeInfo">Info: 1 x SD below mean yield = '+d.detail.yieldInfoValue+'%</span></td>'+
									'</tr>'+
									'<tr id="warningRow">'+
										'<td><span class="warning"></span><span id="subTypeWarning">Warning: 1.5 x SD below mean yield = '+d.detail.yieldWarnValue+'%</span></td>'+
									'</tr>'+
									'<tr id="criticalRow">'+
										'<td><span class="critical"></span><span id="subTypeCritical">Critical: 2 x SD below mean yield = '+d.detail.yieldCritValue+'%</span></td>'+
									'</tr>'+
								'</tbody>'+
						'</table>'+
					'</div>'+
				'</div>'+
			'</div>';

	notificationTemplate+=detailTempalate;
	notificationTemplate+='</div>'

	// `d` is the original data object for the row
	return notificationTemplate;
}	

function changeOverHistory(d){
	if(d==undefined) return "";
	
	var detail = d.detail;		
	var cycleTime = getDaysHours(detail.cycleTime);	
	var endDate = getEndDate(d.date, detail.cycleTime)
	
		var notificationTemplate='<div class="notificationDetail">';
	
		var fromPartsTemplate = '<div>'+
				'<div class="notifications-controls-container">'+
					'<div>'+
						'<span>*From* Part: </span>'+
					'</div>'+
				'</div>'+
				'<div class="notifications-controls-container">'+
					'<div>'+
						'<span>Part Number : </span>'+
						'<span>'+detail.partNumber+'</span>'+
					'</div>'+
				'</div>'+
				'<div class="notifications-controls-container">'+
					'<div>'+
						'<span>Product Type: </span>'+
						'<span>'+detail.productType+'</span>'+
					'</div>'+
				'</div>'+
				'<div class="notifications-controls-container">'+
					'<div>'+
						'<span>Product Family: </span>'+
						'<span>'+detail.productFamily+'</span>'+
					'</div>'+
				'</div>'+
		'</div>';

		var toPartsTemplate ='<div>'+
			'<div class="notifications-controls-container">'+
				'<div>'+
					'<span>*To* Part: </span>'+
				'</div>'+
			'</div>'+
			'<div class="notifications-controls-container">'+
				'<div>'+
					'<span>Part Number : </span>'+
					'<span>'+d.partNumber+'</span>'+
				'</div>'+
			'</div>'+
			'<div class="notifications-controls-container">'+
				'<div>'+
					'<span>Product Type: </span>'+
					'<span>'+d.productType+'</span>'+
				'</div>'+
			'</div>'+
			'<div class="notifications-controls-container">'+
				'<div>'+
					'<span>Product Family: </span>'+
					'<span>'+d.productFamily+'</span>'+
				'</div>'+
			'</div>'+
		'</div>';

		var partTemplate = '<div class="row wrapper">'+
						'<div class="col-sm-12">'+fromPartsTemplate+toPartsTemplate+
						'</div>'+
						'</div>';

		var detailTempalate = '<div class="row wrapper">'+
							'<div class="col-sm-12">'+
							'<div id="tableheader2" class="main detailDescription">'+
								'<table>'+
								'<thead>'+
									'<th>Change Over Time (hh:mm:ss)</th>'+
									'<th></th>'+
									'<th></th>'+
									'<th></th>'+
								'</thead>'+
									'<tbody>';
		
				
			detailTempalate+='<td> Threshold:  00:60:00 </td>';		
			detailTempalate+='<td></td>';
			detailTempalate+='<td> Time(hh:mm:ss) </td>';
			detailTempalate+='<td> Date </td>';
			detailTempalate+='</tr>';

			detailTempalate+='<tr>';		
			detailTempalate+='<td> (Station local time & date) </td>';		
			detailTempalate+='<td>Start</td>';
			detailTempalate+='<td>'+d.date.split(" ")[1]+'</td>';
			detailTempalate+='<td>'+d.date.split(" ")[0]+'</td>';
			detailTempalate+='</tr>';
			
			detailTempalate+='<tr>';		
			detailTempalate+='<td>  </td>';		
			detailTempalate+='<td>End</td>';			
			detailTempalate+='<td>'+(endDate.getHours() < 9 ? '0'+endDate.getHours():endDate.getHours())+':'+(endDate.getMinutes() < 9 ? '0'+endDate.getMinutes():endDate.getMinutes())+':'+(endDate.getSeconds() < 9 ? '0'+endDate.getSeconds():endDate.getSeconds())+'</td>';
			detailTempalate+='<td>'+endDate.getFullYear()+'-'+(endDate.getMonth() <9 ? '0'+(endDate.getMonth()+1):(endDate.getMonth()+1))+'-'+(endDate.getDate() <9 ? '0'+(endDate.getDate()):(endDate.getDate()))+'</td>';
		
			detailTempalate+='</tr>';
			
			
			detailTempalate+='<tr>';		
			detailTempalate+='<td> Elapsed Change Over Time </td>';		
			detailTempalate+='<td></td>';
			detailTempalate+='<td>'+cycleTime.hours+':'+cycleTime.minutes+':'+cycleTime.seconds+'</td>';
			detailTempalate+='<td>'+cycleTime.days +' days </td>';
			detailTempalate+='</tr>';
			
						
		detailTempalate+= '</tbody>'+
				'</table>'+
			'</div>'+
			'</div>'+
		'</div>';

	notificationTemplate+=getInfoDescriptionTemplateChangeOver(d);
	notificationTemplate+=partTemplate;
	notificationTemplate+=detailTempalate;
	notificationTemplate+='</div>'

	// `d` is the original data object for the row
	return notificationTemplate;
	
} 

function getEndDate(startDate, cycleTimeInMilliSeconds){
	var d = dateFromString(startDate);
	var dateInMilliseconds = d.getTime();
	var endDate = new Date(dateInMilliseconds+cycleTimeInMilliSeconds);
	
	return endDate;
}

function getDaysHours(milliSeconds){
	var totalMilliSecInSeconds = 1000;
	var totalMilliSecInMinutes = totalMilliSecInSeconds * 60;
	var totalMilliSecInHours = totalMilliSecInMinutes * 60 ;
	var totalMilliSecInDay = totalMilliSecInHours * 24;
	
	var days = Math.floor(milliSeconds / totalMilliSecInDay);
	var remaining =  milliSeconds % totalMilliSecInDay;	
	var hours = Math.floor(remaining / totalMilliSecInHours);	
	remaining = remaining % totalMilliSecInHours;	
	var minutes = Math.floor(remaining / totalMilliSecInMinutes);	
	remaining = remaining % totalMilliSecInMinutes;	
	var seconds = Math.floor(remaining / totalMilliSecInSeconds);
	
	hours = hours < 10 ? '0'+hours:hours;
	minutes = minutes <10? '0'+minutes:minutes;
	seconds = seconds <10 ? '0'+seconds:seconds;
	var date ={days:days,hours:hours,minutes:minutes,seconds:seconds};
	
	if(debug) console.log('date : '+JSON.stringify(date));
	return date;
}

function cycleTimeHistory ( rowIndex, detail ) {

	if(debug) console.log("cycleTimeHistory detail:");
	if(debug) console.log(detail);
	
	if(detail==undefined || detail.length==0) return "";

	if(detail.deviation){
		var detailTempalate = '<div class="row wrapper">'+
								'<div class="col-sm-12">'+
									'<div id="tableheader2" class="main detailDescription">'+
									'<table>'+
									'<thead>'+
										'<th>Cycle</th>'+
										'<th>Cycle Time<br/>(mm:ss)</th>'+
										'<th>Deviation</th>'+
										'<th>Time</th>'+
										'<th>Date</th>'+
									'</thead>'+
									'<tbody>';
	
		detailTempalate+='<tr>';		
		detailTempalate+='<td> Threshold </td>';		
		detailTempalate+='<td>'+detail.threshold+ '</td>';
		detailTempalate+='<td> - </td>';
		detailTempalate+='<td> - </td>';
		detailTempalate+='<td> - </td>';
		detailTempalate+='</tr>';
	
		var startCycleTimeInSec = getStartCycleTimeInMilli (detail.deviation,detail.threshold);
		
		detailTempalate+='<tr>';		
		detailTempalate+='<td>Start </td>'; 
		detailTempalate+='<td>'+getMinuteSecond(startCycleTimeInSec)+ '</td>';
		detailTempalate+='<td>'+detail.deviation+ '</td>';
		detailTempalate+='<td>'+detail.date.split(" ")[1]+'</td>';
		detailTempalate+='<td>'+detail.date.split(" ")[0]+'</td>';
		detailTempalate+='</tr>';
	}

	var history = detail.detail;
	for(var i=0; i< history.length;i++){
		
		if(undefined==history[i].cycleTime)continue;
		
		detailTempalate+='<tr>';
		if(i==0){
				detailTempalate+='<td> now </td>';
		}else{
			detailTempalate+='<td> n-'+i+ '</td>';
		}
		detailTempalate+='<td>'+history[i].cycleTime+ '</td>';	
		//detailTempalate+='<td>'+calculateDeviation(detail.threshold,history[i].cycleTime)+ '</td>'; 
		detailTempalate+='<td>'+detail.threshold +','+ history[i].cycleTime+ '</td>'; 
		detailTempalate+='<td>'+history[i].time+ '</td>';
		if(i > 0 && history[i].date == history[i-1].date){
			detailTempalate+='<td></td>';
		}else{
			detailTempalate+='<td>'+history[i].date+ '</td>';
		}
		
		detailTempalate+='</tr>';
	}							
	detailTempalate+= '</tbody>'+
			'</table>'+
		'</div>'+
		'</div>'+
	'</div>';

	
	var notificationTemplate='<div class="notificationDetail">';
	
	notificationTemplate+=getDetailChart(rowIndex, detail);
	
	var infoDescriptionTemplate = getInfoDescriptionTemplate(detail);
	
	//console.log("infoDescriptionTemplate:"+infoDescriptionTemplate);
	if(infoDescriptionTemplate!=undefined){
		//console.log("infoDescriptionTemplate added");
		notificationTemplate+=infoDescriptionTemplate;
	}

	//console.log("detailTempalate:"+detailTempalate);
	if(detail.deviation){
		//console.log("detailTempalate added");
		notificationTemplate+=detailTempalate;
	}
	
	notificationTemplate+='</div>'
		
	//console.log("notificationTemplate:"+notificationTemplate);

	return notificationTemplate;
}

function getDetailChart(notificationId,detail){
	
	if(debug) console.log("getDetailChart template called");
	
	var chartTemplate = "";
		var myArray = {1:"1h", 4: "4h", 8: "8h", 24: "1D", 72: "3D", 168: "7D"};		
		var selected="btn";
		chartTemplate += '<div  data-id="'+notificationId+'"  class="cycletime-duration cycletime-duration-'+notificationId+'">'
		for (var key in myArray) {
			selected="btn-white";
			  if(key==detail.hours) selected="btn";
			  chartTemplate += 	'<button value="'+key+'" class="'+selected+'">'+myArray[key]+'</button>';
			}
		chartTemplate += '</div>';
	
	chartTemplate += '<div class="cycletimeChart" style="margin-top: 10px;overflow: hidden;text-align: left;"  id="cycletimeChart-'+notificationId+'"></div>';
	
	return chartTemplate;
}

function initDetailChart(notificationId,detail){
	
	//debug = true;
	
	if(debug) console.log("Initalizing initDetailChart with detail length of "+detail.length);
	
	if(detail.length<=0){
		if(debug) console.log("Adding initDetailChart error message for #cycletimeChart-"+notificationId);
		$("#cycletimeChart-"+notificationId)
		.addClass("error-msg")
		.html("<b>No chart information returned for this station/part number pair for this time range.</b>");
		
		return false;
	}
	
	if(debug) console.log("Initalizing chart with id: cycletimeChart-"+notificationId);
	if(debug) console.log("Data:");
	if(debug) console.log(detail);
	
	var vh = -1;
	var vl = -1;

	var hideManualThreshold = true;
	
	for(i=0;i<detail.length;i++){
		if(vh==-1) vh=detail[i]["Cycletime"];
		if(vl==-1) vl=detail[i]["Cycletime"];

		if(detail[i]["Cycletime"]>vh) vh=detail[i]["Cycletime"];
		if(detail[i]["Cycletime"]<vl) vl=detail[i]["Cycletime"];
		
		if(detail[i]["Threshold"]>vh) vh=detail[i]["Threshold"];
		if(detail[i]["Threshold"]<vl && 
				detail[i]["Threshold"]>0) vl=detail[i]["Threshold"];

		if(detail[i]["ManualThreshold"]>0){
			hideManualThreshold = false;
			if(detail[i]["ManualThreshold"]>vh) vh=detail[i]["ManualThreshold"];
			if(detail[i]["ManualThreshold"]<vl) vl=detail[i]["ManualThreshold"];
		}

		if (detail[i].alertLevel == "Critical"){
			detail[i].color = "#a12a2a";
		} else if (detail[i].alertLevel == "Info"){
			detail[i].color = "#5b8cb9";
		} else if (detail[i].alertLevel == "Warn"){
			detail[i].color = "#CB7F36";
		}
	}

	if(debug) console.log("Low:" + vl + " High:" + vh);
	
	vhb = Math.floor(vh*2.5)
	vlb = Math.floor(vl/2);
	
	if(debug) console.log("Low Bound:" + vlb + " High Bound:" + vhb);
	
	detail.sort(function (a, b) {
		return new Date(a.datetime).getTime() - new Date(b.datetime).getTime();
	});
	
	var chart =  AmCharts.makeChart("cycletimeChart-"+notificationId, {
		"type": "serial",
		"theme": "light",
		"dataProvider": detail,
		"dataDateFormat": "YYYY-MM-DD JJ:NN:SS",
		"categoryField": "datetime",
		"legend": {
			"useGraphSettings": true
		},
		"valueAxes": [{
			"axisAlpha": 0.2,
			"dashLength": 1,
			//"maximum":vhb,
			//"minimum":0,
			//"strictMinMax":true,
			"position": "left",
			"labelFunction": function(value, valueText, valueAxis) {
				return (value/1000)+"s";
			}
		}],
		"categoryAxis": {
			"fontSize":9.5,
			"labelFunction": function(valueText, serialDataItem, categoryAxis) {
				//more work needed on formating for ranges of more than a day
				//http://www.amcharts.com/kbase/formatting-dates/
				
				//if(debug) console.log(valueText);
				var d = dateFromString( valueText );
				
				selectedRange = $(".cycletime-duration-"+notificationId+" button.btn").val();
				
				if( selectedRange=="72"){
					return (d.getMonth()+1)+"/"+d.getDate()+" "+hourFormatAMPM(d.getHours());
				} else if(selectedRange=="168"){
					return (d.getMonth()+1)+"/"+d.getDate();
				} else { //	if Selected Range 1,4,8,24
					return timeFormat(d);
				}
			}
		},
		"chartScrollbar": {
			"graph": "g1",
			"oppositeAxis": false,
			"offset": 30,
			"scrollbarHeight": 50,
			"backgroundAlpha": 0,
			"selectedBackgroundAlpha": 0.1,
			"selectedBackgroundColor": "#888888",
			"graphFillAlpha": 0,
			"graphLineAlpha": 0.5,
			"selectedGraphFillAlpha": 0,
			"selectedGraphLineAlpha": 1,
			"autoGridCount": true,
			"color": "#AAAAAA"
		},
		"graphs": [
			{
				"id": "g6",
				"type": "line",
				"title": "Threshold",
				"bullet": "square",
				"bulletBorderAlpha": 1,
				"bulletAlpha": .5,
				"bulletSize": 1,
				"lineColor": "#777",
				"valueField": "Threshold",
				"colorField": "color",
				"balloonFunction": function(graphDataItem, graph) {
					var value = graphDataItem.values.value;
					var returnText = value/1000;
					return returnText+"s";
				}
			},
			{
				"id": "g7",
				"hidden": hideManualThreshold,
				"type": "line",
				"title": "Manual Threshold",
				"bullet": "square",
				"bulletBorderAlpha": 1,
				"bulletAlpha": .5,
				"bulletSize": 1,
				"lineColor": "#555",
				"colorField": "color",
				"valueField": "ManualThreshold",
				"balloonFunction": function(graphDataItem, graph) {
					var value = graphDataItem.values.value;
					var returnText = value/1000;
					return returnText+"s";
				}
			},
			{
				"id": "g5",
				"type": "line",
				"title": "Cycletime",
				"lineColor": "black",
				"bullet": "round",
				"bulletBorderAlpha": 1,
				"bulletAlpha": 1,
				"bulletSize": 3,
				"colorField": "color",
				"valueField": "Cycletime",
				"balloonFunction": function(graphDataItem, graph) {
					var value = graphDataItem.values.value;
					var returnText = value/1000;
					return returnText+"s";
				}
			},
			{
				"id": "g2",
				"type": "line",
				"lineColor": "#5b8cb9",
				"title": "Info",
				"valueField": "Info",
				"lineThickness": 2
			},
			{
				"id": "g3",
				"type": "line",
				"lineColor": "#CB7F36",
				"title": "Warning",
				"valueField": "Warning",
				"lineThickness": 2
			},
			{
				"id": "g4",
				"type": "line",
				"lineColor": "#a12a2a",
				"title": "Critical",
				"valueField": "Critical",
				"lineThickness": 2
			}
		]
	});
}

function hourFormatAMPM(h){
	return (((h>12)?h-12:h)+((h>=12)?"PM":"AM"));
}

function timeFormat(d){
	var h = d.getHours();
	var m = d.getMinutes();
	
	return ((h>12)?h-12:h)+":"+((m<10)?"0"+m:m)+((h>=12)?"PM":"AM");
}

function getStartCycleTimeInMilli(deviation, threshold){
	var d = parseInt(deviation.substr(0,deviation.indexOf('%')));
	var s = threshold.split(':');
	var t = 0;
	if(s.length == 2){
		t =  parseInt(s[0]) * 60 + parseInt(s[1])
	}else if(s.length == 1){
		t =  parseInt(s[0])
	}
	
	var m = (d * t)/1000+ t;
	
	return m;
}

function getMinuteSecond(sec){
	var secInMin  = Math.floor(sec % 60);
	secInMin = secInMin < 10 ? '0'+secInMin : secInMin;
	var min = Math.floor(sec/60);
	min = min < 10 ? '0'+min: min;
	return min+":"+secInMin;
}

function calculateDeviation(threshold,cycleTime){
	var deviation = 0;
	try{
		var thresholdInSeconds = parseInt(threshold.split(":")[0]*60)+parseInt(threshold.split(":")[1]);
		var cycelTimeInSeconds = parseInt(cycleTime.split(":")[0]*60)+parseInt(cycleTime.split(":")[1]);
		var deviation = ((cycelTimeInSeconds - thresholdInSeconds )*100)/thresholdInSeconds;
	}catch(err){
		console.log('error while calculating deviation');
		console.log(err);
	}
	return Math.round(deviation) + '%';
}

function getInfoDescriptionTemplate(detail){
	
	if(debug) console.log(detail.regionName);
	
	if(undefined == detail.regionName){
		detail.regionName = $(".cycletimeadmin-controls-container .chosen-select-region").val();
	}
	
	if(debug) console.log(detail.siteName);
		
	if(undefined == detail.siteName){
		detail.siteName = $(".cycletimeadmin-controls-container .chosen-select-site").val();
	}
	
	var infoTemplate = 	'<div class="row wrapper">'+
							'<div class="col-sm-3">'+
								'<span>Region: </span>'+
								'<span><b>'+detail.regionName+'</b></span>'+
							'</div>'+
							'<div class="col-sm-3">'+
								'<span>Site: </span>'+
									'<span><b>'+detail.siteName+'</b></span>'+
							'</div>'+
							'<div class="col-sm-3">'+
								'<span>Product Type: </span>'+
								'<span><b>'+detail.productType+'</b></span>'+
							'</div>'+
							'<div class="col-sm-3">'+
								'<span>Product Family: </span>'+
								'<span><b>'+detail.productFamily+'</bs></span>'+
							'</div>'+
						'</div>';
	
	if(detail.description){
		infoTemplate += '<div class="row wrapper">'+
								'<div class="col-sm-12">'+
									'<div>'+
										
										'<span class="description">'+detail.description+'</span>'+
												
									'</div>'+
								'</div>'+
							'</div>';
	}
		
	return infoTemplate;
}

function getInfoDescriptionTemplateChangeOver(detail){
	var infoTemplate = 	'<div class="row wrapper">'+
							'<div class="col-sm-12">'+
								'<div>'+
									'<div class="notifications-controls-container">'+
										'<div>'+
											'<span>Region: </span>'+
											'<span>'+detail.regionName+'</span>'+
										'</div>'+
									'</div>'+
									'<div class="notifications-controls-container">'+
										'<div>'+
											'<span>Site: </span>'+
											'<span>'+detail.siteName+'</span>'+
										'</div>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>';
						
	var descriptionTemplate = 	'<div class="row wrapper">'+
									'<div class="col-sm-12">'+
										'<div>'+
											'<span class="description">'+detail.description+'</span>'+
										'</div>'+	
									'</div>'+
								'</div>';
		
	return infoTemplate+descriptionTemplate;
	
}

function addChosenSelectInSearch(){
	var val = [2,6];

	for(var i in val){
		$('.chosen-select-'+val[i]).chosen();
		$('.chosen-select-'+val[i]).trigger("chosen:updated");  
	}
}

function getSever(regionName,siteName){
	var servers = [];
	for(var r in regionSitesServers){
		if('All' == regionName && 'All' == siteName){
			servers.push(regionSitesServers[r].serverName);
		} else if('All'== regionName && regionSitesServers[r].siteName == siteName){
			servers.push(regionSitesServers[r].serverName);
		} else if(regionSitesServers[r].regionName == regionName && 'All' == siteName){
			servers.push(regionSitesServers[r].serverName);
		}  else if(regionSitesServers[r].regionName == regionName && regionSitesServers[r].siteName == siteName){
			servers.push(regionSitesServers[r].serverName);
		}			
	}
	return uniq(servers);
}

function uniq(a) {
	return a.sort().filter(function(item, pos, ary) {
		return !pos || item != ary[pos - 1];
	})
}

function showDetails(row,tr){
	var data = '';
	switch(row.data().alertType){
		case 'CYCLETIME ALERT':	data = cycleTimeHistory(row.index(),row.data());break;
		case 'DOWNTIME ALERT' : data = downTimeHistory(row.data());break;
		case 'CHANGEOVER ALERT' : data = changeOverHistory(row.data());break;		
		case 'YIELD ALERT' : data = yieldHistory(row.index(),row.data());break;		
	}
	
	if(data){
		row.child( data ).show();
		if(row.child().find("td").attr("colspan")=="5"){
			row.child().find("td").attr("colspan","7");
		}
		
		tr.addClass('shown');
	}
	
	if(debug) console.log(row.data().alertType + ":" + ('CYCLETIME ALERT'==row.data().alertType));
	if(debug) console.log(row.data());

	if('CYCLETIME ALERT'==row.data().alertType){
		initDetailChart(row.index(),row.data().detail);
		setRangeButtonListeners(row.index());
	}
	if('YIELD ALERT'==row.data().alertType){
		setCalcNowButtonListeners(row.index());
	}
}

function setRangeButtonListeners(rowIndex){
	
	if(debug) console.log("setRangeButtonListeners for " + rowIndex);

	$('.cycletime-duration-'+rowIndex+' button').off("click").click(function(event){

		event.preventDefault();
		event.stopPropagation();
		
		var thisRowIndex = $(this).parent().attr("data-id");
		
		if(thisRowIndex.indexOf("threshold-")>=0){
			thresholdTableIndex = thisRowIndex.replace("threshold-","");
			var thisRow = thresholdTable.row(thresholdTableIndex);
			var thisRowData = thresholdTable.row(thresholdTableIndex).data();
			var thisRowTr = $( thresholdTable.row(thresholdTableIndex).node() );
			var chartType = "threshold";
		}else{
			var thisRow = notificationsTable.row(rowIndex);
			var thisRowData = notificationsTable.row(rowIndex).data();
			var thisRowTr = $( notificationsTable.row(rowIndex).node() );
			var chartType = "notification";
		}
		
		if(debug) console.log("setRangeButtonListener clicked id:"+thisRowIndex);
		
		$(this).parent().find('button').addClass('btn-white').removeClass('btn');
		$(this).addClass('btn');
		
		if(debug) console.log("Running showDetails");
		
		retrieveDetail(thisRow, thisRowTr, chartType);
	});
	
}


function setCalcNowButtonListeners(rowIndex){
	
	if(debug) console.log("setCalcNowButtonListeners for " + rowIndex);

	$('.calc-now-button-'+rowIndex).off("click").click(function(event){

		event.preventDefault();
		event.stopPropagation();
		
		var rowIndex = $(this).attr("data-id");
		
		if(debug) console.log("rowIndex is " + rowIndex);
		
		var thisRow = notificationsTable.row(rowIndex);
		var thisRowTr = $( notificationsTable.row(rowIndex).node() );
		
		if(debug) console.log("Running retrieveYieldValues");
		
		retrieveDetail(thisRow, thisRowTr, "notification");	
	});
	
}

