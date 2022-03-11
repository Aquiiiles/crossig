package hr.crosig.content.setup.upgrade;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import hr.crosig.content.setup.upgrade.common.DependencyProvider;
import hr.crosig.content.setup.upgrade.v1_0_0.AddAgentPortalDashboardPage;
import hr.crosig.content.setup.upgrade.v1_0_0.AddAgentPortalHomePage;
import hr.crosig.content.setup.upgrade.v1_0_0.AddAgentPortalSite;
import hr.crosig.content.setup.upgrade.v1_0_0.AddCoveragePlans;
import hr.crosig.content.setup.upgrade.v1_0_0.AddMotorRoles;
import hr.crosig.content.setup.upgrade.v1_0_0.AddProducts;
import hr.crosig.content.setup.upgrade.v1_0_0.AddProposalPage;
import hr.crosig.content.setup.upgrade.v1_0_0.AddVesselRoles;
import hr.crosig.content.setup.upgrade.v1_0_0.CreateAgentPortalUserGroups;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0", new AddAgentPortalSite(_dependencyProvider),
			new CreateAgentPortalUserGroups(_dependencyProvider),
			new AddAgentPortalDashboardPage(_dependencyProvider),
			new AddAgentPortalHomePage(_dependencyProvider),
			new AddProposalPage(_dependencyProvider),
			new AddVesselRoles(_dependencyProvider),
			new AddMotorRoles(_dependencyProvider),
			new AddProducts(_dependencyProvider),
			new AddCoveragePlans(_dependencyProvider));
	}

	@Reference
	private DependencyProvider _dependencyProvider;

}