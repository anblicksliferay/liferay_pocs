<%@ include file="/html/admin/init.jsp" %>

<portlet:resourceURL var="listURL"/>
<aui:form action="<%=listURL.toString() %>" method="post" name="update"></aui:form>

<portlet:resourceURL var="lURL"></portlet:resourceURL>

<portlet:actionURL var="viewURL"/>
<style>
.ui-datepicker .ui-datepicker-prev span, .ui-datepicker .ui-datepicker-next span {
    background-image: none !important;
}
.ui-datepicker .ui-datepicker-prev span, .ui-datepicker .ui-datepicker-prev span {
    background-image: none !important;
}
</style>
<div class="row wrapper white-bg page-heading">
	<div class="col-lg-12">
		<h2>Financial Administration</h2>
	</div>
</div>
<div class="col-sm-12" id="adminWarninig">
 <span class ="badge badge-danger" style="display: none;">There was error while save/update. Please contact Administrator.</span>
</div>
<div class="row wrapper white-bg page-heading">
	<div class="col-sm-12">
	
		<div id="tableheader" class="main">
			
			<table>
				<tbody>
					<tr>
						<td colspan="2" rowspan="5" class="financial-controls-container">
							
							<div class="financial-controls">
								<form action="<%=viewURL.toString() %>" method="get"
										id="dashboardAdminForm" name="dashboardAdminForm">
								
									<input type="hidden" name="action" value="list"/>
									<input type="hidden" name="expenseId" value="<%=expenseId %>"/>
									
									<div>
										<label>Site:</label>
										<select name="adminSiteId">
											<% for(NameId site : sites){ %>
									        <option value="<%=site.getId() %>"
												<%if(site.getId()==siteId){ %>selected="selected"<%}%> >
									        	<%=site.getName() %>
									        </option>
									        <% } %>
										</select>
										
									</div>
									<div>
										<label>Year:</label>
										<select name="adminYear" ">
											<% for(int i=0;i<5;i++){%>
											<option 
												<%if(year == cal.get(Calendar.YEAR)){ %>selected="selected"<%}%>
												value="<%=cal.get(Calendar.YEAR)%>"><%=cal.get(Calendar.YEAR)%></option>
											<% 
												cal.add(Calendar.YEAR,-1);
											}
											%>
										</select>
									</div>
									<div>
										<label>Month:</label>
										<select name="adminMonth" >
											<% for(int i=0;i<12;i++){
												int monthNumber = cal.get(Calendar.MONTH);
												String monthName = new DateFormatSymbols().getMonths()[monthNumber];
											%>
											<option 
												<%if(month.equalsIgnoreCase(monthName) ){ %>selected="selected"<%}%>
												value="<%=monthName%>"><%=monthName%> </option>
											<%
											cal.add(Calendar.MONTH,1);
											} %>
										</select>
									</div>
									<div>
										<span><span class="working-days"> </span> Working Days</span>
									</div>
								</form>
							</div>
						
						</td>
						<td colspan="8" class="grey9 bordered tabarea">
			
							<ul class="tab">
							  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==1){ %>active<% } %>" onclick="dashboardAdmin.openTab(event, 1)">Revenue</a></li>
							  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==2){ %>active<% } %>" onclick="dashboardAdmin.openTab(event, 6)">Packaging</a></li>
							  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==3){ %>active<% } %>" onclick="dashboardAdmin.openTab(event, 2)">Electricity</a></li>
							  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==4){ %>active<% } %>" onclick="dashboardAdmin.openTab(event, 3)">Maint</a></li>
							  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==5){ %>active<% } %>" onclick="dashboardAdmin.openTab(event, 4)">Scrap</a></li>
							  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==6){ %>active<% } %>" onclick="dashboardAdmin.openTab(event, 5)">Overtime</a></li>
							</ul>

						</td>
					</tr>
					<tr>
						  <c:forEach items="${divisions}" var="division">
							   		<td colspan="${fn:length(division.productLines) * 2}" class="grey8 bordered">${division.nameId.name}</td>							   
						     </c:forEach>
						</tr>
					<tr>
					    <c:forEach items="${divisions}" var="division">		    
						    <c:forEach items="${division.productLines}" var="productLine">
						   		<td colspan="2" class="grey8 bordered">${productLine.nameId.name}</td>
						    </c:forEach>
					    </c:forEach>
					</tr>
					<tr>
						<c:forEach items="${divisions}" var="division">
							<c:forEach items="${division.productLines}" var="productLine">
								<td class="grey7 bordered">Target</td>
								<td class="grey7 bordered">Actual</td>
							</c:forEach>
						</c:forEach>
					</tr>
					<tr class="totals">
						<c:set var="count" scope="page" value="1"/>
						<c:forEach items="${divisions}" var="division">
							<c:forEach items="${division.productLines}" var="productLine">
							
								<td class="grey6 bordered"><input class="target${count}" name="target-${count}-total" type="text" readonly/>
								</td>
								<td class="grey6 bordered"><input class="actual${count}" name="actual-${count}-total" type="text" readonly />						
								</td>
						
								<c:set var="count" scope="page" value="${count + 1}"/>
							</c:forEach>
						</c:forEach>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div id="tablecontent"></div>
		
	</div>
</div>

<style>
	<c:if test="${count==2}">
		#tableheader.main table td { width: 25%; }
		#tableheader.main table td.financial-controls-container { width: 50%; }
	</c:if>	
	<c:if test="${count==3}">
		#tableheader.main table td { width: 16.8%; }
		#tableheader.main table td.financial-controls-container { width: 33.32%; }
	</c:if>	
	<c:if test="${count==4}">
		#tableheader.main table td { width: 25%; }
		#tableheader.main table td.financial-controls-container { width: 50%; }
	</c:if>
	<c:if test="${count==5}">
		#tableheader.main table td { width: 10%; }
		#tableheader.main table td.financial-controls-container { width: 20%; }
		#tableheader.main .financial-controls form div>span { margin-left:0;text-align: center;float:none; }
		#tableheader.main .financial-controls select{ margin-bottom:0; }
	</c:if>
</style>

<div class="loader" class='sk-spinner-wave'></div>

<div id='adminSpinner'>
	<div class="spiner-example"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
</div>

<div id="setTargets">

<div class="portlet-msg-success" id="successmessage" style="display: none;">Your request completed successfully </div>
	<div id="tableheader">			
			<table>
				<tbody>
					<tr>
					<td colspan="2" style="width: 10%;">
						<div class="financial-controls">									
								<div style='text-align: left;margin-bottom: 15px'>1. Select Holidays</div>
						</div>
					</td>
					<td colspan="8" >
						<div class="financial-controls">									
								<div style='text-align: left;margin-bottom: 15px'>2. Enter target dollars for month for each product line. Repeat for each category tab. Enter $0 if necessary.</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" rowspan="5" style="width: 10%;">
						<div class="financial-controls">									
								<div id="adminDatepicker"></div>
						</div>
					</td>
					<td colspan="8" class="grey9 bordered tabarea">
		
						<ul class="tab">
						  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==1){ %>active<% } %>" onclick="dashboardAdmin.showTotalField(1,this)">Revenue</a></li>
						  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==2){ %>active<% } %>" onclick="dashboardAdmin.showTotalField(6,this)">Packaging</a></li>
						  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==3){ %>active<% } %>" onclick="dashboardAdmin.showTotalField(2,this)">Electricity</a></li>
						  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==4){ %>active<% } %>" onclick="dashboardAdmin.showTotalField(3,this)">Maint</a></li>
						  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==5){ %>active<% } %>" onclick="dashboardAdmin.showTotalField(4,this)">Scrap</a></li>
						  <li><a href="javascript:void(0)" class="tablinks <% if(expenseId==6){ %>active<% } %>" onclick="dashboardAdmin.showTotalField(5,this)">Overtime</a></li>
						</ul>

					</td>
				</tr>
				<tr>
					<c:forEach items="${divisions}" var="division">
						<td colspan="${fn:length(division.productLines)}" class="grey8 bordered">${division.nameId.name}</td>							   
					</c:forEach>
				</tr>
				<tr>
				    <c:forEach items="${divisions}" var="division">		    
					    <c:forEach items="${division.productLines}" var="productLine">
					   		<td colspan="1" class="grey8 bordered">${productLine.nameId.name}</td>
					    </c:forEach>
				    </c:forEach>
				</tr>
				<tr>
					<c:forEach items="${divisions}" var="division">
						<c:forEach items="${division.productLines}" var="productLine">
							<td class="grey7 bordered">Target</td>
						</c:forEach>
					</c:forEach>
				</tr>
				<tr class="totals">
					<c:set var="count" scope="page" value="0"/>
					<c:forEach items="${divisions}" var="division">
						<c:forEach items="${division.productLines}" var="productLine">							
							<td class="grey6 bordered">
							<input  name="total_1" id="${productLine.rpdpId}_total_1" type="text" oninput='dashboardAdmin.enableSubmitBtn();' required />
							<input  name="total_2" id="${productLine.rpdpId}_total_2" type="text" oninput='dashboardAdmin.enableSubmitBtn();' style="display: none;" required/>
							<input  name="total_3" id="${productLine.rpdpId}_total_3" type="text" oninput='dashboardAdmin.enableSubmitBtn();' style="display: none;" required/>
							<input  name="total_4" id="${productLine.rpdpId}_total_4" type="text" oninput='dashboardAdmin.enableSubmitBtn();' style="display: none;" required/>
							<input  name="total_5" id="${productLine.rpdpId}_total_5" type="text" oninput='dashboardAdmin.enableSubmitBtn();' style="display: none;" required/>
							<input  name="total_6" id="${productLine.rpdpId}_total_6" type="text" oninput='dashboardAdmin.enableSubmitBtn();' style="display: none;" required/>
							</td>						
							<c:set var="count" scope="page" value="${count + 1}"/>
						</c:forEach>
					</c:forEach>
				</tr>
					<tr>
					<td colspan="2" style="width: 10%;">							
						<div class="financial-controls">									
								<div id="workDays" style="text-align: left; float: left;font-weight: bold;font-style: italic;margin-left: 70px;"></div>
						</div>
					
					</td>						
				</tr>
			</tbody>
		</table>
	</div>

</div>

<script type="text/javascript">
	var dashboardAdmin;
	var holiday=[];
	
	
	$(document).ready(function() { 
		$("#successmessage").hide();
		var dashBoardResourceUrl= '<%=listURL.toString()%>';
		var portletNameSpace = '<portlet:namespace/>';
		dashboardAdmin= new dashBoardAdminInit(dashBoardResourceUrl,portletNameSpace);
		
	});  
</script>