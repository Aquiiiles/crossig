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

			<img alt="" class="user-image-round" height="40" src="${user.getPortraitURL(theme_display)}" width="40" />
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

        <#if nav_item.isSelected()>
        <#assign
						nav_item_attr_has_popup = "aria-haspopup='true'"
						nav_item_css_class = "selected"
					/>
				</#if>

				<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
					<a class="nav-item-link" aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
            <span>
              <@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}
            </span>
          </a>
				</li>
			</#list>
		</ul>

		<div class="user-controls">
			<div></div>

			<p class="body-small">${user_name}</p>
		</div> 
	</div>
</nav>
