<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %> 
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %> 
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %> 
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> 
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortletKeys" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil" %>

<script>
	AmCharts_path="/o/delphi-mfg-theme/amcharts/amcharts_3.21.2/amcharts";
</script>

<script src="/o/delphi-mfg-theme/amcharts/amcharts_3.21.2/amcharts/amcharts.js"></script>
<script src="/o/delphi-mfg-theme/amcharts/amcharts_3.21.2/amcharts/plugins/export/export.min.js"></script>
<script src="/o/delphi-mfg-theme/amcharts/amcharts_3.21.2/amcharts/themes/light.js"></script>
<script src="/o/delphi-mfg-theme/amcharts/amcharts_3.21.2/amcharts/gauge.js"></script>
<script src="/o/delphi-mfg-theme/amcharts/amcharts_3.21.2/amcharts/serial.js"></script>

<script>
    define._amd = define.amd;
    define.amd = false;
</script>

<script src="<%=request.getContextPath()%>/js/dataTables.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dataTables.min.css" type="text/css">
<script src="<%=request.getContextPath()%>/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-chosen.css" type="text/css">
<!-- <link rel="stylesheet" href="/inspinia-theme/css/jquery-ui.css">  -->

<script>
    define.amd = define._amd 
</script>

<div id="notifications-context" style="display:none">
	<div class="portlet-context-path"><%=request.getContextPath()%></div>
	<div class="portlet-namespace"><portlet:namespace /></div>
	<div class="alert-count">{}</div>
</div>