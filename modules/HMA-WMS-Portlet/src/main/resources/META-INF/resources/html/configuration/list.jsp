<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_routing_and_approversLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_routing_and_approvers"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Config"%>
<%@page import="com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeImpl"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_action_names"%>
<%@page import="com.ys.hmawfm.wfms.services.model.impl.WFMS_action_namesImpl"%>
<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>

<portlet:actionURL name="gridworkflowConfiguration" var="manageworkflowConfigURL"></portlet:actionURL>
<portlet:actionURL name="newConfiguration" var="newConfigurationURL"></portlet:actionURL>
<portlet:actionURL name="importView" var="importViewURL"></portlet:actionURL>	
<portlet:actionURL name="routingapproversView" var="routingapproversURL"></portlet:actionURL>	
<portlet:actionURL name="naSupportView" var="naSupportViewURL"></portlet:actionURL>
<portlet:actionURL name="actionandreasoncodeView" var="actionandreasoncodeURL"></portlet:actionURL>	


<%
	List<WFMS_Config> configurationList = (List<WFMS_Config>) request.getAttribute("list");
	

	 if(WFMS_action_namesLocalServiceUtil.getWFMS_action_namesesCount()==0){
	System.out.println("Count>>"+WFMS_action_and_reasoncodeLocalServiceUtil.getWFMS_action_and_reasoncodesCount());
	List<WFMS_action_and_reasoncode> wfms_action_and_reasoncode=WFMS_action_and_reasoncodeLocalServiceUtil.getWFMS_action_and_reasoncodes(0, WFMS_action_and_reasoncodeLocalServiceUtil.getWFMS_action_and_reasoncodesCount());
	List<WFMS_routing_and_approvers> wfms_routing_and_approvers=WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approverses(0, WFMS_routing_and_approversLocalServiceUtil.getWFMS_routing_and_approversesCount());

	List<String> linkedHashSet = new ArrayList();
	System.out.println("wfms_action_and_reasoncode>>"+wfms_action_and_reasoncode.size());
	
	for(WFMS_action_and_reasoncode listData:wfms_action_and_reasoncode){		
		if(!linkedHashSet.contains(listData.getAction())){
			  	linkedHashSet.add(listData.getAction());
			  	System.out.println("ActionName>>>>"+listData.getAction());
			    WFMS_action_names wfms_action_names = new WFMS_action_namesImpl();
			    long and_approvers = CounterLocalServiceUtil.increment(WFMS_action_names.class.getName()); 
			    wfms_action_names.setActionId(Long.toString(and_approvers));
				wfms_action_names.setCreateDate(listData.getCreateDate());
				wfms_action_names.setCreatedBy(listData.getCreatedBy());
				wfms_action_names.setDeleteflag(0);
				wfms_action_names.setActionName(listData.getAction());
				wfms_action_names=WFMS_action_namesLocalServiceUtil.addWFMS_action_names(wfms_action_names);
				System.out.println("wfms_action_id>>>"+wfms_action_names.getActionId());
	   }
	}
	for(WFMS_routing_and_approvers listData:wfms_routing_and_approvers){		
		if(!linkedHashSet.contains(listData.getAction())){
			  	linkedHashSet.add(listData.getAction());
			  	System.out.println("ActionName>>>>"+listData.getAction());
			    WFMS_action_names wfms_action_names = new WFMS_action_namesImpl();
			    long and_approvers = CounterLocalServiceUtil.increment(WFMS_action_names.class.getName()); 
			    wfms_action_names.setActionId(Long.toString(and_approvers));
				wfms_action_names.setCreateDate(listData.getCreateDate());
				wfms_action_names.setCreatedBy(listData.getCreatedBy());
				wfms_action_names.setDeleteflag(0);
				wfms_action_names.setActionName(listData.getAction());
				wfms_action_names=WFMS_action_namesLocalServiceUtil.addWFMS_action_names(wfms_action_names);
				System.out.println("wfms_action_id>>>"+wfms_action_names.getActionId());
	   }
	}
	
	List<WFMS_action_names> wfms_action_names1=WFMS_action_namesLocalServiceUtil.getWFMS_action_nameses(0, WFMS_action_namesLocalServiceUtil.getWFMS_action_namesesCount());
		for(WFMS_action_names listData:wfms_action_names1){
	    	
	    	String actionId=listData.getActionId();
	    	String actionName=listData.getActionName();
	    	
	    	 DynamicQuery dynamicQueryForAction = WFMS_action_and_reasoncodeLocalServiceUtil.dynamicQuery();
			 dynamicQueryForAction.add(PropertyFactoryUtil.forName("action").eq(actionName));
			 List<WFMS_action_and_reasoncode> wfms_action_and_reasoncodes2=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQueryForAction); 
			 
			 for(WFMS_action_and_reasoncode reasonCodelist:wfms_action_and_reasoncodes2){		
						    WFMS_action_and_reasoncode wfms_action_and_reasoncode3 = WFMS_action_and_reasoncodeLocalServiceUtil.fetchWFMS_action_and_reasoncode(reasonCodelist.getAarId());
						    wfms_action_and_reasoncode3.setAction(actionId);
						    WFMS_action_and_reasoncodeLocalServiceUtil.updateWFMS_action_and_reasoncode(wfms_action_and_reasoncode3);
	
				}
				 
			 
			      DynamicQuery dynamicQueryForReason = WFMS_routing_and_approversLocalServiceUtil.dynamicQuery();
				 dynamicQueryForReason.add(PropertyFactoryUtil.forName("action").eq(actionName));
	             List<WFMS_routing_and_approvers> wfms_routing_and_approvers2=WFMS_routing_and_approversLocalServiceUtil.dynamicQuery(dynamicQueryForReason); 
			 
			    for(WFMS_routing_and_approvers reasonCodelist:wfms_routing_and_approvers2){		
				 WFMS_routing_and_approvers wfms_routing_and_approvers3 = WFMS_routing_and_approversLocalServiceUtil.fetchWFMS_routing_and_approvers(reasonCodelist.getPrimaryKey());
				 wfms_routing_and_approvers3.setAction(actionId);
				 WFMS_routing_and_approversLocalServiceUtil.updateWFMS_routing_and_approvers(wfms_routing_and_approvers3);
				}
	    }
	}
%>

<%-- <div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Configuration</h4>
	</div>
	
	<div class="portlet-layout row" id="openid">
		<div class="col-sm-12 own-wrapper" style="margin-bottom: 8px;">
			<div class="wfm-system">
					<div class="small" id="openid" name="openid">
									
					<div class="portlet-layout row">
					<div class="portlet-column">

					<button class="btn btn-primary" onclick="getUrl('<%=newConfigurationURL%>')">Create New Configuration</button>
					<button class="btn btn-primary" onclick="getUrl('<%=importViewURL%>')">Import Position Data</button>
					<button class="btn btn-primary" onclick="getUrl('<%=routingapproversURL%>')">Routing and Approvers</button>
					<button class="btn btn-primary" onclick="getUrl('<%=actionandreasoncodeURL%>')">Action and Reasoncode</button>
					<button class="btn btn-primary" onclick="getUrl('<%=routingapproversURL%>')">NA Support Table</button>
					<button class="btn btn-secondary" onclick="getUrl('<%=wmsBasePath%>/dashboard')">Home</button>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> --%>

<div class="col-sm-12" style="margin-bottom: 5px;">
	<div class="row wms-style-1">
	
		<div>
			<h3>Configuration</h3>
		</div>
		
		<div class="portlet-column portlet-column-first col-sm-4 center">
			<div class="wfm-system">
				
				<div>
					<button class="btn btn-primary" onclick="getUrl('<%=newConfigurationURL%>')">Create New Configuration</button>
				</div>
				
				<div>
					<button class="btn btn-primary" onclick="getUrl('<%=importViewURL%>')">Import Position Data</button>
				</div>
			</div>
		</div>
	
		<div class="portlet-column col-sm-4 center">
			<div class="wfm-system">
				
						<div>
							<button class="btn btn-primary" onclick="getUrl('<%=routingapproversURL%>')">Routing and Approvers</button>
						</div>
				
				<button class="btn btn-primary" onclick="getUrl('<%=actionandreasoncodeURL%>')">Action and Reasoncode</button>
			</div>
		</div>
	
		<div class="portlet-column portlet-column-last col-sm-4 center">
			<div class="wfm-system">
				<div><button class="btn btn-primary" onclick="getUrl('<%=naSupportViewURL%>')">NA Support Table</button></div>
				
				<div><button class="btn btn-primary" onclick="getUrl('<%=wmsBasePath%>/dashboard')">Home</button></div>
			</div>
		</div>
		
		<div class="portlet-column portlet-column-last col-sm-4 center">
			<div class="wfm-system">
				<div><button class="btn btn-primary" onclick="getUrl('<%=manageworkflowConfigURL.toString()%>')">Workflow Configuration</button></div>
				
			</div>
		</div>
	
		
	</div>
</div>

<%if(configurationList != null){ %>

	<script>
		$(document).ready(function() { 
			$('#recordList').DataTable({
				dom: 'Blfrtip',
		        lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
	            buttons: [
	                      'copy', 'excel', 'pdf', 'print'
	                  ]
			});
		
			$('#recordList tbody').on( 'click', 'tr', function () {
				console.log("Clicked row "+$(this).index());
				location.href=$(this).attr("data-record-url");
			} );
		    
		} );
	</script>
	
	<table id="recordList" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th class="config_grid_key" style="width: 258px;">Configuration Key</th>
                <th class="config_grid_type" style="width: 50px;">Type</th>
                <th>Example Values</th>
            </tr>
        </thead>
       
        <tbody>
        
			<% for(WFMS_Config wmsConfig: configurationList){ %>
				
				<portlet:actionURL name="manageConfiguration" var="manageConfigurationURL">
					<portlet:param name="configId" value="<%=Long.toString(wmsConfig.getConfigId()) %>" />
				</portlet:actionURL>
			
	        	<tr data-record-url="<%= manageConfigurationURL %>" >
	        		<td><%=wmsConfig.getConfigKey()%></td>
	                <td><%=wmsConfig.getContentType()%></td>
	                <td><%=wmsConfig.getContent()%></td>
	            </tr>
            
            <%}%>
        </tbody>
    </table>
   
   <%}%>