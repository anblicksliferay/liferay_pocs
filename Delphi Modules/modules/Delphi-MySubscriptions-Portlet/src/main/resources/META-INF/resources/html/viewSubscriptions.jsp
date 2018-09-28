<%@ include file="/html/init.jsp" %>

<portlet:resourceURL var="listURL"/>
<portlet:resourceURL var="lURL"/>

<portlet:actionURL var="viewURL"/>
<portlet:actionURL var="deleteSubscription" name="deleteSubscription"/>
<portlet:actionURL var="addSubscription" name="addSubscription" windowState="maximized"/>
<portlet:actionURL var="editSubscription" name="editSubscription" windowState="maximized"/>


<form name="editForm" id="editForm" action="<%=editSubscription.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>subscriptionid" name="<portlet:namespace/>subscriptionid"/>
	<input type="hidden" id="<portlet:namespace/>subscriptionName" name="<portlet:namespace/>subscriptionName"/>
	<input type="hidden" id="<portlet:namespace/>subscriptionDesc" name="<portlet:namespace/>subscriptionDesc"/>
	<input type="hidden" id="<portlet:namespace/>subscriptionType" name="<portlet:namespace/>subscriptionType"/>
	<input type="hidden" id="<portlet:namespace/>subscriptionInfo" name="<portlet:namespace/>subscriptionInfo"/>
	<input type="hidden" id="<portlet:namespace/>subscriptionWarning" name="<portlet:namespace/>subscriptionWarning"/>
	<input type="hidden" id="<portlet:namespace/>subscriptionCritical" name="<portlet:namespace/>subscriptionCritical"/> 
</form>

<form name="deleteForm" id="deleteForm" action="<%=deleteSubscription.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>subid" name="<portlet:namespace/>subid"/>
</form> 

<%
	String subscriptions = (String)renderRequest.getAttribute("subscriptions");
	//String username = (String)renderRequest.getAttribute("userName");
	com.liferay.portal.kernel.json.JSONObject regionSiteServerList = (com.liferay.portal.kernel.json.JSONObject)renderRequest.getAttribute("regionSiteServerList");
	
	String url = PortalUtil.getCurrentURL(request); 
 %>

<div class="subscriptionsAddWrapper delphiHeader row">
<%if(url.contains("msgUpdate")) {%>
<div class="portlet-msg-success" >Your request completed successfully </div>
<%} %>

	<div class="col-xs-6">
		<h2 class="mfg-portlet-title">Subscriptions: <span class="user-subscription-count"></span></h2>
	</div>
	<div class="col-xs-3">
		<label for="switch">All Off/On</label>
		<input type="checkbox" id="all-subscriptions" class="js-switch" name="switch" />
	</div>
	<div class="col-xs-3">
		<aui:form method="post" action="<%=addSubscription.toString()%>" name="addSubscription" id="addSubscription">
			<i class="fa fa-caret-down" aria-hidden="true"></i>
			<a class="addSubscriptionA">
				<i class="fa fa-plus-circle fa-2x" aria-hidden="true" title="Add Subscription"></i>
			</a>
		</aui:form>
	</div>
</div>

<div class="subscriptionHideRow row" style="display: none;">
	
	<div id="viewSubscriptionsTableWrap"></div>
	
	<div id="confirmDelete" style="background-color:#ffffff">
		<p>Confirm Delete</p>
	</div>
	
	<div id='<portlet:namespace />spinner' class="portlet-spinner">
		<div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
	</div>
</div>

<script>
	var debug = false;
	var subscriptions =  <%= subscriptions %>;
	var regionSiteServerList = <%= regionSiteServerList %>;
	var activeSubscriptionFilters = {};
	var subscriptionsTable;
		
	for(i=0;i<subscriptions.length;i++){
		if(subscriptions[i][subscriptions[i].length-1]=="true"){
			$("#all-subscriptions").attr("checked","checked");
			break;
		}
	}
	
	function localSpinner(selector, method){
		if(debug) console.log(selector+" spinner "+method+".");
		if("open"==method){
			$(selector).fadeIn(200);
		} else {
			$(selector).fadeOut(200);
		}
	}

	function addSubscriptionColumnSearch(myTable){
		myTable.columns().every( function () {
			var that = this;	
			$( 'input', this.footer() ).on( 'keyup change', function () {
				if ( that.search() !== this.value ) {
					that
					.search( this.value )
					.draw();
				}
			} );
		} );
	}

	function setSubscriptionCounts(){
		
		var countJSON = "{}";
		var countData = "{}";
		
		try{
			if($("#notifications-context .alert-count").length==1){
				countJSON = $("#notifications-context .alert-count").text( );
			}else{
				var configObj = $("#notifications-context .alert-count")[0];
				countJSON = $(configObj).text( );
			}
			
			countData = JSON.parse(countJSON);
		}catch(error){
			console.log("Unable to parse count")
		}
		
		$(".active-alerts").text(0);
		
		for (var k in countData){
		    if (typeof countData[k] !== 'function') {
		    	
		         if(debug) console.log("key is " + k + ", value is" + countData[k]);
		         $(".active-alerts").each(function(){
					if($(this).attr("data-id")==k) 
						$(this).text( countData[k] );
		         });
		    }
		}
	}

	function checkForSubscriptionSwitches(){
		$(".js-switch:visible").each(function() {
			var switchery = new Switchery( this ,{ color: '#1AB394',size: 'small' });
		});
	}
	
	function setRecordControls(){
		if(debug) console.log("setRecordControls called");
		
		$('#viewSubscriptionsTable tbody .filterControl').off('click').on('click', function () {
			if(debug) console.log("clicked a filter with alert name of "+$( this ).find("i").attr("sub-id"));
			$( this ).toggleClass("active");
			
			if($( this ).hasClass("active")){
				addSelectedFilter( $( this ).find("i").attr("sub-id") );
			}else{
				removeSelectedFilter( $( this ).find("i").attr("sub-id") );
			}
			try{
				updateNotificationsTableView();
			}catch(error){
				console.log("unable to run updateNotificationsTableView();");
			}
			
		} ); 
		
		$('#viewSubscriptionsTable tbody .editControl').off('click').on('click', function () {

			console.log(this);
			
			var data = subscriptionsTable.row( this ).data();
			
			if(debug) console.log("Clicked row data is:");
			if(debug) console.log(data);
			
			$('#<portlet:namespace/>subscriptionType').val(data[1]);
			$('#<portlet:namespace/>subscriptionid').val(data[0]);
			$('#<portlet:namespace/>subscriptionName').val(data[8]);
			$('#<portlet:namespace/>subscriptionDesc').val(data[7]);
			$('#<portlet:namespace/>subscriptionInfo').val(data[4]);
			$('#<portlet:namespace/>subscriptionWarning').val(data[5]);
			$('#<portlet:namespace/>subscriptionCritical').val(data[6]); 
			$('#editForm').submit();
		} );
		
		$('#viewSubscriptionsTable tbody .deleteControl').off('click').on('click', function () {
			var data = subscriptionsTable.row( this ).data();
			$('#<portlet:namespace/>subid').val(data[0]);
			if(debug) console.log("opening dialog");
			$( "#confirmDelete" ).dialog( "open" );
		} ); 
		
		$('#viewSubscriptionsTable tbody .onOffNotification').off('change').on('change', function () {
			console.log("Change Clicked");
			var td = $(this).parent();
			var data = subscriptionsTable.row( td ).data();
			var subId = data[0];
			var onOffNotification = td.find('input')[0].checked
			if(debug) console.log("onOffNotification : "+onOffNotification);
			update("onOffNotification",{onOffNotification:onOffNotification,subId:subId});
		} ); 
		
		$('.subscriptionsAddWrapper .switchery.switchery-small').off('click').on('click', function (event) {
			if(debug) console.log("User Clicked #all-subscriptions");
			
			isActive = !checkSwitchState(this);
			if(debug) console.log("onAllOffNotification isActive:"+isActive);
			
			update("onAllOffNotification",{onAllOffNotification:isActive});

			for(i=0;i<subscriptions.length;i++){
				subscriptions[i][subscriptions[i].length-1] = isActive+"";
			}
			
			subscriptionsTable.destroy(); //removes data but keeps HTML in DOM
			drawSubscriptionTable();
			
			event.stopPropagation();
		} );
	}
	
	function initMySubscriptions(){
		if(debug) console.log("initMySubscriptions()");
		
		$(".subscriptionsAddWrapper").click(function(){
			if($(".subscriptionsAddWrapper").hasClass("open")){
				$(this).removeClass("open").find(".fa.fa-caret-down").removeClass("rotate");
				$(".subscriptionHideRow").removeClass("open").slideUp(500);
			}else {
				$(this).addClass("open").find(".fa.fa-caret-down").addClass("rotate");
				$(".subscriptionHideRow").addClass("open").slideDown(500);
				checkForSubscriptionSwitches();
			}
		});
		
		$(".user-subscription-count").text(subscriptions.length);
		
		drawSubscriptionTable();
		 
		localSpinner("#<portlet:namespace />spinner", "close");
		
	};
	
	function drawSubscriptionTable(){
		
		$('#viewSubscriptionsTable').remove(); //remove HTML from DOM
		$('#viewSubscriptionsTableWrap').html('<table id="viewSubscriptionsTable" class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline" cellspacing="0" width="100%"></table>'); //build table

		subscriptionsTable = $('#viewSubscriptionsTable').DataTable( {
			data: subscriptions,
			stateSave: true,
			drawCallback: function( settings ) {
				checkForSubscriptionSwitches();
				setRecordControls();
				setSubscriptionCounts();
			},
			autoWidth: false,
			columns: [
					{ title: "Alert ID" },
					{ 
						title: 			"Alert Type",
						className:		"alertType"
					},
					{ title: "Active Alerts" },
					{ 
						title: 			"Filter Alerts by Subscription",
						className:		'filterControl'
					},
					{ title: "Alert Info" },
					{ title: "Alert Warn" },
					{ title: "Alert Crit" },
					{ title: "Alert Desc" },
					{ title: "Alert Name" },
					{	
						title:			'Edit',
						className:		'editControl',
						orderable:		true,
						data:			null,
						defaultContent: '<i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i>'
					}, {
						title:			'Delete',
						className:		'deleteControl',
						orderable:		true,
						data:			null,
						defaultContent: '<i class="fa fa-trash-o fa-lg" aria-hidden="true"></i>'
					},{
						title:			'Active',
						className:		'onOffNotificationTd',
						visible: 		true,
						orderable:		true,
						data:			null,
						defaultContent:	""
					}
				],
				"columnDefs": [
				{
					"targets": [ 0,4,5,6,7 ],
					"visible": false
				}, {			
					"targets": 1,
					"width":"10%",
					"createdCell": function (td, cellData, rowData, row, col) {		
						var icon = $("<i class='fa fa-clock-o'></i>");
						
						if (rowData[1] == 'Cycle Time'){
							icon = $("<i class='fa fa-clock-o'></i>");
						}else if (rowData[1] == 'Change Over'){
							icon = $("<i class='fa fa-cogs'></i>");
						}else if(rowData[1] == "Down Time"){
							icon = $("<i class='fa fa-arrow-circle-down'></i> ");
						}else if(rowData[1] == "Yield"){
							icon = $("<i class='fa fa-percent'></i> ");
						}
						
						$(td).html("").append(icon);
						return '';
					}
				}, {			
					"targets": 2,	
					"width":"10%",
					"createdCell": function (td, cellData, rowData, row, col) {							
						var countTarget = $('<span sub-id="'+rowData[0]+'" data-id="'+rowData[8]+'" class="active-alerts active-alerts-'+rowData[0]+'"></span>');	
						countTarget.appendTo(td);
						return '';
					}
				}, {			
					"targets": 3,
					"width":"10%",
					"createdCell": function (td, cellData, rowData, row, col) {							
						var filter = $('<i class="fa fa-filter" sub-id="'+rowData[0]+'" data-id="'+rowData[8]+'"></i>');	
						filter.appendTo(td);
						return '';
					}
				}, {		
					"targets": [9,10],	
					"width":"10%",
				}, {			
					"targets": 11,	
					"width":"5%",
					"createdCell": function (td, cellData, rowData, row, col) {							
						var input = $('<input  type="checkbox" class="js-switch js-check-change onOffNotification"/>');	
		
						if(debug) console.log(cellData);
						if(cellData[9] == "true"){
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
	}
	
	function checkSwitchState(element){
		if(debug) console.log("checkSwitchState returns:"+$(element).find("small").css("left"))
		return ("0px"==$(element).find("small").css("left"))?false:true;
	}
	
	$("#confirmDelete").dialog({
   		height:'130',
   		width:'250',
   		modal: true,
   		autoOpen: false,
   		draggable: false,
		buttons: {
			"Delete": function() {
				$( this ).dialog( "close" );
				$('#deleteForm').submit();
			},
			"Cancel": function() {
				$( this ).dialog( "close" );
			},
		}
   	});

	function addSelectedFilter(filterName){
		activeSubscriptionFilters[filterName]=true;
	}
	
	function removeSelectedFilter(filterName){
		delete activeSubscriptionFilters[filterName];
	}
	
	function update(cmd,context){
		var cmdType= 'nothing';
		if(debug) console.log("[Subscription view] update: called with cmd : "+cmd +"cmdType : "+cmdType+" context:"+JSON.stringify(context));
		
		$.ajax({  
				url : '<%=lURL.toString()%>',
				data : {
					<portlet:namespace />cmd: cmd,
					<portlet:namespace />cmdType: cmdType,
					<portlet:namespace />context: JSON.stringify(context)
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

	$(".addSubscriptionA").on("click",function(event){
		event.stopPropagation();
		document.getElementById("<portlet:namespace />addSubscription").submit();
	});

	initMySubscriptions();
	
</script>