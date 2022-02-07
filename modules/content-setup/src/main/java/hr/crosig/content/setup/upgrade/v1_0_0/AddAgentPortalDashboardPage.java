package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;

/**
 * @author victor.catanante
 */
public class AddAgentPortalDashboardPage extends BaseUpgradeProcess {

	public AddAgentPortalDashboardPage(DependencyProvider dependencyProvider) {

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
				ContentSetupConstants.DASHBOARD_FRIENDLY_URL,
				new ServiceContext());

			setPageLayoutTemplateId(
				layout, userId, ContentSetupConstants.LAYOUT_1_COLUMN);

			updatePage(layout);

			addPortletToPage(
				layout, userId, ContentSetupConstants.CONTACT_PORTLET_NAME,
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

	protected static final String DESCRIPTION = "Dashboard";

	protected static final Boolean HIDDEN = Boolean.FALSE;

	protected static final String PAGE_NAME = "Dashboard";

	protected static final Long PARENT_LAYOUT_ID = 0L;

	protected static final Integer PORTLET_COLUMN_POS = -1;

	protected static final Boolean PRIVATE_PAGE = Boolean.TRUE;

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