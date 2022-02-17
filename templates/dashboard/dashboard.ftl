<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="cap container-fluid" id="wrapper">

<!-- header.ftl -->
	
	<header id="banner" role="banner">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
				<h4>${the_title}</h4>

				<#if !is_signed_in>
					<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
				</#if>
			</div>		
		</div>

    	<div>
        	<button class="btn btn-primary" onclick={location.href='/group/agent-portal/proposal'}>NEW PROPOSAL</button>
    	</div>
	</header>

<!-- end of header.ftl -->

<!-- navigation.ftl -->

<nav class="${nav_css_class}" id="navigation" role="navigation">
	<div class="navigation-aside">
		<div class="crosig-logo">
			<img alt="Crosig Logo" height="40" src="${images_folder}/icons/crosigWhite.svg" width="40" />
		</div>

		<ul aria-label="<@liferay.language key="site-pages" />" class="nav-link-list" role="menubar">
			<#list nav_items as nav_item>
				<#assign
					nav_item_attr_has_popup = ""
					nav_item_css_class = ""
					nav_item_layout = nav_item.getLayout()
				/>

				<#if nav_item.isSelected()>
					<#assign
						nav_item_attr_has_popup = "aria-haspopup='true'"
						nav_item_css_class = "selected"
					/>
				</#if>

				<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
					<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
						<img alt="Dashboard Icon" class="nav-icon" height="24" src="${images_folder}/icons/dashboard.svg" width="24" />
					</a>
				</li>
			</#list>
		</ul>

		<div class="user-controls">
			<img alt="Notifications" height="24" src="${images_folder}/icons/notification.svg" width="24" />

			<img alt="" class="user-image-round" height="40" src="${user.getPortraitURL(theme_display)}" width="40">
		</div>
	</div>

	<div class="navigation-expansion">
		<div class="crosig-logo">
			<img alt="CROATIA OSIGURANJE" height="40" src="${images_folder}/icons/crosigWhiteFull.svg" width="143" />
		</div>

		<ul aria-label="<@liferay.language key="site-pages" />" class="nav-link-list" role="menubar">
			<#list nav_items as nav_item>
				<#assign
					nav_item_attr_has_popup = ""
					nav_item_css_class = ""
					nav_item_layout = nav_item.getLayout()
				/>

		<#include "${full_templates_path}/header.ftl" />		<#if nav_item.isSelected()>
					<#assign
						nav_item_attr_has_popup = "aria-haspopup='true'"
						nav_item_css_class = "selected"
					/>
				</#if>

				<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
					<a class="nav-item-link" aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>
				</li>
			</#list>
		</ul>

		<div class="user-controls">
			<div></div>

			<p class="body-small">${user_name}</p>
		</div>
	</div>
</nav>

<!-- end of navigation.ftl -->


	<#include "${full_templates_path}/navigation.ftl" />

	<section id="content">
		<h2 class="hide-accessible" role="heading" aria-level="1">${the_title}</h2>

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
	<#include "footer.ftl" />
</div>



<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->

<!-- endinject -->

</body>

</html>