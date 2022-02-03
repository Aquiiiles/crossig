package hr.crosig.content.setup.upgrade;

import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PrefsProps;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import hr.crosig.content.setup.upgrade.v1_0_0.AddAgentPortalDashboardPage;
import hr.crosig.content.setup.upgrade.v1_0_0.AddAgentPortalSite;
import hr.crosig.content.setup.upgrade.v1_0_0.CreateAgentPortalUserGroups;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0",
			new AddAgentPortalSite(
				_groupLocalService, _userLocalService, _prefsProps,
				_companyLocalService),
			new CreateAgentPortalUserGroups(
				_companyLocalService, _groupLocalService, _userLocalService,
				_userGroupLocalService),
			new AddAgentPortalDashboardPage(
				_groupLocalService, _userLocalService, _layoutLocalService,
				_roleLocalService));
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private PrefsProps _prefsProps;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserGroupLocalService _userGroupLocalService;

	@Reference
	private UserLocalService _userLocalService;

}