<!DOCTYPE html> <html class="aui ltr" dir="ltr" lang="en-US">
	 <head>
		<style>
		table { border-top:1px solid #ccc; border-right1:1px solid #ccc; }
		table td { border-bottom:1px solid #ccc; border-left1:1px solid #ccc; padding:1px;  }
		</style>
	</head>
 <body class=" yui3-skin-sam controls-hidden signed-in private-page site isAdmin "> 
			
			<table width="100%" align="center" cellpadding="10">
			
				<tr>
				<td>
				 <a class="logo default-logo" href="/" title="Honda Manufacturing of Alabama"> 
				 
				 <img alt="Honda Manufacturing of Alabama" src="<%=renderRequest.getContextPath()%>/images/HondaManufacturingofAlabama_logo.png" width="160" /> </a>
				</td>
				</tr>
			</table> 
			<table width="100%" align="center" cellpadding="10">
			
				<tr>
					<td colspan="4"   style="font-size:18px; ">
						<strong>	Manage Requisition </strong>
					</td> 
				</tr>
				<tr >
				<td width="25%"> 	Requisition Number		</td>
				<td width="25%"> 	<%=reqNumber%></td>
				<td width="25%"> 	Filled with Associate Number		</td>
				<td width="25%"> 
				<%	if(req.getAssociatenumber().equalsIgnoreCase("None")){%>
					<div id="getAssociatenumber">None</div>
				<%}else if(req.getAssociatenumber()!=null){%>
				<%=req.getAssociatenumber() %>-<%=req.getAssociatename() %>
				<%} else {%>
					<%=req.getAssociatenumber() %>-<%=req.getAssociatename() %>
				<%}%>					
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Position Number		</td>
				<td width="25%"> 	<%=frompos.getPId()%>		</td>
				<td width="25%"> 		Name of Person Filling if no ID		</td>
				<td width="25%"> 		<%=req.getAssociatename()%>		</td>
				
				</tr>
				<tr>
				<td> 	Line		</td>
				<td> 	<%=frompos.getLine()%>		</td>
				<td> 	Status		</td>
				<td>
				<%
				if(req.getStatus().equalsIgnoreCase("save")){
				%>
				<div class="portlet-column portlet-column-last col-sm-7">Draft</div>
				<% } else{
				%>
				<div class="portlet-column portlet-column-last col-sm-7"><%=req.getStatus()%></div>
				<%
					}
				%>		
				</td>
				</tr>
				<tr>
				<td width="25%"> 	Posting Type		</td>
				<td width="25%">
				<%	values = ConfigUtility.getInputValuesFromConfig("requisation-type");
				    Arrays.sort(values);
				for (String value : values) {
					%>
					<%if(req.getPostingType().equals(value)){%>
				<%=value%>
				<%
				} }
				%>
				</td>
				<td width="25%"> 	Creator	</td>
				<td width="25%"> 	<%=req.getCreatedBy()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Team Number	</td>
				<td width="25%"> 
				<%	List<String> reportToTeamNumber = HMAAssociateInfoService.getTeamNumberCos();
					 for ( String teamNumber : reportToTeamNumber) { %>
				<%if(req.getTeamNumber().equals(teamNumber)){%>
				<%=teamNumber%>
				<%
					 }}
				%>		
				</td>
				<td width="25%"> 		Date Created	</td>
				<td width="25%"> 	<%=HondaLogicUtil.getDateFormat(req.getCreateDate()).trim()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Ladder	</td>
				<td width="25%"> 	<%=frompos.getLadder()%>	</td>
				<td width="25%"> 	Date Approved	</td>
				<td width="25%"> 	<%=HondaLogicUtil.getDateFormat(req.getApprovedDate()) %>	</td>
				</tr>
				<tr>
				<td width="25%"> 		Associate Type	</td>
				<td width="25%">
				<%	values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
																																								for(String value:values){
				%>
				<%if(req.getAssociatetype().equals(value)){%>
				<%=value%>
				<%
				} }
				%>		
				</td>
				<td width="25%"> 		Department Name </td>
				<td width="25%"> 		<%=frompos.getDepartmentName().trim()%>		</td>
				</tr>
				<tr>
				<td width="25%"> 	Shift Assignment	</td>
				<td width="25%">
				<%	Map<String,String> shiftMap = new HashMap<String,String>();
				 shiftMap=ConfigUtility.getInputValuesForMap("shift-assignment");
				  Map<String,String> shiftMaps = new TreeMap<String,String>(shiftMap);
				 for(Map.Entry<String, String> entry : shiftMaps.entrySet()){
					String total = entry.getKey()+":"+entry.getValue();
				%>
				<%if(req.getShiftAssign().equals(total)){%>
				<%=entry.getKey()%>-<%=entry.getValue()%>
				<%
				 } }
				%>	
				</td>
				<td width="25%"> 		Department Number	</td>
				<td width="25%"> 	<%=frompos.getDepartmentNumber().trim()%>			</td>
				</tr>
				<tr>
				<td width="25%"> 	Who will this person report to?	</td>
				<td width="25%"> 	<%=frompos.getReportsTo()%>	</td>
				<td width="25%"> 		Department Manager	</td>
				<td width="25%"> 			<%=deptMap.get("deptMgrName")%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	How did this Position become available?	</td>
				<td width="25%"> 	
				<%	values = ConfigUtility.getInputValuesFromConfig("position-availableposition");
					   for(String value:values){%>
					   <%if(req.getHowAvailable().equals(value)){%>
					<%=value%>
				<%
					  } }
				%>
				</td>
				<td width="25%"> 		Division	</td>
				<td width="25%"> 		<%=frompos.getDivision()%>		</td>
				</tr>
				<tr>
				<td width="25%"> 		</td>
				<td width="25%"> 		</td>
				<td width="25%"> 		Division Manager</td>
				<td width="25%"> 		<%=deptMap.get("divMgrName")%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	If replacement, replacement of whom?	</td>
				<td colspan="3"> 	<%=req.getWhoReplaced()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Date Manpower needed?	</td>
				<td colspan="3"> 	<%=req.getDateneeded()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Contact Person for Interviews	</td>
				<td colspan="3"> 	<%=req.getContactperson()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Contact Phone Number	</td>
				<td colspan="3"> 	<%=req.getContactphonenumber()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Taleo Number	</td>
				<td colspan="3"> 	<%=req.getTaleonumber()%>	</td>
				</tr>
				<tr>
					<td colspan="4"   style="font-size:18px; ">
					<strong>	REQUISITION INFORMATION </strong>

				</td> 
				</tr>
				<tr>
				<td width="25%"> 	Typical Job Title	</td>
				<td colspan="3"> 	<%=frompos.getTypicalJobTitle()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Minimum Job Relevant Knowledge (Know how)	</td>
				<td colspan="3"> 	<%=frompos.getMinJobKnowHow()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Prioritized duties and Responsibilities </td>
				<td colspan="3"> 	<%=frompos.getDuties()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Daily Tasks Performed	</td>
				<td colspan="3"> 	<%=frompos.getTasksPerformed()%>	</td>
				</tr><tr>
				<td width="25%"> 	Minimun Job Relevant Experience (length of service)	</td>
				<td colspan="3"> 	<%=frompos.getLengthOfService()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Degree or certification required	</td>
				<td colspan="3"> 	<%=frompos.getDegree()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Required Skills (Musts)	</td>
				<td colspan="3"> 	<%=frompos.getReqSkills()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Desired Skills and Abilities (Wants)	</td>
				<td colspan="3"> 	<%=frompos.getDesiredSkills()%>	</td>
				</tr><tr>
				<td width="25%"> 	Environment Associate will work in	</td>
				<td colspan="3"> 	<%=frompos.getEnvironment()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Estimates Weekly Overtime </td>
				<td colspan="3"> 	<%=frompos.getWeeklyOvertime()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Frequency and Duration of Travel	</td>
				<td colspan="3"> 	<%=frompos.getFrequencyOfTravel()%>	</td>
				</tr>
				<tr>
				<td width="25%"> 	Other	</td>
				<td colspan="3"> 	<%=req.getOther()%>	</td>
				</tr>
			
			</table>
			
			<div style="page-break-after: always;"></div>
				
				<table width="100%" align="center" cellpadding="10">
				<tr>
					<td colspan="4" class="n" ><b>Log :</b><br>
					<div class="users col-sm-12">
                	<div class="logs_comments" style="line-height: 14px;" >
					<%
					List<WFMS_Requisition_Audit> requisition_Audit_req= WFMS_Requisition_AuditLocalServiceUtil.findByReqIdForAudit(reqNumber);
					%>
					<%
						for(WFMS_Requisition_Audit wfms_audit_req :requisition_Audit_req){
					%>
							
				<div class="logs">
				    <div class="user_comments" id="user_comments">
						<br>
						 <%=wfms_audit_req.getChange()%>
						By :
						<%=wfms_audit_req.getCreatedBy()%>
						--
						
						<%=HondaLogicUtil.getDateFormat(wfms_audit_req.getCreateDate())%>
						<% if(wfms_audit_req.getChange().equalsIgnoreCase(WorkflowConstants.REQUISITION_DISAPPROVAL) || wfms_audit_req.getChange().equalsIgnoreCase(WorkflowConstants.REQUISITION_CANCEL)){%>
						<div class="comments" id="comments">
							 &nbsp;<div class="log_comments" style="line-height: 19px;margin:-9px 0px -4px 0px;text-indent: 3px;"><b class="comment_title">Comments :</b><%=wfms_audit_req.getComments() %></div>
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