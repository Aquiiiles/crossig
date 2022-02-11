package hr.crosig.sample.data.generator.web.list;


import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import hr.crosig.sample.data.generator.web.constants.SampleDataGeneratorWebPanelCategoryKeys;
import hr.crosig.sample.data.generator.web.constants.SampleDataGeneratorWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author marcelo.mazurky
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + SampleDataGeneratorWebPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class SampleDataGeneratorWebPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SampleDataGeneratorWebPortletKeys.SAMPLE_DATA_GENERATOR_WEB_PORTLET;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + SampleDataGeneratorWebPortletKeys.SAMPLE_DATA_GENERATOR_WEB_PORTLET + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}