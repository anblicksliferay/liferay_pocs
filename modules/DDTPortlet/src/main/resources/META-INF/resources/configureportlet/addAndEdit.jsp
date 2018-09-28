<%@page import="com.testformByAdmin.TestMonailByadmin"%>
<%@page import="com.ddt.service.TestimonialAshokLocalServiceUtil"%>
<%@page import="com.ddt.model.TestimonialAshok"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<% TestimonialAshok testimonialAshok=null;
String id = (String) request.getAttribute("editid");
if(Validator.isNotNull(id)){  testimonialAshok= TestimonialAshokLocalServiceUtil.getTestimonialAshok(Long.parseLong(id));
}
%>

<portlet:actionURL var="addOreditProfile" name="addOreditProfile"/>
<form name="addOreditForm" id="addOreditForm" action="<%=addOreditProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>editid" name="<portlet:namespace/>editid" value=" <%=testimonialAshok.getId()%>"/>
  Content : 	<textarea rows="4" cols="50">   <%=testimonialAshok.getTestimonialContent()%>
</textarea>
</form>


