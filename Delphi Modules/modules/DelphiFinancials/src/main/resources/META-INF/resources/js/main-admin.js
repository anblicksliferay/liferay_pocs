function dashBoardAdminInit(url,portletNameSpace){
	
	debug=false;
	holiday=[];
	var weekend = [];
	var	adminDebug=true;
	var preMonth = $('[name="adminMonth"]').val();
	var	preYear  = $('[name="adminYear"]').val();
	var workDays = 0;
	var option ={};
	
	option.beforeShowDay = function(d){
		for(var i = 0; i< holiday.length;i++){
			if(holiday[i] == d.getDate()){
				return [true, 'ui-state-holiday',''];
			}
		}
		for(var i = 0; i< weekend.length;i++){
			if(weekend[i] == d.getDate()){
				return [true, 'ui-state-holiday',''];
			}
		}
		
		return [true,'',''];
	}
	
	option.onSelect  = function( dateText,  inst ){

		if(debug) console.log(inst);
		if(debug) console.log("option.onSelect filled with "+workDays+":"+holiday.length);
		
		setTimeout(function(){
			var displayValue = $(".ui-datepicker-calendar td").not(".ui-datepicker-unselectable, .ui-state-holiday").length;
			$('#workDays').text(displayValue + " Working Days");
		},100);
		
		for(var i = weekend.length - 1; i >= 0; i--) {
			if(weekend[i] === inst.currentDay) {		   
			   return;
			}
		}
		for(var i = holiday.length - 1; i >= 0; i--) {
			if(holiday[i] === inst.currentDay) {				
			   holiday.splice(i, 1);
			   return;
			}
		}
		holiday.push(inst.currentDay);
	}
	$( "#adminDatepicker" ).datepicker(option);
		
		
	this.showTotalField= function (categoryId,t){
		for(var i=1;i <=6;i++){
			var attr = "total_"+i;
			var selector = 'input[name='+attr+']';
			$(selector).hide();
		}
		var attr = "total_"+categoryId;
		var selector = 'input[name='+attr+']';
		$(selector).show();
		$('.tablinks.active').removeClass('active');
		$(t).addClass('active');
	}
		
	function showCalendar(){
		
		var month = getMonthDays($("#dashboardAdminForm select[name='adminMonth']").val());
	    var year = $("#dashboardAdminForm select[name='adminYear']").val();
		var maxDays = new Date(year,month+1,0).getDate();
		var today = new Date(year,month+1,1);
		workDays = getWorkDays(today.getDay(),maxDays);
		//$('#workDays').text(workDays+" Working Days");
		$( "#adminDatepicker" ).datepicker('option','minDate', new Date(year,month,1));
		$( "#adminDatepicker" ).datepicker('option','maxDate', new Date(year,month,maxDays));
		weekend = [];
		$( "#adminDatepicker" ).find('.ui-datepicker-week-end').each(
			function(i,e){
				if(!$(e).hasClass('ui-datepicker-other-month')){
					$(e).addClass('ui-state-holiday');
					var d = $(e).find('a').text();
					if(d){weekend.push(d)};
				}			
			}		
		);

		setTimeout(function(){
			var displayValue = $(".ui-datepicker-calendar td").not(".ui-datepicker-unselectable, .ui-state-holiday").length;
			$('#workDays').text(displayValue + " Working Days");
		},100);
	}
	
	function getWorkDays(firstDay,maxDays){
		if(firstDay == 0){
			firstDay= 6
		}else{
			firstDay--;
		}
		var weekend = Math.floor(maxDays/7) *2;
		var remainder = maxDays%7;
		if((remainder+firstDay) == 6){
			weekend+=1
		}else if((remainder+firstDay) == 7){
			weekend+=2
		}else if((remainder+firstDay) > 7){
			weekend+=1
		}
			
		console.log(firstDay+":"+maxDays+":"+weekend+":"+(maxDays - weekend));
		return (maxDays - weekend);
	}
	
	function getMonthDays(month) {
	  var months = [
	    'January',
	    'February',
	    'March',
	    'April',
	    'May',
	    'June',
	    'July',
	    'August',
	    'September',
	    'October',
	    'November',
	    'December'
	  ];
		
	  for(var i = 0; i< months.length; i++){
		  if(months[i] == month){
			  return i;
		  }
	  }
	  return -1;
	}
	this.enableSubmitBtn = function (){
		var enable = true;
		for(var i=1;i <=6;i++){
			var attr = "total_"+i;
			var selector = 'input[name='+attr+']';
			$(selector).each(function(){
				//var value = this.value.replace(/\D/g,'');
				if(isNaN(this.value) || this.value==""){
					value = this.value.replace(/\D/g,'');
				}else if(this.value==0){
					value = 1;
				}
				else{
					value = Math.round(this.value);
				}
				if(!value){
					enable = false;
				}
			});

		}
		if(enable){
			$("#diaglog_submit_btn").button( "enable" );
		}else{
			$("#diaglog_submit_btn").button( "disable" );
		}
	}
	function submitTotal(){
		var context={};
		context.month = $("#dashboardAdminForm select[name='adminMonth']").val();
		context.year = $("#dashboardAdminForm select[name='adminYear']").val();
		context.siteid = $("#dashboardAdminForm select[name='adminSiteId']").val();
		context.holiday=holiday;
		context.total=[];
		for(var i=1;i <=6;i++){
			var attr = "total_"+i;
			var selector = 'input[name='+attr+']';
			$(selector).each(function(){
				var rpdpId = this.id.split('_')[0];
				var categoryId = this.name.replace(/\D/g,'');				
				console.log('categoryId : '+categoryId);
				context.total.push({rpdpId:rpdpId,value:this.value.replace(/\D/g,''),categoryId:categoryId});	
			});
		}
		
		updateGridValues("update","total",JSON.stringify(context));	
	}
	
	function saveTotal(){
		var context={};
		context.month = $("#dashboardAdminForm select[name='adminMonth']").val();
		context.year = $("#dashboardAdminForm select[name='adminYear']").val();
		context.siteid = $("#dashboardAdminForm select[name='adminSiteId']").val();

		context.holiday=holiday;
		context.total=[];
		for(var i=1;i <=6;i++){
			var attr = "total_"+i;
			var selector = 'input[name='+attr+']';
			$(selector).each(function(){
				var rpdpId = this.id.split('_')[0];
				var categoryId = this.name.replace(/\D/g,'');				
				console.log('categoryId : '+categoryId);
				context.total.push({rpdpId:rpdpId,value:this.value.replace(/\D/g,''),categoryId:categoryId});	
			});
		}
		
		saveGridValues("save","partial",JSON.stringify(context));	
	}
	
	function saveGridValues(cmd,cmdType,context){
		if(adminDebug) console.log("updateValues: called with context:"+context);
		$("#adminWarninig").hide();
		
		var data  = {};
		data[portletNameSpace+'cmd'] = cmd;
		data[portletNameSpace+'cmdType'] = cmdType;
		data[portletNameSpace+'context'] = context;
		
	    $.ajax({  
	    		url : url,
				data : data,
	
				type : "POST",
				dataType : "json",
				beforeSend:function(){$("#adminSpinner").dialog('open');console.time("adminSpinner");},
				complete:function(){ 	$("#successmessage").show(); $("#adminSpinner").dialog('close');console.timeEnd("adminSpinner");},
				success : function(data) {
					console.log("--Result Returned--");
					if(data.msg == 'Data saved'){							
						console.log(data.msg);
					
					}		
				},
				error : function(response) {
		        	console.log("Error seen for updateValues");
		        	$("#adminWarninig").show();
				}
		});
	}
	
	function updateGridValues(cmd,cmdType,context){
		if(adminDebug) console.log("updateValues: called with context:"+context);
		$("#adminWarninig").hide();
		
		var data  = {};
		data[portletNameSpace+'cmd'] = cmd;
		data[portletNameSpace+'cmdType'] = cmdType;
		data[portletNameSpace+'context'] = context;
		
	    $.ajax({  
	    		url : url,
				data : data,
	
				type : "POST",
				dataType : "json",
				beforeSend:function(){$("#adminSpinner").dialog('open');console.time("adminSpinner");},
				complete:function(){$("#adminSpinner").dialog('close');console.timeEnd("adminSpinner");},
				success : function(data) {
					if(adminDebug) console.log("--Result Returned--");
					if(undefined==data.msg){
						preMonth = $('[name="adminMonth"]').val();
						preYear  = $('[name="adminYear"]').val();
						console.time("editableGrid.loadJSONFromString");
						editableGrid.loadJSONFromString(data);
						console.timeEnd("editableGrid.loadJSONFromString");

						console.time("editableGrid.initializeGrid");
						editableGrid.initializeGrid();
						console.timeEnd("editableGrid.initializeGrid");

						console.time("onGridCompletion");
						onGridCompletion(data);
						console.timeEnd("onGridCompletion");
					}else{
						if(data.msg == 'Data is empty'){							
							showPopUpForNulldata(data, false);
						}
						if(data.msg == 'Partial data exist'){	

							var json = JSON.parse(data.data);
					        var mytotal  = []; 
							mytotal = json.total ; 
							var flag=false;
							for(var i = 0; i< mytotal.length; i++){
								
								if(mytotal[i].value=="")
								{   flag=true;
								  	break;
								}
								
							 }
						//	showPopUp(data.data, true);
							showPopUp(data.data, flag);
						}
						
						if(cmd=="update" && cmdType =="total"){
							reloadGrid();
						}						
						if(adminDebug) console.log(data.msg);
					}
				},
				error : function(response) {
		        	console.log("Error seen for updateValues");
		        	$("#adminWarninig").show();
				}
		});
	}

	function resetTotals(){		
         	for(var i=1;i <=6;i++){
			var attr = "total_"+i;
			var selector = 'input[name='+attr+']';
			$(selector).each(function(){
				$('#'+this.id).val('');
			});
		 }
	}
	$("#setTargets").dialog({
         modal: true,
         height:'600',
		 autoOpen: false,
         width:'1000',
         draggable: false,
         close : function(){
				resetTotals();
		 	 	$('[name="adminYear"]').val(preYear);
		 	 	$('[name="adminMonth"]').val(preMonth);
         },
         
         zIndex: 101,
		 buttons: [
			 {
			 	 text:'Cancel',
			 	 click: function() {
			 	 	$(this).dialog("close");
			 	},
				 style:'float:left'
			},
			{
				text:'Submit',
				 disabled: true,
			     id: "diaglog_submit_btn",
				 click: function() {  submitTotal();	
					preYear= $('[name="adminYear"]').val();
		 	 		preMonth = $('[name="adminMonth"]').val();
				 	$(this).dialog("close");},
				 style:'float:right'
			},
			{
				text:'Save',
			     id: "diaglog_save_btn",
				 click: function() {  saveTotal();	
					preYear= $('[name="adminYear"]').val();
		 	 		preMonth = $('[name="adminMonth"]').val();
				 	},
				 style:'float:right'
			}
		]
	});
	
	$("#adminSpinner").dialog({
		 dialogClass: "no-close",
         modal: true,
         height:'100%',
         width:'100%',
		 autoOpen: false,
         draggable: false,
         zIndex: 101
	});
		
	
	function showPopUpForNulldata(data, partial){
		$("#successmessage").hide();
		var title = 'Enter Holidays and Target Values for the Month for '+ $("#dashboardAdminForm select[name='adminSiteId'] option:selected").text();
		$( "#setTargets" ).dialog( "option", "title", title);
		holiday = [];
		for(var i=1;i <=6;i++){
			var attr = "target-total_"+i;
			var selector = 'input[name='+attr+']';
		
			$(selector).val('$0');
		}

		$("#setTargets").dialog('open');
		showCalendar();
		
	}
	function showPopUp(data, partial){
		$("#successmessage").hide();
		var title = 'Enter Holidays and Target Values for the Month for '+ $("#dashboardAdminForm select[name='adminSiteId'] option:selected").text();
		$( "#setTargets" ).dialog( "option", "title", title);
		holiday = [];
		if(partial){ populatePopUpData(data);
		 $("#diaglog_submit_btn").button( "disable" );
		}
		else{populatePopUpData(data);
			$("#diaglog_submit_btn").button( "enable" );	
		}
		
		for(var i=1;i <=6;i++){
			var attr = "target-total_"+i;
			var selector = 'input[name='+attr+']';
		
			$(selector).val('$0');
		}

		$("#setTargets").dialog('open');
		showCalendar();
		
	}
	function populatePopUpData(data){
		//holiday = [10,13, 16, 27];
		console.log("data - " + data);
		var json = JSON.parse(data);
		console.log("json - " + json);

		
		holiday = json.holiday ; 
		console.log("holiday - " + holiday);
		var mytotal  = []; 
		mytotal = json.total ; 
		console.log("total - " + mytotal);
		
		for(var i = 0; i< mytotal.length; i++){
			console.log("mytotal[i].rpdpId - " + mytotal[i].rpdpId);
			console.log("mytotal[i].categoryId - " + mytotal[i].categoryId);
			console.log("mytotal[i].value - " + mytotal[i].value);

			$('#' + mytotal[i].rpdpId + '_total_' + mytotal[i].categoryId).val(mytotal[i].value);
		  
		}
	}
	
	
	
this.openTab = function (evt, expenseId) {

    $("#dashboardAdminForm input[name='expenseId']").val(expenseId);
    reloadGrid();
    
    $(".tablinks").removeClass("active");
    evt.currentTarget.className += " active";
    
}

function splitValues(col){
	var valueToSplit = $(".totals ."+col).val().replace(/\D/g,'');
	
	var context = {};
	context.id=getFirstRowId();
	context.column=col;
	context.rows=getWorkDayList();
	context.value=Math.round( parseInt(valueToSplit) / getWorkDayList().length );
	
	updateGridValues("list","split", JSON.stringify(context) );
}

function getFirstRowId(){
	if( $("#tablecontent tr").length>1 ){
		
		
	   var id = $("#tablecontent tr").eq(1).attr("id");
	   return id.replace("DemoGrid_","");
	}
}

function getWorkDayList(){
	var workdates = [];
	$("#tablecontent tr").each(function(index){ 
	    if( index!=0 && !$(this).hasClass("holiday") && !$(this).hasClass("weekend")  ){
	       workdates.push( $(this).find("td:first-child").text() );
	    }
	 })
	return workdates;
}



function reloadGrid(){
	
	var month = $("#dashboardAdminForm select[name='adminMonth']").val();
	var year = $("#dashboardAdminForm select[name='adminYear']").val();
	var siteId = $("#dashboardAdminForm select[name='adminSiteId']").val();
	var expenseId = $("#dashboardAdminForm input[name='expenseId']").val();
	updateGridValues("list","all","{month='"+month+"',year:"+year+",expenseId:"+expenseId+",siteId="+siteId+"}");
	
}

function applyListeners(){
	$("#dashboardAdminForm select[name='adminSiteId']")
			.on("change",function(){
		$("#dashboardAdminForm").submit();
	});
	
	$("#dashboardAdminForm select[name='adminYear'],#dashboardAdminForm select[name='adminMonth']")
			.on("change",function(){
			
		reloadGrid();
	});

	$(".aui #tableheader input").blur(function(){
		if(isNaN($(this).val())){
			value = $(this).val().replace(/\D/g,'');
		}else{
			value = Math.round($(this).val());
		}
		$(this).val(moneyFormat(value));
	});
}

function toggleHolidayClass(row,bool){
	bool ? $(row).addClass("holiday") : $(row).removeClass("holiday");
	calculateWorkingDays();
}

function onGridCompletion(tableData){
	$("#tablecontent tr .editablegrid-holiday input:checked").parent().parent().addClass("holiday")
	
	calculateWorkingDays();
	totalColumnData(tableData);
}

function totalColumnData(tableData){
	var numberOfColumns = (tableData.metadata.length-3)/2;
	
	while(numberOfColumns>0){
		target = 0;
		actual = 0;
		
		$(tableData.data).each(function(){
			target+=$(this)[0].values["target"+numberOfColumns];
			actual+=$(this)[0].values["actual"+numberOfColumns];
		});
		
		$("input.target"+numberOfColumns).val(moneyFormat(target));
		$("input.actual"+numberOfColumns).val(moneyFormat(actual));
		
		numberOfColumns--;
	}
}

function totalLiveColumnData(index,columns,data){
	
	newval = 0;
	targetColumn = Math.floor((index-1)/2);
	
	$(data).each(function(){
		newval+=parseInt($(this)[0].columns[index]);
	})	
	
	if(index%2){
		$("input.target"+targetColumn).val(moneyFormat(newval));
	}else{
		$("input.actual"+targetColumn).val(moneyFormat(newval));
	}
}

function calculateWorkingDays(){
	var numberOfDays = $("#tablecontent tr").length;
	var numberOfDaysOff = $("#tablecontent tr.weekend, #tablecontent tr.holiday").length;
	
	$(".working-days").html( numberOfDays-numberOfDaysOff-1 );
}

// create our editable grid
var editableGrid = new EditableGrid("DemoGrid", {
	enableSort: true, // true is the default, set it to false if you don't want sorting to be enabled
	editmode: "absolute", // change this to "fixed" to test out editorzone, and to "static" to get the old-school mode
	editorzoneid: "edition" // will be used only if editmode is set to "fixed"
});

// helper function to display a message
function displayMessage(text, style) { 
	$("#message").html("<p class='" + (style || "ok") + "'>" + text + "</p>"); 
} 

// helper function to get path of a demo image
function image(relativePath) {
	return "images/" + relativePath;
}

function moneyFormat(price) {
	var sign="$";
	if("string"==typeof price) price = price.replace(/\D/g,'');
	
	const pieces = parseFloat(price).toFixed(2).split('')
	let ii = pieces.length - 3
	while ((ii-=3) > 0) {
		pieces.splice(ii, 0, ',')
	}
	
	return sign + pieces.join('').replace(/[.][0-9]+$/g,"");
}

// this will be used to render our table headers
function InfoHeaderRenderer(message) { 
	this.message = message; 
};

InfoHeaderRenderer.prototype = new CellRenderer();
InfoHeaderRenderer.prototype.render = function(cell, value) 
{
	if (value) {
		var link = document.createElement("a");
		link.href = "javascript:alert('" + this.message + "');";
		$(link).html("<i class='fa fa-info'></i>");
		cell.appendChild(document.createTextNode("\u00a0\u00a0"));
		cell.appendChild(link);
	}
};  

// this function will initialize our editable grid
EditableGrid.prototype.initializeGrid = function() 
{
	with (this) {
		
		var productSize = (this.columns.length-3)/2;
		
		for(i=1;i<=productSize;i++){

			setCellRenderer("target"+i, new CellRenderer({
				    render: function(cell, value) { cell.innerHTML = moneyFormat(value) ;}
			})); 
			
			setCellRenderer("actual"+i, new CellRenderer({
			    render: function(cell, value) { cell.innerHTML = moneyFormat(value) ;}
			})); 
			
		}
		
		setCellRenderer("day", new CellRenderer({
			    render: function(cell, value) { 

			    	cell.innerHTML = value ;
			    	cell.style.textAlign = "center";
			    	
			    	if(value=="Saturday"||value=="Sunday"){
			    		$(cell).parent().addClass("weekend");
			    	}
			    }
		})); 
		
		// register the function that will handle model changes
		modelChanged = function(rowIndex, columnIndex, oldValue, newValue, row) { 

			/*
			console.log("oldValue");
			console.log(oldValue);
			console.log("newValue");
			console.log(newValue);
			console.log("row");
			console.log($(row));
			console.log($(this)); //EditableGrid
			console.log("rowIndex");
			console.log(rowIndex);
			console.log("columnIndex");
			console.log(columnIndex);
			*/
			
			
			if(isNaN(newValue)){
				newValue = newValue.replace(/\D/g,'');
			}else{
				newValue = Math.round(newValue);
			}
			
			$(row).children(0).get(3).innerHMTL=newValue;
			
			this.setValueAt(rowIndex, columnIndex, newValue);
			
			if("holiday"==this.getColumnName(columnIndex)) toggleHolidayClass(row,newValue);
				
			updateGridValues("update","value","{id:"+this.getRowId(rowIndex)+",column:"+this.getColumnName(columnIndex)+",value:"+newValue+"}");
			
			//displayMessage("Value for '" + this.getColumnName(columnIndex) + "' in row " + this.getRowId(rowIndex) + " has changed from '" + oldValue + "' to '" + newValue + "'");
			
			totalLiveColumnData(columnIndex,this.columns,this.data);
		};

		rowSelected = function(oldRowIndex, newRowIndex) {
			if (oldRowIndex < 0) displayMessage("Selected row '" + this.getRowId(newRowIndex) + "'");
			else displayMessage("Selected row has changed from '" + this.getRowId(oldRowIndex) + "' to '" + this.getRowId(newRowIndex) + "'");
		};
		
		// render the grid (parameters will be ignored if we have attached to an existing HTML table)
		renderGrid("tablecontent", "testgrid", "tableid");
		
	}
};

EditableGrid.prototype.onloadXML = function(url) 
{
	// register the function that will be called when the XML has been fully loaded
	this.tableLoaded = function() { 
		displayMessage("Grid loaded from XML: " + this.getRowCount() + " row(s)"); 
		this.initializeGrid();  
	};

	// load XML URL
	this.loadXML(url);
};

EditableGrid.prototype.onloadJSON = function(url) 
{
	// register the function that will be called when the XML has been fully loaded
	this.tableLoaded = function() { 
		displayMessage("Grid loaded from JSON: " + this.getRowCount() + " row(s)"); 
		this.initializeGrid();
	};

	// load JSON URL
	this.loadJSON(url);
};

EditableGrid.prototype.onloadHTML = function(tableId) 
{
	// metadata are built in Javascript: we give for each column a name and a type
	this.load({ metadata: [
	    { name: "name", datatype: "string", editable: true }
	]});

	// we attach our grid to an existing table
	this.attachToHTMLTable(_$(tableId));
	displayMessage("Grid attached to HTML table: " + this.getRowCount() + " row(s)"); 
	
	this.initializeGrid();
};

EditableGrid.prototype.duplicate = function(rowIndex) 
{
	// copy values from given row
	var values = this.getRowValues(rowIndex);
	values['name'] = values['name'] + ' (copy)';

	// get id for new row (max id + 1)
	var newRowId = 0;
	for (var r = 0; r < this.getRowCount(); r++) newRowId = Math.max(newRowId, parseInt(this.getRowId(r)) + 1);
	
	// add new row
	this.insertAfter(rowIndex, newRowId, values); 
};

reloadGrid();
applyListeners();
}