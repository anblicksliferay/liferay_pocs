<div class="wrapper">
	<div class="header row">
		<div class="col-xs-12">
			<h2 class="mfg-portlet-title">
				<liferay-ui:message key="Delphi-UserProfile-portlet.Pages" />
				<i class="fa fa-caret-down" aria-hidden="true"></i>
			</h2>
		</div>
	</div>
	
	<div class="content portlets" style="display: none;">
		<div class="row">
			<div class="col-sm-6"></div>
			<div class="col-sm-6 whitebox mt-10 mb-10">
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
		
		<!-- <span style="color: red;"><liferay-ui:message key="Delphi-UserProfile-portlet.Coming-Soon" /></span> -->
		
		<div class="row">
			<div class="col-xs-2">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Default-Startup-Display" /></h4>
			</div>
			<div class="col-xs-4">
				<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Pages-Views" /></h3>
			</div>
			<div class="col-xs-2">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Include-on-Menu" /></h4>
			</div>
			<div class="col-xs-3">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Request-Access-Authorized" /></h4>
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2">
				<input type="radio" name="defaultPage" checked="checked" data-value="/group/delphi/welcome">
			</div>
			<div class="col-xs-4">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Welcome-Screen" /></h4>
			</div>
			<div class="col-xs-2">
				<input type="checkbox" value="/group/delphi/welcome" checked="checked" name="Welcome" />
			</div>
			<div class="col-xs-3">
				<!-- <i class="fa fa-square-o active" data-name="Welcome Screen"></i> -->
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2">
				<input type="radio" id="Revenue_Expense_defaultPage" name="defaultPage" data-value="/group/delphi/operations-revenue-expense" >
			</div>
			<div class="col-xs-4">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Revenue-Expense" /></h4>
			</div>
			<div class="col-xs-2">
				<input type="checkbox" name="Revenue & Expense" checked="checked" value="/group/delphi/operations-revenue-expense"  data-relation="Revenue & Expense" />
			</div>
			<div class="col-xs-3">
				<i class="fa fa-square-o active access-option" data-name="Revenue & Expense"></i>
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-2">
				<input type="radio" name="defaultPage"  data-value="/group/delphi/financial-admin">
			</div>
			<div class="col-xs-4">
				<h4>&nbsp;&nbsp;&nbsp;<liferay-ui:message key="Delphi-UserProfile-portlet.Enter-Financial-Targets" /></h4>
			</div>
			<div class="col-xs-2">
				<!-- <input type="checkbox"   value="/group/delphi/financial-admin"/> -->
			</div>
			<div class="col-xs-3">
				<i class="fa fa-square-o active access-option" data-name="Enter Financial Data"></i>
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>

		<div class="row">
			<div class="col-xs-2">
				<input type="radio" name="defaultPage" data-value="/group/delphi/alerts-thresholds">
			</div>
			<div class="col-xs-4">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Alerts-Thresholds" /></h4>
			</div>
			<div class="col-xs-2">
				<input type="checkbox" name="Alerts & Thresholds"  checked="checked" value="/group/delphi/alerts-thresholds"/>
			</div>
			<div class="col-xs-3">
				<!-- <i class="fa fa-square-o active" data-name="Alerts & Thresholds"></i> -->
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>

		<div class="row">
			<div class="col-xs-2">
				<input type="radio" name="defaultPage" data-value="/group/delphi/production-status">
			</div>
			<div class="col-xs-4">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Production-Status-Display" /></h4>
			</div>
			<div class="col-xs-2">
				<input type="checkbox" name="Production Status Display"  checked="checked" value="/group/delphi/production-status"/>
			</div>
			<div class="col-xs-3">
				<!-- <i class="fa fa-square-o active" data-name="Production Status Display"></i> -->
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>

		<div class="row">
			<div class="col-xs-2">
				<input type="radio" name="defaultPage" data-value="/group/delphi/global-unit-history">
			</div>
			<div class="col-xs-4">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Global-Unit-History" /></h4>
			</div>
			<div class="col-xs-2">
				<input type="checkbox" name="Global Unit History"  checked="checked" value="/group/delphi/global-unit-history"/>
			</div>
			<div class="col-xs-3">
				<!-- <i class="fa fa-square-o active" data-name="Global Unit History"></i> -->
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>

		<div class="row">
			<div class="col-xs-2">
				<input type="radio" name="defaultPage" data-value="/group/delphi/user-profile">
			</div>
			<div class="col-xs-4">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.User-Profile" /></h4>
			</div>
			<div class="col-xs-2">
				<input type="checkbox" disabled checked  value="/group/delphi/user-profile"/>
			</div>
			<div class="col-xs-3">
				<!-- <i class="fa fa-square-o active" data-name="User Profile"></i> -->
			</div>
			<div class="col-xs-1">
				
			</div>
		</div>

		<div class="row">
			<div class="col-xs-2">
				<input type="radio" name="defaultPage" data-value="/group/delphi/admin-tasks">
			</div>
			<div class="col-xs-4">
				<h4>
					<liferay-ui:message key="Delphi-UserProfile-portlet.Admin-Tasks" />
					<br/><i><liferay-ui:message key="Delphi-UserProfile-portlet.access-role" /></i>
				</h4>
			</div>
			<div class="col-xs-2">
				<input type="checkbox" name="Admin Tasks" checked="checked" value="/group/delphi/admin-tasks"/>
			</div>
			<div class="col-xs-3"> 
			</div>
			<div class="col-xs-1">
			</div>
		</div>
		
	</div>
</div>

<script>
	var preferencePortlets = <%= preferencePortlets %>;
	
	for (var key in preferencePortlets) {
		//console.log("key $(\".portlet-boundary<portlet:namespace /> .portlets input[type='checkbox'][name='"+key+"']\")");

		$(".portlet-boundary<portlet:namespace /> .portlets input[type='checkbox'][value='"+key+"']").attr('checked', preferencePortlets[key]);
		
		if(preferencePortlets[key])  $(".portlet-boundary<portlet:namespace /> .portlets input[type='radio'][data-value='"+preferencePortlets[key]+"']").attr('checked', true);
	}

	if( $("input[data-relation='Delphi Super Admin']").is(":checked") || $("input[data-relation='Delphi Admin']").is(":checked") ){
		$("input[name='Admin Tasks']").removeAttr('disabled');
	}
	
	$(".portlet-boundary<portlet:namespace /> .portlets input").off("change").on("change",function(){
		
		var context = {};
		
		$(" .portlets input[type='radio']").each(function(){	
			if($(this).is(":checked")){
				var valName = $(this).attr("name").replace("<portlet:namespace />","");
				context[ valName ] = $(this).attr("data-value");
			}
		});

		$(".portlet-boundary<portlet:namespace /> .portlets input[type='checkbox']").each(function(){
			if($(this).attr("name")){
				var valName = $(this).val();//attr("name").replace("<portlet:namespace />","");
				context[ valName ] = $(this).is(":checked");
			}
		});
		
		storeValues(context, "portlets");
	});
	

	<% if( themeDisplay.isImpersonated() ){ %>
	
		$(".portlet-boundary<portlet:namespace /> .portlets .access-option").off("click").on("click",function(){
		
			var context = {};
			context.requestSection = "portlets";
			context.requestAccessName = $(this).data("name");
			
			if($(this).hasClass("fa-square-o") || $(this).hasClass("fa-minus-square") || $(this).hasClass("fa-commenting-o") ){
				context.requestAccessValue = "Grant";
			}else if($(this).hasClass("fa-check-square")){
				context.requestAccessValue = "Deny";
			}

			$(this).removeClass("fa-square-o").removeClass("fa-check-square").removeClass("fa-minus-square")
					.addClass("fa-refresh").addClass("fa-spin");
			
			storeValues(context, "adminAccessCommand");
		});
	
	<% } else { %>
		
		$(".portlet-boundary<portlet:namespace /> .portlets .fa-square-o.active").on("click",function(){
			$(this).off("click").removeClass("fa-square-o").removeClass("active").addClass("fa-refresh").addClass("fa-spin");
			
			var context = {};
			context.requestSection = "portlets";
			context.requestAccessName = $(this).data("name");
			
			storeValues(context, "accessRequest");
		});
		
	<% } %>
</script>