<%-- 
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
 
<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>
 
<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">
 
	<aui:input type="file" name="fileupload" />
	<aui:input type="text" name="firstname" />
	<aui:button name="Save" value="Save" type="submit" />
 
</aui:form>


<portlet:resourceURL var="niceImageUrl">
</portlet:resourceURL>
<a onclick="addParamToAcnhor('<%=niceImageUrl%>');" >Download PDF</a>


<script>
function addParamToAcnhor(currentAncorObject){
	var newURL=currentAncorObject;
	window.open(newURL, '_blank');
	}


</script>

<portlet:actionURL name="addlocation" var="addlocationURL"></portlet:actionURL>

<aui:form action="<%= addlocationURL %>"  method="post">
 
	<aui:input type="text" name="location" />
	
	<aui:button name="Save" value="Save" type="submit" />
 
</aui:form> --%>


<%-- <div class="col-span 12">
<portlet:actionURL var="addUser" name="addUser"/>
<form name="adduserFrom" id="adduserFrom" action="<%=addUser.toString() %>" method="post" name="update">
<button  class="btn-success">Submit</button>
</form> 
</div>
 --%>
 
 <%@ include file="/init.jsp" %>
