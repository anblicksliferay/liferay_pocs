
<!DOCTYPE html> 
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<html class="aui ltr" dir="ltr" lang="en-US"> 
	<head>
		<style>
		table { border-top:1px solid #ccc; border-right1:1px solid #ccc; }
		table td { border-bottom:1px solid #ccc; border-left1:1px solid #ccc; padding:1px;  }
		</style>
	</head>
 	<body class=" yui3-skin-sam controls-hidden signed-in private-page site isAdmin "> 
			
			<table width="100%" align="center" cellpadding="10" class="portlet-layout row">
				<tr>
				<td>
				 <a class="logo default-logo" href="/" title="Honda Manufacturing of Alabama"> 
				 
				 <img alt="Honda Manufacturing of Alabama" src="<%=renderRequest.getContextPath()%>/images/HondaManufacturingofAlabama_logo.png" width="160" /> </a>
				</td>
				</tr>
				</table> 
				<table width="100%" align="center" cellpadding="10" class="row">
				 	<tr>
							<td colspan="4"   style="font-size:18px; ">
							<strong>Position Data</strong>
		
					</td> 
				
		
				</table>
				
				
				<table width="100%" align="center" cellpadding="10">
		 		<tr>
				<td width="25%">  	Position #		</td>
				<td width="25%">
				<%
							String Id = "";
								if (wfmPosition.getPId().contains("-WFM")) {

									Id = wfmPosition.getPId().replace("-WFM", "");

								} else {
									Id = wfmPosition.getPId();
								}
						%>
				 <%=Id%>	</td>
				 </tr>
				 <tr>
				 <td width="25%">  	Status		</td>
				 <%
						if (wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT) && wfmPosition.getPId().contains("-WFM")) {
					%>
					<td><%=HondaPermissionKeys.POS_DRAFT%></td>
					<%
						} else {
					%>
					<td><%=wfmPosition.getStatus().trim()%></td>
					<%
						}
					%>
				</tr>
				<tr >
				<td width="25%"> 	Associate Number		</td>
				<td width="25%"> <div id="ASSOCIATE_NUMBER"><%=wfmPosition.getAssociateNumber()%></div></td>
				</tr>
				<tr>
				<td width="25%"> 	Associate Name		</td>
				<td width="25%"> 	<div id="ASSOCIATE_NAME"><%=wfmPosition.getAssociateName()%></div>			</td>
				</tr>
				<tr>
				<td width="25%"> 	Associate Title	</td>
				<td width="25%"> 	<div id="ASSOCIATE_TITLE"><%=wfmPosition.getAssociateTitle()%></div>	</td>
				</tr>
				<tr>
				<td width="25%"> 	MP Category Filled With	</td>
				<td width="25%"> 	
				<%	values = ConfigUtility.getInputValuesFromConfig("position-mpcategoryfilledwith");
				     Arrays.sort(values);
					for (String value : values) {%>	
				 	<% if(null != wfmPosition.getMpCatFilledWith()
									&& wfmPosition.getMpCatFilledWith().equals(value)){%><%=value%>	
				<%	}}
				%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Division	</td>
				<td width="25%"> 	<div id="Division"><%=wfmPosition.getDivision()%></div>			</td>
				</tr>
				<tr>
				<td width="25%"> 	Department Name	</td>
				<td width="25%"> 	<div id="DEPT_NAME"><%=wfmPosition.getDepartmentName()%></div>		</td>
				</tr>
				<tr>
				<td width="25%"> 	Department Number</td>
				<td width="25%"> 
				<%   
					Map<String, String> departmentNumberMap=null;
					if(HondaPermissionKeys.POS_PENDING.equalsIgnoreCase(wfmPosition.getStatus()) || HondaPermissionKeys.POS_DRAFT.equalsIgnoreCase(wfmPosition.getStatus())){                                   
							departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
					 }else{
						 departmentNumberMap = HondaLogicUtil.getcccodesOnsameDeptNumber(wfmPosition.getDepartmentNumber());
					} 
					for (Map.Entry<String, String> entry : departmentNumberMap.entrySet()) {
						   if(!entry.getValue().equalsIgnoreCase("")){ %>
								<%if(wfmPosition.getDepartmentNumber().equals(entry.getKey())){%>
									<%=entry.getKey()%>-<%=entry.getValue()%>
					<% } } }%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	MP Category Budget	</td>
				<td width="25%">
				<%  values = ConfigUtility.getInputValuesFromConfig("position-mpcategorybudgeted");
					Arrays.sort(values);
					for (String value : values) { %>
						<%if(null != wfmPosition.getMpCatBugdet() && wfmPosition.getMpCatBugdet().equals(value)){%>
						<%=value%>
					<% } }%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Position Class	</td>
				<td width="25%">
				<% String dbvalueclass = wfmPosition.getPositionClass();
					values = ConfigUtility.getInputValuesFromConfig("position-class");
					for (String value : values) { %>
					<div class='col-sm-2 owncheck'>
						<% if (null != value) { %>
							<%if(value.equalsIgnoreCase(dbvalueclass.trim())){ %>
							<%=value%>
						<% } } %>		
					</div>
					<% } %>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Year Established	</td>
				<td width="25%"> 	<%=wfmPosition.getYearEst()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Reason for addition or change	</td>
				<td colspan="3"> 	<%=wfmPosition.getReasonsFor()%>			</td>
				</tr><tr>
				<td width="25%"> 	Position Re-evaluation date	</td>
				<td width="25%"> 
				<div id="startDate_mainDiv">
				<%
					String className=""; 
					if(wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)){
						  className="datepicker";            
					}                              
				%>				
                <%=wfmPosition.getReavailuationDate() %>
			
                </div>			</td>
				</tr>
				
				<div id="secondsetData" class="wfm-system" <% if(wfmPosition.getWorkflowStep() == 0 && WMSUserAccessUtil.checkPermissionForPosition(renderRequest,PortletPropsPermission.POS_RS2,wfmPosition.getDepartmentNumber())){%>style="display:none;"<%} %>	>
				
				<tr>
				<td width="25%"> Auto Generate Requisition?	</td>
				<td width="25%"> 
				<%if(Validator.isNotNull(wfmPosition.getAutoGenerateReq())){
					if(wfmPosition.getAutoGenerateReq().equalsIgnoreCase("true")){
					%>
				<div id="auto">Yes</div>
					<%} else {%>
				
				<div id="auto11">No</div>
				<%}}%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Is this a Critical Work Segment?	</td>
				<td width="25%"> 
				<%if(Validator.isNotNull(wfmPosition.getCritical())){ 	
				if(wfmPosition.getCritical() == true){%>
				<div id="getCritical11">Yes</div>
				<% } else {%>
				
				
				<div id="getCritical">No</div>
				
				<% } }%>
				</td>
				
				</tr>
				<tr>
				<td width="25%"> 	Position Reports to	</td>
				<td width="25%"> 	
				<%  DynamicQuery dynamicQueryForPosition = WFMS_PositionLocalServiceUtil.dynamicQuery();
                          
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
					<% if(wfmPosition.getReportsTo().equals(lispost.getPId())){%>
					<%=lispost.getPId()%>
				<% }  }%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Line	</td>
				<td width="25%"> 	
				<% values = ConfigUtility.getInputValuesFromConfig("position-lines");
                    boolean line_found = false;
                       for (String value : values) {
					if(value.equals(wfmPosition.getLine())){
								line_found = true;
						}else{
								line_found = false;
						}
						 %>
					<% if(line_found){%>
					<%=value%>
				<% } }%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Ladder </td>
				<td width="25%">
				<% values = ConfigUtility.getInputValuesFromConfig("position-ladders-new");
						Arrays.sort(values);
						for (String value : values) {
                    %>
                    
					<%if(null != wfmPosition.getLadder() && wfmPosition.getLadder().equals(value)){ %>
					<%=value%>
                    <%
							}  }
                    %>			</td>
				</tr>
				<tr>
				<td width="25%"> 	Type </td>
				<td width="25%"> 	
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
                        
					<% if(type_found){%>
					<%=value%>
				<% } } %>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Level (Choose all that apply) </td>
				<td width="25%"> 	
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
					
					 <%if(found){ %>
					 <%=value%><br>
				<% }  }%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Leadership Assignment </td>
				<td width="25%"> 
				<% 
				values = ConfigUtility.getInputValuesFromConfig("position-leadershipassignmenmt");
							Arrays.sort(values);
							for (String value : values) { %>
					<%if(null != wfmPosition.getLeadershipAssignment() && wfmPosition.getLeadershipAssignment().equals(value)){ %>
					<%=value%>
							<% }  }%>	
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Category </td>
				<td width="25%"> 	
				<%
					values = ConfigUtility.getInputValuesFromConfig("position-category");
					   Arrays.sort(values);
					   for (String value : values) {
				%>
							<%if(null != wfmPosition.getCategory() && wfmPosition.getCategory().equals(value)){ %>
							<%=value%>
					<%
							}	}
					%>	
				<div id="other" <% if(!wfmPosition.getCategory().equalsIgnoreCase("Other")){ %> style="display: none;"  <% } %>>
           		 <%=wfmPosition.getOther()%>
       			 </div>		
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Subcategory </td>
				<td width="25%"> 	
				<%
				values = ConfigUtility.getInputValuesFromConfig("position-subcategory");
						Arrays.sort(values);
						for (String value : values) {%>
						
				<%if((null != wfmPosition.getSubCategory() && wfmPosition.getSubCategory().equals(value))){ %>
				<%=value%>
				<% }  }%>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Workforce Category </td>
				<td width="25%"> 
				<%
				Map<String, String> shiftMap = new HashMap<String, String>();
					shiftMap = ConfigUtility.getInputValuesForMap("workforce-category");
					Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
					for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {																
				%>
				
					<% if(wfmPosition.getWorkforceCategory().equals(entry.getKey())){%>
					<%=entry.getKey()%>-<%=entry.getValue()%>
				<%
						} }
				%>	
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Position Description </td>
				<td colspan="3"> 	<%=wfmPosition.getDescription()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Typical Job Title </td>
				<td colspan="3"> 	<%=wfmPosition.getTypicalJobTitle()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Minimum Job Relevant Knowledge (Know how) </td>
				<td colspan="3"> 	<%=wfmPosition.getMinJobKnowHow()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Prioritized duties and Responsibilities </td>
				<td colspan="3"> 	<%=wfmPosition.getDuties()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Daily Tasks Performed </td>
				<td colspan="3"> 	<%=wfmPosition.getTasksPerformed()%>	</td>
				</tr>
				<tr>
				<td> 	Minimum Job Relevant Experience (length of service) </td>
				<td colspan="3"> 	<%=wfmPosition.getLengthOfService()%>			</td>
				</tr>
				<tr>
				<td width="25%"> 	Degree or certification required </td>
				<td colspan="3"> 	<%=wfmPosition.getDegree()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Required Skills (Musts) </td>
				<td colspan="3"> 	<%=wfmPosition.getReqSkills()%>		</td>
				</tr>
				<tr>
				<td width="25%"> 	Desired Skills and Abilities (Wants) </td>
				<td width="25%"> 	<%=wfmPosition.getDesiredSkills()%>		</td>
				</tr>
				<tr>
				<td width="25%"> 	Environment Associate will work in </td>
				<td width="25%"> 	<%=wfmPosition.getEnvironment()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Estimates Weekly Overtime </td>
				<td width="25%"> 	<%=wfmPosition.getWeeklyOvertime()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Frequency and Duration of Travel </td>
				<td width="25%"> 	<%=wfmPosition.getFrequencyOfTravel()%>	</td>
				</tr>
				</div>
				<tr>
				<td width="25%"> 	Employee Category </td>
				<td width="25%"> 
				<div  id="thirdsetData" class="wfm-system" <% if((wfmPosition.getWorkflowStep() <= 60 && wfmPosition.getWorkflowStep() != -1) && !wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){%>style="display:none;"<%} %>>
				<%
				Map<String, String> shiftMap11 = new HashMap<String, String>();
					shiftMap11 = ConfigUtility.getInputValuesForMap("Employe-category");
					Map<String, String> shiftMaps22 = new TreeMap<String, String>(shiftMap11);
					for (Map.Entry<String, String> entry : shiftMaps22.entrySet()) {																
				%>
				
					<% if(wfmPosition.getEmpCategory().equals(entry.getKey())){%>
					<%=entry.getKey()%>-<%=entry.getValue()%>
				<%
						} }
				%>	
				</div>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Employee Category Description </td>
				<td width="25%">
				<div  id="thirdsetData" class="wfm-system" <% if((wfmPosition.getWorkflowStep() <= 60 && wfmPosition.getWorkflowStep() != -1) && !wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){%>style="display:none;"<%} %>>
				
					<%
                    if (wfmPosition.getEmpCategoryDesc().equalsIgnoreCase("")) {
					%>
					<div id="desc" ></div>
					<%
						} else {
					%>
					<div id="desc"><%=wfmPosition.getEmpCategoryDesc()%></div>
					<%
							}
					%>	
				</div>
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Comments </td>
				<td colspan="3">
					<div  id="thirdsetData" class="wfm-system" <% if((wfmPosition.getWorkflowStep() <= 60 && wfmPosition.getWorkflowStep() != -1) && !wfmPosition.getStatus().equalsIgnoreCase(HondaPermissionKeys.POS_MODFIED)){%>style="display:none;"<%} %>>
					 	<%=wfmPosition.getComments()%>		
					</div>
				</td>
				
				</tr>
				
			</table>
			<div style="page-break-after: always;"></div>
				
				<table width="100%" align="center" cellpadding="10">
				<tr>
					<td colspan="4" class="n" ><b>Log :</b><br>
					<div class="users col-sm-12">
                	<div class="logs_comments" style="line-height: 18px;">
						<%
							
							List<WFMS_Position_Audit> wfms_auditlistprint_ss = WFMS_Position_AuditLocalServiceUtil.findByPosIdForAudit(pId);
						%>
						<%
							for (WFMS_Position_Audit wfms_auditprint_ss : wfms_auditlistprint_ss) {
							  %>
							
					   <div class="logs">
						   <div class="user_comments" id="user_comments">
								<br>
								 <%=wfms_auditprint_ss.getChange()%>
								<% if(!wfms_auditprint_ss.getComments().equalsIgnoreCase(WorkflowConstants.POSITION_MODIFY_POSITION_SUBMIT)){ %>
								By :
								<%=wfms_auditprint_ss.getCreatedBy()%>
								--
								
								<%=HondaLogicUtil.getDateFormat(wfms_auditprint_ss.getCreateDate())%>
								<% } %>
										<% if(wfms_auditprint_ss.getChange().equalsIgnoreCase(WorkflowConstants.POSITION_DISAPPROVE_POSITION)){ %>
									<div class="comments" id="comments">
										 &nbsp;<div class="log_comments" style="line-height: 19px;margin:-9px 0px -4px 0px;text-indent: 3px;"><b class="comment_title">Comments :</b><%=wfms_auditprint_ss.getComments() %></div>
										</div>
										<% } %>
						   </div>
					   </div>
					   <%
					   }
						%>
			        </div>
					</div>
					</td> 
				</tr>
				</table>
	</body> 
</html> 
				
