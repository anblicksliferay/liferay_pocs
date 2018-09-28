<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>

<liferay-theme:defineObjects />
<liferay-frontend:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<%
	String userProfilePortlets = (String)renderRequest.getAttribute("userProfilePortlets");
%>
	
<script>

	var bannerCheckInterval = setInterval(bannerCheck, 30000);
	var userProfilePortlets = <%= userProfilePortlets %>;
	var debug = true;

	var renderBanner = function(msg){
			
		var showAlert = msg.showAlert;
		var alertMessage = msg.messageText;
		var alertColor = msg.messageColor;
	
		$('.system-message.alert.alert-warn').remove();
		if(showAlert){
			$('html .has-control-menu #wrapper').prepend("<div class='system-message alert alert-warn "+alertColor+"' id='bannerTheme'><b>Alert:</b> "+alertMessage+"</div>");
		}else
			$('html .has-control-menu #wrapper').addClass('mt-48');
	}
		
	$('.portlet-language .portlet-body img').each(function(){
		if(!$(this).parent().is('a')){
			$(this).parent().addClass('selected');
		};
	});
	
	for(key in userProfilePortlets){
		if(key!="defaultPage"){

			$("#side-menu > li.li-display > a").each(function(){
			
				if($(this).attr("href").indexOf(key)>-1){
					
					if(!userProfilePortlets[key]){
						$(this).parent().hide();
					}
				}
				
			});
			
		}
	}
	
	if("Loading"=="<%=themeDisplay.getLayout().getName("en_US")%>"){
		if(userProfilePortlets["defaultPage"]){
			location.href = userProfilePortlets["defaultPage"];
		}else{
			location.href = "/group/delphi/welcome";
		}
	}
	
	function bannerCheck(){
		context = {};
		checkForBannerUpdate('banner', '', context);
	}
	
	bannerCheck();
	
	function checkForBannerUpdate(cmd, cmdType, context){
		
		if(debug) console.log("checkForBannerUpdate: "+cmdType+":"+context);
		
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
				renderBanner(data);
			},
			error : function(response) {
				console.log("Error seen for "+cmd+" Update Response");
			}
		});
	}  
	
</script>