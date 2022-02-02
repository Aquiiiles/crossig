package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.AdminUpgradeProcess;


/**
 * @author victor.catanante
 */
public class AddAgentPortalDashboardPage extends AdminUpgradeProcess {

	public AddAgentPortalDashboardPage(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

    @Override
    protected void doUpgradeAsAdmin() throws Exception {
        initializeCommonIdentifiers();
        Layout layout = createDashboardPage();
        setLandingPageLayoutTemplateId(layout);
        updateDashBoardPage(layout);
        addContactSearchPortlet(layout);
        updateDashBoardPage(layout);
	}

    protected void initializeCommonIdentifiers() throws PortalException {
        Long companyId = PortalUtil.getDefaultCompanyId();
        Long groupId = _getDefaultGroupId(companyId);
        Long userId = _getAdminUserId(companyId);

        this.companyId = companyId;
        this.groupId = groupId;
        this.userId = userId;
    }

    protected Layout createDashboardPage() throws PortalException {
        Layout layout = LayoutLocalServiceUtil.addLayout(
			userId,
            groupId,
            _isPagePrivate,
            _parentLayoutId,
            _pageName,
            _pageName,
			_description,
            LayoutConstants.TYPE_PORTLET,
            _isHidden,
			ContentSetupConstants.DASHBOARD_FRIENDLY_URL,
            new ServiceContext());

        return layout;
    }

    protected void updateDashBoardPage(Layout layout) throws PortalException {
        LayoutLocalServiceUtil.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(),
			layout.getLayoutId(), layout.getTypeSettings());
    }

    protected void setLandingPageLayoutTemplateId(Layout layout) {
        LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
		layoutTypePortlet.setLayoutTemplateId(userId, ContentSetupConstants.LAYOUT_1_COLUMN);
    }

    protected void addContactSearchPortlet(Layout layout) {
        LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
        
        try {
            layoutTypePortlet.addPortletId(userId, ContentSetupConstants.CONTACT_PORTLET_NAME, ContentSetupConstants.COLUMN_1, -1);
        } catch (Exception e) {
			_log.error(e);
        }
    }

    private Long _getDefaultGroupId(Long companyId) {
        return _groupLocalService.fetchFriendlyURLGroup(companyId, ContentSetupConstants.AGENT_PORTAL_FRIENDLY_URL).getGroupId();
    }

    private Long _getAdminUserId(Long companyId) throws PortalException {
        return UserLocalServiceUtil.getUser(UserLocalServiceUtil.getDefaultUserId(companyId)).getUserId();
	}

    private GroupLocalService _groupLocalService;
    protected Long userId;
    protected Long companyId;
    protected Long groupId;

	private static final Log _log = LogFactoryUtil.getLog(AddAgentPortalDashboardPage.class);

	private final String _description = "Dashboard";
	private final Boolean _isHidden = Boolean.FALSE;
	private final String _pageName = "Dashboard";
	private final Long _parentLayoutId = 0L;
	private final Boolean _isPagePrivate = Boolean.TRUE;
}