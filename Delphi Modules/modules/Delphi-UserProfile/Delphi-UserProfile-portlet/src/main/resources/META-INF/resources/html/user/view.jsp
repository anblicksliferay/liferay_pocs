<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/html/init.jsp" %>
<%
String userId = PortalUtil.getOriginalServletRequest(request).getParameter("userId");
if( userId == null ) userId = "";
if(themeDisplay.isSignedIn()){ %>

	<%@ include file="/html/user/p1-name.jsp" %>
	
	<%@ include file="/html/user/p2-contact-info.jsp" %>
	
	<%@ include file="/html/user/p3-location.jsp" %>
	
	<%@ include file="/html/user/p4-work-hours.jsp" %>
	
	<%@ include file="/html/user/p5-job-role.jsp" %>
	
	<%@ include file="/html/user/p6-activities.jsp" %>
	
	<%@ include file="/html/user/p7-portlets.jsp" %>

<% }else{ %>
  
	<div><i>Sign in to access your profile</a></i></div>
  
<% } %>


<% if( themeDisplay.isImpersonated() ){ %>
	<style>
		.access-option{
			cursor:pointer;
		}
	</style>
<% } %>

<script>
	//var userId= "<%=userId.trim()%>"; 
	//console.log(userId+ "   user Id from Admin ");
	var requestStatuses = <%=requestStatuses%>;
	var editMode = <%= themeDisplay.isImpersonated() %>;

	function initUserProfile(){
		$(".portlet-boundary<portlet:namespace /> .header").on("click",function(){
			if($(this).hasClass("open")){
				$(this).removeClass("open").find(".fa").removeClass("rotate");
				$(this).parent().find(".content").removeClass("open").slideUp(500);
			}else {
				$(this).addClass("open").find(".fa").addClass("rotate");
				$(this).parent().find(".content").addClass("open").slideDown(500);
			}
		});
	}
	
	function applyRequestStatus(editMode){
		for (key in requestStatuses){
			
			targets = key.split("-");
			
			if(targets[1]=="" || targets[0]=="") continue;

			var element = $("."+targets[0]+" i[data-name='"+targets[1]+"']");
			element.removeClass("fa-square-o").removeClass("active");
			
			if(!editMode) element.off("click");
			
			if(requestStatuses[key]=="grant"){
				element.addClass("fa-check-square");

				$("."+targets[0]+" input[type='checkbox'][data-relation='"+targets[1]+"']").attr("checked","checked");
				$("."+targets[0]+" input[type='radio'][data-relation='"+targets[1]+"']").removeAttr('disabled');

			}else if(requestStatuses[key]=="deny"){
				element.addClass("fa-minus-square");
				if(targets[1]=="Revenue & Expense"){
					if($("input[name='Revenue & Expense']").is(":checked")){
						updatePortletOptions();
					}
					$("#Revenue_Expense_defaultPage").prop('disabled', true);
					$("input[name='Revenue & Expense']").prop('disabled', true);
				}
			}else if(requestStatuses[key]=="clear"){
				//Nothing to do
				element.addClass("fa-square-o");
			}else{
				element.addClass("fa-commenting-o");
			}
		}
	}
function updatePortletOptions(){
	$("input[name='Revenue & Expense']").prop('checked', false);
	$("#Revenue_Expense_defaultPage").prop('checked', false);
    var context = {};
	$(".portlets input[type='radio']").each(function(){
		if($(this).is(":checked")){
			var valName = $(this).attr("name").replace("<portlet:namespace />","");
			context[ valName ] = $(this).attr("data-value");
		}
	});
	$(".portlet-boundary<portlet:namespace /> .portlets input[type='checkbox']").each(function(){
		if($(this).attr("name")){
			var valName = $(this).val();
			context[ valName ] = $(this).is(":checked");
		}
	});
	storeValues(context, "portlets");
	//location.reload();
}
	function storeValues(values, section){
		
		var cmd = section;
		var cmdType= 'update';
		var context = values;		
		
		$.ajax({  
			url : '<%=resourceURL.toString()%>',
			data : {
				<portlet:namespace />cmd: cmd,
				<portlet:namespace />cmdType: cmdType,
				<portlet:namespace />context: JSON.stringify(context)
			},

			type : "POST",
			dataType : "json",
			success : function(data) {
				//console.log("stored values "+values+","+ section);
				console.log(data);
				
				if(!data.msg){
					console.log("Error seen for "+cmd+" Update Response");
				} else if(data.msg=="accessRequest returned"){
					returnListenerAccessRequest(data);
				} else if(data.msg=="Admin accessRequest returned"){
					returnAdminAccessCommand(data);
				} else if(data.msg.indexOf("user language changed")>-1){
					var langaugeChangedMessage = data.msg.split("|");
					var languageChangedURL = $("#userLocationChangeURL").text();
					//TODO Language Changing Warning - Example LocalSpinner
					
					location.href=languageChangedURL+langaugeChangedMessage[1];
				}
			},
			error : function(response) {
				console.log("Error seen for "+cmd+" Update Response");
			}
		});
	}
	
	function returnAdminAccessCommand(data){
		var control = $(".portlet-boundary<portlet:namespace /> ." + data.accessRequestSection + " i[data-name='"+data.requestAccessName+"']");
		control.removeClass("fa-refresh");
		control.removeClass("fa-spin");

		if(data.requestAccessValue=="Grant"){
			control.addClass("fa-check-square");
		}else if(data.requestAccessValue=="Deny"){
			control.addClass("fa-minus-square");
		}else if(data.requestAccessValue=="Clear"){
			control.addClass("fa-square-o");
		}
	}
	
	function returnListenerAccessRequest(data){
		var control = $(".portlet-boundary<portlet:namespace /> ." + data.accessRequestSection + " i[data-name='"+data.requestAccessName+"']");
		control.removeClass("fa-refresh");
		control.removeClass("fa-spin");
		control.addClass("fa-commenting-o");
	}
	
	initUserProfile();
	applyRequestStatus(editMode);

</script>