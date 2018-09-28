<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="importPositionData" var="importPositionDataURL"></portlet:actionURL>

<h2>Import Position Data</h2>
<div id="addConfigurationForm">
	<div class="portlet-layout row">
	
		
			<div class="portlet-column portlet-column-first col-sm-8 box-content">
			
				<aui:form action="<%=importPositionDataURL.toString() %>"  enctype="multipart/form-data" method="post">
					<aui:input label="Choose the Position Data Report to upload"  type="file" name="positionReport"/>
					<aui:button name="save" type="submit" value="Start Position Data Import"/>
				</aui:form>
				
			</div>
			<div class="portlet-column portlet-column-first col-sm-4">
				<div class="box-details">
				
					<h3>Import Process Explanation</h3>
					
					<ul class="box-detail-list">
						<li>Detail 1</li>
						<li>Detail 2</li>
						<li>Detail 3</li>
						<li>Detail 4</li>
						<li>Detail 5</li>
					</ul>
		
					<aui:button name="exit" type="button" value="Back" onClick="<%=cancelURL.toString()%>" />
				</div>
			</div>
	</div>
</div>