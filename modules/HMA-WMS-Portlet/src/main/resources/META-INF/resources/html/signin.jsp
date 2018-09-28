<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/html/init.jsp"%>

<%
	String currentURL = PortalUtil.getCurrentURL(request);

	if(currentURL.contains("?")) currentURL = currentURL.split("\\?")[0];
%>

<div style="font-weight:bold;  font-size: 1.4em; text-align: center; background-color: #DDEEFF; padding: 20px;margin-top:20px;">
	<a href="/c/portal/login?redirect=<%=currentURL %>" rel="nofollow">Click here to login into the HMA Workforce Management System</a>
</div>