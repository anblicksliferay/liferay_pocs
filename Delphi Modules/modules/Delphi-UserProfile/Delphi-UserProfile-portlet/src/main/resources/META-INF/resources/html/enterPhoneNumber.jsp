<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div class="portlet-layout row-fluid">
	<div class="span6">
   		
		<form name="savePhoneNumber" action="#" method="get">
			 <% 
				List<Phone> phones = user.getPhones(); 
				String primaryPhoneNumber = "";
				
				for(Phone phone:phones){
					if(phone.isPrimary()) primaryPhoneNumber = phone.getNumber();
				}
			
				if(primaryPhoneNumber.equals("")){
			%>
				<span class="alert alert-warn"><liferay-ui:message key="Delphi-UserProfile-portlet.no-phone" /></span>
			
			<%}%>
			
			<span><liferay-ui:message key="Delphi-UserProfile-portlet.country-code" /><br/>
			<i><liferay-ui:message key="Delphi-UserProfile-portlet.examples" /></i></span>
			
		   	<br/><br/>
		   	
		   	<input type="text" name="primaryPhoneNumber" id="primaryPhoneNumber" label="Primary Phone Number" value="<%=primaryPhoneNumber%>"/>
				
		    <button class="btn btn-primary" type="button" onclick="storePhoneNumber($('#primaryPhoneNumber').val())"><liferay-ui:message key="Delphi-UserProfile-portlet.submit" /></button>
		   
    	</form>
	</div>
</div>