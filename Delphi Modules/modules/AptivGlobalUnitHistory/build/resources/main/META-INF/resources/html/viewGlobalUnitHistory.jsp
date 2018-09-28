<%@ include file="/html/init.jsp" %>
<portlet:resourceURL var="resourceGUHURL"></portlet:resourceURL>
<style>

#select2-barCodeSelect-results > li li {
    display: block !important;
}
.select2-container--default .select2-results__option[role=treeitem] {
    display: none;
}
.select2-container--default .select2-results__option[role=group] {
    display: block;
}
</style>
<div class="delphi-guh">
	<form name="findGUHForm" id="findGUHForm" method="post" name="findGUH">
		<div class="row controlbg" align="center">
			<div class="col-md-5">
				<span class="data-title"><liferay-ui:message key="aptiv-globalunithistory-portlet.unit" /></span>
			</div>
			<div class="col-md-7">
			</div>
		</div>
		<div class="row controlbg" align="center">
			<div class="col-md-5">
				<select class="select-barcodes form-control" id="barCodeSelect" multiple="multiple">
				  <optgroup id="userselect-codes-queued" label="<liferay-ui:message key="aptiv-globalunithistory-portlet.viewed-on-server-colon" />"></optgroup>
				  <optgroup id="userselect-codes-today" label="<liferay-ui:message key="aptiv-globalunithistory-portlet.viewed-today-colon" />"></optgroup>
				  <optgroup id="userselect-codes-week" label="<liferay-ui:message key="aptiv-globalunithistory-portlet.viewed-earlier-this-week-colon" />"></optgroup>
				  <optgroup id="userselect-codes-saved" label="<liferay-ui:message key="aptiv-globalunithistory-portlet.saved" />"></optgroup>
				</select>
			</div>
			<div class="col-md-7 mobile-center">
				<div><button class="btn btn-primary" type="button" id="searchGUH"  style="padding:5px 15px 5px 15px;position:relative;">
				<i class="fa fa-search" aria-hidden="true" style="float: left;position: relative;font-size: 18px;top: 0;left:0;"></i></button></div>
			</div>
		</div>
	</form>
	<div class="controlbg" id="barCodeListWrapper">
		<h3><liferay-ui:message key="aptiv-globalunithistory-portlet.recent" /> <i class="fa arrow"></i></h3>
		<div id="barCodeList" class="row" style="display:none">
			<div class="col-sm-4">
				<div class="barCodeList-wrapper">
					<h4 class="active"><liferay-ui:message key="aptiv-globalunithistory-portlet.queued-on-server" /> <i class="fa arrow"></i></h4>
					<div class="list" id="barCodeList-queued"></div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="barCodeList-wrapper">
					<h4 class="active"><liferay-ui:message key="aptiv-globalunithistory-portlet.viewed-today" /> <i class="fa arrow"></i></h4>
					<div class="list" id="barCodeList-today"></div>
				</div>
				<div class="barCodeList-wrapper">
					<h4 class="active"><liferay-ui:message key="aptiv-globalunithistory-portlet.viewed-earlier-this-week" /> <i class="fa arrow"></i></h4>
					<div class="list" id="barCodeList-week"></div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="barCodeList-wrapper">
					<h4 class="active"><liferay-ui:message key="aptiv-globalunithistory-portlet.saved" /> <i class="fa arrow"></i></h4>
					<div class="list" id="barCodeList-saved"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="mobile-guh-hide" id="delphi-guh-data"></div>
	<div class="desktop-guh-hide" id="delphi-guh-data-mobile"></div>
	
	<div style="padding:5px;"><i><liferay-ui:message key="aptiv-globalunithistory-portlet.guh-display-message" /></i></div>
</div>

<div id='spinner' style="border-color: transparent; display: none;">
    <div class="spiner-example"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
</div>

<!-- To be moved to main.js -->

<script>
	var debug = false; 
	
	function initGUHLogic(){
	
		getGUHList("1"); //queued
	 	getGUHList("21"); //viewed Today
		getGUHList("22"); //viewed Week 
		getGUHList("3"); //saved
		
		$(".select-barcodes").select2({
			placeholder: "<liferay-ui:message key="aptiv-globalunithistory-portlet.type-or-select" />",
			maximumSelectionLength: 1,
			tags: true
		});
		
		$("#findGUHForm").on('keyup keypress', function(e) {
		  var keyCode = e.keyCode || e.which;
		  if (keyCode === 13) {
			searchGUH();
		    e.preventDefault();
		    return false;
		  }
		});
		
		$("#searchGUH").on('click', function(e) { searchGUH(); });
		
		$("#addToGUHQueue").on('click', function(e) {
			var context = {};
			context.id = getBarCodeSelection();
		    serveGUHResource("addToGUHQueue","add",JSON.stringify(context));
		});
		
		$("#saveGUH").on('click', function(e) {
			var context = {};
			context.id = getBarCodeSelection();
		 	serveGUHResource("saveGUH","add",JSON.stringify(context));
		});
		
		$("#barCodeListWrapper h3").on('click', function(e) {
			$(this).toggleClass("active");
			if($(this).hasClass("active")){
				openRecentList();
			} else {
				closeRecentList();
			}
		});
		
		$("#manageListGUH").on('click', function(e) {
			$(this).toggleClass("active");
			if($(this).hasClass("active")){
				openRecentList();
			} else {
				closeRecentList();
			}
		});
	
		$("#barCodeListWrapper h4").on('click', function(e) {
			$(this).toggleClass("active");
			if($(this).hasClass("active")){
				$(this).parent().find(".list").stop().slideDown(200);
			} else {
				$(this).parent().find(".list").stop().slideUp(200);
			}
		});
		
		addBarCodeListEventHandlers("");
	}
	
	function openRecentList(){
		$("#barCodeListWrapper h3").addClass("active");
		$("#barCodeListWrapper #barCodeList").stop().slideDown(200);
	}

	function closeRecentList(){
		$("#barCodeListWrapper h3").removeClass("active");
		$("#barCodeListWrapper #barCodeList").stop().slideUp(200);
	}
	
	function addBarCodeListEventHandlers(type){
		addBarCodeEventHandlersForElements( $("#barCodeList "+type+" .record") );
	}
	
	function addBarCodeEventHandlersForElements(elm){
		$(elm).on('click', function(e) {
			var codeId = $(this).find("span").text();
			if(debug) console.log("Load code action for id: " + codeId);
			
			addAndSetSelectVal(codeId);
			searchGUH();
		});
	
		$(elm).find(".fa.fa-save").on('click', function(e) {
			e.stopPropagation();
			
			var codeId = $(this).parent().find("span").text();
			if(debug) console.log("Calling save action for id: " + codeId);
	
			var context = {};
			context.id = codeId;
			serveGUHResource("saveGUH","add",JSON.stringify(context));
			
			$(this).parent().slideUp(200,function(){
				$(this).find(".fa.fa-save").remove();
				$("#barCodeList-saved").prepend($(this).slideDown(200));
			});
		});
	
		$(elm).find(".fa.fa-close").on('click', function(e) {
			e.stopPropagation();
			
			var codeId = $(this).parent().find("span").text();
			if(debug) console.log("Calling delete action for id: " + codeId);
	
			var context = {};
			context.id = codeId;
			serveGUHResource("addToGUHQueue","delete",JSON.stringify(context));
			
			$(this).parent().slideUp(200, function(){$(this).remove()});
		});
	}
	
	function addFamilyClickListerners(){
		$(".family-objects .familyObject").on('click', function(e) {
			var codeId = $(this).text();
			if(debug) console.log("Load code action for familyObject id: " + codeId);
			
			addAndSetSelectVal(codeId);
			
			searchGUH();
		});
	}
	
	function getGUHList(category){
		var context = {};
		context.category = category;
		serveGUHResource("getlist","get",JSON.stringify(context));
	}
	
	function searchGUH(){
		closeRecentList()
		
		var context = {};
		context.id = getBarCodeSelection();
		serveGUHResource("searchguh","add",JSON.stringify(context));
	}
	
	function getBarCodeSelection(){
		
		if($("#barCodeSelect").val()){
			$(".delphi-guh .select2-search__field").val("");
			return $("#barCodeSelect").val()[0];
		}else{
			var typedValue = $(".delphi-guh .select2-search__field").val();
	
			$(".delphi-guh .select2-search__field").val("");
			
			if( typedValue != undefined && typedValue != "" ){
				addAndSetSelectVal(typedValue);
			} else {
				return "";
			}
	
			return $("#barCodeSelect").val()[0];
		}
	}
	
	function addAndSetSelectVal(code){
		if($("#barCodeSelect option[value='"+code+"']").length>0){
			$("#barCodeSelect").val(code).trigger('change');
		}else{
			$(".delphi-guh .select2-search__field").val("");
			$("#barCodeSelect").append("<option value='"+code+"'>"+code+"</option>").val(code).trigger('change');
		}	
	}
	
	function serveGUHResource(cmd,cmdType,context){
		if(cmd=="searchguh") $("#delphi-guh-data").html("");
		
		var data  = {};
		data[guhPortletNameSpace+'cmd'] = cmd;
		data[guhPortletNameSpace+'cmdType'] = cmdType;
		data[guhPortletNameSpace+'context'] = context;
		
	    $.ajax({  
	        url : '<%=resourceGUHURL.toString()%>',
			data : data,
			type : "POST",
			dataType : "json",
			beforeSend:function(){$("#spinner").show();}, 	//console.time("spinner");
			complete:function(){$("#spinner").hide();}, 	//console.timeEnd("spinner");
			success : function(result) {
				//console.log('ajax call success');
	
				if(result.command=="searchguh"){ 
					$(".select-barcodes").select2({
						placeholder: "<liferay-ui:message key="aptiv-globalunithistory-portlet.type-or-select" />",
						maximumSelectionLength: 1,
						tags: true
					});
					initGUH(result.data, result.multiple);
					if(debug)  console.log(result.viewedTodayData);
					loadGUHList(result.viewedTodaycategory,result.viewedTodayData);
					loadGUHList(result.queuedDatacategory,result.queuedData);
					loadGUHList(result.savedcategory,result.savedData);
					loadGUHList(result.weekcategory,result.weekdData);
				}else if(result.command=="getlist"){
					loadGUHList(result.category,result.data);
				}else if(result.command=="addToGUHQueue"){ 
						$(".select-barcodes").select2({
						placeholder: "<liferay-ui:message key="aptiv-globalunithistory-portlet.type-or-select" />",
						maximumSelectionLength: 1,
						tags: true
					});
					if(debug) console.log('server response: ' + result.data);
					loadGUHList(result.viewedTodaycategory,result.viewedTodayData);
					loadGUHList(result.queuedDatacategory,result.queuedData);
					loadGUHList(result.savedcategory,result.savedData);
					loadGUHList(result.weekcategory,result.weekdData);
				}else{ 
						$(".select-barcodes").select2({
						placeholder: "<liferay-ui:message key="aptiv-globalunithistory-portlet.type-or-select" />",
						maximumSelectionLength: 1,
						tags: true
					});
					if(debug) console.log("UNUSED COMMAND: ["+result.command+"]");
					loadGUHList(result.viewedTodaycategory,result.viewedTodayData);
					loadGUHList(result.queuedDatacategory,result.queuedData);
					loadGUHList(result.savedcategory,result.savedData);
					loadGUHList(result.weekcategory,result.weekdData);
				}
			},
			error : function(response) {
				console.log("Error seen for update");
			}
		});
	}
		
	/************************/
	/* Display Construction */
	/************************/
	
	function initGUH(unitHistory, multiple){
	
		var delphiGUHdata = document.getElementById("delphi-guh-data");
	    delphiGUHdata.innerHTML="";
	    
		var delphiGUHMobiledata = document.getElementById("delphi-guh-data-mobile");
		delphiGUHMobiledata.innerHTML="";
		
		if(multiple === 'true'){
			delphiGUHdata.innerHTML =	"<center class='data-title rework' style='margin: 20px;padding:10px;'>" +
										"<liferay-ui:message key="aptiv-globalunithistory-portlet.history-not-displayed" /> <a href='mailto:steven.f.hutchins@delphi.com?Subject=Duplicate%20serial%20number%20found%20for%20" +getBarCodeSelection()+"' target='_top'>steven.f.hutchins@delphi.com</a>.</center>" ;
			delphiGUHMobiledata.innerHTML = delphiGUHdata.innerHTML;
			return;
		};
		
		if(!unitHistory.length){
			delphiGUHdata.innerHTML =	"<center class='data-title rework' style='margin: 20px;padding:10px;'>" +
										"<liferay-ui:message key="aptiv-globalunithistory-portlet.unable-retrieve" />"	+						
										"</center>" ;
			delphiGUHMobiledata.innerHTML = delphiGUHdata.innerHTML;
			return;
		};
		
		/* Context Table */
		
		var tableDetail = document.createElement("table");
		tableDetail.className="grid table mobile-guh-hide";
	
			var tablehead = document.createElement("thead");
			var tablebody = document.createElement("tbody");
				
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table";
	
				tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.route-key" />" ) );
				tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.product-family" />") );
				tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.part-number" />") );
				tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.product-type" />") );
				tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.site" />") );
				tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.server" />") );
	
				tablehead.appendChild(tablerow);
				tableDetail.appendChild(tablehead);
			
				var tablerow = document.createElement("tr");
	
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["routeKey"] ) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["productType"]) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["partNumber"]) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["productType"]) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["location"]) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["serverName"]) );
				
				tablebody.appendChild(tablerow);
				tableDetail.appendChild(tablebody);
			
		delphiGUHdata.appendChild(tableDetail);
		
		/* Parent Child Table */
		
		var tableDetail = document.createElement("table");
		tableDetail.className="grid table";
	
			var tablehead = document.createElement("thead");
			var tablebody = document.createElement("tbody");
		
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table desktop-guh-hide"; //family-objects 
		
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.route-key-colon" /></b>" ) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["routeKey"] ) );
				tablebody.appendChild(tablerow);
				
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table desktop-guh-hide"; //family-objects 
		
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.product-family-colon" /></b>" ) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["productType"] ) );
				tablebody.appendChild(tablerow);
				
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table desktop-guh-hide"; //family-objects 
		
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.part-number-colon" /></b>" ) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["partNumber"] ) );
				tablebody.appendChild(tablerow);
				
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table desktop-guh-hide"; //family-objects 
		
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.product-type-colon" /></b>" ) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["productType"] ) );
				tablebody.appendChild(tablerow);
				
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table desktop-guh-hide"; //family-objects 
		
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.site-colon" /></b>" ) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["location"] ) );
				tablebody.appendChild(tablerow);
				
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table desktop-guh-hide"; //family-objects 
		
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.server-colon" /></b>" ) );
				tablerow.appendChild( createDomElemement("td", unitHistory[0]["serverName"] ) );
				tablebody.appendChild(tablerow);
			
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table family-objects";
	
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.parent" /> <span id='parentCount'></span>:</b>" ) );
				tablerow.appendChild( createDomElemement("td", splitFamilyObjects("parentCount",unitHistory[0]["parents"]) ) );
	
				tablebody.appendChild(tablerow);
				tableDetail.appendChild(tablehead);
			
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table family-objects";
	
				tablerow.appendChild( createDomElemement("td", "<b><liferay-ui:message key="aptiv-globalunithistory-portlet.children" /> <span id='childCount'></span>:</b>" ) );
				tablerow.appendChild( createDomElemement("td", splitFamilyObjects("childCount",unitHistory[0]["children"]) ) );
				
				tablebody.appendChild(tablerow);
				tableDetail.appendChild(tablebody);
			
		delphiGUHdata.appendChild(tableDetail);
		$(delphiGUHMobiledata).html( $(delphiGUHdata).html() );
		
		/* Desktop Data Table */
		
			var tableData = document.createElement("table");
			tableData.className="grid table";
			
			var tablehead = document.createElement("thead");
			var tablebody = document.createElement("tbody");
			
				var tablerow = document.createElement("tr");
				tablerow.className="basic-table";
				
				var processTh = createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.process" />" );
				processTh.className = "process-title";
		
					tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.event" />" ) );
					tablerow.appendChild( processTh );
					tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.station" />") );
					tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.status" />") );
					tablerow.appendChild( createDomElemement("th", "<liferay-ui:message key="aptiv-globalunithistory-portlet.data" />", 1, 2) );
	
				tablehead.appendChild(tablerow);
				tableData.appendChild(tablehead);
				
				for(i=0;i<unitHistory.length;i++){
					
					var tablerow = document.createElement("tr");
	
				    var dataObj = unitHistory[i]["data"].split("|-|");
				    var ln = dataObj.length-1;
				    var dataRow = dataObj[0].split("|");
				    
				    var processTd = createDomElemement("td", unitHistory[i]["process"], ln, 1);
					processTd.className = "process-data";
				    
					tablerow.appendChild( createDomElemement("td", unitHistory[i]["formattedEventDate"], ln, 1) );
					tablerow.appendChild( processTd );
					tablerow.appendChild( createDomElemement("td", unitHistory[i]["station"], ln, 1) );
					tablerow.appendChild( createDomElemement("td", unitHistory[i]["status"], ln, 1) );
					tablerow.appendChild( createDomElemement("td", (dataRow[0])?dataRow[0]:"" ) );
					tablerow.appendChild( createDomElemement("td", (dataRow[1])?dataRow[1]:"" ) );
					
					if(unitHistory[i]["status"]==='<liferay-ui:message key="aptiv-globalunithistory-portlet.scrap" />'){
						tablerow.className="scrap";
					}else if(unitHistory[i]["status"]==='<liferay-ui:message key="aptiv-globalunithistory-portlet.pass" />'){
						tablerow.className="pass";
					}else if(unitHistory[i]["status"]==='<liferay-ui:message key="aptiv-globalunithistory-portlet.rework" />'){
						tablerow.className="rework";
					}
					
					tablebody.appendChild(tablerow);
	
					if(dataObj.length>1){
						for(ii=1;ii<dataObj.length;ii++){
							if(dataObj[ii]) tablebody.appendChild( getDataRow(dataObj[ii].substr(1), tablerow.className) );
						}
					}
					
					tableData.appendChild(tablebody);
				}
			
		delphiGUHdata.appendChild(tableData);
	
		
		/* Mobile Data Table */
		
		
		var mobileTitleData = document.createElement("div");
		mobileTitleData.className="background-title-guh d-flex";
	
			var mobileDataChild1 = document.createElement("div");
			mobileDataChild1.className="mw-45 p-10 border-guh ";
		
				var mobileDataP1 = document.createElement("p");
				mobileDataP1.className="guh m-process-title";
				$(mobileDataP1).text("<liferay-ui:message key="aptiv-globalunithistory-portlet.process" />");
				
				var mobileDataP2 = document.createElement("p");
				mobileDataP2.className="guh";
				$(mobileDataP2).text("<liferay-ui:message key="aptiv-globalunithistory-portlet.station" />");
				
				var mobileDataP3 = document.createElement("p");
				mobileDataP3.className="guh w-s";
				$(mobileDataP3).text("<liferay-ui:message key="aptiv-globalunithistory-portlet.event" />");
	
			mobileDataChild1.appendChild(mobileDataP1);
			mobileDataChild1.appendChild(mobileDataP2);
			mobileDataChild1.appendChild(mobileDataP3);
	
			var mobileDataChild2 = document.createElement("div");
			mobileDataChild2.className="mw-55 p-10 border-guh d-flex";
		
				var mobileDataP1 = document.createElement("p");
				mobileDataP1.className="guh";
				$(mobileDataP1).text("<liferay-ui:message key="aptiv-globalunithistory-portlet.data" />");
			
			mobileDataChild2.appendChild(mobileDataP1);
			
		mobileTitleData.appendChild(mobileDataChild1);
		mobileTitleData.appendChild(mobileDataChild2);
		
		delphiGUHMobiledata.appendChild(mobileTitleData);
	
		for(i=0;i<unitHistory.length;i++){
				
			var mobileDetailData = document.createElement("div");
			mobileDetailData.className="d-flex";
			
				var mobileDetail1 = document.createElement("div");
				var statusValue = "" 
				
				if(unitHistory[i]["status"]==='<liferay-ui:message key="aptiv-globalunithistory-portlet.scrap" />'){
					statusValue = "scrap";
				}else if(unitHistory[i]["status"]==='<liferay-ui:message key="aptiv-globalunithistory-portlet.pass" />'){
					statusValue = "pass";
				}else if(unitHistory[i]["status"]==='<liferay-ui:message key="aptiv-globalunithistory-portlet.rework" />'){
					statusValue = "rework";
				}
	
				mobileDetail1.className="mw-45 p-10 border-guh " + statusValue;
					
					var mobileDetailChild1 = document.createElement("p");
					mobileDetailChild1.className="guh m-process-title";
					$(mobileDetailChild1).text(unitHistory[i]["process"]);
					
					var mobileDetailChild2 = document.createElement("p");
					mobileDetailChild2.className="guh";
					$(mobileDetailChild2).text(unitHistory[i]["station"]);
					
					var mobileDetailChild3 = document.createElement("div");
					mobileDetailChild3.className="w-114 mt-10";
					
						var mobileDetailChild4 = document.createElement("p");
						mobileDetailChild4.className="guh guh-data-date";
						$(mobileDetailChild4).text(unitHistory[i]["formattedEventDate"]);
						
					mobileDetailChild3.appendChild(mobileDetailChild4);
		
				mobileDetail1.appendChild(mobileDetailChild1);
				mobileDetail1.appendChild(mobileDetailChild2);
				mobileDetail1.appendChild(mobileDetailChild3);
				
			mobileDetailData.appendChild(mobileDetail1);
				
				var mobileDetail2 = document.createElement("div");
				mobileDetail2.className="d-block mw-55 " + statusValue;
	
			    var dataObj = unitHistory[i]["data"].split("|-|");
	
			    if(debug) console.log("[mobile view] dataObj.length:" +dataObj.length);
				
				if(dataObj.length>0){
					for(ii=0;ii<dataObj.length;ii++){
	
						if(debug) console.log("[mobile view] dataObj:");
						if(debug) console.log(dataObj[ii]);
	
						if(dataObj[ii]){
							
						var mobileDetailRecord = document.createElement("div");
						mobileDetailRecord.className="p-10 border-guh " + statusValue;
				    	
							var dataRowSet = dataObj[ii].split("|");
	
							if(debug) console.log("[mobile view] dataRowSet:");
							if(debug) console.log(dataRowSet);
							
							var mobileDetailRowA = document.createElement("p");
							mobileDetailRowA.className="guh mw-45";
							$(mobileDetailRowA).text(dataRowSet[2]?dataRowSet[1]:dataRowSet[0]);
	
							var mobileDetailRowB = document.createElement("p");
							mobileDetailRowB.className="guh mw-55";
							$(mobileDetailRowB).text(dataRowSet[2]?dataRowSet[2]:dataRowSet[1]);
							
							mobileDetailRecord.appendChild(mobileDetailRowA);
							mobileDetailRecord.appendChild(mobileDetailRowB);
						
							mobileDetail2.appendChild(mobileDetailRecord);
						}
					}
				}
				
			mobileDetailData.appendChild(mobileDetail2);
			delphiGUHMobiledata.appendChild(mobileDetailData);
		}
		
		addFamilyClickListerners();
	};
	
	function loadGUHList(category,data){
		var useClose = true;
		var useSave = true;
		var parentElement = "barCodeList-queued";
		var selectElement = "userselect-codes-queued";
		
		if(category=="21"){
			parentElement = "barCodeList-today";
			selectElement = "userselect-codes-today";
		} 
		else if (category=="22"){
			parentElement = "barCodeList-week";
			selectElement = "userselect-codes-week";
		} 
		else if (category=="3"){
			useSave = false;
			parentElement = "barCodeList-saved";
			selectElement = "userselect-codes-saved";
		}
	
		$("#"+parentElement+", #"+selectElement).text("");
		
		for(i=0;i<data.length;i++){
			var code = data[i]["barCode"];
			if(undefined!=code && ""!=code){
				$("#"+selectElement).prepend( "<option value='"+code+"'>"+code+"</option>" );
				$("#"+parentElement).prepend( addGUHListRecord(code, useSave, useClose) );
			}
		}	
		 $("#barCodeSelect").children('option').hide();
	}
	
	function addGUHListRecord(code, useSave, useClose){
		var record = document.createElement("div");
		record.className="record clearfix";
		
		var span = document.createElement("span");
		var codeText = document.createTextNode(code);
		span.appendChild(codeText);
		record.appendChild(span);
		
		if(useClose){
			var icon = document.createElement("i");
			icon.className="fa fa-close";
			record.appendChild(icon);
		}
		
		if(useSave){
			var icon = document.createElement("i");
			icon.className="fa fa-save";
			record.appendChild(icon);
		}
		
		addBarCodeEventHandlersForElements(record);
		return record;
	}
	
	function getDataRow(dataRow, className) {
		var dataRowSet = dataRow.split("|");
		var row = document.createElement("tr");
		row.className=className;
		
		row.appendChild( createDomElemement("td", dataRowSet[0] ) );
		row.appendChild( createDomElemement("td", dataRowSet[1] ) );
		return row;
	}
	
	function createDomElemement(type, value, rowSpan, colSpan){
		rowSpan = rowSpan || 1;
		colSpan = colSpan || 1;
		var tablecell = document.createElement(type);
		tablecell.colSpan = colSpan;
		tablecell.rowSpan = rowSpan;
		$(tablecell).html(value);
		return tablecell;
	}
	
	function splitFamilyObjects(countId, stringObjects){
		var returnString = "";
		var familyObjects = stringObjects.split(",");
		
		if(familyObjects[0]!=""){
			var familyObjectCount = familyObjects.length;
			
			setTimeout(function(){
				$("#"+countId).text("("+familyObjectCount+")");
			},250);
			
			for(var i=0;familyObjectCount>i;i++){
				if(""!=familyObjects[i]) returnString += "<span class='familyObject'>" + familyObjects[i]+"</span>";
			}
		}
		return returnString;
	}

	var guhPortletNameSpace = '<portlet:namespace/>';
	initGUHLogic();
	
	<%	if(!param_code.equalsIgnoreCase("")){ %>
	if(debug) console.log("Starting up with load of '<%= param_code %>'. ");
	addAndSetSelectVal("<%= param_code %>");
	setTimeout(function(){searchGUH();},500);
	<%	} %>
</script>