package hr.crosig.content.setup.upgrade;

import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.PrefsProps;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import hr.crosig.content.setup.upgrade.v1_0_0.AddAgentPortalSite;
import hr.crosig.content.setup.upgrade.v1_0_0.AddUserGroup;

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
				_groupLocalService, _userLocalService, _roleLocalService,
				_prefsProps, _companyLocalService));

		registry.register(
			"0.0.0", "1.0.0",
			new AddUserGroup(
				_companyLocalService, _groupLocalService, _userLocalService,
				_userGroupLocalService));
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private PrefsProps _prefsProps;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserGroupLocalService _userGroupLocalService;

	@Reference
	private UserLocalService _userLocalService;

}