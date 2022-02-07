package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.petra.string.StringPool;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;

/**
 * * Upgrade Process to add user groups
 *
 * @author david.martini
 */
public class CreateAgentPortalUserGroups extends BaseUpgradeProcess {

	public CreateAgentPortalUserGroups(DependencyProvider dependencyProvider) {
		super(dependencyProvider);
	}

	@Override
	protected void doUpgrade() throws Exception {
		addUserGroup(ContentSetupConstants.AGENT_USER_GROUP, StringPool.BLANK);
		addUserGroup(
			ContentSetupConstants.MANAGER_USER_GROUP, StringPool.BLANK);
		addUserGroup(
			ContentSetupConstants.SALES_MANAGER_USER_GROUP, StringPool.BLANK);
		addUserGroup(
			ContentSetupConstants.REGIONAL_MANAGER_USER_GROUP,
			StringPool.BLANK);
	}

}