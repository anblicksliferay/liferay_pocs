<%@ include file="/html/mynotification/init.jsp" %>

<portlet:resourceURL var="notificationURL"/>
<portlet:resourceURL var="listURL"/>

<portlet:renderURL var="generateNotificationsPopupURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/html/mynotification/popup.jsp" />
</portlet:renderURL>

<span class="hidden mfg-alert-container" id="mfg-alert-container">
	<span>
		<span class="mfg-alert crit" data-level="crit" title="Critical Alert">&nbsp;</span>
	</span>
	<span>
		<span class="mfg-alert warn" data-level="warn" title="Warning Alert">&nbsp;</span>
	</span>
	<span>
		<span class="mfg-alert info" data-level="info" title="Informational Alert">&nbsp;</span>
	</span>
	<span style="display: none;" class="server-data-warning" style="">notification updates are not available</span>
	<div class="mfg-alert-container-dropdown" style="display:none"><%@ include file="/html/mynotification/popup.jsp" %></div>
</span>

<script>

	var miniTable;
	var iniMiniTable = false;
	var activeFilter = "";
	var filteredNotificationData = [];

	$(function(){
		$(".page-heading .rightSection .mfg-alert-container, .page-heading.visible-xs .mfg-alert-container").remove();
		
		$(".page-heading .rightSection").append( $(".mfg-alert-container").removeClass('hidden') );
		$(".page-heading.visible-xs").append( $(".mfg-alert-container").clone() );
		
		$(".mfg-alert-container > span").off("click").on("click",function(){
			getAuiNotificationsPopup();
			$(".mfg-alert-container-dropdown").slideToggle(150);
		});
		
		$("#mini-close i").off("click").on("click",function(event){
			$(".mfg-alert-container-dropdown").slideUp(150);
			event.preventDefault();
			event.stopPropagation();
		});
		
		updateMiniNotifications();
		setInterval(updateMiniNotifications,20*1000);
		updateMiniNotificationsPopupGrid();
	});
	
	function getAuiNotificationsPopup() {
		updateMiniNotificationsPopupGrid();
	}
	
	function customSorting(){
		$.fn.dataTable.ext.type.order['level-duration-pre'] = function ( d ) {
			var sortValue = 0;
			var levels = d.split(' ');
		
			if(levels[0]=='Critical'){
				sortValue = 130000000;
				
			} else if(levels[0]=='Warn'){
				sortValue = 120000000;
			}else if(levels[0]=='Info') {
				sortValue = 110000000;
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
		};
	}
	
	function initializeMiniTable(data){
		customSorting();
		
		miniTable = $('.myNotificationPopupTableGrid').DataTable( {
	       data: data,
	       order: [[2, 'asc'],[1, 'desc'] ],
	       "pageLength": 5,
	       columnDefs:[
				{
    				targets: [0,1,2,3],
					"visible": false
    				
				},
				{
					"targets": 4,
					type: "level-duration",
					"createdCell": function (td, cellData, rowData, row, col) {
						//console.log("mini rowData.status:"+rowData.status);
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
				}
			],
	       columns: [
	 	       { data: "alertType"},
	 	      	{ 
					data: "date", 
					render : function(data){ 
						if(undefined!=data) return data;
					}
				},
	        /*    { data: "station" },
	            { data: "partNumber" }, */
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
				
	           { data: "deviation" },
	           { data: "level", render : function(data, type, full, meta){

						if(undefined!=data){
							data = data.charAt(0).toUpperCase() + data.slice(1);
							data = data.replace("Critical","").replace("Info","").replace("Warn","");
						}
						
						if (full.alertType == 'CHANGEOVER ALERT'){
							icon = "<i class='fa fa-cogs'></i> "+data;
						}else if(full.alertType == "DOWNTIME ALERT"){
							icon = "<i class='fa fa-arrow-circle-down'></i> "+data;
						}else if(full.alertType == "YIELD ALERT"){
							icon = "<i class='fa fa-percent'></i> "+data;
						} else {
							icon = "<i class='fa fa-clock-o'></i> "+data;
						}

						var fmt='';
						
						if(full.duration){
							var duration = JSON.parse(full.duration);
							if(duration.days >0){
								var days = parseInt(duration.days);
								if(parseInt(duration.hours)>12) days++;
								fmt+= days + "D ";
								//fmt+= (days>1)? 'D days ':' day ';
							}else if(duration.hours >0){
								var hours = parseInt(duration.hours);
								if(parseInt(duration.minutes)>30) hours++;
								fmt+= hours + "h ";
								//fmt+= (hours>1)? ' hours ':' hour ';
							}else if(duration.minutes >0){
								var minutes = parseInt(duration.minutes);
								if(parseInt(duration.seconds)>30) minutes++;
								fmt+= minutes + "m ";
								//fmt+= (minutes>1)? ' minutes ':' minute ';
							}else{
								var seconds = parseInt(duration.seconds);
								fmt+= seconds + "s ";
								//fmt+= (seconds>1)? ' seconds ':' second ';
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
	           }
	       ]
	   } );
		
		iniMiniTable = true;

		$('.myNotificationPopupTableGrid tbody').on('click', 'tr', function () {
	       var tr = $(this).closest('tr');
	       var row = miniTable.row( tr );
	       var JSONObject = JSON.parse(row.data().duration);
	       var numOfDays=JSONObject["days"]+1;
	       if(numOfDays==4)
	    	   numOfDays=7;
	       else if(numOfDays==8)
	    	   numOfDays=30;
	    location.href="/group/delphi/alerts-thresholds?partNumber=".concat(row.data().partNumber)+"&process=".concat(row.data().process)+"&station=".concat(row.data().station)+"&numOfDays=".concat(numOfDays); 
	   } );
		
	}
	
	var isUpdateOver = true;
	
	function updateMiniNotifications(){
		if(isUpdateOver == false){
			return;
		}
		var cmd = 'count';
       
		$.ajax({  
				url : '<%=notificationURL.toString()%>',
				data : {
				    <portlet:namespace />cmd: cmd
				},
				type : "POST",
				dataType : "json",
				beforeSend:function(){isUpdateOver = false;},
                complete:function(){isUpdateOver = true;},
				success : function(data) {
				   if(data.error){
						//$("#warning").show();
						console.log("Connection error: "+data.error);
						$(".mfg-alert.crit, .mfg-alert.warn, .mfg-alert.info").hide();
						$(".server-data-warning").show();
					} else{

						$(".mfg-alert.crit, .mfg-alert.warn, .mfg-alert.info").show();
						$(".server-data-warning").hide();
						$(".mfg-alert.crit").text(data.crit);
						$(".mfg-alert.warn").text(data.warn);
						$(".mfg-alert.info").text(data.info);
						
						$(".mfg-alert-container").fadeIn();
					}				  
				},
				error : function(response) {
				   console.log("Error seen for updateValues");
				}
		});
	}

	function updateMiniNotificationsPopupGrid(){
		setInterval(function(){
		           $(".table-responsive.myNotificationPopupTable").parent().parent().parent().addClass("myMiniNotificationPopupWrapper");
		},250);

        var context = {};

        var cmd = 'list';
        var cmdType= 'NONE';

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
				$("#<portlet:namespace />spinner-mini").show();
				},
            complete:function(){
            	$("#<portlet:namespace />spinner-mini").hide();
            	},
			success : function(data) {
			   if(data.error){
			         console.log(data.error);
			    } else{
			   	filteredNotificationData = filterNotificationData(data.notifications);

                    if(miniTable && iniMiniTable){
                    	miniTable.clear();
                        miniTable.rows.add(filteredNotificationData).draw();
                    }else{
    			   		initializeMiniTable(filteredNotificationData);
                    }
                    
			   }
			},
			error : function(response) {
			   console.log("Error seen for updateValues");
			}
        });
    }
	
	function filterNotificationData(notificationData){
		
		if(activeFilter=="") return notificationData;
		
		var filteredData = [];
		for(i=0;i<notificationData.length;i++){
		  if(notificationData[i]["alertType"]==activeFilter)
		     filteredData.push(notificationData[i]);
		}
		
		return filteredData;
	}
	
	function filterGrid(el,filter){
		
		if($(el).hasClass("selected")){
			$(".miniLegend span").removeClass("selected");
			activeFilter = "";
		}else{
			$(".miniLegend span").removeClass("selected");
			activeFilter = filter;
			$(el).addClass("selected");
		}
		
		updateMiniNotificationsPopupGrid();
	}
	
</script>