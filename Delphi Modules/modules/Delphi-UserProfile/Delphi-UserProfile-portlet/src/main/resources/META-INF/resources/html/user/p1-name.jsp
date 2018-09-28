<div class="wrapper">
	<div class="headerStatic row">
	
		<div class="col-xs-6">
			<h2 class="mfg-portlet-title">
			<% if(themeDisplay.isImpersonated()){ %><i><liferay-ui:message key="Delphi-UserProfile-portlet.Editing-As" /></i> <% } %>
			${user.getFirstName()} ${user.getLastName()}
			</h2>
		</div>
		
		<div class="col-xs-6">
			<% if(themeDisplay.isImpersonated()){ %>
				<button class="mt-10 right" 
					onclick="location.href='/group/delphi/admin-tasks';">
					<liferay-ui:message key="Delphi-UserProfile-portlet.Return-Admin" />
				</button>
			<% } %>
		</div>
		
	</div>
</div>