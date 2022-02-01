package hr.crosig.contact.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.model.Street;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guilherme.kfouri
 */
@Component(immediate = true)
public class StreetSearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
			Street.class, bundleContext,
			modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
					StreetConstants.FIELD_STREET_NAME, Field.ENTRY_CLASS_PK, CityConstants.FIELD_CITY_ID);

				modelSearchDefinition.setModelIndexWriteContributor(
					modelIndexWriterContributor);
			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(
		target = "(indexer.class.name=" + StreetConstants.MODEL_CLASS_NAME + ")"
	)
	protected ModelIndexerWriterContributor<Street> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	private ServiceRegistration<?> _serviceRegistration;

}