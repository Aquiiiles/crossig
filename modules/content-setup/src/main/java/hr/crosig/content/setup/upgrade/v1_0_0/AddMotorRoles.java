package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.model.role.RoleConstants;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;

/**
 * @author Guilherme Kfouri
 */
public class AddMotorRoles extends BaseUpgradeProcess {

	public AddMotorRoles(DependencyProvider dependencyProvider) {
		super(dependencyProvider);
	}

	@Override
	protected void doUpgrade() {
		addRole(
			ContentSetupConstants.MOTOR_ROLE_ALL,
			ContentSetupConstants.MOTOR_ROLE_ALL_TITLE,
			ContentSetupConstants.MOTOR_ROLE_ALL_DESCRIPTION,
			RoleConstants.TYPE_SITE);
	}

}