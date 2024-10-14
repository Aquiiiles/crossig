package hr.crosig.contact.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchConfigurator;

import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.model.Street;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Implementação de ModelSearchConfigurator para o modelo Street.
 */
@Component(immediate = true, service = ModelSearchConfigurator.class)
public class StreetSearchConfigurator implements ModelSearchConfigurator<Street> {

	@Override
	public String getClassName() {
		return StreetConstants.MODEL_CLASS_NAME;
	}

	@Override
	public String[] getDefaultSelectedFieldNames() {
		return new String[] {
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
			StreetConstants.FIELD_STREET_NAME, Field.ENTRY_CLASS_PK,
			CityConstants.FIELD_CITY_ID
		};
	}

	@Override
	public ModelIndexerWriterContributor<Street> getModelIndexerWriterContributor() {
		return modelIndexWriterContributor;
	}

	@Reference(
		target = "(indexer.class.name=" + StreetConstants.MODEL_CLASS_NAME + ")"
	)
	protected ModelIndexerWriterContributor<Street> modelIndexWriterContributor;
}
