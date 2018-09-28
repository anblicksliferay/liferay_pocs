
<!DOCTYPE html> <%@page import="com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<html class="aui ltr" dir="ltr" lang="en-US"> 
	<head>
		<style>
		table { border-top:1px solid #ccc; border-right1:1px solid #ccc; }
		table td { border-bottom:1px solid #ccc; border-left1:1px solid #ccc; padding:1px;  }
		</style>
	</head>
 <body class=" yui3-skin-sam controls-hidden signed-in private-page site isAdmin COSprintForm"> 
			
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
					<strong>	Manage Change of Status </strong>

			</td> 
				</tr>
				<tr >
				<td width="25%"> 	Associate Number		</td>
				<td width="25%" colspan="3"> 	<%=wfmsCOS.getAssoicateId().trim()+" - "+wfmsCOS.getAssociatename() %></td>
				
				</tr>
				<tr>
				<!--<td width="25%"> 	Associate Name		</td>
				<td width="25%"> 	<%=wfmsCOS.getAssociatename() %>		</td> -->
				<td width="25%"> 				</td>
				<td width="25%"> 				</td>
				</tr>
				<tr>
				<td> 	Change of Status number		</td>
				<td> 		<%=wfmsCOS.getCosId() %>		</td>
				<td> 		Status		</td>
				<td> 			<%=wfmsCOS.getStatus() %>	</td>
				</tr>
				<tr>
				<td> 		Created By		</td>
				<td> 		<% if(wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2){%>System Generated<%}else{%><%=wfmsCOS.getCreatedBy() %><%} %>		</td>
				<td> 		Date Created		</td>
				<td> 		<%= HondaLogicUtil.getDateFormat(wfmsCOS.getCreateDate()) %>
		</td>
				</tr>
				<tr>
				<td> 	Effective Date<br/>
(Should be Thursday of the week)
			</td>
				<td> <%=wfmsCOS.getEffectiveDate() %>	</td>
				<!-- <td> 	Associate Date of Hire			</td>
				<td> 		<%out.print(wfmsCOS.getAssociateDateOfHire()); %>		</td> -->
				<td> Announced </td>
				<td> <%if(wfmsCOS.getAnnounced()==1){%>Yes<%} else {%>No<%}%></td> 
				</tr>
				<tr>
					<!-- <td> 	Change Description
			</td>
					<td> <%=wfmsCOS.getType() %>		</td> -->
					<td> 	Action
			</td>
					<td> <%=wfmsCOS.getAction() %>	</td>
				</tr>
				<tr>
					<td> 	Requisition Number			</td>
					<td> 	<%if(wfmsCOS==null) {}else{if(wfmsCOS.getSystemGenerated() == 1 && Validator.isNotNull(wfmsCOS.getRequistionId())){%><%=wfmsCOS.getRequistionId()%><%}}%> 			</td>
					<td> 				</td>
					<td> 				</td>
					</tr>
					<tr>
					<td> 	Reason Code
			</td>
					<td colspan="3"> <%= wfmsCOS.getReasonCODE()%>-<%= wfmsCOS.getDescription() %>	</td>
					</tr>
					<tr>
					
					<!-- <td> 	Reason Description			</td>
					<td colspan="3"> 	<%=wfmsCOS.getDescription() %>  -->
			</td>
				</tr>
				<tr>
					<td colspan="4"  style="font-size:15px; ">
					<strong>	CURRENT AND NEW POSITION INFORMATION </strong>

			</td> 
				</tr>
				
				<tr>
					<td> <h3>	Current Position</h3>			</td>
					<td> 				</td>
					<td> <h3>New Position</h3>

				</td>
					<td> 				</td>
				</tr>
				<tr>
					<td> 	Associate Title			</td>
					<td> 	 <% if(Validator.isNotNull(wfmsCOS.getCurrentJobCode())){%><%=wfmsCOS.getCurrentJobCode()%><%} %>  			</td>
					<td> 	Associate Title			</td>
					<td> 		<%
						String ladder=null;
						if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
							WFMS_Position newPostionInfo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM",""));
							ladder=newPostionInfo.getLadder();
						}
						Map<String, String> shiftMap = new HashMap<String, String>();
						shiftMap = ConfigUtility.getInputValuesForMap("associate-titles-and-ladder");
						Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
						for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {  
							if(ladder!=null){
								 if(ladder.equalsIgnoreCase("Either") || ladder.equalsIgnoreCase("Technical") || ladder.equalsIgnoreCase("Business")){
									 if(ladder.equalsIgnoreCase("Technical") || ladder.equalsIgnoreCase("Business")){
										 if(!(entry.getValue().equalsIgnoreCase(ladder) || entry.getValue().equalsIgnoreCase("Either")))
											 continue;
									 }
									 else if(ladder.equalsIgnoreCase("Either")){
										 if(!(entry.getValue().equalsIgnoreCase("Business") || entry.getValue().equalsIgnoreCase("Technical") || entry.getValue().equalsIgnoreCase("Either")))
										      continue;
									 }
								 }
								 else if(!entry.getValue().equalsIgnoreCase(ladder))
									 continue;
							}
						%>
							<%if(wfmsCOS.getNewJobCode().equals(entry.getKey())){ %><%=entry.getKey() %><%} %>
						<% } %>
					</td>
				</tr>
				<tr>
					<td> 	Position Number			</td>
					<td> 	<% if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber())){%><%=wfmsCOS.getPositionNumber().replaceAll("-WFM","")%><%} %> 		</td>
					<td> Position Number   </td>
					<td> 	
	 <% if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){%>
						 <%=wfmsCOS.getNewPositionNumber()%>
						 <%}else{ %>
						 <% if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2){
							 if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 1){
						 %>
						     <%=wfmsCOS.getNewPositionNumber()%>
						     <% } else{ %>    
						     <%=wfmsCOS.getPositionNumber()%>
						     <%}}else{%>
							 
								<% DynamicQuery queryForPosition =WFMS_PositionLocalServiceUtil.dynamicQuery();
                                queryForPosition.add(PropertyFactoryUtil.forName("status").eq("Open"));
                                queryForPosition.addOrder(OrderFactoryUtil.asc("pId"));
                             
                                List<WFMS_Position> positionNumbers= new ArrayList<WFMS_Position>();
                                List<String> positionNoList= new ArrayList<String>();
                                positionNumbers = WFMS_PositionLocalServiceUtil.dynamicQuery(queryForPosition);
                                
                                for(WFMS_Position positionNumber: positionNumbers){
                                 List<WFMS_Requisition> reqNumbers= new ArrayList<WFMS_Requisition>();
                                DynamicQuery queryForReq =WFMS_RequisitionLocalServiceUtil.dynamicQuery();
                                 queryForReq.add(PropertyFactoryUtil.forName("rId").eq(positionNumber.getPId()));
                                  reqNumbers = WFMS_RequisitionLocalServiceUtil.dynamicQuery(queryForReq);
                                  
                                  int sum1 = (int)WFMS_RequisitionLocalServiceUtil.dynamicQueryCount(queryForReq);
                                  
                                  if(sum1 > 0){
                                    for(WFMS_Requisition reqNumber:reqNumbers){
                                      if(reqNumber.getStatus().equals("Complete") || reqNumber.getStatus().equals("Cancelled")){
                                      positionNoList.add(positionNumber.getPId());
                                      }else{
                                            if(positionNoList.contains(positionNumber.getPId()))
                                                positionNoList.remove(positionNumber.getPId());
                                      }
                                    }
                                  }else{
                                                positionNoList.add(positionNumber.getPId());
                                  }
                                
                                }
                                
                                List<String> positionNoList1= new ArrayList<String>();                                    
                                HashSet<String> positionNos1 = new HashSet<String>(positionNoList); %>
								<%for(String posid:positionNos1){
									posID=posid;%>
									<%if(wfmsCOS.getNewPositionNumber().equals(posID)){ %><%=posID%><%} %>
								<%} %>
								<%if(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None")){ %><%=wfmsCOS.getNewPositionNumber()%><%} %>
								
							<%}} %></td>
				</tr>
				<%
								 Map<String , String> hondamap= new HashMap<String,String>();
								if(Validator.isNotNull(wfmsCOS.getSameDept())){
								    hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getSameDept());
								}
								if(Validator.isNotNull(wfmsCOS.getNewDepartmentNumber())){
									hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getNewDepartmentNumber());
									}
								%>
				<tr>
					<td> 	Division			</td>
					<td> 	<% if(Validator.isNotNull(wfmsCOS.getCurrentDivision())){%><%=wfmsCOS.getCurrentDivision()%><%} %>	</td>
					<td> 	Division			</td>
					<td> 	 
		                <%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last col-sm-7" id="Division"><%=wfmsCOS.getCurrentDivision()%></div>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						<div class="portlet-column portlet-column-last col-sm-7" id="Division">  <% if(hondamap.get("divName")!=null ) out.print(hondamap.get("divName"));%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="Division">  <% if(hondamap.get("divName")!=null ) out.print(hondamap.get("divName"));%></div>
		                 <%} %>
		                 			</td>
				</tr>
				
				<tr>
					<td> 	Division Manager			</td>
					<td> 	<% if(Validator.isNotNull(wfmsCOS.getCurrentDivisionManager())){%><%=wfmsCOS.getCurrentDivisionManager()%><%} %>
			</td>
					<td> 	Division Manager			</td>
					<td> 	<%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<%=wfmsCOS.getCurrentDivisionManager()%>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						  <% if(hondamap.get("divMgrName")!=null ) out.print(hondamap.get("divMgrName"));%>
						<%}else{ %>
		                <% if(hondamap.get("divMgrName")!=null ) out.print(hondamap.get("divMgrName"));%>
		                <%} %>
			</td>
				</tr>
				<tr>
					<td> 	Department Name			</td>
					<td> 	<% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentName())){%><%=wfmsCOS.getCurrentDepartmentName()%><%} %> 
			</td>
					<td> 	Department Name			</td>
					<td> 	<%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<%=wfmsCOS.getCurrentDepartmentName()%></div>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						 <% if(hondamap.get("deptName")!=null ) out.print(hondamap.get("deptName"));%>
						<%}else{ %>
		                <% if(hondamap.get("deptName")!=null ) out.print(hondamap.get("deptName"));%> 
		                <%} %>
			</td>
				</tr>
				
				<tr>
					<td> 	Department Number			</td>
					<td> 	  <% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentNumber())){%><%=wfmsCOS.getCurrentDepartmentNumber()%><%} %>			</td>
					<td> 	Department Number			</td>
					<td> 	<%if(wfmsCOS.getSystemGenerated() == 1) {%>
		                 <%=wfmsCOS.getNewDepartmentNumber() %>
		                 <%}else if(wfmsCOS.getSystemGenerated() == 2) {%>
		                 <%=wfmsCOS.getCurrentDepartmentNumber() %>
		                 <%}else{ %>
		                 <%=wfmsCOS.getNewDepartmentNumber() %>
		                      <% 
                             	Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
							 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){
								 if(Validator.isNotNull(entry.getValue())){
							 String keyvalue = entry.getKey() +"-" +entry.getValue(); %>
				                  <%if(wfmsCOS.getSameDept().equals(entry.getKey())){ %><%=keyvalue%><%} %>
									<%}} %>		
		                
		                <%} %>			</td>
				</tr>
				<tr>
					<td> Department Manager				</td>
					<td> <% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentManager())){%><%=wfmsCOS.getCurrentDepartmentManager()%><%} %>			</td>
					<td> Department Manager				</td>
					<td> <%if(wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last col-sm-7" id="deptMgrName"><%=wfmsCOS.getCurrentDepartmentManager() %></div>
						<%}else if(wfmsCOS.getSystemGenerated() == 1) {%>
						<div class="portlet-column portlet-column-last col-sm-7" id="deptMgrName">  <%  if(hondamap.get("deptMgrName")!=null ) out.print(hondamap.get("deptMgrName"));%></div>
						<%}else{ %>
		                 <div class="portlet-column portlet-column-last col-sm-7" id="deptMgrName"><%  if(hondamap.get("deptMgrName")!=null ) out.print(hondamap.get("deptMgrName"));%></div>
		                 <%} %>
		                 				</td>
				</tr>				
				
				<tr>
					<td> 	Team Number			</td>
					<td> 	<% if(Validator.isNotNull(wfmsCOS.getCurrentTeamNumber())){%><%=wfmsCOS.getCurrentTeamNumber()%><%} %>			</td>
					<td> 	Team Number			</td>
					<td> 	  <%if(wfmsCOS.getSystemGenerated() == 2) {%>
		                <div class="portlet-column portlet-column-last col-sm-7" id="systemteamNumber"><%=wfmsCOS.getTeamNumber() %></div>
		                
		                <%}else{ %>
			                <% 	List<String> reportToteamNUmber = HMAAssociateInfoService.getTeamNumberCos();
									for (String teamNumber: reportToteamNUmber) {  
								%>
								  <%if(wfmsCOS.getTeamNumber().equals(teamNumber)){ %><%= teamNumber %><%} %>
							<% } %>
						<%} %></td>
				</tr>
				<tr>
					<td> 	Shift Code			</td>
					<td> 	<% if(Validator.isNotNull(wfmsCOS.getCurrentShiftCode())){%><%=wfmsCOS.getCurrentShiftCode()%><%} %> 			</td>
					<td> 	Shift Code			</td>
					<td> 	<%if(wfmsCOS.getSystemGenerated() == 2) {%>
		                <%=wfmsCOS.getShiftCode()%>
		                <%}else{ %>
			                 
									<% 	List<String> reportToshiftCodeManege = HMAAssociateInfoService.getShiftCodeCos();
									for (String shiftNumber : reportToshiftCodeManege) {  
									%>
								  <%if(wfmsCOS.getShiftCode().equals(shiftNumber)){ %><%= shiftNumber %><%} %>
									<% } %>
						<%} %>	</td>
				</tr>
				<tr>
					<td>Employee Category</td>
					<td><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber()) && !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){ 
					WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getPositionNumber().replaceAll("-WFM",""));%>
					<%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}%> </td>
					
					<td>Employee Category</td>
					<td><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getNewPositionNumber()) && !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None")) ){ 
					WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM","")); 
					if(Validator.isNotNull(wfmpo.getEmpCategory())){
					%>
		 			<%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}}%> </td>
				</tr>
				
				<tr>
					<td> 	Leadership Assignment			</td>
					<td> 	<% if(Validator.isNotNull(wfmsCOS.getCurrentLeadershipAssignment())){%><%=wfmsCOS.getCurrentLeadershipAssignment()%><%} %>			</td>
					<td> 	Leadership Assignment 			</td>
					<td> 	<div class="portlet-column portlet-column-last col-sm-7" >
		                <div class="portlet-column portlet-column-last col-sm-7" id="newleadershipassignment">
		                <% if((wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2) && wfmsCOS.getLeadershipAssignment()!=null) 
		                	  out.print(wfmsCOS.getLeadershipAssignment());
						  if(wfmsCOS.getSystemGenerated() == 0 && wfmsCOS.getLeadershipAssignment()!=null) 
		                	  out.print(wfmsCOS.getSameLeadership());
		                   else if(wfmsCOS.getSameLeadership()!=null)
		                	   out.print(wfmsCOS.getSameLeadership());
		                   else if(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))
		                	   out.print("None");
		                  %>
		               
		                </div>
		                <div class="portlet-column portlet-column-last col-sm-7">
		                <div id="UpdatePO" name="UpdatePO">		              
							<div id="MgrAssNo" name="MgrAssNo" <%if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){ %>style="display: none;""<%} %>>
							<div class="leader-ship">
								
									<% 	List<String> reportToleaderShip = HMAAssociateInfoService.getLeaderShipCos();
									for (String leadership: reportToleaderShip) {  
									%>
								  <%if(wfmsCOS.getLeadershipAssignment().equals(leadership)){ %><%= leadership %><%} %>
									<% } %>
								
								<div id="leadership1"  class="form-required">	
								 <%if(wfmsCOS !=null && (wfmsCOS.getNewJobCode().equals("PA") || wfmsCOS.getNewJobCode().equals("TC"))){ %>
		                <%out.print("None"); %>
		                <%}else{ %>
		                 <%=wfmsCOS.getLeadershipAssignment() %>
		                <%} %>
					</div>
							</div>
							
							</div>
						</div>
		                </div>
		                </div>
										</td>
				</tr>
				 <tr>
					<td> Manager Associate Number				</td>
					<td> 	 <% if(Validator.isNotNull(wfmsCOS.getCurrentManagerAssocNumber())){%><%=wfmsCOS.getCurrentManagerAssocNumber()%><%} %> 			</td>
					<td> Manager Associate Number  	</td>
					<td> 	<%if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 2)){%>
		                <div id="managerAssociateNumber"><%=wfmsCOS.getCurrentManagerAssocNumber()%></div>
		                <% }else{ %>
		                             <div id="managerAssociateNumber" <% if(wfmsCOS !=null && (wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %>  style="display:none;" <% } %>><% if(wfmsCOS!=null) out.print(wfmsCOS.getMgrAssociateNumber()); %></div>
                                 <% } %>      
                                            <div id="managerAssociatedropdown" <% if(wfmsCOS ==null || !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %> style="display:none;" <% } %>>  
						    
							<%  Map<String,String> MgrAssNumberMap = HMAAssociateInfoService.getMsrAssociateNoToNewCOS();
                                                                String associatemanage="";
                                                                if(wfmsCOS!=null)
                                                                   associatemanage=wfmsCOS.getMgrAssociateNumber();
							     for(Map.Entry<String, String> entry : MgrAssNumberMap.entrySet()){ %>
				                                <%if(associatemanage.equals(entry.getKey())){ %><%=entry.getKey()%>-<%=entry.getValue()%><%} %>
							    <% } %>
						
                                                                      <div class="form-validator-stack help-inline manageAssociate_ValidationMessage" style="display:none;">
							     Missing required value for the field "Manager Associate Number"</div>          
                                                                
                                        </div>			</td>
				</tr> 

					<tr>
					<td>Manager Name </td>
					<td> <% if(Validator.isNotNull(wfmsCOS.getCurrentManagerName())){%><%=wfmsCOS.getCurrentManagerName()%><%} %> </td>
					<td>Manager Name </td>
					<td><% if(wfmsCOS.getSystemGenerated() == 2){ out.print(wfmsCOS.getCurrentManagerName()); }else{ out.print(wfmsCOS.getNewManagerName()); }%></td>
				</tr>
				<tr>
					<td> Manager Title</td>
					<td> <% if(Validator.isNotNull(wfmsCOS.getCurrentManagerTitle())){%><%=wfmsCOS.getCurrentManagerTitle()%><%} %></td>
					<td>Manager Title </td>
					<td> <% if(wfmsCOS.getSystemGenerated() == 2){ out.print(wfmsCOS.getCurrentManagerTitle()); }else{ out.print(wfmsCOS.getNewManagerTitle()); } %> </td>
				</tr>
				<tr>
					<!-- <td>Routing Path </td>
					<td> <%=wfmsCOS.getApproverList() %></td> -->
					<td> </td>
					<td> </td>
					<td>Manpower Category </td>
					<td>
								<%
									values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
									for(String value:values){	
								%>
									<%if(wfmsCOS.getManpowerCategiry().equals(value)) {%><%=value %><%} %>
								<% } %>
								</td>
				</tr>
					<tr>
					<td> Next Approver </td>
					<td><%=wfmsCOS.getNextApprover() %></td>
					<td>Manpower Rep </td>
					<td><div class="portlet-column portlet-column-last col-sm-7" id="divMgrName"> 
						<% if(wfmsCOS.getSystemGenerated() == 2)
							    out.print(wfmsCOS.getCurrentManpowerRep());
						   else if(hondamap.get("mpwrrep_name")!=null) 
							   out.print(hondamap.get("mpwrrep_name")); 
							   %> 
				       </div></td>
				</tr>
				<tr>
					<td> Role of approver</td>
					<td><%=wfmsCOS.getRoleOfApprover() %></td>
					<td>Notification To </td>
					<td> <% String noticationTo=StringPool.BLANK;
							if(Validator.isNotNull(wfmsCOS.getNotificationTo()))  {
								noticationTo=HondaLogicUtil.convertNotification(wfmsCOS.getNotificationTo(),wfmsCOS.getCosId());
						 }%>
		                 <%=noticationTo%></td>
				</tr>
				<%-- <tr>
					<td>Employee Category</td>
					<td><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber())){ 
					WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getPositionNumber());%>
					<%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}%> </td>
				</tr> --%>
				</table>
				<div style="page-break-after: always;"></div>
				<table width="100%" align="center" cellpadding="10">
				<tr>
					<td><b>Comments :</b>
					<%=wfmsCOS.getComments() %> </td> 
				</tr>				
				
					<tr>
					<td colspan="4" class="n" ><b>Log :</b><br>
                <div class="users col-sm-12">
                	<div class="logs_comments" style="line-height: 16px;">
			                <%List<WFMS_COS_Audit> wfms_auditlist=WFMS_COS_AuditLocalServiceUtil.findByCosIdForAudit(wfmsCOS.getCosId()); %>
			                <%for(WFMS_COS_Audit wfms_audit :wfms_auditlist){%>
			                	
			              
				               		 <%=wfms_audit.getChange() %> By : <%=wfms_audit.getCreatedBy()%> - <%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate()) %> <b> , </b> &nbsp;
				               		 
				               			<% if(wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_DISAPPROVE)|| wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_CANCEL)){%>
											
										 	  	&nbsp;<b class="comment_title">Comments :</b><%=wfms_audit.getComments() %><b> , </b> &nbsp;
										    
											<%}%>
				               
			               <%
			               }
			                %>
			        </div>
	           </div>
	           </td> 
				</tr>
				</table>
<style>
<<<<<<< .mine
.COSprintForm td { padding:2px; font-family:arial; font-size:15px; border-bottom: #ddd 1px solid; }  
.COSprintForm select { max-width:100%; width:100% }
.COSprintForm h3 {margin:0; font-size:14px; }
.COSprintForm li {    line-height: 35px;}
.COSprintForm .logs_cos_comments { margin-bottom:20px; }
.COSprintForm .logs_cos_comments li { line-height:normal; }
=======
.COSprintForm td {
	padding:2px; 
	font-family:arial; 
	font-size:15px; 
	border-bottom: #ddd 1px solid; 
}
.COSprintForm h3 {
	margin:0;
	font-size:14px; 
}
.COSprintForm .logs_cos_comments { 
	margin-bottom:20px; 
}
.COSprintForm .logs_cos_comments li { 
	line-height:normal; 
}
>>>>>>> .r3121
</style>
				
		</body> </html> 