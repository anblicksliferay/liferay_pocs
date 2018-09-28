<#-- Mobile Banner -->
<header id="banner" class="mobileLogo" role="banner">
    <div id="heading" class="sticky d-flex">
    	<div class="navbar-header hidden-sm-up">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " id="btnClose" href="#"><i class="fa fa-bars"></i></a>
        </div>
        <h1 class="site-title d-flex-one text-center">
            <a style="font-size: 0.531em;letter-spacing: .02em;line-height: 1.6em;"
            class="${logo_css_class}" href="${home_url}">
                <#if locale.toString()=="hu_HU">
					<img class="mobileLogo" src="${themeDisplay.getPathThemeRoot()}/images/aptiv-mobile-logo-hu.svg" />
    			<#elseif locale.toString()=="de_DE">
					<img class="mobileLogo" src="${themeDisplay.getPathThemeRoot()}/images/aptiv-mobile-logo-de.svg" />
    			<#elseif locale.toString()=="es_ES">
					<img class="mobileLogo" src="${themeDisplay.getPathThemeRoot()}/images/aptiv-mobile-logo-es.svg" />
            	<#elseif  locale.toString()=="zh_CN">
					<img class="mobileLogo" src="${themeDisplay.getPathThemeRoot()}/images/aptiv-mobile-logo-ch.svg" />
            	<#else>
					<img class="mobileLogo" src="${themeDisplay.getPathThemeRoot()}/images/aptiv-mobile-logo.svg" />
				</#if>
            </a>
        </h1>
        <div>
	        <div class="d-flex-one v-align-middle text-center mobile-dock">
	        	
	        	
		        <#if is_signed_in>
		            <div class="greetingmsg">${user_first_name} ${user_last_name}</div>
		        </#if>
	        </div>
        </div>
    </div>
</header>

<#if getterUtil.getBoolean(theme_settings['show-breadcrumbs']!"", false) == true>
	<div class="row border-bottom white-bg page-heading visible-xs">
	    <div>
	        <#if page.getName(locale)??><h2>${page.getName(locale)}</h2></#if>
        </div>
    </div>
</#if>

<#-- Desktop View -->
<#if getterUtil.getBoolean(theme_settings['show-breadcrumbs']!"", false) == true>
	<div class="row border-bottom white-bg page-heading desktop-view hidden-xs">
	    <div class="d-flex">
	        <#if page.getName(locale)??><h2 class="page-header d-flex-one">${page.getName(locale)}</h2></#if>
	        <div class="rightSection d-flex">
	        	<#if is_signed_in>
		            <div class="greetingmsg d-flex-one">${user_first_name} ${user_last_name}</div>
		        </#if>	        	
		        <div id="UserControls"></div>
		    </div>
	    </div>
	</div>
</#if>