
<!DOCTYPE html> <%@page import="com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil"%>
<%@page import="com.ys.hmawfm.wfms.services.service.WFMS_action_namesLocalServiceUtil"%>
<html class="aui ltr" dir="ltr" lang="en-US"> 
	<head>
		<style>
		table { border-top:1px solid #ccc; border-right1:1px solid #ccc; }
		table td { border-bottom:1px solid #ccc; border-left1:1px solid #ccc; padding:1px;  }
		</style>
	</head>
 <body class=" yui3-skin-sam controls-hidden signed-in private-page site isAdmin COSprintDraft"> 
			
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
					<strong>	<%if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_SUBMIT) || wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){ %>Manage Change of Status<%}else{ %>Create Change of Status<%} %></strong>

			</td> 
				</tr>
				<tr >
				<td width="25%"> 	Associate Number		</td>
				<td width="25%" colspan="3"> 	 <%if(wfmsCOS.getAssoicateId() != null){%><%=wfmsCOS.getAssoicateId().trim()+" - "+wfmsCOS.getAssociatename() %><%}%></td>
				
				</tr>
				<tr>
				<!--<td width="25%"> 	Associate Name		</td>
				<td width="25%"> 	<%=wfmsCOS.getAssociatename() %> </td> -->
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
				<!--<td> 	Associate Date of Hire			</td>
				<td> 		<div id="associatedateofhire_print"><%out.print(wfmsCOS.getAssociateDateOfHire()); %>	</div>	</td> -->
				<td> Announced </td>
					<td> <%if(wfmsCOS.getAnnounced()==1){%>Yes<%} else {%>No<%}%></td> 
				</tr>
				<tr>
					<!--<td> 	Change Description	</td>
					<td> <%=wfmsCOS.getType() %>	</td> -->
					<td> 	Action
			</td>
					<td> <div class="portlet-column portlet-column-last col-sm-7" id="action_maindiv">
		                <%
		                
		                DynamicQuery dynamicQuery = WFMS_action_namesLocalServiceUtil.dynamicQuery();
						//Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("actionName"));
						dynamicQuery.add(PropertyFactoryUtil.forName("deleteflag").eq(0));
						//dynamicQuery.setProjection(projection);
						dynamicQuery.addOrder(OrderFactoryUtil.asc("actionName"));
						//java.util.List<Object> reasoncodeList = WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQuery);
                        List<WFMS_action_names> actionList=WFMS_action_namesLocalServiceUtil.dynamicQuery(dynamicQuery);
		                
		                if(wfmsCOS==null) {%>
							<%
							 for(WFMS_action_names val:actionList){  %>
								 <%=val.getActionName() %>
								<%} %>
						<%} else { %>
							<% 
							 List<String> actioncodeList= new ArrayList<String>();
							 for(WFMS_action_names val:actionList){
								// actioncodeList.add(val.getActionName());
							 //}
							 /* if(Validator.isNotNull(wfmsCOS.getAction())){
								 actioncodeList.add(wfmsCOS.getAction());
							 }
							 Set<String> hs = new HashSet<String>();
							 hs.addAll(actioncodeList);
							 actioncodeList.clear();
							 actioncodeList.addAll(hs); */
                             // for(String val:actioncodeList){
                                %>		
							   <%if(wfmsCOS.getAction().equals(val.getActionName())){ %><%=val.getActionName() %><%}%>
								<%} %>
						
						<% } %>
						
						<div class="form-validator-stack help-inline action_ValidationMessage" id="action_message" style="display:none;">
							     Missing required value for the field "Action"
							</div>
						</div>	</td>
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
					
					<!--<td> 	Reason Description			</td>
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
					<td> 	<div id="associateTitle_print"> <% if(Validator.isNotNull(wfmsCOS.getCurrentJobCode())){%><%=wfmsCOS.getCurrentJobCode()%><%} %>  	</div>		</td>
					<td> 	Associate Title			</td>
					<td> 		                    <%if(wfmsCOS==null) { %>
		              
                                   								
									<%
										Map<String, String> shiftMap = new HashMap<String, String>();
										shiftMap = ConfigUtility.getInputValuesForMap("associate-titles-and-ladder");
										Map<String, String> shiftMaps = new TreeMap<String, String>(shiftMap);
										for (Map.Entry<String, String> entry : shiftMaps.entrySet()) {																
									%>
										<%=entry.getKey() %>
									<% } %>
									
								 
		            <% } else { %>
		          
						<%	    String ladder=null;
						        if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
						        	if(wfmsCOS.getNewPositionNumber()!=null && !wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None")){
							        	WFMS_Position newPostionInfo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM",""));
										ladder=newPostionInfo.getLadder();
						        	}
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
						
						<%if(wfmsCOS.getNewJobCode().equals(entry.getKey())){ %><%=entry.getKey() %><%}%>
						
						<% } %>
					
		              
		            <% } %>
		        
					</td>
				</tr>
				<tr>
					<td> 	Position Number			</td>
					<td> 	<div id="positionId_print"><% if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber())){%><%=wfmsCOS.getPositionNumber().replaceAll("-WFM","")%><%} %> </div>		</td>
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
								 <%if(wfmsCOS.getCurrentPositionText() == 1){%>Current Position - <%=wfmsCOS.getNewPositionNumber()%><%}%> 
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
					<td> <div id="DIVISION_print">	<% if(Validator.isNotNull(wfmsCOS.getCurrentDivision())){%><%=wfmsCOS.getCurrentDivision()%><%} %>	</td>
					<td> 	Division			</td>
					<td> 	 
		                <div class="portlet-column portlet-column-last col-sm-7">
		                <%if(wfmsCOS==null || (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2))) {%>
		                <%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last col-sm-7" id="Division_print"><%=wfmsCOS.getCurrentDivision()%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="Division_print"> </div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="DivisionFromM"> </div>
		                <%}} else {
		                	
								if(Validator.isNotNull(wfmsCOS.getSameDept())){
								hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getSameDept());
								}
								if(Validator.isNotNull(wfmsCOS.getNewDepartmentNumber())){
									hondamap=HondaLogicUtil.singleCallOnServieNow(wfmsCOS.getNewDepartmentNumber());
									}
		                	
		                	%>
		                <div class="portlet-column portlet-column-last col-sm-7" id="Division_print">  <% if(hondamap.get("divName")!=null) out.print(hondamap.get("divName"));%></div>
		               
		                <%} %>		                 
		                </div>
		                 			</td>
				</tr>
				
				<tr>
					<td> 	Division Manager			</td>
					<td> 	<div id="DIVISION_MANAGER_print"> <% if(Validator.isNotNull(wfmsCOS.getCurrentDivisionManager())){%><%=wfmsCOS.getCurrentDivisionManager()%><%} %></div>
			</td>
					<td> 	Division Manager			</td>
					<td><div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS==null || (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2))) {%>
						<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last col-sm-7" id="divMgrName_print"><%=wfmsCOS.getCurrentDivisionManager()%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="divMgrName_print">  </div>
		                 <div class="portlet-column portlet-column-last col-sm-7" id="divMgrNameFromM"></div>
		                 <%}} else { %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="divMgrName_print">  <% if(hondamap.get("divMgrName")!=null) out.print(hondamap.get("divMgrName")); %></div>
		                
		                <%} %>
		               </div>
			</td>
				</tr>
				<tr>
					<td> 	Department Name			</td>
					<td> 	<div id="DEPT_NAME_print"><% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentName())){%><%=wfmsCOS.getCurrentDepartmentName()%><%} %> </div>
			</td>
					<td> 	Department Name			</td>
					<td> 	<div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS==null || (wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2)) {%>
						<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
						<div class="portlet-column portlet-column-last col-sm-7" id="deptNAME_print"><%=wfmsCOS.getCurrentDepartmentName()%></div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptNAME_print">  </div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptNameFromM"></div>
		                <%}} else { %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptNAME_print"><% if(hondamap.get("deptName")!=null) out.print(hondamap.get("deptName"));%> </div>
		                
		                <%} %>
		               </div>
			</td>
				</tr>
				
				<tr>
					<td> 	Department Number			</td>
					<td> 	 <div id="DEPT_NUMBER_print"> <% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentNumber())){%><%=wfmsCOS.getCurrentDepartmentNumber()%><%} %>	</div>		</td>
					<td> 	Department Number			</td>
					<td> <div class="col-sm-7">
                            <%if(wfmsCOS==null) { %>
                       
                              <div class="portlet-column portlet-column-last" id="newDeptNUmber1" name="newDeptNUmber1">
		     					    </div>
			                <div class="portlet-column portlet-column-last" id="deptNumber">
			                 
		     					<div class="portlet-layout row newDeptNUmber_mindiv">
		     					   
										
					<% 
								Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
							  
							 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){  
								 if(Validator.isNotNull(entry.getValue())){
							
							 %>
				                  <%=entry.getKey()%>-<%=entry.getValue()%>
									<%}} %>
										
							<div class="form-validator-stack help-inline newDeptNUmber_ValidationMessage" style="display:none;">
							     Missing required value for the field "Department Number"</div>										 
								</div>
			    		    </div>
			    		     <% } else {  %> 

		                        <div  class="portlet-column portlet-column-last " id="deptNumberFromPosition_print">
		                        
		                        <%if(wfmsCOS.getSystemGenerated() == 2) {%>
		                            <%=wfmsCOS.getCurrentDepartmentNumber()%>
		                        <% }else{ %>
		                         <%=wfmsCOS.getNewDepartmentNumber() %>
		                        <% } %>
		                        </div>
				                <div class="portlet-column portlet-column-last newDeptNUmber_mindiv" id="deptNumber">
				                 
				                 
		                                 <% 
										Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
									  
									 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){
										 if(Validator.isNotNull(entry.getValue())){	 
										  if(wfmsCOS.getSameDept().equals(entry.getKey())){ %>
										  <%=entry.getKey()%>-<%=entry.getValue()%>
									 <%}}} %>		
								
								 	<div class="form-validator-stack help-inline newDeptNUmber_ValidationMessage" style="display:none;">
									     Missing required value for the field "Department Number"</div>	
				                </div>
		               
			    		    <% } %>
			    		     </div>	</td>
				</tr>
				<tr>
					<td> Department Manager				</td>
					<td><div id="DEPT_MANAGER_print"> <% if(Validator.isNotNull(wfmsCOS.getCurrentDepartmentManager())){%><%=wfmsCOS.getCurrentDepartmentManager()%><%} %>		</div>	</td>
					<td> Department Manager				</td>
					<td><div class="portlet-column portlet-column-last col-sm-7">
						<%if(wfmsCOS==null || (wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2)) {%>
						<%if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2){ %>
						<div class="portlet-column portlet-column-last col-sm-7" id="deptManager_print"> <%=wfmsCOS.getCurrentDepartmentManager() %> </div>
						<%}else{ %>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptManager_print">  </div>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptManagerFromM"></div>
		                <%}}else {%>
		                <div class="portlet-column portlet-column-last col-sm-7" id="deptManager_print"><% if(hondamap.get("deptMgrName")!=null) out.print(hondamap.get("deptMgrName")); %></div>
		                 
		                <%} %>
		               </div>
		                 				</td>
				</tr>				
				
				<tr>
					<td> 	Team Number			</td>
					<td> <div id="teamNumber_print">	<% if(Validator.isNotNull(wfmsCOS.getCurrentTeamNumber())){%><%=wfmsCOS.getCurrentTeamNumber()%><%} %></div>			</td>
					<td> 	Team Number			</td>
					<td>  <div id="teamNumber_print2"> <%if(wfmsCOS.getSystemGenerated() == 2) {%>
		                <div class="portlet-column portlet-column-last col-sm-7" id="systemteamNumber"><%=wfmsCOS.getTeamNumber() %></div>
		                
		                <%}else{ %>
			                <% 	List<String> reportToteamNUmber = HMAAssociateInfoService.getTeamNumberCos();
									for (String teamNumber: reportToteamNUmber) {  
								%>
								  <%if(wfmsCOS.getTeamNumber().equals(teamNumber)){ %><%= teamNumber %><%} %>
							<% } %>
						<%} %>
					
                </div></td>
				</tr>
				<tr>
					<td> 	Shift Code			</td>
					<td> 	<div id="shiftcode_print"><% if(Validator.isNotNull(wfmsCOS.getCurrentShiftCode())){%><%=wfmsCOS.getCurrentShiftCode()%><%} %> 		</div>	</td>
					<td> 	Shift Code			</td>
					<td> 	<div class="portlet-column portlet-column-last col-sm-7" id="shiftCode_print2">
                <%if (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)) {%>
                  <div class="portlet-column portlet-column-last col-sm-7" id="systemshiftCode"><%=wfmsCOS.getShiftCode() %></div>
		              
                <%//if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2) {%>
                <!-- <div class="portlet-column portlet-column-last col-sm-7" id="systemshiftCode">  </div>
                <aui:input name="shiftCode" id="shiftCode" type="hidden"></aui:input> -->
                <%//}else{ %>
                <% } else { %>
					<% 	List<String> reportToshiftCodeManege = HMAAssociateInfoService.getShiftCodeCos();
					for (String shiftNumber : reportToshiftCodeManege) {  
					%>
				  <%if(wfmsCOS.getShiftCode().equals(shiftNumber)){ %><%= shiftNumber %><%}%>
					<% } %>
		             <%} %>   
                <div class="form-validator-stack help-inline shiftCode_ValidationMessage" id="shiftCode_message" style="display:none;">
							     Missing required value for the field "Shift Code"</div>
                </div> 	</td>
				</tr>
				
				<tr>
					<td>Employee Category</td>
					<td><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber()) && !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){ 
						WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getPositionNumber().replaceAll("-WFM",""));%>
						 <%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}%> </td>
		 
		 			<td>Employee Category</td>
					<td><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getNewPositionNumber()) && !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None"))){ 
						WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getNewPositionNumber().replaceAll("-WFM","") ); 
						if(Validator.isNotNull(wfmpo.getEmpCategory())){
						%>
				 <%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}}%> </td>
				 </tr>
				<tr>
					<td> 	Leadership Assignment	</td>
					<td> <div id="leader-assignment_print">	

					<% if(wfmsCOS !=null && Validator.isNotNull(wfmsCOS.getCurrentLeadershipAssignment())){%><%=wfmsCOS.getCurrentLeadershipAssignment()%><%} %>
					</div>		</td>
					
					<td> 	Leadership Assignment 			</td>
					
					
					
					<td> <div class="portlet-column portlet-column-last col-sm-7" id="leadershipassignment_print">
                          <% if (wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){
	                              if(wfmsCOS !=null && wfmsCOS.getSystemGenerated() == 2){
	                                  if(wfmsCOS.getLeadershipAssignment()!=null) 
	                                	  out.print(wfmsCOS.getLeadershipAssignment());
	                              } else{    out.println("None");}
                              }
                              else if(wfmsCOS.getLeadershipAssignment()!=null) 
                            	  out.println(wfmsCOS.getSameLeadership());
                              else if(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None")) 
                            	  out.println("None");
                              else    out.println("None");
		                  %>
		                 </div>
						 <div class="portlet-column portlet-column-last col-sm-7">
		                <% if(wfmsCOS==null) {%>
		                <div id="UpdatePO" name="UpdatePO">
	<div id="MgrAssNo" name="MgrAssNo">
							<div class="portlet-column portlet-column-last col-sm-7">
							  <div id="msgForAssociateNumber" class="guide_alert" style=" margin-left:17px; width: 205px;"></div>
								
									<% 	List<String> reportToLeaderShip = HMAAssociateInfoService.getLeaderShipCos();
									for (String leadership: reportToLeaderShip) { 
									%>
								  <%= leadership %>
									<% 	
										 }%>
									
								
								
								<div class="form-validator-stack help-inline" id="leadership1" style="color: #b50303; display:none;">
							      <div role="alert" class="required" >Missing required value for the field "Manager Associate Number"</div>
								</div>
							</div>
							</div>
						</div>
		                <%}else{ %>
		                <div id="UpdatePO" name="UpdatePO">
							<div id="MgrAssNo" name="MgrAssNo" <%if(wfmsCOS !=null && (wfmsCOS.getSystemGenerated() == 1 || wfmsCOS.getSystemGenerated() == 2)){ %>style="display: none;""<%} %>>
							<div class="portlet-column portlet-column-last col-sm-7">
                                                            <div id="msgForAssociateNumber" class="guide_alert" style="display:none;margin-left:-12px; width:205px; margin-bottom:7px;">Please fill Manage Associate Number</div>
								
									<% 	List<String> reportToleaderShip = HMAAssociateInfoService.getLeaderShipCos();
									for (String leadership: reportToleaderShip) {  
									%>
								  <%if(wfmsCOS.getLeadershipAssignment().equals(leadership)){ %><%= leadership %>
									<% }} %>
								
								<div class="form-validator-stack help-inline" id="leadership1" style="color: #b50303; width: 250px; display:none;">
							     <div role="alert" class="required" >Missing required value for the field &quot;Manager Associate Number &quot;</div>
								</div>
							</div>
							
							</div>
						</div>
		                <% } %>
		                <div id="leadershipassignmentnone">
		                <%if(wfmsCOS !=null && (wfmsCOS.getNewJobCode().equals("PA") || wfmsCOS.getNewJobCode().equals("TC"))){ %>
		                <%out.print("None"); %>
		                <%}else{ %>
		              <%--    <%=wfmsCOS.getLeadershipAssignment() %>
 --%>		                <%} %>
		                </div>
		                </div>	
										</td>
										
										
										
										
										
				</tr>
				 <tr>
					<td> Manager Associate Number				</td>
					<td> 	<div id="mgrassociateno_print"> <% if(Validator.isNotNull(wfmsCOS.getCurrentManagerAssocNumber())){%><%=wfmsCOS.getCurrentManagerAssocNumber()%><%} %> </div> 			</td>
					<td> Manager Associate Number  	</td>
					<td> 	 <div class="portlet-column portlet-column-last col-sm-7">
		                <div id="msgFormanagerAssociateNumber" style="display:none;">
							 <div class="guide_alert col-sm-6" style=";margin-left:3px;width:275px;">Please Select Manager Associate Number</div>
				        </div>
                         <% if(wfmsCOS!=null && wfmsCOS.getSystemGenerated() == 2){ %>           
		                 <div id="managerAssociateNumber_print">
		                       <%=wfmsCOS.getCurrentManagerAssocNumber() %>
		                 </div>
		                 <% }else{ %>
		                  <div id="managerAssociateNumber_print" <% if(wfmsCOS !=null && (wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %>  style="display:none;" <% } %>>
		                       <% if(wfmsCOS!=null) out.print(wfmsCOS.getMgrAssociateNumber()); %>
		                 </div>
		                 <% } %>
                         <div id="managerAssociatedropdown" <% if(wfmsCOS ==null || !(wfmsCOS.getNewPositionNumber().equalsIgnoreCase("None") || wfmsCOS.getNewJobCode().equalsIgnoreCase("PA") || wfmsCOS.getNewJobCode().equalsIgnoreCase("TC"))){ %> style="display:none;" <% } %>>
						   
							<%  Map<String,String> MgrAssNumberMap = HMAAssociateInfoService.getMsrAssociateNoToNewCOS();
                                                                String associatemanage="";
                                                                if(wfmsCOS!=null)
                                                                   associatemanage=wfmsCOS.getMgrAssociateNumber();
							     for(Map.Entry<String, String> entry : MgrAssNumberMap.entrySet()){ %>
				                                <%if(associatemanage.equals(entry.getKey())){ %><%=entry.getKey()%>--<%=entry.getValue()%> <%} %>
							    <% } %>
						
                                                                      <div class="form-validator-stack help-inline manageAssociate_ValidationMessage" style="display:none;">
							     Missing required value for the field "Manager Associate Number"</div>          
                         </div>
                         
		                </div>	
		                </td>
				</tr> 	

					<tr>
					<td>Manager Name </td>
					<td> <div id="mgrName_print"> <% if(Validator.isNotNull(wfmsCOS.getCurrentManagerName())){%><%=wfmsCOS.getCurrentManagerName()%><%} %> </div></td>
					<td>Manager Name </td>
					<td><div class="portlet-column portlet-column-last col-sm-7" id="ManagerAssociateName_print"><% if(wfmsCOS!=null){ if(wfmsCOS.getSystemGenerated() == 2) out.print(wfmsCOS.getCurrentManagerName()); else out.print(wfmsCOS.getNewManagerName()); } %></div></td>
				</tr>
				<tr>
					<td> Manager Title</td>
					<td> <div id="mgrTitle_print"> <% if(Validator.isNotNull(wfmsCOS.getCurrentManagerTitle())){%><%=wfmsCOS.getCurrentManagerTitle()%><%} %></div></td>
					<td>Manager Title </td>
					<td><div class="portlet-column portlet-column-last col-sm-7" id="ManagerAssociateTitle_print"> <% if(wfmsCOS!=null){ if(wfmsCOS.getSystemGenerated() == 2)  out.print(wfmsCOS.getCurrentManagerTitle()); else out.print(wfmsCOS.getNewManagerTitle()); } %></div></div> </td>
				</tr>
				<tr>
					<!-- <td>Routing Path </td>
					<td> <%if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_SUBMIT) || wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){ %> <%=wfmsCOS.getApproverList() %><%}%></td> -->
					<td> </td>
					<td> </td>
					<td>Manpower Category </td>
					<td>  <div class="portlet-column portlet-column-last col-sm-7" id="manpowerCategiry_maindiv">
		                <%if(wfmsCOS==null){ %>
							
								<%
									values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
									for(String value:values){	
								%>
									<%=value %>
								<% } %>
								
							
							<%}else{ %>
		                
							
								<%
									values = ConfigUtility.getInputValuesFromConfig("Associate-Type");
									for(String value:values){	
								%>
									<%if(wfmsCOS.getManpowerCategiry().equals(value)){ %><%=value %>
									<% }} %>
								
							
		                <%} %>
							<div class="form-validator-stack help-inline manpowerCategiry_ValidationMessage" id="manpowerCategiry_message" style="display:none;">
							     Missing required value for the field "Manpower Category"</div>
		                </div>					</td>
				</tr>
					<tr>
					<td> Next Approver </td>
					<td><%if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_SUBMIT) || wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){ %> <%=wfmsCOS.getNextApprover() %><%}%>  </td>
					<td>Manpower Rep </td>
					<td>  <%if(wfmsCOS !=null && hondamap.get("mpwrrep_name")!=null ){ %>
		                                    <div class="portlet-column portlet-column-last col-sm-7" id="ManPowerRep_print" > <% if(hondamap.get("mpwrrep_name")!=null) out.print(hondamap.get("mpwrrep_name")); %></div>
		                               <%}else if(wfmsCOS !=null ){ %>
		                                     <div class="portlet-column portlet-column-last col-sm-7" id="ManPowerRep_print"> <% if(wfmsCOS.getCurrentManpowerRep()!=null) out.print(wfmsCOS.getCurrentManpowerRep()); %></div>
		                                     <% }else{ %>
		                                     <div class="portlet-column portlet-column-last col-sm-7" id="ManPowerRep_print"></div>
		                                     <% } %> </td>
				</tr>
				<tr>
					<td> Role of approver</td>
					<td><%if(wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_SUBMIT) || wfmsCOS.getStatus().equalsIgnoreCase(HondaPermissionKeys.COS_APPROVED)){ %><%=wfmsCOS.getRoleOfApprover() %> <%}%> </td>
					
				
					<td>Notification To </td>
					<td><div class="portlet-column portlet-column-last col-sm-7"></div> </td>
				</tr>
				<%-- <tr>
					<td>Employee Category</td>
					<td><%if(wfmsCOS!=null && Validator.isNotNull(wfmsCOS.getPositionNumber())){ 
WFMS_Position wfmpo=WFMS_PositionLocalServiceUtil.getByPositionId(wfmsCOS.getPositionNumber());%>
		 <%=wfmpo.getEmpCategory()%>-<%=wfmpo.getEmpCategoryDesc()  %>  <%}%> </td></tr> --%>
				</table>
				<div style="page-break-after: always;"></div>
				<table width="100%" align="center" cellpadding="10">
				<tr>
					<td> <b>Comments : </b>
					<%=wfmsCOS.getComments() %> </td> 
				</tr>				
				
					<tr>
					<td colspan="4" class="n" ><b>Log :</b><br>
					<%if(wfmsCOS!=null) {%>	
                <div class="users col-sm-12">
                	<div class="logs_comments" style="line-height: 16px;">
			                <%List<WFMS_COS_Audit> wfms_auditlist=WFMS_COS_AuditLocalServiceUtil.findByCosIdForAudit(wfmsCOS.getCosId()); %>
			                <%for(WFMS_COS_Audit wfms_audit :wfms_auditlist){%>
			                	
			               
				               		<%=wfms_audit.getChange() %> By : <%=wfms_audit.getCreatedBy()%> - <%=HondaLogicUtil.getDateFormat(wfms_audit.getCreateDate())  %>   	<% if(wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_DISAPPROVE) || wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_CANCEL)){%>
											
											    

											
										<%}else{%> <b> , </b> &nbsp; <%}%>
				          
				               		
									<% if(wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_DISAPPROVE) || wfms_audit.getChange().equalsIgnoreCase(WorkflowConstants.CHANGE_OF_STATUS_CANCEL)){%>
											
											 	&nbsp;<b class="comment_title">Comments :</b><%=wfms_audit.getComments() %>  <b> , </b> &nbsp;

											
										<%}%>
				              
			               <%
			               }
			                %>
			               
			        </div>
	           </div>
	           <%} %>
					
	           </td> 
				</tr>
				</table>
<style>
.COSprintDraft td { padding:2px; font-family:arial;  font-size:15px;     border-bottom: #ddd 1px solid; }  
.COSprintDraft select , .COSprintDraft input { max-width:100%; width:100% }
.COSprintDraft h3 {margin:0; font-size:14px; }
.COSprintDraft li {    line-height: 35px;}
.COSprintDraft .logs_cos_comments { margin-bottom:20px; }
.COSprintDraft .logs_cos_comments li { line-height:normal; }
</style>
</body> 
</html> 
<script>

$(document).ready(function(){
	$("#<portlet:namespace/>pId").change(function(){
	if($(this).val() == "None"){
		$("#leadershipassignmentnone").show();
    	 $("#leadershipassignmentnone").html("None");
    	}else{
    	 $("#leadershipassignmentnone").html("");	
    	 $("#leadershipassignmentnone").hide();
    	 $("#UpdatePO").hide();
    	}
   }); 
	
	$("#<portlet:namespace/>newAssociateTitle").change(function(){
		if($(this).val() == "PA" || $(this).val() == "TC"){
			  $("#leadershipassignmentnone").show();
			  $("#UpdatePO").hide();
	    	  $("#leadershipassignmentnone").html("None");
	    	}else{
	    	 $("#leadershipassignmentnone").html("");
	    	 $("#leadershipassignmentnone").hide();
	    	 $("#UpdatePO").hide();
	    	}
	   });
	
	<%if(wfmsCOS !=null && (wfmsCOS.getNewJobCode().equals("PA") || wfmsCOS.getNewJobCode().equals("TC"))){ %>
		 document.getElementById("leadershipassignmentnone").style.display = "block";
		 $("#UpdatePO").hide();
    	 $("#leadershipassignmentnone").html("None");
	<%}%>	
}); 

		   <%if(wfmsCOS!=null){ %>
		  
			  function possition_print(){
 <%if(wfmsCOS.getSystemGenerated() == 2){%>
  var associaNumber=$("#<portlet:namespace/>associaNumber").val();
  AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){ 
  A.io.request('<%=AssNumURL%>',{
				 dataType: 'json', 
				 method: 'GET',   
				data: { 
		 		 <portlet:namespace />associateID: associaNumber,
					},
					 on: {    
							success: function() {
							var data=this.get('responseData');
							<% if(Validator.isNotNull(wfmsCOS.getCurrentJobCode())){%>
								$('#associateTitle_print').html("<%=wfmsCOS.getCurrentJobCode()%>");
							<%}else{ %>
									$('#associateTitle_print').html(data.ASSOCIATE_TITLE);
							<% } %>
							if(!(data.positionId === undefined || data.positionId.length <= 0)){
								$('#positionId_print').html(data.positionId);
							}
							$('#DIVISION_print').html(data.DIVISION);
							$('#DIVISION_MANAGER_print').html(data.DIVISION_MANAGER);
							$('#DEPT_NAME_print').html(data.DEPT_NAME);
							$('#DEPT_NUMBER_print').html(data.DEPT_NUMBER);
							$('#DEPT_MANAGER_print').html(data.DEPARTMENT_MANAGER);
							<%  if(Validator.isNotNull(wfmsCOS.getCurrentTeamNumber())){ %>
							$('#teamNumber_print').html("<%=wfmsCOS.getCurrentTeamNumber()%>");
							<%}else{ %>
							$('#teamNumber_print').html(data.TEAM_NUMBER);
							<% } %>
							<% if(Validator.isNotNull(wfmsCOS.getCurrentShiftCode())){ %>
							$('#shiftcode_print').html("<%=wfmsCOS.getCurrentShiftCode()%>");
							<%}else{ %> 
							$('#shiftcode_print').html(data.SHIFT_CODE);
							<% } %>
							if(data.LEADERSHIP_ASSIGNMENT == ""){
							$('#leader-assignment_print').html(data.leadershipassignment);	
							}else{
							$('#leader-assignment_print').html(data.LEADERSHIP_ASSIGNMENT);
							}
							$('#mgrassociateno_print').html(data.MANAGER_ASSOCIATE_NUMBER);
							$('#mgrName_print').html(data.DEPT_MANAGER);
							$('#mgrTitle_print').html(data.DEPT_MANAGER_TITLE);
							//----
							$('#associatedateofhire_print').html(data.ASSOCIATE_DATE_OF_HIRE);
							$('#Division_print').html(data.DIVISION);
							$('#divMgrName_print').html(data.DIVISION_MANAGER);
							$('#deptNAME_print').html(data.DEPT_NAME);
							$('#deptNumberFromPosition_print').html(data.DEPT_NUMBER);
							$('#deptManager_print').html(data.DEPARTMENT_MANAGER);
							$('#managerAssociateNumber_print').html(data.MANAGER_ASSOCIATE_NUMBER);
							$('#ManagerAssociateName_print').html(data.DEPT_MANAGER);
							$('#ManagerAssociateTitle_print').html(data.DEPT_MANAGER_TITLE);
							//$('#associatedateofhire').html(data.ASSOCIATE_DATE_OF_HIRE);
							
							$('#shiftCode_print2').html(data.SHIFT_CODE);
							$('#teamNumber_print2').html(data.TEAM_NUMBER);
			
							$('#manpowerreq').html(data.ManpowerRep);
							
							//-----------------------------------------------------------------------------------
							} 
						}
					
				});
  });
 <%}%>
			  }
		   <%}%>
		   
  		   function requition_print(){
			      var pidvalue=$("#<portlet:namespace/>pId").val();
			      	        if(pidvalue!="None"){
			                        /* }
			      	        else { */
								  <%if(wfmsCOS.getSystemGenerated() == 1){%>
			      	 AUI().use('aui-base','aui-io-request-deprecated', 'aui-node', function(A){  
			      	 A.io.request('<%=resourceURL.toString()%>',{  
			      	 dataType: 'json', 
			      	 method: 'GET',   
			      	 data:
			      	 { 
			      		 <portlet:namespace/>pidvalue: pidvalue,
			      		 <portlet:namespace/>cmd: "getPositionDetailsURL"
			      		 
			      		 },   
			      	 on: {    
			      		 	success: function() { 
			      			var data=this.get('responseData');
							$('#Division_print').html(data.division);
							$('#divMgrName_print').html(data.divMgrName);
							$('#deptNAME_print').html(data.deptName);
							$('#deptNumberFromPosition_print').html(data.deptNumber);
							$('#deptManager_print').html(data.deptManager);
			      			//---$('#deptMgrName').html(data.deptManager);
			      			$('#leadershipassignment_print').html(data.leadershipassignment);
			      			$('#managerAssociateNumber_print').html(data.managerAssociateNumber);
			      			$('#ManagerAssociateName_print').html(data.ManagerAssociateName);
			      			$('#ManagerAssociateTitle_print').html(data.ManagerAssociateTitle);
			      			$('#ManPowerRep_print').html(data.MANPOWER_REP);
							
			      			}   
			      			 }
			      		 });
			      	 });
					  <% } %>
			      	}   
		   
		   }
  setTimeout(possition_print,1500);
  setTimeout(requition_print,1700);
</script>