package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;

public class AddAgentPortalSite extends BaseUpgradeProcess {

    public AddAgentPortalSite(
            GroupLocalService groupLocalService, Portal portal, UserLocalService userLocalService,
            RoleLocalService roleLocalService) {
        super(groupLocalService, portal, userLocalService, roleLocalService);
    }

    @Override
    protected void doUpgrade() throws Exception {
        addSite(ContentSetupConstants.AGENT_PORTAL_SITE_NAME, ContentSetupConstants.AGENT_PORTAL_SITE_DESCRIPTION,
                ContentSetupConstants.AGENT_PORTAL_FRIENDLY_URL, GroupConstants.TYPE_SITE_OPEN);
    }
}
