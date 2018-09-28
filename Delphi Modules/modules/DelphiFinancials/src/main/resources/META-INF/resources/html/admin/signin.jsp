<%@ include file="/html/admin/init.jsp"%>

<%
	String currentURL = PortalUtil.getCurrentURL(request);

	if(currentURL.contains("?")) currentURL = currentURL.split("\\?")[0];
%>

<div style="font-weight:bold;  font-size: 1.4em; text-align: center; padding: 20px;">
	<a href="/c/portal/login?redirect=<%=currentURL %>" rel="nofollow">Click here to login into the Financial Dashboard Administration</a>
</div>