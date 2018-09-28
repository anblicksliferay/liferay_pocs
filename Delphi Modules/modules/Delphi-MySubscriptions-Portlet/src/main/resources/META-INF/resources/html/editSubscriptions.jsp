<%@ include file="/html/init.jsp" %>

<portlet:resourceURL var="listURL"/>

<aui:form action="<%=listURL.toString() %>" method="post" name="update"></aui:form>

<portlet:renderURL var="generateEnterPhoneURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="jspPage" value="/html/enterPhoneNumber.jsp" />
</portlet:renderURL>

<portlet:resourceURL var="lURL"></portlet:resourceURL>
<portlet:actionURL var="viewURL"/>

<%	
	String actionType = (String)renderRequest.getAttribute("actionType");
	String pushDevice = (String)renderRequest.getAttribute("pushDevice");

	//System.out.println("value of actionType is:"+actionType);
	
	String subscriptionName = "";
	int subscriptionID =0;
	String subscriptionType = "";
	String subscriptionDesc = "";
	int subscriptionInfo = 0;
	int subscriptionWarning = 0;
	int subscriptionCritical = 0;
	
	if(actionType.contains("edit")){
		//System.out.println("Creating object of subscription......");
		Subscription subscription = (Subscription) renderRequest.getAttribute("subscription");
		
		subscriptionName = subscription.getSubscriptionName();
		subscriptionID = subscription.getSubscriptionID();
		subscriptionType = subscription.getSubscriptionType();
		subscriptionDesc = subscription.getSubscriptionDesc();
		subscriptionInfo = subscription.getSubscriptionInfo();
		subscriptionWarning = subscription.getSubscriptionWarning();
		subscriptionCritical = subscription.getSubscriptionCritical();
	}
	else if (actionType.contains("add")){
		subscriptionInfo = Integer.parseInt((String)renderRequest.getAttribute("subscriptionInfo"));
		subscriptionWarning = Integer.parseInt((String)renderRequest.getAttribute("subscriptionWarning"));
		subscriptionCritical = Integer.parseInt((String)renderRequest.getAttribute("subscriptionCritical"));
	}
%>

<script>$(".page-heading h2").html("Add/Edit Alert Subscription")</script>

<div class="row mb-20">
	
	<div class="col-sm-3 return">
		<a href="/group/delphi/alerts-thresholds"><i class="fa fa-arrow-left"></i> Return to Alerts & Thresholds</a>
	</div>
	
	<div class="col-sm-9">
		<div id="<portlet:namespace />warning" style="display:none">
			<span id="warningMsg" class ="badge badge-danger">There was error while save/update. Please contact Administrator.</span>
		</div>
	</div>
	
</div>
	
	<div class="subscriptionAlertsForm" >
		<div class="name">
			<label><span class="red">*</span> Alert Name</label> 
			<input type="text" id="alertName"  style="width:100%;height:34px;padding:3px;" maxlength="35" onkeyup="ValidateAlertName()" />
			<span id="subscriptionNameAlert" class="badge badge-danger"></span>
		</div>
			
		<div class="type">
			<label><span class="red">*</span> Type </label>
			<select id="subType" name="subType" class="chosen-select-alert-type" onChange="displayType()">
				<option>Cycle Time</option>
				<option>Change Over</option>
				<option>Down Time</option>
				<option>Yield</option>
			</select>
			<span id="subscriptionTypeAlet" class="badge badge-danger"></span>
		</div>
		<div class="description">
			<label>Description</label> 
			<textarea type="text" id="description" maxlength="1000" style="width:100%;padding:3px;"></textarea>
		</div>
	</div>
	<div class="name">
			<label><span class="red">*</span> Required</label> 
		</div>
	<table id="moveRows2" class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline" cellspacing="0" role="grid" width="100%" style="width: 100%;">
		<tr role="row">
			<th colspan="5" style="text-align: center; color: #fff; background-color: #2f4050;" rowspan="1">Location</th>
		</tr>
	</table>
	<div class="row" style="margin-bottom: 20px;">
		<div id="tableheader" class="main subscriptions-controls-container">	
			<div class="col-sm-4">
				<label>Region</label>
				<select name="region" class="chosen-select-region"></select>						
			</div>
			<div class="col-sm-4">
				<label><% if(subscriptionID==0){ %><span class="red">*</span><% } %> Site</label>
				<select name="site" class="chosen-select-site"></select>
				<span id="subscriptionSiteAlert" style="display:none;float: left;" class="badge badge-danger"></span>
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
	</div>
<div id="subscription-detail-container" style="display: none;">
	<div style="padding-top: 20px;">
		<div class="mb-10">
			<table id="productProcessTable" class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th id="productProcessTableLabel" colspan="5" style="text-align: center; color: #fff; background-color: #2f4050;">Available Part / Station Pairs</th>
						</tr>
						<tr>					
							<th colspan="3" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Product</th>
							<th colspan="2" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Process</th>
						</tr>
						<tr>					
							<th>Product Type</th>
							<th>Product Family</th>
							<th>Part Number</th>
							<th>Process</th>
							<th>Station</th>
							<th>Region</th>
							<th>Site</th>
							<th>Server</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Product Type</th>
							<th>Product Family</th>
							<th>Part Number</th>
							<th>Process</th>
							<th>Station</th>
							<th>Region</th>
							<th>Site</th>
							<th>Server</th>
						</tr>
					</tfoot>
			</table>
		</div>
		
		<div id='<portlet:namespace />spinner'  class="portlet-spinner">
			<div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
		</div>
	
		<div id="moveRows" class="addRemoveButtons">
			<div class="text-center warning-text">
				<p>Select one or more station records above then click "Add to selection criteria". Use the 'All' button to include all values in a column for the selected records.</p>
			</div>
			<div class="addSubscription">
				<button class="btn btn-primary" disabled="disabled" type="button" id="select"><i class="fa fa-arrow-down" aria-hidden="true"></i> Add to selection criteria</button>
			</div>
			<div class="removeSubscription">
				<button class="btn btn-primary" disabled="disabled" type="button" id="remove"><i class="fa fa-arrow-up" aria-hidden="true"></i> Remove from selection criteria</button>
			</div>
			<div class="row" style="text-align: center;">
				<span id="productProcessTableError" class="badge badge-danger"></span>
			</div>
		</div>
	
		<table id="selectedSubscriptions" class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th id="selectedSubscriptionsLabel" colspan="8" style="text-align: center; color: #fff; background-color: #2f4050;">Transactions in Subscription</th>
				</tr>
				<tr>					
					<th colspan="3" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Product</th>
					<th colspan="2" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Process</th>
					<th colspan="3" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Location</th>
				</tr>
				<tr>					
					<th>Product Type</th>
					<th>Product Family</th>
					<th>Part Number</th>
					<th>Process</th>
					<th>Station</th>
					<th>Region</th>
					<th>Site</th>
					<th>Server</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Product Type</th>
					<th>Product Family</th>
					<th>Part Number</th>
					<th>Process</th>
					<th>Station</th>
					<th>Region</th>
					<th>Site</th>
					<th>Server</th>
				</tr>
			</tfoot>
		</table>
	<span id="subscriptionStationsAlert" style="display:none;clear: both;float: left;" class="badge badge-danger"></span>
		<div class="row" style="text-align: center;">
			<span id="yieldAlertMessage" class="badge badge-danger"></span>
		</div>
		
		<div class="subscriptionAlertsThresholds">
		
 			<div id='<portlet:namespace />mini-spinner'  class="portlet-spinner">
				<div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
			</div> 
			
			<table id="moveRows2" class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline" cellspacing="0" role="grid" width="100%" style="width: 100%;">
				<tr role="row" class="view-yield">
					<th colspan="4" style="text-align: center; color: #fff; background-color: #2f4050;" rowspan="1">Subscription Yield Values - Recalculated Once Each Day Over Last 30 Days of Data</th>
				</tr>
				<tr class="view-cycletime view-downtime view-changeover"
					style="text-align: center; color: #fff; background-color: #2f4050;">
					<th style="text-align: center;">Alert Levels</th>
					<th colspan="3" style="text-align: center;">Notification Methods</th>
				</tr>
				<tr class="view-yield">
					<td style="text-align: center; background-color: #a7a7a7; color: #2f4050; padding: 0; border: none;">
						<table id="yield-alert" class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline">
							<tr>
								<th class="yield-alert-title">Mean Yield</th>
								<th class="yield-alert-title">Standard Deviation</th>
								<th rowspan="2" class="calc-now-wrapper">
									<button class="calc-now-button" onclick="updateYieldValues();">Calculate Now</button>
								</th>
							</tr>
							<tr>
								<td class="calc-now-yield"></td> 
								<td class="calc-now-deviation"></td>
							</tr>
						</table>
					</td>
					<th colspan="3" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Notification Methods</th>
				</tr>
				<tr>
					<th style="text-align: center;">
						<span class="view-yield">Alert Levels calculated relative to Mean Yield using Standard Deviation (SD)</span>
					</th>
					<td class="textCenter">
						<span id="emailCaption">Email</span>
					</td>
					
				<% 
					List<Phone> phones = user.getPhones(); 
					String primaryPhoneNumber = "";
					
					for(Phone phone:phones){
						if(phone.isPrimary()) primaryPhoneNumber = phone.getNumber();
					}
				
					//System.out.println("primaryPhoneNumber:["+primaryPhoneNumber+"]");
					if(primaryPhoneNumber.trim().equals("")){
				%>
				
					<td class="textCenter" id="SMSCaption">
						<span>SMS text message</span>
						<span style="cursor:pointer;color:cadetblue;text-decoration:underline;"
						onclick="getEnterPhonePopup()">Add Phone Number</span>
					</td>
					
				<% }else{ %>
				
					<td class="textCenter" id="SMSCaption">
						<span>SMS text message to </span>
						<span style="cursor:pointer;color:cadetblue;text-decoration:underline;"
						onclick="getEnterPhonePopup()"><%=primaryPhoneNumber %></span>
					</td>
				
				<% } %>
					
					<td class="textCenter">
						<span id="pushCaption">Push Notification</span>
					</td>	
				</tr>
				<tr>
					<td>
						<span>
							<span class="info"></span>
							<span id="subTypeInfo">Info: 10%-20% over threshold</span>
						</span>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkInfoEmail"/>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkInfoSMS"/>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkInfoPush"/>
					</td>
				</tr>
				<tr id="warningRow">
					<td>
						<span>
							<span class="warning"></span>
							<span id="subTypeWarning">Warning: 20%-30% over threshold</span>
						</span>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkWarningEmail"/>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkWarningSMS"/>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkWarningPush"/>
					</td>
				</tr>
				<tr id="criticalRow">
					<td>
						<span >
							<span class="critical"></span>
							<span id="subTypeCritical">Critical: 30%+ over threshold</span>
						</span>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkCriticalEmail"/>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkCriticalSMS"/>
					</td>
					<td class="textCenter">
						<input type="checkbox" id="chkCriticalPush"/>
					</td>
				</tr>
				
			</table>
			<div id="dialog1">You don't have any active device registered to receive push notification.</div>
		</div>
		<div class="saveCancelButtons">
			<div id="savespinner" style="display: none;">
			<div class="spinner-wrapper"> 
			<div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
		</div>
			<span class="required"><span class="red">*</span> Required</span>
			<input type="hidden" name="phoneNumber" id="subscriptionPhoneNumber" value="<%=primaryPhoneNumber %>"/>
			<input class="btn btn-primary" type="button" id="save" value="Save" onclick="return saveSubscription()"/>			
			<input class="btn btn-secondary" type="button" id="cancel" value="Cancel" onclick="cancelCalled()"/>		
		</div>
	</div>
	
	<div class="modal inmodal" id="maximumAdddSubscriptionModal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
		<div class="modal-dialog">
		<div class="modal-content animated bounceInRight">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>													
					<h4 class="modal-title">Exceed Subscription limit</h4>
				</div>
				<div class="modal-body">
					<p>Addition of a subscription with more than 12,000 records is not currently supported.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">Close</button>														
				</div>
			</div>
		</div>
	</div>
</div>
	
<script>
	var debug = false;
	
	var regionSiteServerList = JSON.parse('<c:out value="${regionSiteServerList}" escapeXml="false" />');
	var regionSitesServers = regionSiteServerList.regionSitesServers;
	var actionType="<%= actionType%>";
	var pushDevice="<%= pushDevice%>";
	var table = null;
	var myTable = null;
	
	var subscriptionsTable = null;
	var subscriptionsCurrentData = [];
	
	var selectedSubscriptionsTable = null;
	var editor;
	var rows = []; 
	var duplicateName = false;
	
	$(function() {
		 
        var dialog1 = $("#dialog1");
        var checkbox1 = $("#chkCriticalPush");
        var checkbox2 = $("#chkWarningPush");
        var checkbox3 = $("#chkInfoPush");


        dialog1.dialog({
           autoOpen: false,
           modal: true,
           buttons: {
              Close: function() {$(this).dialog("close");}
           },
           title: "Push Notification Device Not Available",

        });

        checkbox1.click(function() {
           if (checkbox1.prop("checked") && pushDevice === "false") {
               dialog1.dialog("open");
           }
        });
        checkbox2.click(function() {
            if (checkbox2.prop("checked") && pushDevice === "false") {
                dialog1.dialog("open");
            }
         });
        checkbox3.click(function() {
            if (checkbox3.prop("checked") && pushDevice === "false") {
                dialog1.dialog("open");
            }
         });
        
		localSpinner("#<portlet:namespace />mini-spinner", 'close');
     });

	$(".chosen-select-alert-type").chosen({width: "100%","disable_search": true});
	
	function localSpinner(selector, method){
		if(debug) console.log(selector+" spinner starts.");
		if("open"==method){
			$(selector).fadeIn(200);
		} else {
			$(selector).fadeOut(200);
		}
	}
	
	function initializeSubscriptionsTable(data){
		//var server = $(".subscriptions-controls-container select[name='server']").val().trim();
		
		subscriptionsTable = $('#productProcessTable').DataTable( {
			"lengthChange": false,
			data: data,
			columns: [
				{ title: "Product Type" },
				{ title: "Product Family" },
				{ title: "Part Number" },
				{ title: "Process" },
				{ title: "Station" },
				{ title: "Region" },
				{ title: "Site" },
				{ title: "Server" }

			],
			"columnDefs": [
						{
							"targets": [ 5,6,7 ],
							"visible": false,
							"searchable": false
						}],
			select: {
				style: 'os'
			},
			"pagingType": "full_numbers",
			"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		} );
		
		selectedSubscriptionsTable = $('#selectedSubscriptions').DataTable( {
			lengthChange: false,
			data: data,
			columns: [
				{ title: "Product Type" , 
					render : function(data){
						if(data.trim()=="ALL"){
							  return "--";
						}
						else{return data;}
					
					}
				},
				{ title: "Product Family",
                    render : function(data){
					if(data.trim()=="ALL"){
						  return "--";
					}
					else{return data;}
				
				} 
				},
				{ title: "Part Number",
					render : function(data){
						if(data.trim()=="ALL"){
							  return "--";
						}
						else{return data;}
					
					} 
				},
				{ title: "Process",
					render : function(data){
						if(data.trim()=="ALL"){
							  return "--";
						}
						else{return data;}
					
					} 
				},
				{ title: "Station",
					render : function(data){
						if(data.trim()=="ALL"){
							  return "--";
						}
						else{return data;}
					
					} 
				},
				{ title: "Region" },
				{ title: "Site" },
				{ title: "Server",
					render : function(data){
						if(data.trim()=="ALL"){
							  return "--";
						}
						else{return data;}
					
					} 
				}
			],
			select: {
						style: 'os'
					},
					"pagingType": "full_numbers",
					"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
			} );
		$("#productProcessTable_filter").hide();
		$(".sorting_disabled").hide();


		subscriptionsTable.on( 'select', function ( e, dt, type, indexes ) {
		    if ( type === 'row' ) 
				checkButtonStates( $(".addSubscription #select") , subscriptionsTable.rows('.selected').data().length );
		} );

		subscriptionsTable.on( 'deselect', function ( e, dt, type, indexes ) {
		    if ( type === 'row' ) 
				checkButtonStates( $(".addSubscription #select") , subscriptionsTable.rows('.selected').data().length  );
		} );
		
		selectedSubscriptionsTable.on( 'select', function ( e, dt, type, indexes ) {
		    if ( type === 'row' ) 
		    	checkButtonStates( $(".removeSubscription #remove") , selectedSubscriptionsTable.rows('.selected').data().length  );
		} );
		
		selectedSubscriptionsTable.on( 'deselect', function ( e, dt, type, indexes ) {
		    if ( type === 'row' ) 
		    	checkButtonStates( $(".removeSubscription #remove") , selectedSubscriptionsTable.rows('.selected').data().length  );
		} );
	}
	
	function checkButtonStates(el,numberOf){
		//console.log(el+ " : " + numberOf);

		if(numberOf>0){
			el.removeAttr("disabled");
		}else{
			el.attr("disabled","disabled");
		}
	}
	
	function updateSubscriptionsGridValues(cmd,cmdType,context, table, baseValues,tableName){
		//used on initial load of top datagrid
		context = baseValues;
	
		if(debug){ 
			console.log("-----------Start [edit] updateSubscriptionsGridValues Log-----------");
			console.log("Called on "+myTable+" for " + tableName +" with cmd : "+ cmd +" cmdType : "+cmdType+" context:"+JSON.stringify(context) +" mbaseValues: ");
			console.log("----baseValues---");
			console.log(baseValues);
			console.log("----myTable---");
			console.log(myTable);
			console.log("-----------Start [edit] updateSubscriptionsGridValues Log-----------");
		}
		
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
			},
			success : function(data) {
				if(debug) console.log(data);
				if(data.error){
						$("#<portlet:namespace />warning").show();
						console.log(data.error);
				} else if(data.msg){
					//console.log(data.msg);
				}else{
					
					if(data["subscriptionList"]){
						
						if(debug) console.log("subscriptionsCurrentData reload");
						if(debug) console.log(data["subscriptionList"]);
						
						subscriptionsCurrentData = data["subscriptionList"];
						
						selectedSubscriptionsTable.clear();
						selectedSubscriptionsTable.rows.add(data["subscriptionList"]).draw();
						addSubscriptionColumnSearch(selectedSubscriptionsTable);

						for(var j=0;j<selectedSubscriptionsTable.rows().data().length;j++){
							var data1 = selectedSubscriptionsTable.rows(j).data();
							rows.push(data1[0][0] + "|"+ data1[0][1] + "|"+ data1[0][2] + "|"+ data1[0][3] + "|"+ data1[0][4] + "|"+ data1[0][5] + "|"+ data1[0][6] + "|"+ data1[0][7]);
						}
						// updateYieldValues(); 
					}else{
						if(debug) console.log("subscriptionList load");
						if(debug) console.log(data);
						
						subscriptionsCurrentData = data;
						
						subscriptionsTable.clear();
						subscriptionsTable.rows.add(data).draw();
						addSubscriptionColumnSearch(subscriptionsTable);
					}

					checkIfInYield();
					
				}
			},
			error : function(response) {
				console.log("Error seen for updateValues");
				$("#<portlet:namespace />warning").show();
			}
		});
	}
	
	function checkDuplicateAlert(){
	
		var alertName =$.trim($("#alertName").val());
	    if (alertName!="" && alertName.length > 3 && alertName.length <36 ) {
	
		if(debug) console.log("checking duplicacy for alert::"+alertName);
		var alertName = $("#alertName").val();
		var cmd = "checkDuplicateAlert";
		var context = {alertName:alertName};
	
			var cmdType= 'nothing';
		if(debug) console.log("[Subscriptions Edit] checkDuplicateAlertName: called with cmd : "+cmd +"cmdType : "+cmdType+" context:"+JSON.stringify(context));
		
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
					if(data.msg){
						//alert("The subscription name matches a subscription already associated with your login.");
						duplicateName = true;
						$("#subscriptionNameAlert").show();
						$("#subscriptionNameAlert").text("The subscription name matches a subscription already associated with your login.");
						//$('#duplicationNameModal').modal('show');
					}else{
						duplicateName = false;
						$("#subscriptionNameAlert").hide();
					}
			},
			error : function(response) {
					console.log("Error seen for update");						
			}
		});
	    }
	};
	
	function displayType(){
		var subType = $("#subType").val();
		$("#productProcessTableLabel").text("Available Part / Station Pairs");
		$("#selectedSubscriptionsLabel").text("Subscribed Part / Station Pairs");
		setEmailSMSCheckbox('<%= subscriptionInfo %>',$("#chkInfoEmail"),$("#chkInfoSMS"), $("#chkInfoPush"));
		setEmailSMSCheckbox('<%= subscriptionWarning %>',$("#chkWarningEmail"),$("#chkWarningSMS"), $("#chkWarningPush"));
		setEmailSMSCheckbox('<%= subscriptionCritical %>',$("#chkCriticalEmail"),$("#chkCriticalSMS"),$("#chkCriticalPush"));

		$(".view-yield, .view-cycletime, .view-downtime, .view-changeover").hide();
		var rows=selectedSubscriptionsTable.rows().data();
		
		if(subType!="Yield"){
			if(rows.length>10)
				$("#subscriptionStationsAlert").text("").hide();
		}
		if(subType=="Change Over"){
			managePartNumberAll("enable");
			$("#subscription-detail-container, .view-changeover").show();
			$("#yield-alert").hide();
			$("#subTypeCol1").text("Duration exeeds");
			$("#subTypeInfo").text("Info: duration exceeds 60 minutes");
			$("#warningRow").hide();
			$("#criticalRow").hide();
			$("#chkWarningEmail").prop( "checked", false );
			$("#chkWarningSMS").prop( "checked", false );
			$("#chkWarningPush").prop( "checked", false );
			$("#chkCriticalEmail").prop( "checked", false );
			$("#chkCriticalSMS").prop( "checked", false );
			$("#chkCriticalPush").prop( "checked", false );
			$("#yieldAlertMessage").hide();
			checkIfInYield()
		}else if(subType=="Cycle Time"){
			managePartNumberAll("enable");
			$("#subscription-detail-container, .view-cycletime").show();
			$("#yield-alert").hide();
			$("#subTypeCol1").text("Threshholds");
			$("#warningRow").show();
			$("#criticalRow").show();
			$("#subTypeInfo").text("Info: 10%-20% over threshold");
			$("#subTypeWarning").text("Warning: 20%-30% over threshold");
			$("#subTypeCritical").text("Critical: 30%+ over threshold");
			$("#yieldAlertMessage").hide();
			checkIfInYield()
		}else if(subType=="Down Time"){
			managePartNumberAll("enable");
			$("#subscription-detail-container, .view-downtime").show();
			$("#yield-alert").hide();
			$("#subTypeCol1").text("Duration exeeds")
			$("#warningRow").show();
			$("#criticalRow").show();
			$("#subTypeInfo").text("Info: duration exceeds 30 minutes");
			$("#subTypeWarning").text("Warning: duration exceeds 60 minutes");
			$("#subTypeCritical").text("Critical: duration exceeds 120 minutes");
			$("#yieldAlertMessage").hide();
			checkIfInYield();
		}else if(subType=="Yield"){
			$("#subscription-detail-container, .view-yield").show();
			$("#yield-alert").show();
			$("#warningRow").show();
			$("#criticalRow").show();
			$("#productProcessTableLabel").text("Select Transactions");
			$("#selectedSubscriptionsLabel").text("Transactions in Subscription");
			$("#subTypeInfo").html("Info: 1 x SD below mean yield = <span class='calc-now-info'></span>"); // Dynamic information in place of percentange
			$("#subTypeWarning").html("Warning: 1.5 x SD below mean yield = <span class='calc-now-warn'></span>"); // Dynamic information in place of percentange
			$("#subTypeCritical").html("Critical: 2 x SD below mean yield = <span class='calc-now-error'></span>"); // Dynamic information in place of percentange

			checkIfInYield();
			// updateYieldValues();
			managePartNumberAll("disable");
			/* $(".calc-now-button").off("click").on("click",function(){
				updateYieldValues();
			}); */
			if(rows.length>10)
				$("#subscriptionStationsAlert").text("Subscription has more than the allowed 10 \"Transactions in Subscription\" records. Use the \"Remove from Selection Criteria\" button to remove records. You may be able to combine several records by using the use  \"All\" buttons to include transactions without regard to some values.").show();
			else if(rows.length!=0)
				$("#subscriptionStationsAlert").text("").hide();
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
	
	function getMultiRowValue(regionName,siteName){
		var servers = [];
		for(var r in regionSitesServers){
			if(regionSitesServers[r].regionName == regionName && regionSitesServers[r].siteName == siteName){
				servers.push(regionSitesServers[r].serverName);
			}			
		}
		return servers;
	}
	
	function uniq(a) {
		return a.sort().filter(function(item, pos, ary) {
			return !pos || item != ary[pos - 1];
		})
	}
	
	function  getEmailSMSSubscription(objectEmail, objectSMS, objectPush){
		var returnValue =0;
		var emailValue = 0;
		var smsValue=0;
		var pushValue=0;
		if($(objectEmail).prop("checked")==true){
			emailValue=1;
		}
		if($(objectSMS).prop("checked")==true){
			smsValue=2;
		}
		if($(objectPush).prop("checked")==true){
			pushValue=4;
		}
		returnValue = emailValue + smsValue + pushValue;
		return returnValue;	
	};

	function validateForm(){
		var returnVal = true;
		
		if(duplicateName)
			returnVal = false;
		
		var alertName = $.trim($("#alertName").val());
		var site = $("select[name='site'] option:selected" ).val();
		var subType = $("#subType").val();
		if($("#subscriptionPhoneNumber").val()=="" && 
				($("#chkInfoSMS").is(":checked") || $("#chkWarningSMS").is(":checked") || $("#chkCriticalSMS").is(":checked"))){
			getEnterPhonePopup();
			returnVal = false;
		}
		if (alertName.length==0)
			$("#subscriptionNameAlert").text("Please Enter Alert Name ").show();
		else if(alertName.length<=3)
			$("#subscriptionNameAlert").text("Alert name should be more than 3 characters").show();
		else if (alertName.length >=35)
			$("#subscriptionNameAlert").text("Enter a shorter subscription name. Maximum subscription name length is 35 characters.").show();
		else
			$("#subscriptionNameAlert").text("").hide();
		
		<% if(subscriptionID==0){ %>
			if(site=="All")
				$("#subscriptionSiteAlert").text("Please Select Site").show();
			else
				$("#subscriptionSiteAlert").text("").hide();
		<% } %>
		if (subType==null)
			$("#subscriptionTypeAlet").text("Please Select Type").show();
		else
			$("#subscriptionTypeAlet").text("").hide();
		
		var rows=selectedSubscriptionsTable.rows().data();
		
		if(rows.length==0)
		    $("#subscriptionStationsAlert").text("Please select atleast one record for subscription").show();
		else if(rows.length>10 && subType=="Yield")
			$("#subscriptionStationsAlert").text("Subscription has more than the allowed 10 \"Transactions in Subscription\" records. Use the \"Remove from Selection Criteria\" button to remove records. You may be able to combine several records by using the use  \"All\" buttons to include transactions without regard to some values.").show();
		else
			$("#subscriptionStationsAlert").text("").hide();

		if(returnVal==true)
		   returnVal = false;
		if($("#subscriptionNameAlert").text()!="")
	    	$("#alertName").focus();
		<% if(subscriptionID==0){ %>else if(site=="All")
			$("select[name='site']").focus();<% } %>
		else if (subType==null)
		     $("#subscriptionTypeAlet").focus();
		else if($("#subscriptionStationsAlert").text()!="")
		     $("#subscriptionStationsAlert").focus();
		else
			returnVal = true;
		return returnVal;
	};
	
	function saveSubscription(){
		//console.log('in function saveSubscription');
		if(validateForm()==false) 	return false;
		
		var subscriptionID = <%= subscriptionID %>;
		
		if(debug){
			console.log("--baseValues--");
			console.log(getBaseValues());
		}

		if(subscriptionID==0) {
			addSubscription(getBaseValues());
		} else {
			editSubscription(getBaseValues());
		}
		
	}
	
	function getBaseValues(){

		var baseValues = {regionName: $(".subscriptions-controls-container select[name='region'] option:selected ").text(),siteName : $(".subscriptions-controls-container select[name='site'] option:selected ").text(), serverName: $(".subscriptions-controls-container select[name='server'] option:selected ").text(), subscriptionName:$("#alertName").val(),subscriptionType:$(".subscriptionAlertsForm select[name='subType'] option:selected ").text(), subscriptionDesc:$("#description").val()}
		//var infoEmail= getEmailSMSSubscription($("#chkInfoEmail"), $("#chkInfoSMS"));
		
		baseValues['infoNotify'] = getEmailSMSSubscription($("#chkInfoEmail"), $("#chkInfoSMS"), $("#chkInfoPush"));
		baseValues['warningNotify'] = getEmailSMSSubscription($("#chkWarningEmail"), $("#chkWarningSMS"), $("#chkWarningPush"));
		baseValues['criticalNotify'] = getEmailSMSSubscription($("#chkCriticalEmail"), $("#chkCriticalSMS"), $("#chkCriticalPush"));
		baseValues['productType'] = selectedSubscriptionsTable.columns( 0 ).data()[0];
		baseValues['productFamily'] = selectedSubscriptionsTable.columns( 1 ).data()[0];
		baseValues['partNumber'] = selectedSubscriptionsTable.columns( 2 ).data()[0];
		baseValues['processNames'] = selectedSubscriptionsTable.columns( 3 ).data()[0];
		baseValues['stationNames'] = selectedSubscriptionsTable.columns( 4 ).data()[0];
		baseValues['regionNames'] = selectedSubscriptionsTable.columns( 5 ).data()[0];
		baseValues['siteNames'] = selectedSubscriptionsTable.columns( 6 ).data()[0];
		baseValues['serverNames'] = selectedSubscriptionsTable.columns( 7 ).data()[0];

		for(k in baseValues){
			for(i=0;i<baseValues[k].length;i++){
				if("--"==baseValues[k][i])baseValues[k][i]="ALL";
			}
		}
		return baseValues;
	}
	
	function editSubscription(baseValues){
		var subId = <%= subscriptionID %>;
		baseValues['subscriptionId'] = subId;
		addUpdateSubscription("update","update",baseValues);
	}
	
	function addSubscription(baseValues){
		addUpdateSubscription("add","",baseValues);
	};
	
	function addUpdateSubscription(cmd,cmdType,context){
		//used to save data on add click
		if(debug) console.log("[Subscriptions Edit] addUpdateSubscription: called with cmd : "+cmd +"cmdType : "+cmdType+" context:"+JSON.stringify(context));
		if(debug) console.log("Printing url:"+'<%=listURL.toString()%>');
		
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
			},
			success : function(data) {
					if(debug) console.log(data);
					if(data.error){
						$("#<portlet:namespace />warning").show();
						console.log(data.error);
					} else if(data.msg){
						$("#savespinner").show();
						var pageLocation=location.href.split("?")[0].split("/");
						window.location.href = pageLocation[pageLocation.length-1]+"?msgUpdate=1";
					}
			},
			error : function(response) {
					console.log("Error seen for updateValues");
					$("#<portlet:namespace />warning").show();
			}
		});
	}
			
	function setEmailSMSCheckbox(notificationVal, chkEmail, chkSMS, chkPush ){
		if(notificationVal==1){
			$(chkEmail).prop( "checked", true );
		}else if(notificationVal==2){
			$(chkSMS).prop( "checked", true );
		}else if(notificationVal==3){
			$(chkEmail).prop( "checked", true );
			$(chkSMS).prop( "checked", true );
		}else if(notificationVal==4){
			$(chkPush).prop( "checked", true );
		}else if(notificationVal==5){
			$(chkEmail).prop( "checked", true );
			$(chkPush).prop( "checked", true );
		}else if(notificationVal==6){
			$(chkSMS).prop( "checked", true );
			$(chkPush).prop( "checked", true );
		}else if(notificationVal==7){
			$(chkEmail).prop( "checked", true );
			$(chkSMS).prop( "checked", true );
			$(chkPush).prop( "checked", true );
		}
	}		
	
	function populateEditData(){
	
		$("#alertName").val('<%= subscriptionName %>');
		$("#subType").val('<%= subscriptionType %>');
		$('#subType option:contains(Base)').prop('selected','selected');
		$('#subType').trigger('chosen:updated');
		$("#description").val('<%= subscriptionDesc %>');
		
		setEmailSMSCheckbox('<%= subscriptionInfo %>',$("#chkInfoEmail"),$("#chkInfoSMS"), $("#chkInfoPush"));
		setEmailSMSCheckbox('<%= subscriptionWarning %>',$("#chkWarningEmail"),$("#chkWarningSMS"), $("#chkWarningPush"));
		setEmailSMSCheckbox('<%= subscriptionCritical %>',$("#chkCriticalEmail"),$("#chkCriticalSMS"),$("#chkCriticalPush"));
		displayType();
		
		//below populate the bottom grid to show selected part numbers for this alert.
		//updateSubscriptionsGridValues("update","",baseValues); 
		var baseValues = <%= subscriptionID %>;
		if(baseValues==0)
			baseValues=-1;
		updateSubscriptionsGridValues('update','','',subscriptionsTable,baseValues,"selectedSubscriptionsTable");
	}
	
	function cancelCalled(){
		var pageLocation=location.href.split("?")[0].split("/"); 
		window.location.href = pageLocation[pageLocation.length-1]
	};
	
	function getEnterPhonePopup(){
		AUI().use('aui-base',
				'aui-io-plugin-deprecated',
				'liferay-util-window', 
				
			function(A) {
				var popUpWindow=Liferay.Util.Window.getWindow({
						id:'phoneNumberPopup',
						dialog: {
							centered: true,
							constrain2view: true,
							align: {
										node: null,
										points: ['tc', 'tc']
									},
							modal: true,
							cache: false,
							width:550,
							height:250,										
							destroyOnClose: true,	
						}
					}
				).plug(A.Plugin.IO,{
						autoLoad: false
					}).render();
					
				popUpWindow.show();
				popUpWindow.titleNode.html("Please enter your primary phone number for SMS messaging.");
				popUpWindow.io.set('uri',"<%=generateEnterPhoneURL%>");
				popUpWindow.io.start();
	
		});
	}
	
	function storePhoneNumber(phoneNumber){
	
		phoneNumber = phoneNumber.trim();
		$("#subscriptionPhoneNumber").val(phoneNumber);
		
		var cmd = 'phone';
		var cmdType= 'update';
		var context = {"phoneNumber":phoneNumber};		
				
		if(phoneNumber!=""){
			$("#SMSCaption").html("<span>SMS text message to </span><span style='cursor:pointer;color:cadetblue;text-decoration:underline;' onclick='getEnterPhonePopup()'>"+phoneNumber+"</span>");
		}else{
			$("#SMSCaption").html("<span>SMS text message </span><span style='cursor:pointer;color:cadetblue;text-decoration:underline;' onclick='getEnterPhonePopup()'>Add Phone Number</span>");
		}	
		
		$.ajax({  
				url : '<%=listURL.toString()%>',
				data : {
					<portlet:namespace />cmd: cmd,
					<portlet:namespace />cmdType: cmdType,
					<portlet:namespace />context: JSON.stringify(context)
				},
	
				type : "POST",
				dataType : "json",
				success : function(data) {
					//console.log("returned");
					//console.log(data);
					//$(".modal-content .close.btn").trigger("click");
					var dialog = Liferay.Util.getWindow("phoneNumberPopup");
					dialog.destroy(); // You can try toggle/hide whatever You want
				},
				error : function(response) {
					console.log("Error seen for Phone Update Response");
				}
		});
	}
	function ValidateAlertName(){
		var alertName = $.trim($("#alertName").val());
        if (alertName.length==0)
			$("#subscriptionNameAlert").text("Please Enter Alert Name ");
		else if(alertName.length<=3)
			$("#subscriptionNameAlert").text("Alert name should be more than 3 characters").show();
		else if (alertName.length >=35)
			$("#subscriptionNameAlert").text("Enter a shorter subscription name. Maximum subscription name length is 35 characters.");
		else{
		   $("#subscriptionNameAlert").hide();	
		   checkDuplicateAlert();
		}
   }
	function updateYieldValues(){
		
		
		
        var rows=selectedSubscriptionsTable.rows().data();
		
		if(rows.length==0)
		    $("#subscriptionStationsAlert").text("Please select atleast one record for Calculate").show();
		else if(rows.length>10)
			$("#subscriptionStationsAlert").text("Subscription has more than the allowed 10 \"Transactions in Subscription\" records. Use the \"Remove from Selection Criteria\" button to remove records. You may be able to combine several records by using the use  \"All\" buttons to include transactions without regard to some values.").show();
		else
			$("#subscriptionStationsAlert").text("").hide();
		
		if(rows.length!=0 && rows.length<11){
			var cmd = 'calculateYield';
			var cmdType= '';
			var context = getBaseValues();
			$("#<portlet:namespace />warning").hide();
			$.ajax({
					url : '<%=listURL.toString()%>',
					data : {
						<portlet:namespace />cmd: cmd,
						<portlet:namespace />cmdType: cmdType,
						<portlet:namespace />context: JSON.stringify(context)
					},
					beforeSend:function(){
						localSpinner("#<portlet:namespace />mini-spinner", 'open');
					},
					complete:function(){
						localSpinner("#<portlet:namespace />mini-spinner", 'close');
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
	
						if(data.yieldInfo){
							var returnYieldVals = data.yieldInfo;
							
							keys = Object.keys(returnYieldVals);
							for(var i=0;i<keys.length;i++){
								//if(debug) console.log(keys[i]+" value:"+returnYieldVals[keys[i]]);
								$("."+keys[i]).text(returnYieldVals[keys[i]]+"%");
								$("#yieldAlertMessage").hide();
							};
						}
						else {
							$(".calc-now-yield, .calc-now-deviation").text("");
							$("#yieldAlertMessage").text("There are no transactions selected by your current subscription definition over the last 30 days.").show();
							
						}
						
					},
					error : function(response) {
						console.log("Error seen for updateYieldValues Response");
						$("#<portlet:namespace />warning").show();
					}
			});
	 }	
		
	}
	
	function checkIfInYield(){
		if($("#subType").val()=="Yield" || $("#subType").val()=="Down Time"){
			forcePartAll();
			filterSubscriptionData();
			//updateYieldValues();
		}
		else{
			filterSubscriptionData();
		}
	}
	
	function managePartNumberAll(statsu){
		if(statsu=="disable")
			$(".subscription-select-all[data-type='Part Number']").attr("disabled","disabled");
		else
			$(".subscription-select-all[data-type='Part Number']").removeAttr("disabled");
	}
	function forcePartAll(){
		if(!$(".subscription-select-all[data-type='Part Number']").hasClass("selected")){
			$(".subscription-select-all[data-type='Part Number']").trigger('click');
		}
	}

	function filterSubscriptionData(){

	   var filteredSubscriptionData = JSON.parse(JSON.stringify(subscriptionsCurrentData));
	   
	   for(i=0;i<filteredSubscriptionData.length;i++){
		   filteredSubscriptionData[i][7] = "--";
		   $(".subscription-select-all.selected").each(function(){
			   var thisColumnIndex = $(this).parent().index();
			   filteredSubscriptionData[i][thisColumnIndex] = "--";
		   });
	   }
	   
	   //filter duplicates
	   var subscriptionUniqueOptions = {};
	   var filteredUniqueSubscriptionData = [];
	   
	   for(i=0;i<filteredSubscriptionData.length;i++){
		   var keyValue = JSON.stringify(filteredSubscriptionData[i]);
		   if(!subscriptionUniqueOptions[keyValue]){
			   subscriptionUniqueOptions[keyValue]=true;
			   filteredUniqueSubscriptionData.push(filteredSubscriptionData[i]);
		   }
	   }
	   
	   if(debug) console.log(filteredUniqueSubscriptionData);
	   
	   subscriptionsTable.clear();
	   subscriptionsTable.rows.add(filteredUniqueSubscriptionData).draw();
	}
	
	initMySubscriptionsLogic(regionSitesServers);
	populateEditData();
	
</script>