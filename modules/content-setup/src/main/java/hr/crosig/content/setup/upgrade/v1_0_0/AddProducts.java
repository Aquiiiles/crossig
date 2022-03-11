package hr.crosig.content.setup.upgrade.v1_0_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.util.PortalUtil;

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
	protected void doUpgrade() {
		Product boat = addProduct(
			ContentSetupConstants.PRODUCT_BOATS_NAME, 0L, true,
			ContentSetupConstants.PRODUCT_BOATS_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product bigBoats = addProduct(
			ContentSetupConstants.PRODUCT_BIG_BOATS_NAME, 0L, false,
			ContentSetupConstants.PRODUCT_BIG_BOATS_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product boatInstitute = addProduct(
			ContentSetupConstants.PRODUCT_BOAT_INSTITUTE_CLAUSE_NAME, 0L, false,
			ContentSetupConstants.PRODUCT_BOAT_INSTITUTE_CLAUSE_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product skipper = addProduct(
			ContentSetupConstants.PRODUCT_SKIPPER_RENT_BOAT_NAME, 0L, false,
			ContentSetupConstants.PRODUCT_SKIPPER_RENT_BOAT_DESCRIPTION,
			ProductCategory.VESSEL.getTitle());

		Product mtpl = addProduct(
			ContentSetupConstants.PRODUCT_MTPL_NAME, 0L, false,
			ContentSetupConstants.PRODUCT_MTPL_DESCRIPTION,
			ProductCategory.MOTOR.getTitle());

		Product casco = addProduct(
			ContentSetupConstants.PRODUCT_CASCO_NAME, 0L, false,
			ContentSetupConstants.PRODUCT_CASCO_DESCRIPTION,
			ProductCategory.MOTOR.getTitle());

		try {
			_addRelationshipToVesselAllAndSell(boat.getProductId());
			_addRelationshipToVesselAllAndSell(bigBoats.getProductId());
			_addRelationshipToVesselAllAndSell(boatInstitute.getProductId());
			_addRelationshipToVesselAllAndSell(skipper.getProductId());
			_addRelationshipToMotorAll(mtpl.getProductId());
			_addRelationshipToMotorAll(casco.getProductId());
		}
		catch (PortalException portalException) {
			log.error(
				"Failed to create relationships to Vessel All and Vessel Sell",
				portalException);
		}
	}

	private void _addRelationshipToMotorAll(long productId)
		throws PortalException {

		Role motorAll = roleLocalService.getRole(
			PortalUtil.getDefaultCompanyId(),
			ContentSetupConstants.MOTOR_ROLE_ALL);

		addProductRole(productId, motorAll.getRoleId());
	}

	private void _addRelationshipToVesselAllAndSell(long productId)
		throws PortalException {

		Role vesselAll = roleLocalService.getRole(
			PortalUtil.getDefaultCompanyId(),
			ContentSetupConstants.VESSEL_ROLE_ALL);

		Role vesselSell = roleLocalService.getRole(
			PortalUtil.getDefaultCompanyId(),
			ContentSetupConstants.VESSEL_ROLE_SELL);

		addProductRole(productId, vesselAll.getRoleId());
		addProductRole(productId, vesselSell.getRoleId());
	}

}