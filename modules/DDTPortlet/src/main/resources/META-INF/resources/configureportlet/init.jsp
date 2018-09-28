

<portlet:defineObjects />

<liferay-theme:defineObjects />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<script>
    define._amd = define.amd;
    define.amd = false;
</script>


<%@page import="com.ddt.service.TestimonialAshokLocalServiceUtil"%>
<%@page import="com.ddt.model.TestimonialAshok"%>
<%@page import="java.util.List"%>
<script src="<%=request.getContextPath()%>/js/dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/js/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-chosen.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dataTables.min.css" type="text/css">
