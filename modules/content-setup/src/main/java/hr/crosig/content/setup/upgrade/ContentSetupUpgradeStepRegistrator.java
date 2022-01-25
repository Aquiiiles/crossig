package hr.crosig.content.setup.upgrade;

import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.v1_0_0.AddAgentPortalSite;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {
        registry.register(ContentSetupConstants.SCHEMA_VERSION_0_0_0, ContentSetupConstants.SCHEMA_VERSION_1_0_0,
                new AddAgentPortalSite(_groupLocalService, _portal, _userLocalService, _roleLocalService));
    }

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private  Portal _portal;

    @Reference
    private  UserLocalService _userLocalService;

    @Reference
    private  RoleLocalService _roleLocalService;
}
