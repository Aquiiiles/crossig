package hr.crosig.contact.internal.search.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.model.City;

import org.osgi.service.component.annotations.Component;

/**
 * @author guilherme.kfouri
 */
@Component(
	immediate = true,
	property = "indexer.class.name=" + CityConstants.MODEL_CLASS_NAME,
	service = ModelDocumentContributor.class
)
public class CityModelDocumentContributor
	implements ModelDocumentContributor<City> {

	@Override
	public void contribute(Document document, City entry) {
		document.addNumber(CityConstants.FIELD_CITY_ID, entry.getCityId());
		document.addKeyword(CityConstants.FIELD_CITY_NAME, entry.getName());
		document.addText(
			CityConstants.FIELD_CITY_POST_NAME, entry.getPostName());
		document.addText(
			CityConstants.FIELD_CITY_BOX_NUMBER, entry.getBoxNumber());
	}

}