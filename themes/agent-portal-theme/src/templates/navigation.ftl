<nav class="${nav_css_class} expansion-trigger" id="navigation" role="navigation">
	<div class="crosig-logo">
		<img src="${images_folder}/icons/crosigWhite.svg" alt="Crosig Logo" width="40" height="40"/>
	</div>
	<ul class="nav-link-list" id="link-list-left" aria-label="<@liferay.language key="site-pages" />" role="menubar">
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
					<img class="nav-icon" width="24" height="24" src="${images_folder}/icons/dashboard.svg" alt="Dashboard Icon"/>
				</a>
				<a class="nav-item-link" style="display: none;" aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>
			</li>
		</#list>
	</ul>
	<div class="user-controls">
		<img src="${images_folder}/icons/notification.svg" alt="Notifications" width="24" height="24"/>
		<img class="user-image-round" src="" alt="" width="40" height="40">
	</div>
	<div class="expanded-nav">
		<div class="crosig-logo">
			<img src="${images_folder}/icons/crosigWhiteFull.svg" alt="CROATIA OSIGURANGE" width="143" height="40"/>
		</div>
		<ul class="nav-link-list" id="link-list-right" aria-label="<@liferay.language key="site-pages" />" role="menubar"></ul>
		<div class="user-controls">
			<div></div>
			<p class="body-small">${user_name}</p>
		</div>
	</div>
</nav>