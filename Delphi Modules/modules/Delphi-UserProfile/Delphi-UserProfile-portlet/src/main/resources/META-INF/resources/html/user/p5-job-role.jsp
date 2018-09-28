<div class="wrapper">
	<div class="header row">
		<div class="col-xs-12">
			<h2 class="mfg-portlet-title">
				<liferay-ui:message key="Delphi-UserProfile-portlet.Job-Role-Portal-Role" />
				<i class="fa fa-caret-down" aria-hidden="true"></i>
			</h2>
		</div>
	</div>
	
	<div class="content jobrole" style="display: none;">
		<div class="row mb-20">
			<div class="col-sm-6">
				<div class="row">
					<div class="col-xs-8">
						<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Job-Role-Select-One" /></h3>
					</div>
					<div class="col-xs-4">
						<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Request-Access-Authorized" /></h4>
					</div>
				</div>
				<div class="row detailItem">
					<div class="col-sm-8">
						<input type="radio" data-relation="Not Yet Defined" name="jobRoleSelect" value="Not Yet Defined" checked="checked"> <liferay-ui:message key="Delphi-UserProfile-portlet.Not-Yet-Defined" />
					</div>
					<div class="col-sm-4">
					</div>
				</div>
				<div class="row detailItem">
					<div class="col-sm-8">
						<input type="radio" data-relation="Technician" name="jobRoleSelect" value="Technician"> <liferay-ui:message key="Delphi-UserProfile-portlet.Technician" />
					</div>
					<div class="col-sm-4">
					</div>
				</div>
				<div class="row detailItem">
					<div class="col-sm-8">
						<input type="radio" data-relation="Engineer" name="jobRoleSelect" value="Engineer"> <liferay-ui:message key="Delphi-UserProfile-portlet.Engineer" />
					</div>
					<div class="col-sm-4">
					</div>
				</div>
				<div class="row detailItem">
					<div class="col-xs-8">
						<input type="radio" data-relation="Supervisor" name="jobRoleSelect" value="Supervisor" disabled> <liferay-ui:message key="Delphi-UserProfile-portlet.Supervisor" />
					</div>
					<div class="col-xs-4">
						<i class="fa fa-square-o active sa-all access-option" data-name="Supervisor"></i>
					</div>
				</div>
				<div class="row detailItem">
					<div class="col-xs-8">
						<input type="radio" data-relation="Operations Manager" name="jobRoleSelect" value="Operations Manager" disabled> <liferay-ui:message key="Delphi-UserProfile-portlet.Operations-Manager" />
					</div>
					<div class="col-xs-4">
						<i class="fa fa-square-o active sa-all access-option" data-name="Operations Manager"></i>
					</div>
				</div>
				<div class="row detailItem">
					<div class="col-xs-8">
						<input type="radio" data-relation="Plant Manager" name="jobRoleSelect" value="Plant Manager" disabled> <liferay-ui:message key="Delphi-UserProfile-portlet.Plant-Manager" />
					</div>
					<div class="col-xs-4">
						<i class="fa fa-square-o active sa-all access-option" data-name="Plant Manager"></i>
					</div>
				</div>
			</div>
			
			<div class="col-sm-6 whitebox mt-10">
				<div class="row">
					<div class="col-xm-12">
						<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Authorization" /></h4>
						<div class="col-sm-6 mb-10">
							<i class="fa fa-square-o"></i>
							<span><liferay-ui:message key="Delphi-UserProfile-portlet.not-authorized" /><br/>
							<liferay-ui:message key="Delphi-UserProfile-portlet.no-requests" /></span>
						</div>
						<div class="col-sm-6 mb-10">
							<i class="fa fa-check-square"></i>
							<span><liferay-ui:message key="Delphi-UserProfile-portlet.authorized" /></span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 mb-10">
						<i class="fa fa-commenting-o"></i>
						<span><liferay-ui:message key="Delphi-UserProfile-portlet.access-requested" /></span>
					</div>
					<div class="col-sm-6">
						<i class="fa fa-minus-square"></i>
						<span><liferay-ui:message key="Delphi-UserProfile-portlet.access-denied" /></span>
					</div>
				</div>
			</div>
		</div>
		<div class="row detailItem">
			<div class="col-xs-12">
				<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Portal-Role" /></h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="row detailItem">
					<div class="col-xs-10 col-sm-6">
						<h4><input type="checkbox" data-relation="Delphi Admin" name="DelphiAdminCheck" value="Delphi Admin" disabled/> <liferay-ui:message key="Delphi-UserProfile-portlet.Administrator" /></h4>
						<liferay-ui:message key="Delphi-UserProfile-portlet.restricted-job-roles" /><br>
						<span style="color: red;"><liferay-ui:message key="Delphi-UserProfile-portlet.view-all-alerts" /></span>
					</div>
					<div class="col-xs-2 col-sm-6">
						<i class="fa fa-square-o active sa-only access-option" data-name="Delphi Admin"></i>
					</div>
				</div>
				<div class="row detailItem">
					<div class="col-xs-10 col-sm-6">
						<h4><input type="checkbox" data-relation="Delphi Super Admin" name="DelphiSuperAdminCheck" value="Delphi Super Admin" disabled/> <liferay-ui:message key="Delphi-UserProfile-portlet.Super-Administrator" /></h4>
						<liferay-ui:message key="Delphi-UserProfile-portlet.Administrator-authorities" />
					</div>
					<div class="col-xs-2 col-sm-6">
						<i class="fa fa-square-o active sa-only access-option" data-name="Delphi Super Admin"></i>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	var preferenceJobRole = <%= preferenceJobRole %>;
	console.log(preferenceJobRole); 
	for (var key in preferenceJobRole) {
		console.log("key <portlet:namespace />"+ " debug " + key+" preferenceJobRole[key]:"+preferenceJobRole[key]);
		if(preferenceJobRole[key]) {
//			$(".portlet-boundary<portlet:namespace /> .jobrole").css("background-color", "yellow");
			$(".portlet-boundary<portlet:namespace /> .jobrole input[type='radio'][data-relation='"+preferenceJobRole[key]+"']").attr('checked', true);
		}
	}

	<% if( themeDisplay.isImpersonated() && userIsDelphiSuperAdmin ){ %>
	
		$(".portlet-boundary<portlet:namespace /> .jobrole .access-option").off("click").on("click",function(){
	
			var context = {};
			context.requestSection = "jobrole";
			context.requestAccessName = $(this).data("name");

			if($(this).hasClass("fa-square-o") || $(this).hasClass("fa-commenting-o") ){
				context.requestAccessValue = "Grant";
			} else if($(this).hasClass("fa-check-square")){
				context.requestAccessValue = "Deny";
			}else if($(this).hasClass("fa-minus-square")){
				context.requestAccessValue = "Clear";
			}
			
			$(this).removeClass("fa-square-o").removeClass("fa-check-square").removeClass("fa-minus-square")
					.addClass("fa-refresh").addClass("fa-spin");
			
			
			storeValues(context, "adminAccessCommand");
		});
	
	<% } if( themeDisplay.isImpersonated() ){ %>
	
		$(".portlet-boundary<portlet:namespace /> .jobrole .sa-all.access-option").off("click").on("click",function(){
		
			var context = {};
			context.requestSection = "jobrole";
			context.requestAccessName = $(this).data("name");
			
			if($(this).hasClass("fa-square-o") || $(this).hasClass("fa-commenting-o") ){
				context.requestAccessValue = "Grant";
			} else if($(this).hasClass("fa-check-square")){
				context.requestAccessValue = "Deny";
			}else if($(this).hasClass("fa-minus-square")){
				context.requestAccessValue = "Clear";
			}
			
			$(this).removeClass("fa-square-o").removeClass("fa-check-square").removeClass("fa-minus-square")
					.addClass("fa-refresh").addClass("fa-spin");
			
			storeValues(context, "adminAccessCommand");
		});
	
	<% } else { %>
	
		$(".portlet-boundary<portlet:namespace /> .jobrole .fa-square-o.active").off("click").on("click",function(){
			$(this).off("click").removeClass("fa-square-o").removeClass("active").addClass("fa-refresh").addClass("fa-spin");
			
			var context = {};
			context.requestSection = "jobrole";
			context.requestAccessName = $(this).data("name");
			
			storeValues(context, "accessRequest");
		});
	
	<% } %>

	$(".portlet-boundary<portlet:namespace /> .jobrole input").off("change").on("change",function(){
		
		var context = {};
		
		$(".portlet-boundary<portlet:namespace /> .jobrole input[type='radio']").each(function(){
			var valName = $(this).attr("name").replace("<portlet:namespace />","");
			if($(this).is(":checked")){
				context[ valName ] = $(this).val();
			}
		});
		
		storeValues(context, "jobrole");
	});
	
</script>