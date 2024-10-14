package hr.crosig.contact.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchConfigurator;

import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.model.City;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guilherme.kfouri
 */
@Component(immediate = true, service = ModelSearchConfigurator.class)
public class CitySearchConfigurator implements ModelSearchConfigurator<City> {

	@Override
	public String getClassName() {
		return CityConstants.MODEL_CLASS_NAME;
	}

	@Override
	public String[] getDefaultSelectedFieldNames() {
		return new String[] {
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
			CityConstants.FIELD_CITY_NAME, Field.ENTRY_CLASS_PK,
			CityConstants.FIELD_CITY_BOX_NUMBER,
			CityConstants.FIELD_CITY_POST_NAME
		};
	}

	@Override
	public ModelIndexerWriterContributor<City> getModelIndexerWriterContributor() {
		return modelIndexWriterContributor;
	}

	@Reference(
		target = "(indexer.class.name=" + CityConstants.MODEL_CLASS_NAME + ")"
	)
	protected ModelIndexerWriterContributor<City> modelIndexWriterContributor;
}
