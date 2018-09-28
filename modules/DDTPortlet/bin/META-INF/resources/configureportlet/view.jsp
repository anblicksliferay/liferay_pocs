<%@page import="com.liferay.portlet.configuration.kernel.util.PortletConfigurationUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<script>
    define._amd = define.amd;
    define.amd = false;
</script>
<portlet:actionURL var="deleteProfile" name="deleteProfile"/>
<portlet:actionURL var="editProfile" name="editProfile"/>

<%@page import="com.ddt.service.TestimonialAshokLocalServiceUtil"%>
<%@page import="com.ddt.model.TestimonialAshok"%>
<%@page import="java.util.List"%>
<script src="<%=request.getContextPath()%>/js/dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/js/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-chosen.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dataTables.min.css" type="text/css">



<form name="deleteForm" id="deleteForm" action="<%=deleteProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>userid" name="<portlet:namespace/>userid"/>
</form> 

<form name="editForm" id="editForm" action="<%=editProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>editid" name="<portlet:namespace/>editid"/>
</form>

	<div id="confirmDelete_Admin" style="background-color:#ffffff;  height: 15px; display: none;">
				<p style="margin: -9px 0 10px;" >Confirm Delete</p>
			</div>
<table class="userlistGrid" class="table-responsive table-striped table-bordered table-hover dataTable display" cellspacing="0" width="100%">
	
				<thead>
					<tr>
						<th>Content</th>
						<th></th> <th></th>
					</tr>
				</thead>
				<tbody>
					<% List <TestimonialAshok> testLists=TestimonialAshokLocalServiceUtil.getTestimonialAshoks(0, TestimonialAshokLocalServiceUtil.getTestimonialAshoksCount()) ;%>
		              <%for(TestimonialAshok list:testLists){ %>
			<tr data-id="<%=list.getId() %>">
						<td class="user-name"><%=list.getTestimonialContent() %></td>
						<td class="user-delete" ><button type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-remove"></span> Remove 
        </button></td>
	      	<td class="user-edit" ><button type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-edit"></span> Edit
        </button></td>
						
					</tr>
					<% } %>
					
				</tbody>
				
			</table>
<script>
initializeUserTable();

function initializeUserTable(){
	
	userlistTable = $('.userlistGrid').DataTable( {
		order: [[0, 'asc'] ],
        dom: 'frtip',
    
	});	
	
	$('.userlistGrid').addClass("table-striped").addClass("table-bordered");
}

$('.userlistGrid tbody .user-delete').off('click').on('click', function () { 
	debug = false; 
	console.log($(this).parent().data());
	var userId = $(this).parent().data("id");
	if(debug) console.log("Clicked userId:"+userId);
	
	$('#<portlet:namespace/>userid').val(userId);
	if(debug) console.log("opening dialog"); 
	$( "#confirmDelete_Admin" ).dialog( "open" );
} ); 


$('.userlistGrid tbody .user-edit').off('click').on('click', function () { 
	debug = false; 
	console.log($(this).parent().data().id);
	var userId = $(this).parent().data().id;
	$('#<portlet:namespace/>editid').val(userId);
	$('#editForm').submit();
} ); 
$("#confirmDelete_Admin").dialog({
		height:'130',
		width:'250',
		modal: true,
		autoOpen: false,
		draggable: false,
	buttons: {
		"Delete": function() {
			$( this ).dialog( "close" );
			$('#deleteForm').submit();
		},
		"Cancel": function() {
			$( this ).dialog( "close" );
		},
	}
	});
</script>

<aui:form>

<aui:input name="firstname" placeholder="enter first name">
  <aui:validator name="required"  errorMessage="please fill field">
 function() {
 return AUI.$("#<portlet:namespace />firstname").val();
                }
  </aui:validator>
</aui:input>
<liferay-ui:input-date  required="true" > </liferay-ui:input-date>
 <aui:button type="submit" value="submit" />
</aui:form> 

