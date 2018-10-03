<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/cla/init.jsp" %>



<div class="row">
<div class="col-md-2">
<portlet:actionURL var="addKpi" name="addKpi"/>
<form name="addKpi" id="addKpi" action="<%=addKpi.toString() %>" method="post" name="update">
<button class="btn-success">Add New Data</button>
</form>
</div>

<div class="col-md-2">
<portlet:actionURL var="getfile" name="getfile"/>
<form name="getfileFrom" id="getfileFrom" action="<%=getfile.toString() %>" method="post" name="update">
<button   class="btn-success">Get Kpi Data</button>
</form> 
</div>
</div>