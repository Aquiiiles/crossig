package hr.crosig.content.setup.upgrade.v1_0_0;

import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;

import java.util.UUID;

/**
 * @author victor.catanante
 */
public class AddCoveragePlans extends BaseUpgradeProcess {

    public AddCoveragePlans(DependencyProvider dependencyProvider) {
        super(dependencyProvider);
    }

    @Override
    protected void doUpgrade() throws Exception {
        dependencyProvider.coveragePlanLocalService.addCoveragePlan(_COMPULSORY_LIABILITY_ONLY, _CATEGORY, _DESCRIPTION);
        dependencyProvider.coveragePlanLocalService.addCoveragePlan(_CASCO_ONLY, _CATEGORY, _DESCRIPTION);
        dependencyProvider.coveragePlanLocalService.addCoveragePlan(_COMPULSORY_LIABILITY_AND_CASCO_BUNDLE, _CATEGORY, _DESCRIPTION);
    }

    private static final String _COMPULSORY_LIABILITY_ONLY = "Compulsory Liability Only";
    private static final String _CASCO_ONLY = "CASCO Only";
    private static final String _COMPULSORY_LIABILITY_AND_CASCO_BUNDLE = "Compulsory Liability and CASCO Bundle";
    private static final String _CATEGORY = "VESSEL";
    private static final String _DESCRIPTION = UUID.randomUUID().toString();
}
