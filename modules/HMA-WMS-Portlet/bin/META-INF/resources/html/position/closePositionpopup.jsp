<%@ include file="/html/init.jsp"%>
<%
String posId=request.getParameter("positionId");
%>
<div class="portlet-layout row">
	<div class="col-sm-5">
	<button style="width:100%;" class="btn btn-primary" type="button" onclick="closepositionclickevent('yes');">Yes</button>
	</div>
	<div class="col-sm-2"></div>
	<div class="col-sm-5">
   		 <button style="width:100%;" class="btn btn-primary" type="button" onclick="closepositionclickevent('no');">No</button>
	</div>
</div>


