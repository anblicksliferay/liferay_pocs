<%@ include file="/html/admin/init.jsp" %>
<portlet:actionURL var="deleteProfile" name="deleteProfile"/>
<portlet:actionURL var="renderUserProfile" name="renderUserProfile"/>
<portlet:actionURL var="sendAlertMessage" name="sendAlertMessage"/>
	
<form name="deleteForm" id="deleteForm" action="<%=deleteProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>userid" name="<portlet:namespace/>userid"/>
</form> 

<form name="renderForm" id="renderForm" action="<%=renderUserProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>profileId" name="<portlet:namespace/>profileId"/>
</form> 

<form name="sendAlertForm" id="sendAlertForm" action="<%=sendAlertMessage.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>systemalert" name="<portlet:namespace/>systemalert"/>
	<input type="hidden" id="<portlet:namespace/>sitealert" name="<portlet:namespace/>sitealert"/>
	<input type="hidden" id="<portlet:namespace/>messagetext" name="<portlet:namespace/>messagetext"/>
	<input type="hidden" id="<portlet:namespace/>portalbanner" name="<portlet:namespace/>portalbanner"/>
	<input type="hidden" id="<portlet:namespace/>colorValue" name="<portlet:namespace/>colorValue" value="info"/>
	<input type="hidden" id="<portlet:namespace/>sitename" name="<portlet:namespace/>sitename"/>
</form>

<% if(themeDisplay.isSignedIn()){ %>
	
	<div class="wrapper form-group">
	  <input placeholder="Search" type="text" class="form-control admintasks-search-control" id="usr">
	</div>
	
	<div class="wrapper clearfix">
		<div class="headerStatic row">
			<div class="col-xs-12">
				<h2	class="mfg-portlet-title">
					Requests
				</h2>
			</div>
		</div>
		<div class="content">
		
			<% 
			
			if(userAccessRequests.size()>=1){
				
				for(UserAccessRequest userAccessRequest : userAccessRequests){ 

					User requestUser = null;
					
					try{
						requestUser = UserLocalServiceUtil.getUser(userAccessRequest.getUserId());
					}catch(com.liferay.portal.kernel.exception.NoSuchUserException nsue){
						System.out.println("User with userId:"+userAccessRequest.getUserId()+" not found.");
					}
					if(null==requestUser) continue;

					UserProfile userProfile = null;
					String userProfileSite = "";
					
					try{
						userProfile = UserProfileLocalServiceUtil.findUserProfileByUserId(userAccessRequest.getUserId());
						userProfileSite = userProfile.getSite();
					} catch(Exception ex){
						System.out.println(ex);
					}

					SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					String timeString = df.format(userAccessRequest.getModifiedDate());
					 
				%>
				
				<div class="requests-card"
					data-search="<%= requestUser.getFullName() %> <%= userAccessRequest.getRequestType() %> <%= userAccessRequest.getPortletAccess() %> <%= userProfileSite %>"
					data-request-id="<%= userAccessRequest.getRequestId() %>">
					
					<div class="requests-card-badge">
						<i class="fa fa-id-badge" aria-hidden="true"></i>
					</div>
					<div class="requests-card-info">
						<p class="mb-0"><b>ACCESS REQUEST</b></p>
						<p class="mb-0"><%= requestUser.getFullName() %></p>
						<p class="mb-0">for <%= userAccessRequest.getRequestType() %>: <b><%= userAccessRequest.getPortletAccess() %></b></p>
						
						<p>
							<%= timeString %>
							<% if(!userProfileSite.equals("")){ %>
								<br/>Site: <%= userProfileSite %>
							<% } %>
						</p>
						
						<button type="button" class="btn btn-default" onclick="setAccess(this,'grant', <%= userAccessRequest.getRequestId() %>);">Grant</button>
						<button type="button" class="btn btn-default" onclick="setAccess(this,'deny', <%=userAccessRequest.getRequestId() %>);">Deny</button>
					</div>
				</div>
				
				<% }
			}
			
			if(userAccessRequests.size()>=1){
			%>
				<h5 class="no-pending-requests-msg text-center" style="display:none">No pending requests.</h5>
			<% }else{ %>
				<h5 class="no-pending-requests-msg text-center">No pending requests.</h5>
			<% } %>
		</div>
	</div>
	
	<script>
			
		function setAccess(elm, type, accessRequestId){
			$(elm).parent().parent().fadeOut(500, function(){
			  $(this).remove();
			  
			  if($(".requests-card").length<=0) $(".no-pending-requests-msg").slideDown(500);
			});
			
			context = {};
			context.accessRequestId = accessRequestId;
	
			storeValues('accessRequestResponseChoice', type, context);
		}
		
		function storeValues(cmd, cmdType, context){
			
			if(debug) console.log("storeValues: "+type+":"+context);
			
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
					console.log(data);
				},
				error : function(response) {
					console.log("Error seen for "+cmd+" Update Response");
				}
			});
		}
	</script>
	
	<div class="wrapper">
		<div class="header row">
			<div class="col-xs-12">
				<h2	class="mfg-portlet-title">
					User List
					<i class="fa fa-caret-down" aria-hidden="true"></i>
				</h2>
			</div>
		</div>
		<div class="content" style="display: none;">
			<%
			com.liferay.portal.kernel.json.JSONObject userList = (com.liferay.portal.kernel.json.JSONObject)renderRequest.getAttribute("userJsonData");
			%>
			
			<div id="confirmDelete_Admin" style="background-color:#ffffff">
				<p>Confirm Delete</p>
			</div>
				
			<table class="userlistGrid" class="table-responsive table-striped table-bordered table-hover dataTable display" cellspacing="0" width="100%">
	
				<thead>
					<tr>
						<th>User</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				
					<% for(User listUser: users){ 
					
						if(listUser.isDefaultUser()) continue;
					%>
				
					<liferay-security:doAsURL
				            doAsUserId="<%=listUser.getUserId()%>"
				            var="impersonateUserURL" />
				            
					<tr data-id="<%=listUser.getUserId() %>">
						<td class="user-name" onclick="useProfilePageImpersonation('<%=impersonateUserURL %>')"><%=listUser.getFullName() %></td>
						<td class="user-delete" ><i class="fa fa-times fa-lg" aria-hidden="true"></i></td>
					</tr>
					
					<% } %>
					
				</tbody>
				
			</table>
			
		</div>
	</div>
	
	<div class="wrapper">
		<div class="header row">
			<div class="col-xs-12">
				<h2	class="mfg-portlet-title">
					Send Alert Message
					<i class="fa fa-caret-down" aria-hidden="true"></i>
				</h2>
			</div>
		</div>
		<div class="content" style="display: none;">
			<div class="alert-messages">
			<h3><b>Message Type:</b></h3>
			<div>
				<label style="display: block;"><input type="radio" name="group1" id="rdio1" checked> System Alert</label>
				<div id="opt1" automaticallyVisibleIfIdChecked="rdio1">	
					<div class="admin-color-picker">
						<span>
							<span class="mfg-admin-alert info" data-level="info" title="Informational Alert">&nbsp;</span>
						</span>
						<span>
							<span class="mfg-admin-alert warn" data-level="warn" title="Warning Alert">&nbsp;</span>
						</span>
						<span>
							<span class="mfg-admin-alert crit" data-level="crit" title="Critical Alert">&nbsp;</span>
						</span>
					</div>
				</div>
			</div>  
			<div><label><input type="radio" name="group1" id="rdio2" > Site Alert</label></div>
			<div id="opt2" automaticallyVisibleIfIdChecked="rdio2" style="display: none;">
				<div>
					<label>Site</label>
					<div class="notifications-controls-container">
						<select name="siteforAdmin" class="chosen-select-site ">
							<option value="">Select Site</option>
							<option value="Braga">Braga</option>
							<option value="Chennai">Chennai</option>
							<option value="Gdansk">Gdansk</option>
							<option value="Jambeiro">Jambeiro</option>
							<option value="Kokomo">Kokomo</option>
							<option value="Macedonia">Macedonia</option>
							<option value="Matamoros">Matamoros</option>
							<option value="Osberghausen">Osberghausen</option>
							<option value="Reynosa">Reynosa</option>
							<option value="Singapore">Singapore</option>
							<option value="St. Aubin">St. Aubin</option>
							<option value="Suzhou">Suzhou</option>
							<option value="Szombathely">Szombathely</option>
						</select>
					</div>
				</div>
			</div>
			</div>
			<div class="send-message-note">
				The alerts are sent to any user that has used the portal within the last 45 days.
			</div>
			<div id="opt1" class="clearfix" automaticallyVisibleIfIdChecked="rdio1">	
				<b>Message Text</b>
				<textarea placeholder='"Informational" System Alert - suggested for planned portal downtime, release of new features, and similar.  Type your text here.' id="textBox"  maxlength="140" class="form-control text-box-1" rows="10" style="margin: 5px 0;"></textarea>
			</div>
			<div id="opt2" automaticallyVisibleIfIdChecked="rdio2">
				<textarea placeholder="Enter message here." id="textBox"  maxlength="140" class="form-control text-box-2" rows="10" style="margin: 5px 0; display: none;"></textarea>
			</div>
			<div id='<portlet:namespace />mini-spinner'  class="portlet-spinner">
				<div class="spinner-wrapper"> <div class="sk-spinner sk-spinner-wave"> <div class="sk-rect1"></div> <div class="sk-rect2"></div> <div class="sk-rect3"></div> <div class="sk-rect4"></div> <div class="sk-rect5"></div> </div> </div>
			</div>
			<div class="clearfix">
				<div id="charNum"></div>
			</div>	
			<button type="button" class="btn btn-default admin-send-msg" onclick="sendmessage()">Send Message</button>
			<button type="button" class="btn btn-default admin-send-msg" onclick="sendPortalBanner()">Post as In-Portal Banner</button>
			<button type="button" class="btn btn-default" onclick="clearPortalBanner()">Clear In-Portal Banner</button>
	</div>
		
	<script>
		var regionSiteServerList 	= JSON.parse('<c:out value="${regionSiteServerList}" escapeXml="false" />');
		var regionSitesServers 		= regionSiteServerList.regionSitesServers;

		if(debug) console.log("regionSitesServers");
		
		var debug=false;
		var userlistTable;
		
		initializeUserTable();
		
		$(".header").on("click",function(){
			if($(this).hasClass("open")){
				$(this).removeClass("open").find(".fa").removeClass("rotate");
				$(this).parent().find(".content").removeClass("open").slideUp(500);
			}else {
				$(this).addClass("open").find(".fa").addClass("rotate");
				$(this).parent().find(".content").addClass("open").slideDown(500);
			}
		});
		
		$(".admin-color-picker .mfg-admin-alert.crit").on("click",function(){
			$("textarea#textBox.text-box-1").css("background-color", "#C77").attr('placeholder', '"Critical" System Alert - suggested for unplanned downtime, complete failure of data flow through the portal.  Type your text here.');
			$("#<portlet:namespace />colorValue").val("crit");
		});
		$(".admin-color-picker .mfg-admin-alert.warn").on("click",function(){
			$("textarea#textBox.text-box-1").css("background-color", "#Fb7").attr('placeholder', '"Warning" System Alert - suggested for delayed or incomplete information displayed, partial portal service disruption.  Type your text here.');
			$("#<portlet:namespace />colorValue").val("warn");
		});

		$(".admin-color-picker .mfg-admin-alert.info").on("click",function(){
			$("textarea#textBox.text-box-1").css("background-color", "#8bd").attr('placeholder', '"Informational" System Alert - suggested for planned portal downtime, release of new features, and similar.  Type your text here.');
			$("#<portlet:namespace />colorValue").val("info");
		});

		localSpinner("#<portlet:namespace />mini-spinner", 'close');
		
		function useProfilePageImpersonation(impersonateUserURL){
			location.href= "/group/delphi/user-profile?"+impersonateUserURL.split("?")[1];
			
		}
		
		function initializeUserTable(){
			
			userlistTable = $('.userlistGrid').DataTable( {
				order: [[0, 'asc'] ],
		        dom: 'frtip',
		        drawCallback: function( settings ) {
		        	setUserListEventHandlers();
				}
			});	
			
			$('.userlistGrid').addClass("table-striped").addClass("table-bordered");
		}
		
		function setUserListEventHandlers(){

			$('.userlistGrid tbody .user-delete').off('click').on('click', function () {
				debug = true;
				
				var userId = $(this).parent().data("id");
				if(debug) console.log("Clicked userId:"+userId);
				
				$('#<portlet:namespace/>userid').val(userId);
				if(debug) console.log("opening dialog"); 
				$( "#confirmDelete_Admin" ).dialog( "open" );
			} ); 
		}
		
		
		$("#confirmDelete_Admin").dialog({
	   		height:'130',
	   		width:'250',
	   		modal: true,
	   		autoOpen: false,
	   		draggable: false,
			buttons: {
				"Delete": function() {
					$( this ).dialog( "close" );
					$('#deleteForm').submit();
				},
				"Cancel": function() {
					$( this ).dialog( "close" );
				},
			}
	   	});
		
		$('input[type="radio"]').click(function() {
	       if($(this).attr('id') == 'rdio1') {
	            $('#opt2').hide();
	            $('textarea#textBox.text-box-2').hide();
	       }else {
	            $('#opt2').show();
	            $('textarea#textBox.text-box-2').show();
	       }
	   });
	   
		$('input[type="radio"]').click(function() {
		       if($(this).attr('id') == 'rdio2') {
		            $('#opt1').hide();
		            $('textarea#textBox.text-box-1').hide();
		       }else {
		            $('#opt1').show();
		            $('textarea#textBox.text-box-1').show();
		       }
		   });

		countChar();
		$('#textBox').change(countChar);
		$('#textBox').keyup(countChar);
	
		function countChar() {
			var len = $('#textBox').val().length;
			$('#charNum').text(len + '/ 140');
		};

		
		function sendmessage(){
			
			context = {};
			context.portalbanner = 'false';
			context.systemalert = $("#rdio1").is(':checked');
			context.sitealert = $("#rdio2").is(':checked');
			context.messagetext = $("#textBox").val();
			context.sitename = $(".chosen-select-site :selected").val() ;
			sendSystemSiteMessage('systemSiteMessage', '', context);
		}
		
		function localSpinner(selector, method){
			if(debug) console.log(selector+" spinner starts.");
			if("open"==method){
				$(selector).fadeIn(200);
			} else {
				$(selector).fadeOut(200);
			}
		}
		
		function sendSystemSiteMessage(cmd, cmdType, context){
			
			if(debug) console.log("sendSystemSiteMessage: "+type+":"+context);
			
			$.ajax({  
				url : '<%=resourceURL.toString()%>',
				data : {
					<portlet:namespace />cmd: cmd,
					<portlet:namespace />cmdType: cmdType,
					<portlet:namespace />context: JSON.stringify(context)
				},
				beforeSend:function(){
					localSpinner("#<portlet:namespace />mini-spinner", 'open');
				},
				complete:function(){
					localSpinner("#<portlet:namespace />mini-spinner", 'close');
				},
				type : "POST",
				dataType : "json",
				success : function(data) {
					console.log(data);
				},
				error : function(response) {
					console.log("Error seen for "+cmd+" Update Response");
				}
			});
		}  

		function clearPortalBanner(){
			$("#textBox").val("");
			sendPortalBanner();
		}
		
		function sendPortalBanner(){
			$('#<portlet:namespace/>portalbanner').val("true");
			$('#<portlet:namespace/>systemalert').val("false");
			$('#<portlet:namespace/>sitealert').val("false");
			
			$('#<portlet:namespace/>messagetext').val($("#textBox").val());
			$('#<portlet:namespace/>sitename').val("");
			
			$('#sendAlertForm').submit();
		}

		$(".admintasks-search-control").off("change").on("change",function(){
			adminSearch($(this).val().trim());
		}).off("keyup").on("keyup",function(){
			adminSearch($(this).val().trim());
		})
		
		function adminSearch(search){
			$(".requests-card").hide();
			$(".requests-card").each(function(){
				if($(this).data("search").indexOf(search)>-1) $(this).show();
			});
			$("#DataTables_Table_0_wrapper input[type='search']").val(search).trigger("keyup");
		}
		
	</script>	

<% }else{ %>
  
	<div><i>Sign in to access Admin Tasks</a></i></div>
  
<% } %>