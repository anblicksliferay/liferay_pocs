<%@ include file="/init.jsp" %>

<div class="col-span 12">
<portlet:actionURL var="getfile" name="getfile"/>
<form name="getfileFrom" id="getfileFrom" action="<%=getfile.toString() %>" method="post" name="update">
<button   class="btn-success">get</button>
</form> 
</div>
  