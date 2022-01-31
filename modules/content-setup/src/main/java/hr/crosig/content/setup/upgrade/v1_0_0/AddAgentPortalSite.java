package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PrefsProps;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;

import javax.portlet.PortletPreferences;

/**
 * @author Guilherme Kfouri
 * Upgrade Process to add the Agent Portal Site
 */
public class AddAgentPortalSite extends BaseUpgradeProcess {

    public AddAgentPortalSite(
            GroupLocalService groupLocalService, UserLocalService userLocalService,
            PrefsProps prefsProps, CompanyLocalService companyLocalService) {

        super(groupLocalService, companyLocalService, userLocalService);

        this.prefsProps = prefsProps;
        this.companyLocalService = companyLocalService;
    }

    @Override
    protected void doUpgrade() throws Exception {
        Group agentPortalGroup = addSite(
                ContentSetupConstants.AGENT_PORTAL_SITE_NAME,
                ContentSetupConstants.AGENT_PORTAL_SITE_DESCRIPTION,
                ContentSetupConstants.AGENT_PORTAL_FRIENDLY_URL,
                GroupConstants.TYPE_SITE_OPEN);

        long companyId = agentPortalGroup.getCompanyId();

        setDefaultLandingPagePath(companyId);
        setHomeURL(companyId);
    }

    protected void setDefaultLandingPagePath(long companyId) throws Exception {
        PortletPreferences portletPreferences = prefsProps.getPreferences(
                companyId);

        portletPreferences.setValue(
                "default.landing.page.path",
                ContentSetupConstants.LANDING_PAGE_URL);
        portletPreferences.store();
    }

    protected void setHomeURL(long companyId) throws Exception {
        Company company = companyLocalService.getCompany(companyId);

        company.setHomeURL(ContentSetupConstants.HOME_URL);

        companyLocalService.updateCompany(company);
    }

    protected CompanyLocalService companyLocalService;
    protected PrefsProps prefsProps;

}