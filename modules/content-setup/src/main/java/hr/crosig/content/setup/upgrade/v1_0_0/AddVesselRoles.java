package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.model.role.RoleConstants;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;

/**
 * @author marcelo.mazurky
 */
public class AddVesselRoles extends BaseUpgradeProcess {

	public AddVesselRoles(DependencyProvider dependencyProvider) {
		super(dependencyProvider);
	}

	@Override
	protected void doUpgrade() throws Exception {
		addRole(
			ContentSetupConstants.VESSEL_ROLE_ALL, _VESSEL_ROLE_ALL_TITLE,
			_VESSEL_ROLE_ALL_DESCRIPTION, RoleConstants.TYPE_SITE);
		addRole(
			ContentSetupConstants.VESSEL_ROLE_SELL, _VESSEL_ROLE_SELL_TITLE,
			_VESSEL_ROLE_SELL_DESCRIPTION, RoleConstants.TYPE_SITE);
		addRole(
			ContentSetupConstants.VESSEL_ROLE_CREATE, _VESSEL_ROLE_CREATE_TITLE,
			_VESSEL_ROLE_CREATE_DESCRIPTION, RoleConstants.TYPE_SITE);
		addRole(
			ContentSetupConstants.VESSEL_ROLE_UPDATE, _VESSEL_ROLE_UPDATE_TITLE,
			_VESSEL_ROLE_UPDATE_DESCRIPTION, RoleConstants.TYPE_SITE);
	}

	private static final String _VESSEL_ROLE_ALL_DESCRIPTION =
		"User can perform all actions for Vessel";

	private static final String _VESSEL_ROLE_ALL_TITLE = "Vessel All";

	private static final String _VESSEL_ROLE_CREATE_DESCRIPTION =
		"User can perform the Create action for Vessel";

	private static final String _VESSEL_ROLE_CREATE_TITLE = "Vessel Create";

	private static final String _VESSEL_ROLE_SELL_DESCRIPTION =
		"User can perform the Sell action for Vessel";

	private static final String _VESSEL_ROLE_SELL_TITLE = "Vessel Sell";

	private static final String _VESSEL_ROLE_UPDATE_DESCRIPTION =
		"User can perform the Update action for Vessel";

	private static final String _VESSEL_ROLE_UPDATE_TITLE = "Vessel Update";

}