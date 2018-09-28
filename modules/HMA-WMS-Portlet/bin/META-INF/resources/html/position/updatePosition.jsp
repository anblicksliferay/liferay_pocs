<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Position_Audit"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.ys.hmawfm.wfms.utils.ConfigUtility"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_COS"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Position"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@page import="com.ys.hmawfm.wfms.workflow.WorkflowConstants"%>
<%@page import="com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaPermissionKeys"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_Position_AuditLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ include file="/html/init.jsp"%>
<%@ page trimDirectiveWhitespaces="true" %>
<% boolean showNotify=false;
	User userdata = themeDisplay.getUser();
	List<Role> roleIds = userdata.getRoles();
	String checkDepartment = "1";
	for (Role rolenames : roleIds) {
		if (rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_SPDM)
				|| rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_CMP)
				|| rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_Administrator) 
			   	|| rolenames.getName().equalsIgnoreCase(HondaPermissionKeys.ROLE_Owner) ) {
			checkDepartment = "0";
		}
	}
%>
<portlet:actionURL name="updateForPosition" var="updateForPositionURL"> </portlet:actionURL>
<portlet:actionURL name="cancelPosition" var="cancelPosition"> </portlet:actionURL>
<portlet:actionURL name="saveEmpIdForPosition" var="saveEmpIdForPosition"> </portlet:actionURL>
<portlet:actionURL name="newNotifications" var="newNotificationsURL"> </portlet:actionURL>
<portlet:actionURL name="manageNotifications" var="manageNotificationsURL"> </portlet:actionURL>
<portlet:actionURL name="swapAssociate" var="swapAssociateURL"></portlet:actionURL>
<portlet:renderURL var="varURL"><portlet:param name="backURL" value="<%=themeDisplay.getPortletDisplay().getURLBack()%>"></portlet:param>
</portlet:renderURL>
<%
	Map<String,String> deptMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
	String autoReqForModal = (String) request.getAttribute("autoReq");
	String mpCatBudgetValue = (String) request.getAttribute("mpCatBudgetValue");
	String addAssociateModal = (String) request.getAttribute("addAssociate");
	String filledmodal = (String) request.getAttribute("filledmodal");
	String ModifyPosPopUpforReq = (String) request.getAttribute("ModifyPosPopUpforReq");
	String pId = (String) request.getAttribute("positionId");
	String statusValue = (String) request.getAttribute("statusValue");
    PortletURL modifyPositionURL = renderResponse.createActionURL();
	modifyPositionURL.setParameter("javax.portlet.action", "modifyPosition");
	modifyPositionURL.setParameter("pid", pId);
	PortletURL approvePositionForModifyURL = renderResponse.createActionURL();
	approvePositionForModifyURL.setParameter("javax.portlet.action", "approvePositionForModify");
	approvePositionForModifyURL.setParameter("positionId", pId);
	approvePositionForModifyURL.setParameter("flowControl", "true");
	PortletURL DiscardURL = renderResponse.createActionURL();
	DiscardURL.setParameter("javax.portlet.action", "discardPosition");
	DiscardURL.setParameter("pid", pId);
	PortletURL Discardstep2URL = renderResponse.createActionURL();
	Discardstep2URL.setParameter("javax.portlet.action", "discardsecondPosition");
	Discardstep2URL.setParameter("pid", pId);
	PortletURL ApproveURL = renderResponse.createActionURL();
	ApproveURL.setParameter("javax.portlet.action", "approvePosition");
	ApproveURL.setParameter("pid", pId);
	PortletURL ApproveURLForYes = renderResponse.createActionURL();
	ApproveURLForYes.setParameter("javax.portlet.action", "approvePositionForYes");
	ApproveURLForYes.setParameter("pid", pId);
	PortletURL FinalApproveURL = renderResponse.createActionURL();
    FinalApproveURL.setParameter("javax.portlet.action", "finalApprovePosition");
    FinalApproveURL.setParameter("pid", pId);
 	PortletURL OpenActionURL = renderResponse.createActionURL();
	OpenActionURL.setParameter("javax.portlet.action", "reopenPosition");
	OpenActionURL.setParameter("pid", pId);
	PortletURL AddAssociateActionURL = renderResponse.createActionURL();
	AddAssociateActionURL.setParameter("javax.portlet.action", "addAssociatePosition");
	AddAssociateActionURL.setParameter("pid", pId);
	String[] values = null;
	WFMS_Position wfmPosition = WFMS_PositionLocalServiceUtil.getByPositionId(pId);
	int wfmPositionforTempcount=0;
	boolean existedCosStatus=false;
	List<WFMS_COS> cos_list=null;
	if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)){
		DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
		dynamicQueryForCos.add(PropertyFactoryUtil.forName("assoicateId").eq(wfmPosition.getAssociateNumber()));
		dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
		Criterion Coscriterion = null;
		Coscriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.COS_DRAFT);
		Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT));
		dynamicQueryForCos.add(Coscriterion);
		Long cosList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos);
		if(cosList>0){
			existedCosStatus=true;
		}
	}
	if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING)){
	DynamicQuery wfmPositionforTemp =WFMS_PositionLocalServiceUtil.dynamicQuery();
	wfmPositionforTemp.add(PropertyFactoryUtil.forName("pId").eq(pId+"-WFM"));
	wfmPositionforTempcount = (int) WFMS_PositionLocalServiceUtil.dynamicQueryCount(wfmPositionforTemp);	
	if(wfmPositionforTempcount > 0 && !HondaPermissionKeys.POS_MODFIED.equalsIgnoreCase(wfmPosition.getStatus())){		
		WFMS_Position wfmPositionTemp = WFMS_PositionLocalServiceUtil.getByPositionId(pId+"-WFM");   
		wfmPosition.setReportsTo(wfmPositionTemp.getReportsTo());
		wfmPosition.setAutoGenerateReq(wfmPositionTemp.getAutoGenerateReq());
		wfmPosition.setCritical(wfmPositionTemp.getCritical());
		wfmPosition.setLine(wfmPositionTemp.getLine());
		wfmPosition.setLadder(wfmPositionTemp.getLadder());
		wfmPosition.setType(wfmPositionTemp.getType());
		wfmPosition.setLevel(wfmPositionTemp.getLevel());
		wfmPosition.setLeadershipAssignment(wfmPositionTemp.getLeadershipAssignment());
		wfmPosition.setCategory(wfmPositionTemp.getCategory());
		wfmPosition.setSubCategory(wfmPositionTemp.getSubCategory());
		wfmPosition.setDescription(wfmPositionTemp.getDescription());
		wfmPosition.setTypicalJobTitle(wfmPositionTemp.getTypicalJobTitle());
		wfmPosition.setMinJobKnowHow(wfmPositionTemp.getMinJobKnowHow());
		wfmPosition.setDuties(wfmPositionTemp.getDuties());
		wfmPosition.setReasonsFor(wfmPositionTemp.getReasonsFor());
		wfmPosition.setTasksPerformed(wfmPositionTemp.getTasksPerformed());
		wfmPosition.setLengthOfService(wfmPositionTemp.getLengthOfService());
		wfmPosition.setDegree(wfmPositionTemp.getDegree());
		wfmPosition.setReqSkills(wfmPositionTemp.getReqSkills());
		wfmPosition.setDesiredSkills(wfmPositionTemp.getDesiredSkills());
		wfmPosition.setEnvironment(wfmPositionTemp.getEnvironment());
		wfmPosition.setWeeklyOvertime(wfmPositionTemp.getWeeklyOvertime());
		wfmPosition.setFrequencyOfTravel(wfmPositionTemp.getFrequencyOfTravel());
		wfmPosition.setEmpCategory(wfmPositionTemp.getEmpCategory());
		wfmPosition.setEmpCategoryDesc(wfmPositionTemp.getEmpCategoryDesc());
		wfmPosition.setWorkforceCategory(wfmPositionTemp.getWorkforceCategory());
		wfmPosition.setComments(wfmPositionTemp.getComments());
		wfmPosition.setOther(wfmPositionTemp.getOther());
	}
	}
	 boolean ismodifed=WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.NOTDM_POSITION,
			 wfmPosition.getDepartmentNumber());
%>
<portlet:actionURL name="closePosition" var="closePositionURL"> 
<portlet:param name="pid" value="<%=pId %>"/>
</portlet:actionURL>
<aui:form method="post" action="<%=closePositionURL.toString()%>" name="closePosition" id="closePosition">
<aui:input id="yesorno" type="hidden" name="yesorno" />
	<aui:input id="positionid" type="hidden" name="pid" value="<%=pId%>" />
</aui:form>
	<portlet:renderURL var="closepositionYesorNoURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/html/position/closePositionpopup.jsp" />
		<portlet:param name="positionId" value="<%=pId %>"/>
</portlet:renderURL>
<aui:form method="post" action="<%=cancelPosition.toString()%>" name="cancelPosition" id="cancelPosition">
	<aui:input id="positionid" type="hidden" name="positionid" value="<%=pId%>" />
</aui:form>
<portlet:actionURL name="terminateAssociate" var="terminateAssociateURL">
	<portlet:param name="actionposition"  value="actionposition" />
	<portlet:param name="positionId" value="<%=pId%>" />
</portlet:actionURL>
<aui:form method="post" action="<%=terminateAssociateURL.toString()%>" name="terminateAssociate" id="terminateAssociate">
	<aui:input name="modalvalue" type="hidden"></aui:input>
	<aui:input id="positionid" type="hidden" name="positionId" value="<%=pId%>" />
</aui:form>
<div class="row text-center">
	<div class="col-sm-12" style="margin-bottom: 10px;">
    <c:if test="<%=wfmPosition.getWorkflowStep()==18%>">
    <%if(WMSUserAccessUtil.checkButtonVisibility(renderRequest, wfmPosition.getWorkflowStep(),wfmPosition.getDepartmentNumber(),PortletPropsPermission.BTN_YES)){ %>
		  <p>Is employee category correct based on changes?</p>
			<div class="col-sm-6 text-right">
				<aui:button class="btn btn-primary" type="button"
					value="Yes"
					onclick="modifyEmpCat('yes')"></aui:button>
			</div>
			<div class="col-sm-6 text-left">
				<button type="button" class="btn btn-primary" type="button"
				id="cancel" data-toggle="modal" data-backdrop="static" data-target="#employeeCategoryId">No </button>
			</div>
	<%}%>
	</c:if>
	</div>
</div>
<c:set var="modal" value="<%=autoReqForModal%>" />
<c:set var="modal1" value="<%=wfmPosition.getAutoGenerateReq()%>" />
<c:set var="modal2" value="<%=wfmPosition.getStatus()%>" />
<c:set var="ADD_RS_1"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.POS_RS1,
					wfmPosition.getDepartmentNumber())%>"
	scope="page" />
<c:set var="ADD_RS_2"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.POS_RS2,
					wfmPosition.getDepartmentNumber())%>" />
<c:set var="EDIT_RS_2"
	value="<%=(WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.POS_RS2,
					wfmPosition.getDepartmentNumber())
					&& RoleLocalServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
							StringUtil.split(HondaPermissionKeys.ROLE_DMP, StringPool.COMMA), true))%>" />
<c:set var="ADD_RS_3"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.POS_RS3,
					wfmPosition.getDepartmentNumber())%>" />
<%
	String EDIT_RS1 = GetterUtil.getBoolean(pageContext.getAttribute("ADD_RS_1")) ? "" : "disabled-fields";
	String EDIT_RS2 = GetterUtil.getBoolean(pageContext.getAttribute("ADD_RS_2")) ? "" : "disabled-fields";
	String EDIT_RS3 = GetterUtil.getBoolean(pageContext.getAttribute("ADD_RS_3")) ? "" : "disabled-fields";
%>
 <c:set var="EDIT_POS"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.POS_EDIT,
						wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="CLOSE_POS"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.POS_CLOSE,
						wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="RE_OPN_CLOSE_POS"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,
			PortletPropsPermission.POS_REOPEN, wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="MOVE_ASSOCIATE"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,
			PortletPropsPermission.POS_MOV_ASS, wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="SWAP_ASSOCIATE"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,
			PortletPropsPermission.POS_SWAP_ASS, wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="TERM_ASSOCIATE"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,
			PortletPropsPermission.POS_TER_ASS, wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="MOVE_ASSOCIATE_TO_DRCT"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,
			HondaPermissionKeys.MOVE_ASSOCIATE_TO_DRCT, wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="ADD_ASSOCIATE"
	value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.POS_ADD_ASS,
						wfmPosition.getDepartmentNumber())%>"></c:set>
<c:set var="APPROVE_DATA"
	value="<%=WMSUserAccessUtil.getApprovePermissions(renderRequest, wfmPosition.getWorkflowStep(),wfmPosition.getDepartmentNumber())%>" />
<c:set var="DIS_APPROVE_DATA"
	value="<%=WMSUserAccessUtil.getApprovePermissions(renderRequest, wfmPosition.getWorkflowStep(),wfmPosition.getDepartmentNumber())%>" />

<aui:form method="post" action="<%=terminateAssociateURL.toString()%>" name="terminateAssociate" id="terminateAssociate">
	<aui:input name="modalvalue" type="hidden"></aui:input>
	<aui:input id="positionid" type="hidden" name="positionId" value="<%=pId%>" />
</aui:form>
<%
String thirdsetDataRequired="1";//required attribute is added to third set data
String fourthsetDataRequired="1";//required attribute is added to fourth set data
%>
<aui:script>
$(document).ready(function (){

	<% if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING)){ %>
	$('#firstsetData :input').attr('disabled', true);
    $('#secondsetData :input').attr('disabled', true);
	$('#thirdsetData :input').attr('disabled', true);
	$('#fourthsetData :input').attr('disabled', true);
     $('#fifthsetData :input').prop('disabled', true);
	$('#addData').click(function() {
		    $("#saveId").show();
			$("#submitId").show();
		<% if(wfmPosition.getWorkflowStep()==40){  
			thirdsetDataRequired="0";
		    fourthsetDataRequired="0"; %>
		    $(".duties_iebrowser").remove();
			$( "#dutiesresponsibilities_iebrowser" ).show();
			$(".relevant_knowledge").remove();
			$( "#minimum_knowledge" ).show();
			$(".Daily_task").remove();
			$( "#Daily_Performed" ).show();
			$(".Relevant_Experience").remove();
			$( "#Relevant_Experience_job" ).show();
			$(".certification_required").remove();
			$( "#degree_certification_required" ).show();
			$(".Required_Skills").remove();
			$( "#Required_Skills_musts" ).show();
			$(".skills_and_Abilities").remove();
			$( "#skills_and_Abilities_wants" ).show();
		    $('#secondsetData :input').prop('disabled', false);
		    $('#firstsetData :input').prop('disabled', true);
	        $('#thirdsetData :input').prop('disabled', true);
	        $('#fourthsetData :input').prop('disabled', true);
	        jQuery(".chosen-container").data("placeholder","Select Frameworks...").chosen({search_contains:true});
		<% }
		else if(wfmPosition.getWorkflowStep()==50){ 
			thirdsetDataRequired="0";
		    fourthsetDataRequired="0";
		    %>
		    $('#secondsetData :input').prop('disabled', true);
	        $('#firstsetData :input').prop('disabled', true);
	        $('#thirdsetData :input').prop('disabled', true);
	        $('#fourthsetData :input').prop('disabled', true);
	        $('#thirdsetData').hide();
		<% }
		else if(wfmPosition.getWorkflowStep()==60){
			thirdsetDataRequired="0";
	        fourthsetDataRequired="0"; %>
		 $('#secondsetData :input').prop('disabled', true);
	        $('#firstsetData :input').prop('disabled', true);
	        $('#thirdsetData :input').prop('disabled', true);
	        $('#fourthsetData :input').prop('disabled', true);
	         $('#fifthsetData :input').prop('disabled', true);
	        $("#<portlet:namespace />mcomments").removeAttr("disabled");
		<% } 
		else if(wfmPosition.getWorkflowStep()==70){ 
			 fourthsetDataRequired="0";%>
		    $('#secondsetData :input').prop('disabled', true);
	        $('#firstsetData :input').prop('disabled', true);
	        $('#thirdsetData :input').prop('disabled', false);
	        $('#fourthsetData :input').prop('disabled', true);
	         $('#fifthsetData :input').prop('disabled', true);
	        jQuery(".thirdsetchosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
		<% } else if(wfmPosition.getWorkflowStep()==80){ 
			 fourthsetDataRequired="0";
           }%>
		
    }); 
	<% }else if(wfmPosition.getWorkflowStep()==-1){ %>
	
		$("#_Position_modify_position_ie").click(function(){
			$(".duties_iebrowser").remove();
			$( "#dutiesresponsibilities_iebrowser" ).show();
			$(".relevant_knowledge").remove();
			$( "#minimum_knowledge" ).show();
			$(".Daily_task").remove();
			$( "#Daily_Performed" ).show();
			$(".Relevant_Experience").remove();
			$( "#Relevant_Experience_job" ).show();
			$(".certification_required").remove();
			$( "#degree_certification_required" ).show();
			$(".Required_Skills").remove();
			$( "#Required_Skills_musts" ).show();
			$(".skills_and_Abilities").remove();
			$( "#skills_and_Abilities_wants" ).show();
			});
		
	       	$('#secondsetData :input').prop('disabled', true);
	        $('#firstsetData :input').prop('disabled', true);
	        $('#thirdsetData :input').prop('disabled', true);
	        $('#fourthsetData :input').prop('disabled', true);
	         $('#fifthsetData :input').prop('disabled', true);
	       
		<% }else if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){%>
       	$('#secondsetData :input').prop('disabled', true);
        $('#firstsetData :input').prop('disabled', true);
        $('#thirdsetData :input').prop('disabled', true);
        $('#fourthsetData :input').prop('disabled', true);
         $('#fifthsetData :input').prop('disabled', true);
        jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	<% }	
	 else { if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)){ %> 
	 $('#secondsetData').hide();
	  $('#thirdsetData').hide();
	   $('#fourthsetData').hide();
	    $('#fifthsetData').hide();
	 jQuery(".chosen-container").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 jQuery(".thirdsetchosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 jQuery(".chosenAssociate").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 <% }else{%>
		  jQuery(".chosen-container").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 jQuery(".thirdsetchosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 jQuery(".chosenAssociate").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	 <% } }%>
});
</aui:script>
<% if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN)){  %>
<portlet:actionURL name="mpCatBudgetForAsscociate" var="mpCatBudgetURL"></portlet:actionURL>
<div class="container" >
<div class="modal fade" id="mpcatBudget" role="dialog" style="display:none;">
	<div class="modal-dialog">
		<aui:form method="post" action="<%=mpCatBudgetURL.toString()%>" name="mpCatBudgetForAsscociate" id="mpCatBudgetForAsscociate">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" style="margin-top:11px;">&times;</button>
                    </div>
				<div class="modal-body"
					style="max-height: 250px;">
					<div class="portlet-layout row">
						<div
							class="portlet-column portlet-column-first col-sm-6 sectionLabel ">Please select Manpower Category Filled With </div>
						<div class="portlet-column portlet-column-last col-sm-6" id="mpCatBudgetAss_maindiv">
							<aui:input name="posid" type="hidden" value="<%=pId%>"></aui:input>
							<aui:select name="mpCatBudgetAss" id="mpCatBudgetAss" class="field-select"
								placeholder="" label=""  onChange="HmaContract()">
								<aui:option value="">Select MP Category Filled With</aui:option>
								<%
									values = ConfigUtility.getInputValuesFromConfig("position-mpcategoryfilledwith");
											Arrays.sort(values);
											for (String value : values) {
								%>
								<aui:option value="<%=value%>"><%=value%></aui:option>
								<%
									}
								%>
							</aui:select>
							 <div id="mpCatBudgetAss_ValidationMessage" class="form-validator-stack help-inline customErroeClass" style="display: none;">
                        Missing required value for the field "Manpower Category Filled With"
                        </div>
						</div>
					</div>

				</div>
				<div class="modal-footer" style="margin-top: 30px;">
					<div class="col-sm-6 text-right">
						<aui:button type="submit" class="btn btn-primary" onclick="return HmaContractValidate();" value="Save"
							name="mpCatBudgetForAsscociate"></aui:button>
					</div>
					<div class="col-sm-6 text-left">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</aui:form>
</div>
</div>
</div>
<%
	String associatenumber = (String) request.getAttribute("associatenumber");
	String mpCatBudgetAss = (String) request.getAttribute("mpCatBudgetAss");
%>
<portlet:actionURL name="saveAssociatedata" var="saveAssociatedataURL"></portlet:actionURL>
<div class="container">
<div class="modal fade" id="assdetailsAddId" role="dialog" style="display:none;">
	<div class="modal-dialog">
		<aui:form method="post" action="<%=saveAssociatedataURL.toString()%>" name="saveAssociatedata" id="saveAssociatedata">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
                             <style>
                                 .chosen-container .chosen-results{
                                     max-height: 65px;
                                 }
                             </style>
                             <div class="modal-body " style="height: 145px;">
					<div class="portlet-column portlet-column-first row">
						<aui:input name="posid" type="hidden" value="<%=pId%>"></aui:input>
						<aui:input name="mpCatBudgetAss" type="hidden" value="<%=mpCatBudgetAss%>"></aui:input>

						<div class="portlet-column portlet-column-first col-sm-5">
							<span class="sectionLabel">Filled with Associate Number</span>
						</div>
						<div class="portlet-column portlet-column-last col-sm-6" id="associatenumber_maindiv">
							 <select class="chosenAssociateNumber" style="width: 260px;height: 50px;" size="4"
								name="<portlet:namespace/>associatenumber" id="associatenumber"
								label="" onchange="associateNameChange();">
								<option value="">Select Filled with Associate Number</option>
								 <%
								 String 	sb= HondaLogicUtil.getassoNumbersByFilterd("", WorkflowConstants.POSITION_ACTOIN);
									Map<String, String> assNumbersMap  = HMAAssociateInfoService.getAssociateNumbersWithNaTable("Position",sb.toString());
									Map<String,String> treeMap = new TreeMap<String, String>(assNumbersMap);
									
									for (String associateNumber : treeMap.keySet()) {
										String ASSOCIATE_NUMBER = associateNumber;
										String ASSOCIATE_NAME = assNumbersMap.get(associateNumber);
								%>
								 <option value="<%=ASSOCIATE_NUMBER%>"><%=ASSOCIATE_NUMBER%>--<%=ASSOCIATE_NAME%></option>
								<% } %> 
							</select> 
							<aui:script>
                        jQuery(".chosenAssociateNumber").data("placeholder","Select Frameworks...").chosen({search_contains:true});
                        </aui:script>
                        <style>
                        #associatenumber_chosen{
                           width:250px!important;
                        }
                        </style>
                        <div id="associatenumber_ValidationMessage" class="form-validator-stack help-inline" style="display: none;">
                        Missing required value for the field "Filled with Associate Number"
                        </div>
						</div>
                                                 <div class="portlet-column portlet-column-last">
                                                <div class="portlet-column portlet-column-last personid" style="margin-top: 10px;" id="assName"></div><br/>
						<div class="portlet-column portlet-column-last personid " id="AssTitle"></div>
					</div></div>
				</div>
                  <div class="modal-footer" >
				<div class="col-sm-6 text-right">
					<aui:button type="submit" class="btn btn-primary" value="Save"
						name="saveAssociatedata" onclick="return associateNumberValidation();"></aui:button>
				</div>
				<div class="col-sm-6 text-left">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
				</div>
			   </div>
			</div>
</aui:form>
</div>
</div>
</div>
<!----------------for add associate HMA and Contractor modal start----------- -->
<div class="container">
	<div class="modal fade" id="addAssforHMA" role="dialog" style="display:none;">
		<div class="modal-dialog" id="moveassociativepopup">
			<div class="modal-content">
				<div style="padding: 62px 10px; text-align: center;">This action generally should be done through Requisition or COS</div>
			<div class="modal-footer" style="margin-top: 30px;">
				<button type="button" class="btn btn-primary" data-dismiss="modal" id="swap_associate">Ignore</button>
			</div>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="modal fade" id="addassociateModalPopup" role="dialog" style="display:none;">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div id="addassociateModalContent" class="popup-cont"></div>
				<div class="modal-footer">
					<div class="col-sm-12">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="swap_associate">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<aui:script>
</aui:script>
<!----------------for add associate HMA and Contracotor modal end----------- -->
<% }
if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)){ %>
<div class="container">
	<div class="modal fade" id="MoveAssociateMustbeCompleted" style="display:none;">
		<div class="modal-dialog" id="moveassociativepopup">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body" style="max-height: 250px;"><h5>You cannot move this associate while there is an open Change of Status.</h5></div>
				<div class="modal-footer">
					<div class="col-sm-2">
						<button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<% } %>
<aui:form method="post" action="<%=updateForPositionURL.toString()%>" name="updateForPosition" id="updateForPosition">
<%--<liferay-ui:error key="3" message="Cannot change the position as Requisition is in Filled state"></liferay-ui:error> --%> 
	<aui:input name="modalvalue" type="hidden"></aui:input>
	<aui:input name="genreqValue" type="hidden"></aui:input>
	<aui:input name="autoreqGenForReopen" type="hidden"></aui:input>
	<aui:input id="positionid" type="hidden" name="positionid" value="<%=pId%>" />
	<aui:input id="buttonclickUpdate" type="hidden" name="buttonclickUpdate" value="" />
	<aui:input name="Deptid_back" value="<%=wfmPosition.getDepartmentNumber()%>" type="hidden"></aui:input>
			<aui:input name="reportsTo1" type="hidden"></aui:input>
	<%-- <aui:input id="tempStatus" type="hidden" name="tempStatus" value=<%=wfmPosition.getStatus()%> />
 --%>
	<aui:input type="hidden" name="tempStaus" value="<%=wfmPosition.getStatus()%>"></aui:input>
	<div class="portlet-layout">
		<h2 class="titleArea">Manage Position
		<% if(renderRequest.getParameter("printPosition") == null){ %>
			<input class="titleArea" type="button" value="Print" id="btnPrint" onclick="printDiv('printableArea')" /><%} %>
		</h2>
	</div>
	<div class="portlet-layout">
		<div class="col-sm-6">
			<div class="wfm-system">
				<%-- <c:if test="${ADD_RS_1}"> --%>
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4">
						<span class="sectionLabel">Position #</span>
					</div>
					<div class="portlet-column portlet-column-last col-sm-8">
						<%
							String Id = "";
								if (wfmPosition.getPId().contains("-WFM")) {
									Id = wfmPosition.getPId().replace("-WFM", "");
								} else {
									Id = wfmPosition.getPId();
								}
						%>
						<%=Id%>
					</div>
				</div>
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4">
						<span class="sectionLabel">Status</span>
					</div>
					<%
						if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT) && wfmPosition.getPId().contains("-WFM")) {
					%>
					<div class="portlet-column portlet-column-last col-sm-8" id="reopen">
						<%=HondaPermissionKeys.POS_DRAFT%>

						<aui:input type="hidden" value="Pending" name="status"
							disabled="${not ADD_RS_1}" />
					</div>
					<%
						} else {
					%>
					<div class="portlet-column portlet-column-last col-sm-8" id="reopen">
						<%=wfmPosition.getStatus().trim()%>

						<aui:input type="hidden" value="<%=wfmPosition.getStatus()%>"
							name="status" />
					</div>
					<% } 	%>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="portlet-layout row own-top">
				<div class="portlet-column portlet-column-first col-sm-6"
					style="padding-left: 3px;">
					<div class="wfm-system">
					<%if(!wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){
						if(WMSUserAccessUtil.checkPermission(renderRequest,PortletPropsPermission.CRT_POS_ROLES)){ %>
					<div class="small">
							<button class="btn btn-primary" type="button" onClick="copyPosition();">Copy Position</button>
						</div>
						<%}} %>
					</div>
				</div>
			</div>
				<div class="portlet-msg-success" id="link" style="display:none"></div>
				 <div style="position: relative; top: -34px;">
            <img src="<%=request.getContextPath()%>/images/ajax-loader.gif"
                    id="img_copy" alt="Please wait a moment.." />
    </div>
		</div>
		<% if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)) { %>
		<div class="portlet-layout row" id="openid">
			<div>
				<div class="wfm-system own-wrapper col-sm-12">
					<div class="small center" id="openid" name="openid">
						<div class="portlet-layout row">
							<div class="portlet-column"><div class="col-sm-3"></div></div>
						</div>
						<div class="portlet-layout row">
							<div class="portlet-column">
								<div class="col-sm-4">
									<button type="button" class="btn btn-primary"
										onclick="redirectExit();">Exit
										View</button>
								</div>
								<% if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,wfmPosition.getWorkflowStep(), wfmPosition.getDepartmentNumber(), PortletPropsPermission.BTN_APRV_BTN)){ %>
								<div class="col-sm-4">
									<aui:input type="hidden" name="Selectedbutton"
										value="Updatepos" />

									<aui:button type="button" cssClass="btn btn-primary"
										value="submit"
										onclick="generateReqClick('updatepositionValue')"></aui:button>
								</div>
<%}  if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,wfmPosition.getWorkflowStep(), wfmPosition.getDepartmentNumber(), PortletPropsPermission.BTN_APRV_BTN)){ %>

								<div class="col-sm-4">
									<button class="btn btn-primary" onclick="getUrl('<%=DiscardURL%>')">Discard</button>
								</div>
								<%} %>	
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<% } %>
		<!-- Buttons for status open -->
		<% if (Validator.isNotNull(wfmPosition.getStatus()) && 
				(wfmPosition.getStatus().trim()).equalsIgnoreCase(HondaPermissionKeys.POS_OPEN)) { %>
		<div class="portlet-layout" id="openid">
			<div>
				<div class="wfm-system own-wrapper col-sm-12">
					<div class="small center" id="openid" name="openid">
						<div class="portlet-layout row">
							<div class="portlet-column">
								<c:if test="${ADD_ASSOCIATE}">

									<div class="col-sm-4" id="addasscoate">
										<%String rqIinModla=StringPool.BLANK;
											String promptId = "0";
										String reqStatus = null;
										List<WFMS_Requisition> requisationList1 = null;
										// out.println("pId"+pId);
										DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
										dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(pId));
										dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
										Long TotalRequisations = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);
										Criterion reqcriterion = null;
										reqcriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.REQ_CANCELLED);
										reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_COMPLETE));
										reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_SAVE));
										dynamicQueryForRequisation.add(reqcriterion);
										dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
										Long requisationList = WFMS_RequisitionLocalServiceUtil
												.dynamicQueryCount(dynamicQueryForRequisation);

										DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
										dynamicQueryForCos.add(PropertyFactoryUtil.forName("newPositionNumber").eq(pId));
										dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
														Criterion Coscriterion = null;
														Coscriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.COS_DRAFT);
														Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,
																RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT));
														//Coscriterion = RestrictionsFactoryUtil.or(criterion , RestrictionsFactoryUtil.eq("status", "Cancelled"));
														dynamicQueryForCos.add(Coscriterion);
														List<WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);

														if (TotalRequisations == requisationList && cosList.size() == 0) {
															promptId = "1";
														} else if (TotalRequisations == requisationList || cosList.size() == 0) {

															if (TotalRequisations.equals(requisationList)) {
																promptId = "2";
															} else {

																DynamicQuery dynamicQueryForRequisation1 = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
																dynamicQueryForRequisation1.add(PropertyFactoryUtil.forName("rId").eq(pId));
																dynamicQueryForRequisation1.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
																Criterion reqcriterion1 = null;
																reqcriterion1 = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.REQ_DRAFT);
																reqcriterion1 = RestrictionsFactoryUtil.or(reqcriterion1, RestrictionsFactoryUtil
																		.eq("status", HondaPermissionKeys.REQ_WAITINGONMANPOWER));
																reqcriterion1 = RestrictionsFactoryUtil.or(reqcriterion1, RestrictionsFactoryUtil
																		.eq("status", HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER));
																reqcriterion1 = RestrictionsFactoryUtil.or(reqcriterion1, RestrictionsFactoryUtil
																		.eq("status", HondaPermissionKeys.REQ_COMPLETE_PENDING_APPROVAL));
																reqcriterion1 = RestrictionsFactoryUtil.or(reqcriterion1,
																		RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_SUBMITTED));
																dynamicQueryForRequisation1.add(reqcriterion1);
																requisationList1 = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryForRequisation1);
																if (!requisationList1.isEmpty()) {
																	reqStatus = requisationList1.get(0).getStatus().trim();
																	if (reqStatus.equalsIgnoreCase(HondaPermissionKeys.REQ_SUBMITTED)
																			|| reqStatus.equalsIgnoreCase(HondaPermissionKeys.REQ_DRAFT)
																			|| reqStatus.equalsIgnoreCase(HondaPermissionKeys.REQ_WAITINGONMANPOWER)) {
																		promptId = "3";
																	} else {
																		promptId = "4";
																	}
																}
															}
														} else {
															promptId = "2";
														}
														if (promptId.equalsIgnoreCase("1")) {%>
										  <!--   <button class="btn btn-primary" onclick="mpcaterydropdown();" >Add Associate</button> -->
										  <button type="button" class="btn btn-primary" type="button"
	onclick="mpcaterydropdown()">Add Associate</button>
										 
											<%
												} else if (promptId.equalsIgnoreCase("2") || promptId.equalsIgnoreCase("3")
																	|| promptId.equalsIgnoreCase("4")) {
													
													 if (!promptId.equalsIgnoreCase("2")){
													  rqIinModla=requisationList1.get(0).getRwfId();
													  if(rqIinModla.contains("-WFM"))
														  rqIinModla=rqIinModla.replaceAll("-WFM", "");
													 }
											%>
											<aui:button id="Add_Associate" name="Add_Associate"
												value="Add Associate" cssClass="btn btn-primary"
												type="button" data-toggle="modal" 
												data-target="#addassociateModalPopup"  data-backdrop="static" />
											<aui:script>
								         <% if(promptId.equalsIgnoreCase("2")){ %>
									            $("#addassociateModalContent").html("Position must be Filled Through Completing the Change of Status \""+ "<%=cosList.get(0).getCosId() %>"+"\"");	
									            <% } else if(promptId.equalsIgnoreCase("3")){ %>
									            $("#addassociateModalContent").html("There is an Open Requisition \""  +"<%=rqIinModla %>\"  that needs to be Completed or Cancelled");
									    <% } else if(promptId.equalsIgnoreCase("4")){ %>
									    $("#addassociateModalContent").html("Position must be Filled Through Completing the Requisition \""+"<%=rqIinModla%>"+"\"");
									  
									    <% } %>
									   </aui:script>
												<%
												}
											%>
	</div>
</c:if>
<c:if test="${CLOSE_POS}">
	<div class="col-sm-4" id="closeposition">
<% 
DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(wfmPosition.getPId()));
dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
Criterion reqcriterion = null;
reqcriterion = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_CANCELLED);
reqcriterion = RestrictionsFactoryUtil.and(reqcriterion,RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.REQ_COMPLETE));
dynamicQueryForRequisation.add(reqcriterion);
DynamicQuery dynamicQueryForCOS = WFMS_COSLocalServiceUtil.dynamicQuery();
dynamicQueryForCOS.add(PropertyFactoryUtil.forName("newPositionNumber").eq(wfmPosition.getPId()));
dynamicQueryForCOS.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
Criterion reqcriterionCOS = null;
reqcriterionCOS = RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_APPROVED);
reqcriterionCOS = RestrictionsFactoryUtil.and(reqcriterionCOS,
		RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_CANCELLED));
reqcriterionCOS = RestrictionsFactoryUtil.and(reqcriterionCOS,
		RestrictionsFactoryUtil.ne("status", HondaPermissionKeys.COS_DISAPPROVED));
dynamicQueryForCOS.add(reqcriterionCOS);
List <WFMS_COS> cosList = WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCOS);
List <WFMS_Requisition> requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQuery(dynamicQueryForRequisation);
String showpopup="";
if (requisationList.size()>0 ) {
	String reqStatus=requisationList.get(0).getStatus();
	if(reqStatus.equalsIgnoreCase(HondaPermissionKeys.REQ_COMPLETE_PENDING_APPROVAL) || reqStatus.equalsIgnoreCase(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER)){
		showpopup="1";
	}
}
if(cosList.size()> 0){
	if(cosList.get(0).getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_SUBMIT) ||
			cosList.get(0).getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_DRAFT)){
		showpopup="2";
	}
}
if(showpopup.equalsIgnoreCase("1") || showpopup.equalsIgnoreCase("2") ){ %>

<div>
	<button type="button" class="btn btn-primary" type="button"
	onclick="closepositionModal()">Close Position </button>
</div>
<aui:script>
	        function closepositionModal() {
			AUI().use('aui-base',
					'aui-io-plugin-deprecated',
					'liferay-util-window',
				function(A) {
					var popUpWindow = Liferay.Util.Window.getWindow({
						dialog : {
							centered : true,
							constrain2view : true,
							align : {
								node : null,
								points : [ 'tc', 'tc' ]
							},
							modal : true,
							cache : false,
							width : 780,
							height : 90,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();
					popUpWindow.titleNode.html("Position has a pending associate placement and can not be closed ");
	 	});
			};
</aui:script>
									<% }else{ %>
										<aui:button cssClass="btn btn-primary" type="button"  value="Close Position" onclick="closepoitionYesORNo();"></aui:button>	
												
									<% } %>											
									</div>
								</c:if>
								<c:if test="${EDIT_POS}">
                                   <%
                                        DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
										dynamicQueryForCos.add(PropertyFactoryUtil.forName("newPositionNumber").eq(pId));
										dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
										Criterion Coscriterion = null;
										Coscriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.COS_DRAFT);
										Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,
												RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT));
										dynamicQueryForCos.add(Coscriterion);
										Long cosList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos); 
										DynamicQuery dynamicQueryForReq = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
										dynamicQueryForReq.add(PropertyFactoryUtil.forName("rId").eq(pId));
										dynamicQueryForReq.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
										dynamicQueryForReq.add(PropertyFactoryUtil.forName("status").eq(HondaPermissionKeys.REQ_FILLEDBUTNOASSOCIATENUMBER));
										Long reqList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForReq); 		%>
										<%if(cosList > 0) { %>
											<div class="col-sm-4">
										<aui:button class="btn btn-primary" type="button"
											value="Modify Position" onclick="IsactiveCOS()"></aui:button>
									</div>
										 <aui:script>
							        function IsactiveCOS() {
			AUI().use('aui-base',
					'aui-io-plugin-deprecated',
					'liferay-util-window',
				function(A) {
					var popUpWindow = Liferay.Util.Window.getWindow({
						dialog : {
							centered : true,
							constrain2view : true,
							align : {
								node : null,
								points : [ 'tc', 'tc' ]
							},
							modal : true,
							cache : false,
							width : 780,
							height : 90,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();
					popUpWindow.titleNode.html("You cannot modify this position while there is an open Change of Status");
	 	});
			};
</aui:script>
										<%} else if(reqList > 0){ %>
											<div class="col-sm-4">
										<aui:button cssClass="btn btn-primary" type="button"
											value="Modify Position" onclick="modifypoitionforapprove()"></aui:button>
									</div>
										<% }else{  %>
										
										<div class="col-sm-4">
										<aui:button cssClass="btn btn-primary" type="button" id="modify_position_ie"
											value="Modify Position" onclick="modifyFunction('Modified')"></aui:button>
									</div>
<% } %>
								</c:if>
                                <%
                               if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_CRT_REQ,wfmPosition.getDepartmentNumber())){ %>
								<div class="col-sm-4">
									<portlet:actionURL name="Generaterequisition"
										var="GeneraterequisitionURL">
										<aui:input type="hidden" name="Selectedbutton"
											value="Generaterequisition" />
									</portlet:actionURL>
									<%
									String content="";
									if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest, PortletPropsPermission.REQ_CRT_REQ,wfmPosition.getDepartmentNumber())){
									        DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
											dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(wfmPosition.getPId()));
											dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
											Long TotalRequisations = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);
											Criterion reqcriterion = null;
											reqcriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.REQ_CANCELLED);
											reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_COMPLETE));
											dynamicQueryForRequisation.add(reqcriterion);
											Long requisationList = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);
											String reqOpen="";
											String cosOpen="";
											String genReq="";
											if (TotalRequisations == requisationList) {
												DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
												dynamicQueryForCos.add(PropertyFactoryUtil.forName("newPositionNumber").eq(wfmPosition.getPId()));
												dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
												Long cosTotalList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos);
												Criterion Coscriterion = null;
												Coscriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_APPROVED);
												Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_CANCELLED));
												Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DISAPPROVED));
												dynamicQueryForCos.add(Coscriterion);
												Long cosList1 = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos);
												if (cosTotalList != cosList1) {
													cosOpen="1";
												}	
											} 
											else { 
												reqOpen="1";
											}
										if(reqOpen.equalsIgnoreCase("1") || cosOpen.equalsIgnoreCase("1")){
											
											if(reqOpen.equalsIgnoreCase("1")){
												content="The Current Position has an Open Requisition in Manage Requisition table. So you wouldn't be able to add another requisition to this position - Thank you";
											}
											else if(cosOpen.equalsIgnoreCase("1")){
												content="You cannot generate a requisition when there is a COS that has an Associate moving to this position";
											}
									%>
										<button class="btn btn-primary" type="button" name="Cancel Account" onClick="showpopup()">Generate Requisition</button>
									<% } else{ %>
									<button class="btn btn-primary" type="button"
										onclick="generateReqClick('generateReqValue')">Generate
										Requisition</button>
									<% } } %>
									<script type="text/javascript">
					function showpopup() {
						$('#message_alert_popup').html("<%=content %>");
						$('#modifyPositionAlert').modal({ backdrop: 'static',
					          keyboard: true, 
					          show: true});
						/*AUI().use('aui-base',
									'aui-io-plugin-deprecated',
									'liferay-util-window',
								function(A) {
									var popUpWindow = Liferay.Util.Window.getWindow({
										dialog : {
											centered : true,
											constrain2view : true,
											align : {
												node : null,
												points : [ 'tc', 'tc' ]
											},
											modal : true,
											cache : false,
											width : 780,
											height : 90,
											destroyOnClose : true,
										}
									}).plug(A.Plugin.IO, {
										autoLoad : false
									}).render();

									popUpWindow.titleNode.html("<%=content %>");
					 	});*/
					}
					</script>
								</div>
								<%}%>
								<div class="col-sm-4">
									<button type="button" class="btn btn-primary"
										onclick="redirectExit();">Exit
										View</button>
								</div>
								<div class="col-sm-4">
										<aui:button type="button" cssClass="btn btn-primary modifySubmit"
										value="submit" onclick="generateReqClick('updatepositionValue');" disabled="<%=true%>"></aui:button>
										</div>
							</div>
						</div>
						
							

								
									<portlet:actionURL name="Updatepos" var="UpdateposURL">
										<aui:input type="hidden" name="Selectedbutton"
											value="Updatepos" />
									</portlet:actionURL>
									<aui:input type="hidden" name="Selectedbutton"
										value="Updatepos" />
										
										
									<% 
								String modifySubmit="";
								 DynamicQuery dynamicQueryForPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
				                dynamicQueryForPosition.add(PropertyFactoryUtil.forName("pId").eq(pId+"-WFM"));
				                List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQueryForPosition);
				               %>
									 <% if(wfms_PositionList.size()>0) {
								%>
								<div class="container">
									<div class="modal fade" id="canceSaveModalPopup" role="dialog" style="display:none;">
										<div class="modal-dialog">
											<div class="modal-content">
													<div class="popup-cont">Are you Sure, you want to cancel the changes made?</div>
													<div class="modal-footer">
														<div class="col-sm-12">
														<button type="button" onclick="cancelPosition();" class="btn " data-dismiss="modal">Yes</button>														
														<button type="button" class="btn " data-dismiss="modal" id="swap_associate">No</button>
														</div>
													</div>
											</div>
								
										</div>
									</div>
								</div>
								
								<% } %>
									<aui:input type="hidden" name="buttonclick" id="buttonclick"
									value="" />
		
						
					</div>
				</div>
			</div>
		</div>
		<% } %>
		<% if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){ 
			 %>
				<div class="portlet-layout row" id="openid">
					<div class="col-sm-12">
						<div class="wfm-system own-wrapper">
							<div class="small center" id="openid" name="openid">
								
								<div class="portlet-layout row">
									<div class="portlet-column">

										<div class="col-sm-4">
											<button type="button" class="btn btn-primary"
												onclick="redirectExit();">Exit
												View</button>
										</div>
										<%if(WMSUserAccessUtil.getApprovePermissions(renderRequest, wfmPosition.getWorkflowStep(),wfmPosition.getDepartmentNumber())){ %>
												<div class="col-sm-4">
													<aui:button cssClass="btn btn-primary modifyExe" type="button"
														value="Approve" onclick="approveModify();"></aui:button>
												</div>
												<div class="col-sm-4">
													<aui:button cssClass="btn btn-primary modifyExe" type="button"
														data-toggle="modal" data-target="#disapprovePositionModal" data-backdrop="static"
														value="Disapprove" ></aui:button>
												</div>
										<%}%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		<% 	}%>
		<!-- Buttons for status pending -->
		<% if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING)) { %>
		<div class="portlet-layout row">
			<div class="col-sm-12">
				<div class="wfm-system own-wrapper">
					<div class="portlet-layout row">
						<div class="small center">
							<div class="col-sm-4">
								<button class="btn btn-primary" onclick="redirectExit();">Exit View</button>
							</div>
							<% if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,wfmPosition.getWorkflowStep(), wfmPosition.getDepartmentNumber(), PortletPropsPermission.BTN_APRV_BTN)){ %>
							<aui:script>
                                $(document).ready(function(){
                                   $("#approvebutton").click(function(){
                                   	this.disabled=true;
                                       document.getElementById('<portlet:namespace />positionAapproveForm').submit();
                                   });
                              });
                               </aui:script>
								<div class="col-sm-4">									
								<% if(wfmPosition.getWorkflowStep()==80){if(wfmPosition.getAutoGenerateReq().equalsIgnoreCase("false")){ %>
                                       <button class="btn btn-primary" onclick="generateReqClick('updatepositionValue')">Approve</button>
                                       <% }else{%>
                           <button type="button" class="btn btn-primary"	onclick="getUrl('<%=ApproveURLForYes%>')">Approve</button>
                                       	
                                       <% }}else{ %>
                                          <button class="btn btn-primary" id="approvebutton">Approve</button>
                                       <% } %>
								</div>
								<div class="col-sm-4">
									<button class="btn btn-primary" type="button"
										data-toggle="modal" data-target="#disapprovePositionTocreate" data-backdrop="static"
										value="Disapprove">Disapprove</button>
								</div>
							<% } // %>
<% if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,wfmPosition.getWorkflowStep(), wfmPosition.getDepartmentNumber(),PortletPropsPermission.BTN_ADD_DATA)){ %>
							<div class="col-sm-4">
								
								<button class="btn btn-primary" onclick="this.disabled=true" id="addData" type="button">Add Data</button>
								
							</div>
<% } %>
						
							<aui:input type="hidden" name="saveonworkflow" id="saveonworkflow" />

							<% if(WMSUserAccessUtil.checkPermissionForPosition(
												renderRequest, PortletPropsPermission.POS_SAVE,
												wfmPosition.getDepartmentNumber())) {
							%>
							<div class="col-sm-4" style="display: none" id="saveId">
								<aui:button type="button" cssClass="btn btn-primary"
									value="save" onclick="generateReqClick('save')"></aui:button>
							</div>
							<% } %>
							<div class="col-sm-4" style="display: none" id="submitId">
								<aui:button type="button" cssClass="btn btn-primary" value="submit" 
									onclick="generateReqClick('updatepositionValue')"></aui:button>
							</div>
							<% if(WMSUserAccessUtil.checkButtonVisibility(renderRequest,wfmPosition.getWorkflowStep(), wfmPosition.getDepartmentNumber(),PortletPropsPermission.BTN_ADD_DATA)){ %>
							<%if(wfmPositionforTempcount > 0){%>
							<div class="col-sm-4" id="discardId">									
								<button type="button" class="btn btn-primary" onclick="getUrl('<%=Discardstep2URL%>')">Discard</button>		
							</div>
							<%} } %>				
					</div>
				</div>
			</div>
		</div>
	</div>
		<% } %>
		<!-- Buttons for status filled -->
		<% if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)) { %>
		<div class="portlet-layout row">
			<div class="col-sm-12">
				<div class="wfm-system own-wrapper">
					<div class="portlet-layout row">
							<div class="row small center">

			 <%if(WMSUserAccessUtil.checkPermissionForPosition(renderRequest, PortletPropsPermission.MODIFY_POSITION,
					 wfmPosition.getDepartmentNumber())){ %>							
							
								<c:if test="${MOVE_ASSOCIATE}">
									<div class="col-sm-4">
										<button id="MoveAssociateShowButton"
											class="btn btn-primary" type="button">Move Associate</button>
									</div>
								</c:if>
								<c:if test="${SWAP_ASSOCIATE}">
									<div class="col-sm-4">
										<button type="button" class="btn btn-primary" id="swapAssociatepopup">Swap Associate</button>
						</div>
						</c:if>
								<c:if test="${TERM_ASSOCIATE}">
									<div class="col-sm-4">
										<aui:button cssClass="btn btn-primary" type="button"
											name="terminateAssociate" onclick="terminateAssociate();" value="Terminate Associate"></aui:button>
									<aui:script>
									
									function terminateAssociate(){
									<%  if(existedCosStatus){ %>
									 $('#message_alert_popup').html("You cannot Terminate this associate while there is an open Change of Status.");
								      $('#modifyPositionAlert').modal({ backdrop: 'static',
							          keyboard: true, 
							          show: true});
							          <% }else{ %>
							          $('#terminate_alert_popup').modal({ backdrop: 'static',
							          keyboard: true, 
							          show: true});
							          <% } %>
									}
									</aui:script>
									</div>	
								</c:if>
								<c:if test="${EDIT_POS}">
									<div class="col-sm-4">
										<aui:button cssClass="btn btn-primary" type="button" id="modify_position_ie"
											value="Modify Position" onclick="modifyFunction('Modified')"></aui:button>
									</div>
								</c:if>
								<%} %>
								<% 
								String modifySubmit="";
								 DynamicQuery dynamicQueryForPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
				                dynamicQueryForPosition.add(PropertyFactoryUtil.forName("pId").eq(pId+"-WFM"));
				                List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQueryForPosition);
								if(wfms_PositionList.size()>0) { %>
								<div class="container">
									<div class="modal fade" id="canceSaveModalPopup" role="dialog" style="display:none;">
										<div class="modal-dialog">
											<div class="modal-content">
													<div class="popup-cont">Are you Sure, you want to cancel the changes made? </div>
													<div class="modal-footer">
														<div class="col-sm-12">
														<button type="button" onclick="cancelPosition();" class="btn btn-primary" data-dismiss="modal">Yes</button>														
														<button type="button" class="btn btn-primary" data-dismiss="modal" id="swap_associate">No</button>
														</div>
													</div>
											</div>
								
										</div>
									</div>
								</div>
								
								<% } %>
								<div class="col-sm-4">
										<button type="button" class="btn btn-primary"
											onclick="redirectExit();">Exit
											View</button>
									</div>
									<div class="col-sm-4">
									    <aui:button disabled="<%=true%>" type="button" cssClass="btn btn-primary modifySubmit"
											value="submit" onclick="generateReqClick('updatepositionValue');"></aui:button>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<% } %>

		<!-- Buttons for status closed -->
		<% if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_CLOSED)) { %>
		<div class="portlet-layout row " id="closedid">
			<div class="col-sm-12">
				<div class="wfm-system own-wrapper">
					<div class="portlet-layout row small center">
						<div class="portlet-column portlet-column-only" id="closeid"
							name="closeid">
							<div class="col-sm-4">
								<button type="button" class="btn btn-primary"
									onclick="redirectExit();">Exit
									View</button>
							</div>
							<c:if test="${RE_OPN_CLOSE_POS}">
								<div class="col-sm-4">
										<button type="button" class="btn btn-primary" style="width: 77.5%;">
										<a href="<%=OpenActionURL%>" style="text-decoration: none; color: #333;">Re-Open</a></button>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		<% } %>
		<div class="portlet-layout row">
			<div class="col-sm-12">
				<div class="wfm-system" style="margin-top: 20px;">
				<% if(!wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)){ %>
				<div id="fifthsetData">
								<div class="portlet-layout row">
									<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Number</div>

									<div class="portlet-column portlet-column-last col-sm-8">
										<div id="ASSOCIATE_NUMBER"><%=wfmPosition.getAssociateNumber()%></div>
										<aui:input type="hidden"
											value="<%=wfmPosition.getAssociateNumber()%>"
											name="associateNumber" />
									</div>
								</div>
								<div class="portlet-layout row">
									<div
										class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Name</div>

									<div class="portlet-column portlet-column-last col-sm-8">
										<div id="ASSOCIATE_NAME" ><%=wfmPosition.getAssociateName()%></div>
										<aui:input type="hidden"
											value="<%=wfmPosition.getAssociateName()%>"
											name="associateName" />
									</div>
								</div>
								<div class="portlet-layout row">
									<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Associate Title</div>
									<div class="portlet-column portlet-column-last col-sm-8">
										<div id="ASSOCIATE_TITLE" ><%=wfmPosition.getAssociateTitle()%></div>
										<aui:input type="hidden"
											value="<%=wfmPosition.getAssociateTitle()%>"
											name="associateTitle" />
									</div>
								</div>
								<div class="portlet-layout row">
									<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">MP Category Filled With</div>
									<div class="portlet-column portlet-column-last col-sm-3">
										<aui:select  name="mpCatFilledWith" id="mpCatFilledWith"
											class="field-select"
											onChange="mpCatFilledWithvalidate();" placeholder="mp filled"
											label="" value="<%=wfmPosition.getMpCatFilledWith()%>">
											<aui:option value="">Select MP Category Filled With</aui:option>
											<%-- <aui:option value="<%=wfmPosition.getMpCatFilledWith()%>"><%=wfmPosition.getMpCatFilledWith()%></aui:option> --%>
											<%
												values = ConfigUtility.getInputValuesFromConfig("position-mpcategoryfilledwith");
														Arrays.sort(values);
														for (String value : values) {
											%>
											<aui:option
												selected="<%=(null != wfmPosition.getMpCatFilledWith()
									&& wfmPosition.getMpCatFilledWith().equals(value))%>"
												value="<%=value%>"><%=value%></aui:option>
											<%
												}
											%>

										</aui:select>
										<div id="mpCatFilledWitherrormesg" class="form-required"></div>
									</div>
								</div>
					</div>
				<% } %>
				
        <div class="firstsetData wfm-system" id="firstsetData">
                <div class="portlet-layout row">
                        <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Division</div>
                           <div class="portlet-column portlet-column-last col-sm-8">
                                <div id="Division"><%=wfmPosition.getDivision()%></div>
                                <input type="hidden" value="<%=wfmPosition.getDivision()%>" name="division" disabled="${not ADD_RS_1}" />
                        </div>
                </div>
                <div style="position: relative; top: -34px;">
                        <img src="<%=request.getContextPath()%>/images/ajax-loader.gif"
                                id="img" alt="Please wait a moment.." style="display: none"/>
                </div>
                <div class="portlet-layout row">
                        <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Department Name</div>
                        <div class="portlet-column portlet-column-last col-sm-8">
                                <div id="DEPT_NAME"><%=wfmPosition.getDepartmentName()%></div>
                                <input type="hidden" value="<%=wfmPosition.getDepartmentName()%>" name="departmentname" />
                        </div>

                        <div id="departmentname" class="form-required"></div>
                </div>
                <div class="portlet-layout row">
                        <div class="portlet-column portlet-column-first col-sm-4 sectionLabel "> Department Number</div>
                          <div id="Deptid_mainDiv" class="portlet-column portlet-column-last col-sm-3">
                           <aui:select  name="Deptid" id="divdeptRest" cssClass="field-select chosen" placeholder="" label=""
                                        onchange="loadDivisonDepName(this.value);" disabled="true" required="true">
                                <aui:option value="">Select Department Number</aui:option>
                        <%   
                                Map<String, String> departmentNumberMap=null;
                                if(HondaPermissionKeys.POS_PENDING.equalsIgnoreCase(wfmPosition.getStatus()) || HondaPermissionKeys.POS_DRAFT.equalsIgnoreCase(wfmPosition.getStatus())){                                   
                                        departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
	                             }else{
	                            	 departmentNumberMap = HondaLogicUtil.getcccodesOnsameDeptNumber(wfmPosition.getDepartmentNumber());
                                } 
                                for (Map.Entry<String, String> entry : departmentNumberMap.entrySet()) {
                                       if(!entry.getValue().equalsIgnoreCase("")){ %>
                                        <aui:option selected="<%=(wfmPosition.getDepartmentNumber().equals(entry.getKey()))%>"
                                                value="<%=entry.getKey()%>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
                               <% } } %>
	    </aui:select>
		<div class="Deptid_ValidationMessage form-validator-stack help-inline" style="display: none;">
                   			           Missing required value for the field "Department Number"</div>
	    </div>
	</div>
        <div class="portlet-layout row">
                <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">MP Category Budget</div>
                <div id="mpCatBudget_mainDiv" class="portlet-column portlet-column-last col-sm-3">
                        <aui:select  name="mpCatBudget" id="mpCatBudget" class="field-select" onchange="mpCatBudgetvalidate();"
                                placeholder="" label="" value="<%=wfmPosition.getMpCatBugdet()%>" disabled="${not ADD_RS_1}">
                                <aui:option value="">Select MP Category Budget</aui:option>
                                <%  values = ConfigUtility.getInputValuesFromConfig("position-mpcategorybudgeted");
                                    Arrays.sort(values);
                                    for (String value : values) { %>
                                <aui:option selected="<%=(null != wfmPosition.getMpCatBugdet() && wfmPosition.getMpCatBugdet().equals(value))%>"
                                        value="<%=value%>"><%=value%></aui:option>
                                <% } %>
                        </aui:select>
                        <div class="mpCatBudget_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;"> Missing required value for the field "MP Category Budget"</div>
                </div>
        </div>
						<%-- </c:if> --%>
            <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Position Class</div>
                    <div class="portlet-column portlet-column-last col-sm-8" id="positionClass_mainDiv">
                            <% String dbvalueclass = wfmPosition.getPositionClass();
                                            values = ConfigUtility.getInputValuesFromConfig("position-class");
                                            for (String value : values) { %>
                            <div class='col-sm-2 owncheck'>
                                    <% if (null != value) { %>
                                    <aui:input checked="<%=(value.equalsIgnoreCase(dbvalueclass.trim()))%>" inlineLabel="right"
                                            name="positionClass" onchange="datevalidation()" onclick="positionClassvalidate();"
                                            id="positionClass" type="radio" value='<%=value%>' label="<%=value%>" />
                                    <% } %>
                                    
                            </div>
                            <% } %>
                            <div class=" form-validator-stack help-inline customErroeClass positionClass_ValidationMessage" style="display: none;padding-right: 280px;">
                                    Missing required value for the field "Position Class"
                            </div>
                    </div>
            </div>
            <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Year Established</div>
                    <div class="portlet-column portlet-column-last col-sm-3" id="yearEst_mainDiv">
                            <aui:input  name="yearEst" id="yearEst" placeholder="YYYY" onkeyup="yearEstvalidate();" type="text" label="" maxLength="75"
                                    value="<%=wfmPosition.getYearEst()%>"></aui:input>
                        <div class="form-validator-stack help-inline customErroeClass yearEst_ValidationMessage" style="display: none;">
                                    Missing required value for the field "Year Established "</div>
                    </div>

            </div>
            <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Reason for addition or change</div>

                    <div id="reasonchange_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                            <aui:input  type="textarea" onkeyup="reasonchangevalidate();" name="reasonchange" id="reasonchange"
                                    label="" value="<%=wfmPosition.getReasonsFor()%>" cols="55" placeholder="Reasons" rows="10" maxLength="250">
                            </aui:input>
                        <div class="reasonchange_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                                                Missing required value for the field "Reason for addition or changes"</div>
                    </div>
            </div>
						<%-- <c:if test="${ADD_RS_1}"> --%>
            <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Position Re-evaluation date</div>
                    <div class="portlet-column portlet-column-last col-sm-3 startDt">
                <div id="startDate_mainDiv">
                    <%
                        String className=""; 
                        if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)){
                              className="datepicker";            
                        }                              
                    %>				
                        <aui:input name="reevaluationDate" label="" id="startDate" maxlength="70" title="Click Here" 
                          placeholder="MM/DD/YYYY" onkeyup="datevalidation();" disabled="${not ADD_RS_1}" value="<%=wfmPosition.getReavailuationDate() %>">
                        </aui:input>
			<div class="startDate_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                            Missing required value for the field "Position Re-evaluation date".
                        </div>
                </div>
							</div>
						</div>
    </div>
<div id="secondsetData" class="wfm-system" <% if(wfmPosition.getWorkflowStep() == 0 && WMSUserAccessUtil.checkPermissionForPosition(renderRequest,PortletPropsPermission.POS_RS2,wfmPosition.getDepartmentNumber())){%>style="display:none;"<%} %>	>
        <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel">Auto Generate Requisition?</div>
            <div class="portlet-column portlet-column-last col-sm-8">
                <div class="col-sm-2">
                    <aui:input class="field-radio1" name="auto-gen-req"
                            checked="<%=(null!=wfmPosition.getAutoGenerateReq() && wfmPosition.getAutoGenerateReq().equals(\"true\"))%>"
                            type="radio" value="true" label="Yes" disabled="${not ADD_RS_2}" />
                </div>
                <div class="col-sm-2">
                    <aui:input class="field-radio1" name="auto-gen-req"
                            checked="<%=(null!=wfmPosition.getAutoGenerateReq() && !wfmPosition.getAutoGenerateReq().equals(\"true\"))%>"
                            type="radio" value="false" label="No" disabled="${not ADD_RS_2}" />
                </div>
            </div>
        </div>
        <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Is this a Critical Work Segment?</div>
            <div class="portlet-column portlet-column-last col-sm-8">
                <div class="col-sm-2">
                    <aui:input class="field-radio1" name="critical-wrk-seg"
                            checked="<%=(wfmPosition.getCritical() ==true)%>"
                            type="radio" value="true" label="Yes" disabled="${not ADD_RS_2}" />
                </div>
                <div class="col-sm-2">
                    <aui:input class="field-radio1" name="critical-wrk-seg"
                            checked="<%=(wfmPosition.getCritical() ==false)%>"
                            type="radio" value="false" label="No"
                            disabled="${not ADD_RS_2}" />
                </div>
            </div>
        </div>
        <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Position Reports to</div>
            <div id="reportsTo_mainDiv" class="portlet-column portlet-column-last col-sm-3">
                <aui:select name="reportsTo"
                    cssClass="aui-field-select secondsetchosen chosen-container <%=EDIT_RS2%>" id="report"
                    label="" onchange="reportsTovalidate()" disabled="${not ADD_RS_2}">
                            <aui:option value="">Select Position Reports to</aui:option>
                            <% //List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
                         
                           DynamicQuery dynamicQueryForPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
                           dynamicQueryForPosition.add(PropertyFactoryUtil.forName("dummy").eq("0"));
                           dynamicQueryForPosition.add(PropertyFactoryUtil.forName("leadershipAssignment").ne("None"));
                           Criterion poscriterion = null;
                   		poscriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.POS_FILLED);
                   		poscriterion = RestrictionsFactoryUtil.or(poscriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.POS_OPEN));
                   		poscriterion = RestrictionsFactoryUtil.or(poscriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.POS_MODFIED));
                   		dynamicQueryForPosition.add(poscriterion);
                            List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQueryForPosition);
                                                    for (WFMS_Position lispost : wfms_PositionList) {

                            %>
                            <aui:option selected="<%=wfmPosition.getReportsTo().equals(lispost.getPId())%>"
                                    value="<%=lispost.getPId()%>"> <%=lispost.getPId()%></aui:option>
                            <% } %>
                </aui:select>
                <div class="reportsTo_ValidationMessage form-validator-stack help-inline" style="display: none;">
                    Missing required value for the field "Position Report To"
                </div>
            </div>
        </div>
        <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Line</div>
            <div  id="line_mainDiv" class="portlet-column portlet-column-last col-sm-8">
                  <% values = ConfigUtility.getInputValuesFromConfig("position-lines");
                    boolean line_found = false;
                       for (String value : values) {

                            if(value.equals(wfmPosition.getLine())){
                                    line_found = true;
                            }else{
                                    line_found = false;
                            }
                             %>
                            <div class='col-sm-2 owncheck'>
                                <aui:input checked="<%=line_found %>" inlineLabel="right" name="line" onchange="linevalidate();"
                              type="radio" value='<%=value%>' label="<%=value%>" disabled="${not ADD_RS_2}"/>
                            </div>
                  <% } %>
                   <div class="line_ValidationMessage form-validator-stack help-inline customErroeClass row col-sm-12" style="display: none;" >
                        Missing required value for the field "Line"
                    </div>
            </div>
        </div>
        <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Ladder</div>
            <div id="ladder_mainDiv" class="portlet-column portlet-column-last col-sm-3">
                <aui:select name="ladder" id="ladder" class="field-select"
                    onchange="laddervalidate();" placeholder="" label=""
                    value="<%=wfmPosition.getLadder()%>" disabled="${not ADD_RS_2}">
                    <aui:option value="">Select Ladder</aui:option>
                    <%-- <aui:option ><%=wfmPosition.getLadder()%></aui:option> --%>
                    <% values = ConfigUtility.getInputValuesFromConfig("position-ladders-new");
                                            Arrays.sort(values);
                                            for (String value : values) {
                    %>
                    <aui:option
                            selected="<%=(null != wfmPosition.getLadder() && wfmPosition.getLadder().equals(value))%>"
                            value="<%=value%>"><%=value%></aui:option>
                    <%
                            }
                    %>
                </aui:select>
                    <div class="ladder_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                        Missing required value for the field "Ladder"
                    </div>
            </div>
        </div>
        <div class="portlet-layout row">
                <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Type</div>
                <div id="positionType_mainDiv" class="portlet-column portlet-column-last col-sm-8">
                        <%
                                values = ConfigUtility.getInputValuesFromConfig("position-manpowertype");
                        boolean type_found = false;
                                        for (String value : values) {

                                                if(value.equals(wfmPosition.getType())){
                                                        type_found = true;
                                        }else{
                                                type_found = false;
                                        }

                                  %>
                        <div class='col-sm-2 owncheck'>
                                <aui:input checked="<%=type_found%>" inlineLabel="right" onchange="positionTypevalidate();"
                                        name="positionType" type="radio" value='<%=value%>' label="<%=value%>" disabled="${not ADD_RS_2}" />
                        </div>
                        <% } %>
                        <div class="positionType_ValidationMessage form-validator-stack help-inline customErroeClass " style="display: none;padding-top: 10px;margin-top: 21px;">
                       Missing required value for the field "Type"
                    </div>
                        
                </div>
        </div>
        <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Level (Choose all that apply)</div>
                    <div class="portlet-column portlet-column-last col-sm-8" id="positionLevel_mainDiv">
                            <% values = ConfigUtility.getInputValuesFromConfig("position-level");
                                            String levelstring = wfmPosition.getLevel();
                                            String strArray[] = levelstring.split(",");
                                            for (String value : values) {
                                                    boolean found = false;
                                                    if(Arrays.asList(strArray).contains(value)){
                                                            found = true;
                                                    }else{
                                                            found = false;
                                                    } %>
                                                    <div class="col-sm-2 owncheck"> 
                                                    <div class="control-group form-inline"> 
                                                    <label class="checkbox">
                                                    <input <% if(found){ %> checked="checked" <% } %> class="field positionLevelCheckboix" name="positionCheckbox" onclick="updateCheckboxValue(); " type="checkbox" value="<%=value%>"> <%=value%> </label>
                                                     </div>
                                                     </div>
                            <% } %>
                                <aui:input name="positionLevel" type="hidden" value="<%=wfmPosition.getLevel()%>"></aui:input>
                              <div class="positionLevel_ValidationMessage form-validator-stack help-inline col-sm-8 " style="display: none;">
                       Missing required value for the field "Level"
                    </div>
                    </div>
            </div>
							<div class="portlet-layout row" style="margin-top: 8px;">
								<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Leadership Assignment</div>
                                <div id="leadershipassignment_mainDiv" class="portlet-column portlet-column-last col-sm-3">
									<aui:select  name="leadershipassignment"
										id="leadershipassignment" onChange="leadershipassignmentvalidate();"
										class="field-select chosen-container" placeholder="" label="" value="<%=wfmPosition.getLeadershipAssignment()%>"
										disabled="${not ADD_RS_2}">
										<aui:option value="">Select Leadership Assignment</aui:option>
										<%-- <aui:option value="<%=wfmPosition.getLeadershipAssignment()%>"><%=wfmPosition.getLeadershipAssignment()%></aui:option> --%>
										<%
											values = ConfigUtility.getInputValuesFromConfig("position-leadershipassignmenmt");
													Arrays.sort(values);
													for (String value : values) { %>
										<aui:option
											selected="<%=(null != wfmPosition.getLeadershipAssignment()
									&& wfmPosition.getLeadershipAssignment().equals(value))%>"
											value="<%=value%>"><%=value%></aui:option>
										<% } %>
									</aui:select>
                            <div class="leadershipassignment_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
									Missing required value for the field "Leadership Assignment"</div>
								</div>
							</div>
        <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Category</div>
                    <div id="category_mainDiv"  class="portlet-column portlet-column-last col-sm-3">
                            <c:if test="${not ADD_RS_2}">
                                    <aui:input name="category" type="hidden" value="<%=wfmPosition.getCategory()%>"></aui:input>
                            </c:if>
                            <aui:select  name="category" id="category"
                                    class="field-select chosen-container" placeholder="" label=""
                                    onChange="categoryvalidate()"
                                    value="<%=wfmPosition.getCategory()%>"
                                    disabled="${not ADD_RS_2}">
                                    <aui:option value="">Select Category</aui:option>
                                    <%-- <aui:option value="<%=wfmPosition.getCategory()%>"><%=wfmPosition.getCategory()%></aui:option> --%>
                                    <%
                                            values = ConfigUtility.getInputValuesFromConfig("position-category");
                                                            Arrays.sort(values);
                                                            for (String value : values) {
                                    %>
                                    <aui:option selected="<%=(null != wfmPosition.getCategory() && wfmPosition.getCategory().equals(value))%>"
                                            value="<%=value%>"><%=value%></aui:option>
                                    <%
                                            }
                                    %>
                            </aui:select>
                            <div id="other" <% if(!wfmPosition.getCategory().equalsIgnoreCase("Other")){ %> style="display: none;"  <% } %>>
				            <aui:input name="other" class="field" type="text" label=""
				                    maxLength="75" value="<%=wfmPosition.getOther()%>">
				            </aui:input>
			       			 </div>
                    <div class="category_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
			Missing required value for the field "Category"
                    </div>
	</div>
      </div>
        <div class="portlet-layout row">
                <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Subcategory</div>

                <div id="subCategory_mainDiv" class="portlet-column portlet-column-last col-sm-3">
                        <aui:select  name="subCategory" id="subCategory"
                                onChange="subCategoryvalidate();" class="field-select" placeholder="" label=""
                                value="<%=wfmPosition.getSubCategory()%>" disabled="${not ADD_RS_2}">
                                <aui:option value="">Select Subcategory</aui:option>
                                <%-- <aui:option value="<%=wfmPosition.getSubCategory()%>"><%=wfmPosition.getSubCategory()%></aui:option> --%>
                                <%
                                        values = ConfigUtility.getInputValuesFromConfig("position-subcategory");
                                                        Arrays.sort(values);
                                                        for (String value : values) {
                                %>
                                <aui:option
                                        selected="<%=(null != wfmPosition.getSubCategory()
                && wfmPosition.getSubCategory().equals(value))%>"
                                        value="<%=value%>"><%=value%></aui:option>
                                <% }  %>
                        </aui:select>
                <div class="subCategory_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                                 Missing required value for the field "Subcategory";
                </div>
            </div>
        </div>
        <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Workforce Category</div>
            <div id="workforceCategory_mainDiv" class="portlet-column portlet-column-last col-sm-3"> 
                    <aui:select name="workforceCategory" id="workforceCategory" placeholder="" label=""  cssClass="field-select secondsetchosen chosen-container" 
                            onChange="workforceCategoryvalidate();">
                            <aui:option value="">Select Workforce Category</aui:option>
                            <%
                            Map<String, String> shiftMap = new HashMap<String, String>();
                            shiftMap = ConfigUtility.getInputValuesForMap("workforce-category");
                            Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
                            for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {
                            %>
                            <aui:option   selected="<%=wfmPosition.getWorkforceCategory().equals(entry.getKey())%>"
                                    value="<%=entry.getKey()%>"><%=entry.getKey()%>-<%=entry.getValue()%>     </aui:option>
                            <%
                                    }
                            %>
                    </aui:select>
            <div class="workforceCategory_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Workforce Category"
            </div>
            </div>
    </div>
        <div class="portlet-layout row">
                <div class="portlet-column portlet-column-first col-sm-4">
                        <span class="sectionLabel">Position Description</span>
                </div>
                <div id="positionDescription_mainDiv" class="portlet-column portlet-column-last col-sm-3">
                        <aui:input type="text" name="positionDescription"
                                id="positionDescription" onkeyup="positionDescriptionvalidate();" 
                                value="<%=wfmPosition.getDescription()%>" label=""
                                 maxLength="75" disabled="${not ADD_RS_2}">								
                        </aui:input>	
                <div class="positionDescription_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Position Description"
                </div>
                </div>
        </div>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Typical Job Title</div>

            <div id="typicaljobtitle_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                    <aui:input type="textarea" name="typicaljobtitle"  onkeyup="typicaljobtitlevalidate();" 
                            id="typicaljobtitle"
                            value="<%=wfmPosition.getTypicalJobTitle()%>" class="field"
                            cols="55" placeholder="" rows="1" label="" maxLength="75" disabled="${not ADD_RS_2}">				
                    </aui:input>	
                <div class="typicaljobtitle_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                   Missing required value for the field "Typical Job Title"
                </div>
            </div>
    </div>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Minimum
                    Job Relevant Knowledge (Know how)</div>
		<div class="relevant_knowledge" style="border:1px solid black;width:587px;height:205px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;padding-left: 6px;padding-top: 4px;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=wfmPosition.getMinJobKnowHow()%> </div>
			<div id="minimum_knowledge" style="display:none">
            	<div id="minimumjob_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                    <aui:input type="textarea" name="minimumjob" id="minimumjob" onkeyup="minimumjobvalidate();" 
                            class="field" value="<%=wfmPosition.getMinJobKnowHow()%>"
                            label="" cols="55" placeholder="" rows="10" maxLength="7500" 
                            disabled="${not ADD_RS_2}">
                    </aui:input>
	                <div class="minimumjob_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
	                   Missing required value for the field "Minimum Job Relevent Knowledge"
	                </div>
            	</div>
            </div>
    </div>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Prioritized
                    duties and Responsibilities</div>
     <div class="duties_iebrowser" style="border:1px solid black;width:587px;height:205px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;padding-left: 6px;padding-top: 4px;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=wfmPosition.getDuties()%> </div> 
			<div id="dutiesresponsibilities_iebrowser" style="display:none">
            <div id="prioritizedduties_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                <aui:input type="textarea" name="prioritizedduties" onkeyup="prioritizeddutiesvalidate();" 
                                        id="prioritizedduties" class="field"
                                        value="<%=wfmPosition.getDuties()%>" label="" cols="55" 
                                        placeholder="" rows="10" maxLength="7500"
                                        disabled="${not ADD_RS_2}">
                </aui:input>
                <div class="prioritizedduties_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Prioritized duties and Responsibilities"
                </div>
            </div></div>
    </div>
    <div class="portlet-layout row">
        <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Daily Tasks Performed</div>
        <div class="Daily_task" style="border:1px solid black;width:587px;height:205px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;padding-left: 6px;padding-top: 4px;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=wfmPosition.getTasksPerformed()%> </div> 
		<div id="Daily_Performed" style="display:none">
            <div id="dailytask_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                <aui:input type="textarea" name="dailytask" id="dailytask" onkeyup="dailytaskvalidate();" 
                        class="field" value="<%=wfmPosition.getTasksPerformed()%>"
                        cols="55" placeholder="" label="" rows="10" maxLength="7500" 
                        disabled="${not ADD_RS_2}">
                </aui:input>
                <div class="dailytask_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Daily Tasks Performed"
                </div>
            </div>
        </div>
    </div>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Minimum
                    Job Relevant Experience (length of service)</div>
              <div class="Relevant_Experience" style="border:1px solid black;width:587px;height:205px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;padding-left: 6px;padding-top: 4px;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=wfmPosition.getLengthOfService()%> </div> 
		<div id="Relevant_Experience_job" style="display:none">
            <div id="lengthofservices_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                    <aui:input type="textarea" name="lengthofservices" onkeyup="lengthofservicesvalidate();" 
                            id="lengthofservices" class="field" 
                            value="<%=wfmPosition.getLengthOfService()%>" cols="55"
                            placeholder="" label="" rows="10" maxLength="7500" 
                            disabled="${not ADD_RS_2}">
                    </aui:input>
                <div class="lengthofservices_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Minimum Job Relevent Experience"
                </div>
            </div>
         </div>
    </div>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Degree or certification required</div>
            <div class="certification_required" style="border:1px solid black;width:587px;height:67px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;padding-left: 6px;padding-top: 4px;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=wfmPosition.getDegree()%> </div> 
		<div id="degree_certification_required" style="display:none">
            <div id="degreecertificate_mainDiv" class="portlet-column portlet-column-last col-sm-6">
	            <aui:input type="textarea" name="degreecertificate" id="degreecertificate" value="<%=wfmPosition.getDegree()%>" onkeyup="degreecertificatevalidate();" 
	                            class="field" cols="55" placeholder="" rows="3" label="" maxLength="250" disabled="${not ADD_RS_2}">
	            </aui:input>
	            <div class="degreecertificate_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
	                    Missing required value for the field "Degree or certification required"
	            </div>
    		</div>
    	</div>
    </div>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Required Skills (Musts)</div>
            <div class="Required_Skills" style="border:1px solid black;width:587px;height:205px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;padding-left: 6px;padding-top: 4px;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=wfmPosition.getReqSkills()%> </div>
		<div id="Required_Skills_musts" style="display:none">
            <div id="requiredskills_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                    <aui:input type="textarea" name="requiredskills" onkeyup="requiredskillsvalidate();" 
                            id="requiredskills" class="field"
                            value="<%=wfmPosition.getReqSkills()%>" cols="55"
                            placeholder="" rows="10" label="" maxLength="7500" 
                            disabled="${not ADD_RS_2}">
                    </aui:input>
	            <div class="requiredskills_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
	                    Missing required value for the field "Required Skills"
	            </div>
            </div>
       </div>
    </div>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Desired
                    Skills and Abilities (Wants)</div>
<div class="skills_and_Abilities" style="border:1px solid black;width:587px;height:205px;overflow:auto;background-color:#eee;font-size:14px;border: 1px solid #ccc;padding-left: 6px;padding-top: 4px;float: left;margin: 0 0 7px 15px;
border-radius: 2px;"> <%=wfmPosition.getDesiredSkills()%> </div>
		<div id="skills_and_Abilities_wants" style="display:none">
            <div id="desiredskills_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                    <aui:input type="textarea" name="desiredskills" onkeyup="desiredskillsvalidate();" 
                            id="desiredskills" class="field" cols="55"
                            value="<%=wfmPosition.getDesiredSkills()%>" placeholder=""
                            rows="10" label="" maxLength="7500"
                            disabled="${not ADD_RS_2}">
                    </aui:input>
				     <div class="desiredskills_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
				                    Missing required value for the field "Desired Skills and Abilities"
            		</div>
            </div>
       </div>
    </div>
    <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Environment
                            Associate will work in</div>
                    <div id="environmentassociate_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                            <aui:input type="textarea" name="environmentassociate"  onkeyup="environmentassociatevalidate();" 
                                    id="environmentassociate" class="field" cols="55" 
                                    value="<%=wfmPosition.getEnvironment()%>" placeholder=""
                                    rows="1" label="" maxLength="75" disabled="${not ADD_RS_2}">
                            </aui:input>
             <div class="environmentassociate_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Environment Associate will work in"
            </div>                    </div>            </div>
            <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Estimates
                            Weekly Overtime</div>

                    <div id="estimateweekly_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                            <aui:input type="textarea" name="estimateweekly" onkeyup="estimateweeklyvalidate();" 
                                    id="estimateweekly" class="field" cols="55" 
                                    value="<%=wfmPosition.getWeeklyOvertime()%>" placeholder=""
                                    rows="1" label="" maxLength="75" disabled="${not ADD_RS_2}">
                            </aui:input>
             <div class="estimateweekly_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Estimates Weekly Overtime"
            </div>               </div>            </div>
            <div class="portlet-layout row">
                    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Frequency
                            and Duration of Travel</div>

                    <div id="frequency_mainDiv" class="portlet-column portlet-column-last col-sm-6">
                            <aui:input type="textarea" name="frequency" id="frequency" onkeyup="frequencyvalidate();"  
                                    class="field" cols="55"
                                    value="<%=wfmPosition.getFrequencyOfTravel()%>"
                                    placeholder="" rows="1" label="" maxLength="75"
                                    disabled="${not ADD_RS_2}">
             
                            </aui:input>
                        <div class="frequency_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                    Missing required value for the field "Frequency and Duration of Travel"
            </div>                  </div>            </div>
    </div>
<div  id="thirdsetData" class="wfm-system" <% if((wfmPosition.getWorkflowStep() <= 60 && wfmPosition.getWorkflowStep() != -1) && !wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){%>style="display:none;"<%} %>>
    <div class="portlet-layout row">
            <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Employee Category</div>
                  <style>
                         #<portlet:namespace/>empCategoryStep_chosen{
                              width: 270px!important;
                          }
                             </style>
            <div id="empCategory_mainDiv" class="portlet-column portlet-column-last col-sm-3">
                    <aui:select name="empCategory" id="empCategory"
                            cssClass="field-select thirdsetchosen empCategory-chosen" placeholder="" label="" onChange="employeecatagorydescription(); empCategoryvalidate()" >
                            <aui:option value="">Select Employee Category</aui:option>
                            <%
                                    Map<String, String> shiftMap = new HashMap<String, String>();
                                                    shiftMap = ConfigUtility.getInputValuesForMap("Employe-category");
                                                    Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
                                                    for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {																
                            %>
                            <aui:option
                                    selected="<%=(wfmPosition.getEmpCategory().equals(entry.getKey()))%>"
                                    value="<%=entry.getKey()%>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
                            <%
                                    }
                            %>
                    </aui:select>
                    <div class="empCategory_ValidationMessage form-validator-stack help-inline" style="display: none;">
                    Missing required value for the field "Employee Category"</div>
            </div>
    </div>
    <div style="position: relative; top: -34px;">
            <img src="<%=request.getContextPath()%>/images/ajax-loader.gif"
                    id="img2" alt="Please wait a moment.." style="display: none"/>
    </div>
    <div class="portlet-layout row" >
    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Employee Category Description</div>
		<div class="employee_category col-sm-8">
            <%
                    if (wfmPosition.getEmpCategoryDesc().equalsIgnoreCase("")) {
            %>
            <div class="portlet-column portlet-column-last col-sm-8" id="desc" name="desc" ></div>
            <%
                    } else {
            %>
            <div id="desc"><%=wfmPosition.getEmpCategoryDesc()%></div>
            <%
                    }
            %>
        </div>
    </div>
</div>
							<div id="fourthsetData" class="wfm-system" <% if(wfmPosition.getWorkflowStep() <= 60 && wfmPosition.getWorkflowStep() != -1){%>style="display:none;"<%} %>>
								
								<div class="portlet-layout row">
									<div
										class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Comments</div>

									<div class="portlet-column portlet-column-last col-sm-6">
										<aui:input type="textarea" name="comments_updation" class="field" id="mcomments"
											value="<%=wfmPosition.getComments()%>" cols="55"
											placeholder="Comments" rows="3" label="" maxLength="250">
										</aui:input>
									</div>
								</div>
							</div>

							<%if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){ %>
							<div id="fourthsetData" class="wfm-system" >
								<div class="portlet-layout row">
									<div
										class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Comments</div>
									<div class="portlet-column portlet-column-last col-sm-8">
										<aui:input type="textarea" name="comments_updation" class="field" id="mcomments"
											value="<%=wfmPosition.getComments()%>" cols="55"
											placeholder="Comments" rows="3" label="" maxLength="250">
										</aui:input>
									</div>
								</div>
							</div>
					<%} %>
					<div class="portlet-layout row">
						<div class="col-sm-12 logs_main"
							style="font-style: oblique; font-size: 12px">
							<b>Log:</b>
						</div>
						<div class="users col-sm-12">
							<div class="logs_comments" style="line-height: 14px;">
								<%
									List<WFMS_Position_Audit> wfms_auditlist = WFMS_Position_AuditLocalServiceUtil.findByPosIdForAudit(pId);
								%>
									<%	for (WFMS_Position_Audit wfms_audit : wfms_auditlist) {         %>
                                          <div class="logs" style="border-bottom: thin dashed #dddd;">
									<div class="user_comments" id="user_comments">
										<br> 
										<%=wfms_audit.getChange()%>
										<% if(!wfms_audit.getComments().equalsIgnoreCase(WorkflowConstants.POSITION_MODIFY_POSITION_SUBMIT)){ %>
										By :
										<%=wfms_audit.getCreatedBy()%>
										--
										<%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate())%>
										<% } %>
												<% if(wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.POSITION_DISAPPROVE_POSITION)){ %>
												<div class="comments" id="comments">
												&nbsp; <div class="user" style="line-height: 19px;margin: -10px 0px -5px 0px;text-indent: 3px;"><b class="comment_title">Comments :</b><%=wfms_audit.getComments() %></div>
												</div>
												<% } %>
									</div>
								</div>
								<%}
								%>
							</div>
						</div>
					</div>
						</div>
					</div>
				</div>
            </div>             
			</div>
			<div style="display: none;">
			<%
			String validation_type="0";
			if( wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)){
				validation_type="1";
			}
			%>
				 <aui:input type="hidden" required="true" name="hidden_field" id="hidden_field" value="1" label="" maxlength="75"></aui:input>
		                 <aui:input type="textarea" name="validation_type" label="" value="<%=validation_type%>" disabled="${not ADD_RS_1}"> </aui:input>
                        </div>
				</aui:form>
							
			<div class="scroll_back_to_top">
			<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
			</div>	
<!----------------------------------- Disapprove Create Position workflow  --------------------------------->

<portlet:actionURL name="disapprovePosition" var="disapprovePositionURL">
<portlet:param name="positionId" value="<%=wfmPosition.getPId()%>"/>
</portlet:actionURL>
<div class="container">
	<div class="modal fade" id="disapprovePositionTocreate" style="display:none;" role="dialog">
		<div class="modal-dialog">
			<aui:form method="post"
				action="<%=disapprovePositionURL.toString()%>"
				name="disapprovePosition" id="disapprovePosition">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Please enter the reason for disapproval</h4>
					</div>
					<div class="modal-body">
						
						<aui:input type="textarea" name="Comments" label="" value="" required="true"
							class="field" cols="5" placeholder="Comments" rows="3"
							 />
						<aui:input type="hidden" name="positionId" label=""
							value="<%=wfmPosition.getPId()%>" required="true" />
					</div>
					<div class="modal-footer">
						<div class="col-sm-6 text-right">
							<aui:button type="submit" class="btn btn-primary" value="Save"></aui:button>
						</div>
						<div class="col-sm-6 text-left">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>
		           <c:if test="<%=wfmPosition.getWorkflowStep()==18%>">
			<div class="container">
			  <div class="modal fade" id="employeeCategoryId" role="dialog" style="display:none;">
			    <div class="modal-dialog">
			   <aui:form action="<%=saveEmpIdForPosition.toString()%>" method="post" name="empCategoryForm">
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title"> </h4>
			        </div>
			         <style>
                                 .chosen-container .chosen-results{
                                     max-height: 92px;
                                 }
                             </style>
                             <div class="modal-body " style="height: 145px;">
			        <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Employee Category</div>
			
					<div class="portlet-column portlet-column-last col-sm-8">
					 <aui:input type="hidden" name="posId"  value="<%=wfmPosition.getPId() %>"/>
			        	<aui:input name="positionId" type="hidden" value="<%=wfmPosition.getPId()%>"></aui:input>
						<aui:select cssClass="field-select chosen" name="empCategoryStep" placeholder="" label="" required="<%=true%>">
							<aui:option value="">Select Employee Category</aui:option>
							<%
								Map<String, String> shiftMap = new HashMap<String, String>();
										shiftMap = ConfigUtility.getInputValuesForMap("Employe-category");
										Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
										for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {																
							%>
							<aui:option
								selected="<%=(wfmPosition.getEmpCategory().equals(entry.getKey()))%>"
								value="<%=entry.getKey()%>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
							<%
								}
							%>
						</aui:select>
						<div id="empCategoryerrormesg" class="form-required"></div>
					</div>
			        </div>
			        <div class="modal-footer">
			        <div class="col-sm-2">
			          <aui:button type="submit" class="btn btn-primary" value="Save"></aui:button>
			        </div>
			        <div class="col-sm-2">
			        	<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
			        </div>
			        </div>
			      </div>
			 	</aui:form>
			    </div>
			  </div>
			  
			</div>
		</c:if>
<!----------------------------------- Disapprove Position popup end---------------------------------->
  <%if(Validator.isNotNull(statusValue)){%> 
  
  <aui:script>
  
  //$( document ).ready(function() {
	
		AUI().use('aui-base',
				'aui-io-plugin-deprecated',
				'liferay-util-window',

			function(A) {

				var popUpWindow = Liferay.Util.Window.getWindow({
					dialog : {
						centered : true,
						constrain2view : true,
						align : {
							node : null,
							points : [ 'tc', 'tc' ]
						},
						modal : true,
						cache : false,
						width : 550,
						height : 150,
						destroyOnClose : true,
					}
				}).plug(A.Plugin.IO, {
					autoLoad : false
				}).render();
				popUpWindow.show();
				popUpWindow.titleNode.html("Do you want to generate a requisition for the Current Position?");
				popUpWindow.io.set('uri',"<%=generateReqPopupURLFromUpdatePosition%>");
				popUpWindow.io.start();
 	});
	//});
		</aui:script>
	
 <% } if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)) {
     if(existedCosStatus){ 
    		DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
    		dynamicQueryForCos.add(PropertyFactoryUtil.forName("assoicateId").eq(wfmPosition.getAssociateNumber()));
    		dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
    		Criterion Coscriterion = null;
    		Coscriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.COS_DRAFT);
    		Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT));
    		dynamicQueryForCos.add(Coscriterion);
    	      cos_list= WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
    	      if(cos_list.size()> 0){
     %>
     
           <aui:script>
                    $("#swapAssociatepopup").click(function(){
                    $('#message_alert_popup').html("You cannot Swap \ "+"<%=wfmPosition.getAssociateName()%>"+"\  [\ "+"<%=wfmPosition.getAssociateNumber()%>"+"\] while there is an open Change of Status  [\ "+"<%=cos_list.get(0).getCosId()%>"+"\] ");
				    $('#modifyPositionAlert').modal({ backdrop: 'static',
				         keyboard: true, 
				         show: true});
				     });
                   </aui:script>
	  <% }}else{ %>
	
 <!--  Swap Associate Workflow Start by kiran -->	  
					<%
				DynamicQuery dynamicjunctionANDQuery = WFMS_PositionLocalServiceUtil.dynamicQuery();
				Junction junctionAND = RestrictionsFactoryUtil.conjunction();
				Property property = PropertyFactoryUtil.forName("departmentName");
				junctionAND.add(property.eq(wfmPosition.getDepartmentName()));
				property = PropertyFactoryUtil.forName("dummy");
				junctionAND.add(property.eq("0"));
				property = PropertyFactoryUtil.forName("ladder");
				junctionAND.add(property.eq(wfmPosition.getLadder()));
				property = PropertyFactoryUtil.forName("leadershipAssignment");
				junctionAND.add(property.eq(wfmPosition.getLeadershipAssignment()));
				property = PropertyFactoryUtil.forName("status");
				junctionAND.add(property.eq("Filled"));
				junctionAND.add(PropertyFactoryUtil.forName("associateNumber").ne(wfmPosition.getAssociateNumber()));
				dynamicjunctionANDQuery.add(junctionAND);
				List<WFMS_Position> wfms_posList=WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicjunctionANDQuery);
				if(wfms_posList.size()>0){ %>
				<div class="container">
			  <div class="modal fade" id="swapAssociate" role="dialog" style="display:none;">
			    <div class="modal-dialog">
			    <aui:form method="post" action="<%=swapAssociateURL.toString() %>"
				name="swapAssociate" id="swapAssociate">
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal" id="swapAssociatefromclose">&times;</button>
		          <h4 class="modal-title">Choose associate to swap</h4>
		        </div>
		        <div class="move_search">
						 <input id="filtro" class="filtro_class" name="filtro" type="text" onkeyup="filter(this)" placeholder="Search"/>	
				</div>
		        <div class="modal-body" style="overflow-y: scroll;max-height: 250px;">	
		            <aui:input type="hidden" name="posId"  value="<%=wfmPosition.getPId() %>"/>
		         	<div class="checkbox">
					  
					  <aui:input type="hidden" value="<%=wfmPosition.getAssociateNumber()%>" name="currentAssociateNumber"></aui:input>  
				<%
					ArrayList<String> arrlist = new ArrayList<String>();
						for(WFMS_Position wfms_pos:wfms_posList){
						  if(!arrlist.contains(wfms_pos.getAssociateNumber())){
							arrlist.add(wfms_pos.getAssociateNumber().trim());
							if(!(wfms_pos.getAssociateNumber().trim().equalsIgnoreCase("")) && !(wfms_pos.getAssociateNumber().equalsIgnoreCase("None"))){
						%>
						<div id="filtro_mod">
					 	<ul id="theList">
						   <li> <label class="move_checkboxtext">	<input type="checkbox" label="" class="associateId-list" name="associateId" id="associateId" value="<%=wfms_pos.getAssociateNumber() %>"/>  [<%=wfms_pos.getAssociateNumber() %>] <%=wfms_pos.getAssociateName() %> [Current Position: <%=wfms_pos.getPId() %>]
                    </label> </li> 
					</ul>
					</div>	
						<%
						}
						  }
						}
						arrlist.clear();
						%>
				  <div id="error_msg" style="display: none;color: red; margin-top : -7px;">This field is required.</div>
				 </div>
			        
			      </div>
			      <div class="modal-footer" style="margin-top: 30px;">
			        <div class="col-sm-2" id="swapAssociateSaveButtonDiv">
			          <aui:button type="button" class="btn btn-primary" value="Save" name="swapAssociate" onClick="swapAssociate();"></aui:button>
			        </div>
			        <div class="col-sm-2"> 
			        	<button type="button" class="btn btn-primary" data-dismiss="modal" id="swap_associate">Close</button>
			        </div>
			        </div>
			      </div>
			      
			      <aui:input type="hidden" name="selectedAssocId" id="selectedAssocId" value=""/>
			 	</aui:form>
			    </div>
			  </div>
			  </div>
			  
<style>

/* Edit the CSS to style the tooltip */
 .disabledButtonDiv:hover:after {
    position:relative;
    top:10px;
    left:0px;
    border:1px solid #000;
    background-color:#ffc;
    color:#000;
    padding: 3px;
    font-size: 12px;
    text-align: center;
    content: attr(faketitle);
}
 ul {
  list-style-type: none;
}

</style>

<% if(deptMap.isEmpty()) {
		String currentURL = PortalUtil.getCurrentURL(request);
		if(currentURL.contains("?")){
			currentURL = currentURL.split("\\?")[0];
		}
		 %>
		<br>
	<aui:script>
  //	$( document ).ready(function() {
		AUI().use('aui-base',
				'aui-io-plugin-deprecated',
				'liferay-util-window',
			function(A) {
				var popUpWindow = Liferay.Util.Window.getWindow({
					dialog : {
						centered : true,
						constrain2view : true,
						align : {
							node : null,
							points : [ 'tc', 'tc' ]
						},
						modal : true,
						cache : false,
						width : 550,
						height : 150,
						destroyOnClose : true,
					}
				}).plug(A.Plugin.IO, {
					autoLoad : false
				}).render();

				popUpWindow.show();
				popUpWindow.titleNode.html("");
				popUpWindow.io.set('uri',"<%=generateInternetConnection%>");
				popUpWindow.io.start();
 	});
	//});
	</aui:script>
	<br>
	<%} %>
	<script>
window.filter = function(element) {
    var value = $(element).val().toUpperCase();

    $("#filtro_mod > ul > li").each(function() {
      if ($(this).text().toUpperCase().search(value) > -1) {
          $(this).show();
      }
      else {
           $(this).hide();
      }
    });
  }
$('input').keyup(function() {
    filter(this); 
});

function filter(element) {
    var value = $(element).val();
    $("#theList > li").each(function () {
        if ($(this).text().indexOf(value) > -1) {
            $(this).show();
        } else {
            $(this).hide();
        }
    });
}
</script>
			  <aui:script>
			       $("#swapAssociatepopup").click(function(){
				   $('#swapAssociate').modal({ backdrop: 'static',
					         keyboard: true, 
					         show: true});
				   });
			  </aui:script>
		 <% }else{ %>
                   <aui:script>
                    $("#swapAssociatepopup").click(function(){
					$('#message_alert_popup').html("No open positions match this ladder and leadership.");
				   $('#modifyPositionAlert').modal({ backdrop: 'static',
				         keyboard: true, 
				         show: true});
				     });
                   </aui:script>			  
				<% } %>

<% } } %>
<!--  Swap Associate Workflow Start by kiran -->
 <aui:script>
	    $('.associateId-list').on('change', function() {
		    $('.associateId-list').not(this).prop('checked', false);  
		    $("#error_msg").hide();
		});
			$("#swap_associate").click(function(){
 			$(".filtro_class").val('');
 			 filter($(".filtro_class").val('')); 
	    	$('.associateId-list').prop('checked', false);
	    });
 		
 		$("#swapAssociatefromclose").click(function(){
 			$(".filtro_class").val('');
 			 filter($(".filtro_class").val('')); 
	    	$('.associateId-list').prop('checked', false);
	    });
 			function swapAssociate(){
	    	var associateValue=$('input[name="associateId"]:checked').val();
	    	$("#<portlet:namespace/>associateValue").val(associateValue);
	    	if(jQuery(".associateId-list").is(":checked")){
	    		$("#error_msg").hide();
	    		$("#<portlet:namespace/>selectedAssocId").val(associateValue);
	    	    document.getElementById('<portlet:namespace />swapAssociate').submit();	
	    	}
	    	else{
	    		$("#error_msg").show();
	    		$('input[name="associateId"]:checked').focus();
	    	return false;	
	    	}
	      }
 			
 			$('#bb').on('keyup keypress', function(e) {
 				  var keyCode = e.keyCode || e.which;
 				  if (keyCode === 13) { 
 				    e.preventDefault();
 				    return false;
 				  }
 				});
    	  function moveAssociate(){
		 			var moveassociateValue=$('input[name="moveassociateId"]:checked').val();		
			    	$("#<portlet:namespace/>moveassociateValue").val(moveassociateValue);		
			    	if(jQuery(".move-associateId-list").is(":checked")){		
			    		$("#move-error_msg").hide();		

	                    if($.trim($('input[name=<portlet:namespace/>auto-gen-req]:checked').val())=="false"){
							      $('#yesNoModal').modal({ backdrop: 'static',
						          keyboard: true, 
						          show: true});    			
			    		}		
			    		else{
				    		$("#<portlet:namespace />generateRequisation").val(1);		
				    		document.getElementById('<portlet:namespace />moveAssociateForm').submit();		
			    		}		
			    	}		
			    	else{		
			    		$("#move-error_msg").show();		
			    		$('input[name="associateId"]:checked').focus();		
			    	    return false;			
			    	}		
	 		    }
 	    function loadDivisonDepName(Deptid){
                Deptidvalidate();
        $('#Division').html("");
		$('#DEPT_NAME').html("");
                if(Deptid!=''){
	 	 $('#img').show();
	    $.ajax({
	        url : '<%=resourceURL.toString()%>',    
	        data: {
				<portlet:namespace />Deptid: Deptid,
	     		<portlet:namespace />cmd: 'LoadDivisionNames' 
	     	},
	        type: "POST",
	        dataType: "json",
	        success: function(data) {
	        	$('#Division').html(data.Division);
	        	$('#DEPT_NAME').html(data.DEPT_NAME);
	        	$('#img').hide();
	        	if(data.DEPT_NAME=="" || data.DEPT_NAME.length <3){
					 document.getElementById('departmentname').innerHTML='Department Name less than three characters is invalid - Please contact System Admin';
					 $('#<portlet:namespace/>hidden_field').val('');
					 
				}
				else{
					document.getElementById('departmentname').innerHTML='';
					$('#img').hide();
				}
	        	
	        },
	        error: function (response) {
	  			//console.log("Error seen for loadDivisonDepName ajax result");
	        }
		});
    }
	}
 	function validateradio() {
		datevalidation();
 	}
 	function reOpensubmit(value){
		//console.log(value);
		$("#<portlet:namespace/>reopenButton").val(value);
		$("#<portlet:namespace/>updateForPosition").submit();
	}
	function redirectToupdateForPosition() {
		document.getElementById('<portlet:namespace />updateForPosition').submit();	
	}
	function updateRequest() {
		document.getElementById('<portlet:namespace />manageNotifications').submit();		
	}
	function closepositionclickevent(val) {
		$("#<portlet:namespace/>yesorno").val(val);
		document.getElementById('<portlet:namespace />closePosition').submit();		
	}
	function reopenEvent(){
			    $.ajax({
			        url : '<%=resourceURL.toString()%>',    
			        data: {
			        	<portlet:namespace />pid: '<%=pId%>',
		         	   	<portlet:namespace />status: '<%=wfmPosition.getStatus()%>' ,
		         	  	<portlet:namespace />cmd: 'reopenEvent' 
		         	},   
			        type: "POST",
			        dataType: "json",
			        success: function(data) {
						$('#reopen').html('Open');
							if(data.success='true'){
							
							   $('#openid1').show();
				        	   $('#closedid').hide();
				        	   $('#closedid1').hide();
						}
			        },
			        error: function (response) {
			  			//console.log("Error seen for reopenEvent ajax result");
			        }
				});
			}
			function closePositionEvent(){
	  					    $.ajax({
	  					        url : '<%=resourceURL.toString()%>',    
	  					        data: {
	  					        	<portlet:namespace />pid: '<%=pId%>',
	  				         	    <portlet:namespace />status: '<%=wfmPosition.getStatus()%>' ,
	  				         	  	<portlet:namespace />cmd: 'closePositionEvent' 
	  				         	},
	  					        type: "POST",
	  					        dataType: "json",
	  					        success: function(data) {
	  					        	
	  					           if(data.status='Closed'){
	  					        	   $('#reopen').html(data.status);
	  					        	   $('#openid').hide();
	  					        	   $('#openid1').hide();
	  					        	   $('#closedid1').show();
	  					          		//hide the close div
	  					            }
	  					           else {
	  					        	   $('#reopen').html('Open');
	  					        	}
	  					        },
	  					        error: function (response) {
	  					  		//	console.log("Error seen for closePositionEvent ajax result");
	  					        }
	  						});
	  					}
</aui:script>
<%

	if (null != wfmPosition.getStatus() && null != wfmPosition.getAutoGenerateReq()
			&& null != request.getAttribute("autoReqForTerminate")) {
		if (wfmPosition.getStatus().equalsIgnoreCase("Open")
				&& wfmPosition.getAutoGenerateReq().equalsIgnoreCase("false")) {
%>
<aui:script>
//$( document ).ready(function() {
			AUI().use('aui-base',
					'aui-io-plugin-deprecated',
					'liferay-util-window',
				function(A) {
					var popUpWindow = Liferay.Util.Window.getWindow({
						dialog : {
							centered : true,
							constrain2view : true,
							align : {
								node : null,
								points : [ 'tc', 'tc' ]
							},
							modal : true,
							cache : false,
							width : 550,
							height : 150,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();
					popUpWindow.show();
					popUpWindow.titleNode.html("Do you want to generate a requisition for the Current Position?");
					popUpWindow.io.set('uri',"<%=generateReqPopupURLFromUpdatePosition%>");
					popUpWindow.io.start();
	 	});
		//	});
</aui:script>
<%
	}
	}
%>
<%
	if (null != wfmPosition.getStatus() && null != wfmPosition.getAutoGenerateReq()
			&& null != request.getAttribute("autoReqAfterTerminate")) {
		if (wfmPosition.getStatus().equalsIgnoreCase("Open")
				&& wfmPosition.getAutoGenerateReq().equalsIgnoreCase("false")) {
%>
<aui:script>
		window.onload = function() {
			AUI().use('aui-base',
					'aui-io-plugin-deprecated',
					'liferay-util-window',
				function(A) {
					var popUpWindow = Liferay.Util.Window.getWindow({
						dialog : {
							centered : true,
							constrain2view : true,
							align : {
								node : null,
								points : [ 'tc', 'tc' ]
							},
							modal : true,
							cache : false,
							width : 550,
							height : 150,
							destroyOnClose : true,
						}
					}).plug(A.Plugin.IO, {
						autoLoad : false
					}).render();

					popUpWindow.show();
					popUpWindow.titleNode.html("Do you want to generate a requisition for the Current Position?");
					popUpWindow.io.set('uri',"<%=generateReqPopupURLAfterTerminateAssociate%>");
					popUpWindow.io.start();
	 	});
			};
		</aui:script>
<% } } %>
<aui:script>
function employeecatagorydescription(){
	    var empCategoryID=$("#<portlet:namespace/>empCategory").val();
	  //  console.log(": empCategory "+empCategoryID)
	     $('#img2').show();
	      $.ajax({  
	       url : '<%=resourceURL.toString()%>',
	    data : {
	     <portlet:namespace />empCategoryID : empCategoryID,
	     <portlet:namespace />cmd : 'Employecategory',
	     <portlet:namespace />cmdType : 'Employe-category',
	    },
	    type : "POST",
	    dataType : "json",
	    success : function(data) {
	    // console.log(data);
	     $('#desc').html(data.desc);
	     $('#img2').hide();
	    },
	    error : function(response) {
	       //    console.log("Error seen for for loadDivisonDepName");
	           $('#img2').hide();
	    }
	   });
   }

function generateRequistionInUpdate(value) {
	  $("#<portlet:namespace/>autoreqGenForReopen").val(value);
	   $("#<portlet:namespace/>updateForPosition").submit();
				
}
function generateReqAfterTerminateAssociate(value){
	 $("#<portlet:namespace/>modalvalue").val(value);
	 $("#<portlet:namespace/>terminateAssociate").submit();
}
</aui:script>
<%   if (Validator.isNotNull(addAssociateModal) && addAssociateModal.equalsIgnoreCase("addAssociate")) { %>
<aui:script>
//$( document ).ready(function() {
	 $('#assdetailsAddId').modal({backdrop:'static'});
	 
//});
</aui:script>
<% } if (Validator.isNotNull(filledmodal) && filledmodal.equalsIgnoreCase("filledmodal")) { %>
<aui:script>
//$( document ).ready(function() {
	  $('#filledModal').modal({backdrop:'static'});
//});
</aui:script>
<% } %>

<!---------------Add associate Popup code end----------- -->
<!-- ----------------------      Move associate code start    -------------------------------- -->
<%
	if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)) {
		String cosStatus = "";

		String associateNumber = wfmPosition.getAssociateNumber();
		DynamicQuery dynamicQueryForCosTemp = WFMS_COSLocalServiceUtil.dynamicQuery();
		dynamicQueryForCosTemp.add(PropertyFactoryUtil.forName("assoicateId").eq(associateNumber));
		dynamicQueryForCosTemp.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
		Long cosTotalListTemp = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCosTemp);
		Long cosTotalList1 = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCosTemp);
		Criterion CoscriterionTemp = null;
		CoscriterionTemp = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_APPROVED);
		CoscriterionTemp = RestrictionsFactoryUtil.or(CoscriterionTemp,
				RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_CANCELLED));
		CoscriterionTemp = RestrictionsFactoryUtil.or(CoscriterionTemp,
				RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DISAPPROVED));
		dynamicQueryForCosTemp.add(CoscriterionTemp);

		Long cosListTemp = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCosTemp);
		if (cosTotalListTemp != cosListTemp) { showNotify=true; %>
		<%
		DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
    		dynamicQueryForCos.add(PropertyFactoryUtil.forName("assoicateId").eq(wfmPosition.getAssociateNumber()));
    		dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
    		Criterion Coscriterion = null;
    		Coscriterion = RestrictionsFactoryUtil.like("status", HondaPermissionKeys.COS_DRAFT);
    		Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_SUBMIT));
    		dynamicQueryForCos.add(Coscriterion);
    	      cos_list= WFMS_COSLocalServiceUtil.dynamicQuery(dynamicQueryForCos);
    	     
    	      %>
		<script>
		$(document).ready(function(){
		$("#MoveAssociateShowButton").click(function(){
		
			$('#message_alert_popup').html("You cannot Move \ "+"<%=wfmPosition.getAssociateName()%>"+"\  [\ "+"<%=wfmPosition.getAssociateNumber()%>"+"\] while there is an open Change of Status  [\ "+"<%= cos_list.get(0).getCosId()%>"+"\] ");
			 
	      $('#modifyPositionAlert').modal({ backdrop: 'static',
          keyboard: true, 
          show: true});
		    });
		});
		</script>
		<%
	} else {
			ArrayList<String> positionIds = new ArrayList<String>();
			DynamicQuery dynamicQueryForPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
			dynamicQueryForPosition.add(PropertyFactoryUtil.forName("status").eq(HondaPermissionKeys.POS_OPEN));
			dynamicQueryForPosition.add(PropertyFactoryUtil.forName("dummy").eq("0"));
			dynamicQueryForPosition.add(PropertyFactoryUtil.forName("ladder").eq(wfmPosition.getLadder()));
			dynamicQueryForPosition.add(PropertyFactoryUtil.forName("leadershipAssignment")
					.eq(wfmPosition.getLeadershipAssignment()));
			if (checkDepartment.equals("1")) {
				dynamicQueryForPosition.add(PropertyFactoryUtil.forName("departmentNumber").eq(wfmPosition.getDepartmentNumber()));
			}
			List<WFMS_Position> positionsList = WFMS_PositionLocalServiceUtil.dynamicQuery(dynamicQueryForPosition);
			if (positionsList.size() > 0) {

				for (WFMS_Position position : positionsList) {
					DynamicQuery dynamicQueryForRequisation = WFMS_RequisitionLocalServiceUtil.dynamicQuery();
					dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("rId").eq(position.getPId()));
					dynamicQueryForRequisation.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
					Long TotalRequisations = WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(dynamicQueryForRequisation);
					Criterion reqcriterion = null;
					reqcriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_CANCELLED);
					reqcriterion = RestrictionsFactoryUtil.or(reqcriterion,
							RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.REQ_COMPLETE));
					dynamicQueryForRequisation.add(reqcriterion);
					Long requisationList = WFMS_RequisitionLocalServiceUtil
							.dynamicQueryCount(dynamicQueryForRequisation);
					if (TotalRequisations == requisationList) {
						DynamicQuery dynamicQueryForCos = WFMS_COSLocalServiceUtil.dynamicQuery();
						dynamicQueryForCos.add(PropertyFactoryUtil.forName("newPositionNumber").eq(position.getPId()));
						dynamicQueryForCos.add(PropertyFactoryUtil.forName("deleteflagStatus").eq(0));
						Long cosTotalList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos);
						Criterion Coscriterion = null;
						Coscriterion = RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_APPROVED);
						Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,
								RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_CANCELLED));
						Coscriterion = RestrictionsFactoryUtil.or(Coscriterion,
								RestrictionsFactoryUtil.eq("status", HondaPermissionKeys.COS_DISAPPROVED));
						dynamicQueryForCos.add(Coscriterion);

						Long cosList = WFMS_COSLocalServiceUtil.dynamicQueryCount(dynamicQueryForCos);
						if (cosTotalList == cosList) {
							positionIds.add(position.getPId());
						}
					}

				}
%>
<%
 	if (positionIds.size() > 0) { %>
 	<portlet:actionURL name="moveAssociate" var="moveAssociateURL"></portlet:actionURL>
 	<div class="container">
<div class="modal fade" id="SelectAssociate" style="display:none;">
	<div class="modal-dialog">
		<aui:form method="post" action="<%=moveAssociateURL.toString()%>"
			name="moveAssociateForm" id="moveAssociateForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id="moveAssociateFormclose" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Available positions for Move</h4>
				</div>
				<div class="move_search">
					<input id="filtro" name="filtro" class="filtro_class" type="text" onkeyup="filter(this)" placeholder="Search"/>	 
				</div>
				<div class="modal-body" style="overflow-y: scroll; max-height: 250px;">
					<aui:input type="hidden" name="posId" value="<%=wfmPosition.getPId()%>" />
					
					<div class="checkbox">
						<aui:input type="hidden" name="moveassociateValue"></aui:input>
						<aui:input type="hidden" name="generateRequisation"></aui:input>
							 	<% for (int i = 0; i < positionIds.size(); i++) { %> 
					<div id="filtro_mod">
                       <ul id="theList">
							<li>   <label class="move_checkboxtext">   <input type="checkbox"	class="move-associateId-list" name="moveassociateId" value="<%=positionIds.get(i)%>" /><%=positionIds.get(i)%> 
							  	</label>  </li>
					   </ul>
					</div>	   <%}%>
						<div id="move-error_msg"
							style="display: none; color: red; margin-top: -7px;">This field is required.</div>
					</div>
				</div>
				<div class="modal-footer" style="margin-top: 30px;">
						<div class="col-sm-2">
							<aui:button type="button" class="btn btn-primary" value="Move"
								name="moveAssociateButton" onClick="moveAssociate();"></aui:button>
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" id="move_associate_close">Close</button>
						</div>
					</div>
			</div>
		</aui:form>
	</div>
</div>
</div>
<style>
/* Edit the CSS to style the tooltip */
 .disabledButtonDiv:hover:after {
    position:relative;
    top:10px;
    left:0px;
    border:1px solid #000;
    background-color:#ffc;
    color:#000;
    padding: 3px;
    font-size: 12px;
    text-align: center;
    content: attr(faketitle);
}
 ul {
  list-style-type: none;
}
</style>
<script>
window.filter = function(element) {
    var value = $(element).val().toUpperCase();

    $("#filtro_mod > ul > li").each(function() {
      if ($(this).text().toUpperCase().search(value) > -1) {
          $(this).show();
      }
      else {
           $(this).hide();
      }
    });
  }

$('input').keyup(function() {
	
    filter(this); 
});

function filter(element) {
    var value = $(element).val();
    $("#theList > li").each(function () {
        if ($(this).text().indexOf(value) > -1) {
            $(this).show();
        } else {
            $(this).hide();
        }
    });
}
</script>

<script>
$("#MoveAssociateShowButton").click(function(){
	      $('#SelectAssociate').modal({ backdrop: 'static',
          keyboard: true, 
          show: true});    
    }); 
</script>
		 	<%
		 } else {
		 %> 
		 <script>
		    		$("#MoveAssociateShowButton").click(function(){
							    $('#message_alert_popup').html("No open positions match this ladder and leadership.");
						      $('#modifyPositionAlert').modal({ backdrop: 'static',
					          keyboard: true, 
					          show: true});   
							    
							    });
		   </script>
		  <%
		 	}
		 %>
						
<div class="container">
	<div class="modal fade in" id="yesNoModal" role="dialog" style="display:none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="yui3-widget-hd modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3>Do you want to generate a requisition for the vacated Position?</h3>
				</div>
				 <div class="yui3-widget-bd modal-body"
					style="max-height: 150px; height: 60px;">
					<div class="portlet-layout row">
						<div class="col-sm-5">
							<button style="width: 100%;" class="btn btn-primary" type="button"
								onclick="reqPopupComplete('1');this.disabled=true">Yes</button>
						</div>
						<div class="col-sm-2"></div>
						<div class="col-sm-5">
							<button style="width: 100%;" class="btn btn-primary" type="button"
								onclick="reqPopupComplete('0');this.disabled=true">No</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<aui:script>
      function reqPopupComplete(x){
           $("#<portlet:namespace />generateRequisation").val(x);
           document.getElementById('<portlet:namespace />moveAssociateForm').submit();	
      }
$('.move-associateId-list').on('change', function() {
    $('.move-associateId-list').not(this).prop('checked', false);  		
    $("#move-error_msg").hide();		
    		
});	

$("#move_associate_close").click(function(){
	$(".filtro_class").val('');
	 filter($(".filtro_class").val('')); 
	$('.move-associateId-list').prop('checked', false);	
	$("#move-error_msg").hide();		
});

$("#moveAssociateFormclose").click(function(){
	$(".filtro_class").val('');
	 filter($(".filtro_class").val('')); 
	$('.move-associateId-list').prop('checked', false);	
	$("#move-error_msg").hide();		
});

</aui:script>
<%
	} else {
%>
<aui:script>
		$(document).ready(function(){
		$("#MoveAssociateShowButton").click(function(){
		    $('#message_alert_popup').html("No open positions match this ladder and leadership.");
	      $('#modifyPositionAlert').modal({ backdrop: 'static',
          keyboard: true, 
          show: true});   
		    
		    
		    }); 
         });
</aui:script>
<div class="modal fade" id="SelectAssociate" style="display:none;">
	<div class="modal-dialog">
		<aui:form method="post" action="" name="moveAssociateForm"
			id="moveAssociateForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id="moveAssociateFormclose" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Available positions for Move</h4>
				</div>
				<div class="modal-body">
					<div class="checkbox">
						<label> There is no available positions for Move. </label>
					</div>
					<div class="modal-footer" style="margin-top: 30px;">
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" id="move_associate_close">Close</button>
						</div>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>

<%
	}
		}
	}
%>
<div style="display: none;">
	<aui:form method="post" action="<%=ApproveURL%>" name="positionAapproveForm" id="positionAapproveForm">
	</aui:form>
	
</div>
<!-- ----------------------      Move associate code end    -------------------------------- -->
<aui:script>
 function HmaContract() {
   HmaContractValidate();
  if($("#<portlet:namespace />mpCatBudgetAss").val()!=""){
	  if($("#<portlet:namespace />mpCatBudgetAss").val()=="Contractor"  || $("#<portlet:namespace />mpCatBudgetAss").val()=="HMA"){
		  $('#addAssforHMA').modal();
	  }
	  else{
		     $('#addAssforHMA').modal('hide');	
	  }
   }
}
function HmaContractValidate() {
		 var val=$.trim($("#<portlet:namespace />mpCatBudgetAss").val());
		if(val==''){
			$("#mpCatBudgetAss_ValidationMessage").show();
            $('#mpCatBudgetAss_maindiv').addClass('control-group error');
            return false;
		}
		else{
			$("#mpCatBudgetAss_ValidationMessage").hide();
            $('#mpCatBudgetAss_maindiv').removeClass('control-group error');
            return true;
		}
	}
  function associateNumberValidation() {
	  if($("#associatenumber").val()=="" ||  $("#associatenumber").val() === null){
			$("#associatenumber_ValidationMessage").show();
            $('#associatenumber_maindiv').addClass('control-group error');
            return false;
		}
		else{
			$("#associatenumber_ValidationMessage").hide();
            $('#associatenumber_maindiv').removeClass('control-group error');
            return true;
		}
}
  function mpFilledDetails() {
  
	  if($("#mpCatFilledWithAdd").val()==""){
          document.getElementById("errormesgModalFilled").innerHTML = "This field is required.";
	  }
	  else{
		  document.getElementById("errormesgModalFilled").innerHTML = "";
		 document.getElementById("<portlet:namespace />savempCatFilled").submit();	
		 }
}
  function associateNameChange(){
        associateNumberValidation();
        
	  if($("#associatenumber").val()==""){
          $('#assName').html("");
			$('#AssTitle').html("");
			 $('#assName').hide();
			 $('#AssTitle').hide();
	  }
	  else{

	      var deptId=$("#associatenumber").val();
		// console.log(": empCategory "+deptId)
		 $('#img').show();
		    $.ajax({  
	   		url : '<%=resourceURL.toString()%>',
				data : {<portlet:namespace />cmd : 'getAssNameForAddAssociate',
					<portlet:namespace />cmdType : deptId
				},
				type : "POST",
				dataType : "json",
				success : function(data) {
			  $('#assName').html('<div class="portlet-column portlet-column-first col-sm-5"><span class="sectionLabel">Associate Name</span></div><div class="portlet-column portlet-column-last col-sm-7">'+data.AssName+'</div>');
			  $('#AssTitle').html('<div class="portlet-column portlet-column-first col-sm-5"><span class="sectionLabel">Associate Title</span></div><div class="portlet-column portlet-column-last col-sm-7">'+ data.AssTitle +'</div>');
			  $('#assName').show();
			  $('#AssTitle').show();
				$('#img').hide();
				},
				error : function(response) {
		        //	console.log("Error seen for for loadDivisonDepName");
					$('#img').hide();
				}
			});
	  }
	} 
  function modifyFunction(value) {
		var show="<%=showNotify%>";
		$("#<portlet:namespace/>buttonclickUpdate").val(value);
		if(show=="true"){
			$('#message_alert_popup').html("You cannot modify this associate while there is an open Change of Status.");
		     $('#modifyPositionAlert').modal({ backdrop: 'static',
	          keyboard: true, 
	          show: true});
	    }else{
	     <% if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED)){ %>
	        $('#fifthsetData :input').prop('disabled', false);
	    <% } %>
	    	$('#secondsetData :input').prop('disabled', false);
	        $('#firstsetData :input').prop('disabled', false);
	        <% if(!ismodifed){ %>
            $('#<portlet:namespace />divdeptRest').prop('disabled', true);
            <% } %>
	        $('#thirdsetData :input').prop('disabled', false);
	        $('#fourthsetData :input').prop('disabled', false);
	        jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
                $('#<portlet:namespace/>startDate').addClass('datepicker');
	        jQuery(".thirdsetchosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	        jQuery(".secondsetchosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
			var A=new AUI();
			A.all('.modifySubmit').removeClass('disabled');
			A.all('.modifySubmit').removeAttribute('disabled');	
	}
  }
		
		function mpCatBudgetvalidate(){ 
                 var type=$("#<portlet:namespace/>validation_type").val();
			var val=$.trim($("#<portlet:namespace />mpCatBudget").val());
		 if(val=='' && type==1){
			$(".mpCatBudget_ValidationMessage").show();
                        $('#mpCatBudget_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
		}
		else{
                     $('#mpCatBudget_mainDiv').removeClass('control-group error');
                     $(".mpCatBudget_ValidationMessage").hide();
		}
	    }
	    function mpCatFilledWithvalidate(){
		   var val=document.getElementById("<portlet:namespace />mpCatFilledWith");
			if(val.value==''){
				text = "Missing required value for the field &quot;MpCatFilledwith &quot;";
				document.getElementById("mpCatFilledWitherrormesg").innerHTML = text;
				$("#<portlet:namespace/>hidden_field").val('');
				val.focus();
			}
			else{
				 document.getElementById("mpCatFilledWitherrormesg").innerHTML = '';
			}
		 }
		function workforceCategoryvalidate(){
			
                        var type=$("#<portlet:namespace/>validation_type").val();
			var val=$("#<portlet:namespace />workforceCategory").val();
			if(val=='' && type==1){
                                       $(".workforceCategory_ValidationMessage").show();
                                       $('#workforceCategory_mainDiv').addClass('control-group error');
                                       $('#<portlet:namespace/>hidden_field').val('');
				}
				else{
				       $('#workforceCategory_mainDiv').removeClass('control-group error');
                                       $(".workforceCategory_ValidationMessage").hide();
				}
			
			 }
		function empCategoryvalidate(){
                var type=$("#<portlet:namespace/>validation_type").val();
			var val=$("#<portlet:namespace />empCategory").val();
			if(val=='' && type==1){
				$(".empCategory_ValidationMessage").show();
                                $('#empCategory_mainDiv').addClass('control-group error');
			        $('#<portlet:namespace/>hidden_field').val(''); 
			}
                        else{
                            $('#empCategory_mainDiv').removeClass('control-group error');
                            $(".empCategory_ValidationMessage").hide();
                        }	
		}
        function datevalidation(){
            var type=$("#<portlet:namespace/>validation_type").val();
            var reEvaluationDate=$("#<portlet:namespace/>startDate").val();
            var A=new AUI();
        	   if($('[name=<portlet:namespace/>positionClass]:checked').length>0){
            var checkBoxValue= A.one("input[name=<portlet:namespace/>positionClass]:checked").get("value"); 
            if(checkBoxValue=="Temporary"){
                if(reEvaluationDate=='' && type==1){
                    $(".startDate_ValidationMessage").show();
                    $('#startDate_mainDiv').addClass('control-group error');
                    $('#<portlet:namespace/>hidden_field').val('');
                }
                else {
                    $(".startDate_ValidationMessage").hide();
                    $('#startDate_mainDiv').removeClass('control-group error');
                }
            }
            else {
                $(".startDate_ValidationMessage").hide();
                $('#startDate_mainDiv').removeClass('control-group error');
            }
           }
       	   else {
                  $(".startDate_ValidationMessage").hide();
                  $('#startDate_mainDiv').removeClass('control-group error');
              }
        }
	function Deptidvalidate(){
		var val=$("#<portlet:namespace />divdeptRest").val();
		if(val==''){
			$(".Deptid_ValidationMessage").show();
            $('#Deptid_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
            $('#Deptid_mainDiv').removeClass('control-group error');
			$(".Deptid_ValidationMessage").hide();
		}
	}
        function yearEstvalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />yearEst").val());
		if(val=='' && type==1){
			$(".yearEst_ValidationMessage").show();
                        $('#yearEst_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".yearEst_ValidationMessage").hide();
                        $('#yearEst_mainDiv').removeClass('control-group error');
		}
	}
function updateCheckboxValue(){
                    	
	var type=$("#<portlet:namespace/>validation_type").val();	
                    	 var favorite = [];
                         $.each($("input[name='positionCheckbox']:checked"), function(){            
                             favorite.push($(this).val());
                         });
             		    $("#<portlet:namespace/>positionLevel").val(favorite.join(","));
                    	if(favorite.length == 0 && type==1){
                    		$(".positionLevel_ValidationMessage").show();
                            $('#positionLevel_mainDiv').addClass('control-group error');
                    		$('#<portlet:namespace/>hidden_field').val('');   
                    	}
                    	else{
                    		$(".positionLevel_ValidationMessage").hide();
                            $('#positionLevel_mainDiv').removeClass('control-group error');
                    	}
}
	
        function reportsTovalidate(){
                var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace/>report").val();
		if(val==''  && type==1){
                  	$(".reportsTo_ValidationMessage").show();
                        $('#reportsTo_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".reportsTo_ValidationMessage").hide();
                        $('#reportsTo_mainDiv').removeClass('control-group error');
		}
	    return true;
	}
        function leadershipassignmentvalidate(){
                  var type=$("#<portlet:namespace/>validation_type").val();
		  var val=$("#<portlet:namespace />leadershipassignment").val();
		        if(val=='' && type==1){
                            $(".leadershipassignment_ValidationMessage").show();
                            $('#leadershipassignment_mainDiv').addClass('control-group error');
                            $("#<portlet:namespace/>hidden_field").val('');
			}
			else{
                            $(".leadershipassignment_ValidationMessage").hide();
                            $('#leadershipassignment_mainDiv').removeClass('control-group error');
			}
            return true;
	}
        function subCategoryvalidate(){
		var val=$("#<portlet:namespace />subCategory").val();
                var type=$("#<portlet:namespace/>validation_type").val();
		if(val=='' && type==1){
			    $(".subCategory_ValidationMessage").show();
                            $('#subCategory_mainDiv').addClass('control-group error');
                            $("#<portlet:namespace/>hidden_field").val('');
			}
			else{
				 $(".subCategory_ValidationMessage").hide();
                                $('#subCategory_mainDiv').removeClass('control-group error');
			}
            return true;
	}
        function categoryvalidate(){
                    var empCategory=$("#<portlet:namespace/>category").val();
                    var type=$("#<portlet:namespace/>validation_type").val();
                    $('#other').hide();
                        if(empCategory=='' && type==1){
                               $(".category_ValidationMessage").show();
                               $('#category_mainDiv').addClass('control-group error');
                               $("#<portlet:namespace/>hidden_field").val('');
                        }
                        else{
                            $(".category_ValidationMessage").hide();
                            $('#category_mainDiv').removeClass('control-group error');
                            if(empCategory=='Other'){
                                $('#other').show();
                            }
                            else{
                               $('#other').hide();
                            }
                        }
            return true;
        }
        function laddervalidate(){
                       var type=$("#<portlet:namespace/>validation_type").val();
			var val=$("#<portlet:namespace />ladder").val();
			if(val=='' && type==1){
				$(".ladder_ValidationMessage").show();
                                $('#ladder_mainDiv').addClass('control-group error');
                                $('#<portlet:namespace/>hidden_field').val(''); 
			}
			else{
				$(".ladder_ValidationMessage").hide();
                                $('#ladder_mainDiv').removeClass('control-group error');
			}
            return true;
	}
        function reasonchangevalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />reasonchange").val());
		if(val=='' && type==1){
			$(".reasonchange_ValidationMessage").show();
                        $('#reasonchange_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".reasonchange_ValidationMessage").hide();
                        $('#reasonchange_mainDiv').removeClass('control-group error');
		}
	}	      
        function positionDescriptionvalidate(){
              var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />positionDescription").val());
		if(val=='' && type==1){
			$(".positionDescription_ValidationMessage").show();
                        $('#positionDescription_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".positionDescription_ValidationMessage").hide();
                        $('#positionDescription_mainDiv').removeClass('control-group error');
		}        }
        function typicaljobtitlevalidate(){
             var type=$("#<portlet:namespace/>validation_type").val();
		   var val=$.trim($("#<portlet:namespace />typicaljobtitle").val());
		if(val=='' && type==1){
			$(".typicaljobtitle_ValidationMessage").show();
                        $('#typicaljobtitle_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".typicaljobtitle_ValidationMessage").hide();
                        $('#typicaljobtitle_mainDiv').removeClass('control-group error');
		}        }
        function minimumjobvalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />minimumjob").val());
		if(val=='' && type==1){
			$(".minimumjob_ValidationMessage").show();
                        $('#minimumjob_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".minimumjob_ValidationMessage").hide();
                        $('#minimumjob_mainDiv').removeClass('control-group error');
		}        }
        function prioritizeddutiesvalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />prioritizedduties").val());
		if(val=='' && type==1){
			$(".prioritizedduties_ValidationMessage").show();
                        $('#prioritizedduties_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".prioritizedduties_ValidationMessage").hide();
                        $('#prioritizedduties_mainDiv').removeClass('control-group error');
		}        }
        function dailytaskvalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />dailytask").val());
		if(val=='' && type==1){
			$(".dailytask_ValidationMessage").show();
                        $('#dailytask_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".dailytask_ValidationMessage").hide();
                        $('#dailytask_mainDiv').removeClass('control-group error');
		}        }
        function lengthofservicesvalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />lengthofservices").val());
		if(val=='' && type==1){
			$(".lengthofservices_ValidationMessage").show();
                        $('#lengthofservices_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".lengthofservices_ValidationMessage").hide();
                        $('#lengthofservices_mainDiv').removeClass('control-group error');
		}        }
        function degreecertificatevalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />degreecertificate").val());
		if(val=='' && type==1){
			$(".degreecertificate_ValidationMessage").show();
                        $('#degreecertificate_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".degreecertificate_ValidationMessage").hide();
                        $('#degreecertificate_mainDiv').removeClass('control-group error');
		}        }
        function requiredskillsvalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />requiredskills").val());
		if(val=='' && type==1){
			$(".requiredskills_ValidationMessage").show();
                        $('#requiredskills_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".requiredskills_ValidationMessage").hide();
                        $('#requiredskills_mainDiv').removeClass('control-group error');
		}        }
        function desiredskillsvalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />desiredskills").val());
		if(val=='' && type==1){
			$(".desiredskills_ValidationMessage").show();
                        $('#desiredskills_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".desiredskills_ValidationMessage").hide();
                        $('#desiredskills_mainDiv').removeClass('control-group error');
		}        }
        function environmentassociatevalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />environmentassociate").val());
		if(val=='' && type==1){
			$(".environmentassociate_ValidationMessage").show();
                        $('#environmentassociate_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".environmentassociate_ValidationMessage").hide();
                        $('#environmentassociate_mainDiv').removeClass('control-group error');
		}    }
        function estimateweeklyvalidate(){
           var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />estimateweekly").val());
		if(val=='' && type==1){
			$(".estimateweekly_ValidationMessage").show();
                        $('#estimateweekly_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".estimateweekly_ValidationMessage").hide();
                        $('#estimateweekly_mainDiv').removeClass('control-group error');
		}       }
        function frequencyvalidate(){
          var type=$("#<portlet:namespace/>validation_type").val();
		var val=$.trim($("#<portlet:namespace />frequency").val());
		if(val=='' && type==1){
			$(".frequency_ValidationMessage").show();
                        $('#frequency_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val('');   
		}
		else{
			$(".frequency_ValidationMessage").hide();
                        $('#frequency_mainDiv').removeClass('control-group error');
		}
        
        }
        function positionTypevalidate(){
            var type=$("#<portlet:namespace/>validation_type").val();
  		if($('[name=<portlet:namespace/>positionType]:checked').length==0 && type==1){
  			$(".positionType_ValidationMessage").show();
                          $('#positionType_mainDiv').addClass('control-group error');
  			$('#<portlet:namespace/>hidden_field').val('');   
  		}
  		else{
  			$(".positionType_ValidationMessage").hide();
                          $('#positionType_mainDiv').removeClass('control-group error');
  		}
          
          }
        function linevalidate(){
            var type=$("#<portlet:namespace/>validation_type").val();
  			if($('[name=<portlet:namespace/>line]:checked').length==0 && type==1){
  			$(".line_ValidationMessage").show();
                          $('#line_mainDiv').addClass('control-group error');
  			$('#<portlet:namespace/>hidden_field').val('');   
  		}
  		else{
  			$(".line_ValidationMessage").hide();
                          $('#line_mainDiv').removeClass('control-group error');
  		}
          }
        function positionClassvalidate(){
            var type=$("#<portlet:namespace/>validation_type").val();
   		if($('[name=<portlet:namespace/>positionClass]:checked').length==0 && type==1){
   			//alert("new");
   			$(".positionClass_ValidationMessage").show();
                           $('#positionClass_mainDiv').addClass('control-group error');
   			$('#<portlet:namespace/>hidden_field').val('');   
   		}
   		else{
   			$(".positionClass_ValidationMessage").hide();
                           $('#positionClass_mainDiv').removeClass('control-group error');
   		}
   	}
	function secondset(){
                $("#saveId").show();
                $("#submitId").show();
        }
        function validatereports() {
            var x, text;
           datevalidation();
            x = document.getElementById("<portlet:namespace/>associatenumber").value;
            if (x=="" ) {
                text = "This field is required.";
                document.getElementById("errormesg").innerHTML = text;
                return false;
            } else{
              document.getElementById("errormesg").innerHTML = "";
              return true;
            }

        }
    function generateReqClick(value) {
		checkServiceNowIsDownPoPup();
		if(value == "generateReqValue"){
			  $("#<portlet:namespace/>buttonclickUpdate").val("");
		 }
            $('#<portlet:namespace/>hidden_field').val('1'); 
            if(value == "save"){
                    $('#<portlet:namespace/>saveonworkflow').val('save'); 
                    $('#<portlet:namespace/>validation_type').val(0);
            }
            else{
            	 $('#<portlet:namespace/>validation_type').val(1);
            }
            <% if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_PENDING) || wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED) || wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN)){ %>
            <% if(wfmPosition.getWorkflowStep()==40 || wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED) ||  wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN)){ %>
                reportsTovalidate();
                updateCheckboxValue();
                leadershipassignmentvalidate();
                subCategoryvalidate();
                workforceCategoryvalidate();
                categoryvalidate();
                laddervalidate();
                positionDescriptionvalidate();
                typicaljobtitlevalidate();
                minimumjobvalidate();
                prioritizeddutiesvalidate();
                dailytaskvalidate();
                lengthofservicesvalidate();
                degreecertificatevalidate();
                requiredskillsvalidate();
                desiredskillsvalidate();
                environmentassociatevalidate();
                estimateweeklyvalidate();
                frequencyvalidate();
                positionTypevalidate();
                linevalidate();
                if(value == "save"){
                   $(".form-validator-stack").hide();
                }
            <% } if(wfmPosition.getWorkflowStep()==70 ||  wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED) ||  wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN)){ %>
                empCategoryvalidate();
                
            <% } } %>
     <% if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT) ||  wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_FILLED) ||  wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_OPEN)){ %>
            if(value == "updatepositionValue"){
                Deptidvalidate();
                mpCatBudgetvalidate();
                yearEstvalidate();
                reasonchangevalidate();
                datevalidation();
                positionClassvalidate();
              }
         <% } %>  
      
          if(value != "save"){
                                     var auiForm = Liferay.Form._INSTANCES._Position_updateForPosition;
                                     var auiValidator = auiForm.formValidator;
                                  //   auiValidator.validate();
                                     console.log(auiValidator);
                                      if (!auiValidator.hasErrors() && $('#<portlet:namespace/>hidden_field').val()!="") { 

                                    	  $('#generateReqClick').modal('hide');
                                                    $("button[type=button]").attr('disabled',true);
                                                    $("#<portlet:namespace/>genreqValue").val(value);
                                                    $('#firstsetData :input').attr('disabled', false);
                                                    $('#secondsetData :input').attr('disabled', false);
                                                    $('#thirdsetData :input').attr('disabled', false);
                                                    $('#fourthsetData :input').attr('disabled', false);
                                                   $("#<portlet:namespace/>updateForPosition").submit();
                                      }
                                      else{
                                    	
                                    	  	$('#generateReqClick').modal();
                                  			}
                                      }
                                     else{   
                                    $("button[type=button]").attr('disabled',true);
                                    $("#<portlet:namespace/>genreqValue").val(value);
                                    $('#firstsetData :input').attr('disabled', false);
                                    $('#secondsetData :input').attr('disabled', false);
                                    $('#thirdsetData :input').attr('disabled', false);
                                    $('#fourthsetData :input').attr('disabled', false);
                                   $("#<portlet:namespace/>updateForPosition").submit();
            }	        			
    }
    function modifyPostion(){
            //$("#<portlet:namespace/>updateForPosition").submit();
    }
    function savePostion(){
            $("#<portlet:namespace/>buttonclickUpdate").val("SaveModify");
            $("#<portlet:namespace/>updateForPosition").submit();
    }
   function cancelPosition(){
         $("#<portlet:namespace/>cancelPosition").submit();
    }
    function checkAutoGenReqAndSubmit() {
            var val = $( "input:radio[name='<portlet:namespace/>auto-gen-req']:checked") .val();

            if (val == "false") {
                    getAuiGenerateReqPopup();
            } else {
                    $("#<portlet:namespace/>updateForPosition").submit();
            }
    }
    function generateReqPopupComplete(value) {
              $("#<portlet:namespace/>auto-gen-req-choice").val(value);
              $("#<portlet:namespace/>updateForPosition").submit();
             }
    function getAuiGenerateReqPopup() {

            AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',function(A) {

                                    var popUpWindow = Liferay.Util.Window.getWindow({
                                            dialog : {
                                     centered : true,
                                     constrain2view : true,
                                     align : {
                                             node : null,
                                             points : [ 'tc', 'tc' ]
                                     },
                                     modal : true,
                                     cache : false,
                                     width : 550,
                                     height : 150,
                                     destroyOnClose : true,
                                            }
                                    }).plug(A.Plugin.IO, {
                                            autoLoad : false
                                    }).render();

                                    popUpWindow.show();
                                    popUpWindow.titleNode.html(" Do you want to generate a requisition for the Current Position?");
                                    popUpWindow.io.set('uri',"<%=generateReqPopupURL%>");
                                    popUpWindow.io.start();
            });
    }
	 $(document).ready(function(){
			$("#<portlet:namespace />mcomments").removeAttr("disabled");
			<% if(wfmPosition.getWorkflowStep() <= 70){%>
			$( "#addData").click(function() {
				$("#<portlet:namespace />mcomments").removeAttr("disabled");
			});
			<%}%>
		});
		function modifyEmpCat(val){
			  var url="<%=saveEmpIdForPosition.toString()%>";
			  document.<portlet:namespace/>empCategoryForm.action =url;
			  document.getElementById("<portlet:namespace/>empCategoryForm").submit();
		}
		function approveModify(){
             var url="<%=approvePositionForModifyURL.toString()%>";
			  document.<portlet:namespace/>updateForPosition.action =url;
			  document.getElementById("<portlet:namespace/>updateForPosition").submit();
		}
		function employeeCatId(){
			var popup=document.getElementById("employeeCatId").innerHTML;
			var popUpWindow = Liferay.Util.Window.getWindow({
				dialog : {
					centered : true,
					constrain2view : true,
					align : {
						node : null,
						points : [ 'tc', 'tc' ]
					},
					modal : true,
					cache : false,
					width : 550,
					height : 150,
					title: 'Notification detail',
					bodyContent: popup ,
					destroyOnClose : true,
				}
			}).plug(A.Plugin.IO, {
				autoLoad : false
			}).render();
			popUpWindow.show();
			popUpWindow.io.start();
		}
	    function closepoitionYesORNo() {
	        AUI().use('aui-base',
	                                'aui-io-plugin-deprecated',
	                                'liferay-util-window',
	                        function(A) {
	                                var popUpWindow = Liferay.Util.Window.getWindow({
	                                        dialog : {
	                                                centered : true,
	                                                constrain2view : true,
	                                                align : {
	                                                        node : null,
	                                                        points : [ 'tc', 'tc' ]
	                                                },
	                                                modal : true,
	                                                cache : false,
	                                                width : 690,
	                                                height : 150,
	                                                destroyOnClose : true,
	                                        }
	                                }).plug(A.Plugin.IO, {
	                                        autoLoad : false
	                                }).render();
	                                popUpWindow.show();
	                                popUpWindow.titleNode.html("Are you sure you want to permanently close this position?");
	                                popUpWindow.io.set('uri',"<%=closepositionYesorNoURL%>");
	                                popUpWindow.io.start();
	        });
	}
	    function modifypoitionforapprove() {
	     $('#message_alert_popup').html("Cannot change the position as Requisition is in Filled state");
	     $('#modifyPositionAlert').modal({ backdrop: 'static',
          keyboard: true, 
          show: true});
	}
	    function checkServiceNowIsDown(){
		 	AUI().use('aui-base',
			'aui-io-plugin-deprecated',
			'liferay-util-window',

		function(A) {
			var popUpWindow = Liferay.Util.Window.getWindow({
				dialog : {
					centered : true,
					constrain2view : true,
					align : {
						node : null,
						points : [ 'tc', 'tc' ]
					},
					modal : true,
					cache : false,
					width : 550,
					height : 150,
					destroyOnClose : true,
				}
			}).plug(A.Plugin.IO, {
				autoLoad : false
			}).render();

			popUpWindow.show();
			popUpWindow.titleNode.html("");
			popUpWindow.io.set('uri',"<%=generateInternetConnection%>");
			popUpWindow.io.start();
	});
	 }
	function checkServiceNowIsDownPoPup(){
		
	    $.ajax({
	    		url : '<%=resourceURL.toString()%>',
				data : {
					
					<portlet:namespace />cmd : 'checkServiceNowIsDown'
				},
				type : "POST",
				dataType : "json",
				success : function(data) {
			
					if(data.sucess)checkServiceNowIsDown();
					
				},
				error : function(response) {
		        //	console.log("Error seen for for checkServiceNowIsDownPoPup");
				}
		});
}
</aui:script>
<!----------------------------------- Disapprove Position popup start---------------------------------->
<portlet:actionURL name="disapprovePositionForModify" var="disapprovePositionForModifyURL">
  <portlet:param name="positionId" value="<%=wfmPosition.getPId()%>"/>
  <portlet:param name="flowControl" value="false"/>
</portlet:actionURL>
<div class="container">
	<div class="modal fade" id="disapprovePositionModal" role="dialog" style="display:none;">
		<div class="modal-dialog">
			<aui:form method="post"
				action="<%=disapprovePositionForModifyURL.toString()%>"
				name="disapprovePositionForModify" id="disapprovePositionForModify">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Please enter a comment explaining the disapproval</h4>
					</div>
					<div class="modal-body">
						<aui:input type="hidden" name="reqid" value="" />
						<aui:input type="textarea" name="Comments" label="" value="" required="true"
							class="field"  cols="5" maxlength="3000" placeholder="Comments" rows="3"
							 />
						<aui:input type="hidden" name="positionId" label=""
							value="<%=wfmPosition.getPId()%>" required="true" />
						<aui:input type="hidden" name="flowControl" label=""
							value="<%=false%>" required="true" />
						<aui:input type="hidden" name="mailid" label=""
							value="<%=user.getEmailAddress()%>" required="true" />
					</div>
					<div class="modal-footer">
						<div class="col-sm-2">
							<aui:button type="submit" class="btn btn-primary" value="Save"></aui:button>
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="container">
<div class="modal fade" id="generateReqClick" style="top: 10%!important;display:none;">
	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id="moveAssociateFormclose" class="close"	data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body" style="overflow: auto; overflow-y: auto; max-height: 400px;line-height: 30px;">
					<div class="control-group error">
					   <h4 class="modal-title help-inline">Please fill the following required fields</h4>
					  	<ul class="popup-validation-messages">
                   			<li class="Deptid_ValidationMessage col-sm-12 help-inline" style="display: none;">Department Number</li>
                   			<li class="mpCatBudget_ValidationMessage col-sm-12 help-inline" style="display: none;">MP Category Budget</li>
                   			<li class="yearEst_ValidationMessage col-sm-12 help-inline" style="display: none;">Year Established</li>   
                   			<li class="reasonchange_ValidationMessage col-sm-12 help-inline" style="display: none;">Reason for addition or changes</li>
                   			<li class="startDate_ValidationMessage col-sm-12 help-inline" style="display: none;">Position Re-evaluation date</li>
                   			<li class="reportsTo_ValidationMessage col-sm-12 help-inline" style="display: none;">Position Reports to</li>
                   			<li class="line_ValidationMessage col-sm-12 help-inline" style="display: none;">Line</li>
							<li class="ladder_ValidationMessage col-sm-12 help-inline" style="display: none;">Ladder</li>
							<li class="positionType_ValidationMessage col-sm-12 help-inline" style="display: none;">Type</li>
							<li class="positionLevel_ValidationMessage col-sm-12 help-inline" style="display: none;">Level (Choose all that apply)</li>
							<li class="leadershipassignment_ValidationMessage col-sm-12 help-inline" style="display: none;">Leadership Assignment</li>
							<li class="category_ValidationMessage col-sm-12 help-inline" style="display: none;">Category</li>
							<li class="subCategory_ValidationMessage col-sm-12 help-inline" style="display: none;">Subcategory</li>
							<li class="workforceCategory_ValidationMessage col-sm-12 help-inline" style="display: none;">Workforce Category</li>
							<li class="positionDescription_ValidationMessage col-sm-12 help-inline" style="display: none;">Position Description</li>
							<li class="typicaljobtitle_ValidationMessage col-sm-12 help-inline" style="display: none;">Typical Job Title</li>
							<li class="minimumjob_ValidationMessage col-sm-12 help-inline" style="display: none;">Minimum Job Relevant Knowledge (Know how)</li>
							<li class="prioritizedduties_ValidationMessage col-sm-12 help-inline" style="display: none;">Prioritized duties and Responsibilities</li>
							<li class="dailytask_ValidationMessage col-sm-12 help-inline" style="display: none;">Daily Tasks Performed</li>
							<li class="lengthofservices_ValidationMessage col-sm-12 help-inline" style="display: none;">Minimum Job Relevant Experience (length of service)</li>
							<li class="degreecertificate_ValidationMessage col-sm-12 help-inline" style="display: none;">Degree or certification required</li>
							<li class="requiredskills_ValidationMessage col-sm-12 help-inline" style="display: none;">Required Skills (Musts)</li>
							<li class="desiredskills_ValidationMessage col-sm-12 help-inline" style="display: none;">Desired Skills and Abilities (Wants)</li>
							<li class="environmentassociate_ValidationMessage col-sm-12 help-inline" style="display: none;">Environment Associate will work in</li>
							<li class="estimateweekly_ValidationMessage col-sm-12 help-inline" style="display: none;">Estimates Weekly Overtime</li>
							<li class="frequency_ValidationMessage col-sm-12 help-inline" style="display: none;">Frequency and Duration of Travel</li>
							<li class="empCategory_ValidationMessage col-sm-12 help-inline" style="display: none;">Employee Category</li>
							<li class="positionClass_ValidationMessage col-sm-12 help-inline" style="display: none;">Position Class</li>
	                   </ul>
	                 </div>
				</div>
				<div class="modal-footer" style="margin-top: 30px;">
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary" data-dismiss="modal" id="move_associate_close">Close</button>
						</div>
					</div>
			</div>
	</div>
</div>
</div>
<% if(Validator.isNotNull(ModifyPosPopUpforReq)){ %>
<script type="text/javascript">
$(document).ready(function (){
	modifypoitionforapprove() ;
});
</script>
<%}
	if (null != request.getAttribute("modifypositionalert")) { %>
	<aui:script>
	$('#message_alert_popup').html("As you have not modified any values over Position, the position status remains same.");
	$('#modifyPositionAlert').modal({ backdrop: 'static',
          keyboard: true, 
          show: true});
</aui:script>	
	<% } %>
<div class="container">
	<div class="modal fade" id="modifyPositionAlert" role="dialog" style="display:none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div id="message_alert_popup" class="popup-cont"></div>
				<div class="modal-footer">
					<div class="">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="swap_associate">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="terminate_alert_popup" style="display:none;">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="yui3-widget-hd modal-header">
			      <div class="toolbar-content yui3-widget component toolbar">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<h3>Do you want to Terminate the associate?</h3>
				</div>
				<div class="yui3-widget-bd modal-body">
					<div class="col-sm-12">
						<div class="portlet-layout row">
						    <aui:button cssClass="btn btn-primary col-sm-5" name="terminateAssociate"  type="button"
									onClick='<%=terminateAssociateURL.toString()%>' value="Yes"></aui:button>
								<div class="col-sm-2"></div>
								     <button class="btn btn-primary col-sm-5" type="button" data-dismiss="modal">No</button>
						 </div>
					 </div>
				 </div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
if ($('#back-to-top').length) {
    var scrollTrigger = 100, // px
        backToTop = function () {
            var scrollTop = $(window).scrollTop();
            if (scrollTop > scrollTrigger) {
                $('#back-to-top').addClass('show');
            } else {
                $('#back-to-top').removeClass('show');
            }
        };
    backToTop();
    $(window).on('scroll', function () {
        backToTop();
    });
    $('#back-to-top').on('click', function (e) {
        e.preventDefault();
        $('html,body').animate({
            scrollTop: 0
        }, 700);
    });
}
function copyPosition() {
	$('#img_copy').show();
$.ajax({
		url : '<%=resourceURL.toString()%>',
		data : {
			<portlet:namespace />Pid :  '<%= wfmPosition.getPId()%>',
			<portlet:namespace />cmd : 'CopyPosition'
		},

		type : "POST",
		dataType : "json",
		success : function(data) {
			$('#img_copy').hide();
		var target=target="_blank";
			$('#link').html("<a href='"+data.link+"'   >Position was copied with new position Number  ' <b>"+data.sucess+" '</b></a>  ");
			
		$('#pid_copyPosition').show();
		$('#link').show();
		 jQuery("#link a").prop("target","_blank");
		},
		error : function(response) {
        	//console.log("Error seen for copy position--");
			$('#img_copy').hide();
		}
	});
}
//$( document ).ready(function() {
	$('#pid_copyPosition').hide();
	$('#img_copy').hide();
//});
function redirectExit(){ 
	window.location.href = 'position';
}
function mpcaterydropdown(){
	//$("#mpcatBudget").show();   $('#addAssforHMA').modal();
	  $('#mpcatBudget').modal();
}
</script>

<% if(renderRequest.getParameter("printPosition") == null){ %>
<div class="print"  id="printableArea">
<%@ include file="/html/position/print-position.jsp" %> 
</div>
<%} %>
<script type="text/javascript">
 		function printDiv(divName) {
 	        var printContents = document.getElementById(divName).innerHTML;
 	        w = window.open();
 	        w.document.write(printContents);
 	        w.document.write('<scr' + 'ipt type="text/javascript">' + 'window.onload = function() { window.print(); window.close(); };' + '</sc' + 'ript>');
 	        w.document.close(); // necessary for IE >= 10
 	        w.focus(); // necessary for IE >= 10
 	        return true;
 	    }
 	$(document).ready(function() {
 			$('.modal-backdrop').remove();
 			$('.modal-backdrop').remove();
 			$('.modal-backdrop').remove();
 			} );
    </script>

<style type="text/css"  > 
	.print { display:none; } 
</style>
<style type="text/css" media="print">
	.manageCOS { display:block;}
	.print { display:none; }
</style>
