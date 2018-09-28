<!DOCTYPE html>

<#include init />

<html class="${root_css_class} sm" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />


	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>ServiceMandi | Trucks | Buses | Repair and Maintenance Services</title>
	<meta name="keywords" content="Service Mandi, ServiceMandi, Commercial vehicle, M&HCV, ICV, LCV, Trucks, Buses, Servicing, Highway, Breakdown, Repair, Maintenance, Ashok Leyland, Tata Motors, Mahindra, Mechanics, Parts Retailers, Service App, Service Mobile App, Service locator" />
	<meta name="description" content="ServiceMandi is a digital mobile app based platform for commercial vehicles (M&HCV, ICV and LCV) which helps trucks and buses (of any brand such as Ashok Leyland, Tata Motors, Mahindra etc.) locate the nearest local mechanic in India to avail services such as breakdown, repair or maintenance related." />
	<meta name="robots" content="index, follow" />
	<meta name="revisit-after" content="15 days" />
	<meta name="author" content="servicemandi" />


	<@liferay_util["include"] page=top_head_include />
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans" rel="stylesheet">
	<script type="text/javascript" src="${javascript_folder}/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${javascript_folder}/jquery.easings.min.js"></script>
	<script type="text/javascript" src="${javascript_folder}/scrolloverflow.js"></script>
	<script type="text/javascript" src="${javascript_folder}/jquery.fullPage.js" media="only screen and (min-device-width: 1199px)"></script>
	<script type="text/javascript" src="${javascript_folder}/showup.js"></script>
	<script type="text/javascript" src="${javascript_folder}/wow.js"></script>
	<script type="text/javascript" src="${javascript_folder}/jquery.bcSwipe.js"></script>
	
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />


	
<div class="">
 
  
 
	<header id="banner" role="banner">
		<!-- <div id="heading">
			<h1 class="site-title">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</h1>
		</div> -->

		<!--<#if !is_signed_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if> -->

		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>

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

	
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
<!-- endinject -->
</body>

</html>