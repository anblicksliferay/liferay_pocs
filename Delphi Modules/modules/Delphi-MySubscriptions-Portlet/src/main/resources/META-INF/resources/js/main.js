function portletContext(selector){
	return $("#subscriptions-context ."+selector).text();
}

function initMySubscriptionsLogic(regionSitesServers){

	var debug = false;
	var actionType = '';
	initializeSubscriptionsTable([]);
	var regions = getRegions(regionSitesServers);
	var subscriptionFormElement = ".subscriptions-controls-container ";

	var selectRegion = $(subscriptionFormElement+ " select[name='region']");
	//selectRegion.append($("<option></option>").attr("value", 'All').text('All'));
	selectRegion.append($("<option></option>").attr("value", 'All').text('Select Region'));
	for (var i = 0; i < regions.length; i++) {
		if($.trim(regions[i])!=""){
		    selectRegion.append($("<option></option>").attr("value", regions[i]).text(regions[i]));
		}
	}
	
	populateSites('All');
	$(subscriptionFormElement+ " [class^=chosen-select]").chosen({width: "100%"});
	
	function populateSites(regionName){
		$(subscriptionFormElement+ " select[name='site'] option" ).remove();
		var region = null;
		var selectSite= $(subscriptionFormElement+ " select[name='site']");
		var sites = getSite(regionName);
		selectSite.append($("<option></option>").attr("value", 'All').text('Select Site'));
		for (var i = 0; i < sites.length; i++) {
			if($.trim(sites[i])!=""){
			    selectSite.append($("<option></option>").attr("value", sites[i]).text(sites[i]));
			}
		}
		
		$(subscriptionFormElement+ " .chosen-select-site").trigger("chosen:updated");	
		populateSubscriptionsServer(regionName,'All');
	}
	
	function populateRegions(siteName){
	
		if(debug) console.log("populateRegions testing against: ["+siteName+"] ");
		var regionName="All";
		
		for(var r in regionSitesServers){
			if(debug) console.log(regionSitesServers[r]);
			if(	regionSitesServers[r].siteName == siteName && 
				undefined != regionSitesServers[r].regionName){
			 
				regionName = regionSitesServers[r].regionName;
				if(debug) console.log(regionName)
				break;
			}		
		}
		/*$(subscriptionFormElement+ " select[name='region'] option" ).remove();
		var selectRegion = $(subscriptionFormElement+ " select[name='region']");
		selectRegion.append($("<option></option>").attr("value", regionSitesServers[r].regionName).text(regionSitesServers[r].regionName));
		selectRegion.append($("<option></option>").attr("value", 'All').text('Select Region'));
		var regions = getRegions(regionSitesServers);
		
		for (var i = 0; i < regions.length; i++) {
			if(regions[i]!=regionName && $.trim(regions[i])!=""){
			selectRegion.append($("<option></option>").attr("value", regions[i]).text(regions[i]));
			}
		}*/
		var selectRegion = $(subscriptionFormElement+ " select[name='region']");
		selectRegion.val(regionName).find("option[value=" + regionName +"]").attr('selected', true);
		$(subscriptionFormElement+ " .chosen-select-region").trigger("chosen:updated");  
		
		populateSubscriptionsServer(regionName,siteName);
		
		/*$(subscriptionFormElement+ " select[name='server'] option" ).remove();
		var server = $(subscriptionFormElement+ "select[name='server']");
		var servers = getSever(regionName,siteName);
	
		server.append($("<option></option>").attr("value", 'All').text('All'));
		for (var i = 0; i < servers.length; i++) {
			if($.trim(servers[i].substr(0,servers[i].indexOf(".")))!=""){
			    server.append($("<option></option>").attr("value", servers[i]).text(servers[i].substr(0,servers[i].indexOf("."))));
            }
		}
		
     	$(subscriptionFormElement+ " .chosen-select-server").trigger("chosen:updated");  

		var baseValues = {regionName: regionName,siteName : siteName, serverName: $(subscriptionFormElement+ " select[name='server'] option:selected ").text()};
		updateSubscriptionsGridValues('list','','',subscriptionsTable,baseValues);  */
	}
	
	function populateSubscriptionsServer(regionName,siteName){
		$(subscriptionFormElement+ " select[name='server'] option" ).remove();
		var server = $(subscriptionFormElement+ "select[name='server']");
		var servers = getSever(regionName,siteName);
	
		server.append($("<option></option>").attr("value", 'All').text('All'));
		
		for (var i = 0; i < servers.length; i++) {
          if($.trim(servers[i].substr(0,servers[i].indexOf(".")))!=""){
			server.append($("<option></option>").attr("value", servers[i]).text(servers[i].substr(0,servers[i].indexOf("."))));
		 }
		}
		
		$(subscriptionFormElement+ " .chosen-select-server").trigger("chosen:updated");  
		var baseValues = {regionName: $(subscriptionFormElement+ " select[name='region'] option:selected ").text(),siteName : $(subscriptionFormElement+ " select[name='site'] option:selected ").text(), serverName: $(subscriptionFormElement+ " select[name='server'] option:selected ").val()};
		updateSubscriptionsGridValues('list','','',subscriptionsTable,baseValues);  
	}
	
	$(subscriptionFormElement+ " select[name='region']").on("change",function(){		
		var regionId = $(subscriptionFormElement+ " select[name='region'] option:selected ").val();

		populateSites(regionId);
	});
	
	$(subscriptionFormElement+"select[name='site']").on("change",function(){
		var site=$("select[name='site'] option:selected" ).val();
			if(site=="All")
				$("#subscriptionSiteAlert").text("Please Select Site").show();
			else
				$("#subscriptionSiteAlert").text("").hide();
		populateRegions(site);
		checkIfInYield();
	});
	
	$(subscriptionFormElement+" select[name='server']").on("change",function(){			
		var baseValues = {regionName: $(subscriptionFormElement+ " select[name='region'] option:selected ").text(),siteName : $(subscriptionFormElement+ " select[name='site'] option:selected ").text(), serverName: $(subscriptionFormElement+ " select[name='server'] option:selected ").val()};
		updateSubscriptionsGridValues('list','','',subscriptionsTable,baseValues); 
		checkIfInYield();
	});
	
	$('#productProcessTable tfoot th').each( function (index) {
		var title = $(this).text();
		if(index  < 5) $(this).html( '<input type="text" placeholder="Search '+title+'" /><button data-type="'+title+'" class="subscription-select-all">All</button>' );
	
		$(".subscription-select-all").off("click").on("click",function(){
		   $(this).toggleClass("selected");
		   
		   if(debug) console.log("User clicked All on column:" + $(this).parent().index());
		  
		   filterSubscriptionData();
		});
	
	} );
	
	
	$('#selectedSubscriptions tfoot th').each( function (index) {
		var title = $(this).text();
		if(index  < 8) $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	} );
	
	if( actionType === "edit"){
		$("#subType").prop('disabled', true).trigger("chosen:updated");
		populateEditData()
	}else{
		$("#subType").prop('disabled', false).trigger("chosen:updated");
	};
	
	$('#select').click( function () {
		//console.log( table.rows('.selected').data().length +' row(s) selected' );
	
			$("#select").prop('disabled', true);
			var data = subscriptionsTable.rows('.selected').data();
			if(data.length > 12000){
				$('#maximumAdddSubscriptionModal').modal('show');
				$("#select").prop('disabled', false);
				return;
			}
			
			//$("#"+portletNamespace+"spinner").dialog('open');
			localSpinner("#" + portletContext("portlet-namespace") + "spinner", "open");
			
			var server = $(".subscriptions-controls-container select[name='server'] option:selected ").text();
				for(var i=0;i<data.length;i++){
					if(server ===  "All"){
					   data[i][7]="--";
					}
					else{
						data[i][7]=server;
					}
				}
			rows=selectedSubscriptionsTable.rows().data();
			if(rows.length==0){
				if(debug) console.log("Adding rows in one go....");
				//rows = data;
				//selectedSubscriptionsTable.dataTable().fnAddData(data);
				selectedSubscriptionsTable.rows.add(subscriptionsTable.rows('.selected').data()).draw(); 
				
				//$("#"+portletNamespace+"spinner").dialog('close');
				localSpinner("#"+portletContext("portlet-namespace") + "spinner", "close");
				
			}else{
				if(debug) console.log("Adding rows in else condition......");
				
				setTimeout(function(){
					
					if(debug) console.log("Starting after 1 second");
	
					for(var i=0;i<data.length;i++){
						var tempString =data[i]; //[0] + "|"+ data[i][1] + "|"+ data[i][2] + "|"+ data[i][3] + "|"+ data[i][4] + "|"+ data[i][5] + "|"+ data[i][6] + "|"+ data[i][7];
						var recordExist=0;
						for(var m=0;m<rows.length;m++){
							for(var j=0;j<=7;j++){
								if(rows[m][j]=="ALL")
									rows[m][j]="--";
							}
							if(rows[m]==$.trim(tempString))
							   recordExist=1;
						}
						if (recordExist==0)
						{
							
						//}else{
							//rows.push(data[i][0] + "|"+ data[i][1] + "|"+ data[i][2] + "|"+ data[i][3] + "|"+ data[i][4] + "|"+ $("#region").val() + "|"+ $("#site").val() + "|"+ $("#server").val());
							//rows.push(tempString);
							selectedSubscriptionsTable.row.add( [
																data[i][0],
																data[i][1],
																data[i][2],
																data[i][3],
																data[i][4],
																data[i][5],
																data[i][6],
																data[i][7]
														] ).draw( false );
						}
						
					}
					
						//$("#"+portletNamespace+"spinner").dialog('close');
						localSpinner("#"+portletContext("portlet-namespace")+"spinner", "close");
					
				},50);
			}
			var subType = $("#subType").val();
			var rows=selectedSubscriptionsTable.rows().data();
			if(rows.length>10 && subType=="Yield")
				$("#subscriptionStationsAlert").text("Subscription has more than the allowed 10 \"Transactions in Subscription\" records. Use the \"Remove from Selection Criteria\" button to remove records. You may be able to combine several records by using the use  \"All\" buttons to include transactions without regard to some values.").show();
			else if(rows.length>0)
				$("#subscriptionStationsAlert").text("").hide();
			
			$("#select").prop('disabled', false);
	} );
	
	$('#remove').click( function () {
		var data = selectedSubscriptionsTable.rows('.selected').data();
		var rows=selectedSubscriptionsTable.rows().data();
		if(debug) console.log("Number of rows::"+data.length);
		for(var i=0;i<data.length;i++){
			if(debug) console.log("value if i::"+i);
			var tempString =data[i];//[0] + "|"+ data[i][1] + "|"+ data[i][2] + "|"+ data[i][3] + "|"+ data[i][4] + "|"+ data[i][5] + "|"+ data[i][6] + "|"+ data[i][7];
			var j = rows.indexOf(tempString);
			//console.log("string found out::"+j)
			if(j != -1) {
				rows.splice(j, 1);
			}
		}
		
		selectedSubscriptionsTable.rows('.selected').remove().draw( false );
		var rowsData=selectedSubscriptionsTable.rows().data();
		var subType = $("#subType").val();
		if(rowsData.length==0)
			$("#subscriptionStationsAlert").text("Please select atleast one record for subscription").show();
		else if(rowsData.length<11 && subType=="Yield")
			$("#subscriptionStationsAlert").text("").hide();
	});
	/////new end
	
	//Adds an alert to the end of selectedSubscriptions table
	$('#selectedSubscriptions').append('<tr><td colspan="8" style="text-align:center;"><span id="productProcessTableError" class="badge badge-danger"></span></td></tr>');

	function getRegions(regionSitesServers){
		var regions =[];
		for(var r in regionSitesServers){
			regions.push(regionSitesServers[r].regionName);
		}
		return uniq(regions);
	}

	function getSite(regionName){
	
		var sites = [];
		for(var r in regionSitesServers){
			if(regionName=='All'){
				sites.push(regionSitesServers[r].siteName);
			}else if(regionSitesServers[r].regionName == regionName){
				sites.push(regionSitesServers[r].siteName);
			}			
		}
		return uniq(sites);
	}
	
	function getSever(regionName,siteName){
		var servers = [];
		for(var r in regionSitesServers){
			if(regionSitesServers[r].regionName == regionName && regionSitesServers[r].siteName == siteName){
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
	
}