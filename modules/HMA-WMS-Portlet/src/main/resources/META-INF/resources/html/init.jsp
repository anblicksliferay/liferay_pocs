<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%@ page import="javax.portlet.PortletURL"%>
<% String wmsBasePath = "/group/workforce-management"; %>

<portlet:renderURL var="cancelURL" />
<%@page import="java.util.HashSet"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date"%>   
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale"%> 
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Calendar"%> 
<%@ page import="java.util.TimeZone"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.DateFormat"%>  
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.text.SimpleDateFormat"%> 
<%@page import="com.ys.hmawfm.wfms.utils.HondaPermissionKeys"%>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.Property"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.Junction"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_NotificationEngine"%>

<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_Config"%>
<%@ page import="com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil"%>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig"%>
<%@ page import="com.ys.hmawfm.wfms.services.service.WFMS_WorkflowConfigLocalServiceUtil"%>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_Position"%>
<%@ page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition"%>
<%@ page import="com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil"%>

<%@ page import="com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil"%>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_COS"%>
<%@ page import="com.ys.hmawfm.wfms.services.service.WFMS_Requisition_AuditLocalServiceUtil"%>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition_Audit"%>
<%@ page import="com.ys.hmawfm.wfms.services.service.WFMS_COS_AuditLocalServiceUtil"%>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_COS_Audit"%>
<%@ page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.Projection" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil" %>

<%@ page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil" %>
<%@ page import="com.ys.hmawfm.wfms.services.rest.CostCenterService" %>
<%@ page import="com.ys.hmawfm.wfms.services.rest.DepartmentService" %>
<%@ page import="com.ys.hmawfm.wfms.services.rest.DivisionService" %>
<%@ page import="com.ys.hmawfm.wfms.services.rest.UserService" %>
<%@ page import="com.ys.hmawfm.wfms.services.dao.HMADB2Connection" %>
<%@ page import="com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService" %>
<%@ page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@ page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil" %>
<%@ page import="com.ys.hmawfm.wfms.utils.ConfigUtility" %>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>

<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil" %> 
<%@page import="com.liferay.portal.kernel.dao.orm.Disjunction" %>

<%@page import="javax.portlet.ResourceRequest"%>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
 <portlet:renderURL var="generateReqPopupURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/html/position/generateReqPopup.jsp" />
</portlet:renderURL>
<portlet:renderURL var="generateReqPopupURLFromUpdatePosition"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/html/position/generateReqPopupInUpdate.jsp" />
</portlet:renderURL>

<portlet:renderURL var="generateInternetConnection"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/html/position/generateInternetConnectionDown.jsp" />
</portlet:renderURL>

<portlet:renderURL var="generateReqPopupURLAfterTerminateAssociate"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/html/position/generateReqPopupInTerminate.jsp" />
</portlet:renderURL>
<%@ page import="com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit"%>
<%@page import="com.ys.hmawfm.wfms.workflow.WorkflowConstants"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalService"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil"%>
<portlet:resourceURL var="resourceURL"/>
<aui:form action="<%=resourceURL.toString() %>" method="post" name="update"></aui:form>
<!-- jQuery is supplied by theme, holding on removing for now however would like to clean up before finalizing project to avoid conflicts. -->
<script src="<%=request.getContextPath()%>/js/js.cookie.js" type="text/javascript"></script> 
<link href="<%=request.getContextPath()%>/js/chosen_v1.6.2/chosen.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/chosen_v1.6.2/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-modal.js"></script>
<script>
    define.amd = define._amd 
</script>