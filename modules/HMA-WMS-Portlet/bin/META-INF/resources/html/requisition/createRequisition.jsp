<%@page import="com.ys.hmawfm.wfms.services.model.WFMS_Requisition"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.ys.hmawfm.wfms.utils.ConfigUtility"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@page import="java.util.TreeMap"%>
<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="createRequisition" var="createRequisitionURL"></portlet:actionURL>

<%-- <liferay-ui:success key="Your request completed sucessfully" message="your-saved-sucessfully"/> --%>

<% 


//if(currentURL.contains("?")) currentURL = currentURL.split("\\?")[0];

	String positionId = (String) request.getAttribute("posid");
	
	String reqcid = (String) request.getAttribute("reqcid");
	
	String[] values = null;
	if(positionId!=null){
		WFMS_Position frompos = WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
		List<WFMS_Requisition> findreq = WFMS_RequisitionLocalServiceUtil.findBypositionnumber(positionId);
		
			WFMS_Requisition fromreq = WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(reqcid);
			
%>


	<div class="portlet-layout row">
		<div class="col-sm-12">
			<h2 class="titleArea">Create Requisition</h2>
		</div>
	</div>
	
	<aui:form action="<%= createRequisitionURL.toString()%>" method="post"
		name="createRequisition" id="createRequisition">
		<aui:input type="hidden" name="positionId" value="<%=positionId %>"/>
		<aui:input type="hidden" name="reqcid" value="<%=reqcid %>" />
	
		<div class="portlet-layout row">
			<div class="col-sm-12">
				<div class="wfm-system">
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-6">
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5">
									<span class="sectionLabel">Requisition Number</span>
								</div>
		
							<div class="portlet-column portlet-column-last col-sm-7"><%=reqcid %></div>
						</div>
		
						<div class="portlet-layout row">
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Position Number</span>
							</div>
							<div class="portlet-column portlet-column-last col-sm-7"><%=frompos.getPId() %></div>
						</div>
					</div>
		
					<div class="portlet-column portlet-column-first col-sm-6">
						
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel">Filled with Associate Number</span>
							</div>
		                    <div style="display:none;">
							
							 <aui:input type="text" class="field error-field" id="hidden_field" name="hidden_field"  required="true"></aui:input>
							</div>
							<div class="portlet-column portlet-column-last col-sm-7"> 
                                 <select  class=" chosenAssociate " name="<portlet:namespace/>associatenumber" disabled id="associatenumber" label="" disabled onChange="associateNameChange();">
								 <option  value="">Select Filled with Associate Number</option>
								<%-- <% 
									List<Map<String,String>> associateList = HMAAssociateInfoService.getDistinctAssociateNumber();
									for (Map<String,String> associate: associateList) {  
										String ASSOCIATE_NUMBER = associate.get("ASSOCIATE_NUMBER");
										String ASSOCIATE_NAME = associate.get("ASSOCIATE_NAME");
									%>
									  <option  value="<%=ASSOCIATE_NUMBER %>"><%=ASSOCIATE_NUMBER %> </option>
								<% } %> --%>
									<%
								
							    StringBuilder sb = new StringBuilder();
								List<WFMS_Position> wfms_PositionList = WFMS_PositionLocalServiceUtil.getAll();
							            String delim="";
									   for(WFMS_Position i:wfms_PositionList){
										   if(!(i.getAssociateNumber().equalsIgnoreCase("")) && !(i.getAssociateNumber().equalsIgnoreCase("None"))){
											   
											   sb.append(delim).append("'" + i.getAssociateNumber() + "'");
											     delim = ",";
										 
										   }
									 
								 }
							 List<String> listofass =	HMAAssociateInfoService.getassNumberForAddAssociate(sb.toString());
							 for(String AssID:listofass)
							 {%>
								 
								 <option  value="<%=AssID %>"><%=AssID %> </option>
							<%} %> 
								  <option  value="None">None</option>
								</select>
								 <div id="errormesg" class="form-required"></div>
							</div>
						
							<div class="portlet-column portlet-column-first col-sm-5">
								<span class="sectionLabel" >Name of Person Filling if no ID</span>
							</div>
									
		<div class="portlet-column portlet-column-last col-sm-5  " id="assName" name="associateName" class=" personid" style="width:205px;margin-left:45px;"   >
						
							</div>
<div  id="assName" name="associateName" style="position: relative; top: -34px;"> <img  src="<%= request.getContextPath()%>/images/ajax-loader.jpg"  id="img" alt="Please Wait A Movement"  style="display:none"/ ></div>
		
	                    <div class="portlet-column portlet-column-last col-sm-5  " id="associatenameNotreqid" name="associatenameNotreqid" class=" personid"  >
      
                          <aui:input type="none"  value="" onkeyup="validateEmptyField()" name="associatename" class=" personid" id="associateName"   label=""/>
                         <div><span style="color:#b50303;" id="associateSpan"></span></div>
                         </div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="portlet-layout row">
				<div class="col-sm-12 own-wrapper">
					<div class="wfm-system">
						<div class="portlet-layout">
							<div class="portlet-column portlet-column-first">
								<div class="small center">
								<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_SBMT_REQ,frompos.getDepartmentNumber())){ %>
								   <div class="col-sm-3">
									<aui:button class="btn btn-secondary" type="submit" name="saveRequisition" onclick="validateText();requisitionformsubmit('save')" value="Save" id="saveRequisition"></aui:button>
								</div> 
								<%}%>
								<aui:input type="hidden" name="buttonclick" id="buttonclick" value="" />
                                <%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_SBMT_REQ ,frompos.getDepartmentNumber())){ %>
									<div class="col-sm-3">
										 <aui:button class="btn btn-secondary" type="submit" name="createRequisitionButton" onClick="validateText();requisitionformsubmit('submit')"
										 value="Submit" id="createRequisitionButton"></aui:button>
									</div>
                               <%} %>
                               <%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_EDIT_REQ,frompos.getDepartmentNumber())){ %>
									<div class="col-sm-3">
										<aui:button class="btn btn-secondary" type="submit" name="modifyRequisition" id="modifyRequisition"
										 value="Modify Requisition" disabled="true"></aui:button>
								    </div>
                              <%}%>
<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest,PortletPropsPermission.REQ_CNCL_REQ,frompos.getDepartmentNumber())){ %>
							
									<div class="col-sm-3">
									<aui:button class="btn btn-secondary" type="submit" value="Cancel Requisition" id="cancel" data-toggle="modal" data-target="#myModal"></aui:button>
									</div>
<%}%>
									<div class="col-sm-3">
									<portlet:renderURL var="Exit">
										<portlet:param name="jspPage" value="/html/wfmDashboard/wfmDashboardView.jsp" />
									</portlet:renderURL>
									
									
										
									<button type="button" class="btn btn-secondary" onclick="exitviewUrl('<%=wmsBasePath%>/dashboard')">Exit View</button>
									</div>
									<%-- <div class="col-sm-3">
										<aui:button class="btn btn-secondary" type="button" value="Approve"></aui:button>
									</div>
									
									<div class="col-sm-3">
										<aui:button class="btn btn-secondary" type="button" value="Disapprove"></aui:button>
									</div> --%>
									<%if(WMSUserAccessUtil.checkPermissionForRequisition(renderRequest, PortletPropsPermission.REQ_CRT_REQ,frompos.getDepartmentNumber())){ %>
									<div class="col-sm-3">
										<aui:button class="btn btn-secondary" type="button" name="addRequisition" 
										 id="addRequisition" value="Add Data" onClick="addDataFunction()"></aui:button>
									
									</div>
								  <%}%>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		<div class="portlet-layout row">
			<div class="col-sm-12">
				<div class="wfm-system" style="margin-top:20px;">
					<div class="portlet-layout row">
						<div class="portlet-column col-sm-6">
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Line</div>
		
								<div class="portlet-column portlet-column-last col-sm-7">
									<div class="portlet-column portlet-column-last col-sm-7"><%= frompos.getLine() %></div>
								</div>
							</div>
<script>
function exitviewUrl(url) {
	window.location.href = url;
}

	function teamNumbervalidate(){
		var val=document.getElementById("<portlet:namespace />teamNumber").value;
		if(val==''){
			text = "Missing required value for the field &quot;Team Number &quot;";
	        document.getElementById("teamNumbererrormesg").innerHTML = text;
		}
		else{
			 document.getElementById("teamNumbererrormesg").innerHTML = '';
		}
		document.getElementById("<portlet:namespace />teamNumber").focus();
	}
	function postingTypevalidate(){
		var val=document.getElementById("<portlet:namespace />postingType").value;
		if(val==''){
			text = "Missing required value for the field &quot;Posting Type &quot;";
	        document.getElementById("postingTypeerrormesg").innerHTML = text;
		}
		else{
			 document.getElementById("postingTypeerrormesg").innerHTML = '';
		}
		document.getElementById("<portlet:namespace />postingType").focus();
	}
	
	function associatetypevalidate(){
		var val=document.getElementById("<portlet:namespace />associatetype").value;
		if(val==''){
			text = "Missing required value for the field &quot;Associate Type &quot;";
	        document.getElementById("associatetypeerrormesg").innerHTML = text;
		}
		else{
			 document.getElementById("associatetypeerrormesg").innerHTML = '';
		}
		document.getElementById("<portlet:namespace />associatetype").focus();
	}
	function shiftAssignvalidate(){
		var val=document.getElementById("<portlet:namespace />shiftassignment").value;
		if(val==''){
			text = "Missing required value for the field &quot;Shift Assignment &quot;";
	        document.getElementById("shiftassignmenterrormesg").innerHTML = text;
		}
		else{
			 document.getElementById("shiftassignmenterrormesg").innerHTML = '';
		}
		document.getElementById("<portlet:namespace />shiftassignment").focus();
	}
	
	function howAvailablevalidate(){
		
		var val=document.getElementById("<portlet:namespace />howAvailable").value;
		//alert(val);
		if(val==''){
			text = "Missing required value for the field &quot;How did this Position become available? &quot;";
	        document.getElementById("howAvailableerrormesg").innerHTML = text;
		}
		else{
			 document.getElementById("howAvailableerrormesg").innerHTML = '';
		}
		document.getElementById("<portlet:namespace />howAvailable").focus();
	}


</script>
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Posting Type</div>
		
								<div class="portlet-column portlet-column-last col-sm-7">
									<aui:select name="postingType" id="postingType" class="field-select" onchange="postingTypevalidate();" placeholder=""  label="" disabled="true" >
									<aui:option value="">Select Posting Type</aui:option>
									<% values = ConfigUtility.getInputValuesFromConfig("requisation-type");
									   Arrays.sort(values);	
									for (String value : values) {
									%>
									<aui:option value="<%=value%>"><%=value%></aui:option>
									<%
										}
									%>
									</aui:select>
									<div id="postingTypeerrormesg" class="form-required"></div>
								</div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Team Number</div>
		
								<div class="portlet-column portlet-column-last col-sm-7">
									  <aui:select name="teamNumber" id="teamNumber" cssClass="field-select chosenTeam" onchange="teamNumbervalidate();"  placeholder="" label="" disabled="true">
					         <aui:option value="">Select Team Number</aui:option>
					         
					          <%
					                   values = ConfigUtility.getInputValuesFromConfig("Team-Number");
					                   Arrays.sort(values);
					                  for(String value:values){ 
					                  %>
					                   <aui:option value="<%=value %>"><%=value %></aui:option>
					                  <% } %>
					         </aui:select>
					         <div id="teamNumbererrormesg" class="form-required"></div>
								</div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Ladder</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"> <%=frompos.getLadder() %> </div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Associate Type</div>
		
								<div class="portlet-column portlet-column-last col-sm-7">
									<div class="portlet-column portlet-column-last col-sm-7">
					         <aui:select name="associatetype" id="associatetype" class="field-select" onchange="associatetypevalidate();" placeholder="" label="" disabled="true">
					         <aui:option value="">Select Associate Type</aui:option>
					           <%
					                   values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
					                  Arrays.sort(values); 
					                  for(String value:values){ 
					                  %>
					                   <aui:option value="<%=value %>"><%=value %></aui:option>
					                  <% } %>
					         </aui:select>
					         <div id="associatetypeerrormesg" class="form-required"></div>
					        </div>
								</div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Shift Assignment</div>
		
								<div class="portlet-column portlet-column-last col-sm-7">
									  <aui:select name="shiftAssign" id="shiftassignment" cssClass="field-select chosenShiftassignment" onchange="shiftAssignvalidate();" placeholder="" label="" disabled="true">
									         <aui:option value="">Select Shift Assignment</aui:option>
									           <%
          
                                       Map<String,String> shiftMap = new HashMap<String,String>();
                                       shiftMap=ConfigUtility.getInputValuesForMap("shift-assignment");
                                       Map<String,String> shiftMaps = new TreeMap<String,String>(shiftMap);
                                        for(Map.Entry<String, String> entry : shiftMaps.entrySet()){
               
                                                 %>
                                        <aui:option value="<%=entry.getKey() %>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
                                           <% } %>
									         </aui:select> 
									         <div id="shiftassignmenterrormesg" class="form-required"></div>
								</div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Who will this person report to?</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"> <%=frompos.getReportsTo() %> </div>
							</div>
		
							<div class="portlet-layout row">
							<div style="display:none;">
							
							 <aui:input type="text" class="field error-field" id="hidden_field_replacement" name="hidden_field_replacement" value="" ></aui:input>
							</div>
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">How did this Position become available?</div>
		
								<div class="portlet-column portlet-column-last col-sm-7">
									<aui:select name="howAvailable" id="howAvailable" class="field-select" placeholder="" label="" onchange="howAvailablevalidate()" disabled="true">
							          <aui:option value="">Select How did this Position become available?</aui:option>
							           <%
							                   values = ConfigUtility.getInputValuesFromConfig("position-availableposition");
							                Arrays.sort(values);   
							                for(String value:values){ 
							                  %>
							                   <aui:option value="<%=value %>"><%=value %></aui:option>
							                  <% } %>
							         </aui:select>
							         <div id="howAvailableerrormesg" class="form-required"></div>
								</div>
							</div>
						</div>
		
						<div class="portlet-column col-sm-6">
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Status</div>
								<div class="portlet-column portlet-column-last col-sm-7"><%=fromreq.getStatus() %> </div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Creator</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"><%=frompos.getCreatedBy() %> </div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date Created</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"> <%= HondaLogicUtil.getDateFormat(fromreq.getCreateDate()) %> </div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date Approved</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"> </div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Name</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"><%=frompos.getDepartmentName() %></div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Number</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"><%=frompos.getDepartmentNumber() %></div>
								<aui:input type="hidden"  name="Deptid" label="" id="Deptid" value="<%=frompos.getDepartmentNumber() %>"/>
								
										 
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Department Manager</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"><%=frompos.getDepartmentManager()%></div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"><%=frompos.getDivision() %></div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Division Manager</div>
		
								<div class="portlet-column portlet-column-last col-sm-7"><%=frompos.getDivisionManager() %></div>
							</div>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column col-sm-12">
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">If replacement, replacement of whom?</div>
							
								
							<div class="portlet-column portlet-column-last col-sm-7" >
							<input type="textarea" name="<portlet:namespace/>whoReplaced" label="" id="<portlet:namespace/>whoReplaced" cols="55" rows="1" maxlength="75" disabled="true" />
							
							
							<span style="" id="error" > </span>
							</div>

							</div>
						</div>
					</div>
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Date Manpower needed?</div>
		
								<div class="portlet-column portlet-column-last col-sm-7">
									<script type="text/javascript">
										function datevalidation(x){
								              if(x==''){
								            	  
												$("#error123").html("Missing required value for the field &quot;Date Manpower Needed? &quot;.");
												document.getElementById('<portlet:namespace/>hidden_field1').value=''; 
												} 
											   else {
												   $("#error123").html(""); 
												   document.getElementById('<portlet:namespace/>hidden_field1').value='1'; 
											   }
								             // alert(document.getElementById('<portlet:namespace/>hidden_field1').value);
										}
										
										
										</script>	
									<div id="#<portlet:namespace />startDatePicker">
												<aui:input name="dateneeded" label="" id="startDate"
												maxlength="70" title="Click Here" readOnly="true"
												placeholder="MM/DD/YYYY"
												style="cursor:pointer;background-color: white"
												errorMessageDivId="startDateErrorDiv"
												onFocus="clearErrorMessage('startDateErrorDiv');"
												onClick="clearErrorMessage('startDateErrorDiv');">
												</aui:input>
												 <div class="form-validator-stack help-inline">
			 									<div class="required" class="field error-field"  style="color:#b50303;" id="error123" > </div>
			 							 </div>
			 							 <div style="display: none;">
								     <aui:input type="textarea" name="hidden_field1" label="" required="true"> </aui:input>
								    </div>
									</div>										
								</div>	
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Contact Person for Interviews</div>
		
													<div class="portlet-column portlet-column-last col-sm-7">
					         <aui:input type="textarea" name="contactperson" id="contactperson" label="" class="field" cols="55" placeholder="" rows="1"  maxLength='75' disabled="true">
					         <aui:validator  name="custom"  errorMessage="Missing required value for the field &quot;Contact Person for Interviews &quot;" >
								function (val, fieldNode, ruleValue) {
								var result = false;
								 
								if (val != "") {
								result = true;
								}
								return result;
								}
								</aui:validator>
					         </aui:input>
					        </div>
							</div>
		
							<div class="portlet-layout row">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Contact Phone Number</div>
		
													<div class="portlet-column portlet-column-last col-sm-7">
						         <aui:input type="textarea" name="contactphonenumber" id="contactphonenumber" label="" class="field" cols="55"  rows="1"  maxLength='75' disabled="true">
						               <aui:validator  name="custom"  errorMessage="Missing required value for the field &quot;Contact Phone Number &quot;" >
								function (val, fieldNode, ruleValue) {
								var result = false;
								 
								if (val != "") {
								result = true;
								}
								return result;
								}
								</aui:validator>
						              </aui:input>
						        </div>
							</div>
		
							<div class="portlet-layout row" style="margin-top:30px">
								<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Taleo Number</div>
		
							<div class="portlet-column portlet-column-last col-sm-7">
        						 <aui:input type="textarea" name="taleonumber" id="taleonumber" class="field" label="" cols="55"  rows="1"  maxLength='75' disabled="true">
              						<aui:validator  name="custom"  errorMessage="Missing required value for the field &quot;Taleo Number &quot;" >
								function (val, fieldNode, ruleValue) {
								var result = false;
								 
								if (val != "") {
								result = true;
								}
								return result;
								}
								</aui:validator> 
              		 </aui:input>
       						 </div>
							</div>
						</div>
					</div>
				</div>
		<div class="wfm-system">
					<h3 class="subsection">Requisition Information</h3>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Typical Job Title</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="1"><%=frompos.getTypicalJobTitle() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Minimum Job Relevant Knowledge (Know how)</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="10"><%=frompos.getMinJobKnowHow() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Prioritized duties and Responsibilities</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="10"><%=frompos.getDuties() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Daily Tasks Performed</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="10"><%=frompos.getTasksPerformed() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Minimun Job Relevant Experience (length of service)</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="10"><%=frompos.getLengthOfService() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Degree or certification required</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="3"><%=frompos.getDegree() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Required Skills (Musts)</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="10"><%=frompos.getReqSkills() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Desired Skills and Abilities (Wants)</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="10"><%=frompos.getDesiredSkills() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Environment Associate will work in</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="1"><%=frompos.getEnvironment() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Estimates Weekly Overtime</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="1"><%=frompos.getWeeklyOvertime() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Frequency and Duration of Travel</div>
		
						<div class="portlet-column portlet-column-last col-sm-7">
							<textarea class="field" cols="55" disabled="disabled" placeholder="" rows="1"><%=frompos.getFrequencyOfTravel() %></textarea>
						</div>
					</div>
		
					<div class="portlet-layout row">
									<div class="portlet-column portlet-column-first col-sm-5 sectionLabel ">Other</div>
					<div class="portlet-column portlet-column-last col-sm-7">
			       <aui:input type="textarea" name="other" label=""
			        class="field" cols="55" placeholder="" rows="10" maxlength="255">
			        	
			        
			        </aui:input> 
			      </div>
					</div>
					<div class="scroll_back_to_top">
						<a href="#" id="back-to-top" title="Back to top">&uarr;</a>	
					</div>	
					
				</div>
				</div>
		
		</aui:form>
	<%
	
}
%>
<portlet:actionURL name="cancelRequisition"
	var="cancelRequisitionURL">
</portlet:actionURL>
<div class="container">
  <div class="modal fade" id="myModal" role="dialog" style="display:none;">
    <div class="modal-dialog">
    <aui:form method="post" action="<%=cancelRequisitionURL.toString() %>"
	name="cancelRequisition" id="cancelRequisition">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Want to cancel Requisition</h4>
        </div>
        <div class="modal-body">
        <aui:input type="hidden" name="reqid" value="<%=reqcid %>" />
          <aui:input type="textarea" name="Comments" label=""
			value="" class="field" cols="5"
			placeholder="Comments" rows="3" required="true"
			 />
        </div>
        <div class="modal-footer">
        <div class="col-sm-2">
          <aui:button type="submit" class="btn btn-default" value="Save"></aui:button>
        </div>
        <div class="col-sm-2">
        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </div>
      </div>
 	</aui:form>
    </div>
  </div>
  
</div>
<div class="portlet-layout row">
                <div class="logs_main" style="font-style: oblique; font-size:12px"><b>Log:</b></div>					
                <div class="users col-sm-12">
                	<div class="logs_comments" style="line-height: 9px;">
			                <%List<WFMS_Requisition_Audit> wfms_auditlist=WFMS_Requisition_AuditLocalServiceUtil.findByReqIdForAudit(reqcid); %>
			                <%for(WFMS_Requisition_Audit wfms_audit :wfms_auditlist){%>
			                	
			               <div class="logs">
				               <div class="user_comments" id="user_comments">
				               		<br> <%=wfms_audit.getChange() %>  <%=wfms_audit.getCreatedBy()%>-<%=wfms_audit.getCreateDate()%> <br/>
				               </div>
			               </div>
			               <%
			               }
			                %>
			                   <%-- <aui:input type="textarea" name="comments" class="field" cols="55" value="<%=wfmsCOS.getUserComments() %>"
									placeholder="comments" rows="10" label="" style="width: 93%;" maxLength="500"></aui:input> --%>
			    	</div>
	           </div>
        </div>
<div class="scroll_back_to_top">
		<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
		</div>	
	
<%-- <aui:script use="node">
AUI().use('aui-base', function(A){
	A.one("#<portlet:namespace/>associatenumber").on('change',function(){
		//alert("asdfdf")
		var associatenumber=A.one("#<portlet:namespace/>associatenumber").get("value");
		//alert(associatenumber);
		if(emailAddress=='none'){
		//	alert(associatenumber);
			A.one('div.associatenameNotreqid').set("innerHTML","<div><aui:input tpye='text'  /></div>");
		}
		
});
})
</aui:script> --%>
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

</script>

	<aui:script>
	YUI({ lang: 'en' }).use(
			   'aui-datepicker-deprecated',
			   function(Y) {
				   var today=new Date();
			     var datepicker = new Y.DatePicker(
			       {
			          trigger: '#<portlet:namespace />startDate',
			         mask: '%m/%d/%Y',
			         calendar: {
			         	
			        	   minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * 24 * 60))
			        	  //maximumDate:  new Date(today.getTime() + (1000 * 60 * 60 * 120)),

			        	},
			        	on: {
			                selectionChange: function(event) {

			                	//$("#<portlet:namespace />startDate").siblings('.form-validator-stack').remove();
			                //	$("#error").innerHTML("");
			                	  $("#error123").html("");
			                	  document.getElementById('<portlet:namespace/>hidden_field1').value='1'; 
			              }
			            },
			         popover: {
			           toolbars: {
			             header: [[
			               {
			                 icon:'icon-trash',
			                 label: 'Clear',
			                 on: {
			                   click: function() {
			                     datepicker.clearSelection();
			                     
			                     var A=new AUI();
									var checkBoxValue= A.one("input[name=<portlet:namespace/>positionClass]:checked").get("value"); 
									if(checkBoxValue=="Temporary"){
			                     document.getElementById('<portlet:namespace/>hidden_field1').value=''; 
			                     $("#error123").html("Missing required value for the field Position Re-evaluation date.");
									}
									else{
										 document.getElementById('<portlet:namespace/>hidden_field1').value='1'; 
					                     $("#error123").html("");
									}
			                   }
			                 }
			               },             
			             ]]
			           },
			           zIndex: 1
			         }
			       }
			     );
			   }
			 );
	 </aui:script>
	 
	 <portlet:renderURL var="showjspURL">
	 	<portlet:param name="jspPage" value="/html/position/managePosition.jsp" />
	 </portlet:renderURL>
		
	<!-- show the modal div while click save button id by Chandramouli -->
		 
	<div id="autoGenModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin: 50px 81px 27px -246px !important;">
	    
	    <aui:form  name="emailForm" style="margin-bottom: 0px;">
	    
	        <div class="modal-header">
	             <a href="<%= showjspURL %>">x</a>
	            <h3 id="myModalLabel">The Current Position has an Open Requisition. So you wouldn't be able to add another requisition to this position.</h3>
	        </div>
	        <div class="modal-body">
	            <input class="form-control" name="email" type="hidden" required  />
	        </div>
	        <div class="modal-footer">
				<aui:button class="btn btn-primary" type="cancel" value="Close"
				onClick="<%= showjspURL.toString() %>" /> 
			</div>
	
	    </aui:form>
	</div> 
	
	<!-- show the modal div while click save button id by Chandramouli -->
	 
	
<%-- <%
	List<WFMS_Requisition> findreq = WFMS_RequisitionLocalServiceUtil.findBypositionnumber(positionId);
	if(findreq.size()!=0){%>
	
	<script>
		$(document).ready(function() {
			
			getAuiGenerateReqPopup();
		});
		
	</script> 
	
<%}%> --%>

<script type="text/javascript" >
function getAuiGenerateReqPopup() {

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
				popUpWindow.titleNode.html("The Current Position has an Open Requisition in Manage Requisition table. So you wouldn't be able to add another requisition to this position - Thank you");
			
				popUpWindow.io.start();
 	});
}

window.onload= function(){
    $('#associatenameNotreqid').hide();
 //  $('#associatenameNotreqid').show();
}
function validateEmptyField(){
	var val=document.getElementById("<portlet:namespace/>associateName").value;
	
	if(val=='')
		document.getElementById("associateSpan").innerHTML="This field is required";
	else
		document.getElementById("associateSpan").innerHTML="";

    return true;
}


/* function requisitionsubmit(value){
	var hidden_field_replacement = $("#<portlet:namespace/>hidden_field_replacement").value;

	if( hidden_field_replacement!="")
	$("#<portlet:namespace/>selectedButton").val(value);
	$("#<portlet:namespace/>createRequisition").submit();
} */

	
function validateText()
{
//alert("validateText");	
datevalidation($("#<portlet:namespace/>startDate").val());
var a=document.getElementById("associatenumber");
var b=document.getElementById("<portlet:namespace/>associateName")?document.getElementById("<portlet:namespace/>associateName"):document.getElementById("assName");
 //alert(a.value);
  
//var x, text;
document.getElementById("<portlet:namespace/>hidden_field").value = '';

    if (a.value=='None' && b.value=="") {
   //  alert("if");
      a.focus();
      b.focus();
      document.getElementById("errormesg").innerHTML = "";
      document.getElementById("associateSpan").innerHTML="Missing required value for the field &quot;Name of Person Filling if no ID &quot;.";
      //return false;
    }
    else if(a.value==''){
    	//alert("else-if");
        
		 document.getElementById("errormesg").innerHTML =  "Missing required value for the field filled with &quot;Associate Number &quot;.";
        //return false;
	}
    else 
	{
    	
    	document.getElementById("<portlet:namespace/>hidden_field").value = 1;
    	document.getElementById("errormesg").innerHTML = "";
		document.getElementById("associateSpan").innerHTML="";
    }	
    var a=document.getElementById("<portlet:namespace/>howAvailable").value;
    if(a=='New Position'){
    //alert(a);
    $('#<portlet:namespace/>whoReplaced').prop('required',true);
    var message = document.getElementById('error');
            message.style.color = "#b50303";
            message.innerHTML = "Missing required value for the field &quot; If replacement, replacement of whom?&quot;.";
    }
    else{
    //alert(a);
    /* $('#whoReplaced').prop('required',true);
    document.getElementById('error').style.display = "none"; */
    $('#<portlet:namespace/>whoReplaced').removeAttr('required');
    var message = document.getElementById('error');
        message.style.color = "#b50303";
        message.innerHTML = "";

    }
   // alert("end");
   // return true;
  }
  
function associateNameChange(){
	//alert($('<portlet:namespace/>associatenameNotreqid').val());
console.log("associateNameChange")
	
if($("#associatenumber").val()=='None'){
	console.log("show sencod div")
$('#associatenameNotreqid').show();
	$('#assName').hide();
	

}
else if($("#associatenumber").val()=='' ){
	var a=document.getElementById("associatenumber");
	//alert(a.value);
	   //alert("nothing selected");
	 console.log("show sencod div")
	 //alert(#<portlet:namespace/>associatenumber);
	 $('#associatenameNotreqid').hide();
	  $('#assName').hide();
	  

	 } 
 else {
	 //var a=document.getElementById("associatenumber");
		//alert(a.value);
	 console.log("show fist div",$("#<portlet:namespace/>associatenumber").val())
	//alert($('#_WFMPosition_WAR_HMAWorkforceManagementSystemportlet_associatenumber').val())
   
    $('#associatenameNotreqid').hide();
    
    var deptId=$("#associatenumber").val();
	 console.log(": empCategory "+deptId)
	 $('#img').show();
	    $.ajax({  
   		url : '<%=resourceURL.toString()%>',
			data : {<portlet:namespace />cmd : 'getAssName',
				<portlet:namespace />cmdType : deptId
				
				
			},

			type : "POST",
			dataType : "json",
			success : function(data) {
			
				console.log(data);
				$('#assName').html(data.AssName);
				 $('#assName').show();
			//	$('#DEPT_NAME').html(data.DEPT_NAME);
			$('#img').hide();
			},
			error : function(response) {
	        	console.log("Error seen for for loadDivisonDepName");
				$('#img').hide();
			}
		});
    
}
} 



jQuery(document).ready(function(){
jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
}

);

</script>
<script>

function requisitionformsubmit(value){
	
	//validateText();

	var postingType=document.getElementById("<portlet:namespace />postingType");
	var teamNumber=document.getElementById("<portlet:namespace />teamNumber");
	var associateType=document.getElementById("<portlet:namespace />associatetype");
	var shiftAssignment=document.getElementById("<portlet:namespace />shiftassignment");
	var howAvilable=document.getElementById("<portlet:namespace />howAvailable");
	var associatenumber=document.getElementById("<portlet:namespace />associatenumber");
	var assName=document.getElementById("<portlet:namespace />assName");

	$("#<portlet:namespace/>buttonclick").val(value);    
			
			//console.log(auiValidator.hasErrors());
			
			if( postingType.value!='' && teamNumber.value!='' && associateType.value!='' && shiftAssignment.value!='' && howAvilable.value!='' && associatenumber.value!='' && assName.value!='' ){
				 document.getElementById('<portlet:namespace/>hidden_field').value='1'; 
	      }
		  else{
			     howAvailablevalidate();
				 associatetypevalidate();
				 postingTypevalidate();
				 teamNumbervalidate();
				 shiftAssignvalidate();
				 
				 document.getElementById('<portlet:namespace/>hidden_field').value=''; 
				
				
			 }
			 var auiForm = Liferay.Form._INSTANCES.<portlet:namespace/>createRequisition;
				var auiValidator = auiForm.formValidator;
			auiValidator.validate();
			
			 if (!auiValidator.hasErrors()) {
					$("#<portlet:namespace/>createRequisition").submit();
				}
	
}
</script>

<script>
function selectbuttonclick(value){
	console.log(value);
	$("#<portlet:namespace/>buttonclick").val(value);
	$("#<portlet:namespace/>createRequisition").submit();
}
</script>


<aui:script>
function addDataFunction() {
	

	document.getElementById("associatenumber").disabled = false;
	$(".chosenAssociate").data("placeholder","Select Frameworks...").chosen({search_contains:true});
	
    document.getElementById("<portlet:namespace/>postingType").disabled = false;
    document.getElementById("<portlet:namespace/>teamNumber").disabled = false;
    $(".chosenTeam").data("placeholder","Select Frameworks...").chosen({search_contains:true});
   
    document.getElementById("<portlet:namespace/>associatetype").disabled = false;
    document.getElementById("<portlet:namespace/>shiftassignment").disabled = false;
    $(".chosenShiftassignment").data("placeholder","Select Frameworks...").chosen({search_contains:true});
    
    document.getElementById("<portlet:namespace/>howAvailable").disabled = false;
    document.getElementById("<portlet:namespace/>whoReplaced").disabled = false;
    document.getElementById("<portlet:namespace/>startDate").disabled = false;
    document.getElementById("<portlet:namespace/>contactperson").disabled = false;
    document.getElementById("<portlet:namespace/>contactphonenumber").disabled = false;
    document.getElementById("<portlet:namespace/>taleonumber").disabled = false;
    document.getElementById("<portlet:namespace/>other").disabled = false;
    document.getElementById("<portlet:namespace/>saveRequisition").disabled = false;
    document.getElementById("<portlet:namespace/>createRequisitionButton").disabled = false;
    $("#<portlet:namespace/>createRequisitionButton").removeClass("disabled");
    $("#<portlet:namespace/>saveRequisition").removeClass("disabled"); 
    $("#<portlet:namespace/>modifyRequisition").removeClass("disabled");
    
     
}
</aui:script>