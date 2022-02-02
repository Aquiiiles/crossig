package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;
import hr.crosig.content.setup.constants.ContentSetupConstants;

/**
 * @author victor.catanante
 */
public class AddAgentPortalDashboardPage extends UpgradeProcess {

    public AddAgentPortalDashboardPage(GroupLocalService groupLocalService) {
        this._groupLocalService = groupLocalService;
    }

    @Override
    protected void doUpgrade() throws Exception {
        Long companyId = PortalUtil.getDefaultCompanyId();
        Long userId = UserLocalServiceUtil.getDefaultUserId(companyId);
        Group group = _groupLocalService.fetchFriendlyURLGroup(companyId, ContentSetupConstants.AGENT_PORTAL_FRIENDLY_URL);
        Long groupId = group.getGroupId();

        long parentLayoutId = 0;
        String pageName = "Dashboard";
        Boolean privatePage = Boolean.TRUE;


        Layout layout =  LayoutLocalServiceUtil.addLayout(
                userId,
                groupId,
                privatePage,
                0,
                pageName,
                pageName,
                "My sample page",
                LayoutConstants.TYPE_PORTLET,
                false,
                ContentSetupConstants.DASHBOARD_FRIENDLY_URL,
                new ServiceContext());


        LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet)layout.getLayoutType();

        layoutTypePortlet.setLayoutTemplateId(userId, "1_column");

        LayoutLocalServiceUtil.updateLayout(
                layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(), layout.getTypeSettings());

    }

    private GroupLocalService _groupLocalService;
}