function initCycleTimeAdminLogic(regionSitesServers){
	
	initializeCycleTimeTable([]);
	
	$(".cycletimeadmin-controls-container .chosen-select-server").chosen({width: "100%"});
	
	var regions = getRegions(regionSitesServers);
	var selectRegion= $(".cycletimeadmin-controls-container select[name='region']");

	for (var i = 0; i < regions.length; i++) {
		if($.trim(regions[i])!=""){
		    selectRegion.append($("<option></option>").attr("value", regions[i]).text(regions[i]));
		}
	}
	
	$(".cycletimeadmin-controls-container .chosen-select-region").chosen({width: "100%"});
	$(".cycletimeadmin-controls-container select[name='region']").val(defRegion);
	$(".cycletimeadmin-controls-container select[name='region']").trigger("chosen:updated");

	populateSites(defRegion);
	$(".cycletimeadmin-controls-container .chosen-select-site").chosen({width: "100%"});
	
	function populateSites(regionName){
		$(".cycletimeadmin-controls-container select[name='site'] option" ).remove();
		var region = null;
		var selectSite= $(".cycletimeadmin-controls-container select[name='site']");
		var sites = getSite(regionName);
		for (var i = 0; i < sites.length; i++) {
			if($.trim(sites[i])!=""){
			     selectSite.append($("<option></option>").attr("value", sites[i]).text(sites[i]));
			}
		}
		$(".cycletimeadmin-controls-container select[name='site']").val(defSite);
		$(".cycletimeadmin-controls-container .chosen-select-site").trigger("chosen:updated");	
		populateCycleTimeServer(regionName,defSite);
	}

	function populateCycleTimeServer(regionName,siteName){
	    $(".cycletimeadmin-controls-container select[name='server'] option" ).remove();
	    var server= $(".cycletimeadmin-controls-container select[name='server']");
	    var servers = getSever(regionName,siteName);
	
		server.append($("<option></option>").attr("value", 'All').text('All'));
	    for (var i = 0; i < servers.length; i++) {
	    	if($.trim(servers[i].split(".")[0])!=""){
	              server.append($("<option></option>").attr("value", servers[i]).text(servers[i].split(".")[0]));
	    	}
	    }
		$(".cycletimeadmin-controls-container select[name='server']").val(defServer);
	    $(".cycletimeadmin-controls-container .chosen-select-server").trigger("chosen:updated");  
	    updateCycleTimeGridValues('list');  
	}
	
	$(".cycletimeadmin-controls-container select[name='region']").on("change",function(){		
			var regionId = $(".cycletimeadmin-controls-container select[name='region'] option:selected ").val();
			populateSites(regionId);
			storeCycleTimeDefaultValues("region",regionId);
	});
	
	$(".cycletimeadmin-controls-container select[name='site']").on("change",function(){			
		var onchangesite = $(".cycletimeadmin-controls-container select[name='site'] option:selected" ).val();
		populateCycleTimeServer($(".cycletimeadmin-controls-container select[name='region'] option:selected" ).val(),$(".cycletimeadmin-controls-container select[name='site'] option:selected" ).val());
		storeCycleTimeDefaultValues("site",onchangesite);
	});
	
	$(".cycletimeadmin-controls-container select[name='server']").on("change",function(){			
		updateCycleTimeGridValues('list');
		var onchangeserver = $(".cycletimeadmin-controls-container select[name='server'] option:selected" ).val();
		storeCycleTimeDefaultValues("server",onchangeserver);
	});
	
	 $('#thresholdsTable tfoot th').each( function (index) {
	    var title = $(this).text();
	   	if(index  < 5) $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	} );
	
	function initializeCycleTimeTable(data){
	
		thresholdTable = $('#thresholdsTable').DataTable( {
	    	lengthChange: false,
	    	pagingType: "full_numbers",
	        data: data,
			drawCallback: function( settings ) {
            	addThresholdListeners();
			},
	        columns: [
	            { 
	            	title: "Product Type",
	            	data: "productType"
	            },
	            { 
	            	title: "Product Family",
	            	data: "productFamily"
	            },
	            { 
	            	title: "Part Number",
	            	data: "partNumber"
	            },
	            { 
	            	title: "Process",
	            	data: "process"
	            },
	            { 
	            	title: "Station",
	            	data: "station"
	            },
	            { 	
	            	title: "Calculated",
	            	orderable: false,
	            	data: "defaultCycleTime"
	            },
	            { 
	            	title: "Manually Set",
	            	orderable: false,
	            	data: "customCycleTime"
	            },
	            { 
	            	data: "site"
	            },
	            { 
	            	data: "region"
	            }
	        ],
			columnDefs: [{
					"targets": 5,
					"createdCell": colorTd											     
				},
				{
					"targets": 6,
					"createdCell": colorTd											     
				},{
					"targets": [7,8],
					"visible": false
				}
			]
	    } );
	    $("#thresholdsTable_filter").hide();
	    $(".sorting_disabled").hide();
	}
	
	function colorTd (td, cellData, rowData, row, col) {
		if(debug) console.log(col+" : "+rowData["defaultCycleTime"]+":"+rowData["customCycleTime"]);
		if(col == 5 && rowData["defaultCycleTime"] > 0){
			$(td).css('background-color', '#B0BED9');
		}
		if(col == 6 && rowData["customCycleTime"] > 0){
			$(td).css('background-color', '#B0BED9');
			$(td).prev().css('background-color','');
		}	
		if(cellData <= 0){
			$(td).html('');
		}
	}

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
			if(regionSitesServers[r].regionName == regionName){
				sites.push(regionSitesServers[r].siteName);
			}			
		}
		return uniq(sites);
	}

}