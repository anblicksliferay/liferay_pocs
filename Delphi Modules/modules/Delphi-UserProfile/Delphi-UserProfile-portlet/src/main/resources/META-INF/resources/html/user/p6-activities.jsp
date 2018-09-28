<div class="wrapper">
	<div class="header row">
		<div class="col-xs-12">
			<h2 class="mfg-portlet-title">
				<liferay-ui:message key="Delphi-UserProfile-portlet.Activities-of-Interest" />
				<i class="fa fa-caret-down" aria-hidden="true"></i>
			</h2>
		</div>
	</div>
	
	<div class="content" style="display: none;">
		
		<div class="row activities">
			<div class="col-sm-6">
				
				<div class="row">
					<div class="col-xs-12">
						<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Activities-of-Interest" /></h3>
						<i><liferay-ui:message key="Delphi-UserProfile-portlet.Select-none" /></i>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="" checked> <liferay-ui:message key="Delphi-UserProfile-portlet.None" /></div>
						<div class="mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="Screw driving"> <liferay-ui:message key="Delphi-UserProfile-portlet.Screw-driving" /></div>
						<div class="mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="Soldering"> <liferay-ui:message key="Delphi-UserProfile-portlet.Soldering" /></div>
						<div class="ml-20 mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="Welding"> <liferay-ui:message key="Delphi-UserProfile-portlet.Welding" /></div>
						<div class="mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="Testing"> <liferay-ui:message key="Delphi-UserProfile-portlet.Testing" /></div>
						<div class="ml-20 mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="Programming"> <liferay-ui:message key="Delphi-UserProfile-portlet.Programming" /></div>
						<div class="mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="Finishing"> <liferay-ui:message key="Delphi-UserProfile-portlet.Finishing" /></div>
						<div class="ml-20 mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="Laser etching"> <liferay-ui:message key="Delphi-UserProfile-portlet.Laser-etching" /></div>
						<div class="ml-20 mb-5"><input type="radio" name="<portlet:namespace />ActivitiesOfInterest" value="paint"> <liferay-ui:message key="Delphi-UserProfile-portlet.Paint" /></div>
					</div>
				</div>
				
			</div>
		
			<div class="col-sm-6 whitebox">
				<liferay-ui:message key="Delphi-UserProfile-portlet.defined-alert-subscriptions" />
			</div>
		</div>
			
	</div>
</div>

<script>
	
	var preferenceActivitiesOfInterest = <%= preferenceActivitiesOfInterest %>;
	
	for (var key in preferenceActivitiesOfInterest) {
		
		var input = $(".portlet-boundary<portlet:namespace /> .activities input[name='<portlet:namespace />"+key+"']");
		
		if(input.attr("type")=="radio"){
			$(input).each(function(){
				if(preferenceActivitiesOfInterest[key] == $(this).val()){
					$(this).attr('checked', true);
				}else{
					$(this).removeAttr('checked');
				}
			});
		} else if(input.attr("type")=="checkbox" && preferenceActivitiesOfInterest[key]){
			input.attr('checked', true);
		}else if(input.attr("type")=="text"){
			input.val(preferenceActivitiesOfInterest[key]);
		}
	}
	
	$(".portlet-boundary<portlet:namespace /> .activities input").off("change").on("change",function(){
		
		var context = {};
		
		$(".portlet-boundary<portlet:namespace /> .activities input").each(function(){
			var valName = $(this).attr("name").replace("<portlet:namespace />","");
			if($(this).attr("type")=="text"){
				context[ valName ] = $(this).val();
			}else if($(this).attr("type")=="radio" && $(this).is(":checked")){
				context[ valName ] = $(this).val();
			}else if($(this).attr("type")=="checkbox"){
				context[ valName ] = $(this).is(":checked");
			}
		});
		
		//console.log(context);
		storeValues(context, "activities");
	});

</script>