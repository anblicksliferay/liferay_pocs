<%@page import="java.util.List"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig"%>
<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>

<portlet:actionURL name="newConfiguration" var="newConfigurationURL"></portlet:actionURL>
<portlet:actionURL name="importView" var="importViewURL"></portlet:actionURL>	

<%
	List<WFMS_WorkflowConfig> configurationList = (List<WFMS_WorkflowConfig>) request.getAttribute("list");
%>

<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Workflow Configuration</h4>
	</div>
	
	<div class="col-sm-6">
		<div class="btn-manage small">
		
			<div class="portlet-layout row">
				<input type="button" class="btn btn-primary" value="Create New Configuration" name="newConfiguration" onclick="getUrl('<%=newConfigurationURL%>')"> 
				<button class="btn btn-default" onclick="getUrl('<%=wmsBasePath%>/dashboard')">Home</button>
			</div>
			
		</div>
	</div>
</div>

<%if(configurationList != null){ %>

	<script>
		$(document).ready(function() { 
			$('#recordList').DataTable({
				dom: 'Blfrtip',
		        lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
	            buttons: [
	                      'copy', 'excel', 'pdf', 'print'
	                  ]
			});
		
			$('#recordList tbody').on( 'click', 'tr', function () {
				console.log("Clicked row "+$(this).index());
				location.href=$(this).attr("data-record-url");
			} );
		    
		} );
	</script>
	
	<table id="recordList" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Configuration Key</th>
                <th>Type</th>
                <th>Configuration Label</th>
            </tr>
        </thead>
               <tbody>
        
			<% for(WFMS_WorkflowConfig wmsConfig: configurationList){ %>
				
				<portlet:actionURL name="manageConfiguration" var="manageConfigurationURL">
					<portlet:param name="configId" value="<%=Long.toString(wmsConfig.getWfcId()) %>" />
				</portlet:actionURL>
			
	        	<tr data-record-url="<%= manageConfigurationURL %>" >
	        		<td><%=wmsConfig.getConfigKey()%></td>
	                <td><%=wmsConfig.getContentType()%></td>
	                <td><%=wmsConfig.getConfigLabel()%></td>
	            </tr>
            
            <%}%>
        </tbody>
    </table>
   
   <%}%>