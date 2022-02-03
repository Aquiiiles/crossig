package hr.crosig.contact.internal.search.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.model.Street;

import org.osgi.service.component.annotations.Component;

/**
 * @author guilherme.kfouri
 */
@Component(
	immediate = true,
	property = "indexer.class.name=" + StreetConstants.MODEL_CLASS_NAME,
	service = ModelDocumentContributor.class
)
public class StreetModelDocumentContributor
	implements ModelDocumentContributor<Street> {

	@Override
	public void contribute(Document document, Street entry) {
		document.addNumber(
			StreetConstants.FIELD_STREET_ID, entry.getStreetId());
		document.addNumber(CityConstants.FIELD_CITY_ID, entry.getCityId());
		document.addKeyword(StreetConstants.FIELD_STREET_NAME, entry.getName());
	}

}