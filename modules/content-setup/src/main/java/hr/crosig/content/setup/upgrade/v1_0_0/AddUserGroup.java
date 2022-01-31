package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;

import java.util.ArrayList;
import java.util.List;

/**
 ** Upgrade Process to add user groups
 * @author david.martini
 */
public class AddUserGroup extends BaseUpgradeProcess {

	public AddUserGroup(
		CompanyLocalService companyLocalService,
		GroupLocalService groupLocalService, UserLocalService userLocalService,
		UserGroupLocalService userGroupLocalService) {

		super(
			companyLocalService, groupLocalService, userLocalService,
			userGroupLocalService);
	}

	@Override
	protected void doUpgrade() throws Exception {
		List<String> groupNames = new ArrayList<>();

		groupNames.add(ContentSetupConstants.AGENT_USER_GROUP);
		groupNames.add(ContentSetupConstants.MANAGER_USER_GROUP);
		groupNames.add(ContentSetupConstants.SALES_MANAGER_USER_GROUP);
		groupNames.add(ContentSetupConstants.REGIONAL_MANAGER_USER_GROUP);

		String groupDescription = StringPool.BLANK;

		for (String groupName : groupNames) {
			addUserGroup(groupName, groupDescription);
		}
	}

}