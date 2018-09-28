<div class="wrapper ">
	<div class="header row">
		<div class="col-xs-12">
			<h2 class="mfg-portlet-title">
				<liferay-ui:message key="Delphi-UserProfile-portlet.Location-Divison-Language" />
				<i class="fa fa-caret-down" aria-hidden="true"></i>
			</h2>
		</div>
	</div>
	
	<div class="content location" style="display: none;">
		<div class="row">
			<div class="col-xs-12">
				<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Location-Opt" /></h3>
			</div>
		</div>
		<div class="row ">
			<div class="col-sm-4">
				<select name="region" class="chosen-select-region"></select>	
			</div>
			<div class="col-sm-4">
				<select name="site" class="chosen-select-site">
					<option value=""><liferay-ui:message key="Delphi-UserProfile-portlet.select-site-default" /></option>
					<option value="Braga">Braga [Spanish] (WEST UTC +01:00)</option>
					<option value="Chennai">Chennai [English] (IST UTC +05:30)</option>
					<option value="Gdansk">Gdansk [English] (CEST UTC +02:00)</option>
					<option value="Jambeiro">Jambeiro [Spanish] (BRT UTC -03:00)</option>
					<option value="Kokomo">Kokomo [English] (EST UTC -05:00)</option>
					<option value="Macedonia">Macedonia [English] (CEST UTC +02:00)</option>
					<option value="Matamoros">Matamoros [Spanish] (CDT UTC -05:00)</option>
					<option value="Osberghausen">Osberghausen  [German] (CEST UTC +02:00)</option>
					<option value="Reynosa">Reynosa [Spanish] (CDT UTC -05:00)</option>
					<option value="Singapore">Singapore [Chinese] (SGT TC +08:00)</option>
					<option value="St. Aubin">St. Aubin [English] (CEST UTC +02:00)</option>
					<option value="Suzhou">Suzhou [Chinese] (CST UTC +08:00)</option>
					<option value="Szombathley">Szombathley [Hungarian] (CEST UTC +02:00)</option>
				</select>	
			</div>
			<div class="col-sm-4">
				<select name="division" class="chosen-select-division">
					<option value=""><liferay-ui:message key="Delphi-UserProfile-portlet.Select-Division" /></option>
					<option value="Electronics & Safety"><liferay-ui:message key="Delphi-UserProfile-portlet.Electronics-Safety" /></option>
					<option value="Powertrain"><liferay-ui:message key="Delphi-UserProfile-portlet.Powertrain" /></option>
				</select>	
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Language-Preference" /></h3>
				<div>
					<select name="<portlet:namespace />language" class="chosen-select-language">
						<option value=""><liferay-ui:message key="Delphi-UserProfile-portlet.site-default-language" /></option>
						
						<% for (Locale localeOpt: locales) { %>
					        <option value="<%=localeOpt.toString()%>" <%  if(languageId.equalsIgnoreCase(localeOpt.toString())){  %> selected <% } %> ><%=localeOpt.getDisplayName().split(" ")[0]%></option>
					    <% } %>
					</select>	
				</div>
			</div>
			<div class="col-sm-4">
				<h3><liferay-ui:message key="Delphi-UserProfile-portlet.Time-Zone" /></h3>
				<div>
					<liferay-ui:input-time-zone name="timeZone" value="<%=timeZoneId %>"></liferay-ui:input-time-zone>
				</div>
			</div>
		</div>
	</div>
</div>

<%
Locale userLocale = user.getLocale();
String currentURL = PortalUtil.getCurrentURL(request); 

//String displayPreferredLanguageURLString = themeDisplay.getPathMain() + "/portal/update_language?p_l_id=" + themeDisplay.getPlid() + "&redirect=" + currentURL + "&languageId=" + user.getLanguageId() + "&persistState=false&showUserLocaleOptionsMessage=false";
//String displayPreferredLanguageURLString = themeDisplay.getPathMain() + "/portal/update_language?p_l_id=" + themeDisplay.getPlid() + "&redirect=" + currentURL + "&languageId=xx_XX&persistState=false&showUserLocaleOptionsMessage=false";
String displayPreferredLanguageURLString = themeDisplay.getPathMain() + "/portal/update_language?p_l_id=" + themeDisplay.getPlid() + "&redirect=" + currentURL + "&languageId=";

//String displayPreferredLanguageURLString = currentURL;
%>

<div id="userLocationChangeURL" style="display:none"><%=displayPreferredLanguageURLString %></div>

<script>
	
	$("#<portlet:namespace />timeZone").prepend('<option value=""><liferay-ui:message key="Delphi-UserProfile-portlet.site-default-time-zone" /></option>');
	
	var regionSiteServerList = JSON.parse('<c:out value="${regionSiteServerList}" escapeXml="false" />');
	var regionSitesServers = regionSiteServerList.regionSitesServers;

	loadRegions();
	loadUserLocationPreferences();
	
	function loadUserLocationPreferences(){
		$(".portlet-boundary<portlet:namespace /> .location select[name='region']").val("<%= selectedRegion %>");
		$(".portlet-boundary<portlet:namespace /> .location select[name='site']").val("<%= selectedSite %>");
		$(".portlet-boundary<portlet:namespace /> .location select[name='division']").val("<%= selectedDivision %>");
		
		$(".portlet-boundary<portlet:namespace /> .location select[name='<portlet:namespace />language']").val("<%= selectedLanguage %>");
		$(".portlet-boundary<portlet:namespace /> .location select[name='<portlet:namespace />timeZone']").val("<%= selectedTimeZone %>");
	}
	
	function loadRegions(){
		$(".location select[name='region'] option" ).remove();
		
		var regionSite = $(".location select[name='region']");
		regionSite.append($("<option></option>").attr("value", '').html('<liferay-ui:message key="Delphi-UserProfile-portlet.Select-Region" />'));

		var regions = getRegions();
		for (var i = 0; i < regions.length; i++) {
			regionSite.append($("<option></option>").attr("value", regions[i]).html(regions[i]));
		}
		
		$(".location .chosen-select-region").trigger("chosen:updated");	
	}

	function getRegions(){
		var regions =[];
		for(var r in regionSitesServers){
			regions.push(regionSitesServers[r].regionName);
		}
		return uniq(regions);
	}
	
	function uniq(a) { 
		return a.sort().filter(function(item, pos, ary) {
			return !pos || item != ary[pos - 1];
		})
	}

	$(".portlet-boundary<portlet:namespace /> .location select[name='region']").off("change").on("change",function(){		
		storeLocationValues();
	});

	$(".portlet-boundary<portlet:namespace /> .location select[name='site']").off("change").on("change",function(){		
			
		var siteSelection = $(this).find(":selected").text().split("[");
		
		for(var i=0; i < regionSitesServers.length;i++){

			if(regionSitesServers[i].siteName==$.trim(siteSelection[0])){

				$(".portlet-boundary<portlet:namespace /> .location select[name='region'] option").each(function(){

					if($(this).text().indexOf(regionSitesServers[i].regionName) > -1){
						$(".location select[name='region']").val($(this).val()).trigger("chosen:updated");
					}
				});
				
				break;
		    }
		}

		storeLocationValues();
	});
	
	$(".portlet-boundary<portlet:namespace /> .location select[name='division']").off("change").on("change",function(){	
		storeLocationValues();
	});

	$(".portlet-boundary<portlet:namespace /> .location select[name='<portlet:namespace />language']").off("change").on("change",function(){
		storeLocationValues();
	});
	
	$(".portlet-boundary<portlet:namespace /> .location select[name='<portlet:namespace />timeZone']").off("change").on("change",function(){
		storeLocationValues();
	});

	$(".portlet-boundary<portlet:namespace /> .location select").chosen({width: "100%"});
	
	function storeLocationValues(){
		var context = {};
		
		$(".portlet-boundary<portlet:namespace /> .location select").each(function(){
			var valName = $(this).attr("name").replace("<portlet:namespace />","");
			context[ valName ] = $(this).val();
		});
		
		console.log(context);
		storeValues(context, "location");
	}
	
</script>