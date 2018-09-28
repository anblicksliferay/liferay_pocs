<div class="wrapper">
	<div class="header row">
		<div class="col-xs-12">
			<h2 class="mfg-portlet-title">
				<liferay-ui:message key="Delphi-UserProfile-portlet.work-hours" />
				<i class="fa fa-caret-down" aria-hidden="true"></i>
			</h2>
		</div>
	</div>
	
	<div class="content workhours" style="display: none;">
		<div class="row">
			<div class="col-xs-8 whitebox mb-10">
				<i><b><liferay-ui:message key="Delphi-UserProfile-portlet.work-hours-opt" /></b> <liferay-ui:message key="Delphi-UserProfile-portlet.work-msg" /></i>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<h3>
					<input type="radio" name="<portlet:namespace />workHoursSelectionType" value="on" checked="checked">
					<liferay-ui:message key="Delphi-UserProfile-portlet.always-on" />
				</h3>
			</div>
			<div class="col-sm-2">
			</div>
		</div>
		<div class="row detailItem">
			<div class="col-sm-6">
				<h3>
					<input type="radio" name="<portlet:namespace />workHoursSelectionType" value="manual">
					<liferay-ui:message key="Delphi-UserProfile-portlet.specify-hours" />
				</h3>
			</div>
			<div class="col-sm-6 grey text-center">
					
				<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-9">
						<liferay-ui:message key="Delphi-UserProfile-portlet.receive-communications-from" />
					</div>
				</div>
				
				<div class="row bold">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.day" />
					</div>
					<div class="col-sm-4">
						<liferay-ui:message key="Delphi-UserProfile-portlet.start-time" />
					</div>
					<div class="col-sm-1">
						<liferay-ui:message key="Delphi-UserProfile-portlet.to" />
					</div>
					<div class="col-sm-4">
						<liferay-ui:message key="Delphi-UserProfile-portlet.end-time" />
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.calendar-sunday" />
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="" type="text" name="<portlet:namespace />sunday-from"  />
					</div>
					<div class="col-sm-1">
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="" type="text" name="<portlet:namespace />sunday-to"  />
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.calendar-monday" />
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="7:00 AM"  type="text" name="<portlet:namespace />monday-from"  />
				
					</div>
					<div class="col-sm-1">
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="6:00 PM" type="text" name="<portlet:namespace />monday-to"  />
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.calendar-tuesday" />
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="7:00 AM" type="text" name="<portlet:namespace />tuesday-from"  />
				
					</div>
					<div class="col-sm-1">
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="6:00 PM" type="text" name="<portlet:namespace />tuesday-to"  />
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.calendar-wednesday" />
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="7:00 AM" type="text" name="<portlet:namespace />wednesday-from"  />
					</div>
					<div class="col-sm-1">
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="6:00 PM" type="text" name="<portlet:namespace />wednesday-to"  />
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.calendar-thursday" />
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="7:00 AM" type="text" name="<portlet:namespace />thursday-from"  />
				
					</div>
					<div class="col-sm-1">
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="6:00 PM" type="text" name="<portlet:namespace />thursday-to"  />
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.calendar-friday" />
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="7:00 AM" type="text" name="<portlet:namespace />friday-from"  />
				
					</div>
					<div class="col-sm-1">
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="6:00 PM" type="text" name="<portlet:namespace />friday-to"  />
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<liferay-ui:message key="Delphi-UserProfile-portlet.calendar-saturday" />
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value=""  type="text" name="<portlet:namespace />saturday-from"  />
				
					</div>
					<div class="col-sm-1">
					</div>
					<div class="col-sm-4">
						<input class="targetTime" value="" type="text" name="<portlet:namespace />saturday-to"  />
					</div>
				</div>
				 
			</div>	
		</div>
		
		<div class="row">
			<div class="col-sm-2">
				<label for="switch"><liferay-ui:message key="Delphi-UserProfile-portlet.vacation-on-off" /></label>
				<input type="checkbox" id="vacation-toggle" class="js-switch" name="<portlet:namespace />vacation-toggle" />
			</div>
			<div class="col-sm-10 mb-10">
				<label><liferay-ui:message key="Delphi-UserProfile-portlet.vacation-start-end" /></label><br/>
				<input class="targetDate" type="text" id="vacationFrom" name="<portlet:namespace />vacationFrom"  />
				<input class="targetDate" type="text" id="vacationTo" name="<portlet:namespace />vacationTo"  />
			</div>
			<div class="col-sm-5 text-center">
					
			</div>
		</div>
	</div>
</div>

<script>
	
	var preferenceWorkHours = <%= preferenceWorkHours %>;
	
	for (var key in preferenceWorkHours) {
		
		var input = $(".portlet-boundary<portlet:namespace /> .workhours input[name='<portlet:namespace />"+key+"']");
		
		if(input.attr("type")=="radio"){
			$(input).each(function(){
				if(preferenceWorkHours[key] == $(this).val()){
					$(this).attr('checked', true);
				}else{
					$(this).removeAttr('checked');
				}
			});
		} else if(input.attr("type")=="checkbox" && preferenceWorkHours[key]){
			input.attr('checked', true);
		}else if(input.attr("type")=="text"){
			if($(input).hasClass("targetDate")){
				input.val(revertDateFormat(preferenceWorkHours[key]));
			}else{
				input.val(convertFrom24Hour(preferenceWorkHours[key]));
			}
		}
	}

	if(preferenceWorkHours["workHoursSelectionType"]=="on"){
		preferenceWorkHoursEntryDisabled(true);
	}

	$(".portlet-boundary<portlet:namespace /> .workhours input").off("change").on("change",function(){
		var context = {};
		updateDataOnInputChange();
	});
	
	$(".portlet-boundary<portlet:namespace /> .workhours select").chosen({width: "100%"});

	$(".portlet-boundary<portlet:namespace /> .js-switch").each(function() {
		var switchery = new Switchery( this ,{ color: '#1AB394',size: 'small' });
	});

	$('.portlet-boundary<portlet:namespace /> .targetTime').timepicker({ 'scrollDefault': 'now', 'timeFormat': 'h:i A' });
	
	var vacationFrom = $( "#vacationFrom" ).datepick({
		 	altFormat: "mm/dd/yyyy",
			showOn: "button",
			buttonImage: "/o/delphifinancials/images/calendar.gif",
			//monthNames: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
			monthNames: monthNamesShort,
			todayText: todayText,
			clearText: clearText,
			closeText: closeText,
			prevText: "&lt;",
			nextText: "&gt;",
			buttonImageOnly: true,
			defaultDate: "+1w",
			changeMonth: true,
			minDate: new Date(new Date().getFullYear()-1, 0, 1),
			maxDate: new Date((new Date().getFullYear())+1, 11, 31),
			numberOfMonths: 1,
			onSelect: function (dates) {
				updateDataOnInputChange();
			}
		})
		
	var vacationTo = $( "#vacationTo" ).datepick({
	 		altFormat: "mm/dd/yyyy",
			showOn: "button",
			buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
			monthNames: monthNamesShort,
			todayText: todayText,
			clearText: clearText,
			closeText: closeText,
			prevText: "&lt;",
			nextText: "&gt;",
			buttonImageOnly: true,
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			minDate: new Date(new Date().getFullYear()-1, 0, 1),
			maxDate: new Date((new Date().getFullYear())+1, 11, 31),
			onSelect: function (dates) {
				updateDataOnInputChange();
			}
		});

	function preferenceWorkHoursEntryDisabled(isDisabled){
		if(isDisabled){
			$(".targetTime").attr("disabled","disabled");
		}else{
			$(".targetTime").removeAttr('disabled'); 
		}
	}
    function updateDataOnInputChange(){
    	
       var context = {};
		$(".portlet-boundary<portlet:namespace /> .workhours input").each(function(){
			var valName = $(this).attr("name").replace("<portlet:namespace />","");
			if($(this).attr("type")=="text"){
				if($(this).hasClass("targetTime")){
					context[ valName ] = convertFrom12Hour($(this).val());
				}else{
					context[ valName ] = convertDateFormat($(this).val()); 
				}
			}else if($(this).attr("type")=="radio" && $(this).is(":checked")){
				context[ valName ] = $(this).val();
			}else if($(this).attr("type")=="checkbox"){
				context[ valName ] = $(this).is(":checked");
			}
			
			if(valName=="workHoursSelectionType" && $(this).is(":checked")){
				preferenceWorkHoursEntryDisabled($(this).val()=="on");
			}
		});
		
		storeValues(context, "workhours");
    	
    }
    function convertFrom24Hour(time){
		 if (time.indexOf("AM") >= 0 || time.indexOf("PM") >= 0 || time.trim()=="")
			return time;
			time=time.substr(0, 2)+":"+time.substr(2, 2);
			time=time.trim();
		  time = time.toString ().match (/^([01]\d|2[0-3])(:)([0-5]\d)?$/) || [time];
		  if (time.length > 1) { // If time format correct
		    time = time.slice (1);  // Remove full string match value
		    time[5] = +time[0] < 12 ? ' AM' : ' PM'; // Set AM/PM
		    time[0] = +time[0] % 12 || 12; // Adjust hours
		  }
		  return time.join (''); // return adjusted time or original string
	}
	function convertFrom12Hour(time){
		if(time.trim()=="")return "";
		var hours = Number(time.match(/^(\d+)/)[1]);
		var minutes = Number(time.match(/:(\d+)/)[1]);
		var AMPM = time.match(/\s(.*)$/)[1];
		if(AMPM.toUpperCase() == "PM" && hours<12) hours = hours + 12;
		if(AMPM.toUpperCase() == "AM" && hours==12) hours = hours - 12;
		var sHours = hours.toString();
		var sMinutes = minutes.toString();
		if(hours<10) sHours = "0" + sHours;
		if(minutes<10) sMinutes = "0" + sMinutes;
		return (sHours + "" + sMinutes);
	}
	function convertDateFormat(date){
		if(date.trim()=="")return "";
		dvals = date.split("/");
		if(dvals.length!=3)return "";
		return dvals[2]+dvals[0]+dvals[1];
	}
	
	function revertDateFormat(date){
		if(date.trim()=="" || date.length!=8)return "";
		return date.substr(4,2) + "/" + date.substr(6,2) + "/" + date.substr(0,4);
	}
	
</script>