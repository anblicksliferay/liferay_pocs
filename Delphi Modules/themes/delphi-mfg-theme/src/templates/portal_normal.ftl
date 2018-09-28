<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	
	<meta name="format-detection" content="telephone=no" />
	
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	
	<#assign current = portalUtil.getCurrentCompleteURL(request) />

    <link href="${themeDisplay.getPathThemeRoot()}/font-awesome/css/font-awesome.css?t=${ .now?long }" rel="stylesheet" /> 

	<!-- Toastr style -->
    <link href="${themeDisplay.getPathThemeRoot()}/css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <!-- Gritter -->
    <!-- <link href="${themeDisplay.getPathThemeRoot()}/js/plugins/gritter/jquery.gritter.css" rel="stylesheet"> -->
    
    <link href="${themeDisplay.getPathThemeRoot()}/css/animate.css" rel="stylesheet" />
	<link href="${themeDisplay.getPathThemeRoot()}/css/plugins/iCheck/custom.css" rel="stylesheet" />
	<@liferay_util["include"] page=top_head_include />
    <#-- <link href="${themeDisplay.getPathThemeRoot()}/css/_custom.scss" rel="stylesheet" />-->
    
    <link rel="apple-touch-icon" sizes="180x180" href="${themeDisplay.getPathThemeRoot()}/images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="${themeDisplay.getPathThemeRoot()}/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${themeDisplay.getPathThemeRoot()}/images/favicon-16x16.png">
	<link rel="manifest" href="${themeDisplay.getPathThemeRoot()}/images/manifest.json">
	<link rel="mask-icon" href="${themeDisplay.getPathThemeRoot()}/images/safari-pinned-tab.svg" color="#5bbad5">
	<link rel="shortcut icon" href="${themeDisplay.getPathThemeRoot()}/images/favicon.ico">
	<meta name="msapplication-config" content="${themeDisplay.getPathThemeRoot()}/images/browserconfig.xml">
	<meta name="theme-color" content="#ffffff">
	
	<!-- Mainly scripts -->
	<script type="text/javascript">
         window.__define = window.define;
         window.__require = window.require;
         window.define = undefined;
         window.require = undefined;
    </script>
    
    <script type="text/javascript">     
         var userLanguagePreference = "${locale.toString()}";
         
         if(userLanguagePreference=="hu_HU") {
         	monthNamesShort= ['Jan', 'Feb', 'M&aacute;rc', '&aacute;pr', 'M&aacute;j', 'Jun', 'Jul', 'Aug', 'Szept', 'Okt', 'Nov', 'Dec'];
         	todayText= ['Ma'];
         	clearText= ['Egyértelmű'];
         	closeText= ['Bezárás'];
         }else if(userLanguagePreference=="de_DE") {
         	monthNamesShort= ['Jan', 'Feb', 'M&#228;rz', 'Apr', 'Mai', 'Juni', 'Juli', 'Aug', 'Sept', 'Okt', 'Nov', 'Dez'];
         	todayText= ['Heute'];
         	clearText= ['Klar'];
         	closeText= ['Schließen'];
         }else if(userLanguagePreference=="es_ES") {
         	monthNamesShort= ['Enero', 'Feb', 'Marzo', 'Abr', 'Mayo', 'Jun', 'Jul', 'Agosto', 'Sept', 'Oct', 'Nov', 'Dic'];
         	todayText= ['Hoy'];
         	clearText= ['Claro'];
         	closeText= ['Cerca'];
         }else if(userLanguagePreference=="zh_CN") {
         	monthNamesShort= ['&#19968;&#26376;', '&#20108;&#26376;', '&#25439;&#20260;', '&#22235;&#26376;', '&#21487;&#33021;', '&#21531;', '&#19971;&#26376;', '&#20843;&#26376;', '&#20061;&#26376;', '&#21313;&#26376;', '&#21313;&#19968;&#26376;', '&#21313;&#20108;&#26376;'];
         	todayText= ['今天'];
         	clearText= ['明确'];
         	closeText= ['关'];
         }else {
         	monthNamesShort= ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
         	todayText= ['Today'];
         	clearText= ['Clear'];
         	closeText= ['Close'];
         };   
         
     </script>
	
	<script src="${themeDisplay.getPathThemeRoot()}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/bootstrap.min.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	
	<script src="${themeDisplay.getPathThemeRoot()}/js/jquery.cookie.js"></script>	
	
	<script src="${themeDisplay.getPathThemeRoot()}/js/custom.js"></script>
	<script type="text/javascript">
         window.define = window.__define;
         window.require = window.__require;
         window.__define = undefined;
         window.__require = undefined;
     </script>
     
</head>

<body class="${css_class} site-body">
	<@liferay_util["include"] page=body_top_include />
	<@liferay.control_menu />
	
	<#if getterUtil.getBoolean(theme_settings['locked-page']!"", false) == false>
					
        <div id="wrapper">
			<#if getterUtil.getBoolean(theme_settings['no-left-menu']!"", false)  == false>
				<#include "${full_templates_path}/side_bar.ftl" />
			</#if>
			
			<#if getterUtil.getBoolean(theme_settings['right-sidebar-fixed']!"", false) == true>
				<div id="page-wrapper" class="gray-bg sidebar-content">
			<#else>
				<div id="page-wrapper" class="gray-bg">			
			</#if>
			
					<#if getterUtil.getBoolean(theme_settings['no-left-menu']!"", false)  == false>
						<#include "${full_templates_path}/top_header.ftl" />
					<#else>
						<#include "${full_templates_path}/top_navigation.ftl" />
					</#if>
			
					<#if selectable>
						<@liferay_util["include"] page=content_include />
					<#else>
						${portletDisplay.recycle()}
			
						${portletDisplay.setTitle(the_title)}
			
						<@liferay_theme["wrap-portlet"] page="portlet.ftl">
							<@liferay_util["include"] page=content_include />
						</@>
					</#if>

					<#if getterUtil.getBoolean(theme_settings['display-footer']!"", false) == true>
						<div class="footer">
							<#if journalContentUtil??>
								${footer}
							<#else>
								<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupShowBorders", "false")>
								<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", "${footer}")>
								
								<@liferay_portlet["runtime"]
									defaultPreferences="${freeMarkerPortletPreferences}"
									portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" 
									instanceId="footer">
								</@> 
								${freeMarkerPortletPreferences.reset()}
							</#if>
						</div>
					</#if>
				</div><!-- End page-wrapper -->	
		</div><!-- End wrapper -->
		
		<!-- Custom and plugin javascript -->
		<script>
	         window.__define = window.define;
	         window.__require = window.require;
	         window.define = undefined;
	         window.require = undefined;
	     </script>
	     
		<script src="${themeDisplay.getPathThemeRoot()}/js/plugins/pace/pace.min.js"></script>
		
		<!-- Peity -->
	    <script src="${themeDisplay.getPathThemeRoot()}/js/plugins/peity/jquery.peity.min.js"></script>
	    <script src="${themeDisplay.getPathThemeRoot()}/js/demo/peity-demo.js"></script>
	    
		<!-- iCheck -->
    	<script src="${themeDisplay.getPathThemeRoot()}/js/plugins/iCheck/icheck.min.js"></script>
    	
    	<!-- jQuery UI custom -->
		<script src="${themeDisplay.getPathThemeRoot()}/js/jquery-ui.custom.min.js"></script>
		<script src="${themeDisplay.getPathThemeRoot()}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	
		<script src="${themeDisplay.getPathThemeRoot()}/js/delphimfg.js" ></script>
		
		<script>
	         window.define = window.__define;
	         window.require = window.__require;
	         window.__define = undefined;
	         window.__require = undefined;
	     </script>
	<#else>
		<@liferay_util["include"] page=body_top_include />
		<section id="content">
			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}
	
				${portletDisplay.setTitle(the_title)}
	
				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</section>
	</#if>
	
	<div class="hidden">
		<@liferay_portlet["runtime"]
			defaultPreferences="${freeMarkerPortletPreferences}"
			portletProviderAction=portletProviderAction.VIEW
			portletName="com_ys_delphi_notification_portlet_MyMiniNotificationPortlet"
		/>
	</div>

	<div class="hidden">
		<@liferay_portlet["runtime"]
			defaultPreferences="${freeMarkerPortletPreferences}"
			portletProviderAction=portletProviderAction.VIEW
			portletName="com_delphi_userprofile_portlet_DelphiUserProfileThemeHelper"
		/>
	</div>

	<#include "${full_templates_path}/settings.ftl" />
	<#include "${full_templates_path}/liferay_settings.ftl" />
			
	<@liferay_util["include"] page=body_bottom_include />
	<@liferay_util["include"] page=bottom_include />

</body>

</html>