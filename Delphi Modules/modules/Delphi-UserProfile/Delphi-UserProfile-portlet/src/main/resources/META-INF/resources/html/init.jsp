<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale"%> 
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Set" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.ResourceURL" %>
<%@ page import="javax.portlet.UnavailableException" %>
<%@ page import="javax.portlet.ValidatorException" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.model.Phone" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>

<%@ page import="com.delphi.userprofile.model.UserProfile" %>
<%@ page import="com.delphi.userprofile.model.UserAccessRequest" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:renderURL var="generateEnterPhoneURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="jspPage" value="/html/enterPhoneNumber.jsp" />
</portlet:renderURL>

<portlet:resourceURL var="resourceURL"/>

<aui:form action="<%=resourceURL.toString() %>" method="post" name="update"></aui:form>


<liferay-frontend:defineObjects />

<portlet:defineObjects />

<%
	Set<Locale> locales = (Set<Locale>)renderRequest.getAttribute("locales");

	UserProfile userProfile = (UserProfile)renderRequest.getAttribute("userProfile");
	String requestStatuses = (String)renderRequest.getAttribute("requestStatuses");
	boolean userIsDelphiSuperAdmin = (boolean)renderRequest.getAttribute("userIsDelphiSuperAdmin");
	

	String preferenceContactInfo = "{}";
	if(null!=userProfile.getCommunicationPreferences()){
		preferenceContactInfo = userProfile.getCommunicationPreferences();
	}	

	String languageId = user.getLanguageId();
	String timeZoneId = user.getTimeZoneId();
	
	String selectedRegion = userProfile.getRegion();
	String selectedSite = userProfile.getSite();
	String selectedDivision = userProfile.getDivision();
	String selectedLanguage = userProfile.getLanguage();
	String selectedTimeZone = userProfile.getTimezone();
	
	String preferenceWorkHours = "{}";
	if(null!=userProfile.getWorkHours()){
		preferenceWorkHours = userProfile.getWorkHours();
	}	
	
	String preferenceActivitiesOfInterest = "{}";
	if(null!=userProfile.getInterests()){
		preferenceActivitiesOfInterest = userProfile.getInterests();
	}	
	
	String preferenceJobRole = "{}";
	if(null!=userProfile.getJobrole()){
		preferenceJobRole = userProfile.getJobrole();
	}	
	
	String preferencePortlets = "{}";
	if(null!=userProfile.getPortlets() && !userProfile.getPortlets().equalsIgnoreCase("")){
		preferencePortlets = userProfile.getPortlets();
	}	
	
	System.out.println("preferencePortlets:"+preferencePortlets);
	
%>

<script>
    define._amd = define.amd;
    define.amd = false;
</script>

<script src="<%=request.getContextPath()%>/js/jquery.plugin.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.datepick.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/redmond.datepick.css">
<script src="<%=request.getContextPath()%>/js/dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/chosen.min.css" />
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-chosen.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dataTables.min.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.timepicker.css" />
<script src="<%=request.getContextPath()%>/js/switchery.min.js" ></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/switchery.min.css" >

<script>
    define.amd = define._amd 
</script>