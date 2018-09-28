<%@ include file="/html/cycletimeadmin/init.jsp" %>

<portlet:resourceURL var="listURL"/>
<aui:form action="<%=listURL.toString() %>" method="post" name="update"></aui:form>

<portlet:resourceURL var="lURL"></portlet:resourceURL>
<portlet:actionURL var="viewURL"/>

<div class="col-sm-12" id="<portlet:namespace />warning" class="mfg-warning" style="display:none">
	<span class ="badge badge-danger">There was error while save/update. Please contact Administrator.</span>
</div>

<div class="thresholdsAddWrapper row">
	<div class="col-xs-6">
		<h2 class="mfg-portlet-title">Thresholds</h2>
	</div>
    <div class="col-xs-6">
    	<i class="fa fa-caret-down" aria-hidden="true"></i>
    </div>
</div>

<%
	Map<String, String> defaultModel = null ; 
	if(renderRequest.getAttribute("userDefaultModel")!=null){
		defaultModel = (Map<String, String>)renderRequest.getAttribute("userDefaultModel");%>
		<script>
			defRegion = "<%=(defaultModel.get("region")==null) ? "All": defaultModel.get("region") %>";
			defSite = "<%=(defaultModel.get("site")==null) ? "All": defaultModel.get("site") %>";
			defServer = "<%=(defaultModel.get("server")==null) ? "All" : defaultModel.get("server") %>";
		</script>
		<%
	}
%>

<div class="thresholdsHideRow row wrapper" style="display: none;">
	<div id="tableheader" class="main cycletimeadmin-controls-container">	
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
	<div style="padding-top: 20px;">
        <table id="thresholdsTable" cellspacing="0" width="100%"
        	class="table-responsive table-striped table-bordered table-hover dataTable dtr-inline">
            <thead>
            	<tr>               
                    <th colspan="3" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Product</th>
                    <th colspan="2" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Process</th>
                    <th colspan="2" id="nominalCycleTimeCol" style="text-align: center; background-color: #a7a7a7; color: #2f4050;">Cycle Time Threshold<br/>(seconds)</th>
                </tr>
                <tr>               
                    <th>Product Type</th>
                    <th>Product Family</th>
                    <th>Part Number</th>
                    <th>Process</th>
                    <th>Station</th>
                    <th style="width: 100px;">Median</th>
                    <th style="width: 100px;">Manually Set</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th>Product Type</th>
                    <th>Product Family</th>
                    <th>Part Number</th>
                    <th>Process</th>
                    <th>Station</th>
                    <th>Median</th>
                    <th>Manually Set</th>
                </tr>
            </tfoot>
        </table>
	</div>

	<div id='spinner_cycleTime' class="portlet-spinner">
	    <div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
	</div>
</div>
    
<script>

	var regionSiteServerList = JSON.parse('<c:out value="${regionSiteServerList}" escapeXml="false" />');
	var debug = false;
	var regionSitesServers = regionSiteServerList.regionSitesServers;
 	var thresholdTable = null

	$(document).ready(function(){
	    $(".thresholdsAddWrapper").click(function(){
	        if($(".thresholdsAddWrapper").hasClass("open")){
	        	$(this).removeClass("open").find(".fa.fa-caret-down").removeClass("rotate");
	        	$(".thresholdsHideRow").removeClass("open").slideUp(500);
	        }else {
	        	$(this).addClass("open").find(".fa.fa-caret-down").addClass("rotate");
	        	$(".thresholdsHideRow").addClass("open").slideDown(500);
	        }
	    });
	});
	
	function localspinner_cycleTime(selector, method){
		if(debug) console.log(selector+" spinner starts.");
		if("open"==method){
			$(selector).fadeIn(200);
		} else {
			$(selector).fadeOut(200);
		}
	}
	
	function addThresholdColumnSearch(thisthresholdtable){
		thisthresholdtable.columns().every( function () {
            var that = this;  
            $(that.footer()).find('input').on( 'keyup change', function () {
            	
            	if(debug) console.log("addThresholdColumnSearch input event triggered");
            	
                if ( that.search() !== this.value ) {
                	if(debug) console.log(this.value);
                    that
                        .search( this.value )
                        .draw();
                }
            });
        });
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
	function storeCycleTimeDefaultValues(id, value){
		
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

	function updateCycleTimeGridValues(cmd,cmdType,context){
		
		var baseValues = {regionName: $(".cycletimeadmin-controls-container  select[name='region'] option:selected ").val(),siteName : $(".cycletimeadmin-controls-container select[name='site'] option:selected ").val(), serverName: $(".cycletimeadmin-controls-container select[name='server'] option:selected ").val()}
	        
		if(cmd=='update'){
			for(var prop in baseValues){
				context[prop] = baseValues[prop];
				if(debug) console.log("Added prop "+prop+ " to "+ JSON.stringify(context));
			    
			}
			if(context['serverName'] == 'All'){
			    var s = getSever(context['regionName'],context['siteName']);
			    context['serverName']=s.join();
			}
		} else {
		    context = baseValues;
		}
        
		if(debug) console.log("[Thresholds view] updateValues: called with cmd : "+cmd +" cmdType : "+cmdType+" context:"+JSON.stringify(context));
        
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
	        	localspinner_cycleTime("#spinner_cycleTime", 'open');
	        	$('#nominalCycleTimeCol').attr('rowspan', '1');
	        },
	        complete:function(){
	        	localspinner_cycleTime("#spinner_cycleTime", 'close');
	        	$('#nominalCycleTimeCol').attr('rowspan', '2');
	        },
	        success : function(data) {
	            if(debug) console.log(data);
	            if(data.error){
	            	$("#<portlet:namespace />warning").show();
	            	console.log(data.error);
	            } else if(data.msg){
	            	//console.log(data.msg);
	            } else {
	            	thresholdTable.clear();
	            	thresholdTable.rows.add(data).draw();
	            	addThresholdColumnSearch(thresholdTable);
	            }
	        },
	        error : function(response) {
	            console.log("Error seen for updateValues");
	            $("#<portlet:namespace />warning").show();
	        }
        });
    }

	function addThresholdListeners(){
			
		$('#thresholdsTable tbody td').off('click').on('click', function () {
			
			if(debug) console.log("thresholdsTable tbody td clicked. Is this the last column? "+$(this).is(':last-child'));
			
			if(!$(this).is(':last-child')){
				
				//display detail
				
				var tr = $(this).closest('tr');
				var row = thresholdTable.row( tr );
				
				row.indexId = row.index();
				row.index = function(){
					var thisRowIndex=row.indexId+'';
					var res = thisRowIndex.split("-");
					    var length=res.length-1;
					    return "threshold-"+res[length];
					};
				row.dataStore = row.data();
				var thd = new Date();
				row.dataStore["startTimeUTC"] = (thd.getFullYear() +"-"+ (thd.getMonth()+1)  +"-"+ thd.getDate()  +" "+
												thd.getHours() +":"+ thd.getMinutes() +":"+ thd.getSeconds() +".0") ;
				row.dataStore["alertType"] = "CYCLETIME ALERT";
				row.data = function(){return this.dataStore};
				
				if ( row.child.isShown() ) {
					row.child.hide();
					tr.removeClass('shown');
				} else {
					if(row.data()){
						if(row.data().detail){
							if(debug) console.log("showDetails(row,tr);");
							if(debug) console.log("row");
							if(debug) console.log(row);
							showDetails(row,tr);				
						}else{				
							if(debug) console.log("retrieveDetail(row,tr);");
							if(debug) console.log("row");
							if(debug) console.log(row);
							retrieveDetail(row,tr,"threshold");	
						}
					}
				}
	
			}else{
					
				//display detail
				if($(this).children().length ==0 ){
					var val = $(this).html();
					$(this).html('');
					var input = $('<input />');		
					input.val(val);
					input.focusout(function(e){
						updateCycleTime($(this).parent());
					});
					input.keypress(function(e){
						if(e.which == 13 || e.which == 1 ) {
							updateCycleTime($(this).parent());
						}
					});
					input.appendTo(this);
					$($(this).children()[0]).focus();		
				}
	
			}
			
			event.preventDefault();
			event.stopPropagation();
		} );
	}
	
	function updateCycleTime(td) {
		var input = $(td.children()[0])
		var val = Math.round(input.val());

		td.html(val);
		
		var context = thresholdTable.row( $(td).parent() ).data();
		var currentData = val;
		var oldData = context.customCycleTime;
		
		if(debug) console.log("A currentData:"+currentData);
		
		input.remove();
		
		if(isNaN(currentData)){
			td.html('');
			return;
		} 
		
		if(currentData == oldData){
			if(currentData==0){td.html('');} 
			return;
		}

		if(debug) console.log("B currentData:"+currentData);
		
		if(currentData==0){
			td.html('');
			currentData = "";
		} 
		
		if(debug) console.log("C currentData:"+currentData);
		
		if(currentData != ""){		
			
			if(currentData <= 0 || currentData > 9999 ){
				td.html( (oldData == 0 )? '':oldData);
				return;
			}
			td.css('background-color','#B0BED9');
			td.prev().css('background-color','');
		}else{
			td.css('background-color','');
			td.prev().css('background-color','#B0BED9');
		}
		
		if(debug) console.log("D currentData:"+currentData);
		
		context.customCycleTime=currentData
		
		if(debug) console.log("About to trigger updateCycleTimeGridValues with json values of "+JSON.stringify(context));
		updateCycleTimeGridValues('update','',context);
	} 
	
	initCycleTimeAdminLogic(regionSitesServers);
</script>