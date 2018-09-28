<%@ include file="/init.jsp" %>

<div class="col-span 12">
<portlet:actionURL var="addUser" name="addUser"/>
<form name="adduserFrom" id="adduserFrom" action="<%=addUser.toString() %>" method="post" name="update">
<button  class="btn-success">Submit</button>
</form> 
 </div>