package hr.crosig.common.cache.management.application.list;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;

import hr.crosig.common.cache.management.constants.CacheManagementPanelCategoryKeys;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author marcelo.mazurky
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION,
		"panel.category.order:Integer=100"
	},
	service = PanelCategory.class
)
public class CacheManagementPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		return CacheManagementPanelCategoryKeys.CONTROL_PANEL_CATEGORY;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(
			locale, CacheManagementPanelCategoryKeys.CONTROL_PANEL_CATEGORY);
	}

}