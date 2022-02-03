package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;

/**
 * * Upgrade Process to add user groups
 *
 * @author david.martini
 */
public class CreateAgentPortalUserGroups extends BaseUpgradeProcess {

	public CreateAgentPortalUserGroups(
		CompanyLocalService companyLocalService,
		GroupLocalService groupLocalService, UserLocalService userLocalService,
		UserGroupLocalService userGroupLocalService) {

		super(
			companyLocalService, groupLocalService, userLocalService,
			userGroupLocalService);
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