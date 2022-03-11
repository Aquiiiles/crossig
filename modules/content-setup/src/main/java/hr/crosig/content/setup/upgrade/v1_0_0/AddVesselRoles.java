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
	protected void doUpgrade() {
		addRole(
			ContentSetupConstants.VESSEL_ROLE_ALL,
			ContentSetupConstants.VESSEL_ROLE_ALL_TITLE,
			ContentSetupConstants.VESSEL_ROLE_ALL_DESCRIPTION,
			RoleConstants.TYPE_SITE);
		addRole(
			ContentSetupConstants.VESSEL_ROLE_SELL,
			ContentSetupConstants.VESSEL_ROLE_SELL_TITLE,
			ContentSetupConstants.VESSEL_ROLE_SELL_DESCRIPTION,
			RoleConstants.TYPE_SITE);
		addRole(
			ContentSetupConstants.VESSEL_ROLE_CREATE,
			ContentSetupConstants.VESSEL_ROLE_CREATE_TITLE,
			ContentSetupConstants.VESSEL_ROLE_CREATE_DESCRIPTION,
			RoleConstants.TYPE_SITE);
		addRole(
			ContentSetupConstants.VESSEL_ROLE_UPDATE,
			ContentSetupConstants.VESSEL_ROLE_UPDATE_TITLE,
			ContentSetupConstants.VESSEL_ROLE_UPDATE_DESCRIPTION,
			RoleConstants.TYPE_SITE);
	}

}