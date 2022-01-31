package hr.crosig.common.cache.management.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import hr.crosig.common.cache.management.constants.CacheManagementPanelCategoryKeys;
import hr.crosig.common.cache.management.constants.CacheManagementPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author marcelo.mazurky
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + CacheManagementPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class CacheManagementPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return CacheManagementPortletKeys.CACHE_MANAGEMENT_PORTLET;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + CacheManagementPortletKeys.CACHE_MANAGEMENT_PORTLET + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}