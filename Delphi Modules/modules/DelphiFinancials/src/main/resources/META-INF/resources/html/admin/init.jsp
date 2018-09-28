<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %> 
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %> 
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<% String basePath = "/web/guest"; %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<portlet:renderURL var="cancelURL" />

<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date"%>   
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale"%> 
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Calendar"%> 
<%@ page import="java.util.TimeZone"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.DateFormat"%>  
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>

<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="java.text.SimpleDateFormat"%> 
<%@ page import="java.text.DateFormatSymbols"%>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PortletKeys" %>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<%@ page import="com.delphi.portlet.model.NameId"%>

<script src="<%=request.getContextPath()%>/js/editablegrid-master/editablegrid.js"></script>
<script src="<%=request.getContextPath()%>/js/editablegrid-master/editablegrid_renderers.js" ></script>
<script src="<%=request.getContextPath()%>/js/editablegrid-master/editablegrid_validators.js" ></script>
<script src="<%=request.getContextPath()%>/js/editablegrid-master/editablegrid_utils.js" ></script>
<script src="<%=request.getContextPath()%>/js/editablegrid-master/editablegrid_charts.js" ></script>
<script src="<%=request.getContextPath()%>/js/editablegrid-master/editablegrid_editors.js" ></script>

<!-- <script src="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/external/jquery/jquery.js"></script>  -->
 
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.js"></script> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.min.css" type="text/css" media="screen">


<script src="<%=request.getContextPath()%>/js/main-admin.js?v=<%=new Date().getTime()%>"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main-admin.css" type="text/css" >
<% 
	List<NameId> sites = (List<NameId>) request.getAttribute("sites");
	
	String url = PortalUtil.getCurrentURL(request); 

	Calendar currentCal = Calendar.getInstance();
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.YEAR,2);
	cal.set(Calendar.MONTH,0);

	int siteId = 1;
	int expenseId = 1;
	int year = currentCal.get(Calendar.YEAR);
	String month = new DateFormatSymbols().getMonths()[currentCal.get(Calendar.MONTH)];
	
	if(null!=HttpUtil.getParameterMap(url).get("adminSiteId"))
		siteId = Integer.parseInt( HttpUtil.getParameterMap(url).get("adminSiteId")[0] );
	
	if(null!=HttpUtil.getParameterMap(url).get("year"))
		year = Integer.parseInt( HttpUtil.getParameterMap(url).get("year")[0] );

	if(null!=HttpUtil.getParameterMap(url).get("month"))
		month =  HttpUtil.getParameterMap(url).get("month")[0];

	if(null!=HttpUtil.getParameterMap(url).get("expenseId")){

		
		expenseId = Integer.parseInt( HttpUtil.getParameterMap(url).get("expenseId")[0] );
	}
%>

<div id="financialdashboard-context" style="display:none">
	<div class="portlet-context-path"><%=request.getContextPath()%></div>
	<div class="portlet-namespace"><portlet:namespace /></div>
</div>