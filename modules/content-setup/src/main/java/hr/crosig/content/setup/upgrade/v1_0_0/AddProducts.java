package hr.crosig.content.setup.upgrade.v1_0_0;

import hr.crosig.content.setup.constants.ContentSetupConstants;
import hr.crosig.content.setup.upgrade.common.BaseUpgradeProcess;
import hr.crosig.content.setup.upgrade.common.DependencyProvider;
import hr.crosig.proposal.enums.ProductCategory;
import hr.crosig.proposal.model.Product;

/**
 * @author Guilherme Kfouri
 * Upgrade Process to add Boats,
 * Big Boats, Boat Institute Clause,
 * Skipper and Rent-a-Boat
 */
public class AddProducts extends BaseUpgradeProcess {

	public AddProducts(DependencyProvider dependencyProvider) {
		super(dependencyProvider);
	}

	@Override
	protected void doUpgrade() throws Exception {
		Product boat = addProduct(
			ContentSetupConstants.PRODUCT_BOATS_NAME, 1L, true,
			ContentSetupConstants.PRODUCT_BOATS_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product bigBoats = addProduct(
			ContentSetupConstants.PRODUCT_BIG_BOATS_NAME, 1L, true,
			ContentSetupConstants.PRODUCT_BIG_BOATS_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product boatInstitute = addProduct(
			ContentSetupConstants.PRODUCT_BOAT_INSTITUTE_CLAUSE_NAME, 1L, true,
			ContentSetupConstants.PRODUCT_BOAT_INSTITUTE_CLAUSE_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product skipper = addProduct(
			ContentSetupConstants.PRODUCT_SKIPPER_NAME, 1L, true,
			ContentSetupConstants.PRODUCT_SKIPPER_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product rentABoat = addProduct(
			ContentSetupConstants.PRODUCT_RENT_A_BOAT_NAME, 1L, true,
			ContentSetupConstants.PRODUCT_RENT_A_BOAT_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());
	}

}