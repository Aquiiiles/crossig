package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.login.web.constants.LoginPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;

/**
 * @author marcelo.mazurky
 */
public class AddAgentPortalHomePage extends BaseUpgradeProcess {

	public AddAgentPortalHomePage(DependencyProvider dependencyProvider) {
		super(dependencyProvider);
	}

	@Override
	protected void doUpgrade() throws Exception {
		try {
			setupAdminUpgrade();

			initializeCommonIdentifiers();

			Layout layout = addPage(
				userId, groupId, PRIVATE_PAGE, PARENT_LAYOUT_ID, PAGE_NAME,
				PAGE_NAME, DESCRIPTION, LayoutConstants.TYPE_PORTLET, HIDDEN,
				ContentSetupConstants.HOME_FRIENDLY_URL, new ServiceContext());

			setPageLayoutTemplateId(
				layout, userId, ContentSetupConstants.LAYOUT_1_COLUMN);

			updatePage(layout);

			addPortletToPage(
				layout, userId, LoginPortletKeys.LOGIN,
				ContentSetupConstants.COLUMN_1, PORTLET_COLUMN_POS);

			updatePage(layout);
		}
		finally {
			teardownAdminUpgrade();
		}
	}

	protected void initializeCommonIdentifiers() throws PortalException {
		Long companyId = PortalUtil.getDefaultCompanyId();

		Long groupId = _getDefaultGroupId(companyId);
		Long userId = _getAdminUserId(companyId);

		this.companyId = companyId;

		this.groupId = groupId;
		this.userId = userId;
	}

	protected static final String DESCRIPTION = "Home";

	protected static final Boolean HIDDEN = Boolean.FALSE;

	protected static final String PAGE_NAME = "Home";

	protected static final Long PARENT_LAYOUT_ID = 0L;

	protected static final Integer PORTLET_COLUMN_POS = -1;

	protected static final Boolean PRIVATE_PAGE = Boolean.FALSE;

	protected static final String THEME_ID =
		"agentportaltheme_WAR_agentportaltheme";

	protected Long companyId;
	protected Long groupId;
	protected Long userId;

	private Long _getAdminUserId(Long companyId) throws PortalException {
		return userLocalService.getUser(
			userLocalService.getDefaultUserId(companyId)
		).getUserId();
	}

	private Long _getDefaultGroupId(Long companyId) {
		return groupLocalService.fetchFriendlyURLGroup(
			companyId, ContentSetupConstants.AGENT_PORTAL_FRIENDLY_URL
		).getGroupId();
	}

}