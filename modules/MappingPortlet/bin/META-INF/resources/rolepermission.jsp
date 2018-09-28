<%@page import="java.util.ArrayList"%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<h1>Role Checking in Liferay </h1>
<%
List<Role> userRoles = user.getRoles();
List<String> roles = new ArrayList<String>();
for(Role r : userRoles){
	roles.add(r.getName());
}
if(roles.contains("Role-A") || roles.contains("Administrator")){%>
	<button>button1</button>	
<%}
if(roles.contains("Role-B") || roles.contains("Administrator")){ %>
	<button>button2</button>
<%}
if(roles.contains("Role-C") || roles.contains("Administrator")){%>
	<button>button3</button>
<%}%>

<%-- <c:forEach var="role" items="<%= userRoles %>">
<c:if test="${role.getName() == 'Student'}">
<h2>Student can See This.</h2><br>
</c:if>

<c:if test="${role.getName() == 'Teacher'}">
<h2>Teacher can See This.</h2><br>
</c:if>
</c:forEach> --%>








