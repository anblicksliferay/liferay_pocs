<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.astra.workflowservice.service.RegistrationLocalServiceUtil"%>
<%@page import="com.astra.workflowservice.model.Registration"%>

<%
List<Registration> List = RegistrationLocalServiceUtil.getRegistrations(0, RegistrationLocalServiceUtil.getRegistrationsCount());
List<Registration> userList = new ArrayList<Registration>();
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
for (Registration registration : List) {
	if(registration.getUserId() == themeDisplay.getUser().getUserId()){
		userList.add(registration);
	}	
}
request.setAttribute("userList", userList);
%>

<body>
  <table id="example" class="table table-bordered table-striped" style="width:100%">
    <thead>
      <tr>
       <th>Name</th>
       <th>Course</th>
       <th>Status</th>
       <th>Comments</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
       <tr>
       <td>${user.firstname}</td>
       <td>${user.course}</td>
       <td>${user.status}</td>
       <td>${user.comments}</td>
       </tr>
    </c:forEach>
     
    </tbody>
  </table>
  
  <script>
  $(function(){
    $("#example").dataTable({
    	 "iDisplayLength":25, // default page size
         "aLengthMenu": [
           [25, 100, 200, -1],   // per page record options
           [25, 100, 200, "All"]
         ],
         "bLengthChange": true, //Customizable page size 
         "bSort": false, // for Soring
         "bFilter": true, //search box
         "aaSorting": [],
         "aoColumns": [{// Columns width
           "sWidth": "15%"
         }, {
           "sWidth": "10%"
         },  {
           "sWidth": "10%"
         }, {
           "sWidth": "40%"
         },],
         "bAutoWidth": false,
         "oLanguage": {
           "sSearch": "Search: ",
           "sEmptyTable": "<div class='portlet-msg-alert'>No User Found</div>" // default message for no data
         },
         "sPaginationType": "full_numbers"
    });
  })
  </script>
</body>

<!-- <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.7/css/jquery.dataTables.css">

<portlet:resourceURL var="getRegistrationData"></portlet:resourceURL>

<script type="text/javascript">
$(document).ready(function(){
	 $.ajax({
        url: '${getRegistrationData}',
        data: {
            <portlet:namespace />cmd: 'getRegistrationData',
        },
        type: "POST",
        dataType: "text",
        success: function(data) {
        	console.log("JSON_DATA :  "+data); 
        	var json = data;
        	 $('#userTable').dataTable( {
                 "ajax": {
                   "dataSrc": "json"
                  },
                 "columns": [
                     { "data": "Name" },
                     { "data": "Course" },
                     { "data": "Status" },
                     { "data": "Comments" }
                 ]
             } );
        },
        error: function () {
            console.log("Error occured on server.");
        }
        });	 
});


</script> -->