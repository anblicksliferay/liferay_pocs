<div class="wrapper contact-info">
	<div class="header row">
		<div class="col-xs-12">
			<h2 class="mfg-portlet-title">
				<liferay-ui:message key="Delphi-UserProfile-portlet.Communication-Preferences" />
			 	<i class="fa fa-caret-down" aria-hidden="true"></i>
			</h2>
		</div>
	</div>
	
	<div class="content" style="display: none;">
		<div class="row">
			<div class="col-xs-6">
				<h3>&nbsp</h3>
			</div>
			<div class="col-xs-6">
				<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Default-Preferences" /></h3>
			</div>
		</div>
		<div class="row detailItem">
			<div class="col-xs-5">
			</div>
			<div class="col-xs-2 text-center">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.System-Alerts" /></h4>
			</div>
			<div class="col-xs-2 text-center">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Site-Alerts" /></h4>
			</div>
			<div class="col-xs-3 text-center">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Process-Alerts" /></h4>
				
				<div class="row">
					<div class="col-xs-4">
						<liferay-ui:message key="Delphi-UserProfile-portlet.info" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:message key="Delphi-UserProfile-portlet.warning" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:message key="Delphi-UserProfile-portlet.critical" />
					</div>
				</div>
			</div>
		</div>
		<div class="row detailItem">
			<div class="col-xs-5">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Email" /></h4>
				<a href="mailto:${user.getEmailAddress()}">${user.getEmailAddress()}</a>
			</div>
			<div class="col-xs-2 text-center">
				<i class="fa fa-check-square"></i>
			</div>
			<div class="col-xs-2 text-center">
				<i class="fa fa-check-square"></i>
				</div>
			<div class="col-xs-3 text-center">
				<div class="row">
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="emailProcessInfo" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="emailProcessWarning" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="emailProcessCritical" />
					</div>
				</div>
			</div>
		</div>
		<div class="row detailItem">
			<div class="col-xs-5">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Mobile-Phone" /></h4>
				
				<% 
					List<Phone> phones = user.getPhones(); 
					String phoneMessage = "";
					
					for(Phone phone:phones){
						if(phone.isPrimary()) phoneMessage = phone.getNumber();
					}

					if(phoneMessage.trim().equals("")){
				%>
					<td class="textCenter" id="SMSCaption">
						<span style="cursor:pointer;color:cadetblue;text-decoration:underline;"
						onclick="getEnterPhonePopup()" id="userProfilePhone"><liferay-ui:message key='Delphi-UserProfile-portlet.Add-Phone' /></span>
					</td>
				<% 
					}else{
				%>
					<td class="textCenter" id="SMSCaption">
						<span style="cursor:pointer;color:cadetblue;text-decoration:underline;"
						onclick="getEnterPhonePopup()" id="userProfilePhone"><%= phoneMessage %></span>
					</td>
				<%
					}
				%>

			</div>
			<div class="col-xs-2 text-center">
				<liferay-ui:input-checkbox param="smsSystemAlerts" />
			</div>
			<div class="col-xs-2 text-center">
				<liferay-ui:input-checkbox param="smsSiteAlerts" />
			</div>
			<div class="col-xs-3 text-center">
				<div class="row">
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="smsProcessInfo" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="smsProcessWarning" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="smsProcessCritical" />
					</div>
				</div>
			</div>
		</div>
		<div class="row detailItem">
			<div class="col-xs-5">
				<h4><liferay-ui:message key="Delphi-UserProfile-portlet.Mobile-App" /></h4>
			</div>
			<div class="col-xs-2 text-center">
				<liferay-ui:input-checkbox param="pushSystemAlerts" />
			</div>
			<div class="col-xs-2 text-center">
				<liferay-ui:input-checkbox param="pushSiteAlerts" />
			</div>
			<div class="col-xs-3 text-center">
				<div class="row">
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="pushProcessInfo" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="pushProcessWarning" />
					</div>
					<div class="col-xs-4">
						<liferay-ui:input-checkbox param="pushProcessCritical" />
					</div>
				</div>
			</div>
		</div>
		<div class="row detail-message mt-10 mb-10">
				<div class="col-xs-5 whitebox">
					<p>
						<h4><liferay-ui:message key="Delphi-UserProfile-portlet.receive-mobile" /> </h4>
						<ol>
							<li><liferay-ui:message key="Delphi-UserProfile-portlet.Install-Delphi" /></li>
							<li><liferay-ui:message key="Delphi-UserProfile-portlet.Install-EMI" /></li>
							<li><liferay-ui:message key="Delphi-UserProfile-portlet.Log-Okta" /></li>
						</ol>
					</p>
					 
					<p><liferay-ui:message key="Delphi-UserProfile-portlet.registers-device" /></p>
				</div>
			</div>
	</div>
</div>

<script>
	var preferenceContactInfo = <%= preferenceContactInfo %>;
	
	for (var key in preferenceContactInfo) {
		//console.log("key <portlet:namespace />"+key+" preferenceContactInfo[key]:"+preferenceContactInfo[key]);
		if(preferenceContactInfo[key])  $(".portlet-boundary<portlet:namespace /> .contact-info input[name='<portlet:namespace />"+key+"']").attr('checked', true);
	}

	$(".portlet-boundary<portlet:namespace /> .contact-info input").off("change").on("change",function(){
		
		var context = {};
		
		$(".portlet-boundary<portlet:namespace /> .contact-info input").each(function(){
			var valName = $(this).attr("name").replace("<portlet:namespace />","");
			context[ valName ] = $(this).is(":checked");
		});
		
		storeValues(context, "contact-info");
	});
	
	function getEnterPhonePopup(){
		AUI().use('aui-base',
				'aui-io-plugin-deprecated',
				'liferay-util-window', 
				
			function(A) {
				var popUpWindow=Liferay.Util.Window.getWindow({
						id:'phoneNumberPopup',
						dialog: {
							centered: true,
							constrain2view: true,
							align: {
										node: null,
										points: ['tc', 'tc']
									},
							modal: true,
							cache: false,
							width:550,
							height:250,										
							destroyOnClose: true,	
						}
					}
				).plug(A.Plugin.IO,{
						autoLoad: false
					}).render();
					
				popUpWindow.show();
				popUpWindow.titleNode.html('<liferay-ui:message key="Delphi-UserProfile-portlet.SMS-messaging" />');
				popUpWindow.io.set('uri',"<%=generateEnterPhoneURL%>");
				popUpWindow.io.start();
	
		});
	}

	function storePhoneNumber(phoneNumber){
	
		phoneNumber = phoneNumber.replace(/\D/g,'');

		if(phoneNumber.trim()==""){
			$("#userProfilePhone").text("<liferay-ui:message key='Delphi-UserProfile-portlet.Add-Phone' />");
		} else {
			$("#userProfilePhone").text(phoneNumber);
		}
		
		var cmd = 'phone';
		var cmdType= 'update';
		var context = {"phoneNumber":phoneNumber};		
		
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
				var dialog = Liferay.Util.getWindow("phoneNumberPopup");
				dialog.destroy(); // You can try toggle/hide whatever You want
			},
			error : function(response) {
				console.log("Error seen for Phone Update Response");
			}
		});
	}
</script>