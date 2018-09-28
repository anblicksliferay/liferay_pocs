<%@page import="java.time.LocalDateTime"%>
<%LocalDateTime today = LocalDateTime.now(); 
System.out.println("<<<<load Start Time>>>>>>"+today); %>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.ys.hmawfm.wfms.utils.ConfigUtility"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaPermissionKeys"%>
<%@page import="java.util.Map"%>
<%@page import="com.ys.hmawfm.wfms.utils.PortletPropsPermission"%>
<%@page import="com.ys.hmawfm.wfms.utils.WMSUserAccessUtil"%>
<%@page import="com.ys.hmawfm.wfms.utils.HondaLogicUtil"%>
<%@ include file="/html/init.jsp"%>

<portlet:actionURL name="createPosition" var="createPositionsURL"></portlet:actionURL>

<%
	//HondaLogicUtil.getpositionsCOS();
	//CostCenterService centerManagerService = new CostCenterService();
	//Map<String, String > mapRest= new HashMap<String, String>();
	//String mapRest="";
	//mapRest=centerManagerService.getAllCostCenters();
	
/* 	long userId = themeDisplay.getUserId();
	long companyId = user.getCompanyId();
	String screenName = user.getScreenName(); */
	//centerManagerService.getAllCostCenters();
/* 	boolean userIsSameDepartment = false;//centerManagerService.userIsSameDepartment("VC039736"); 		//Comparision needs to be developed
	//boolean userIsSameDepartment = centerManagerService.userIsSameDepartment("GroupName"); 		//Checks the GroupName or UserName.. with Rest ServiceNow
	boolean userIsDepartmentManager = false; //REST Service Lookup needs to be developed
	boolean userIsDepartmentManpower = false; //REST Service Lookup needs to be developed
	boolean permission_add1stSet = WMSUserAccessUtil.doesUserHaveAccess(user, companyId, "position",
			"add2ndSet", userIsSameDepartment, userIsDepartmentManager, userIsDepartmentManpower); */
	
	String[] values = null;
			
	// popUp for Internet connection down 
	Map<String,String> deptMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
%>

<c:set var="ADD_RS_1" value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,PortletPropsPermission.POS_RS1,null)%>" />
<%-- <c:set var="ADD_RS_2" value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,PortletPropsPermission.POS_RS2,null)%>" />
 <c:set var="ADD_RS_3" value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,PortletPropsPermission.POS_RS3,null)%>" />
<c:set var="APPROVE_DATA" value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,HondaPermissionKeys.APPROVE_DATA,null)%>" />
<c:set var="DIS_APPROVE_DATA" value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,HondaPermissionKeys.DIS_APPROVE_DATA,null)%>" />
<c:set var="CRT_POS" value="<%=WMSUserAccessUtil.checkPermissionForPosition(renderRequest,HondaPermissionKeys.CRT_POS,null)%>" />--%>

<aui:form action="<%=createPositionsURL.toString()%>" method="post" id="createPosition" name="createPosition">

	<div class="portlet-layout">
		<h2 class="titleArea">Create&nbsp;Position</h2>
	</div>
	
    <div class="portlet-layout">
		<div class="col-sm-12">
			<div class="wfm-system">
			<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4">
						<span class="sectionLabel">Position #</span>
					</div>
					<div class="portlet-column portlet-column-last col-sm-8 position-number-value"></div>
			</div>			
			</div>
		</div>
		<div class="portlet-layout">
			<div class="col-sm-12">
				<div class="wfm-system">
				<div class="portlet-layout row">
						<div class="portlet-column portlet-column-first col-sm-4">
							<span class="sectionLabel">Status</span>
						</div>
						<div class="portlet-column portlet-column-last col-sm-8">
								<%=HondaPermissionKeys.POS_DRAFT %>
						</div>
				</div>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="portlet-layout row own-top">
				<div class="portlet-column portlet-column-first col-sm-6"
					style="padding-left: 3px;">
					<div class="wfm-system">
						<div style="display: none">
							<button class="btn btn-primary" type="button" value="">Copy
								Position</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="portlet-layout">
			<div class="col-sm-12 own-wrapper">
				<div class="wfm-system">
					<div class="portlet-layout">
						<div class="portlet-column portlet-column-first">
                                    <div class="small center">
                                            <div class="col-sm-4">
                                                  <button type="button" class="btn btn-primary" onclick="redirectExit();">Exit
                                                            View</button>
                                                  <aui:input type="hidden" name="auto-gen-req-choice" />
                                            </div>
                                            <div class="col-sm-4">
                                            	  <aui:input name="createPositionValue" type="hidden"></aui:input>
	                                              <aui:button cssClass="btn btn-primary" type="button" id="btn-action-submit" onClick="validateForm('submit');" value="Submit"></aui:button>
                                            </div>
				                            <div class="col-sm-4">
					                              <aui:input name="genPosition" type="hidden" ></aui:input>
												  <aui:button type="button" cssClass="btn btn-primary" id="btn-action-save" onClick="validateForm('save');" value="Save"></aui:button>
											</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		</div>

		<div class="col-sm-12">
			<div class="wfm-system" style="margin-top: 20px;">
				<div class="portlet-layout row">
				
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Department
						Number</div>

					<div id="Deptid_mainDiv" class="portlet-column portlet-column-last col-sm-3">
					
						<aui:select disabled="${not ADD_RS_1}" name="Deptid" id="divdeptRest" cssClass="field-select chosen" placeholder="" label="" onChange="updateValuesForSelectedDepartment()" style= "width: 100%;">
							
							    <aui:option value=''>Select Department Number</aui:option>
							<% 
								Map<String,String> departmentNumberMap = HondaLogicUtil.getDeptAbbrevationDetailsforPosition();
							  
							 for(Map.Entry<String, String> entry : departmentNumberMap.entrySet()){
							 if(!entry.getValue().equals("")){
							 %>
				                  <aui:option value="<%=entry.getKey() %>"><%=entry.getKey()%>-<%=entry.getValue()%></aui:option>
									<%}} %>
						</aui:select>
                        <div class="Deptid_ValidationMessage form-validator-stack help-inline" style="display: none;">
                   			           Missing required value for the field "Department Number"</div>
					</div>
				</div>
				
				<div class="portlet-layout row">
					<div
						class="portlet-column portlet-column-first col-sm-4 sectionLabel "
						class="">Division</div>

					<div class="portlet-column portlet-column-last col-sm-8 sectionLabel"
						id="Division"></div>
				</div>
<div style="position: relative; top: -34px;"> <img  src="<%= request.getContextPath()%>/images/ajax-loader.gif"  id="img" alt="Please wait a moment.."  style="display:none" /></div>
			
				
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel"
						class="">Department Name</div>

					<div class="portlet-column portlet-column-last col-sm-8 sectionLabel"
						id="DEPT_NAME" >     </div>
                                    <div class="col-sm-4"></div>
                                    <div class="departmentname_ValidationMessage form-required col-sm-8" style="display: none;">Department Name less than three characters is invalid - Please contact System Admin</div>
     
				</div>

<div class="portlet-layout row">
    <div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">MP Category Budget</div>

    <div id="mpCatBudget_mainDiv" class="portlet-column portlet-column-last col-sm-3">
            <aui:select name="mpCatBudget" id="mpCatBudget" class="field-select" onchange="mpCatBudgetvalidate();"
                        placeholder="" label="" disabled="${not ADD_RS_1}" >
                <aui:option value="">Select MP Category Budget</aui:option>

                <%
                        values = ConfigUtility.getInputValuesFromConfig("position-mpcategorybudgeted");
          Arrays.sort(values);
                for (String value : values) {
                %>
                <aui:option value="<%=value%>"><%=value%></aui:option>
                <%
                        }
                %> 
            </aui:select>
            <div class="mpCatBudget_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                Missing required value for the field "MP Category Budget"
            </div>
    </div>
</div>

<%-- </c:if>	 --%>
				
				
<%-- <c:if test="${ADD_RS_2}"> --%>
			
				
<%-- <c:if test="${ADD_RS_1}"> --%>
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Position Class</div>

					<div class="portlet-column portlet-column-last col-sm-8" id="positionClass_mainDiv">
						<%
							values = ConfigUtility.getInputValuesFromConfig("position-class");
								for (String value : values) {
						%>
						<div class='col-sm-2 owncheck'>

							<aui:input checked="" inlineLabel="right" onchange="datevalidation();"
								name="positionClass" onclick="positionClassvalidate();"  id="positionClass"  type="radio" value='<%=value%>'
								label="<%=value%>" disabled="${not ADD_RS_1}">
							</aui:input>	
						</div>
						<%
							}
						%>
					</div>
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<div class="positionClass_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none; color: #b50303; margin-top: 0;">
	                            Missing required value for the field "Position Class"
	                    </div>
                   	</div>
				</div>				
<%-- </c:if> --%>
<%-- <c:if test="${ADD_RS_2}"> --%>
				
				
				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Year
						Established</div>

					<div class="portlet-column portlet-column-last col-sm-3">
                                            <div class="" id="yearEst_mainDiv">
                                <aui:input name="yearEst" onkeyup="yearEstvalidate();" id="yearEst" type="text" label="" maxLength="75" disabled="${not ADD_RS_1}">
                                </aui:input>
                                <div class="yearEst_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                                    Missing required value for the field "Year Established"
                                </div>
                                            </div>
					</div>
				</div>

				<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Reason for addition or change</div>

					<div id="reasonchange_mainDiv" class="portlet-column portlet-column-last col-sm-6">
						<aui:input type="textarea" onkeyup="reasonchangevalidate();" name="reasonchange" id="reasonchange" label="" cols="55" placeholder="Reasons" rows="10"
							 maxLength="250" disabled="${not ADD_RS_1}">
							</aui:input>
                                            <div class="reasonchange_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                                                Missing required value for the field "Reason for addition or changes"</div>

					</div>
				</div>
				
						
			

<div class="portlet-layout row">
					<div class="portlet-column portlet-column-first col-sm-4 sectionLabel ">Position Re-evaluation date</div>

					<div class="portlet-column portlet-column-last col-sm-3 startDt">										
										<div id="startDate_mainDiv">
										
										<aui:input name="reevaluationDate" label="" id="startDate"
												maxlength="70" title="Click Here" onkeyup="datevalidation();"
												placeholder="MM/DD/YYYY" 
												disabled="${not ADD_RS_1}">
												</aui:input>
												
											<!-- 	<aui:input name="reevaluationDate" label="" id="startDate"
												maxlength="70" title="Click Here" readOnly="true"
												placeholder="MM/DD/YYYY" cssClass="datepicker"
												errorMessageDivId="startDateErrorDiv"
												onFocus="clearErrorMessage('startDateErrorDiv');"
												onClick="clearErrorMessage('startDateErrorDiv');" disabled="${not ADD_RS_1}">
												</aui:input> -->
                                  <div class="startDate_ValidationMessage form-validator-stack help-inline customErroeClass" style="display: none;">
                                      Missing required value for the field "Position Re-evaluation date".
                                   </div>
									</div>
							</div>
                                                                                                 <div style="display: none;">
					  <aui:input type="textarea" name="hidden_field" label="" required="true" disabled="${not ADD_RS_1}"> </aui:input>
                                          <aui:input type="textarea" name="validation_type" label="" value="0" disabled="${not ADD_RS_1}"> </aui:input>

									          </div>
				</div>
					
				<div class="scroll_back_to_top">
				<a href="#" class="icon-chevron-up" id="back-to-top" title="Back to Top"> <div class="top-scroll-sec">Back to Top</div></a>
				
				</div>
				</div>
			</div>

		</div>
</aui:form>

	<% if(deptMap.isEmpty()) {
		String currentURL = PortalUtil.getCurrentURL(request);
		if(currentURL.contains("?")){
			currentURL = currentURL.split("\\?")[0];
		}
		 %>
		<br>
<aui:script>
  
  $( document ).ready(function() {
	
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
	});
 
		</aui:script>
	<br>
	<%} %>


<script>
function redirectExit(){
	window.location.href = 'position';
}
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
     $(document).ready( function(){
    
     });
    
   
     function datevalidation(){
    	// alert("date insert  123");
      var type=$("#<portlet:namespace/>validation_type").val();
            var reEvaluationDate=$("#<portlet:namespace/>startDate").val();
			var A=new AUI();
			
			
			if($('[name=<portlet:namespace/>positionClass]:checked').length>0){
				var checkBoxValue=A.one("input[name=<portlet:namespace/>positionClass]:checked").get("value");
			if( checkBoxValue.trim()=="Temporary"){
                       if(reEvaluationDate=='' && type==1){
				    $(".startDate_ValidationMessage").show();
                                     $('#startDate_mainDiv').addClass('control-group error');
			         $('#<portlet:namespace/>hidden_field').val('');
				} 
			   else {
				   $(".startDate_ValidationMessage").hide();
                                   $('#startDate_mainDiv').removeClass('control-group error');
			     }
		     } else {
				   $(".startDate_ValidationMessage").hide();
                   $('#startDate_mainDiv').removeClass('control-group error');
				}
			
			
			}
			 else {
				   $(".startDate_ValidationMessage").hide();
                                 $('#startDate_mainDiv').removeClass('control-group error');
			   }
		}
	function mpCatBudgetvalidate(){
        var type=$("#<portlet:namespace/>validation_type").val();
		 var val=$("#<portlet:namespace />mpCatBudget");
		 if(val.val()=='' && type==1){
			$(".mpCatBudget_ValidationMessage").show();
                        $('#mpCatBudget_mainDiv').addClass('control-group error');
			$('#<portlet:namespace/>hidden_field').val(''); 
			//val.focus();
		}
		else{
                     $('#mpCatBudget_mainDiv').removeClass('control-group error');
                     $(".mpCatBudget_ValidationMessage").hide();
		}
	}
	
	function Deptidvalidate(){
		var val=document.getElementById("<portlet:namespace />divdeptRest").value;
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
		var val=$("#<portlet:namespace />yearEst").val();
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
        function reasonchangevalidate(){
         var type=$("#<portlet:namespace/>validation_type").val();
		var val=$("#<portlet:namespace />reasonchange").val();
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
        
        
        function positionClassvalidate(){
        	//alert("positionclass new script");
            var type=$("#<portlet:namespace/>validation_type").val();
                       //var val=$("#<portlet:namespace />positionClass").val();
                      // alert($('[name=<portlet:namespace/>positionClass]:checked').length );
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
	
	function updateValuesForSelectedDepartment(){
                 Deptidvalidate();
		console.log("loadDivsionNames: called");
		var Deptid=$("#<portlet:namespace/>divdeptRest").val();
		//console.log("loadDivsionNames: Deptid "+Deptid);
		$('#Division').html("");
		$('#DEPT_NAME').html("");
                if(Deptid!=''){
		 $('#img').show();
	    $.ajax({
	    		url : '<%=resourceURL.toString()%>',
				data : {
					<portlet:namespace />Deptid : Deptid,
					<portlet:namespace />cmd : 'LoadDivisionNames'
				},
	
				type : "POST",
				dataType : "json",
				success : function(data) {
					
					//console.log(data);
					$('#Division').html(data.Division);
					$('#DEPT_NAME').html(data.DEPT_NAME);
					$('#img').hide();
					if(data.DEPT_NAME=="" || data.DEPT_NAME.length <3 ){
						 $(".departmentname_ValidationMessage").show();
						 document.getElementById('<portlet:namespace/>hidden_field').value=''; 
					}else{
						  $(".departmentname_ValidationMessage").hide();
					}
				},
				error : function(response) {
		        	console.log("Error seen for for loadDivisonDepName");
					$('#img').hide();
				}
			});
                    }
		}
	function validateForm(value) {
	checkServiceNowIsDownPoPup();
            $('#<portlet:namespace/>hidden_field').val('1');
            
              if(value == "submit"){
                 $("#<portlet:namespace/>validation_type").val(1);
              }
              else if(value == "save"){
                 $("#<portlet:namespace/>validation_type").val(0);
              }
                 Deptidvalidate();
		         mpCatBudgetvalidate();
                 yearEstvalidate();
                 reasonchangevalidate();
                 datevalidation();
                positionClassvalidate();
        var hiddenval=$('#<portlet:namespace/>hidden_field').val();
	  if (hiddenval!='') {
	      $('#showValidations').modal('hide');
			$("button[type=button]").attr('disabled',true); 
			$("#<portlet:namespace/>createPositionValue").val(value);
		$("#<portlet:namespace/>createPosition").submit();
	  }		
	  else{
	    $('#showValidations').modal({ backdrop: 'static',
                        keyboard: true, 
                        show: true});
	  	}
	}
    $(".chosen-select").chosen({});

jQuery(document).ready(function(){ 
jQuery(".chosen").data("placeholder","Select Frameworks...").chosen({search_contains:true});
});

 /*YUI({ lang: 'en' }).use(
		   'aui-datepicker-deprecated',
		   function(Y) {
			   var today=new Date();
		     var datepicker = new Y.DatePicker(
		       {
		          trigger: '#<portlet:namespace />startDate',
		         mask: '%m/%d/%Y',
		         calendar: {
		         	
		        	   minimumDate: new Date(today.getTime() + (1000 * 60 * 60 * 24))
		        	//maximumDate:  new Date(today.getTime() + (1000 * 60 * 60 * 120)),

		        	},
		        	on: {
		                selectionChange: function(event) {
				    $(".startDate_ValidationMessage").hide();
                                   $('#startDate_mainDiv').removeClass('control-group error');
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
		                      datevalidation();
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
		 );*/
		 
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
		        	console.log("Error seen for for checkServiceNowIsDownPoPup");
					
				}
		});
}
 </aui:script>
 <!-- <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Modal header</h3>
    </div>
    <div class="modal-body">
        <p>One fine body…</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
        <button class="btn btn-primary">Save changes</button>
    </div>
</div>
 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> -->
<div class="modal fade" id="showValidations" style="display:none">
	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id="moveAssociateFormclose" class="close"
						data-dismiss="modal">&times;</button>
					
				</div>
				<div class="modal-body">
					<div class="control-group error">
					   <h4 class="modal-title help-inline">Please fill the following required fields</h4>
						<ul class="popup-validation-messages">
						    <li class="Deptid_ValidationMessage col-sm-12 help-inline" style="display: none;">Department Number</li>
	                   		<li class="departmentname_ValidationMessage col-sm-12 help-inline" style="display: none;">
	                   			           Department Name less than three characters is invalid - Please contact System Admin</li>
	                   		<li class="mpCatBudget_ValidationMessage col-sm-12 help-inline" style="display: none;">MP Category Budget</li>
	                   		<li class="positionClass_ValidationMessage col-sm-12 help-inline" style="display: none;">Position Class</li>
	                        <li class="yearEst_ValidationMessage col-sm-12 help-inline" style="display: none;">Year Established</li>
	                        <li class="reasonchange_ValidationMessage col-sm-12 help-inline" style="display: none;">Reason for addition or changes</li>
	                        <li type="square" class="startDate_ValidationMessage col-sm-12 help-inline" style="display: none;">Position Re-evaluation date</li>
	                      </ul>
					</div>
					
				</div>
				<div class="modal-footer" style="margin-top: 30px;">
						<div class="col-sm-2">
							<button type="button" class="btn btn-default" data-dismiss="modal" id="move_associate_close">Close</button>
						</div>
					</div>
			</div>
	</div>
</div>
<%LocalDateTime today1 = LocalDateTime.now(); 
System.out.println("<<<<load End Time>>>>>>"+today1); %>
