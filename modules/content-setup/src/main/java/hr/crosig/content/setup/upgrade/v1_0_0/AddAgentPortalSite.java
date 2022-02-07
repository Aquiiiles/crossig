package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;

import javax.portlet.PortletPreferences;

/**
 * @author Guilherme Kfouri
 * Upgrade Process to add the Agent Portal Site
 */
public class AddAgentPortalSite extends BaseUpgradeProcess {

	public AddAgentPortalSite(DependencyProvider dependencyProvider) {
		super(dependencyProvider);
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

}