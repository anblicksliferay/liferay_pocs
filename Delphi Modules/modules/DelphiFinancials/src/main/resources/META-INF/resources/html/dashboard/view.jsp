<%@ page import="com.delphi.util.UserAccessUtil"%>
<%@ page import="java.util.Map"%>

<%@ include file="/html/dashboard/init.jsp" %>
<%
	String allStartDate ="";
	if(renderRequest.getAttribute("allStartDate")!=null){
		allStartDate = (String)renderRequest.getAttribute("allStartDate");
	}
	
%>
<input class="hidden" type="text" id="allStartDate" name="allStartDate" value="<%= allStartDate %>" />
<portlet:resourceURL var="listURL"/>

<div class="delphidash">
	<div class="row wrapper">
		<div class="dashboard-controls">
			<div class="row wrapper button-row">
				<div id="dateButtons" class="col-sm-6">
					<input class="btn-white" type="button" value="MTD" id="mtd" class="activeButton"/>
					<input class="btn-white" type="button" value="3MTD" id="3mtd" />
					<input class="btn-white" type="button" value="6MTD" id="6mtd" />
					<input class="btn-white" type="button" value="YTD" id="ytd" />
					<input class="btn-white" type="button" value="ALL" id="all" /></div>
				<div class="col-sm-3">
					<label for="autoUpdateSwitch">Auto Update</label>
					<input type="checkbox" class="js-switch js-check-change" checked name="autoUpdateSwitch"/>
				</div>
			 <%
			 if(permissionChecker.isOmniadmin())   { %>
			 	<div class="col-sm-3">	
					<a  href="/group/delphi/financial-admin"
						class="btn btn-default btn-rounded mobile-hide">Enter Data</i>
					</a>
				</div>
			 <%}
			 if(!permissionChecker.isOmniadmin()){
			 Boolean isUserAdmin=   UserAccessUtil.checkPermissionForIsAdmin(renderRequest);
							if(isUserAdmin){%>
				<div class="col-sm-3">	
					<a  href="/group/delphi/financial-admin"
						class="btn btn-default btn-rounded mobile-hide">Enter Data
					</a>
				</div>
				<%}}%> 
			</div>
			
			<div class="row wrapper button-row">
				<div class="col-sm-12">
					<input class="targetDate" type="text" id="from" name="from" readonly />
					<input class="targetDate" type="text" id="to" name="to" readonly />
				</div>
			</div>
		</div>
	</div>
	<div class="row wrapper button-row">
		<div class="dash-controls" style="min-height: 48px;padding: 7px;">
			<div class="current-selection">Current Selections:</div> 
			<a class="btn btn-default btn-rounded fa fa-times ico-after"  id="regionNavigation" style="display: none;">Asia </a>
			<a class="btn btn-default btn-rounded fa fa-times ico-after"  id="divisionNavigation" style="display: none;" >E&S</a>
			<a class="btn btn-default btn-rounded fa fa-times ico-after"  id="productNavigation" style="display: none;">IDI</a>
			<a class="btn btn-default btn-rounded" style="float:right;margin-right: 20px;margin-top: 2px;" onclick="dash.clearFilter()">Clear All</i></a>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12" id="dashWarning" style="display: none;">
	 		<span class ="badge badge-danger">There are no data for the current selection. Please change the selected filter.</span>
		</div>
	</div>
	<div class="row wrapper topchartarea">
		<div class="col-sm-12">
			 <ul class="tab" id="categoryTabs">
				<li><a id="categoryTabs-1" class="tablinks active" onclick="dash.openTab(event, -1)">Revenue & Expense</a></li>
				<li><a id="categoryTabs6" class="tablinks" onclick="dash.openTab(event, 6)">Packaging</a></li>
				<li><a id="categoryTabs2" class="tablinks" onclick="dash.openTab(event, 2)">Electricity</a></li>
				<li><a id="categoryTabs3" class="tablinks" onclick="dash.openTab(event, 3)">Maintenance</a></li>
				<li><a id="categoryTabs4" class="tablinks" onclick="dash.openTab(event, 4)">Scrap</a></li>
				<li><a id="categoryTabs5" class="tablinks" onclick="dash.openTab(event, 5)">Overtime</a></li>
			</ul>
		</div>
	</div>
	
	<div class="row wrapper bottom-margin topchartarea">
		<div id="tabs" class="tabarea">		
				<div class="col-sm-7 bordered" style="height:660px; border-right: none;">
				
					<div id="mapByRegiondiv" style="height:325px"></div>
				
					<div class="row wrapper">
						<div class="col-sm-12 rockerswitch">
							
							<span id="division" onclick="dash.onDivisionChartToggle(this)"
								class="active">Divisions</span>
							<span id="product" onclick="dash.onDivisionChartToggle(this)">Product Lines</span>

						</div>
						
					</div>
					<div class="row bottom-margin">
						
						<div id="divisionChartdiv"></div>
						
					</div>
				
				</div>
				
				
				<div class="col-sm-5 bordered mobile-bordered" style="height:660px">
				
				<div class="row">
					<div class="bottom-margin"><p style="font-size:15px; margin: 5px 0 0; font-weight:bold;" >Revenue ($)</p>
					<div id="revenueCycleDiv"></div></div>
					<div><p style="font-size:15px; margin: 5px 0 0; font-weight:bold;" id="ExpenseId" ></p>
					<div id="expenseCycleDiv"></div></div>
				</div>
				
			</div>
		</div>
	</div>
	
	<div class="row wrapper bottom-margin topchartarea">
		<div id="timeSeriesTabs" class="tabarea">
			<ul class="tab">
			   <li><a class="tablinks active" id='dayTab'>Day</a></li>
			  <li><a  class="tablinks" id='monthTab'>Month</a></li>
			   <li><a class="tablinks" id='yearTab'>Year</a></li>
			</ul>
			<div class="bordered mobile-bordered" id="timeSeriesChartdiv" style="height:350px"></div>
		</div>
	</div>
	
	<div class="row wrapper bottom-margin topchartarea mobile-bordered">
			
		<div class="row wrapper bordered" id='bulletchartdiv'>
			<div class="col-lg-2">
				<div class="row ">
					<div class="col-lg-12" style="margin: 15px 0;">
						<span class="ui-widget" style="font-weight:bold">
							Expenses ($)
						</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span class="legend target-expense"><span id="bc-tooltip-target-expense"></span></span>
					</div>
					<div class="col-xs-8">
						<span class="ui-widget"> Target to date </span>
					</div>
				</div>
				<div class="row" style="margin-top: 15px;">
					<div class="col-xs-4">
						<span class="legend tfp"><span id="bc-tooltip-tfp"></span></span>
					</div>
					<div class="col-xs-8">
						<span class="ui-widget"> Target for period </span>
					</div>
				</div>
				<div class="row" style="margin-top: 15px;">
					<div class="col-xs-4">
						<span class="legend expense-bad"><span id="bc-tooltip-expense-bad"></span></span>
					</div>
					<div class="col-xs-8">
						<span class="ui-widget"> Actual Expense (Above) </span>
					</div>
				</div>
				<div class="row" style="margin-top: 15px;">
					<div class="col-xs-4">
						<span class="legend expense-warn"><span id="bc-tooltip-expense-warn"></span></span>
					</div>
					<div class="col-xs-8">
						<span class="ui-widget"> Actual Expense (5% below) </span>
					</div>
				</div>
				<div class="row" style="margin-top: 15px;">
					<div class="col-xs-4">
						<span class="legend expense-good"><span id="bc-tooltip-expense-good"></span></span>
					</div>
					<div class="col-xs-8">
						<span class="ui-widget"> Actual Expense (>5% below) </span>
					</div>
				</div>
				
			</div>
			<div class="col-lg-2" id="bulletchartdiv1"></div>
			<div class="col-lg-2" id="bulletchartdiv2"></div>
			<div class="col-lg-2" id="bulletchartdiv3"></div>
			<div class="col-lg-2" id="bulletchartdiv4"></div>
			<div class="col-lg-2" id="bulletchartdiv5"></div>
		</div>
		
	</div>
	
	<div id='<portlet:namespace />spinner' class="portlet-spinner" style="display:none;">
		<div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
	</div>
</div>

<%
	Map<String, String> defaultModel = null ; 
	if(renderRequest.getAttribute("userDefaultModel")!=null){
		defaultModel = (Map<String, String>)renderRequest.getAttribute("userDefaultModel");%>
		<script>
		defRegion = "<%=defaultModel.get("Region")%>";
		defSite = "<%=defaultModel.get("Site")%>";
		defChartDuration = "<%=defaultModel.get("ChartDuration")%>";
		defDivisionProductLine = "<%=defaultModel.get("DivisionProductLine")%>";
		defExpenseCategory = "<%=defaultModel.get("ExpenseCategory")%>";	
		defTimePeriod = "<%=defaultModel.get("TimePeriod")%>";
		</script>
		<%
	}
%>

<script>
	var dash;
	var autoUpdate = true;
	var debug = false;
	var dashBoardResourceUrl= '<%=listURL.toString()%>';
	var portletNameSpace = '<portlet:namespace/>';
	
	$( document ).ready(function() {
		
		var today = "${dateToday}";
		
		var elem = document.querySelector('.js-switch');
		var init = new Switchery(elem, { color: '#1AB394',size:'small'});
		
		dash = new dashBoardInit(today,dashBoardResourceUrl,portletNameSpace);
		
		var idleTimer = null;
		var idleState = false;
		var idleWait = 60000;
	
		$('*').bind('mousemove keydown scroll', function () {
			if(!autoUpdate){
				return;
			}
			
			clearTimeout(idleTimer);
					
			if (idleState == true) {		   
				dash.update();		   
			}
			
			idleState = false;
			
			idleTimer = setTimeout(function () {idleState = true; }, idleWait);
		});
		var changeCheckbox = document.querySelector('.js-check-change');
	
	 	changeCheckbox.onchange = function() {
	 		if(debug) console.log(changeCheckbox.checked);
	 		autoUpdate = changeCheckbox.checked;	
		};
		// set the default values
		$('#'+defTimePeriod).trigger("click");
		$('#'+defChartDuration).trigger("click");
		$('#'+defDivisionProductLine).trigger("click"); 
		$('#'+defExpenseCategory).trigger("click"); 
		
		if(defSite && defSite != "null"){
			setTimeout(function(){
				defSiteSplit = defSite.split("|");
				console.log("Setting worldMap to "+defSiteSplit[0]+":"+defSiteSplit[1])
				
				$('#regionNavigation').hide();
				
				$('#regionNavigation').text(defSiteSplit[0]);
				$('#regionNavigation').show();
				
				worldMap.selectObject( worldMap.dataProvider.images[defSiteSplit[1]] )

				dash.changeAll();
			},5000);
		}
	});

	function localSpinner(selector, method){
		if(debug) console.log("localSpinner "+selector +" "+method);
		if("open"==method){
			$(selector).fadeIn(200);
		} else {
			$(selector).fadeOut(200);
		}
	}

</script>