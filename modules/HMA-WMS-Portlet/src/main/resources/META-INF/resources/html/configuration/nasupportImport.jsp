<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="importNASupportData" var="NASupportDataURL"></portlet:actionURL>

<h2>Import NA Support Data</h2>

<div id="addConfigurationForm">
	<div class="portlet-layout row">	
		
			<div class="portlet-column portlet-column-first col-sm-8 box-content">
			
				<aui:form action="<%=NASupportDataURL.toString() %>"  enctype="multipart/form-data" method="post">
					<aui:input label="Choose the NASupport Data Report to upload"  type="file" name="importNASupportData"/>
					<aui:button name="save" type="submit" value="Start NASupport Data Import"/>
				</aui:form>
				
				<aui:button name="exit" type="button" value="Back" onClick="<%=cancelURL.toString()%>" />
				
			</div>
			<div class="portlet-column portlet-column-first col-sm-4">
				<div class="box-details">
				
					<h3>NASupport Import Process - Required Columns</h3>
					
					<ul>
						<li>ASSOC NO</li>
						<li>ASSOCIATE DATE OF HIRE</li>
						<li>ASSOCIATE NAME</li>
						<li>DEPT NUMBER</li>
						<li>DEPT NO</li>
						<li>DEPT NAME</li>
						<li>ASSOCIATE TITLE</li>
						<li>SHIFT CODE</li>
						<li>TEAM NUMBER</li>
						<li>EFFDT</li>
						<li>TERMINATION_DT</li>
						<li>MANAGER ASSOCIATE NUMBER</li>
						<li>ASSGN TYPE</li>
						<li>LEADERSHIP ASSIGNMENT</li>
						<li>EMAIL</li>
	        		</ul>
				</div>
			</div>
	</div>
</div>