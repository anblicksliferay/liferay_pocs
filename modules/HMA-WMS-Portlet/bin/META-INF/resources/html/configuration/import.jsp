<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="importPositionData" var="importPositionDataURL"></portlet:actionURL>

<h2>Import Position Data</h2>

<div id="addConfigurationForm">
	<div class="portlet-layout row">	
		
			<div class="portlet-column portlet-column-first col-sm-8 box-content">
			
				<aui:form action="<%=importPositionDataURL.toString() %>"  enctype="multipart/form-data" method="post">
					<aui:input label="Choose the Position Data Report to upload"  type="file" name="positionReport"/>
					<aui:button name="save" type="submit" value="Start Position Data Import" style="margin-bottom: 5px"/>
				</aui:form>
				
				<aui:button name="exit" type="button" value="Back" onClick="<%=cancelURL.toString()%>" />
				
			</div>
			<div class="portlet-column portlet-column-first col-sm-4">
				<div class="box-details">
				
					<h3>Position Import Process - Required Columns</h3>
					
					<ul>
						<li>Pos #</li>
						<li>Division</li>
						<li>Department</li>
						<li>Reports To</li>
						<li>Status</li>
						<li>Line</li>
						<li>Ladder</li>
						<li>MP Category Budgeted</li>
						<li>MP Category Filled</li>
						<li>Position Class</li>
						<li>Type</li>
						<li>Level</li>
						<li>Leadership Assignment</li>
						<li>Category</li>
						<li>Subcategory</li>
						<li>WF Cat</li>
						<li>Emp Cat</li>
						<li>Emp Cat Desc</li>
						<li>Year Established</li>
						<li>Addition Reason</li>
						<li>Re-eval Date</li>
						<li>Assoc Num</li>
						<li>Assoc Name</li>
						<li>Assoc Title</li>
						<li>Critical Workforce?</li>
						<li>Typical Title</li>
						<li>Minimum Knowledge</li>
						<li>Duties</li>
						<li>Tasks</li>
						<li>Experience</li>
						<li>Degree</li>
						<li>Musts</li>
						<li>Wants</li>
						<li>Estimated OT</li>
						<li>Travel</li>
						<li>Environment</li>
					</ul>
		
				</div>
			</div>
	</div>
</div>