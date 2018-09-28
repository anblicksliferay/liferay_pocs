<%@page import="javax.portlet.RenderRequest"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_ConfigLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Config"%>
<%@page import="com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService"%>
<%@page import="com.liferay.portal.kernel.json.JSON"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_associate_skillsLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_associate_skills"%>
<%@page import="java.util.Iterator"%>


<%@ include file="/html/init.jsp" %>
<%@ include file="/html/dataTableIncludes.jspf" %>
<liferay-ui:success key="Your request saved Sucessfully"
	message="your-saved-sucessfully" />

<portlet:actionURL name="associateInformation" var="associateInformationURL"> </portlet:actionURL>

<aui:form action="<%=associateInformationURL.toString() %>" method="post" name="associateInformation">
	<aui:input name="associateId" type="hidden"/>
</aui:form>

<portlet:actionURL name="associateList" var="associateListURL"> </portlet:actionURL>

<aui:form action="<%=associateListURL.toString() %>" method="post" name="associateList">
	<aui:input name="filterType" value="0" type="hidden"/>
</aui:form>

<% 
String filterType ="0";
if(request.getAttribute("filterType")!=null){
   filterType = (String)request.getAttribute("filterType");
}
String associateSkills[] = filterType.split(",");
%>
<aui:script>
var primaryKeyColumn = 0;
var primaryKeyColumnName = "Associate Number";
	var exampleData = <%= HMAAssociateInfoService.getAssociateInformation(renderRequest,filterType) %>;	
	
	var associates;

	$(document).ready(function() {

		function loadDataTable(tableData){
            associates = $('#associateRecords').DataTable({
				dom: 'Blfrtip',
	        	lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
                data: tableData,
	            scrollY: true,
	            scrollY: '50vh',
	            scrollCollapse: true,
                buttons: [
                          'copy', 'excel', 'pdf', 'print'
                      ],
				"initComplete": function(settings, json) {
			        $(".dt-button.buttons-copy").text("Copy to Clipboard");
				},
                /*columnDefs: [
			            {
			                title: "Skills",
			                targets:[3],
			                visible: false
			            }
		            ]*/
            	}
            );
        }
		
        loadDataTable(exampleData);

        $('#associateRecords tbody').on( 'click', 'tr', function () {
            $("#<portlet:namespace/>associateId").val($(this).find("td")[primaryKeyColumn].innerHTML);
            console.log($(this).find("td"));
            $("#<portlet:namespace/>associateInformation").submit();
        });

       	$("select.multi-select-filter")	.multiselect({selectedList:1,noneSelectedText:"Choose associate skills"})
       									.multiselect("uncheckAll")
       									.multiselectfilter()
       									.bind("multiselectclick", function(event, ui){
											var filters = $("select.multi-select-filter").multiselect("getChecked");
											var filteredExampleData = [];
											for(i=0;i< exampleData.length;i++){
												pass = true;
												for(ii=0;ii< filters.length;ii++){
													//console.log("testing: "+filters[ii].value);
													//console.log("indexOf: "+exampleData[i][3].indexOf(filters[ii].value));
													if(-1==exampleData[i][3].indexOf(filters[ii].value)){
														pass = false;
														//break;
													}
												}
												//console.log("pass:"+pass);
												if(pass) filteredExampleData.push(exampleData[i]);
											}
											//console.log(filteredExampleData);

										 	associates.clear().rows.add( filteredExampleData ).draw();
										});
       } );

</aui:script>

<div class="portlet-layout row">
	<div class="col-sm-6">
		<h4>Select Associate</h4>
	</div>
	<div class="col-sm-6">
		<div class="btn-manage small">
			<button class="btn btn-default" onclick="getUrl('<%=wmsBasePath%>/dashboard')">Exit View</button>
		</div>
	</div>
</div>
<div class="wfm-system" style="margin-bottom:20px;">
	<div style="font-size: 14px; margin-bottom: 10px;">
		View Associates with All Skills: <input id="mainfiletercheckbox" <% if(filterType.equalsIgnoreCase("0")){ %>checked="checked" <% } %> onclick="displayresult();" style="margin: 0;" type="checkbox" value="all-skills" />
	</div>

	<div id="skill-selection" class="portlet-layout" <% if(filterType.equalsIgnoreCase("0")){ %> style="display:none" <% } %>>
			<% 
			WFMS_Config wfms_config = WFMS_ConfigLocalServiceUtil.getByConfigKey("Associate-Skills");
			JSONObject jObject= JSONFactoryUtil.createJSONObject(wfms_config.getContent());
			Iterator<String> iterator = jObject.keys();
			while(iterator.hasNext() ){
			    String key = (String)iterator.next();
			    JSONObject jObject1=JSONFactoryUtil.createJSONObject(jObject.getString(key));
			    Iterator<String> iterator1 = jObject1.keys();
			    %>
			    <h5><%=key%></h5>
			<%
			    while( iterator1.hasNext() ){
			    	 String key1= (String)iterator1.next();
			    	%>
		        <input  <% if(Arrays.asList(associateSkills).contains(key1)){ %> checked="checked" <% } %> class="field-radio" name="skills" type="checkbox" value="<%=key1 %>" /><label class="skills"><%=jObject1.getString(key1) %></label> 
			  <%  }  } %>
			<div>
				<div style="display:none;" id="skils_required" class="form-validator-stack help-inline">Missing required value for the field "Skills"</div>
		  	<div class="small right-align">
		  		<button class="btn btn-secondary" onclick="filterlist(1)">Search</button>
			</div>
			</div>  	
	</div>
</div>

<table cellspacing="0" class="display" id="associateRecords" width="100%">
	<thead>
		<tr>
			<th style="width:20%;">Associate Number</th>
			<th style="width:20%;">Associate Name</th>
			<th style="width:20%;">Current Position</th>
			<th style="width:40%;">Skills</th>
		</tr>
	</thead>
</table>
<aui:script>
function displayresult(){
$('#skill-selection').toggle();
if($('#mainfiletercheckbox').is(":checked")){
   filterlist(0);
}
}
$('.field-radio').on('change', function() {
var checkboxValues = [];
  $('.field-radio:checkbox:checked').each(function () {
     checkboxValues.push($(this).val());
   });
   if(checkboxValues!=''){
      $("#skils_required").hide();
     $('#skill-selection').removeClass('control-group error');
   }
  $("#<portlet:namespace/>filterType").val(checkboxValues);
});
function filterlist(val){
   $("#skils_required").hide();
   $('#skill-selection').removeClass('control-group error');
     if(val!=0){
	     if($("#<portlet:namespace />filterType").val()!="" && $("#<portlet:namespace />filterType").val()!=0){
	        document.getElementById('<portlet:namespace />associateList').submit();
	     }
	     else{
	         $("#skils_required").show();
	         $('#skill-selection').addClass('control-group error');
	     }
	  }
	  else{
	        $("#<portlet:namespace />filterType").val(val);
	        document.getElementById('<portlet:namespace />associateList').submit();
	    }
   }
 	function redirectRequest() {
		document.getElementById('<portlet:namespace />newChangeOfStatus').submit();
	}


</aui:script>

